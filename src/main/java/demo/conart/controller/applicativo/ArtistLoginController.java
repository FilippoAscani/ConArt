package demo.conart.controller.applicativo;

import demo.conart.bean.BeanLogin;
import demo.conart.other.PersistenceStrategy;

public class ArtistLoginController extends LoginController {

        public ArtistLoginController(PersistenceStrategy persistenza) {

            super(persistenza);

        }

        @Override
        public void start() {
            BeanLogin user = loginView.login("artista");
            persistenza.getUserDAO().salva(user);
            loginView.mostraMessaggio("Benvenuto artista: " + user.getUsername());
        }


}
