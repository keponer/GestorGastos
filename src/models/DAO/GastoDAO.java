/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import java.util.List;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public interface GastoDAO {    

    public List<Gasto> getList();
    
    public int insert();
    
    public boolean update();
}
