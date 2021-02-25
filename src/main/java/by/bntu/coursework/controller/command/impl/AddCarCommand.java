package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.creator.CarCreator;
import by.bntu.coursework.creator.UserCreator;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;
import by.bntu.coursework.service.impl.UserServiceImpl;
import by.bntu.coursework.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

public class AddCarCommand implements Command {

    private final CarServiceImpl carService = CarServiceImpl.getInstance();
    private final CarCreator carCreator = CarCreator.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            String mark = request.getParameter("mark");
            String title = request.getParameter("title");
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int price = Integer.parseInt(request.getParameter("price"));
            carService.add(carCreator.createCar(description, title, color, price, mark));
            request.setAttribute("message", "Car was successfully added to store!");
            page = PagePath.NOTIFICATION;
        } catch (ServiceException exp) {
            System.out.println(exp.getMessage());
            page = PagePath.ERROR;
        }
        return page;
    }
}
