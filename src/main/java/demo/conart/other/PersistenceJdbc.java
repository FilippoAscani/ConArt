package demo.conart.other;


import demo.conart.model.dao.user.UserDao;
import demo.conart.model.dao.user.UserDaoDb;

public class PersistenceJdbc implements PersistenceStrategy{

        private UserDao userDao = new UserDaoDb();

        @Override
        public UserDao getUserDAO() {
            return userDao;
        }


}
