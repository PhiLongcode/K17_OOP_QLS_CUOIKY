package controller;

import entity.Sach;
import entity.SachGiaoKhoa;
import entity.SachThamKhao;
import ui.ThanhTienCUI;
import dao.IThanhTienDAO;

public class ThanhTienControl {
    private IThanhTienDAO tTDAO = null;
    private ThanhTienCUI tTCUI = null;
    public ThanhTienControl(){
        
    }
    public ThanhTienControl(IThanhTienDAO _tTDAO , ThanhTienCUI _tTCUI){
        this.tTDAO = _tTDAO;
        this.tTCUI = _tTCUI;
    }
    // public void setThanhTien(IThanhTienDAO _tTDAO){
    //     this.tTDAO = _tTDAO;
    // }

    // public void setTrungBinhCongDonGia(IThanhTienDAO _tTDAO){
    //     this.tTDAO = _tTDAO;
    // }
    
    public void tinhTien(){
        tTCUI.ThanhTienPromt();
    }
}

