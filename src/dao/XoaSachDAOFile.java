package dao;

import entity.Sach;

import java.io.*;
import java.util.ArrayList;

public class XoaSachDAOFile implements XoaDAO {
    private File file = null;

    public XoaSachDAOFile(String fileName) {
        this.file = new File(fileName);
    }

    ArrayList<Sach> getDSSach() {
        ArrayList<Sach> DSSach = new ArrayList<>();
        if (file.exists()) {
            try (FileInputStream fileStream = new FileInputStream(file);
                 ObjectInputStream oIS = new ObjectInputStream(fileStream)) {
                DSSach = (ArrayList<Sach>) oIS.readObject();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return DSSach;
    }

    @Override
    public boolean xoaSach(String maSach) {
        ArrayList<Sach> DSSach = getDSSach();
        boolean daXoa = false;
        for (int i = 0; i < DSSach.size(); i++) {
            if (DSSach.get(i).getMaSach().equals(maSach)) {
                DSSach.remove(i);
                daXoa = true;
                break;
            }
        }
        if (daXoa) {
            try {
                FileOutputStream fileStream = new FileOutputStream(file);
                ObjectOutputStream oOS = new ObjectOutputStream(fileStream);
                oOS.writeObject(DSSach);
                oOS.close();
                fileStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return daXoa;
    }

    @Override
    public boolean capNhatSach(Sach sach) {
        ArrayList<Sach> DSSach = getDSSach();
        boolean daCapNhat = false;
        for (int i = 0; i < DSSach.size(); i++) {
            if (DSSach.get(i).getMaSach().equals(sach.getMaSach())) {
                DSSach.set(i, sach);
                daCapNhat = true;
                break;
            }
        }
        if (daCapNhat) {
            try {
                FileOutputStream fileStream = new FileOutputStream(file);
                ObjectOutputStream oOS = new ObjectOutputStream(fileStream);
                oOS.writeObject(DSSach);
                oOS.close();
                fileStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return daCapNhat;
    }

	@Override
	public Sach getSach(String maSach) {
		 ArrayList<Sach> DSSach = getDSSach();
	        for (Sach sach : DSSach) {
	            if (sach.getMaSach().equals(maSach)) {
	                return sach;
	            }
	        }
	        return null;
	}
}
