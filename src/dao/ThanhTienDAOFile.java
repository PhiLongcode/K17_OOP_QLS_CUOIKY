package dao;

import java.util.Scanner;    
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class ThanhTienDAOFile implements IThanhTienDAO {
    private File file = null;


    @Override
    public ArrayList<Sach> danhSachSach() {
        FileInputStream fileStream = null;
        ObjectInputStream oIS = null;
        ArrayList<Sach> danhSachSach = null;

        try {
            //Mo duong truyen
            fileStream = new FileInputStream(file);
            oIS = new ObjectInputStream(fileStream);

            //Doc du lieu
            danhSachSach = (ArrayList<Sach>) oIS.readObject();

            //Dong duong truyen
            oIS.close();
            fileStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return danhSachSach;
    }
    private Scanner sc = null;


    public ThanhTienDAOFile(String fileName) {
        
        sc = new Scanner(System.in);
        this.file = new File(fileName);
    }

    public double tinhTongThanhTienTatCa() {
        double tong = 0.0;
        ArrayList<Sach> danhSachSach = danhSachSach() ; 
        for (Sach sach : danhSachSach) {
            tong += sach.tinhThanhTien();
        }
        return tong;
    }
    

    public double tinhTongThanhTienTheoLoai(String loaiSach) {
        ArrayList<Sach> danhSachSach = danhSachSach() ; 
        double tongThanhTien = 0.0;
        for (Sach sach : danhSachSach) {
            if (loaiSach.equalsIgnoreCase("1") && sach instanceof SachGiaoKhoa) {
                
                tongThanhTien += sach.tinhThanhTien();
            } else if (loaiSach.equalsIgnoreCase("2") && sach instanceof SachThamKhao) {
                tongThanhTien += sach.tinhThanhTien();
            }
        }
        return tongThanhTien;
    }

    public double tinhTrungBinhDonGiaTheoLoai(String loaiSach) {
        ArrayList<Sach> danhSachSach = danhSachSach() ;
        double tongDonGia = 0.0;
        int demSach = 0;
        for (Sach sach : danhSachSach) {
            if (loaiSach.equalsIgnoreCase("1") && sach instanceof SachGiaoKhoa) {
                
                tongDonGia += sach.getDonGia();
                demSach++;
            } else if (loaiSach.equalsIgnoreCase("2") && sach instanceof SachThamKhao) {
                tongDonGia += sach.tinhThanhTien();
                demSach++;
            }
        }
        return demSach > 0 ? tongDonGia / demSach : 0;
    }
    
}
