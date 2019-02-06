package by.myfirstweb.test.service.impl;

import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.exceptions.NoSuchEntityException;
import com.google.protobuf.ServiceException;

public interface UserService extends GenericServiceInterface <User, User> {
    User loadById(User userId) throws ServiceException, NoSuchEntityException;
    /**
     * Method provides operation for login user
     *
     * @param user object, that provides authorization operation
     * @return {@link User} - login record
     * @throws ServiceException
     */
    User authorization(User user) throws ServiceException;
}
