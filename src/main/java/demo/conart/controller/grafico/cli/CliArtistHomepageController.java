package demo.conart.controller.grafico.cli;

import demo.conart.controller.applicativo.ArtistHomepageController;
import demo.conart.model.entity.Artist;
import demo.conart.view.ArtistHomepageCliView;

public class CliArtistHomepageController {



    private final ArtistHomepageCliView view;
    private final ArtistHomepageController controller;
    private final Artist artist;

    public CliArtistHomepageController(ArtistHomepageCliView view, ArtistHomepageController controller, Artist artist) {
        this.view = view;
        this.controller = controller;
        this.artist = artist;
    }

    public void start() {
        while (true) {
            String choice = view.showMenuAndGetChoice();

            switch (choice) {
                case "1" -> controller.onProfileSelected(artist);
                case "2" -> controller.onRequestsSelected(artist);
                case "3" -> controller.onReviewsSelected(artist);
                case "4" -> controller.onExitSelected();
                default -> view.showError("Scelta non valida");
            }
        }
    }
}

