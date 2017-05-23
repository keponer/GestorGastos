/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.sql.Connection;
import models.CategoriaTransaccion;
import models.DAO.JDBC.CategoriaTransaccionDAOJdbc;
import models.DAO.JDBC.TransaccionDAOJdbc;
import models.Transaccion;

/**
 *
 * @author angel
 */
public class DAOFactory {
    private static Connection c;
    
    public static TransaccionDAO getTransaccionDAO(Transaccion t) {
      if (c == null) {
          c = SingletonDataConnection.getInstance().getConnection();
      }
      return new TransaccionDAOJdbc(c, t);
    }
    
    public static CategoriaTransaccionDAO getCategoriaTransaccionDAO(CategoriaTransaccion ct) {
      if (c == null) {
          c = SingletonDataConnection.getInstance().getConnection();
      }
      return new CategoriaTransaccionDAOJdbc(c, ct);
    }
}
