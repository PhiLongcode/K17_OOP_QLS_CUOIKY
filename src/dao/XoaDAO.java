package dao;

import entity.Sach;

public interface XoaDAO {
    boolean xoaSach(String maSach);
    boolean capNhatSach(Sach sach);
}
