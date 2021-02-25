package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PassingToAdminCatalog implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        CarServiceImpl service = CarServiceImpl.getInstance();
        HttpSession session = request.getSession();
        String pagePath;
        try{
            List<Car> cars = service.findAll();
            session.setAttribute("cars",cars);
            pagePath = PagePath.PASSING_ADMIN_CATALOG;
        } catch (ServiceException exp) {
            pagePath = PagePath.ERROR;
        }
        return pagePath;
    }
}
