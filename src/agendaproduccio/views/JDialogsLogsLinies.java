package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;

public class JDialogsLogsLinies extends JDialog {

	/***************** ATTRIBUTS *******************/

	private static final String MAIN_TITLE = "Logs modificació";

	private static JDialogsLogsLinies m_LogsModfFrame;
	public static JPanelLogsLinies m_JpanelLogs;

	/*****************
	 * CONSTRUCTOR
	 * 
	 * @param p_orderLininia
	 **************************/

	private JDialogsLogsLinies(OrderLiniaRutaPNavison p_orderLininia) {
		this.showWindow(p_orderLininia);
	}

	public static synchronized JDialogsLogsLinies getInstance(OrderLiniaRutaPNavison p_orderLininia) {
		if (m_LogsModfFrame == null) {
			m_LogsModfFrame = new JDialogsLogsLinies(p_orderLininia);
		} else {
			m_JpanelLogs.setVisible(false);
			m_LogsModfFrame.actualitza(p_orderLininia);
			m_LogsModfFrame.setAlwaysOnTop(true);
		}
		return m_LogsModfFrame;
	}

	public void activate() {
		setVisible(true);
	}

	public void desactivate() {
		setVisible(false);
	}

	private void showWindow(OrderLiniaRutaPNavison p_orderLininia) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		getContentPane().setLayout(new BorderLayout());
		setVisible(false);
		setTitle(MAIN_TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		m_JpanelLogs = new JPanelLogsLinies(p_orderLininia);
		add(m_JpanelLogs);
	}

	public void actualitza(OrderLiniaRutaPNavison p_order) {
		showWindow(p_order);
	}
}
