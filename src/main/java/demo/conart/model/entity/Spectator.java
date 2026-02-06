package demo.conart.model.entity;

import demo.conart.enums.Ruolo;

public class Spectator extends User {

    /*
     * l'utente si logga, vede gli spettacoli, decide se partecipare o meno, se partecipa il numero dei posti
     * disponibili scende, quando va a zero lo spettacolo scompare dalla lista di tipo observable list
     *
     */

    private String cf;
    private String nome;
    private String cognome;
    private String email;

    public Spectator() {
        this.ruolo = Ruolo.SPECTATOR;
    }


    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
