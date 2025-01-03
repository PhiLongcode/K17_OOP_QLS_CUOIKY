package ui;

import java.io.PrintWriter;
import java.util.Scanner;
import controller.InDSSachControl;
import controller.SuaSachControl;
import controller.ThanhTienControl;
import controller.TimKiemSachControl;
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
		private SuaSachControl suaSachControl = null;
		private TimKiemSachControl timKiemSachControl = null;
		private TimTKSCUI  timTKSCUI = null;
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
		public void setSuaSachControl(SuaSachControl suaSachControl) {
			this.suaSachControl = suaSachControl;
		}
		

		public MenuCUI(PrintWriter _screenOutput, Scanner _keyBoardInput) {
			screenOutput = _screenOutput;
			keyBoardInput = _keyBoardInput;
			prompt = "->";
			command = " ";
			chon = "";
		}

		public MenuCUI(PrintWriter _screenOutput, Scanner _keyBoardInput,
				ThemSachInputCUI _themSachCUI , TimTKSCUI  _timTKSCUI ) {
			this(_screenOutput, _keyBoardInput);//gọi lại constructor MenuCUI 2 tham số
			themSachInputCUI  = _themSachCUI ;
			timTKSCUI = _timTKSCUI;
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
				if ("4".equalsIgnoreCase(command)) {
					suaSach();
					continue;
				}
				if ("5".equalsIgnoreCase(command)) {
					thanhTien();
					continue;
				}
				if ("6".equalsIgnoreCase(command)) {
					timKiem();
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
	private void suaSach(){
		suaSachControl.suaSach();
	}

	private void thanhTien() {
		thanhTienControl.tinhTien();
	}
	private void timKiem() {
		timTKSCUI.timKiemSach();
	}
	private void menu() {
			screenOutput.println("~~~~~~~~~~Console Help Menu~~~~~~~~~");
			screenOutput.println("[1] - Them moi sach");
			screenOutput.println("[2] - In danh sach sach");
			screenOutput.println("[3] - Xoa sach theo ma sach");
			screenOutput.println("[4] - Sua sach theo ma sach");
			screenOutput.println("[5] - Tinh tien");
			screenOutput.println("[6] - Tim kiem");
			screenOutput.println("[EXIT] - Thoat chuong trinh");
			screenOutput.println("~~~~~~~~~~Console Help Menu~~~~~~~~~");
	}


}
