package by.myfirstweb.test.controller.command.impl;
import by.myfirstweb.test.controller.command.CommandException;
import by.myfirstweb.test.controller.command.CommandInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCommand implements CommandInterface {
    private static final String ACTION = "action";
    private static final String FORWARD_ACTION_ATTRIBUTE = "forward";

    public static CommandInterface getInstance() {
        return ViewCommand.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final CommandInterface INSTANCE = new ViewCommand();
    }

    public ViewCommand() {
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        PagePath page = null;
        page = PagePath.CREATE_CAR;
        request.setAttribute(ACTION, FORWARD_ACTION_ATTRIBUTE);
        return page.toString().toLowerCase();
    }
}
