package demo.conart.other;

import demo.conart.exception.DBConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    /*
    * la connessione al db dovrebbe avvenire tramite alcuni accorgimenti come non creare troppe connessioni
    * aperte contemporaneamente, quindi usando il pattern singleton
    * */

    private static DatabaseConnection instance = null;
    private static Connection conn = null;

    private DatabaseConnection() {

    }

    //singleton sulla connessione

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() throws DBConnectionException {
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (conn == null || conn.isClosed()) {
                if(input == null){
                    throw new DBConnectionException("configurazione non trovata");
                }
                else{
                    Properties properties = new Properties();
                    properties.load(input);



                    String url = properties.getProperty("db.url");
                    String user = properties.getProperty("db.user");
                    String password = properties.getProperty("db.password");

                    conn = DriverManager.getConnection(url, user, password);
                }
            }
        }
        catch (IOException | SQLException e) {
            throw new DBConnectionException("Errore di connessione al database: " + e.getMessage());
        }
        return conn;
    }


    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }














}
