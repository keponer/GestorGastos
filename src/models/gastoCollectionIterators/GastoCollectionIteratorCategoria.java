/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gastoCollectionIterators;

import java.util.List;
import models.CategoriaGasto;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public class GastoCollectionIteratorCategoria extends FilteredGastoCollectionIterator{
    private int cat = 0;
    
    public GastoCollectionIteratorCategoria(List<Gasto> lista) {
        super(lista);
    }
    
    @Override
    public boolean filter() {
        return actual().getTipo().getId() == cat;
    }
    
    public void setCategoria(CategoriaGasto c) {
        cat = c.getId();
    }
}
