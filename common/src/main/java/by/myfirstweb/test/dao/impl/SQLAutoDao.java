package by.myfirstweb.test.dao.impl;

import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.connection_pool.ConnectionPool;
import by.myfirstweb.test.dao.connection_pool.ConnectionPoolException;
import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.domain.to.AutoReq;
import by.myfirstweb.test.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLAutoDao implements AutoDao {

    private static final String AUTO_ID = "autoId";
    private static final String STATUS = "carStatus";
    private static final String PRICEDAY = "priceDay";
    private static final String CAR_BREND = "carBrend";
    private static final String CAR_MODEL = "carModel";
    private static final String COLOR = "color";
    private static final String YEAR = "year";
    private static final String ENGINE = "engine";


    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_AUTOID = "SELECT * FROM auto WHERE autoId = ?";
    private static final String SELECT_ALL__AUTOID = "SELECT * FROM auto";
    private static final String CREATE_CARE = "INSERT INTO auto (autoId, carBrend, carModel, engine, year, color, carStatus, priceDay)" +
            " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";


    private SQLAutoDao() {
    }

    public static AutoDao getInstance() {
        return SingletonHolder.instance;
    }


    public List<Auto> findAll() throws DaoException {
        List<Auto> autoList = new ArrayList<>();
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_ALL__AUTOID)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Auto auto = new Auto();
                auto.setAutoId((long) set.getInt(AUTO_ID));
                auto.setCarStatus(set.getString(STATUS));
                auto.setCarBrend(set.getString(CAR_BREND));
                auto.setCarModel(set.getString(CAR_MODEL));
                auto.setPriceDay((long) set.getInt(PRICEDAY));
                auto.setColor(set.getString(COLOR));
                auto.setEngine(set.getString(ENGINE));
                auto.setYear(set.getString(YEAR));

                autoList.add(auto);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return autoList;
    }

    @Override
    public Auto findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public int create(Auto entity) throws DaoException {
        return 0;
    }

    @Override
    public Long update(Auto entity) throws DaoException {
        return null;
    }

    public Auto findByAutoId(Long id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(SELECT_BY_AUTOID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                Auto auto = new Auto();
                auto.setAutoId((long) set.getInt(AUTO_ID));
                auto.setCarStatus(set.getString(STATUS));
                auto.setCarBrend(set.getString(CAR_BREND));
                auto.setCarModel(set.getString(CAR_MODEL));
                auto.setPriceDay((long) set.getInt(PRICEDAY));
                auto.setColor(set.getString(COLOR));
                auto.setEngine(set.getString(ENGINE));
                auto.setYear(set.getString(YEAR));
                return auto;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean checAuto(Auto status) throws DaoException {
        return false;
    }


    private static class SingletonHolder {
        private static final AutoDao instance = (AutoDao) new SQLAutoDao();
    }
}
