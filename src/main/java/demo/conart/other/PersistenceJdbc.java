package demo.conart.other;

import demo.conart.bean.BeanLogin;
import demo.conart.model.dao.user.UserDaoDb;

public class PersistenceJdbc implements PersistenceStrategy{

        private BeanLogin userDao = new UserDaoDb();

        @Override
        public BeanLogin getUserDAO() {
            return BeanLogin;
        }


}
