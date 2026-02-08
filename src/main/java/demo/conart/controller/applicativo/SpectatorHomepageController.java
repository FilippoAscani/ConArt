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

    public SpectatorHomepageController(
            SpectatorHomepageCliView view,
            ShowDao showDAO,
            ReviewDao reviewDAO
    ) {
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
        Review review = new Review(spectator, show, stars, comment);
        reviewDAO.save(review);
        view.showMessage("Recensione salvata con successo!");
    }

    // visualizza le recensioni scritte dallo spettatore
    public void onMyReviewsSelected(Spectator spectator) {
        List<Review> reviews = reviewDAO.getBySpectator(spectator);
        view.showReviews(reviews);
    }

    // esci
    public void onExitSelected() {
        view.exit();
    }
}

