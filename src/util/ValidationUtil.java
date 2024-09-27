package util;

public class ValidationUtil {

    public static boolean validateCarData(String model, int power, int year) {
        return model != null && !model.isEmpty() && power > 0 && year > 1885;
    }

    public static boolean validateBookData(String author, String title, int pages) {
        return author != null && !author.isEmpty() && title != null && !title.isEmpty() && pages > 0;
    }

    public static boolean validateRootCropData(String type, int weight, String color) {
        return type != null && !type.isEmpty() && weight > 0 && color != null && !color.isEmpty();
    }
}