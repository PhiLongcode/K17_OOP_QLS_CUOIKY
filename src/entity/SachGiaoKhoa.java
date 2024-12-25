package entity;

import java.io.Serializable;
import java.util.Date;

public class SachGiaoKhoa extends Sach implements Serializable  {
	private static final long serialVersionUID =2593189524794325033L;
	 	private boolean tinhTrang; // true: mới, false: cũ
	    public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
	        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
	        this.tinhTrang = tinhTrang;
	    }

	    
	    public boolean isTinhTrang() {
			return tinhTrang;
		}

		public void setTinhTrang(boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}


		@Override
		public double tinhThanhTien(){
			// TODO Auto-generated method stub
			return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;	
		}
}
