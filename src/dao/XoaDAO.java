package dao;

import entity.Sach;

public interface XoaDAO {
	 Sach getSach(String maSach);
    boolean xoaSach(String maSach);
    boolean capNhatSach(Sach sach);
}
