package controller;

import dao.TimDAO;
import dao.TimTKSDAOFile;
import entity.Sach;
import ui.TimTKSCUI;

import java.util.ArrayList;

public class TimKiemSachControl {
    private TimTKSCUI timTKSCUI; // Giao diện người dùng
    private TimDAO timDAO; // Interface DAO
    private TimTKSDAOFile timTKSDAOFile;

    // Constructor
    public TimKiemSachControl(TimTKSCUI timTKSCUI, TimDAO timDAO, TimTKSDAOFile timTKSDAOFile) {
        this.timTKSCUI = timTKSCUI;
        this.timDAO = timDAO;
        this.timTKSDAOFile = timTKSDAOFile;
    }

    // Các phương thức xử lý logic tìm kiếm, gọi đến DAO
    public ArrayList<Sach> timSachTheoNXB(String nhaXuatBan) {
        return timDAO.timSachTheoNXB(nhaXuatBan);
    }

    public Sach timSachTheoMaSach(String maSach) {
        return timDAO.timSachTheoMaSach(maSach);
    }

//    public ArrayList<Sach> timSachThamKhao(boolean thamKhao) {
//        return timDAO.timSachThamKhao(thamKhao);
//    }
}