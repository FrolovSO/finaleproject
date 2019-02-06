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
import java.util.Date;

/* Class is designed for the registration of a new client*/
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
    //private static final Date DATE_REGISTR = "dateRegistr";
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


    /* Method performs the procedure for adding a new customer to the system.
            * Getting all information about new client and then create new node in system.
   * Also determines what action must be made for transition(forward or sendRedirect).
            *
            * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return the path to go to a specific page
     * @throws CommandException when creating fail
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        PagePath page = null;
        try {
            String mobilePhone = request.getParameter(MOBILE_PHONE);
            String name = request.getParameter(NAME_ATTRIBUTE);
            String surname = request.getParameter(SURNAME_ATTRIBUTE);
            //Date dateRegistr = request.getParameter(DATE_REGISTR);
            String email = request.getParameter(EMAIL);
            //String role = USER_ROLE;
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
            //user.setRole(role);
            //user.setDateRegistr(dateRegistr);


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
