package demo.conart.other;

import demo.conart.enums.TypesOfPersistenceLayer;
import demo.conart.enums.TypesOfUis;

public class AppConfig {

    private static AppConfig instance;

    private TypesOfUis typesOfUis;
    private TypesOfPersistenceLayer typesOfPerLas;

    private AppConfig() {

    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }


    public TypesOfUis getTypesOfUis() {
        return typesOfUis;
    }

    public void setTypesOfUis(TypesOfUis typesOfUis) {
        this.typesOfUis = typesOfUis;
    }

    public TypesOfPersistenceLayer getTypesOfPersistenceLayer() {
        return typesOfPerLas;
    }

    public void setTypesOfPersistenceLayer(TypesOfPersistenceLayer typesOfPerLas) {
        this.typesOfPerLas = typesOfPerLas;
    }



}
