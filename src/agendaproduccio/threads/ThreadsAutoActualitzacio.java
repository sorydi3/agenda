package agendaproduccio.threads;

import java.time.LocalTime;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.views.MainFrame;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class ThreadsAutoActualitzacio extends Thread {
	JTableLinies m_jtable;
	ControllerAgenda m_controller;
	JButton m_jButonAct;
	private Calendar l_dataInici;
	private Calendar l_dataFinal;
	private boolean m_run;
	private int m_timeIntervalRefresh;

	public ThreadsAutoActualitzacio(JTableLinies p_jtable, ControllerAgenda p_controller, JButton p_jButonAct) {
		super();
		this.m_jtable = p_jtable;
		this.m_controller = p_controller;
		this.m_jButonAct = p_jButonAct;
		this.m_run = true;
		this.m_jButonAct.setText(getTime());
		this.m_timeIntervalRefresh = 180000;
	}

	public String getTime() {
		StringBuilder builder = new StringBuilder();
		String l_t = LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond();
		builder.append("<html> <font size = 1.2 ><b>").append(l_t).append("</b></font></html>");
		return builder.toString();
	}

	@Override
	public void run() {
		while (this.m_run) {
			try {
				sleep(m_timeIntervalRefresh);
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						fillTable();
						m_jButonAct.setText(getTime());
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		m_controller.pararThreads();
	}

	private void fillTable() {
		setDate();
		m_jtable.buidarTaula();
		m_controller.clearData();
		SwingWorker<Void, Void> l_swingWorker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				MainFrame.getInstance().getGlassPane().setVisible(true);
				m_controller.populateViewJTable(m_jtable, l_dataInici, l_dataFinal,
						JPanelBuilder.m_checkBox.isSelected());
				return null;
			}

			@Override
			protected void done() {
				MainFrame.getInstance().getGlassPane().setVisible(false);
			}
		};
		l_swingWorker.execute();
	}

	public void parar() {
		this.m_run = false;
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

}
