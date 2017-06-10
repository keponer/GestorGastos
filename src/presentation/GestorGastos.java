package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.CategoriaGasto;
import models.CategoriaGastoCollection;
import models.DAO.SingletonDataConnection;
import models.GastoCollection;
import models.gastoCollectionIterators.GastoCollectionIteratorGasto;
import models.gastos.Alquiler_Hipoteca;
import models.gastos.Comida;
import models.gastos.Gasto;
import models.gastos.GastosFactory;
import models.gastos.Impuestos;
import models.gastos.Ocio;
import models.gastos.Otros;
import models.gastos.Prestamo;
import models.gastos.Ropa;
import models.gastos.Salud;
import models.gastos.Transporte;

/**
 *
 * @author Alex
 */
public class GestorGastos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int iInput = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("/// --- GestorGastos --- \\\\\\");
        System.out.println("");

        System.out.println("Conectando a la base de datos...");
        SingletonDataConnection.getInstance();

        if(!SingletonDataConnection.isReady()) {
            System.out.println("No se ha podido conectar a la base de datos");
            return;
        }
        
        System.out.println("Descargando datos de categorias...");
        CategoriaGastoCollection.start();

        System.out.println("Descargando datos de gastos...");
        GastoCollection.getInstance();
        GastoCollection.setList();

        System.out.println("----------------------------------------------");
        System.out.println("");

        test();
        getAllGastos();
        getAllImpuestos();

        while (true) {
            System.out.println("¿Qué quieres hacer? Inserte el número con lo que quiere hacer");
            System.out.println("1. Mostrar gastos");
            System.out.println("2. Añadir gasto");
            System.out.println("3. Editar gasto");
            System.out.println("4. Eliminar gasto");

            try {
                iInput = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }

            switch (iInput) {
                case 1:
                    mostrarGastos();
                    break;
                case 2:
                    añadirGasto();
                    break;
                case 3:
                    editarGasto();
                    break;
                case 4:
                    eliminarGasto();
                    break;
                default:
                    System.out.println("Número introducido invalido, introduce otro número");
            }

        }

    }

    public static void mostrarGastos() throws IOException {
        
        
        int iInput = 0;
        String sInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Mostrar gastos:");
        System.out.println("0. Todos");
        System.out.println("1. Alquiler/Hipoteca");
        System.out.println("2. Comida");
        System.out.println("3. Impuestos");
        System.out.println("4. Ocio");
        System.out.println("5. Prestamos");
        System.out.println("6. Ropa");
        System.out.println("7. Salud");
        System.out.println("8. Transporte");
        System.out.println("9. Otros");

        try {
            iInput = Integer.parseInt(br.readLine());
            getGastos(iInput);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }

    }

    public static void añadirGasto() throws IOException {
 
        GastosFactory gf = new GastosFactory();
        CategoriaGasto ct;
        Gasto g;
        String concepto = "";
        int tipoGasto = 0;
        double cantidad = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Añadir gasto");
        System.out.println("Introduce el concepto:");
        concepto = br.readLine();

        System.out.println("Introduce el tipo de gasto:");
        System.out.println("1. Alquiler/Hipoteca");
        System.out.println("2. Comida");
        System.out.println("3. Impuestos");
        System.out.println("4. Ocio");
        System.out.println("5. Prestamos");
        System.out.println("6. Ropa");
        System.out.println("7. Salud");
        System.out.println("8. Transporte");
        System.out.println("9. Otros");

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
        
        
        ct = CategoriaGastoCollection.getById(tipoGasto);
        
        g = gf.createGasto(0, concepto, ct, cantidad, null, null);
        
        GastoCollection.addGasto(g);

    }

    public static void editarGasto() throws IOException {
        GastosFactory gf = new GastosFactory();
        CategoriaGasto ct;
        Gasto g;
        int iInput = 0;
        String sInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Editar gasto");

        System.out.println("Introduce el tipo de gasto:");
        System.out.println("1. Alquiler/Hipoteca");
        System.out.println("2. Comida");
        System.out.println("3. Impuestos");
        System.out.println("4. Ocio");
        System.out.println("5. Prestamos");
        System.out.println("6. Ropa");
        System.out.println("7. Salud");
        System.out.println("8. Transporte");
        System.out.println("9. Otros");

        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }

        System.out.println("Seleccione la id del gasto que quiera editar:");

        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    
       //g = gf.createGasto(iInput, sInput, tipo, iInput, null, null);
    }

    public static void eliminarGasto() throws IOException {

        int iInput = 0;
        String sInput = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Eliminar gasto");

        System.out.println("Introduce el tipo de gasto:");
        System.out.println("1. Alquiler/Hipoteca");
        System.out.println("2. Comida");
        System.out.println("3. Impuestos");
        System.out.println("4. Ocio");
        System.out.println("5. Prestamos");
        System.out.println("6. Ropa");
        System.out.println("7. Salud");
        System.out.println("8. Transporte");
        System.out.println("9. Otros");

        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }

        System.out.println("Seleccione la id del gasto que quiera eliminar:");

        try {
            iInput = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }

    }

    public static void getGastos(int tipoGasto) {

        switch (tipoGasto) {
            case 0: getAllGastos();
                break;
            case 1: getAllAlquiler_Hipoteca();
                break;
            case 2: getAllComida();
                break;
            case 3: getAllImpuestos();
                break;
            case 4: getAllOcio();
                break;
            case 5: getAllPrestamo();
                break;
            case 6: getAllRopa();
                break;
            case 7: getAllSalud();
                break;
            case 8: getAllTransporte();
                break;
            case 9: getAllOtros();
                break;

            default:
                System.out.println("Número introducido invalido, introduce otro número");
        }
    }

    public static void getAllGastos() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
        }
    }

    public static void getAllAlquiler_Hipoteca() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Alquiler_Hipoteca) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllComida() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Comida) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllImpuestos() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Impuestos) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllOcio() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Ocio) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllPrestamo() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Prestamo) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllRopa() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Ropa) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllSalud() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Salud) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllTransporte() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Transporte) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    
    public static void getAllOtros() {
        Gasto g;
        GastoCollection.setList();
        GastoCollectionIteratorGasto it = (GastoCollectionIteratorGasto) GastoCollection.iterator("forward");

        while (it.hasNext()) {
            g = it.next();
            if (g instanceof Otros) {
                System.out.println(g.getId() + "--" + g.getConcepto() + "--" + g.getCantidad() + "--" + g.getCreationTime() + "--" + g.getTipo().getName());
            }
        }
    }
    

    public static void test() {
        int i = 1;
        CategoriaGasto ct;
        while (CategoriaGastoCollection.getById(i) != null) {
            ct = CategoriaGastoCollection.getById(i++);
            System.out.println(ct.getId() + "\t" + ct.getName());
        }
    }
}
