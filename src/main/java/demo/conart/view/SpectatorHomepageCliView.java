package demo.conart.view;

import demo.conart.model.entity.Artist;
import demo.conart.model.entity.Request;
import demo.conart.model.entity.Show;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class SpectatorHomepageCliView {

    private static final Logger logger = LoggerFactory.getLogger(ArtistHomepageCliView.class);
    private final Scanner scanner = new Scanner(System.in);

    public String showMenuAndGetChoice() {
        logger.info("1 Profilo");
        logger.info("2 Show");
        logger.info("3 Recensioni");
        logger.info("4 Esci");

        return scanner.nextLine();
    }

    public void showProfile(Artist artist) {
        logger.info("ID {}", artist.getId());
        logger.info("Username {}", artist.getUsername());
    }



    public void showShows(List<Show> shows) {
        for (Show s : shows) {
            logger.info("Spettacolo: {}", s.getTitolo());
        }
    }


    public void writeReview(){

    }


    public void showError(String message) {
        logger.info(message);
    }

    public void exit() {
        System.exit(0);
    }

}
