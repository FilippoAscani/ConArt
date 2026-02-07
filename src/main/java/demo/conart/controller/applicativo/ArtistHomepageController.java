package demo.conart.controller.applicativo;

import demo.conart.enums.RequestStatus;
import demo.conart.model.dao.request.RequestDaoCsv;
import demo.conart.model.dao.show.ShowDaoCsv;
import demo.conart.model.entity.Artist;
import demo.conart.model.entity.Request;
import demo.conart.model.entity.Show;
import demo.conart.view.ArtistHomepageCliView;

import java.util.List;

public class ArtistHomepageController {

    private final ArtistHomepageCliView view;
    private final RequestDaoCsv requestDAO = new RequestDaoCsv();
    private final ShowDaoCsv showDAO = new ShowDaoCsv();

    public ArtistHomepageController(ArtistHomepageCliView view) {
        this.view = view;
    }

    public void onProfileSelected(Artist artist) {
        view.showProfile(artist);
    }

    public void onRequestsSelected(Artist artist) {
        List<Request> requests = getRequestsByTipo(artist.getTipo());
        view.showRequests(requests);

        for (Request request : requests) {
            boolean accepted = view.askAcceptRequest(request);

            if (accepted) {
                Show show = new Show();

                show.setTipo(request.getTipo());
                show.setTitolo(request.getNome());
                show.setPostiDisponibili(request.getNumeroPosti());

                showDAO.addShow(show);

                request.setStatus(RequestStatus.ACCEPTED);
            } else {
                request.setStatus(RequestStatus.REJECTED);
            }
        }
    }

    public void onReviewsSelected(Artist artist) {
        List<Show> shows = getShowsReviewed(artist.getTipo());
        view.showShows(shows);
    }

    public void onExitSelected() {
        view.exit();
    }

    private List<Request> getRequestsByTipo(String tipo) {
        return requestDAO.getRequests()
                .stream()
                .filter(r -> r.getTipo().equals(tipo))
                .toList();
    }

    private List<Show> getShowsReviewed(String tipo) {
        return showDAO.getShows()
                .stream()
                .filter(s -> s.getTipo().equals(tipo))
                .toList();
    }
}
