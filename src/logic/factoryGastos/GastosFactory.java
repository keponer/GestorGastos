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
public class GastosFactory implements GastosFactoryMethod{

   
    @Override
    public Gasto createGasto(int id, String concepto, int tipo, double cantidad, Date creationTime, Date updateTime) {
        
        if      (concepto.equals("Alquiler/Hipoteca")){
            return new Alquiler_Hipoteca(id, concepto, tipo, cantidad, creationTime, updateTime);
        } 
        
        else if (concepto.equals("Comida")){
            return new Comida(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Impuesto")){
            return new Impuestos(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Ocio")){
            return new Ocio(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Prestamo")){
            return new Prestamo(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Ropa")){
            return new Ropa(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Salud")){
            return new Salud(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else if (concepto.equals("Transporte")){
            return new Transporte(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
        
        else {
            return new Otros(id, concepto, tipo, cantidad, creationTime, updateTime);
        }
    
    }
    
}
