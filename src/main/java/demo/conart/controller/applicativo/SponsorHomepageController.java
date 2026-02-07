package demo.conart.controller.applicativo;

import demo.conart.model.entity.Sponsor;
import demo.conart.view.SponsorHomepageCliView;


public class SponsorHomepageController {

    private SponsorHomepageCliView view;

    public SponsorHomepageController(SponsorHomepageCliView view) {
        this.view = view;
    }

    //vede profilo
    public void onProfileSelected(Sponsor sponsor) {
        view.showProfile(sponsor);
    }


    //elabora richiesta


    //vedi recensioni

}
