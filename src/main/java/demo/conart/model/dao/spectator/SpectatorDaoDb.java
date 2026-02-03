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

    }


    @Override
    public ArrayList<Spectator> getSpectators() {
        ArrayList<Spectator> Spectators = new ArrayList<>();
        String sql = "select * from Spectators";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){
                Spectator Spectator = new Spectator();
                Spectator.setUsername(rs.getString("Spectatorname"));
                Spectator.setEmail(rs.getString("email"));

                Spectators.add(Spectator);
            }

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
        return Spectators;
    }

    //due modi uno passa l'id e l'altro passa un utente e poi fa getId
    @Override
    public Spectator getSpectator(int id) {
        String sql = "select * from Spectators where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Spectator Spectator = new Spectator();
                Spectator.setEmail(rs.getString("email"));
                Spectator.setUsername(rs.getString("Spectatorname"));
                return Spectator;
            }

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
        return null;
    }







    @Override
    public boolean addSpectator(Spectator Spectator) {
        String sql = "insert into Spectators (Spectatorname, email) values (?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Spectator.getUsername());
            ps.setString(2, Spectator.getEmail());
            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean updateSpectator(Spectator Spectator) {
        String sql = "update Spectators set Spectatorname = ?, email = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,Spectator.getUsername());
            ps.setString(2, Spectator.getEmail());

            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }

        return false;
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
            e.printStackTrace();
        }

        return false;
    }

}
