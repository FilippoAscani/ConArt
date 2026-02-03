package demo.conart.bean;

public class BeanLogin {

    private String username;
    private String password;
    private String tipoUtente;

    public BeanLogin() {
        //vuoto
    }
    public BeanLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BeanLogin(String username, String password, String tipoUtente) {
        this.username = username;
        this.password = password;
        this.tipoUtente = tipoUtente;
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

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }
}
