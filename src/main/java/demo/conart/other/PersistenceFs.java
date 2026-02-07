package demo.conart.other;


import demo.conart.model.dao.user.UserDao;
import demo.conart.model.dao.user.UserDaoCsv;

public class PersistenceFs implements PersistenceStrategy {

    private UserDao userDAO = new UserDaoCsv();

    @Override
    public UserDao getUserDAO() {
        return userDAO;
    }

}
