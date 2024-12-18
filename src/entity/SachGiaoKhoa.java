package entity;

import java.util.Date;

public class SachGiaoKhoa extends Sach {
	 	private boolean tinhTrang; // true: mới, false: cũ
	    public SachGiaoKhoa(int maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
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
	    public String toString() {
	        return super.toString() + ", Tình Trạng: " + (tinhTrang ? "Mới" : "Cũ") + ", Thành Tiền: " + tinhThanhTien();
	    }

		@Override
		public double tinhThanhTien(){
			// TODO Auto-generated method stub
			return tinhTrang ? soLuong * donGia : soLuong * donGia * 0.5;	
		}
}
