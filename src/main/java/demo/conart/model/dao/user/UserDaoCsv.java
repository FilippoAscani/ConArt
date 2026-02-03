package demo.conart.model.dao.user;

import demo.conart.bean.BeanLogin;

import java.util.HashMap;
import java.util.Map;

public class UserDaoCsv implements UserDao {

    private static Map<String, BeanLogin> fileStorage = new HashMap<>();

    @Override
    public void salva(BeanLogin user) {
        fileStorage.put(user.getUsername(), user);
        System.out.println("Salvato su CSV: " + user);
    }

    @Override
    public BeanLogin carica(String username) {
        System.out.println("Caricato da CSV: " + username);
        return fileStorage.get(username);
    }

}
