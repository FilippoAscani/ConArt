package demo.conart.model;

import demo.conart.model.entity.Spectator;

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
        Spectator spectator = new Spectator();
        spectator.setUsername(email);
        spectator.setPassword(password);
        repo.save(spectator);
        return true;
    }

    public boolean login(String email, String password) {
        Spectator spectator = repo.findByEmail(email);
        return spectator != null && spectator.getPassword().equals(password);
    }



}
