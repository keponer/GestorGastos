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
public class GastosFactory implements GastosFactoryMethod{

   
    @Override
    public Gasto createGasto(int id, String tipoGasto, double cantidadGasto, String categoriaGasto) {
        
        if      (categoriaGasto.equals("Alquiler/Hipoteca")){
            return new Alquiler_Hipoteca(id, tipoGasto, cantidadGasto);
        } 
        
        else if (categoriaGasto.equals("Comida")){
            return new Comida(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Impuesto")){
            return new Impuestos(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Ocio")){
            return new Ocio(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Prestamo")){
            return new Prestamo(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Ropa")){
            return new Ropa(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Salud")){
            return new Salud(id, tipoGasto, cantidadGasto);
        }
        
        else if (categoriaGasto.equals("Transporte")){
            return new Transporte(id, tipoGasto, cantidadGasto);
        }
        
        else {
            return new Otros(id, tipoGasto, cantidadGasto);
        }
    
    }
    
}
