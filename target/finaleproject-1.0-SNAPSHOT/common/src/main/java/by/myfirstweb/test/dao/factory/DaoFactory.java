package by.myfirstweb.test.dao.factory;

import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.AutoDao;
public abstract class DaoFactory {
    public static DaoFactory getDaoFactory() {
        return SQLDaoFactory.getInstance();
    }

    public abstract UserDAO getUserDao();
    public abstract AutoDao getAutoDao();
//  public abstract RoomDao getRoomDao();
//  public abstract ClientDao getClientDao();
//  public abstract ReservationDao getReservationDao();
//  public abstract ApplicationDao getApplicationDao();
//  public abstract PaymentDao getPaymentDao();
}