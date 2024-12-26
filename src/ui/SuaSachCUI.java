// File: ui/SuaSachCUI.java
package ui;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SuaSachCUI {
    private PrintWriter screenOutput;

    public SuaSachCUI(PrintWriter screenOutput) {
        this.screenOutput = screenOutput;
    }

    public String nhapMaSach() {
        Scanner scanner = new Scanner(System.in);
        screenOutput.println("Nhập mã sách cần sửa: ");
        return scanner.nextLine().trim();
    }

    public Sach nhapThongTinSachMoi(Sach sach) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

       
        screenOutput.println("Nhập ngày nhập mới (dd/MM/yyyy) (hiện tại: " + dateFormat.format(sach.getNgayNhap()) + "): ");
        String ngayNhapMoi = scanner.nextLine();
        if (!ngayNhapMoi.isEmpty()) {
            try {
                Date ngayNhap = dateFormat.parse(ngayNhapMoi);
                sach.setNgayNhap(ngayNhap);
            } catch (ParseException e) {
                screenOutput.println("Ngày nhập không hợp lệ!");
            }
        }

        screenOutput.println("Nhập đơn giá mới (hiện tại: " + sach.getDonGia() + "): ");
        String donGiaMoi = scanner.nextLine();
        if (!donGiaMoi.isEmpty()) {
            sach.setDonGia(Double.parseDouble(donGiaMoi));
        }

        screenOutput.println("Nhập số lượng mới (hiện tại: " + sach.getSoLuong() + "): ");
        String soLuongMoi = scanner.nextLine();
        if (!soLuongMoi.isEmpty()) {
            sach.setSoLuong(Integer.parseInt(soLuongMoi));
        }

        screenOutput.println("Nhập nhà xuất bản mới (hiện tại: " + sach.getNhaXuatBan() + "): ");
        String nhaXuatBanMoi = scanner.nextLine();
        if (!nhaXuatBanMoi.isEmpty()) {
            sach.setNhaXuatBan(nhaXuatBanMoi);
        }

        if (sach instanceof SachGiaoKhoa) {
            screenOutput.println("Nhập tình trạng mới (hiện tại: " + (((SachGiaoKhoa) sach).isTinhTrang() ? "Mới" : "Cũ") + "): ");
            String tinhTrangMoi = scanner.nextLine();
            if (!tinhTrangMoi.isEmpty()) {
                ((SachGiaoKhoa) sach).setTinhTrang(Boolean.parseBoolean(tinhTrangMoi));
            }
        } else if (sach instanceof SachThamKhao) {
            screenOutput.println("Nhập thuế mới (hiện tại: " + ((SachThamKhao) sach).getThue() + "): ");
            String thueMoi = scanner.nextLine();
            if (!thueMoi.isEmpty()) {
                ((SachThamKhao) sach).setThue(Double.parseDouble(thueMoi));
            }
        }

        return sach;
    }

    public void thongBaoKhongTimThaySach() {
        screenOutput.println("Không tìm thấy sách!");
        screenOutput.flush();
    }

    public void thongBaoKetQuaCapNhat(boolean daCapNhat) {
        if (daCapNhat) {
            screenOutput.println("Cập nhật sách thành công!");
        } else {
            screenOutput.println("Không tìm thấy sách để cập nhật!");
        }
        screenOutput.flush();
    }
}