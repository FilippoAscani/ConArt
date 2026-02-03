package demo.conart.controller.grafico.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StarsController {

    @FXML
    private Button btnArtist;

    @FXML
    private Button btnSponsor;

    @FXML
    private Button btnUser;

    @FXML private Label star1;
    @FXML private Label star2;
    @FXML private Label star3;
    @FXML private Label star4;
    @FXML private Label star5;

    private Label[] stars;
    private int rating = 0;

    @FXML
    public void initialize() {

        stars = new Label[]{star1, star2, star3, star4, star5};

        for (int i = 0; i < stars.length; i++) {
            Label star = stars[i];
            final int index = i;

            star.setStyle("-fx-font-size: 26px; -fx-cursor: hand;");

            star.setOnMouseClicked(e -> {
                rating = index + 1;
                aggiornaStelle(rating);
                System.out.println("Rating: " + rating);
            });
        }

        aggiornaStelle(0);
    }

    private void aggiornaStelle(int rating) {
        for (int i = 0; i < stars.length; i++) {
            if (i < rating) {
                stars[i].setText("★");
                stars[i].setStyle("-fx-font-size: 26px; -fx-text-fill: gold;");
            } else {
                stars[i].setText("☆");
                stars[i].setStyle("-fx-font-size: 26px; -fx-text-fill: gray;");
            }
        }
    }


    public void handleUser() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-login-view.fxml")));
            Stage stage = (Stage) btnUser.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata user login", e);
        }

    }

    public void handleArtist() {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-login-view.fxml")));
            Stage stage = (Stage) btnArtist.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata artist login", e);
        }

    }

    public void handleSponsor() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sponsor-login-view.fxml")));
            Stage stage = (Stage) btnSponsor.getScene().getWindow();
            stage.setScene(new Scene(root));


        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata sponsor login", e);
        }

    }
}
