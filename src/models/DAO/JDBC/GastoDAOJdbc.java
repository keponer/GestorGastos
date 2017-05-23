/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import controllers.factoryGastos.Gasto;
import controllers.factoryGastos.GastosFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.DAO.GastoDAO;

/**
 *
 * @author alroigar
 */
public class GastoDAOJdbc implements GastoDAO{
    private Connection c;
    private Gasto g;
    
    public GastoDAOJdbc(Connection c, Gasto t) {
        this.c = c;
        
    }

    @Override
    public List<Gasto> getList() {
        List<Gasto> lista = new ArrayList<>();
        try {
            Statement query = c.createStatement();
            String queryTxt = "SELECT * FROM transacciones;";
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

    public static Gasto parseResultRow(ResultSet set) {
        GastosFactory gf = new GastosFactory();
        Gasto g = null;
        int id, tipo;
        double cantidad;
        String concepto;
        Date creation, update;
        try {
            id = set.getInt(1);
            concepto = set.getString(2);
            tipo =  set.getInt(3);
            cantidad = set.getDouble(4);
            creation = set.getDate(5);
            update = set.getDate(6);

            g = gf.createGasto(id, concepto, tipo, cantidad, creation, update);
            
        } catch (SQLException ex) {
            System.out.println("Error de conexión.");
        }
        
        return g;
    }
    
    @Override
    public int insert() {
        PreparedStatement query;
        String queryText = "INSERT INTO categorias_transacciones (`concepto`, `tipo`,";
        queryText += "`cantidad`, `creation_time`, `update_time` ) VALUES (?, ?, ?, ?, ?);";
        try {
            query = this.c.prepareStatement(queryText, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, g.getConcepto());
            query.setInt(2, g.getTipo());
            query.setDouble(3, g.getCantidad());
            query.setDate(4, (Date) g.getCreationTime());
            query.setDate(5, (Date) g.getUpdateTime());
            
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

    @Override
    public boolean update() {
        PreparedStatement query;
        String queryText = "UPDATE categorias_transacciones SET `concepto`=?, `tipo`=?, `cantidad`=?";
        queryText += " WHERE `id` = ?;";
        try {
            query = this.c.prepareStatement(queryText, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, g.getConcepto());
            query.setInt(2, g.getTipo());
            query.setDouble(3, g.getCantidad());
            query.setInt(4, g.getId());
            
            query.execute();

        }
        catch(SQLException sqlException) {
            System.out.println("Posible error de conexión a la db.");
            return false;
        }
        return true;
    }
    
}
