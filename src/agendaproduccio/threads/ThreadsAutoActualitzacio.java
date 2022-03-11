package agendaproduccio.threads;

import java.util.Calendar;
import javax.swing.JButton;
import agendaproduccio.models.ControllerAgenda;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.views.renderers.jtables.MyJTable;

public class ThreadsAutoActualitzacio extends Thread {
	MyJTable m_jtable;
	ControllerAgenda m_controller;
	JButton m_jButonAct;
	private Calendar l_dataInici;
	private Calendar l_dataFinal;
	ThreadsAutoActualitzacio (MyJTable p_jtable,ControllerAgenda p_controller,JButton p_jButonAct ){
		super();
		this.m_jtable = p_jtable;
		this.m_controller =p_controller;
		this.m_jButonAct =p_jButonAct;
		
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		//super.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		fillTable();
	}
	
	private void fillTable() {
		setDate();
		m_jtable.buidarTaula();
		m_controller.clearData();
		m_controller.populateViewJTable(m_jtable, l_dataInici, l_dataFinal);
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
