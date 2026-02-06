package demo.conart.model.entity;

public class Show {


    private int id;
    private int postiDisponibili;
    private String tipo;
    private Artist artist;
    private Sponsor sponsor;



    public void decrementaPosti() {
        if (postiDisponibili > 0) {
            postiDisponibili--;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }
}
