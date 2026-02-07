package demo.conart.model.dao.user;

import demo.conart.bean.BeanLogin;

import java.util.HashMap;
import java.util.Map;

public class UserDaoDb implements UserDao {

    private static Map<String, BeanLogin> database = new HashMap<>();

    @Override
    public void salva(BeanLogin user) {
        database.put(user.getUsername(), user);

    }

    @Override
    public BeanLogin carica(String username) {
        
        return database.get(username);
    }

}
