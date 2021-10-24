package Manager;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMessage(String str) {
		String msg;

		switch (str) {
		case "fill":
			msg = "Lütfen tüm alanlarý doldurunuz.";
			break;
		case "succes":
			msg = "Ýþlem Baþarýlý";
			break;
		default:
			msg = str;
			break;

		}

		JOptionPane.showInternalMessageDialog(null, msg, "title", JOptionPane.INFORMATION_MESSAGE);

	}

	public static boolean confirmMessage(String str) {
		String msg;

		switch (str) {
		case "sure":
			msg = "Bu iþlemi yapmak istediðinizden emin misiniz ?";
			break;
		default:
			msg = str;
			break;

		}

		int res = JOptionPane.showConfirmDialog(null, msg, "Mesaj", JOptionPane.YES_NO_OPTION);

		if(res == 0) {
			return true;
		}else {
			return false;
		}
		
		

	}

}
