package by.bntu.coursework.validator;

public class CarValidator {
    private static final String TITLE_REGEX = "^[a-zA-Z0-9 -]{3,50}$";
    private static final String DESCRIPTION_REGEX = "^[a-zA-Z ,.]{3,50}$";
    private static final String COLOR_REGEX = "^[a-zA-Z-]{3,50}$";
    private static final String MARK_REGEX = "^[a-zA-Z]+$";
    private static final String PRICE_REGEX = "^[0-9$]+$";

    public static boolean checkTitleInput(String str) {
        return isEmptyOrNull(str) && str.matches(TITLE_REGEX);
    }

    public static boolean checkDescriptionInput(String str) {
        return isEmptyOrNull(str) && str.matches(DESCRIPTION_REGEX);
    }

    public static boolean checkPriceInput(String str) {
        return isEmptyOrNull(str) && str.matches(PRICE_REGEX);
    }

    public static boolean checkColorInput(String str){
        return isEmptyOrNull(str) && str.matches(COLOR_REGEX);
    }

    public static boolean checkMarkInput(String str){
        return isEmptyOrNull(str) && str.matches(MARK_REGEX);
    }

    public static boolean checkAllParameters(String title, String description, String color, String mark, String price){
        return checkTitleInput(title) && checkDescriptionInput(description) && checkPriceInput(price)
                && checkColorInput(color) && checkMarkInput(mark);
    }

    public static boolean isEmptyOrNull(String str) {
        return str != null && !str.isEmpty();
    }



}
