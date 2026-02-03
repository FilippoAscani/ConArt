package demo.conart.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainView {

    public MainView(){
        //costruttore per le view
    }

    private static final Logger logger = LoggerFactory.getLogger(MainView.class);
    static Scanner scanner = new Scanner(System.in);

    public static String visualizzazione(){

        logger.info("CLI: 1 or GUI: 2");

        return scanner.nextLine();

    }

    public static String persistenza(){

        logger.info("BD: 1 or CSV: 2");

        return scanner.nextLine();
    }

    public static String tipoUtente() {
        logger.info("Scegli tipo utente: spettatore, artista, sponsor");

        return scanner.nextLine();
    }




}
