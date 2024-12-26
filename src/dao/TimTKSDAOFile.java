package dao;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TimTKSDAOFile implements TimDAO {
	private File file = null;
    private Scanner sc = null;
    public TimTKSDAOFile(String filePath) {
    	sc = new Scanner(System.in);
        this.file = new File(filePath);
    }
    

    @Override
    public ArrayList<Sach> timSachTheoNXB(String nhaXuatBan) {
        ArrayList<Sach> danhSachSach = danhSachSach(); 
        ArrayList<Sach> ketQua = new ArrayList<>(); 
        for (Sach sach : danhSachSach) {
            if (sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) { 
                ketQua.add(sach); 
            }
        }
        return ketQua; 
    }
    @Override
    public ArrayList<Sach> timSachTheoMaSach(String maSach) {
    	ArrayList<Sach> danhSachSach = danhSachSach(); 
    	ArrayList<Sach> ketQua = new ArrayList<>(); 
    	for (Sach sach : danhSachSach) {
            if (sach.getMaSach().equalsIgnoreCase(maSach)) { 
            	ketQua.add(sach); 
            }
        }
    	 return ketQua; 
    }



	@Override
	public ArrayList<Sach> timSachThamKhao(String loaiSach) {
		ArrayList<Sach> danhSachSach = danhSachSach(); 
		ArrayList<Sach> ketQua = new ArrayList<>(); 
		 if (danhSachSach != null) {
	            for (Sach sach : danhSachSach) {
	                if (loaiSach.equalsIgnoreCase("1") && sach instanceof SachGiaoKhoa) {
	                	ketQua.add(sach); 
	                } else if (loaiSach.equalsIgnoreCase("2") && sach instanceof SachThamKhao) {
	                	ketQua.add(sach); 
	                }
	            }
	        }
        return ketQua; 
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
}