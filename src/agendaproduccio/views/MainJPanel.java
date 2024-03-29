package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.threads.ThreadsAutoActualitzacio;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.utils.JPanellCalendari;
import agendaproduccio.utils.JScrollPaneTableGUI;
import agendaproduccio.utils.MyJTextField;
import agendaproduccio.views.renderers.HeaderRenderrer;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class MainJPanel extends JPanel implements ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTableLinies m_jtaula;
	private MyJTextField m_jtextField;
	private JPanellCalendari m_calendari_inici, m_calendari_final;
	private JButton m_refresh;
	private JScrollPaneTableGUI m_jspTaulaOrdres;
	private ControllerAgenda m_controllerAgenda;
	private Calendar l_dataInici;
	private Calendar l_dataFinal;
	private ThreadsAutoActualitzacio m_threadAct;
	private JFrame m_parentFrame;
	private boolean isDone;
	private JCheckBox m_checkBox;

	public MainJPanel(MainFrame p_mainFrame) {
		super();
		isDone = true;
		this.m_parentFrame = p_mainFrame;
		initVariables();
		setLayout(new BorderLayout());
		JPanel l_panelHeaders = JPanelBuilder.BuildHeader(this);
		add(l_panelHeaders, BorderLayout.NORTH);
		m_jtaula.getTableHeader().setDefaultRenderer(new HeaderRenderrer());
		m_jspTaulaOrdres = new JScrollPaneTableGUI(m_jtaula);
		add(m_jspTaulaOrdres, BorderLayout.CENTER);
		JPanel l_panel = new JPanel();
		l_panel.setPreferredSize(new Dimension(0, 20));
		l_panel.setBackground(Color.white);
		add(l_panel, BorderLayout.SOUTH);
		this.addListenerButton(m_refresh);
		fillTable(false);
		initThread();
	}

	public void initThread() {
		m_threadAct = new ThreadsAutoActualitzacio(m_jtaula, m_controllerAgenda, m_refresh);
		m_threadAct.start();
		m_parentFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				m_threadAct.parar();
				System.exit(0);
			}
		});
	}

	private void initVariables() {
		m_checkBox = new JCheckBox("<html><b>Filtrar per Data Job Ticket &lt; Data �ltim canvi</b></html>");
		JPanelBuilder.m_checkBox = this.m_checkBox;
		m_checkBox.addItemListener(this);
		this.m_calendari_inici = new JPanellCalendari();
		this.m_calendari_final = new JPanellCalendari();
		JPanelBuilder.m_calendari_inici = this.m_calendari_inici;
		JPanelBuilder.m_calendari_final = this.m_calendari_final;
		this.m_jtextField = new MyJTextField("img_buscar.png", "Capcelera  \\  M�quina  \\  Paper ...");
		JPanelBuilder.m_jtextField = this.m_jtextField;
		this.m_refresh = new JButton();
		JPanelBuilder.m_refresh = this.m_refresh;
		JPanelBuilder.DIMENTION_WIDTH_CALENDAR = this.getWidth();
		this.m_jtaula = new JTableLinies(m_jtextField);
		m_jtextField.addJtable(m_jtaula);
		this.m_controllerAgenda = ControllerAgenda.getInstance();
		m_calendari_inici.setJtable(m_jtaula);
		m_calendari_final.setJtable(m_jtaula);
	}

	private void addListenerButton(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getClickCount() == 1) {
					fillTable(false);
					m_refresh.setText(m_threadAct.getTime());
				}
			}

		});
	}

	private void fillTable(boolean filter) {
		if (isDone) {
			setDate();
			m_jtaula.buidarTaula();
			m_controllerAgenda.clearData();
			SwingWorker<Void, Void> l_swingWorker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					isDone = false;
					MainFrame.getInstance().getGlassPane().setVisible(true);
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							
							m_controllerAgenda.populateViewJTable(m_jtaula, l_dataInici, l_dataFinal, filter,false);
						}
					});
					return null;
				}

				@Override
				protected void done() {
					isDone = true;
				}
			};
			l_swingWorker.execute();
		}
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
	}
	
	
	//private void

	@Override
	public void itemStateChanged(ItemEvent e) {
		fillTable(e.getStateChange() == 1 ? true : false);
	}

}