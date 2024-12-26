package dao;

import entity.Sach;
import java.util.ArrayList;

public interface TimDAO {
    ArrayList<Sach> timSachTheoNXB(String nhaXuatBan);
    Sach timSachTheoMaSach(String maSach);
//    ArrayList<Sach> timSachThamKhao(boolean thamKhao);
}