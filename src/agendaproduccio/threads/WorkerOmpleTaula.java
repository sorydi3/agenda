package agendaproduccio.threads;

import javax.swing.SwingWorker;

import agendaproduccio.views.renderers.jtables.JTableLinies;

public class WorkerOmpleTaula extends SwingWorker<Void, Void> {

	private JTableLinies m_table;

	public WorkerOmpleTaula(JTableLinies p_jtable) {
		m_table = p_jtable;
	}

	@Override
	protected Void doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
