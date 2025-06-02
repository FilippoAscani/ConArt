package demo.conart.model.dao.user;

import demo.conart.exception.DBConnectionException;
import demo.conart.model.entity.User;
import demo.conart.other.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDaoDb implements UserDao {

    /*
     *classe per la gestione dei dati dell'utente come registrazione sia su db sia su csv
     * quindi anche inserimento ed eliminazione e ricerca
     */

    public UserDaoDb() {

    }


    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "select * from users";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){


            while(rs.next()){
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));

                users.add(user);
            }

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
        return users;
    }

    //due modi uno passa l'id e l'altro passa un utente e poi fa getId
    @Override
    public User getUser(int id) {
        String sql = "select * from users where id = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                return user;
            }

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }
        return null;
    }







    @Override
    public boolean addUser(User user) {
        String sql = "insert into users (username, email) values (?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean updateUser(User user) {
        String sql = "update users set username = ?, email = ?";

        try(Connection conn = DatabaseConnection.getInstance().getConnection();
           PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1,user.getUsername());
            ps.setString(2, user.getEmail());

            ps.executeUpdate();

            return true;

        }
        catch(SQLException | DBConnectionException e){
            e.printStackTrace();
        }

        return false;
    }










    @Override
    public boolean deleteUser(int id) {
        String sql = "delete from users where id = ?";

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
