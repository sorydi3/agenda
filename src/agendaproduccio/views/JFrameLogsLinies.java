package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;

public class JFrameLogsLinies extends JFrame {

	/***************** ATTRIBUTS *******************/

	private static final String MAIN_TITLE = "Logs modificacio linia ";

	private static JFrameLogsLinies m_LogsModfFrame;
	public JPanelLogsLinies m_JpanelLogs;

	/*****************
	 * CONSTRUCTOR
	 * 
	 * @param p_orderLininia
	 **************************/

	private JFrameLogsLinies(OrderLiniaRutaPNavison p_orderLininia) {
		this.showWindow(p_orderLininia);
	}

	public static synchronized JFrameLogsLinies getInstance(OrderLiniaRutaPNavison p_orderLininia) {
		if (m_LogsModfFrame == null) {
			m_LogsModfFrame = new JFrameLogsLinies(p_orderLininia);
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
}
