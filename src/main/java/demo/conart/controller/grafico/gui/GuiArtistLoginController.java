package demo.conart.controller.grafico.gui;


import demo.conart.model.dao.artist.ArtistDaoCsv;
import demo.conart.model.dao.artist.ArtistDaoDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GuiArtistLoginController implements Initializable {



    @FXML
    private Button btnIndietroA;

    @FXML
    private Button btnLoginA;

    @FXML
    private Button btnRegisterA;

    @FXML
    private ComboBox<String> combo1A;

    @FXML
    private Label lblLoginA;

    @FXML
    private Label lblpasswordA;

    @FXML
    private Label lblusernameA;

    @FXML
    private PasswordField passwordFieldA;

    @FXML
    private TextField usernameFieldA;

    private static final Logger logger = LoggerFactory.getLogger(GuiArtistLoginController.class);
    private ArtistDaoCsv artistDaoCsv;
    private ArtistDaoDb artistDaoDb;

    @FXML
    public void select(ActionEvent actionEvent) {
        combo1A.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("JDBC","CSV");
        combo1A.setItems(list);

    }

    @FXML
    public void handleIndietro(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-homepage-view.fxml")));
            Stage stage = (Stage) btnIndietroA.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata di registrazione.", e);
        }
    }

    @FXML
    public void handleLogin() throws IOException {


        String s = combo1A.getSelectionModel().getSelectedItem();
        String username = usernameFieldA.getText();
        String password = passwordFieldA.getText();



        switch (s) {
            case "JDBC":


                if(artistDaoDb.exists(username,password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginA.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non è possibile loggare l'artista");
                }
                break;

            case "CSV":


                if(artistDaoCsv.exists(username,password)){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-profile-view.fxml")));
                    Stage stage = (Stage) btnLoginA.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
                else{
                    logger.info("non è possibile  loggare l'artista csv");
                }
                break;

            default:
                logger.info("errore default");

        }

    }




    @FXML
    public void handleRegister(ActionEvent actionEvent){
        //cambia schermata e porta alla registrazione

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("artist-register-view.fxml")));
            Stage stage = (Stage) btnRegisterA.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            throw new IllegalStateException("Impossibile caricare la schermata di registrazione.", e);
        }


    }







}


