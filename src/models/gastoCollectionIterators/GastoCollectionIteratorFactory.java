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
public class GastoCollectionIteratorFactory {
    public static Iterator getIterator(String tipo, List<Gasto> gc) {
        switch (tipo) {
            case "forward": 
            default:
                throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}