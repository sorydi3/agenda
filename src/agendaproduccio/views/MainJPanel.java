package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.threads.ThreadsAutoActualitzacio;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.utils.JPanellCalendari;
import agendaproduccio.utils.JScrollPaneTableGUI;
import agendaproduccio.utils.MyJTextField;
import agendaproduccio.views.renderers.HeaderRenderrer;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class MainJPanel extends JPanel {
	private JTableLinies m_jtaula;
	private MyJTextField m_jtextField;
	private JPanellCalendari m_calendari_inici, m_calendari_final;
	private JComboBox<String> m_jcombo;
	private JButton m_jButtonXml, m_imprimir, m_refresh;
	private JScrollPaneTableGUI m_jspTaulaOrdres;
	private ControllerAgenda m_controllerAgenda;
	private Calendar l_dataInici;
	private Calendar l_dataFinal;
	private ThreadsAutoActualitzacio m_threadAct;
	private JFrame m_parentFrame;

	public MainJPanel(MainFrame p_mainFrame) {
		this.m_parentFrame = p_mainFrame;
		initVariables();
		setLayout(new BorderLayout());
		JPanel l_panelHeaders = JPanelBuilder.BuildHeader(this);
		add(l_panelHeaders, BorderLayout.NORTH);
		m_jtaula.getTableHeader().setDefaultRenderer(new HeaderRenderrer());
		m_jspTaulaOrdres = new JScrollPaneTableGUI(m_jtaula);
		add(m_jspTaulaOrdres, BorderLayout.CENTER);
		// this.addListenerButton(m_jButtonXml);
		// this.addListenerButton(m_imprimir);
		this.addListenerButton(m_refresh);
		fillTable();
		initThread();
	}

	public void initThread() {
		m_threadAct = new ThreadsAutoActualitzacio(m_jtaula, m_controllerAgenda, m_refresh);
		m_threadAct.start();
		m_parentFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(m_parentFrame, "Are you sure you want to close this window?",
						"Close Window?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					m_threadAct.parar();
					System.exit(0);
				}
			}
		});
	}

	private void initVariables() {
		this.m_calendari_inici = new JPanellCalendari();
		this.m_calendari_final = new JPanellCalendari();
		JPanelBuilder.m_calendari_inici = this.m_calendari_inici;

		JPanelBuilder.m_calendari_final = this.m_calendari_final;

		this.m_imprimir = new JButton();
		JPanelBuilder.m_imprimir = this.m_imprimir;
		this.m_jButtonXml = new JButton();
		JPanelBuilder.m_jButtonXml = this.m_jButtonXml;
		this.m_jtextField = new MyJTextField("img_buscar.png", "Capcelera  \\  M�quina  \\  Paper ...");
		JPanelBuilder.m_jtextField = this.m_jtextField;
		this.m_refresh = new JButton();
		JPanelBuilder.m_refresh = this.m_refresh;
		this.m_jcombo = new JComboBox<>();
		JPanelBuilder.m_jcombo = this.m_jcombo;
		JPanelBuilder.DIMENTION_WIDTH_CALENDAR = this.getWidth();
		this.m_jtaula = new JTableLinies(m_jtextField);
		m_jtextField.addJtable(m_jtaula);
		this.m_controllerAgenda = ControllerAgenda.getInstance();
	}

	private void addListenerButton(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 1) {
					fillTable();
					m_refresh.setText(m_threadAct.getTime());
				}
			}

		});
	}

	private void fillTable() {
		setDate();
		m_jtaula.buidarTaula();
		m_controllerAgenda.clearData();
		SwingWorker l_swingWorker = new SwingWorker<Void,Void>() {
			//LodingFrame loading = new LodingFrame();
			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				MainFrame.getInstance().getGlassPane().setVisible(true);
				m_controllerAgenda.populateViewJTable(m_jtaula, l_dataInici, l_dataFinal);
				return null;
			}
			
			@Override
			protected void done() {
				MainFrame.getInstance().getGlassPane().setVisible(false);
				//loading.amaga();
			}
			
		};
		l_swingWorker.execute();
	}

	private void setDate() {
		l_dataInici = JPanelBuilder.m_calendari_inici.GetDataCalendarFormat();
		l_dataInici.set(Calendar.HOUR_OF_DAY, 0);
		l_dataInici.set(Calendar.MINUTE, 0);
		l_dataInici.set(Calendar.SECOND, 0);

		l_dataFinal = JPanelBuilder.m_calendari_final.GetDataCalendarFormat();
		l_dataFinal.set(Calendar.HOUR_OF_DAY, 23);
		l_dataFinal.set(Calendar.MINUTE, 59);
		l_dataFinal.set(Calendar.SECOND, 59);
		l_dataFinal.add(Calendar.DAY_OF_MONTH, +1);
	}

}