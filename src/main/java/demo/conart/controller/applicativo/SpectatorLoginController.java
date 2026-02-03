package demo.conart.controller.applicativo;

import demo.conart.bean.BeanLogin;
import demo.conart.other.PersistenceStrategy;

public class SpectatorLoginController extends LoginController {

    public SpectatorLoginController(PersistenceStrategy persistenza) {

        super(persistenza);

    }

    @Override
    public void start() {
        BeanLogin user = loginView.login("spettatore");
        persistenza.getUserDAO().salva(user);
        BeanLogin caricato = persistenza.getUserDAO().carica(user.getUsername());
        loginView.mostraMessaggio("Benvenuto spettatore: " + caricato.getUsername());
        // qui si aprirebbe la home page spettatore
    }

}
