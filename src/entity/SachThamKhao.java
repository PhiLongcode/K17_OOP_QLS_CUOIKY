package entity;

import java.util.Date;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao(int maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }
   
    public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

    @Override
    public String toString() {
        return super.toString() + ", Thuế: " + thue + ", Thành Tiền: " + tinhThanhTien();
    }
	@Override
	public double tinhThanhTien() {
		// TODO Auto-generated method stub
		return soLuong * donGia + thue;
	}
}
