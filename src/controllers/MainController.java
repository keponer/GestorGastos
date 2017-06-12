/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.CategoriaGasto;
import models.CategoriaGastoCollection;
import models.GastoCollection;
import models.gastoCollectionIterators.FilteredGastoCollectionIterator;
import models.gastos.Alquiler_Hipoteca;
import models.gastos.Comida;
import models.gastos.Gasto;
import models.gastos.GastosFactory;
import models.gastos.Impuesto;
import models.gastos.Ocio;
import models.gastos.Otro;
import models.gastos.Prestamo;
import models.gastos.Ropa;
import models.gastos.Salud;
import models.gastos.Transporte;

/**
 *
 * @author angel
 */
public class MainController {

    /**
     * Printea por consola todos los Gastos de tipo Ocio.
     */
    public static void getAllOcio() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Ocio) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Pide por consola todos los datos necesarios para crear un gasto nuevo y lo añade a la base de datos.
     * @throws IOException 
     */
    public static void añadirGasto() throws IOException {
        CategoriaGasto ct;
        Gasto g;
        String concepto = "";
        int tipoGasto = 0;
        double cantidad = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("A\u00f1adir gasto");
        System.out.println("Introduce el concepto:");
        concepto = br.readLine();
        System.out.println("Introduce el tipo de gasto:");
        System.out.println("0\tTodos");
        printCategorias();
        try {
            tipoGasto = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        System.out.println("Cantidad:");
        try {
            cantidad = Double.parseDouble(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        ct = CategoriaGastoCollection.getInstance().getById(tipoGasto);
        g = GastosFactory.createGasto(0, concepto, ct, cantidad, null, null);
        GastoCollection.getInstance().addGasto(g);
    }

    /**
     * Printea por consola todos los Gastos de tipo Transporte.
     */
    public static void getAllTransporte() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Transporte) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos.
     */
    public static void getAllGastos() {
        Gasto g;
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            System.out.println(g.getId() + "--" + g.getConcepto() + "--" +g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
        }
    }

    /**
     * Printea por consola todas la categorías
     */
    public static void printCategorias() {
        int i = 1;
        CategoriaGasto ct;
        while (CategoriaGastoCollection.getInstance().getById(i) != null) {
            ct = CategoriaGastoCollection.getInstance().getById(i++);
            System.out.println(ct.getId() + "\t" + ct.getName());
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Ropa
     */
    public static void getAllRopa() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Ropa) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Prestamo
     */
    public static void getAllPrestamo() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Prestamo) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Pide por consola todos los datos necesario para editar un gasto y lo edita en la base de datos
     * @throws IOException 
     */
    public static void editarGasto() throws IOException {
        CategoriaGasto ct;
        Gasto g;
        int iInput = 0;
        int idGasto = 0;
        String sInput = "";
        String concepto = "";
        int tipoGasto = 0;
        double cantidad = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Editar gasto");
        System.out.println("Introduce el tipo de gasto:");
        System.out.println("0\tTodos");
        printCategorias();
        try {
            iInput = Integer.parseInt(br.readLine());
            getGastos(iInput);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        System.out.println("Seleccione la id del gasto que quiera editar:");
        try {
            idGasto = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        System.out.println("Introduce el concepto:");
        concepto = br.readLine();
        System.out.println("Introduce el tipo de gasto:");
        printCategorias();
        try {
            tipoGasto = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        System.out.println("Cantidad:");
        try {
            cantidad = Double.parseDouble(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        ct = CategoriaGastoCollection.getInstance().getById(tipoGasto);
        g = GastosFactory.createGasto(idGasto, concepto, ct, cantidad, null, null);
        GastoCollection.getInstance().updateGasto(g);
    }

    /**
     * Printea por consola un gasto dada su ID
     * @throws IOException 
     */
    public static void mostrarGastos() throws IOException {
        int iInput = 0;
        String sInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Mostrar gastos:");
        System.out.println("0\tTodos");
        printCategorias();
        try {
            iInput = Integer.parseInt(br.readLine());
            getGastos(iInput);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Alquiler_Hipoteca
     */
    public static void getAllAlquiler_Hipoteca() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Alquiler_Hipoteca) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Comida
     */
    public static void getAllComida() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Comida) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Otros
     */
    public static void getAllOtros() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Otro) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Impuestos
     */
    public static void getAllImpuestos() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Impuesto) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Printea por consola todos los Gastos de tipo Salud
     */
    public static void getAllSalud() {
        Gasto g;
        GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Salud) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }

    /**
     * Dado un int con el tipo de gasto printea ese tipo, en caso de ser 0 printea todos.
     * @param tipoGasto Tipo de gasto a printear
     */
    public static void getGastos(int tipoGasto) {
        switch (tipoGasto) {
            case 0:
                getAllGastos();
                break;
            case 1:
                getAllAlquiler_Hipoteca();
                break;
            case 2:
                getAllComida();
                break;
            case 3:
                getAllImpuestos();
                break;
            case 4:
                getAllOcio();
                break;
            case 5:
                getAllPrestamo();
                break;
            case 6:
                getAllRopa();
                break;
            case 7:
                getAllSalud();
                break;
            case 8:
                getAllTransporte();
                break;
            case 9:
                getAllOtros();
                break;
            default:
                System.out.println("N\u00famero introducido invalido, introduce otro n\u00famero");
        }
    }

    /**
     * Elimina un gasto de la base de datos dada su ID por consola
     * @throws IOException 
     */
    public static void eliminarGasto() throws IOException {
        int iInput = 0;
        String sInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Eliminar gasto");
        System.out.println("Introduce el tipo de gasto:");
        System.out.println("0\tTodos");
        printCategorias();
        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        getGastos(iInput);
        System.out.println("Seleccione la id del gasto que quiera eliminar:");
        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        Gasto g;
        //GastoCollection.setList();
        FilteredGastoCollectionIterator it = GastoCollection.getInstance().iterator("forward");
        g = it.getGastoById(iInput);
        GastoCollection.getInstance().deleteGasto(g);
    }
    
}
