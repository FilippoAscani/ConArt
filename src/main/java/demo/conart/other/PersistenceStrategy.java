package demo.conart.other;


import demo.conart.model.dao.user.UserDao;

public interface PersistenceStrategy {

        UserDao getUserDAO();

}
