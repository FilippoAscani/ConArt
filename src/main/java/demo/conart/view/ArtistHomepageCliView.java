package demo.conart.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ArtistHomepageCliView {


    private static final Logger logger = LoggerFactory.getLogger(ArtistHomepageCliView.class);
    private final Scanner scanner = new Scanner(System.in);

    public String showMenuAndGetChoice() {
        logger.info("1 Profilo");
        logger.info("2 Richieste");
        logger.info("3 Recensioni");
        logger.info("4 Esci");

        return scanner.nextLine();
    }

    public void showProfile(Artist artist) {
        logger.info("ID {}", artist.getId());
        logger.info("Username {}", artist.getUsername());
    }

    public void showRequests(List<Request> requests) {
        if (requests.isEmpty()) {
            logger.info("Nessuna richiesta");
        } else {
            for (Request r : requests) {
                logger.info("Richiesta: {}", r.getNome());
            }
        }
    }

    public boolean askAcceptRequest(Request request) {
        logger.info("Accetti {}? (y/n)", request.getNome());
        return scanner.nextLine().equalsIgnoreCase("y");
    }

    public void showShows(List<Show> shows) {
        for (Show s : shows) {
            logger.info("Spettacolo: {}", s.getTitolo());
        }
    }

    public void showError(String message) {
        logger.info(message);
    }

    public void exit() {
        System.exit(0);
    }

}
