/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.factoryGastos;

/**
 *
 * @author Alex
 */
public class Otros extends Gasto {

    public Otros(int id, String tipoGasto, double cantidadGasto) {
        super(id, tipoGasto, cantidadGasto);
    }

    @Override
    public double IVA() {
        //21% de IVA 
        return getCantidadGasto()*0.1735;
    }
    
}
