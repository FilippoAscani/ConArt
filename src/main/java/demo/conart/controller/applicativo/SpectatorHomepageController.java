package demo.conart.controller.applicativo;

import demo.conart.model.entity.Artist;
import demo.conart.model.entity.Show;
import demo.conart.model.entity.Spectator;
import demo.conart.view.SpectatorHomepageCliView;

import java.util.List;

public class SpectatorHomepageController {


    private SpectatorHomepageCliView view;

    public SpectatorHomepageController(SpectatorHomepageCliView view) {
        this.view = view;
    }

    //vede profilo
    public void onProfileSelected(Spectator spectator) {
        view.showProfile(spectator);
    }

    //scrive recensione
    public void onReviewsSelected(Spectator spectator) {
        List<Show> shows = getShowsReviewed(spectator.getTipo());
        view.showShows(shows);
    }

    //esci
    public void onExitSelected() {
        view.exit();
    }

    //vedi recensioni
    private List<Show> getShowsReviewed(String tipo) {
        return showDAO.getShows().stream().filter(s -> s.getTipo().equals(tipo)).toList();
    }

    //aggiunge stelle

}
