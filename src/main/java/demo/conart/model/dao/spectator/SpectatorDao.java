package demo.conart.model.dao.spectator;

import demo.conart.model.entity.Spectator;

import java.util.ArrayList;

public interface SpectatorDao {

    /*
    Spectator che contiene tutte le operazioni utili sul dao

     */

    public ArrayList<Spectator> getSpectators();
    public Spectator getSpectator(int id);
    public boolean addSpectator(Spectator Spectator);
    public boolean updateSpectator(Spectator Spectator);
    public boolean deleteSpectator(int id);
    public boolean exists(String username, String password);

}
