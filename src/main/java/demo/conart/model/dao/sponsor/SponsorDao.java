package demo.conart.model.dao.sponsor;

import demo.conart.model.entity.Sponsor;

import java.util.List;

public interface SponsorDao {

    /*
     * interfaccia per elencare i metodi di registrazione sullo sponsor
     * metodi standard con arraylist e booleani definiti
     */

    public List<Sponsor> getSponsors();
    public Sponsor getSponsor(int id);
    public boolean addSponsor(Sponsor sponsor);
    public boolean updateSponsor(Sponsor sponsor);
    public boolean deleteSponsor(int id);
    public boolean exists(String username, String password);
    public Sponsor getSponsorByUsername(String username);
}
