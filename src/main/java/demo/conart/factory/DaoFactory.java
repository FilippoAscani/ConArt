package demo.conart.factory;

import demo.conart.enums.TypesOfPersistenceLayer;
import demo.conart.model.dao.request.RequestDao;
import demo.conart.model.dao.request.RequestDaoCsv;
import demo.conart.model.dao.request.RequestDaoDb;
import demo.conart.model.dao.review.ReviewDao;
import demo.conart.model.dao.review.ReviewDaoCsv;
import demo.conart.model.dao.review.ReviewDaoDb;
import demo.conart.model.dao.show.ShowDao;
import demo.conart.model.dao.show.ShowDaoCsv;
import demo.conart.model.dao.show.ShowDaoDb;


public final class DaoFactory {

        private DaoFactory() {
            // impedisce new DaoFactory()
        }

        public static ReviewDao createReviewDao(TypesOfPersistenceLayer type) {
            switch (type) {
                case JDBC:
                    return new ReviewDaoDb();
                case FS:
                    return new ReviewDaoCsv();
                default:
                    throw new IllegalArgumentException("Persistence type review non supportato");
            }
        }

        public static ShowDao createShowDao(TypesOfPersistenceLayer type) {
            switch (type) {
                case JDBC:
                    return new ShowDaoDb();
                case FS:
                    return new ShowDaoCsv();
                default:
                    throw new IllegalArgumentException("Persistence type show non supportato");
            }
        }

        public static RequestDao createRequestDao(TypesOfPersistenceLayer type) {
            switch (type) {
                case JDBC:
                    return new RequestDaoDb();
                case FS:
                    return new RequestDaoCsv();
                default:
                    throw new IllegalArgumentException("Persistence type request non supportato");
            }
        }



}
