package ui;

import java.io.PrintWriter;
import java.util.Scanner;

import helper.Valid;

public class ValidCUI {
    private static PrintWriter screenOutput = null;
    private static Scanner keyBoardInput = null;

    // Constructor để khởi tạo screenOutput và keyBoardInput
    public static void init(PrintWriter output, Scanner input) {
        screenOutput = output;
        keyBoardInput = input;
    }

    public static double getNumberInput(String message) {
        while (true) {
            screenOutput.print(message);
            screenOutput.flush();
            String input = keyBoardInput.nextLine();
            if (Valid.isNumber(input)) {
                return Double.parseDouble(input);
            } else {
                screenOutput.println("Error: Phai la so . Vui Long Nhap Lai!");
                screenOutput.flush();
            }
        }
    }

    
    public static double getSoDuongInput(String message) {
        while (true) {
            double number = getNumberInput(message);
            if (number > 0) {
                return number;
            } else {
                screenOutput.println("Error: Phai la so duong. Vui Long Nhap Lai!");
                screenOutput.flush();
            }
        }
    }

    public static String getNgayInput(String message, String format) {
        while (true) {
            screenOutput.print(message);
            screenOutput.flush();
            String input = keyBoardInput.nextLine();
            if (Valid.isNgayHopLe(input, format)) {
                return input;
            } else {
                screenOutput.println("Error: Nhap sai dinh dang: " + format + ".Vui Long Nhap Lai!");
                screenOutput.flush();
            }
        }
    }

    public static String getEmptyInput(String message) {
        while (true) {
            screenOutput.print(message);
            screenOutput.flush();
            String input = keyBoardInput.nextLine();
            if (Valid.isNotEmpty(input)) {
                return input;
            } else {
                screenOutput.println("Error: Khong duoc de trong. Vui Long Nhap Lai!");
                screenOutput.flush();
            }
        }
    }
}
