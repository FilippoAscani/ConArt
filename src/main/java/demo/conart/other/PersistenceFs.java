package demo.conart.other;

import demo.conart.bean.BeanLogin;
import demo.conart.model.dao.user.UserDao;
import demo.conart.model.dao.user.UserDaoCsv;

public class PersistenceFs implements PersistenceStrategy {

    private UserDao userDAO = new UserDaoCsv();

    @Override
    public BeanLogin getUserDAO() {
        return userDAO;
    }

}
