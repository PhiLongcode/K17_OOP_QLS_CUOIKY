package dao;

import entity.Sach;
import java.util.ArrayList;

public interface TimDAO {
    ArrayList<Sach> timSachTheoNXB(String nhaXuatBan);
    ArrayList<Sach> timSachTheoMaSach(String maSach);
    ArrayList<Sach> timSachThamKhao(String loaiSach);
    ArrayList<Sach> danhSachSach();
}