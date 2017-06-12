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
public class GastoCollectionIteratorCategoria extends FilteredGastoCollectionIterator{
    private Class cat = null;
    
    public GastoCollectionIteratorCategoria(List<Gasto> lista) {
        super(lista);
    }
    
    @Override
    public boolean filter() {
        return cat == actual().getClass();
    }
    
    public void setCategoria(Class c) {
        cat = c;
    }
}
