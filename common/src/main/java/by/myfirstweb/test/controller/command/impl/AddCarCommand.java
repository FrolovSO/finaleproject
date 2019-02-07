package by.myfirstweb.test.controller.command.impl;

import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;
import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.service.impl.AutoService;
import by.myfirstweb.test.service.impl.AutoServiceImpl;
import by.myfirstweb.test.service.validator.ServiceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddCarCommand implements CommandInterface {
    private static final AutoService SERVICE = AutoServiceImpl.getInstance();

    private static final String REGISTRATION_NAMBER = "autoId";
    private static final String STATUS ="carStatus";
    private static final String BREND = "carBrend";
    private static final String MODEL = "carModel";
    private static final String ENGINE = "engine";
    private static final String YEAR = "year";
    private static final String COLOR = "color";
    private static final String PRICE = "priceDay";


    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    public static CommandInterface getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new AddCarCommand();
    }
    private AddCarCommand(){}
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        try {
            String autoId = request.getParameter(REGISTRATION_NAMBER);
            String carBrend = request.getParameter(BREND);
            String carModel = request.getParameter(MODEL);
            String carStatus = request.getParameter(STATUS);
            String engine = request.getParameter(ENGINE);
            String year = request.getParameter(YEAR);
            String color = request.getParameter(COLOR);
            String priceDay = request.getParameter(PRICE);

            Auto auto = new Auto();
            auto.setAutoId(Long.valueOf(autoId));
            auto.setCarBrend(carBrend);
            auto.setCarModel(carModel);
            auto.setCarStatus(carStatus);
            auto.setEngine(engine);
            auto.setYear(year);
            auto.setColor(color);
            auto.setPriceDay(Long.valueOf(priceDay));

            Auto newAuto = SERVICE.createAuto(auto);
            if(newAuto == null) {
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
                page = PagePath.ERROR;
            } else {
               // HttpSession session = request.getSession(true);
                page = PagePath.ADMIN;
                request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return page.toString().toLowerCase();
    }
}
