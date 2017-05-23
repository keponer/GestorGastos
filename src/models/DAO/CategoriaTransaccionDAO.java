/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.util.List;
import models.CategoriaTransaccion;

/**
 *
 * @author angel
 */
public interface CategoriaTransaccionDAO {
    public List<CategoriaTransaccion> getList();
    
    public int insert();
    
    public boolean update();
}
