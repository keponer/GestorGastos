/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gastos;

import java.util.Date;
import models.CategoriaGasto;

/**
 *
 * @author Alex
 */
public class Prestamo extends Gasto {

    public Prestamo(int id, String concepto, CategoriaGasto tipo, double cantidad, Date creationTime, Date updateTime) {
        super(id, concepto, tipo, cantidad, creationTime, updateTime);
    }

    @Override
    public double getIVAPagado() {
        //21% de getIVAPagado 
        //return getCantidadGasto()*0.1735;
        return 0;
    }

    @Override
    public double getSinIVA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
