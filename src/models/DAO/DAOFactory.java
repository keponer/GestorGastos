/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.sql.Connection;
import models.CategoriaGasto;
import models.DAO.JDBC.CategoriaGastoDAOJdbc;
import models.DAO.JDBC.GastoDAOJdbc;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public class DAOFactory {
    private static Connection c;
    
    public static void setConnection() {
        if (c == null) 
            c = SingletonDataConnection.getInstance().getConnection();
    }

    public static GastoDAO getGastoDAO() {
        setConnection();
        return new GastoDAOJdbc(c);
    }
    public static GastoDAO getGastoDAO(Gasto t) {
        setConnection();
        return new GastoDAOJdbc(c, t);
    }

    public static CategoriaGastoDAO getCategoriaGastoDAO() {
        setConnection();
        return new CategoriaGastoDAOJdbc(c);
    }
    public static CategoriaGastoDAO getCategoriaGastoDAO(CategoriaGasto ct) {
        setConnection();
        return new CategoriaGastoDAOJdbc(c, ct);
    }
}
