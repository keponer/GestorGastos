package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import models.CategoriaGastoCollection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class GestorGastos extends Application {
    
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
    public static void main(String[] args) {
        Connection c = SingletonDataConnection.getInstance().getConnection();
        GastoDAOJdbc gastojdbc = new GastoDAOJdbc(c, null);
        GastoCollection.setList(gastojdbc.getList());
        
        
        launch(args);
        
        
        
    }
    
}
