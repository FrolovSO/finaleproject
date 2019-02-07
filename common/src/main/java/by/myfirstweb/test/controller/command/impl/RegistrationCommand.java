package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.domain.to.User;
import by.myfirstweb.test.service.impl.UserService;
import by.myfirstweb.test.service.impl.UserServiceImpl;
import by.myfirstweb.test.service.validator.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RegistrationCommand implements CommandInterface {
    private static final UserService SERVICE = UserServiceImpl.getInstance();


   private static final String CLIENT_ROLE = "user";

    private static final String MOBILE_PHONE = "mobilePhone";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String EMAIL = "email";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String DRIVER_LICENSE = "driverLicense";
    private static final String ACTION = "action";
    private static final String REDIRECT_ACTION_ATTRIBUTE = "redirect";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    private static final String ERROR_FLAG = "errorFlag";
    private static final int ERROR_FLAG_VALUE = 1;
    private static final int ERROR_FLAG_VALUE_2 = 2;

    private RegistrationCommand(){}

    public static CommandInterface getInstance(){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new RegistrationCommand();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        PagePath page = null;
        try {
            String mobilePhone = request.getParameter(MOBILE_PHONE);
            String name = request.getParameter(NAME_ATTRIBUTE);
            String surname = request.getParameter(SURNAME_ATTRIBUTE);
            String email = request.getParameter(EMAIL);
            String driverLicense = request.getParameter(DRIVER_LICENSE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setUserName(name);
            user.setSurname(surname);
            user.setEmail(email);
            user.setMobilePhone(mobilePhone);
            user.setDriverLicense(driverLicense);



            User resultClient = SERVICE.create(user);
            if(resultClient == null) {
                request.setAttribute(ACTION, REDIRECT_ACTION_ATTRIBUTE);
                page = PagePath.ERROR;
            } else {
                HttpSession session = request.getSession(true);
                page = PagePath.ADMIN;
                session.setAttribute(CLIENT_ROLE, resultClient);
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            }
        } catch (ValidationException e) {
            request.setAttribute(ERROR_FLAG, ERROR_FLAG_VALUE);
            request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        } catch (Exception e) {
            throw new CommandException("Command Exception", e);
        }
      return page.toString().toLowerCase();

    }
}
