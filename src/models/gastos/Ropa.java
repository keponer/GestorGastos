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
public class Ropa extends Gasto {

    public Ropa(int id, String concepto, CategoriaGasto tipo, double cantidad, Date creationTime, Date updateTime) {
        super(id, concepto, tipo, cantidad, creationTime, updateTime);
    }

    @Override
    public double getIVAPagado() {
        //21% de getIVAPagado 
        return getCantidad()*0.1735;
    }

    @Override
    public double getSinIVA() {
        //21% de IVA
        return getCantidad()*0.8265;
    }
    
}