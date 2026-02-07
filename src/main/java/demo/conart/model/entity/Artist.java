package demo.conart.model.entity;

import demo.conart.enums.Ruolo;

public class Artist extends User {



    private String tipo;

    public Artist() {
        //costruttore
        this.ruolo = Ruolo.ARTIST;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
