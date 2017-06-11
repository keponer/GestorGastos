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
public class GastosFactory{

   
    public static Gasto createGasto(int id, String concepto, CategoriaGasto tipo, double cantidad, Date creationTime, Date updateTime) {
        int tipoID = tipo.getId();
        if      (tipoID == 1){
            return new Alquiler_Hipoteca(id, concepto, tipo, cantidad, creationTime, updateTime);
        } 
        
        else if (tipoID == 2){
            return new Comida(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 3){
            return new Impuestos(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 4){
            return new Ocio(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 5){
            return new Prestamo(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 6){
            return new Ropa(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 7){
            return new Salud(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (tipoID == 8){
            return new Transporte(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else {
            return new Otro(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
    
    }
    
    
    
}
