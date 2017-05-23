/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.sql.Connection;
import java.util.List;
import models.Transaccion;

/**
 *
 * @author angel
 */
public interface TransaccionDAO {    
    public List<Transaccion> getList();
    
    public int insert();
    
    public boolean update();
}
