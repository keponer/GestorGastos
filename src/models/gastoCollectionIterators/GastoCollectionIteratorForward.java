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
 * @author angel
 */
public class GastoCollectionIteratorForward extends FilteredGastoCollectionIterator{

    public GastoCollectionIteratorForward(List<Gasto> lista) {
        super(lista);
    }
    
    @Override
    public boolean filter() {
        return true;
    }
    
}
