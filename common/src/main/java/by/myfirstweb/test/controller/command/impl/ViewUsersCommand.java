package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.service.impl.UserService;
import by.myfirstweb.test.service.impl.UserServiceImpl;
import by.myfirstweb.test.dao.UserDAO;
import com.google.protobuf.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewUsersCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";
    private static final UserService SERVICE = UserServiceImpl.getInstance();

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new ViewUsersCommand();
    }

    private  ViewUsersCommand() {
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;

        try {
            page = PagePath.VIEW_USER;
            request.setAttribute("userList", SERVICE.loadAll());
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return page.toString().toLowerCase();
    }

}
