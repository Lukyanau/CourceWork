package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;
import by.bntu.coursework.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class PassingToAboutUs  implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.PASSING_ABOUT_US;
    }
}
