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
import models.gastoCollectionIterators.FilteredGastoCollectionIterator;
import models.gastoCollectionIterators.GastoCollectionIteratorFactory;
import models.gastos.Gasto;

/**
 *
 * @author angel
 */
public class GastoCollection implements Iterable{
    private List<Gasto> lista;
    private static GastoCollection instance = null;
    private ListIterator<Gasto> it = null;
    
    
    GastoCollection(){
        lista = null;
    }
    GastoCollection(List<Gasto> lista){
        this.lista = lista;        
    }
    
    /**
     * Llamada al DAOFactory y su insert correspondiente. Añade un Gasto en la base de datos.
     * @param g Gasto que será añadido
     */
    public void addGasto(Gasto g) {
        DAOFactory.getGastoDAO(g).insert();
        setList();
    }
    
    /**
     * Llamada al DAOFactory y su update correspondiente. Updatea un Gasto en la base de datos.
     * @param g Gasto que será updateado con los nuevos datos
     */
    public void updateGasto(Gasto g){
        if (g != null) {
            DAOFactory.getGastoDAO(g).update();
        }
        setList();
    }
    
    /**
     * Llamada al DAOFactory y su delete correspondiente. Elimina un Gasto en la base de datos.
     * @param g Gasto que será eliminado de la base de datos
     */
    public void deleteGasto(Gasto g) {
        if (g != null) {
            DAOFactory.getGastoDAO(g).delete(); 
        }
        setList();
    }
    
    /**
     * Llamada el iterador 
     * @return Iterador
     */
    @Override
    public FilteredGastoCollectionIterator iterator() {
        return iterator("forward");
    }
    
    
    public FilteredGastoCollectionIterator iterator(String tipo) {
        return GastoCollectionIteratorFactory.getIterator(tipo, lista);
    }
    
    public static GastoCollection getInstance() {
        if (instance == null) {
            instance = new GastoCollection();
        }
        return instance;
    }
    
    /**
     * Llamada al DAOFactory y su setList correspondiente. Crea una lista a partir de los datos de la base de datos.
     */
    public static void setList() {
        getInstance().lista = DAOFactory.getGastoDAO().getList();
    }
    
    
    public static void setList(List<Gasto> l) {
        getInstance().lista = l;
    }
}
