package demo.conart.model;

import demo.conart.model.entity.User;

public class AuthService {

    /*
    authservice si dovrebbe occupare dell'autenticazione login o registrazione senza sapere dove sono
    inseriti i dati
     */

    private UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    public boolean register(String email, String password) {
        if (repo.exists(email)){
            return false;
        }
        User user = new User();
        user.setUsername(email);
        user.setPassword(password);
        repo.save(user);
        return true;
    }

    public boolean login(String email, String password) {
        User user = repo.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }



}
