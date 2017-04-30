/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.factoryGastos;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class Ocio extends Gasto {

    public Ocio(int id, String concepto, int tipo, double cantidad, Date creationTime, Date updateTime) {
        super(id, concepto, tipo, cantidad, creationTime, updateTime);
    }

    @Override
    public double IVA() {
        //21% de IVA 
        //return getCantidadGasto()*0.1735;
        return 0;
    }
}
