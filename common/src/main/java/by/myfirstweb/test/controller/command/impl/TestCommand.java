package by.myfirstweb.test.controller.command.impl;
import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.dao.AutoDao;
import by.myfirstweb.test.dao.factory.DaoFactory;
import by.myfirstweb.test.exceptions.DaoException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class TestCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";


    private TestCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        DaoFactory factoryA = DaoFactory.getDaoFactory();
        AutoDao autoDao = factoryA.getAutoDao();
        try {
            page = PagePath.ADMIN;
            //request.setAttribute("testList", Arrays.asList(autoDao.findByAutoId(1L)));
            request.setAttribute("autoList", autoDao.findAll());
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
