package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.utils.JScrollPaneTableGUI;
import agendaproduccio.views.renderers.HeaderRenderrer;
import agendaproduccio.views.renderers.jtables.JTableLogs;

public class JPanelLogsLinies extends JPanel {
	private JTableLogs m_jtaula;
	private JScrollPaneTableGUI m_jspTaulaOrdres;
	private final OrderLiniaRutaPNavison m_orderLininia;

	public JPanelLogsLinies(OrderLiniaRutaPNavison p_orderLininia) {
		super();
		m_jtaula = new JTableLogs();
		m_orderLininia = p_orderLininia;
		setLayout(new BorderLayout(200,0));
		m_jtaula.getTableHeader().setDefaultRenderer(new HeaderRenderrer());
		m_jspTaulaOrdres = new JScrollPaneTableGUI(m_jtaula);
		add(getHeaderJPanel(), BorderLayout.NORTH);
		add(m_jspTaulaOrdres, BorderLayout.CENTER);
		JPanel l_panel = new JPanel();
		l_panel.setPreferredSize(new Dimension(0,38));
		l_panel.setBackground(Color.white);
		add(l_panel, BorderLayout.SOUTH);
		ompleJTable();
	}

	private JPanel getHeaderJPanel() {
		JPanel l_jpanel = new JPanel();
		JLabel l_jlabel = new JLabel("<html><font size = 7 ><b>Historial de canvis:</b></font></html>");
		l_jpanel.add(l_jlabel);
		return l_jpanel;
	}
	

	private void ompleJTable() {
		List<LogsModificacions> l_listLogs = m_orderLininia.getLogs();
		l_listLogs.forEach((log) -> m_jtaula.AfegirFila(log));
	}
}
