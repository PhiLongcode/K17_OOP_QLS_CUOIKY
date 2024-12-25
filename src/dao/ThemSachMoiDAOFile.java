package dao;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;

public class ThemSachMoiDAOFile implements IThemSachDAO {
    private File fileData = null;
    private ArrayList<Sach> tempData = null;
    public ThemSachMoiDAOFile() {};
    public ThemSachMoiDAOFile(String fileName) {
        fileData = new File(fileName);
        tempData = new ArrayList<>();
        readDataToListFromFile();  // Khởi tạo danh sách từ tệp khi tạo DAO
        
    }

    @Override
    public void addSachDAO(Sach sach) {
        tempData.add(sach);

        // Ghi danh sách vào tệp
        writeListToFile();
    }

    private void readDataToListFromFile() {
        if (!fileData.exists() || fileData.length() == 0) {
            tempData = new ArrayList<>();
            return;
        }
        try (FileInputStream fileStream = new FileInputStream(fileData);
             ObjectInputStream oIS = new ObjectInputStream(fileStream)) {
            tempData = (ArrayList<Sach>) oIS.readObject();
        } catch (EOFException e) {
            tempData = new ArrayList<>();
        } catch (FileNotFoundException e) {
            tempData = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeListToFile() {
        try (FileOutputStream fileStream = new FileOutputStream(fileData);
             ObjectOutputStream os = new ObjectOutputStream(fileStream)) {
            os.writeObject(tempData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //TEST
//    public void getAllSach() {
//        if (tempData != null && !tempData.isEmpty()) {  
//            for (Sach sach : tempData) {
//              System.out.println(sach);
//            }
//        } else {
//            System.out.println("Danh sách sách trống.");
//        }
//    }

	@Override
	public ArrayList<String> docDanhSachMaSach() {
		
		 ArrayList<String> maSachList = new ArrayList<>();

		    // Lấy các mã sách từ danh sách tempData
		    for (Sach sach : tempData) {
		        maSachList.add(sach.getMaSach());
		    }

		    return maSachList;
	}
}
