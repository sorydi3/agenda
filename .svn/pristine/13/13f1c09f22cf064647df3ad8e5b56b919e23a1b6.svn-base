package agendaproduccio.views;

import java.awt.BorderLayout;
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
		setLayout(new BorderLayout());
		m_jtaula.getTableHeader().setDefaultRenderer(new HeaderRenderrer());
		m_jspTaulaOrdres = new JScrollPaneTableGUI(m_jtaula);
		add(getHeaderJPanel(), BorderLayout.NORTH);
		add(m_jspTaulaOrdres, BorderLayout.CENTER);
		ompleJTable();
	}

	private JPanel getHeaderJPanel() {
		JPanel l_jpanel = new JPanel();
		JLabel l_jlabel = new JLabel("Cambis fets:");
		l_jpanel.add(l_jlabel);
		return l_jpanel;
	}
	

	private void ompleJTable() {
		List<LogsModificacions> l_listLogs = m_orderLininia.getLogs();
		l_listLogs.forEach((log) -> m_jtaula.AfegirFila(log));
	}
}
