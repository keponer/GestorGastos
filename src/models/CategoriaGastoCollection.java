/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import java.util.ListIterator;
import models.DAO.DAOFactory;

/**
 *
 * @author angel
 */
public class CategoriaGastoCollection {
    private static List<CategoriaGasto> lista = null;
    

    
    public static CategoriaGasto getById(int id){
        ListIterator<CategoriaGasto> it = lista.listIterator();
        CategoriaGasto current;
        while(it.hasNext()) {
            current = it.next();
            if (current.getId() == id)
                return current;
        }
        return null;
    }

    public static boolean ready() {
        return lista != null;
    }

    private static void poblate() {
        lista = DAOFactory.getCategoriaGastoDAO(null).getList();
    }

    public static void resetList() {
        poblate();
    }

    public static void start() {
        if (!ready()) {
            poblate();
        }
    }
}
