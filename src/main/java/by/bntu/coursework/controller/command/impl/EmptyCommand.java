package by.bntu.coursework.controller.command.impl;

import by.bntu.coursework.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
