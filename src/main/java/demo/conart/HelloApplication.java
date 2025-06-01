package demo.conart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

        System.out.println("CLI: 1 or GUI: 2");
        String input = sc.nextLine();

        switch (input) {

            case "1":
                System.out.println("Hello World!");
                break;

            case "2":
                System.out.println("Goodbye World!");
                break;

            default:
                System.out.println("Invalid input");

        }
        /*

        il main chiede cli o gui
        il main chiede db o csv

        il main lancia il controller pertinente e assegna il layer

         */


    }
}