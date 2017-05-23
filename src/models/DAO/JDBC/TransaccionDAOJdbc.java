/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import java.sql.Connection;
import java.util.List;
import models.DAO.TransaccionDAO;
import models.Transaccion;

/**
 *
 * @author alroigar
 */
public class TransaccionDAOJdbc implements TransaccionDAO{
    private Connection c;
    
    public TransaccionDAOJdbc(Connection c) {
        this.c = c;
    }

    @Override
    public List<Transaccion> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean insert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
