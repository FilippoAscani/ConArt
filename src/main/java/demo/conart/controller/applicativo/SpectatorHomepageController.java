package demo.conart.controller.applicativo;


import demo.conart.model.dao.review.ReviewDao;
import demo.conart.model.dao.show.ShowDao;
import demo.conart.model.entity.Review;
import demo.conart.model.entity.Show;
import demo.conart.model.entity.Spectator;
import demo.conart.view.SpectatorHomepageCliView;

import java.util.List;

public class SpectatorHomepageController {

    private final SpectatorHomepageCliView view;
    private final ShowDao showDAO;
    private final ReviewDao reviewDAO;

    public SpectatorHomepageController(SpectatorHomepageCliView view, ShowDao showDAO, ReviewDao reviewDAO) {

        this.view = view;
        this.showDAO = showDAO;
        this.reviewDAO = reviewDAO;

    }

    // visualizza profilo
    public void onProfileSelected(Spectator spectator) {
        view.showProfile(spectator);
    }

    // visualizza tutti gli show
    public void onShowsSelected() {
        List<Show> shows = showDAO.getShows();
        view.showShows(shows);
    }

    // scrive una recensione
    public void onWriteReviewSelected(Spectator spectator, Show show, int stars, String comment) {
        Review review = new Review();
        review.setAuthor(spectator);
        review.setShow(show);
        review.setStelle(stars);
        review.setCommento(comment);

        reviewDAO.addReview(review);
        view.showError("Recensione salvata con successo!");
    }

    // visualizza le recensioni scritte dallo spettatore


    // esci
    public void onExitSelected() {
        view.exit();
    }
}

