package controller;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.ThanhTienCUI;
import dao.IThanhTienDAO;
import dao.ThanhTienDAOFile;

public class ThanhTienControl {
    private IThanhTienDAO tTDAO = null;
    private ThanhTienCUI tTCUI = null;
    private ThanhTienDAOFile ttDAOFile = null;


    public ThanhTienControl(IThanhTienDAO _tTDAO , ThanhTienCUI _tTCUI){
        this.tTDAO = _tTDAO;
        this.tTCUI = _tTCUI;
    }
    
    public void tinhTien(){
        tTCUI.loaiThanhTienPromt();
    }
}

