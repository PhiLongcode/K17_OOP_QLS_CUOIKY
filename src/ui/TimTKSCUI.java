package ui;

import controller.TimKiemSachControl;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TimTKSCUI {
    private PrintWriter screenOutput; // In ra màn hình
    private Scanner keyBoardInput; // Nhận input từ bàn phím
    private TimKiemSachControl timKiemSachControl; // Đối tượng điều khiển logic tìm kiếm
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    // Constructor
    public TimTKSCUI(PrintWriter pWriterRemote, Scanner keyBoardInput, TimKiemSachControl timKiemSachControl) {
        this.screenOutput = pWriterRemote;
        this.keyBoardInput = keyBoardInput;
        this.timKiemSachControl = timKiemSachControl;
    }

    // Phương thức chính để thực hiện tìm kiếm
    public void timKiemSach() {
        screenOutput.print("Nhập lựa chọn tìm kiếm (1: theo NXB, 2: theo mã sách, 3: theo loại sách tham khảo): "); screenOutput.flush();
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
            screenOutput.println("Vui lòng nhập số."); screenOutput.flush();
        }
    }

    private void timKiemTheoNXB() {
        screenOutput.print("Nhập NXB: "); screenOutput.flush();
        String nhaXuatBan = keyBoardInput.nextLine().trim();
        ArrayList<Sach> dsSachTheoNXB = timKiemSachControl.timSachTheoNXB(nhaXuatBan);
        if (dsSachTheoNXB.size()>0) {
        hienThiDanhSachSach(dsSachTheoNXB);
        }else {
            screenOutput.println("Không tìm thấy sách với mã " + nhaXuatBan);
        }
    }

    private void timKiemTheoMaSach() {
        screenOutput.print("Nhập mã sách: "); screenOutput.flush();
        String maSach = keyBoardInput.nextLine().trim();
        ArrayList<Sach> sachTheoMa = timKiemSachControl.timSachTheoMaSach(maSach);
        if (sachTheoMa.size()>0) {
        	 hienThiDanhSachSach(sachTheoMa);
        } else {
            screenOutput.println("Không tìm thấy sách với mã " + maSach);
        }
    }
    private void timKiemTheoThamKhao() {  
          
            ArrayList<Sach> dsSachThamKhao = timKiemSachControl.timSachThamKhao("2");
            hienThiDanhSachSach(dsSachThamKhao);
    }

    // Phương thức hiển thị danh sách sách
    public void hienThiDanhSachSach(ArrayList<Sach> dsSach) {
        screenOutput.printf("%-10s %-12s %-17s %-12s %-15s %-14s %-10s %-17s%n",
                "Mã sách", "Ngày Nhập", "Đơn giá", "Số lượng", "Nhà Xuất bản", "Tình Trạng", "Thuế", "Thành tiền");
        screenOutput.println("-------------------------------------------------------------------------------------------------------------");

        for (Sach sach : dsSach) {
            String ngayNhapFormatted = dateFormat.format(sach.getNgayNhap());
            String tinhTrang = "không";
            String thue = "không";

            if (sach instanceof SachGiaoKhoa) {
                SachGiaoKhoa sgk = (SachGiaoKhoa) sach;
                tinhTrang = sgk.isTinhTrang() ? "Mới" : "Cũ";
            } else if (sach instanceof SachThamKhao) {
                SachThamKhao stk = (SachThamKhao) sach;
                thue = String.format("%.2f", stk.getThue());
            }

            screenOutput.printf("%-10s %-12s %-17.2f %-12d %-15s %-14s %-10s %-17s%n",
                    sach.getMaSach(), ngayNhapFormatted, sach.getDonGia(), sach.getSoLuong(), sach.getNhaXuatBan(), tinhTrang, thue, sach.tinhThanhTien());
        }
        screenOutput.flush();
    }
}