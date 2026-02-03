package demo.conart.model;

import demo.conart.model.entity.Spectator;


public interface UserRepository {

    boolean exists(String email);
    Spectator findByEmail(String email);
    void save(Spectator user);

}
