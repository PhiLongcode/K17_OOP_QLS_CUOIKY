package app;

import java.io.PrintWriter;
import java.util.Scanner;

import controller.InDSSachControl;
import controller.ThemMoiSachControl;
import controller.XoaSachControl;
import dao.InDSSDAOFile;
import dao.ThemSachMoiDAOFile;
import dao.XoaSachDAOFile;
import ui.InDSSachCUI;
import ui.MenuCUI;
import ui.ThemSachInputCUI;
import ui.ThongBaoThemSachCUI;
import ui.ValidCUI;
import ui.XoaSachCUI;

public class AppQLS {

	public static void main(String[] args) {
		 // Initialize PrintWriter and Scanner
        PrintWriter pWriterRemote = new PrintWriter(System.out, true);
        Scanner scannerRemote = new Scanner(System.in);
        ValidCUI.init(pWriterRemote, scannerRemote);

        // Initialize UI components
        InDSSachCUI inDSSachCUIRemote = new InDSSachCUI(pWriterRemote);
        XoaSachCUI xoaSachCUIRemote = new XoaSachCUI(pWriterRemote);

        // Initialize DAO components
        ThemSachMoiDAOFile themSachMoiDAOFile = new ThemSachMoiDAOFile("src//Sach.txt");
        InDSSDAOFile inDSSVDAOFileRemote = new InDSSDAOFile("src//Sach.txt");
		XoaSachDAOFile xoaSachDAOFileRemote = new XoaSachDAOFile("src//Sach.txt");

        // Initialize Control components
        ThemMoiSachControl themMoiSachControlRemote = new ThemMoiSachControl(themSachMoiDAOFile);
        themMoiSachControlRemote.setThemSachDAOFile(themSachMoiDAOFile);
        themMoiSachControlRemote.setTbThemSachCUI(new ThongBaoThemSachCUI(pWriterRemote));

        InDSSachControl inDSSachControlRemote = new InDSSachControl(inDSSVDAOFileRemote, inDSSachCUIRemote);
//        inDSSachControlRemote.set(inDSSVDAOFileRemote);


        XoaSachControl xoaSachControlRemote = new XoaSachControl(xoaSachDAOFileRemote, xoaSachCUIRemote);
//		xoaSachControlRemote.set(xoaSachDAOFileRemote);


        // Initialize MenuCUI and set controls
        ThemSachInputCUI themMoiSachCUIRemote = new ThemSachInputCUI(pWriterRemote, scannerRemote, themMoiSachControlRemote);
        MenuCUI menuCUIRemote = new MenuCUI(pWriterRemote, scannerRemote, themMoiSachCUIRemote);
        menuCUIRemote.setInDSSachControl(inDSSachControlRemote);
        menuCUIRemote.setXoaSachControl(xoaSachControlRemote);

        // Start the menu control loop
        menuCUIRemote.controlLoop();

	}

}
