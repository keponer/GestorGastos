/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.gastoCollectionIterators;

import java.util.Iterator;
import java.util.List;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public abstract class FilteredGastoCollectionIterator implements Iterator{
    private List<Gasto> lista;
    private int index;
    private int next;
    
    FilteredGastoCollectionIterator(List<Gasto> lista) {
        this.lista = lista;
        this.index = -1;
        this.next = 0;
    }
    
    @Override
    public boolean hasNext() {
        if (next < lista.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Object next() {
        index = next;
        this.calculateNext();
        return lista.get(index);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
    
    public void calculateNext() {
        /* Aumentará next hasta que algún elemento cumpla el filtro o se
           alcance el final de la lista, en ese caso hasNext devolverá false */
        while (++next < lista.size()) {
            if (this.filter()) break;
        }
    }
    
    public abstract boolean filter();
}
