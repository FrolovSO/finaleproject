package by.myfirstweb.test.dao;

import by.myfirstweb.test.domain.to.Payment;
import by.myfirstweb.test.exceptions.DaoException;

import java.sql.Date;

public interface PaymentDao extends GenericDAO<Payment, Integer> {
    /**
     *
     * @return
     * @throws DaoException
     */
    double getAllTimeIncome() throws DaoException;

    /**
     *
     * @param dateFrom
     * @param dateTo
     * @return
     * @throws DaoException
     */
    double getPeriodIncome(Date dateFrom, Date dateTo) throws DaoException;
}
