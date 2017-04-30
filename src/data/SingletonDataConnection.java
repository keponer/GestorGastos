/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alex
 */
public class SingletonDataConnection {
    
    public Connection con; // atribut per a guardar l’objecte connexió.
    private static SingletonDataConnection INSTANCE = null;
    
    
    //Método constructor que ejecuta el método para conectar con la base de datos
    private SingletonDataConnection() {
        this.performConnection();
    }
    
    //Crea una instancia de la base de datos en caso de no estar creada.
    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonDataConnection();
        }
    }
    
    /**Metodo para retornar una instancia de SingletonDataConnection.
     * Si no esta creada la crea, y si esta creada la retorna.
     * @return retorna una instancia de la conexión a la base de datos
     */
    public static SingletonDataConnection getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    /** Método para retornar la instancia de la conexión
     * @return Connection conexión a la base de datos. */
    public Connection getConnection() {
        return this.con;
    }
    
    //Método para eliminar la instancia de la conexión
    public static void delInstance() {
        closeConnection();
        INSTANCE = null;
    }
    
    //Método que crea la conexión a la base de datos
    public void performConnection() {
 
        String host = "127.0.0.1";
        String user = "root";
        String pass = "";
        String dtbs = "dds";
 
        try { // preparamos la conexión
            Class.forName("com.mysql.jdbc.Driver");
            String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?"
                    + "user=" + user + "&password=" + pass;
            this.con = DriverManager.getConnection(newConnectionURL);
        } catch (Exception e) {
            System.out.println("Error al abrir la conexión.");
        }
    }
 
    //Método para cerrar la conexión con la base de dades
    public static void closeConnection() {
        try {
            INSTANCE.getConnection().close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }
    
}
