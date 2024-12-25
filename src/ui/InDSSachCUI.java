package ui;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class InDSSachCUI {
    private PrintWriter screenOutput = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public InDSSachCUI(PrintWriter screenOutput) {
        this.screenOutput = screenOutput;
    }

    public void inDSSach(ArrayList<Sach> dsSach) {
        screenOutput.printf("%-10s %-12s %-20s %-12s %-15s %-14s %-17s%n",
                "Mã sách", "Ngày Nhập", "Đơn giá", "Số lượng", "Nhà Xuất bản", "Tình Trạng", "Thuế");
        screenOutput.println("-------------------------------------------------------------------------------------------------");

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

            screenOutput.printf("%-10s %-12s %-20.2f %-12d %-15s %-14s %-17s%n",
                    sach.getMaSach(), ngayNhapFormatted, sach.getDonGia(), sach.getSoLuong(), sach.getNhaXuatBan(), tinhTrang, thue);
        }
        screenOutput.flush();
    }
}
