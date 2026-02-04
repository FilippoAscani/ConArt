package demo.conart.other;

import demo.conart.bean.BeanLogin;
import demo.conart.model.dao.user.UserDao;

public interface PersistenceStrategy {

        UserDao getUserDAO();

}
