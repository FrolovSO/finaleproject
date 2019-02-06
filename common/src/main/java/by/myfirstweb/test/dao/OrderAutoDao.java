package by.myfirstweb.test.dao;
import by.myfirstweb.test.domain.to.AutoReq;
import by.myfirstweb.test.domain.to.OrderAuto;
import by.myfirstweb.test.exceptions.DaoException;

public interface OrderAutoDao extends GenericDAO <OrderAuto, Long>{

    //OrderAuto createOrder(Long id) throws DaoException;

    //public boolean addReservation(Reservation reserv) throws DaoException; на сервисе установить айдишник комнаты для резервации

    /**
     * Method checks hotel room to be present in the database
     *
     * @param app object that necessary fo finding hotel room
     * @return boolean result of operations
     * @throws DaoException
     */
    boolean checkAutoInOrder(AutoReq app) throws DaoException;

    /**
     * Method find client's reservations by unique numbers of application
     * @param appId application unique number
     * @return reservation by one of application
     * @throws DaoException
     */
    OrderAuto findByAutoReqId(int appId) throws DaoException;
}
