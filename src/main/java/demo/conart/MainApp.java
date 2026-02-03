package demo.conart;

import demo.conart.controller.applicativo.AppController;
import demo.conart.view.MainView;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {

    public static void main(String[] args) {

        AppController controller = new AppController();
        controller.start();

    }
}