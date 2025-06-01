package demo.conart.model.entity;

public class Sponsor {

    /*
     * lo sponsor crea e invia le richieste per gli spettacoli che verranno accettate o meno dagli artisti.
     * visualizza le recensioni degli spettacoli dove hanno partecipato gli artisti da lui contattati
     */

    private int id;
    private String username;
    private String password;

    public Sponsor() {

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
