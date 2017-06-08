package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import models.CategoriaGastoCollection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.DAO.JDBC.GastoDAOJdbc;
import models.DAO.SingletonDataConnection;
import models.GastoCollection;
import models.gastos.Gasto;

/**
 *
 * @author Alex
 */
public class GestorGastos extends Application{
    
    @Override
    public void start(Stage stage) throws IOException {
        //CategoriaGastoCollection.run();
        Parent root = FXMLLoader.load(getClass().getResource("VentanaPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Connection c = SingletonDataConnection.getInstance().getConnection();
        //GastoDAOJdbc gastojdbc = new GastoDAOJdbc(c, null);
        //GastoCollection.setList(gastojdbc.getList());
        
        int iInput = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //launch(args);
        while(true){
            System.out.println("que quieres hacer? Inserte el número con lo que quiere hacer");
            System.out.println("1. mostrar gastos");
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
            }
       
        }
        
    }
    
    public static void mostrarGastos(){
        System.out.println("1. Todos");
        
    } 
    
    public static void añadirGasto(){
        System.out.println("añadir gasto");        
    }
    
    public static void editarGasto(){
        System.out.println("editar gasto");
    }
    
    public static void eliminarGasto(){
        System.out.println("eliminar gasto");
    }
    

    
}
