package by.myfirstweb.test;

import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.connection_pool.ConnectionPool;
import by.myfirstweb.test.dao.connection_pool.ConnectionPoolException;
import by.myfirstweb.test.dao.factory.DaoFactory;
import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.exceptions.DaoException;


public class Test {
    public static void main(String[] args) throws ConnectionPoolException {
        ConnectionPool.getInstance().init();
//        DaoFactory factory = DaoFactory.getDaoFactory();
//        UserDAO userDao = factory.getUserDao();
//        try {
//            User user = userDao.findById(1L);
//            System.out.println(((User) user).getLogin());
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
        DaoFactory factory = DaoFactory.getDaoFactory();
        UserDAO userDao = factory.getUserDao();

        try {
//            Object f = userDao.findById(1L);
//            System.out.println(f);
            Object f1 = userDao.checkUser("Sergey", "password");
            System.out.println(f1);
            Object f3 = userDao.checkUser("werewr", "12345");
            System.out.println(f3);
            Object f2 = userDao.getUserNode("asdasd", "1234");

            System.out.println(f2);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        DaoFactory factoryA = DaoFactory.getDaoFactory();
        AutoDao autoDao = factoryA.getAutoDao();
        try {
            Auto auto = autoDao.findByAutoId(1L);
            System.out.print(auto.getAutoId()+ " " + auto.getCarBrend()+ " " + auto.getCarModel() + " " + auto.getCarStatus()+ " " + auto.getColor() + " " + auto.getEngine()+ " " + auto.getYear() + " " + auto.getPriceDay());
            System.out.println(" ");

        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
