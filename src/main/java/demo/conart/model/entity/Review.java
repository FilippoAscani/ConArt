package demo.conart.model.entity;

public class Review {

    private int id;
    private String commento;
    private int stelle; // 1..5
    private Spectator author;
    private Show show;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    public Spectator getAuthor() {
        return author;
    }

    public void setAuthor(Spectator author) {
        this.author = author;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
