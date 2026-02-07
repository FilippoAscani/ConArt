package demo.conart.model.dao.spectator;

import demo.conart.exception.DBConnectionException;
import demo.conart.model.entity.Spectator;
import demo.conart.other.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SpectatorDaoDb implements SpectatorDao {

    /*
     *classe per la gestione dei dati dell'utente come registrazione sia su db sia su csv
     * quindi anche inserimento ed eliminazione e ricerca
     */

    public SpectatorDaoDb() {
        //costruttore vuoto
    }


    @Override
    public ArrayList<Spectator> getSpectators() {
        ArrayList<Spectator> spectators = new ArrayList<>();
        String sql = "select"+" * from spectators";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){
                Spectator spectator = new Spectator();
                spectator.setUsername(rs.getString("username"));
                spectator.setEmail(rs.getString("email"));

                spectators.add(spectator);
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile trovare spettatore", e);
        }
        return spectators;
    }

    //due modi uno passa l'id e l'altro passa un utente e poi fa getId
    @Override
    public Spectator getSpectator(int id) {
        String sql = "select *"+ " from Spectators where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Spectator spectator = new Spectator();
                spectator.setEmail(rs.getString("email"));
                spectator.setUsername(rs.getString("username"));
                return spectator;
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile ottenere spettatore", e);
        }
        return null;
    }







    @Override
    public boolean addSpectator(Spectator spectator) {
        String sql = "insert into Spectators (spectatorname, email) values (?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, spectator.getUsername());
            ps.setString(2, spectator.getEmail());
            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile aggiungere spettatore", e);
        }


    }


    @Override
    public boolean updateSpectator(Spectator spectator) {
        String sql = "update Spectators set Spectatorname = ?, email = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,spectator.getUsername());
            ps.setString(2, spectator.getEmail());

            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile aggiornare spettatore", e);
        }


    }










    @Override
    public boolean deleteSpectator(int id) {
        String sql = "delete from Spectators where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;
        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile cancellare spettatore", e);
        }


    }


    @Override
    public boolean exists(String username, String password) {
        String sql =  "SELECT 1 FROM Spectators WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException | DBConnectionException e) {
            throw new IllegalStateException("Impossibile trovare spettatore", e);

        }

    }
}
