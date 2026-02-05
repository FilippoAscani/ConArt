package demo.conart.controller.applicativo;

import demo.conart.view.ArtistHomepageCliView;

public class ArtistHomepageController {

    private final ArtistHomepageCliView view;
    private final RequestDAOImplCSV requestDAO = new RequestDAOImplCSV();
    private final ShowDAOImplCSV showDAO = new ShowDAOImplCSV();

    public ArtistHomepageController(ArtistHomepageView view) {
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
                Show show = new Show(
                        request.getId(),
                        request.getNome(),
                        request.getCapienza(),
                        request.getTipo()
                );
                showDAO.addShow(show);
                request.setStatus("accepted");
            } else {
                request.setStatus("denied");
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
