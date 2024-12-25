package dao;

import entity.Sach;

import java.io.*;
import java.util.ArrayList;

public class InDSSDAOFile implements InDAO {
    private File file = null;

    public InDSSDAOFile(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public ArrayList<Sach> getDSSach() {
        FileInputStream fileStream = null;
        ObjectInputStream oIS = null;
        ArrayList<Sach> getDSSAll = null;

        try {
            //Mo duong truyen
            fileStream = new FileInputStream(file);
            oIS = new ObjectInputStream(fileStream);

            //Doc du lieu
            getDSSAll = (ArrayList<Sach>) oIS.readObject();

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
        return getDSSAll;
    }
}
