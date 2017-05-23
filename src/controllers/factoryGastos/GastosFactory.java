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
public class GastosFactory{

   
    public Gasto createGasto(int id, String concepto, int tipo, double cantidad, Date creationTime, Date updateTime) {
        
        if      (tipo == 1){
            return new Alquiler_Hipoteca(id, concepto, tipo, cantidad, creationTime, updateTime);
        } 
        
        else if (tipo == 2){
            return new Comida(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 3){
            return new Impuestos(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 4){
            return new Ocio(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 5){
            return new Prestamo(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 6){
            return new Ropa(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 7){
            return new Salud(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipo == 8){
            return new Transporte(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else {
            return new Otros(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
    
    }
    
    
    
}
