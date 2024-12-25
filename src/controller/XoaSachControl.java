package controller;

import dao.InDAO;
import dao.XoaDAO;
import ui.XoaSachCUI;

public class XoaSachControl {
    private XoaDAO xoaDAO;
    private XoaSachCUI xoaSachCUI;


    public XoaSachControl(XoaDAO xoaDAO, XoaSachCUI xoaSachCUI) {
        this.xoaDAO = xoaDAO;
        this.xoaSachCUI = xoaSachCUI;
    }

    public void xoaSach() {
        String maSach = xoaSachCUI.nhapMaSach();
        boolean daXoa = xoaDAO.xoaSach(maSach);
        xoaSachCUI.thongBaoKetQua(maSach, daXoa);
    }
}