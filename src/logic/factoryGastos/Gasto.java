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
public abstract class Gasto {
    
    private int     id;
    private String  tipoGasto;
    private double   cantidadGasto;
    
    public Gasto(int id, String tipoGasto, double cantidadGasto){
        this.id = id;
        this.tipoGasto = tipoGasto;
        this.cantidadGasto = cantidadGasto;
    }
    
    public abstract double IVA();
    
    public int getId() {
        return id;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public double getCantidadGasto() {
        return cantidadGasto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public void setCantidadGasto(float cantidadGasto) {
        this.cantidadGasto = cantidadGasto;
    }
    
    
}
