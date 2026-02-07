package demo.conart.controller.applicativo;

import demo.conart.model.entity.Show;
import demo.conart.model.entity.Sponsor;
import demo.conart.view.SponsorHomepageCliView;

import java.util.List;

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
    private List<Show> getShowsReviewed(String tipo) {
        return showDAO.getShows().stream().filter(s -> s.getTipo().equals(tipo)).toList();
    }
}
