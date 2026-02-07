package demo.conart.model.dao.artist;

import demo.conart.exception.DBConnectionException;
import demo.conart.model.entity.Artist;
import demo.conart.other.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistDaoDb implements ArtistDao{


    @Override
    public ArrayList<Artist> getArtists() {
        ArrayList<Artist> artists = new ArrayList<>();
        String sql = "select *" + " from artist";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){
                Artist artist = new Artist();
                artist.setUsername(rs.getString("username"));
                artist.setPassword(rs.getString("password"));

                artists.add(artist);
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile visualizzare artisti", e);
        }
        return artists;
    }

    @Override
    public Artist getArtist(int id) {
        String sql = "select *" + " from artist where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Artist artist = new Artist();
                artist.setUsername(rs.getString("username"));
                artist.setPassword(rs.getString("password"));

                return artist;
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile visualizzare artista", e);
        }
        return null;

    }











    @Override
    public Artist getArtistByUsername(String username) {
        String sql = "select *" + " from artist where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Artist artist = new Artist();
                artist.setUsername(rs.getString("username"));
                artist.setPassword(rs.getString("password"));

                return artist;
            }

        }
        catch(SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile visualizzare artista", e);
        }
        return null;

    }





















    @Override
    public boolean addArtist(Artist artist) {
        String sql = "insert into artist (username, password) values (?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, artist.getUsername());
            ps.setString(2, artist.getPassword());
            ps.executeUpdate();

            return true;
        }
        catch (SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile visualizzare artista", e);
        }
        
    }












    @Override
    public boolean updateArtist(Artist artist) {
        String sql = "UPDATE artist SET username = ?, password = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, artist.getUsername());
            ps.setString(2, artist.getPassword());
            ps.setInt(3, artist.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException | DBConnectionException e) {
            throw new IllegalStateException("Impossibile aggiornare artista", e);
        }
    }







    @Override
    public boolean deleteArtist(int id) {
        String sql = "delete from artist where id = ?";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        }
        catch (SQLException | DBConnectionException e){
            throw new IllegalStateException("Impossibile cancellare artista", e);
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
            throw new IllegalStateException("Impossibile trovare artista ", e);

        }
    }








}
