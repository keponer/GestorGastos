package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.CategoriaGastoCollection;
import models.DAO.DAOFactory;
import models.DAO.SingletonDataConnection;
import models.GastoCollection;

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
        
        System.out.println("Descargando datos de categorias...");
        CategoriaGastoCollection.start();
        
        System.out.println("Descargando datos de gastos...");
        GastoCollection.getInstance();
        GastoCollection.setList();
        
        System.out.println("----------------------------------------------");
        System.out.println("");
        
        while(true){
            System.out.println("¿Qué quieres hacer? Inserte el número con lo que quiere hacer");
            System.out.println("1. Mostrar gastos");
            System.out.println("2. Añadir gasto");
            System.out.println("3. Editar gasto");
            System.out.println("4. Eliminar gasto");

            try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
            }
            
            switch(iInput){
                case 1: mostrarGastos();
                        break;
                case 2: añadirGasto();
                        break;
                case 3: editarGasto();
                        break;
                case 4: eliminarGasto();
                        break;
                default: System.out.println("Número introducido invalido, introduce otro número");
            }
       
        }
        
    }
    
    public static void mostrarGastos() throws IOException{
        
        int iInput          = 0;
        String sInput       = "";
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        
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
        
        try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
        
    } 
    
    public static void añadirGasto() throws IOException{
        
        String concepto     = "";
        int tipoGasto       = 0; 
        double cantidad     = 0;
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        
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
        
        try{
                tipoGasto = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
        
        System.out.println("Cantidad:"); 
        
        try{
                cantidad = Double.parseDouble(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
   
    }
    
    public static void editarGasto() throws IOException{
        
        int iInput          = 0;
        String sInput       = "";
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        
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
        
        try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
        
        System.out.println("Seleccione la id del gasto que quiera editar:");
        
        try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
    }
    
    public static void eliminarGasto() throws IOException{
        
        int iInput          = 0;
        String sInput       = "";
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        
        
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
        
        try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
        
        System.out.println("Seleccione la id del gasto que quiera eliminar:");
        
        try{
                iInput = Integer.parseInt(br.readLine());
            }catch(NumberFormatException nfe){
                System.err.println("Invalid Format!");
        }
        
        
        
        
    }
    
    public static void getGastos(int tipoGasto){
        
        switch(tipoGasto){
            case 0:
                    break;
            case 1: 
                    break;
            case 2: 
                    break;
            case 3: 
                    break;
            case 4: 
                    break;
            case 5: 
                    break;
            case 6: 
                    break;
            case 7: 
                    break;
            case 8: 
                    break;
            case 9: 
                    break;
                    
            default: System.out.println("Número introducido invalido, introduce otro número");
        }
    }

    
}
