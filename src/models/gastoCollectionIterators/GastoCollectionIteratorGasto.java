/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gastoCollectionIterators;

import java.util.List;
import models.gastos.Gasto;

/**
 *
 * @author Alex
 */
public class GastoCollectionIteratorGasto extends FilteredGastoCollectionIterator{

    public GastoCollectionIteratorGasto(List<Gasto> lista) {
        super(lista);
        //this.lista = lista;
    }

    @Override
    public boolean filter() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
    
}
