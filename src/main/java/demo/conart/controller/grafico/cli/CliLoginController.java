package demo.conart.controller.grafico.cli;

import demo.conart.bean.BeanSpectator;
import demo.conart.bean.BeanLogin;
import demo.conart.controller.applicativo.LoginController;
import demo.conart.view.LoginView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static demo.conart.view.LoginView.metodoLoginDue;


public class CliLoginController {


    private static final Logger log = LoggerFactory.getLogger(CliLoginController.class);

    public CliLoginController(){
        //vuoto
    }

    public void cliLogin(){

        BeanLogin beanLogin = new BeanLogin();

        try{
            beanLogin = LoginView.metodoLoginUno();
        }
        catch(Exception e){
            LoginView.metodoLoginDue();
        }

        try {

        } catch (Exception e) {
            LoginView.metodoLoginDue();
        }



    }



}
