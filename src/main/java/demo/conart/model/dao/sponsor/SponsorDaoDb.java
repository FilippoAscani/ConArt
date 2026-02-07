package demo.conart.model.dao.sponsor;

import demo.conart.exception.DBConnectionException;
import demo.conart.model.entity.Sponsor;
import demo.conart.other.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SponsorDaoDb implements SponsorDao {



    @Override
    public ArrayList<Sponsor> getSponsors() {
        ArrayList<Sponsor> sponsors = new ArrayList<>();
        String sql = "select * from sponsors";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){
                Sponsor sponsor = new Sponsor();
                sponsor.setUsername(rs.getString("username"));
                sponsor.setPassword(rs.getString("password"));

                sponsors.add(sponsor);
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile vedere gli sponsor", e);
        }
        return sponsors;
    }

    @Override
    public Sponsor getSponsor(int id) {
        String sql = "select * from sponsors where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Sponsor sponsor = new Sponsor();
                sponsor.setUsername(rs.getString("username"));
                sponsor.setPassword(rs.getString("password"));
                return sponsor;
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile ottenere sponsor", e);
        }
        return null;

    }

    @Override
    public Sponsor getSponsorByUsername(String username) {
        //aggiungere metodo
        return null;
    }








    @Override
    public boolean addSponsor(Sponsor sponsor) {
        String sql = "insert into sponsors (username, password) values (?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sponsor.getUsername());
            ps.setString(2, sponsor.getPassword());
            ps.executeUpdate();

            return true;
        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile aggiungere sponsor", e);
        }


    }














    @Override
    public boolean updateSponsor(Sponsor sponsor) {
        String sql = "update sponsors set username = ?, password = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sponsor.getUsername());
            ps.setString(2, sponsor.getPassword());

            ps.executeUpdate();

            return true;
        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile aggiornare sponsor", e);
        }


    }







    @Override
    public boolean deleteSponsor(int id) {

        String sql = "delete from sponsors where id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;
        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile cancellare sponsor", e);
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
            throw new IllegalStateException("Impossibile trovare sponsor", e);
        }
    }



}
