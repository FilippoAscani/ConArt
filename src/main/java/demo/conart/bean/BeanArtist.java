package demo.conart.bean;

public class BeanArtist {

    public BeanArtist(){
        //vuoto
    }

    private int idBeanArtist;
    private String usernameBeanArtist;
    private String passwordBeanArtist;
    private String tipoBeanArtist;


    public int getIdBeanArtist() {
        return idBeanArtist;
    }

    public void setIdBeanArtist(int idBeanArtist) {
        this.idBeanArtist = idBeanArtist;
    }

    public String getUsernameBeanArtist() {
        return usernameBeanArtist;
    }

    public void setUsernameBeanArtist(String usernameBeanArtist) {
        this.usernameBeanArtist = usernameBeanArtist;
    }

    public String getPasswordBeanArtist() {
        return passwordBeanArtist;
    }

    public void setPasswordBeanArtist(String passwordBeanArtist) {
        this.passwordBeanArtist = passwordBeanArtist;
    }

    public String getTipoBeanArtist() {
        return tipoBeanArtist;
    }

    public void setTipoBeanArtist(String tipoBeanArtist) {
        this.tipoBeanArtist = tipoBeanArtist;
    }
}
