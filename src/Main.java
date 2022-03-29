
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import agendaproduccio.views.MainFrame;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		System.setProperty("ipNavision", "10.46.100.28");
		System.setProperty("passdbControlPlanta", "lpc1232001");
		MainFrame.getInstance().activate();
	}
}
