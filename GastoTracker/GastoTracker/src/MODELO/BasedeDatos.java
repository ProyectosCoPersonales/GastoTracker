
package MODELO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasedeDatos {
    private final String url;
    private final String driver;
    private Connection conexion;
    
    public BasedeDatos(){
        this.driver = "jdbc:sqlite";
        this.url = "GastoTracker.db";
    }
    
    protected void conectar() throws SQLException{
        this.conexion = DriverManager.getConnection(this.driver+":"+this.url);
        if (!this.conexion.isClosed())
            System.out.println("Conectado");
    }
    
    protected void cerrar() throws SQLException {
        if (!this.conexion.isClosed())
            this.conexion.close();
    }

    protected Connection getConexion() {
        return conexion;
    }
}    

