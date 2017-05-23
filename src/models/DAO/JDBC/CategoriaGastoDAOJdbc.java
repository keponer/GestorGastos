/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import models.DAO.SingletonDataConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.CategoriaGasto;
import models.DAO.CategoriaGastoDAO;

/**
 *
 * @author angel
 */
public class CategoriaGastoDAOJdbc implements CategoriaGastoDAO{
    private CategoriaGasto ct;
    private Connection c;
    
    public CategoriaGastoDAOJdbc(Connection c, CategoriaGasto ct) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    /**
     * Intenta insertar el objeto en la base de datos.
     * Devuelve el identificador numérico generado si es posible.
     * Devuelve 0 en caso de error.
     * Devuelve negativo en caso de no error y no poder devolver identificador.
     * @return int id autogenerado, 0 en caso de error, -1 si no se autogenera id
     */
    @Override
    public int insert() {
        PreparedStatement query;
        String queryText = "INSERT INTO categorias_transacciones (`name`, `iva`) VALUES (?, ?);";
        try {
            
            query = this.c.prepareStatement(queryText, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, ct.getName());
            query.setFloat(2, ct.getIva());
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
    
    /**
     *
     * @return 
     */
    @Override
    public boolean update(){
        return false;
    }
    
    /**
     * Devuelve una lista con todas las categorias existentes.
     * @return List resultado
     */
    @Override
    public List<CategoriaGasto> getList() {
        List<CategoriaGasto> lista = new ArrayList<>();
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
    
    public static CategoriaGasto parseResultRow(ResultSet set) {
        CategoriaGasto cat = new CategoriaGasto();
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
