package ui;

import java.io.PrintWriter;
import java.util.Scanner;

public class XoaSachCUI {
    private PrintWriter screenOutput;

    public XoaSachCUI(PrintWriter pWriterRemote) {
        this.screenOutput = new PrintWriter(System.out, true);
    }

    public String nhapMaSach() {
        Scanner scanner = new Scanner(System.in);
        screenOutput.println("Nhập mã sách cần xóa: ");
        return scanner.nextLine().trim();
    }

    public void thongBaoKetQua(String maSach, boolean daXoa) {
        if (daXoa) {
            screenOutput.println("Đã xóa sách với mã sách: " + maSach);
        } else {
            screenOutput.println("Không tìm thấy sách với mã sách: " + maSach);
        }
    }
}