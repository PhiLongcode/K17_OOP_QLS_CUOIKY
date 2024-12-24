package entity;

import java.io.Serializable;
import java.util.Date;

public class SachThamKhao extends Sach implements Serializable {
	private static final long serialVersionUID = 5722119392024971021L;
    private double thue;

    public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
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
