package by.myfirstweb.test.dao.impl;

import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.connection_pool.ConnectionPool;
import by.myfirstweb.test.dao.connection_pool.ConnectionPoolException;
import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.exceptions.DaoException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDao implements UserDAO {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE = "roleId";
    private static final String DRIVERSLICENCE = "driverLicense";
    private static final String USER_ID = "userId";
    private static final String EXPERIENCE = "experience";
    private static final String SURNAME = "surname";
    private static final String USERNAME = "userName";
    private static final String PHONE = "mobilePhone";
    private static final String EMAIL = "email";


    private static final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String SELECT_BY_ID = "SELECT * FROM user WHERE userId = ?";
    private static final String SELECT_BY_LOGINDATA = "SELECT * FROM user WHERE login = ? and password = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String DELETE_USER = "DELETE FROM user WHERE userId = ?";
    private static final String CREATE_USER = "INSERT INTO user ( userName, surname, login, password, sex, mobilePhone, email, status, dateRegistr, driverLicense)" +
            " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE user SET user.email = ?, user.phone = ? " +
            "WHERE user.iduser = ?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as userId";



    private SQLUserDao() {
    }

    public static UserDAO getInstance() {
        return SingletonHolder.instance;
    }

    public User getUserNode(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGINDATA)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                User user = new User();
                user.setLogin(login);
                user.setLogin(password);
                return user;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    private User getUserFromResultSet(ResultSet set) throws DaoException{
        try {
            User user = new User();
            user.setUserId(set.getLong(USER_ID));
            user.setLogin(set.getString(LOGIN));
            user.setPassword(set.getString(PASSWORD));
            //user.setRoleId(set.getInt(ROLE));
            user.setDriverLicense(set.getString(DRIVERSLICENCE));
            user.setExperience(set.getInt(EXPERIENCE));
            return user;

        } catch (SQLException e) {
            throw new DaoException("Exception", e);
        }
    }

    public boolean checkUser(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGINDATA)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                User user = new User();
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
                //
                user.setUserId(set.getLong(USER_ID));
                user.setDriverLicense(set.getString(DRIVERSLICENCE));
                user.setUserName(set.getString(USERNAME));
                user.setSurname(set.getString(SURNAME));
                user.setMobilePhone(set.getString(PHONE));
                user.setEmail(set.getString(EMAIL));

                //user.setRole(set.getString(ROLE));
                userList.add(user);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
        return userList;
    }

    public User findById(Long id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                User user = new User();
                user.setUserId((long) set.getInt(USER_ID));
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
//                user.setRole(set.getString(ROLE));
                return user;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public boolean delete(Long id) throws DaoException {
        return false;
    }

    @Override
    public int create(User user) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(CREATE_USER);
            PreparedStatement statementThird = connect.prepareStatement(LAST_INSERT_ID)) {
            connect.setAutoCommit(false);

//            statement.setString(1, String.valueOf(user.getUserId()));
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getSex() !=null ?String.valueOf(user.getSex()): "M");
            statement.setString(6, user.getMobilePhone());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getStatus());
            statement.setString(9, user.getDateRegistr() != null ? String.valueOf(user.getDateRegistr()):null);
            statement.setString(10, user.getDriverLicense());
            statement.executeUpdate();
            connect.commit();



            ResultSet set = statementThird.executeQuery();
            set.next();
            return set.getInt(USER_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    public Long update(User entity) throws DaoException {
        return null;
    }

    private static class SingletonHolder {
        private static final UserDAO instance = new SQLUserDao();
    }


}


