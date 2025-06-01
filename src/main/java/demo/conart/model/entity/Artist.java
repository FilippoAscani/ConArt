package demo.conart.model.entity;

public class Artist {

    /*
     * l'artista sceglie gli spettacoli dove partecipare, accetta o rifiuta le richieste. se accetta crea
     * lo spettacolo altrimenti elimina la richiesta dal suo elenco. visualizza le recensioni scritte dagli
     * utenti agli spettacoli dove si è esibito
     */

    private int id;
    private String username;
    private String password;

    public Artist() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
