// File: controller/SuaSachControl.java
package controller;

import dao.XoaDAO;
import entity.Sach;
import ui.SuaSachCUI;

public class SuaSachControl {
    private XoaDAO xoaDAO;
    private SuaSachCUI suaSachCUI;

    public SuaSachControl(XoaDAO xoaDAO, SuaSachCUI suaSachCUI) {
        this.xoaDAO = xoaDAO;
        this.suaSachCUI = suaSachCUI;
    }

    public void suaSach() {
        String maSach = suaSachCUI.nhapMaSach();
        Sach sach = xoaDAO.getSach(maSach);
        if (sach != null) {
            Sach sachMoi = suaSachCUI.nhapThongTinSachMoi(sach);
            boolean daCapNhat = xoaDAO.capNhatSach(sachMoi);
            suaSachCUI.thongBaoKetQuaCapNhat(daCapNhat);
        } else {
            suaSachCUI.thongBaoKhongTimThaySach();
        }
    }
}