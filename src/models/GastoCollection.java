/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Iterator;
import java.util.List;
import models.gastoCollectionIterators.GastoCollectionIteratorFactory;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public class GastoCollection implements Iterable{
    private List<Gasto> lista;
    private static GastoCollection instance = null;
    
    
    GastoCollection(){
        this.lista = null;
    }
    GastoCollection(List<Gasto> lista){
        this.lista = lista;        
    }
    
    
    @Override
    public Iterator iterator() {
        return iterator("forward");
    }
    
    public Iterator iterator(String tipo) {
        return GastoCollectionIteratorFactory.getIterator(tipo, this.lista);
    }
    
    public static GastoCollection getInstance() {
        if (instance == null) {
            instance = new GastoCollection();
        }
        return instance;
    }
    
    public static void setList(List<Gasto> l) {
        getInstance().lista = l;
    }
}
