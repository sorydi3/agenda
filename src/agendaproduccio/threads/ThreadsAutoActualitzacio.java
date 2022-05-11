package agendaproduccio.threads;

import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class ThreadsAutoActualitzacio extends Thread {
	JTableLinies m_jtable;
	ControllerAgenda m_controller;
	JButton m_jButonAct;
	WorkerOmpleTaula m_worker;
	private boolean m_run;
	private int m_timeIntervalRefresh;

	public ThreadsAutoActualitzacio(JTableLinies p_jtable, ControllerAgenda p_controller, JButton p_jButonAct) {
		super();
		this.m_jtable = p_jtable;
		this.m_controller = p_controller;
		this.m_jButonAct = p_jButonAct;
		this.m_run = true;
		this.m_jButonAct.setText(getTime());
		this.m_timeIntervalRefresh = Integer.parseInt(System.getProperty("intervalAct"));
		m_worker = new WorkerOmpleTaula();
		m_worker.setJtable(m_jtable);
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
						ompleTaula();
						m_jButonAct.setText(getTime());
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		m_controller.pararThreads();
	}

	public void ompleTaula() {
		m_worker = new WorkerOmpleTaula();
		m_worker.setJtable(m_jtable);
		m_worker.execute();
	}

	public void parar() {
		this.m_run = false;
	}
}
