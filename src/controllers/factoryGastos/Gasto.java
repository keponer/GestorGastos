/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.factoryGastos;

import java.util.Date;

/**
 *
 * @author Alex
 */
public abstract class Gasto {
    
    private int id;
    private String concepto;
    private int tipo;
    private double cantidad;
    private Date creationTime;
    private Date updateTime;

 
    public Gasto(int id, String concepto, int tipo, double cantidad, Date creationTime, Date updateTime){
        this.id = id;
        this.concepto = concepto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public abstract double getIVAPagado();
    
    public abstract double getSinIVA();
    
    
    
    
}
