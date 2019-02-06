package by.myfirstweb.test.service.impl;

import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.factory.DaoFactory;
import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.exceptions.DaoException;
import by.myfirstweb.test.exceptions.NoSuchEntityException;
import by.myfirstweb.test.service.validator.LoginValidator;
import by.myfirstweb.test.service.validator.ValidationException;
import by.myfirstweb.test.service.validator.ValidatorInterface;
import com.google.protobuf.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final DaoFactory factory = DaoFactory.getDaoFactory();
    private static final ValidatorInterface<User> VALIDATE = LoginValidator.getInstance();

    private UserServiceImpl(){}

    public static UserService getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public User loadById(User userId) throws ServiceException, NoSuchEntityException {
        return null;
    }


    @Override
    public User create(User obj) throws ServiceException {
        UserDAO userDao = factory.getUserDao();
        try {
            obj.setUserId(new Long(userDao.create(obj)));
        } catch (DaoException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
        return obj;
    }

//    @Override
//    public List<User> loadAll() throws ServiceException {
//        return null;
//    }
    @Override
    public List<User> loadAll() {
        UserDAO userDao = factory.getUserDao();
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            return null;
        }
    }


    private static class SingletonHolder {
        private static final UserServiceImpl instance = new UserServiceImpl();
    }


    /**
     * Method check login and password information from some user and get user object if authorization success
     * @param user object, that provides authorization operation
     * @return null if client not exists in system; user object if authorization execute correctly
     * @throws ServiceException
     */
    @Override
    public User authorization(User user) throws ServiceException {
        try {
            UserDAO userDao = factory.getUserDao();

            if(VALIDATE.isValid(user)) {

                String password = user.getPassword();
                String passwordMD5 = DigestUtils.md5Hex(password);
               user.setPassword(password);

                boolean check = userDao.checkUser(user.getLogin(), user.getPassword());
                if (!check) {
                    return null;
                } else {
                    return userDao.getUserNode(user.getLogin(), user.getPassword());
                }
            } else {
                throw new ValidationException("Validation Exception");
            }
        } catch (DaoException e) {
            throw new ServiceException("Service Exception", e);
        }
    }
}