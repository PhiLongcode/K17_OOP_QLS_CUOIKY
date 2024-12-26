package dao;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class ThanhTienDAOFile implements IThanhTienDAO {
    private File file = null;
    private Scanner sc = null;

    public ThanhTienDAOFile(String fileName) {
        sc = new Scanner(System.in);
        this.file = new File(fileName);
    }

    @Override
    public ArrayList<Sach> danhSachSach() {
        FileInputStream fileStream = null;
        ObjectInputStream oIS = null;
        ArrayList<Sach> danhSachSach = null;

        try {
            // Open the file stream
            fileStream = new FileInputStream(file);
            oIS = new ObjectInputStream(fileStream);

            // Read the data
            danhSachSach = (ArrayList<Sach>) oIS.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
        } finally {
            // Close the streams
            try {
                if (oIS != null) {
                    oIS.close();
                }
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
        return danhSachSach;
    }

    public double tinhTongThanhTienTatCa() {
        double tong = 0.0;
        ArrayList<Sach> danhSachSach = danhSachSach();
        if (danhSachSach != null) {
            for (Sach sach : danhSachSach) {
                tong += sach.tinhThanhTien();
            }
        }
        return tong;
    }

    public double tinhTongThanhTienTheoLoai(String loaiSach) {
        ArrayList<Sach> danhSachSach = danhSachSach();
        double tongThanhTien = 0.0;
        if (danhSachSach != null) {
            for (Sach sach : danhSachSach) {
                if (loaiSach.equalsIgnoreCase("1") && sach instanceof SachGiaoKhoa) {
                    tongThanhTien += sach.tinhThanhTien();
                } else if (loaiSach.equalsIgnoreCase("2") && sach instanceof SachThamKhao) {
                    tongThanhTien += sach.tinhThanhTien();
                }
            }
        }
        return tongThanhTien;
    }

    public double tinhTrungBinhDonGiaTheoLoai(String loaiSach) {
        ArrayList<Sach> danhSachSach = danhSachSach();
        double tongDonGia = 0.0;
        int demSach = 0;
        if (danhSachSach != null) {
            for (Sach sach : danhSachSach) {
                if (loaiSach.equalsIgnoreCase("1") && sach instanceof SachGiaoKhoa) {
                    tongDonGia += sach.getDonGia();
                    demSach++;
                } else if (loaiSach.equalsIgnoreCase("2") && sach instanceof SachThamKhao) {
                    tongDonGia += sach.tinhThanhTien();
                    demSach++;
                }
            }
        }
        return demSach > 0 ? tongDonGia / demSach : 0;
    }
}