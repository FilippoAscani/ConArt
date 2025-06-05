package demo.conart.controller.cli;

import demo.conart.model.AuthService;
import demo.conart.view.CliControllerView;
import demo.conart.view.CliLoginView;
import demo.conart.view.CliRegisterView;

import java.util.Scanner;

public class CliAuthController {

    private AuthService authService;
    private CliControllerView cliControllerView;
    private CliLoginView cliLoginView;
    private CliRegisterView cliRegisterView;

    public CliAuthController(AuthService authService) {
        this.authService = authService;
    }

    public void inizio(){
        Scanner sc = new Scanner(System.in);

        while(true){
            cliControllerView.menu();
            String choice = sc.nextLine();
            switch (choice){

                case "1":
                    cliLoginView.startLogin();
                    break;

                case "2":
                    cliRegisterView.startRegistration();
                    break;

                case "3":
                    System.out.println("esci");
                    break;

                default:
                    System.out.println("scelta non valida");
                    return;
            }


        }

    }






}
