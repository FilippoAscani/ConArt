package demo.conart.controller.applicativo;

import demo.conart.bean.BeanLogin;
import demo.conart.bean.BeanSpectator;
import demo.conart.other.PersistenceStrategy;
import demo.conart.view.LoginView;

public abstract class LoginController {

    protected PersistenceStrategy persistenza;
    protected LoginView loginView;

    public LoginController(PersistenceStrategy persistenza) {
        this.persistenza = persistenza;
        this.loginView = new LoginView();
    }

    public abstract void start();

}
