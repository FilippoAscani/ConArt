package demo.conart.model.entity;

import demo.conart.enums.Ruolo;

public class Artist extends User {

    /*
     * artista sceglie gli spettacoli dove partecipare, accetta o rifiuta le richieste. se accetta crea
     * lo spettacolo altrimenti elimina la richiesta dal suo elenco. visualizza le recensioni scritte dagli
     * utenti agli spettacoli dove si è esibito
     */

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
