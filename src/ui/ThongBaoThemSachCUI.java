package ui;

import java.io.PrintWriter;

public class ThongBaoThemSachCUI {
	private PrintWriter screenOutput = null;
	
	public ThongBaoThemSachCUI() {
		
	}
	
	public ThongBaoThemSachCUI(PrintWriter _screenOutput) {
		screenOutput = _screenOutput;
		
	}
	
	public void inThongBao(String noiDung) {
		screenOutput.println(noiDung);
	}
}
