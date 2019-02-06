package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.domain.to.User;
//import by.myfirstweb.test.service.PagesConfigManager;
import by.myfirstweb.test.service.impl.UserService;
import by.myfirstweb.test.service.impl.UserServiceImpl;
import by.myfirstweb.test.service.validator.ValidationException;
import com.google.protobuf.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* Class is designed for the log in in system as administrator or client
        */
public class LoginCommand implements CommandInterface {

    private static final UserService SERVICE = UserServiceImpl.getInstance();
   // private static final PagesConfigManager MANAGER = PagesConfigManager.getInstance();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    //private static final String ADMIN_ROLE = "admin";
    private static final String USER = "uaer";
    //private static final String ERROR_FLAG = "errorFlag";
    //private static final int ERROR_FLAG_VALUE = 1;
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

    /* Method performs the procedure for authorization in system
     * In first, getting login and password parameters from request
     * Then finding node with equals parameters. If procedure return not null, then necessary define client or admin
     * log in. According to role of user creating admin or client object and put into session.
     *
     * Also determines what action must be made for transition(forward or sendRedirect)
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException if authorization method process fail
     */
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
               // request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);// одна из реализаций эрор меседжа
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.REGISTRATION;
            } else {
//                if (user.getRoles().equals(ADMIN_ROLE)) {
//                    session.setAttribute(CLIENT_ROLE, user);
//                    page = PagePath.RESULT;
//                }
                page = PagePath.ADMIN;
                session.setAttribute(USER, user);
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            }
            return page.toString().toLowerCase();

    }
}