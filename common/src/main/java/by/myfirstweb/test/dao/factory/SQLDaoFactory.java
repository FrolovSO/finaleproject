package by.myfirstweb.test.dao.factory;


import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.impl.SQLAutoDao;
import by.myfirstweb.test.dao.impl.SQLUserDao;

public class SQLDaoFactory extends DaoFactory {

    private static final SQLDaoFactory instance = new SQLDaoFactory();

    private SQLDaoFactory(){}

    public static SQLDaoFactory getInstance(){
        return instance;
    }

    @Override
    public UserDAO getUserDao() {
        return SQLUserDao.getInstance();
    }

    @Override
    public AutoDao getAutoDao() {
        return SQLAutoDao.getInstance();
    }
//
//    @Override
//    public ClientDao getClientDao() {
//        return SQLClientDao.getInstance();
//    }
//
//    @Override
//    public ReservationDao getReservationDao() {
//        return SQLReservationDao.getInstance();
//    }
//
//    @Override
//    public ApplicationDao getApplicationDao() {
//        return SQLApplicationDao.getInstance();
//    }
//
//    @Override
//    public PaymentDao getPaymentDao() {
//        return SQLPaymentDao.getInstance();
//    }
}