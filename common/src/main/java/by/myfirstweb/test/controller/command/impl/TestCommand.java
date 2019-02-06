package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.UserDAO;
import by.myfirstweb.test.dao.factory.DaoFactory;
import by.myfirstweb.test.exceptions.DaoException;
import by.myfirstweb.test.service.impl.UserService;
import by.myfirstweb.test.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class TestCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
   // private static final UserService SERVICE = UserServiceImpl.getInstance();

    private TestCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Method performs the procedure for adding hotel room information on page and further viewing and updating
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when getting all nodes fail
     */
//    @Override
//   // "testList", Arrays.asList(DaoFactory.getDaoFactory().getUserDao().getUserNode("serget","password"))
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
//        PagePath page = null;
//
//        DaoFactory factory = DaoFactory.getDaoFactory();
//        AutoDao autoDao = factory.getAutoDao();
//        try {
//            page = PagePath.ADMIN;
//            request.setAttribute("testList", Arrays.asList(autoDao.findByAutoId(1L)));
//        } catch (DaoException e) {
////            e.printStackTrace();
//        }
//        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
//
//        return page.toString().toLowerCase();
//    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        DaoFactory factoryA = DaoFactory.getDaoFactory();
        AutoDao autoDao = factoryA.getAutoDao();
        try {
            page = PagePath.ADMIN;
            request.setAttribute("testList", Arrays.asList(autoDao.findByAutoId(1L)));
        } catch (DaoException e) {
            e.printStackTrace();
        }

        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
       return page.toString().toLowerCase();
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new TestCommand();
    }
}
