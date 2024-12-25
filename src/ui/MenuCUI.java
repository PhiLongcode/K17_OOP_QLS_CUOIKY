package ui;

import java.io.PrintWriter;
import java.util.Scanner;
import controller.InDSSachControl;
import controller.ThanhTienControl;
import controller.XoaSachControl;
import dao.ThemSachMoiDAOFile;
import entity.Sach;

public class MenuCUI {
	//fields
		private PrintWriter screenOutput = null;
		private Scanner keyBoardInput = null;
		private String prompt;
		private String command;
		private String chon;
		private ThemSachInputCUI themSachInputCUI = null;
		private InDSSachControl inDSSachControl = null;
		private XoaSachControl xoaSachControl = null;
		private ThanhTienControl thanhTienControl = null;


		//functions - methods

		//constructor

		public MenuCUI() {
			screenOutput = new PrintWriter(System.out);
		}


		public void setInDSSachControl(InDSSachControl inDSSachControl) {
			this.inDSSachControl = inDSSachControl;
		}

		public void setXoaSachControl(XoaSachControl xoaSachControl) {
			this.xoaSachControl = xoaSachControl;
		}
		public void setThanhTienControl (ThanhTienControl thanhTienControl){
			this.thanhTienControl = thanhTienControl;
		}

		public MenuCUI(PrintWriter _screenOutput, Scanner _keyBoardInput) {
			screenOutput = _screenOutput;
			keyBoardInput = _keyBoardInput;
			prompt = "->";
			command = " ";
			chon = "";
		}

		public MenuCUI(PrintWriter _screenOutput, Scanner _keyBoardInput,
				ThemSachInputCUI _themSachCUI ) {
			this(_screenOutput, _keyBoardInput);//gọi lại constructor MenuCUI 2 tham số
			themSachInputCUI  = _themSachCUI ;
		}




		public void controlLoop() {

			screenOutput.println("go lenh \"help\" de dung phan mem!");
			screenOutput.flush();



			while(true) {
				screenOutput.print(prompt);screenOutput.flush();
				command = keyBoardInput.nextLine().trim();//"help"


				if("help".equalsIgnoreCase(command)) {
					menu();//gọi đến hàm menu
					continue;
				}

				if("1".equalsIgnoreCase(command)) {
					themSach();
					continue;
				}

				if("2".equalsIgnoreCase(command)) {
					inDSSach();
					continue;
				}
				if ("3".equalsIgnoreCase(command)) {
					xoaSach();
					continue;
				}
				if ("5".equalsIgnoreCase(command)) {
					thanhTien();
					continue;
				}
				if ("EXIT".equalsIgnoreCase(command)) {
					screenOutput.println("Dang thoat chuong trinh...");
					screenOutput.println("Da thoat chuong trinh thanh cong !!!");
					break;
				}

			}

		}

	private void xoaSach() {
		xoaSachControl.xoaSach();
	}

	private void inDSSach() {
			inDSSachControl.inDSSach();
	}

	private void themSach() {
		//đối tượng ????UI để người dùng nhập
		//thông tin của sách
		themSachInputCUI.nhapThongTinSach();

	}
		
		private void thanhTien() {
			thanhTienControl.tinhTien();
		}
		private void menu() {
			screenOutput.println("~~~~~~~~~~Console Help Menu~~~~~~~~~");
			screenOutput.println("[1] - Them moi sach");
			screenOutput.println("[2] - In danh sach sach");
			screenOutput.println("[3] - Xoa sach theo ma sach");
			screenOutput.println("[5] - Tinh tien");
			screenOutput.println("[EXIT] - Thoat chuong trinh");
			screenOutput.println("~~~~~~~~~~Console Help Menu~~~~~~~~~");
		}


}
