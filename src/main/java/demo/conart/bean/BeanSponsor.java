package demo.conart.bean;

public class BeanSponsor {

    public BeanSponsor(){
        //vuoto
    }

    private int idBeanSponsor;
    private String usernameBeanSponsor;
    private String passwordBeanSponsor;

    public int getIdBeanSponsor() {
        return idBeanSponsor;
    }

    public void setIdBeanSponsor(int idBeanSponsor) {
        this.idBeanSponsor = idBeanSponsor;
    }

    public String getUsernameBeanSponsor() {
        return usernameBeanSponsor;
    }

    public void setUsernameBeanSponsor(String usernameBeanSponsor) {
        this.usernameBeanSponsor = usernameBeanSponsor;
    }

    public String getPasswordBeanSponsor() {
        return passwordBeanSponsor;
    }

    public void setPasswordBeanSponsor(String passwordBeanSponsor) {
        this.passwordBeanSponsor = passwordBeanSponsor;
    }
}
