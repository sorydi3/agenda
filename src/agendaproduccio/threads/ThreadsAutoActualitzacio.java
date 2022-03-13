package agendaproduccio.threads;

import java.time.LocalTime;
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
	private	boolean m_run;
	public ThreadsAutoActualitzacio (MyJTable p_jtable,ControllerAgenda p_controller,JButton p_jButonAct ){
		super();
		this.m_jtable = p_jtable;
		this.m_controller =p_controller;
		this.m_jButonAct =p_jButonAct;
		this.m_run = true;
		this.m_jButonAct.setText("<html> <font size = 2><b>" +LocalTime.now().toString()+" </b></font></html>");
	}

	@Override
	public void run() {
		while (this.m_run){
			System.out.println("THREAD RUNNNING!!!!");
			try {
				sleep(9000);
				System.currentTimeMillis();
				fillTable();
				this.m_jButonAct.setText("<html> <font size = 2><b>" +LocalTime.now().toString()+" </b></font></html>");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("STOPED THREADDDDDD!!!");
		//slee
	}

	private void fillTable() {
		setDate();
		m_jtable.buidarTaula();
		m_controller.clearData();
		m_controller.populateViewJTable(m_jtable, l_dataInici, l_dataFinal);
	}

	public void parar(){
		this.m_run=false;
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