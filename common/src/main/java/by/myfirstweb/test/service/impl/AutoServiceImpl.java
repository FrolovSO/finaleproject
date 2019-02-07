package by.myfirstweb.test.service.impl;

import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.factory.DaoFactory;
import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.exceptions.DaoException;
import by.myfirstweb.test.service.validator.ServiceException;

import java.util.List;

public class AutoServiceImpl implements AutoService {
    private static final DaoFactory factoryB = DaoFactory.getDaoFactory();

    public AutoServiceImpl() {
    }
    public static AutoService getInstance() {
        return AutoServiceImpl.SingletonHolder.instance;
    }

    @Override
    public Auto create(Auto entity) throws com.google.protobuf.ServiceException {
        return null;
    }

    @Override
    public List<Auto> loadAll() throws com.google.protobuf.ServiceException {
        return null;
    }

    private static class SingletonHolder {
        private static final AutoServiceImpl instance = new AutoServiceImpl();
    }
    @Override
    public Auto createAuto(Auto obj) throws ServiceException {
        AutoDao autoDao = factoryB.getAutoDao();
        try {
            obj.setAutoId(new Long(autoDao.createAuto(obj)));
        } catch (DaoException e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
        return obj;
    }
}
