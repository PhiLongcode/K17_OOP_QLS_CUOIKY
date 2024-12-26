package ui;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import controller.ThemMoiSachControl;

public class ThemSachInputCUI {
    private  PrintWriter screenOutput;
    private  Scanner keyboardInput;
    private AtomicInteger counter = new AtomicInteger(0);

    private String ngayNhapPrompt, loaiSachPrompt, 
    nhaXuatBanPrompt, soLuongPrompt, donGiaPrompt,
    tinhTrangPrompt, thuePrompt;
   
    private SimpleDateFormat dateFormat;
    private ThemMoiSachControl themSachControl;

    public ThemSachInputCUI(PrintWriter _screenOutput, Scanner _keyboardInput, ThemMoiSachControl _themSachControl) {
        this(_screenOutput, _keyboardInput);
        themSachControl = _themSachControl;
    }

    public ThemSachInputCUI(PrintWriter _screenOutput, Scanner _keyboardInput) {
        screenOutput = _screenOutput;
        keyboardInput = _keyboardInput;
        ngayNhapPrompt = "Nhập ngày nhập sách (dd/MM/yyyy): ";
        loaiSachPrompt = "Nhập loại sách ( 1. Sach giao khoa / 2. Sach tham khao): ";
        nhaXuatBanPrompt = "Nhập nhà xuất bản: ";
        soLuongPrompt = "Nhập số lượng sách: ";
        donGiaPrompt = "Nhập đơn giá: ";
        tinhTrangPrompt = "Nhập tình trạng: (1. Cu / 2: Moi):";
        thuePrompt = "Nhập thuế: ";
        String pattern = "dd/MM/yyyy";
         dateFormat = new SimpleDateFormat(pattern);
    }
    
//    private String taoMaSach(String loaiSach) {
//        int stt = counter.incrementAndGet(); // Tăng số thứ tự
//        return loaiSach.toUpperCase() + "-" + String.format("%05d", stt);
//    }

    public void nhapThongTinSach() {
    	
        // Nhập ngày nhập sách
        String ngayNhapStr = ValidCUI.getNgayInput(ngayNhapPrompt, "dd/MM/yyyy");
        
		Date ngayNhap = null;
		try {
			ngayNhap = dateFormat.parse(ngayNhapStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
        // Nhập loại sách
        double loaiSachNumber = ValidCUI.getSoDuongInput(loaiSachPrompt);
        int loaiSach = (int) loaiSachNumber;
        while (loaiSach != 1 && loaiSach != 2) {
            screenOutput.println("Loi: Loai sach phai la 1 hoac 2. Vui long thu lai.");
            screenOutput.flush();
             loaiSachNumber = ValidCUI.getSoDuongInput(loaiSachPrompt);
             loaiSach = (int) loaiSachNumber;
        }
        String loaiSachStr = loaiSach == 1 ? "SGK" : "STK";
        String maSach = themSachControl.taoMaSach(loaiSachStr);
        // Nhập nhà xuất bản
        String nhaXuatBan = ValidCUI.getEmptyInput(nhaXuatBanPrompt);

        // Nhập số lượng sách
        double soLuongNumber = ValidCUI.getSoDuongInput(soLuongPrompt);
        int soLuong = (int) soLuongNumber;

        // Nhập đơn giá
        double donGia = ValidCUI.getSoDuongInput(donGiaPrompt);

        if (loaiSach == 1) {
            // Nhập tình trạng (Mới hay Cũ)
            String tinhTrangStr = ValidCUI.getEmptyInput(tinhTrangPrompt);
            
            // Kiểm tra xem tình trạng có hợp lệ không
            while (!tinhTrangStr.equals("1") && !tinhTrangStr.equals("2")) {
                screenOutput.println("Lỗi: Tình trạng phải là 1 (Mới) hoặc 2 (Cũ). Vui lòng thử lại.");
                screenOutput.flush();
                tinhTrangStr = ValidCUI.getEmptyInput(tinhTrangPrompt);
            }
            
            // Chuyển đổi từ chuỗi sang boolean
            boolean tinhTrang = tinhTrangStr.equals("1");  // Nếu là "1" thì true, nếu là "2" thì false
            
            // Gửi thông tin đến controller để xử lý
            themSachControl.taoSach(maSach, soLuong, ngayNhap, donGia, nhaXuatBan, tinhTrang);
        }
        if (loaiSach == 2) {
        	Double thue = ValidCUI.getSoDuongInput(thuePrompt);
        	float _thue = (float) (double) thue;
        	
        	 // Gửi thông tin đến controller để xử lý
            themSachControl.taoSach(maSach, soLuong, ngayNhap, donGia, nhaXuatBan, _thue);
        }
       
     
       
        screenOutput.println("Thong tin sach da duoc them thanh cong voi ma: " + maSach);
    }
   
}
