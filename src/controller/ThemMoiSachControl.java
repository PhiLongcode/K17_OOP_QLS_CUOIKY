package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import dao.IThemSachDAO;
import dao.ThemSachMoiDAOFile;
import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.ThongBaoThemSachCUI;

public class ThemMoiSachControl {
	private IThemSachDAO IThemDAO = null;
	private ThongBaoThemSachCUI tbThemSachCUI = null;

	public ThemMoiSachControl(IThemSachDAO  _IThemDAO) {
		IThemDAO = _IThemDAO;
	}
	
	
	public void setTbThemSachCUI(ThongBaoThemSachCUI _tbThemSachCUI) {
		tbThemSachCUI = _tbThemSachCUI;
	}
	
	
	
	public void setThemSachDAOFile(IThemSachDAO  _IThemDAO) {
		IThemDAO = _IThemDAO;
	}
	 // Tạo mã sách mới không trùng
	private String taoMaSach(String loaiSach) {
	    // Bước 1: Lấy danh sách các mã sách đã tồn tại từ DAO
		List<String> maSachDaTonTai = IThemDAO.docDanhSachMaSach();
		
		String maSachMoi;
		
		
		do {
		    // Tạo số ngẫu nhiên có 5 chữ số
		    int soNgauNhien = (int) (Math.random() * 100000);
		    
		    maSachMoi = loaiSach.toUpperCase() + "-" + String.format("%05d", soNgauNhien);
		} while (maSachDaTonTai.contains(maSachMoi)); // Kiểm tra mã sách đã tồn tại trong danh sách
		
		
		return maSachMoi;
	}


	public void taoSach(String maSach, int soLuong , Date ngayNhap,
			double donGia, String nhaXuatBan , float thue) {
		
		//đối tượng sach tham khao
		SachThamKhao stk = new SachThamKhao(maSach, ngayNhap, donGia, 
				soLuong, nhaXuatBan , thue);
		
		doThemSach(stk);
	}
	
	
	public void taoSach(String maSach, int soLuong , Date ngayNhap,
			double donGia, String nhaXuatBan , boolean tinhTrang) {
		//đối tượng sach giao khoa
		SachGiaoKhoa sgk = new SachGiaoKhoa(maSach, ngayNhap, donGia, 
				soLuong, nhaXuatBan ,tinhTrang);
		
		doThemSach(sgk);

	}
	
	private void doThemSach(Sach sach ) {
		//themSVDAO.addSinhVien(sv);
		IThemDAO.addSachDAO(sach);
		tbThemSachCUI.inThongBao("Them Moi Sach Thanh Cong!!!");
	}
	
}
