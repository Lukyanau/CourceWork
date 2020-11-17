package by.bntu.coursework.controller.command;

import by.bntu.coursework.controller.command.impl.*;

public enum CommandType {
    PASSING_SIGN_IN(new PassingToSignInCommand(), "passing_sign_in"),
    PASSING_REGISTRATION(new PassingToRegistrationCommand(), "passing_registration"),
    PASSING_ABOUT_US(new PassingToAboutUs(),"passing_about_us"),
    PASSING_HOME(new PassingToHomeCommand(),"passing_home"),
    SIGN_UP(new SignUpCommand(),"sign_up"),
    SIGN_IN(new SignInCommand(), "sign_in");

    private final Command command;
    private final String nameCommand;

    CommandType(Command command, String nameCommand) {
        this.command = command;
        this.nameCommand = nameCommand;
    }

    public Command getCommand() {
        return command;
    }

    public String getNameCommand() {
        return nameCommand;
    }
}
