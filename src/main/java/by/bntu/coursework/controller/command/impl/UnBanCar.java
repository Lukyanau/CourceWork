package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UnBanCar implements Command {

    private final CarServiceImpl carService= CarServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        int carId = Integer.parseInt(request.getParameter("carId"));
        String pagePath;
        try{
            carService.unBan(carId);
            request.setAttribute("message","Car was successfully banned");
            pagePath = PagePath.NOTIFICATION;
        }catch(ServiceException exp){
            pagePath = PagePath.ERROR;
        }
        return pagePath;
    }
}
