package demo.conart.model.dao.user;

import demo.conart.model.entity.User;

import java.util.ArrayList;

public interface UserDao {

    /*
    user che contiene tutte le operazioni utili sul dao

     */

    public ArrayList<User> getUsers();
    public User getUser(int id);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int id);

}
