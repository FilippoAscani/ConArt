package demo.conart.view;

import demo.conart.model.AuthService;

import java.util.Scanner;

public class CliLoginView {

    /*
     * si occupa della presentazione dei form per permettere a chi utilizza il sistema di accedere
     * ad esempio l'utente accede come user normale, come artista o come sponsor il controller del login
     * gestisce quando chiamare la view
     */

    private AuthService authService;

    public CliLoginView(AuthService authService) {
        this.authService = authService;
    }

    public void startLogin(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (authService.login(username, password)){
            System.out.println("You are logged in!");
        }
        else{
            System.out.println("You are not logged in!");
        }
    }



}
