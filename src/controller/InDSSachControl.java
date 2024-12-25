package controller;

import dao.InDAO;
import dao.InDSSDAOFile;
import entity.Sach;
import ui.InDSSachCUI;

import java.util.ArrayList;

public class InDSSachControl {
    private InDSSachCUI inDSSachCUI = null;
    private InDAO inDAO = null;

    public InDSSachControl(InDAO inDAO, InDSSachCUI inDSSachCUI) {
        this.inDAO = inDAO;
        this.inDSSachCUI = inDSSachCUI;
    }

    public void set(InDAO inDAO) {
        this.inDAO = inDAO;
    }

    public  void inDSSach(){
        ArrayList<Sach> dsSach = inDAO.getDSSach();
        inDSSachCUI.inDSSach(dsSach);
    }

}
