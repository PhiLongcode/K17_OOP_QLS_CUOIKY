package app;

import java.io.PrintWriter;
import java.util.Scanner;

import controller.ThemMoiSachControl;
import dao.ThemSachMoiDAOFile;
import ui.MenuCUI;
import ui.ThemSachInputCUI;
import ui.ThongBaoThemSachCUI;
import ui.ValidCUI;

public class AppQLS {

	public static void main(String[] args) {
		//sử dụng Class MenuCUI
				PrintWriter pWriterRemote = new PrintWriter(System.out, true);
				Scanner scannerRemote = new Scanner(System.in);
				ValidCUI.init(pWriterRemote, scannerRemote);
				//DAO
				
				ThemSachMoiDAOFile themSachMoiDAOFile = new 
						ThemSachMoiDAOFile("src\\Sach.txt");
				
				
				ThongBaoThemSachCUI tbThemSachCUIRemote = 
						new ThongBaoThemSachCUI(pWriterRemote);
				
				
				//Control
				ThemMoiSachControl themMoiSachControlRemote = new ThemMoiSachControl(themSachMoiDAOFile);
				themMoiSachControlRemote.setThemSachDAOFile(themSachMoiDAOFile);;
				themMoiSachControlRemote.setTbThemSachCUI(tbThemSachCUIRemote);
				
				
				//CUI
				ThemSachInputCUI themMoiSachCUIRemote = new 
						ThemSachInputCUI(pWriterRemote, scannerRemote,themMoiSachControlRemote);
				
				MenuCUI menuCUIRemote = new MenuCUI(pWriterRemote, 
						scannerRemote, themMoiSachCUIRemote);
				
				
				//gửi thông điệp
				menuCUIRemote.controlLoop();
				

	}

}
