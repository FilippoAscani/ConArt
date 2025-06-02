package demo.conart.model.entity;

public class User {

    /*
     * l'utente si logga, vede gli spettacoli, decide se partecipare o meno, se partecipa il numero dei posti
     * disponibili scende, quando va a zero lo spettacolo scompare dalla lista di tipo observable list
     *
     */

    private int id;
    private String cf;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;

    public User() {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
