/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class CategoriaTransaccion {
    private int id;
    private String name;
    private float iva;

    public CategoriaTransaccion() {
    }
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
    
    /**
     * Intenta insertar el objeto en la base de datos.
     * Devuelve el identificador numérico generado si es posible.
     * Devuelve 0 en caso de error.
     * Devuelve negativo en caso de no error y no poder devolver identificador.
     * @return int id autogenerado, 0 en caso de error, -1 si no se autogenera id
     */
    public int insert() {
        Connection db = SingletonDataConnection.getInstance().getConnection();
        PreparedStatement query;
        String queryText = "INSERT INTO categorias_transacciones (`name`, `iva`) VALUES (?, ?);";
        try {
            
            query = db.prepareStatement(queryText, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, this.name);
            query.setFloat(2, this.iva);
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch(SQLException sqlException) {
            System.out.println("Posible error de conexión a la db.");
            return 0;
        }
        return -1;
    }
    
    public void update(){
        
    }
    
    public void selectById(int _id) {
    
    }
    
    public void selectByName(String _name) {
    
    }
    
    /**
     * Devuelve una lista con todas las categorias existentes.
     * @return List resultado
     */
    public static List<CategoriaTransaccion> list() {
        List<CategoriaTransaccion> lista = new ArrayList<>();
        Connection db = SingletonDataConnection.getInstance().getConnection();
        try {
            Statement query = db.createStatement();
            String queryTxt = "SELECT * FROM categorias_transacciones;";
            query.execute(queryTxt);
            ResultSet result = query.getResultSet();
            while(!result.isLast()) {
                result.next();
                lista.add(parseResultRow(result));
            }
        }
        catch(SQLException sqlException) {
            System.out.println("Posible error de conexión a la db. No se pudo crear el objeto query.");
            lista = null;
        }
        return lista;
    }
    
    public static CategoriaTransaccion parseResultRow(ResultSet set) {
        CategoriaTransaccion cat = new CategoriaTransaccion();
        try {
            cat.setId(set.getInt(1));
            cat.setName(set.getString(2));
            cat.setIva(set.getFloat(3));
        } catch (SQLException ex) {
            System.out.println("Error de conexión.");
        }
        return cat;
    }
}
