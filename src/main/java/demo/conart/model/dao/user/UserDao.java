package demo.conart.model.dao.user;

import demo.conart.bean.BeanLogin;

public interface UserDao {

    void salva(BeanLogin user);
    BeanLogin carica(String username);
}
