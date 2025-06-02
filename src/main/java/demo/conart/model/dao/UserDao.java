package demo.conart.model.dao;

import demo.conart.model.entity.User;

import java.util.ArrayList;

public interface UserDao {

    /*
    user che contiene tutte le operazioni utili sul dao

     */

    public ArrayList<User> getSponsors();
    public User getSponsor(int id);
    public boolean addSponsor(User user);
    public boolean updateSponsor(User user);
    public boolean deleteSponsor(int id);

}
