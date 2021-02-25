package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class BuyCar implements Command {
    CarServiceImpl carService = CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        int carId = Integer.parseInt(request.getParameter("carId"));
        try {
            carService.ban(carId);
            request.setAttribute("message", "You successfully buy a new car, our congratulations");
            page = PagePath.NOTIFICATION;
        } catch (ServiceException exp) {
            page = PagePath.ERROR;
        }
        return page;
    }
}
