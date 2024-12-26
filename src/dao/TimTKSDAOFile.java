package dao;

import entity.Sach;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TimTKSDAOFile implements TimDAO {
    private File file;

    public TimTKSDAOFile(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public ArrayList<Sach> timSachTheoNXB(String nhaXuatBan) {
        ArrayList<Sach> ketQua = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Sach sach = parseSachFromLine(line);
                if (sach != null && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                    ketQua.add(sach);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file: " + file.getAbsolutePath());
        }
        return ketQua;
    }

    @Override
    public Sach timSachTheoMaSach(String maSach) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Sach sach = parseSachFromLine(line);
                if (sach != null && sach.getMaSach().equalsIgnoreCase(maSach)) {
                    return sach;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file: " + file.getAbsolutePath());
        }
        return null;
    }

//    @Override
//    public ArrayList<Sach> timSachThamKhao(boolean thamKhao) {
//        ArrayList<Sach> ketQua = new ArrayList<>();
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                Sach sach = parseSachFromLine(line);
//                if (sach != null && sach.isThamKhao() == thamKhao) {
//                    ketQua.add(sach);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("Không tìm thấy file: " + file.getAbsolutePath());
//        }
//        return ketQua;
//    }

    private Sach parseSachFromLine(String line) {
        if (line == null || line.isEmpty()) {
            return null;
        }
        String[] parts = line.split(",");
        if (parts.length == 5) {
            try {
                String maSach = parts[0].trim();
                String tenSach = parts[1].trim();
                String tacGia = parts[2].trim();
                String nhaXuatBan = parts[3].trim();
                boolean thamKhao = Boolean.parseBoolean(parts[4].trim());
                return new Sach(maSach, ngayNhap, tacGia, nhaXuatBan, thamKhao);
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi định dạng dữ liệu trong file: " + line);
                return null;
            }
        } else {
            System.err.println("Dòng dữ liệu không đúng định dạng: " + line);
            return null;
        }
    }
}