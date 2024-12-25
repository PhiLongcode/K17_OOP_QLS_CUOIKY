package ui;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import dao.ThanhTienDAOFile;
import java.io.PrintWriter;
import java.util.Scanner;



public class ThanhTienCUI {
    private PrintWriter screenOutput = null;
		private Scanner keyBoardInput = new Scanner(System.in);
		private String prompt;
		private String chon;
        private ThanhTienDAOFile tTDAOFile = null;

    public ThanhTienCUI(){}

    public ThanhTienCUI(PrintWriter screenOutput) {
        this.screenOutput = new PrintWriter(System.out, true );
        prompt = "->";
		chon = "";

    }

        public String nhapLoaiSach(){
            screenOutput.println("Nhập loại sách (1:SachGiaoKhoa hoặc 2:SachThamKhao) Lưu ý: (nhập số 1 or 2): ");
            screenOutput.flush();
            String loaiSach = keyBoardInput.nextLine();
            return loaiSach;
        }

        public void ThanhTienPromt() {
            
            while (true) {
            screenOutput.println("Chon mot trong cac lua chon sau:");
            screenOutput.println("[1] Tinh tong thanh tien cua tat ca cac sach dang co");
            screenOutput.println("[2] Tinh tong thanh tien cua tung loai sach");
            screenOutput.println("[3] Tinh trung binh cong theo don gia cua tung loai sach");
            screenOutput.println("[4] Thoat");
            screenOutput.print(prompt);screenOutput.flush();
            chon = keyBoardInput.nextLine().trim();

            switch (chon) {
                case "1":
                    tinhTongThanhTienTatCa();
                    break;
                case "2":
                    String loaiSach = nhapLoaiSach();
                    tinhTongThanhTienTheoLoai(loaiSach);
                    break;
                case "3":
                    String loaiSach1 = nhapLoaiSach();
                    tinhTrungBinhCongDonGia(loaiSach1);
                    break;
                case "4":
                    screenOutput.println("Dang thoat...");
                    return;
                default:
                    screenOutput.println("Vui long chon 1 trong 4 lua chon tren !!!");
            }
        }

    }
    private void tinhTongThanhTienTatCa() {
        double tongThanhTienTatCa =  tTDAOFile.tinhTongThanhTienTatCa();
        screenOutput.println("Tong thanh tien cua tat ca cac loai sach la: " + tongThanhTienTatCa);
        screenOutput.flush();
    }

    private void tinhTongThanhTienTheoLoai(String loaiSach) {
        double tienTungLoai = tTDAOFile.tinhTongThanhTienTheoLoai(loaiSach);
        screenOutput.println("Tong thanh tien cua "+ loaiSach +" la: " + tienTungLoai);
        screenOutput.flush();
    }

    private void tinhTrungBinhCongDonGia(String loaiSach) {
        double trungBinhCongDonGia = tTDAOFile.tinhTrungBinhDonGiaTheoLoai(loaiSach);
        screenOutput.println("Trung binh con don gia cua "+ loaiSach +" la: " + trungBinhCongDonGia);
        screenOutput.flush();
    }
}
