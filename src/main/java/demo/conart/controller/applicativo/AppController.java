package demo.conart.controller.applicativo;

import demo.conart.controller.grafico.cli.CliLoginController;
import demo.conart.controller.grafico.gui.GuiLoginController;
import demo.conart.enums.TypesOfPersistenceLayer;
import demo.conart.enums.TypesOfUis;
import demo.conart.other.AppConfig;
import demo.conart.other.PersistenceFs;
import demo.conart.other.PersistenceJdbc;
import demo.conart.other.PersistenceStrategy;
import demo.conart.view.MainView;




public class AppController {

    private PersistenceStrategy persistenza;
    private LoginController loginController;

    public void start() {

        //  Scegli UI
        String sceltaView = MainView.visualizzazione();
        TypesOfUis ui = switch (sceltaView) {
            case "1" -> TypesOfUis.CLI;
            case "2" -> TypesOfUis.JAVAFX;
            default -> { System.out.println("UI non valida"); yield null; }
        };
        if(ui == null) return;
        AppConfig.getInstance().setTypesOfUis(ui);

        //  Scegli persistenza
        String sceltaPersistenza = MainView.persistenza();
        TypesOfPersistenceLayer persistenceLayer = switch (sceltaPersistenza) {
            case "1" -> TypesOfPersistenceLayer.JDBC;
            case "2" -> TypesOfPersistenceLayer.FS;
            default -> { System.out.println("Persistenza non valida"); yield null; }
        };
        if(persistenceLayer == null) return;
        AppConfig.getInstance().setTypesOfPersistenceLayer(persistenceLayer);

        //  Configura strategia persistenza
        persistenza = (persistenceLayer == TypesOfPersistenceLayer.JDBC) ?
                new PersistenceJdbc() : new PersistenceFs();

        //  Scegli tipo utente
        String tipoUtente = MainView.tipoUtente();

        //  Crea login controller giusto
        loginController = switch(tipoUtente.toLowerCase()) {
            case "spettatore" -> new SpectatorLoginController(persistenza);
            case "artista" -> new ArtistLoginController(persistenza);
            case "sponsor" -> new SponsorLoginController(persistenza);
            default -> { System.out.println("Tipo utente non valido"); yield null; }
        };
        if(loginController == null) return;

        //  Avvia login + home page
        loginController.start();
    }
}


