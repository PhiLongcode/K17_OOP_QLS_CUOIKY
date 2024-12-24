package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Valid {
	//Kiem tra la so
    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Kiem tra la so duong
    public static boolean isSoDuong(String input) {
        if (isNumber(input)) {
            double number = Double.parseDouble(input);
            return number > 0;
        }
        return false;
    }

    // Kiem tra ngay hop le
    public static boolean isNgayHopLe(String input, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }	

    // Kiem tra khong bo trong
    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

}
