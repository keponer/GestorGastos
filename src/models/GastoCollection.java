/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import models.DAO.DAOFactory;
import models.gastoCollectionIterators.GastoCollectionIteratorFactory;
import models.gastoCollectionIterators.GastoCollectionIteratorGasto;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public class GastoCollection implements Iterable{
    private static List<Gasto> lista;
    private static GastoCollection instance = null;
    private static ListIterator<Gasto> it = null;
    
    
    GastoCollection(){
        lista = null;
    }
    GastoCollection(List<Gasto> lista){
        this.lista = lista;        
    }
    
    public static void addGasto(Gasto g) {
        //lista.add(g);
        DAOFactory.getGastoDAO(g).insert();
        //DAOFactory.getGastoDAO().getList();
        setList();
    }
    
    public static void updateGasto(Gasto g){
        Gasto target = g;
        if (target != null) {
            DAOFactory.getGastoDAO(target).update();
        }
    }
    
    public static void iniciarListIterator(){
        it = lista.listIterator();
    }
    
    public static void deleteGasto(Gasto g) {
        Gasto target = g;
        if (target != null) {
            DAOFactory.getGastoDAO(target).delete(); 
        }
    }
    
    public static Gasto getById(int id){
        ListIterator<Gasto> it = lista.listIterator();
        Gasto current;
        while(it.hasNext()) {
            current = it.next();
            if (current.getId() == id)
                return current;
        }
        return null;
    }

    public static Gasto getCurrentGasto(){
        Gasto current;
        while(it.hasNext()) {
            current = it.next();
            return current;
        }  
        return null;
    }
    
    
    @Override
    public Iterator iterator() {
        return iterator("forward");
    }
    
    public static Iterator iterator(String tipo) {
        return new GastoCollectionIteratorGasto(GastoCollection.lista);
    }
    
    public static GastoCollection getInstance() {
        if (instance == null) {
            instance = new GastoCollection();
        }
        return instance;
    }
    
    public static void setList() {
        getInstance().lista = DAOFactory.getGastoDAO().getList();
    }
    public static void setList(List<Gasto> l) {
        getInstance().lista = l;
    }
}
