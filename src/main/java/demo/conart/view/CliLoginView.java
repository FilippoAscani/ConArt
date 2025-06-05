package demo.conart.view;

import demo.conart.model.AuthService;

import java.util.Scanner;
import java.util.logging.Logger;

public class CliLoginView {

    /*
     * si occupa della presentazione dei form per permettere a chi utilizza il sistema di accedere
     * ad esempio l'utente accede come user normale, come artista o come sponsor il controller del login
     * gestisce quando chiamare la view
     */

    private AuthService authService;
    private Logger logger = Logger.getLogger(CliLoginView.class.getName());

    public CliLoginView(AuthService authService) {
        this.authService = authService;
    }

    public void startLogin(){
        Scanner sc = new Scanner(System.in);

        logger.info("Enter username: ");
        String username = sc.nextLine();

        logger.info("Enter password: ");
        String password = sc.nextLine();

        if (authService.login(username, password)){
            logger.info("You are logged in!");
        }
        else{
            logger.info("You are not logged in!");
        }
    }



}
