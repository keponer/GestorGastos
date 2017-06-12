package presentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controllers.MainController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.CategoriaGastoCollection;
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
                    MainController.mostrarGastos();
                    break;
                case 2:
                    MainController.añadirGasto();
                    break;
                case 3:
                    MainController.editarGasto();
                    break;
                case 4:
                    MainController.eliminarGasto();
                    break;
                default:
                    System.out.println("Número introducido invalido, introduce otro número");
            }

        }

    }

}
