package by.bntu.coursework.controller.command;

import by.bntu.coursework.controller.command.impl.*;

public enum CommandType {
    ADD_CAR(new AddCarCommand(),"add_car"),
    NOTIFICATION(new PassingToNotification(),"passing_notification"),
    PASSING_ADMIN_CATALOG(new PassingToAdminCatalog(),"passing_admin_catalog"),
    PASSING_USER_CATALOG(new PassingToUserCatalog(),"passing_user_catalog"),
    LOG_OUT(new LogOut(),"log_out"),
    BAN_CAR(new BanCar(),"ban_car"),
    UNBAN_CAR(new UnBanCar(),"unBan_car"),
    BUY_CAR(new BuyCar(),"buy_car"),
    PASSING_SIGN_IN(new PassingToSignInCommand(), "passing_sign_in"),
    PASSING_REGISTRATION(new PassingToRegistrationCommand(), "passing_registration"),
    PASSING_ABOUT_US(new PassingToAboutUs(),"passing_about_us"),
    PASSING_HOME(new PassingToHomeCommand(),"passing_home"),
    SIGN_UP(new SignUpCommand(),"sign_up"),
    SIGN_IN(new SignInCommand(), "sign_in"),
    PASSING_ADMIN_PAGE(new PassingToAdminPage(), "passing_admin_page"),
    PASSING_ADMIN_ADD_CAR(new PassingToAdminAddCar(), "passing_admin_add_car"),
    PASSING_PURCHASE(new PassingToPurchase(), "passing_purchase");

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
