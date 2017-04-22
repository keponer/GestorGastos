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
public interface GastosFactoryMethod {
    public Gasto createGasto(int id, String tipoGasto, double cantidadGasto, String categoriaGasto);
}
