package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PassingToUserCatalog implements Command {
    private static final String DEFAULT_MARK_VALUE = "all";

    @Override
    public String execute(HttpServletRequest request) {
        CarServiceImpl service = CarServiceImpl.getInstance();
        HttpSession session = request.getSession();
        String pagePath;
        try {
            String mark = request.getParameter("mark");
            if (mark == null) {
                mark = DEFAULT_MARK_VALUE;
            }
            List<Car> cars = service.findActiveCars(mark);
            session.setAttribute("cars", cars);
            pagePath = PagePath.PASSING_USER_CATALOG;
        } catch (ServiceException exp) {
            pagePath = PagePath.ERROR;
        }
        return pagePath;
    }
}
