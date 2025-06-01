package demo.conart.model;

import demo.conart.model.entity.User;

public interface UserRepository {

    boolean exists(String email);
    User findByEmail(String email);
    void save(User user);

}
