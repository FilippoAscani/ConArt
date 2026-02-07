package demo.conart.model.dao.spectator;

import demo.conart.model.entity.Spectator;

import java.util.List;

public interface SpectatorDao {

    /*
    Spectator che contiene tutte le operazioni utili sul dao

     */

    public List<Spectator> getSpectators();
    public Spectator getSpectator(int id);
    public boolean addSpectator(Spectator spectator);
    public boolean updateSpectator(Spectator spectator);
    public boolean deleteSpectator(int id);
    public boolean exists(String username, String password);
    public Spectator getSpectatorByUsername(String username);

}
