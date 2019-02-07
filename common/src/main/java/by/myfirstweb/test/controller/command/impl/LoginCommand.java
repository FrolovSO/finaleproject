package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.service.impl.UserService;
import by.myfirstweb.test.service.impl.UserServiceImpl;
import com.google.protobuf.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginCommand implements CommandInterface {

    private static final UserService SERVICE = UserServiceImpl.getInstance();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "uaer";
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private LoginCommand() {
    }

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new LoginCommand();
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        PagePath page = null;

            User tempUser = new User();
            tempUser.setLogin(request.getParameter(LOGIN));
            tempUser.setPassword(request.getParameter(PASSWORD));


            HttpSession session = request.getSession(true);
            User user = null;
            try {
                user = SERVICE.authorization(tempUser);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            if(user == null) {

                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.REGISTRATION;
            } else {
                page = PagePath.ADMIN;
                session.setAttribute(USER, user);
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            }
            return page.toString().toLowerCase();

    }
}