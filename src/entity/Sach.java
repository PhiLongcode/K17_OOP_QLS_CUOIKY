package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sach  implements Serializable{
	private static final long serialVersionUID = 2593189524794325047L;
		protected String maSach;
	    protected Date ngayNhap;
	    protected double donGia;
	    protected int soLuong;
	    protected String nhaXuatBan;
 
		public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
			this.maSach = maSach;
			this.ngayNhap = ngayNhap;
			this.donGia = donGia;
			this.soLuong = soLuong;
			this.nhaXuatBan = nhaXuatBan;
		}

	    public String getMaSach() {
			return maSach;
		}
		public void setMaSach(String maSach) {
			this.maSach = maSach;
		}
		public Date getNgayNhap() {
			return ngayNhap;
		}
		public void setNgayNhap(Date ngayNhap) {
			this.ngayNhap = ngayNhap;
		}
		public double getDonGia() {
			return donGia;
		}
		public void setDonGia(double donGia) {
			this.donGia = donGia;
		}
		public int getSoLuong() {
			return soLuong;
		}
		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
		public String getNhaXuatBan() {
			return nhaXuatBan;
		}
		public void setNhaXuatBan(String nhaXuatBan) {
			this.nhaXuatBan = nhaXuatBan;
		}
		
		public abstract double tinhThanhTien();

		
}
