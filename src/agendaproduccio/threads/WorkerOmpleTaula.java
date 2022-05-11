package agendaproduccio.threads;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.views.MainFrame;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class WorkerOmpleTaula extends SwingWorker<Void, Void> {

	private JTableLinies m_table;
	private boolean isDone;

	public WorkerOmpleTaula() {
		m_table = null;
	}

	@Override
	protected Void doInBackground() throws Exception {
		if (m_table != null) {
			m_table.buidarTaula();
			ControllerAgenda.getInstance().clearData();
			isDone = false;
			Vector<Calendar> llistaDatesSeleccionades = JPanelBuilder.m_calendari_inici.getllistaDatasSeleccionades();
			MainFrame.getInstance().getGlassPane().setVisible(true);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					if (!llistaDatesSeleccionades.isEmpty()) {
						ControllerAgenda.getInstance().addpublicacionsWithData(llistaDatesSeleccionades, m_table);
					} else {
						Calendar dummyData = new GregorianCalendar();
						ControllerAgenda.getInstance().populateViewJTable(m_table, dummyData, dummyData,
								JPanelBuilder.m_checkBox.isSelected(), false);
					}
				}
			});
		} else {
			System.out.println("VARIBALE JTBALE IS NULL");
			return null;
		}
		return null;
	}

	@Override
	protected void done() {
		//MainFrame.getInstance().getGlassPane().setVisible(false);
		return;
	}

	public void setJtable(JTableLinies m_jtaula2) {
		this.m_table = m_jtaula2;
	}

}
