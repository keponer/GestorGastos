/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import models.CategoriaGastoCollection;
import models.gastos.Gasto;
import models.gastos.GastosFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.CategoriaGasto;
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
        this.g = t;
    }
    public GastoDAOJdbc(Connection c) {
        this.c = c;
        this.g = null;
    }

    /**
     * Se conecta a la base de datos para devolver una lista con todos los gastos
     * @return Lista tipo gasto
     */
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
            System.out.println("GastoDAOJdbc.getList: Error sql / Conexión.");
            lista = null;
        }
        return lista;
    }

    /**
     * Dado el resultado de una query lo parsea en un objecto de tipo gasto
     * @param set
     * @return Objeto tipo gasto parseado
     */
    public static Gasto parseResultRow(ResultSet set) {
        if (!(set instanceof Gasto)) {
            return null;
        }
            
        Gasto g = null;
        int id, tipo;
        double cantidad;
        String concepto;
        Date creation, update;
        CategoriaGasto cat;
        try {
            id = set.getInt(1);
            concepto = set.getString(2);
            tipo =  set.getInt(3);
            cantidad = set.getDouble(4);
            creation = set.getDate(5);
            update = set.getDate(6);
            cat = CategoriaGastoCollection.getInstance().getById(tipo);
            g = GastosFactory.createGasto(id, concepto, cat, cantidad, creation, update);
            
        } catch (SQLException ex) {
            System.out.println("Error de conexión.");
        }
        
        return g;
    }

    /**
     * Dado un gasto hace un update de este mismo en la base de datos
     * @return True en caso de conseguir hacer el update False en el caso contrario
     */
    @Override
    public boolean update() {
        if (this.g == null || this.g.getId() <= 0)
            return false;
        
        PreparedStatement query;
        String queryText = "UPDATE transacciones SET `concepto`=?, `tipo`=?, `cantidad`=?";
        queryText += " WHERE `id` = ?;";
        try {
            query = this.c.prepareStatement(queryText, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, g.getConcepto());
            query.setInt(2, g.getTipo().getId());
            query.setDouble(3, g.getCantidad());
            query.setInt(4, g.getId());
            
            query.execute();

        }
        catch(SQLException sqlException) {
            System.out.println("GastoDAOJdbc.update: Error sql / Conexión.");
            return false;
        }
        return true;
    }

    /**
     * Inserta un Gasto en la base de datos
     * @return int con la id del nuevo gasto
     */
    @Override
    public int insert() {
        if (g == null || g.getId() != 0) {
            System.out.println("GastoDAOJdbc.insert: Se ha intentado insertar un Gasto nulo o uno ya existente.");
            return -1;
        }

        PreparedStatement query;
        String queryText = "INSERT INTO transacciones (`concepto`, `tipo`, `cantidad`) VALUES (?, ?, ?);";
        try {
            query = c.prepareStatement(queryText);
            query.setString(1, g.getConcepto());
            query.setInt(2, g.getTipo().getId());
            query.setDouble(3, g.getCantidad());
            
            query.execute();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        catch(SQLException sqlException) {
            System.out.println("GastoDAOJdbc.insert: Error sql / Conexión.");
            return 0;
        }
        return 1;
    }
    
    /**
     * Elimina un gasto de la base de datos por su id
     * @return True en caso de eliminar el gasto con exito False en el caso contrario
     */
    @Override
    public boolean delete(){
        if (this.g == null || this.g.getId() <= 0)
            return false;
        
        PreparedStatement query;
        String queryText = "DELETE FROM transacciones WHERE id=?;";
        
        try {
            query = c.prepareStatement(queryText);
            query.setInt(1, g.getId());
            query.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("GastoDAOJdbc.insert: Error sql / Conexión.");
        }
        
        return false;
    }
    
    
}
