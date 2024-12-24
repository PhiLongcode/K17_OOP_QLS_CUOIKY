package dao;

import java.io.IOException;
import java.util.List;

import entity.Sach;

public interface IThemSachDAO {
	void addSachDAO(Sach sach);
	List<String> docDanhSachMaSach();
}
