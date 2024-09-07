package CONTROLADOR;

import MODELO.ManejadorDatos;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Funciones {
public DefaultTableModel ObtenerDatosOrdenadosPorCategoria() throws SQLException {
    ManejadorDatos manejador = new ManejadorDatos();

  
    manejador.iniciar();

   
    String sql = "SELECT * FROM Transacciones ORDER BY Categoria";

  
    ResultSet resultado = manejador.obtenerDatos(sql);

  
    DefaultTableModel modeloTabla = new DefaultTableModel();

 
    modeloTabla.addColumn("Categoría");
    modeloTabla.addColumn("Producto");
    modeloTabla.addColumn("Cantidad");
    modeloTabla.addColumn("PrecioUnitario");
    modeloTabla.addColumn("Total");
    modeloTabla.addColumn("Tipo_Pago");
    modeloTabla.addColumn("Mes");
    modeloTabla.addColumn("Año");

  
    while (resultado.next()) {
        Object[] fila = {
            resultado.getString("Categoria"),
            resultado.getString("Producto"),
            resultado.getString("Cantidad"),
            resultado.getString("PrecioUnitario"),
            resultado.getString("Total"),
            resultado.getString("Tipo_Pago"),
            resultado.getString("Mes"),
            resultado.getString("Año")
        };
        modeloTabla.addRow(fila);
    }

    // Cierra la conexión después de obtener los resultados
    manejador.terminar();

    return modeloTabla;
}

public DefaultTableModel FiltrarDatosCategoriaMes(String buscarCategoria, String buscarMes) throws SQLException {
    ManejadorDatos manejador = new ManejadorDatos();
    manejador.iniciar();
    String sql = String.format("SELECT * FROM Transacciones WHERE Categoria = '%s' AND Mes = '%s'", buscarCategoria, buscarMes);
    ResultSet resultado = manejador.obtenerDatos(sql);
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("Categoría");
    modeloTabla.addColumn("Producto");
    modeloTabla.addColumn("Cantidad");
    modeloTabla.addColumn("PrecioUnitario");
    modeloTabla.addColumn("Total");
    modeloTabla.addColumn("Tipo_Pago");
    modeloTabla.addColumn("Mes");
    modeloTabla.addColumn("Año");
    while (resultado.next()) {
        Object[] fila = {
            resultado.getString("Categoria"),
            resultado.getString("Producto"),
            resultado.getString("Cantidad"),
            resultado.getString("PrecioUnitario"),
            resultado.getString("Total"),
            resultado.getString("Tipo_Pago"),
            resultado.getString("Mes"),
            resultado.getString("Año")
        };
        modeloTabla.addRow(fila);
    }
    manejador.terminar();

    return modeloTabla;
}

public DefaultTableModel FiltrarDatosPorMes(String buscarMes) throws SQLException {
    ManejadorDatos manejador = new ManejadorDatos();

    // Abre la conexión antes de realizar la consulta
    manejador.iniciar();

    // Construye la consulta SQL con la condición del mes
    String sql = String.format("SELECT * FROM Transacciones WHERE Mes = '%s'", buscarMes);

    // Obtiene los resultados correctamente
    ResultSet resultado = manejador.obtenerDatos(sql);

    // Crea un modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();

    // Agrega columnas al modelo (ajusta estas según tus columnas)
    modeloTabla.addColumn("Categoría");
    modeloTabla.addColumn("Producto");
    modeloTabla.addColumn("Cantidad");
    modeloTabla.addColumn("PrecioUnitario");
    modeloTabla.addColumn("Total");
    modeloTabla.addColumn("Tipo_Pago");
    modeloTabla.addColumn("Mes");
    modeloTabla.addColumn("Año");

    // Agrega filas al modelo utilizando los datos de la consulta
    while (resultado.next()) {
        Object[] fila = {
            resultado.getString("Categoria"),
            resultado.getString("Producto"),
            resultado.getString("Cantidad"),
            resultado.getString("PrecioUnitario"),
            resultado.getString("Total"),
            resultado.getString("Tipo_Pago"),
            resultado.getString("Mes"),
            resultado.getString("Año")
        };
        modeloTabla.addRow(fila);
    }

    // Cierra la conexión después de obtener los resultados
    manejador.terminar();

    return modeloTabla;
}

public DefaultTableModel FiltrarDatosCategoria(String buscarCategoria) throws SQLException {
    ManejadorDatos manejador = new ManejadorDatos();

    // Abre la conexión antes de realizar la consulta
    manejador.iniciar();

    String sql = String.format("SELECT * FROM Transacciones WHERE Categoria = '%s'", buscarCategoria);

    // Obtiene los resultados correctamente
    ResultSet resultado = manejador.obtenerDatos(sql);

    // Crea un modelo de tabla
    DefaultTableModel modeloTabla = new DefaultTableModel();

    // Agrega columnas al modelo (ajusta estas según tus columnas)
    modeloTabla.addColumn("Categoría");
    modeloTabla.addColumn("Producto");
    modeloTabla.addColumn("Cantidad");
    modeloTabla.addColumn("PrecioUnitario");
    modeloTabla.addColumn("Total");
    modeloTabla.addColumn("Tipo_Pago");
    modeloTabla.addColumn("Mes");
    modeloTabla.addColumn("Año");

    // Agrega filas al modelo utilizando los datos de la consulta
    while (resultado.next()) {
        Object[] fila = {
            resultado.getString("Categoria"),
            resultado.getString("Producto"),
            resultado.getString("Cantidad"),
            resultado.getString("PrecioUnitario"),
            resultado.getString("Total"),
            resultado.getString("Tipo_Pago"),
            resultado.getString("Mes"),
            resultado.getString("Año")
        };
        modeloTabla.addRow(fila);
    }

    // Cierra la conexión después de obtener los resultados
    manejador.terminar();

    return modeloTabla;
}


    public void AgregarDatos(String... datos) throws SQLException{
        ManejadorDatos manejador = new ManejadorDatos();
        String sql = String.format("INSERT INTO Transacciones("
                + "Categoria, Producto, Cantidad, PrecioUnitario, Total, Tipo_Pago, Mes, Año"
                + ") VALUES('%s', '%s', %s, %s, %s, '%s', '%s','%s')", datos);
        manejador.ejecutarConsulta(sql);
    }
    public DefaultTableModel cargarDatos() throws SQLException {
        String [] columnas = {
            "Categoría", 
            "Producto",
            "Cantidad",
            "PrecioUnitario",
            "Total",
            "Tipo_Pago",
            "Mes",
            "Año"
        };
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        ManejadorDatos manejador = new ManejadorDatos();
        ResultSet datos = manejador.obtenerDatos("SELECT * FROM Transacciones");
        String[] registro = new String[8];
        while(datos.next()){
            registro[0] = datos.getString("Categoria");
            registro[1] = datos.getString("Producto");
            registro[2] = String.valueOf(datos.getInt("Cantidad"));
            registro[3] = String.valueOf(datos.getDouble("PrecioUnitario"));
            registro[4] = String.valueOf(datos.getDouble("Total"));
            registro[5] = datos.getString("Tipo_Pago");
            registro[6] = datos.getString("Mes");
            registro[7] = datos.getString("Año");
            modelo.addRow(registro);
        }
        manejador.cerrar();
        return modelo;
    }


}
