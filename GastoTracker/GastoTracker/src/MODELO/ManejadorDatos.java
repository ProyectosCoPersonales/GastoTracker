
package MODELO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDatos extends BasedeDatos {
    
    private Connection conexion;
    private Statement consulta;
    private ResultSet resultados;
    
    public ManejadorDatos(){
        super();
        this.conexion = super.getConexion();
    }
    
    
    public void ejecutarConsulta(String sql) throws SQLException {
        iniciar();
        this.conexion = super.getConexion();
        consulta = conexion.createStatement();
        consulta.execute(sql);
        terminar();
    }
    public ResultSet ejecutarConsulta1(String sql) throws SQLException {
    iniciar();
    this.conexion = super.getConexion();
    consulta = conexion.createStatement();
    ResultSet resultado = consulta.executeQuery(sql);
    terminar();
    return resultado;
}

    
    public ResultSet obtenerDatos(String sql) throws SQLException {
        iniciar();
        this.consulta = conexion.createStatement();
        this.resultados = consulta.executeQuery(sql);
        return this.resultados;
    }
    
    public List<Object> resultado(String sql) throws SQLException {
        List<Object> retorno = new ArrayList<>();
        iniciar();
        this.consulta = this.conexion.createStatement();
        this.resultados = this.consulta.executeQuery(sql);
        if (this.resultados.next()){
            for (int i = 1; i <= this.resultados.getMetaData().getColumnCount(); i++){
                retorno.add(this.resultados.getObject(i));
            }
        }
        terminar();
        return retorno;
    }
    
    @Override
    public void cerrar() throws SQLException{
        if (!this.conexion.isClosed())
            this.conexion.close();
    }
    
    public void iniciar() throws SQLException{
        super.conectar();
        this.conexion = super.getConexion();
    }
    
    public void terminar() throws SQLException {
        super.cerrar();
        this.conexion.close();
        this.conexion = null;
    }
    
}
