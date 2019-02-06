package by.myfirstweb.test.dao;

import by.myfirstweb.test.domain.to.AutoReq;
import by.myfirstweb.test.exceptions.DaoException;

import java.util.List;


public interface AutoReqDao extends GenericDAO <AutoReq, Integer> {
        /**
         * Method give list clients applications
         *
         * @param clientId unique client number
         * @return List client's applications from database
         * @throws DaoException
         */
        List<AutoReq> getClientAutoReq(int clientId) throws DaoException;
    }

