package demo.conart.view;


import java.util.Scanner;

import demo.conart.bean.BeanLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginView {

    public LoginView () {
        //costruttore vuoto
    }

    private static final Logger logger = LoggerFactory.getLogger(LoginView.class);




    public static BeanLogin metodoLoginUno(){

        Scanner sc = new Scanner(System.in);

        logger.info("inserisci username");
        String username = sc.nextLine();


        logger.info("inserisci password");
        String password = sc.nextLine();

        return new BeanLogin(username, password);

    }

    public static void metodoLoginDue(){

        logger.info("non corretto riprova");

    }

    public BeanLogin login(String tipoUtente) {

        Scanner scanner = new Scanner(System.in);

        logger.info("Login - inserisci username:");
        String username = scanner.nextLine();
        logger.info("Inserisci password:");
        String password = scanner.nextLine();
        return new BeanLogin(username, password, tipoUtente);
    }

    public void mostraMessaggio(String msg){
        logger.info(msg);
    }




}
