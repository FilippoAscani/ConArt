package demo.conart.model.entity;

import demo.conart.enums.RequestStatus;

public class Request {

    private int id;
    private int numeroPosti;
    private String tipoShow;
    private Sponsor sponsor;
    private Artist artist;
    private RequestStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTipoShow() {
        return tipoShow;
    }

    public void setTipoShow(String tipoShow) {
        this.tipoShow = tipoShow;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
