package demo.conart.controller.applicativo;

import demo.conart.bean.BeanLogin;
import demo.conart.other.PersistenceStrategy;

public class SponsorLoginController extends LoginController {

        public SponsorLoginController(PersistenceStrategy persistenza) {
            super(persistenza);
        }

        @Override
        public void start() {
            BeanLogin user = loginView.login("sponsor");
            persistenza.getUserDAO().salva(user);
            loginView.mostraMessaggio("Benvenuto sponsor: " + user.getUsername());
        }


}
