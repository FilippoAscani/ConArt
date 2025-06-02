package demo.conart.view;

import demo.conart.model.AuthService;

import java.util.Scanner;

import static java.lang.System.exit;

public class CliRegisterView {

    /*
     * questa view si occupa invece della registrazione. viene chiamata dal relativo controller
     * quando non esiste ancora l'utente all'interno del sistema
     */

    private AuthService authService;

    public CliRegisterView(AuthService authService) {
        this.authService = authService;
    }

    public void startRegistration(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("inserisci username ");
        String username = scanner.nextLine();

        System.out.println("inserisci password ");
        String password = scanner.nextLine();

        System.out.println("inserisci email ");
        String email = scanner.nextLine();

        System.out.println("immetti di nuovo la password");
        String nPassword = scanner.nextLine();

        if(!password.equals(nPassword)){
            System.out.println("le password non coincidono");
        }

        boolean success = authService.register(email, password);

        if(success){
            System.out.println("registrato");
        }
        else{
            System.out.println("utente già esistente");
        }
    }

}
