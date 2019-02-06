package by.myfirstweb.test.dao;

import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.domain.to.AutoReq;
import by.myfirstweb.test.exceptions.DaoException;

import java.util.List;


public interface AutoDao extends GenericDAO <Auto, Long>{

     Auto findByAutoId(Long id) throws DaoException;

     /**
      * Method checks auto status to be present in the database
      *
      * @param status object that will be checks for the presence of in database
      * @return boolean result of operation
      * @throws DaoException
      */
     boolean checAuto(Auto status) throws DaoException;

     /**
      * Method find all nodes fro database which satisfy the conditions of application
      *
      * @param app facility which searches
      * @return list nodes that can be find in database
      * @throws DaoException
      */
     List<Auto> findByAutoReq(AutoReq app) throws DaoException;

}
