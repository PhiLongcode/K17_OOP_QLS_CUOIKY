package ui;

import controller.TimKiemSachControl;
import entity.Sach;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TimTKSCUI {
    private PrintStream screenOutput; // In ra màn hình
    private Scanner keyBoardInput; // Nhận input từ bàn phím
    private TimKiemSachControl timKiemSachControl; // Đối tượng điều khiển logic tìm kiếm

    // Constructor
    public TimTKSCUI(PrintStream screenOutput, Scanner keyBoardInput, TimKiemSachControl timKiemSachControl) {
        this.screenOutput = screenOutput;
        this.keyBoardInput = keyBoardInput;
        this.timKiemSachControl = timKiemSachControl;
    }

    // Phương thức chính để thực hiện tìm kiếm
    public void timKiemSach() {
        screenOutput.print("Nhập lựa chọn tìm kiếm (1: theo NXB, 2: theo mã sách, 3: theo loại sách tham khảo): ");
        try {
            int luaChon = Integer.parseInt(keyBoardInput.nextLine());

            switch (luaChon) {
                case 1:
                    timKiemTheoNXB();
                    break;
                case 2:
                    timKiemTheoMaSach();
                    break;
                case 3:
                    timKiemTheoThamKhao();
                    break;
                default:
                    screenOutput.println("Lựa chọn không hợp lệ.");
            }
        } catch (NumberFormatException e) {
            screenOutput.println("Vui lòng nhập số.");
        }
    }

    private void timKiemTheoNXB() {
        screenOutput.print("Nhập NXB: ");
        String nhaXuatBan = keyBoardInput.nextLine();
        ArrayList<Sach> dsSachTheoNXB = timKiemSachControl.timSachTheoNXB(nhaXuatBan);
        hienThiDanhSachSach(dsSachTheoNXB);
    }

    private void timKiemTheoMaSach() {
        screenOutput.print("Nhập mã sách: ");
        String maSach = keyBoardInput.nextLine();
        Sach sachTheoMa = timKiemSachControl.timSachTheoMaSach(maSach);
        if (sachTheoMa != null) {
            screenOutput.println(sachTheoMa);
        } else {
            screenOutput.println("Không tìm thấy sách với mã " + maSach);
        }
    }
    private void timKiemTheoThamKhao() {
        screenOutput.print("Bạn muốn tìm sách tham khảo? (true/false): ");
        try{
            boolean thamKhao = Boolean.parseBoolean(keyBoardInput.nextLine());
            ArrayList<Sach> dsSachThamKhao = timKiemSachControl.timSachThamKhao(thamKhao);
            hienThiDanhSachSach(dsSachThamKhao);
        }catch (Exception e){
            screenOutput.println("Bạn cần nhập true hoặc false");
        }

    }

    // Phương thức hiển thị danh sách sách
    private void hienThiDanhSachSach(ArrayList<Sach> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) { // Kiểm tra danh sách null hoặc rỗng
            screenOutput.println("Không tìm thấy sách nào.");
        } else {
            screenOutput.println("Kết quả tìm kiếm:");
            for (Sach sach : danhSach) {
                screenOutput.println(sach); // In thông tin sách (đã sử dụng toString() trong lớp Sach)
            }
        }
    }
}