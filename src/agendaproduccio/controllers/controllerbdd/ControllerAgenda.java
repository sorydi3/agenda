package agendaproduccio.controllers.controllerbdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.SwingWorker;

import agendaproduccio.models.Publicacio;
import agendaproduccio.models.entitatsbddAgenda.dao.LogsModificacionsDAO;
import agendaproduccio.models.entitatsbddAgenda.dao.OrdreLiniaRutaDAO;
import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.fitxatecnica.dao.OrdreProduccioFitxaTecnicaDAO;
import agendaproduccio.models.fitxatecnica.model.OrdreProduccioFitxaTecnica;
import agendaproduccio.utils.JPanelBuilder;
import agendaproduccio.views.MainFrame;
import agendaproduccio.views.renderers.jtables.JTableLinies;
import javafx.util.Pair;

public class ControllerAgenda {
	private OrdreLiniaRutaDAO m_dadesBddDao;
	private OrdreProduccioFitxaTecnicaDAO m_dadesBddFitxaDao;
	private LogsModificacionsDAO m_logsDao;
	private final Map<String, Pair<Publicacio, List<LogsModificacions>>> m_ordres; // Map<Lan,Pair<Publicacio,List<LogsModif>>>
	public static ControllerAgenda m_instanceSingleton;
	SwingWorker<Void, Void> l_swingWorkerLogs;

	private ControllerAgenda() {
		this.m_ordres = new TreeMap<>();
		m_dadesBddDao = OrdreLiniaRutaDAO.GetInstance();
		m_dadesBddFitxaDao = OrdreProduccioFitxaTecnicaDAO.GetInstance();
		m_logsDao = LogsModificacionsDAO.GetInstance();
	}

	public static ControllerAgenda getInstance() {
		if (m_instanceSingleton == null) {
			m_instanceSingleton = new ControllerAgenda();
		}
		return m_instanceSingleton;
	}

	public void populateViewJTable(JTableLinies view, Calendar p_dataInici, Calendar p_dataFinal, boolean filter,
			boolean dateFilter) {
		if (dateFilter)
			m_dadesBddDao.activateFilterByDate();
		retreaveDataBddTaulaLinies(p_dataInici, p_dataFinal);
		mostraLinies(view, filter);
		addLogsPublicacions(view);
		if (dateFilter)
			m_dadesBddDao.deactivateFilterByDate();

	}

	public void populateOrdres(JTableLinies view, Calendar p_dataInici, Calendar p_dataFinal, boolean filter,
			boolean dateFilter) {
		if (dateFilter)
			m_dadesBddDao.activateFilterByDate();
		retreaveDataBddTaulaLinies(p_dataInici, p_dataFinal);
		if (dateFilter)
			m_dadesBddDao.deactivateFilterByDate();

	}

	public void mostraLinies(JTableLinies view, boolean filter) {
		for (Entry<String, Pair<Publicacio, List<LogsModificacions>>> publicacio : m_ordres.entrySet()) {
			publicacio.getValue().getKey().mostraTiratges(view, filter);
		}
	}

	public void clearData() {
		this.m_ordres.clear();
	}

	private void retreaveDataBddTaulaLinies(Calendar p_dataInici, Calendar p_dataFinal) {
		for (OrderLiniaRutaPNavison l_tiratge : m_dadesBddDao.GetEntreDates(p_dataInici, p_dataFinal)) {
			String l_key = l_tiratge.m_nI_Num_Orden_Produccion_o.trim();
			int l_idtiratge = l_tiratge.getM_nI_Identificador_Tiratge_l();
			if (!m_ordres.containsKey(l_key)) {
				m_ordres.put(l_key, new Pair<>(new Publicacio(), new ArrayList<>()));
				m_ordres.get(l_key).getKey().afegirTiratge(l_idtiratge, l_tiratge);
			} else {
				m_ordres.get(l_key).getKey().afegirTiratge(l_idtiratge, l_tiratge);
			}
		}
	}

	public void addLogsPublicacions(JTableLinies view) {
		l_swingWorkerLogs = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				for (LogsModificacions l_log : m_logsDao.getEntrades("")) {
					String l_lan = l_log.getLan().trim();
					Pair<Publicacio, List<LogsModificacions>> l_ordre = m_ordres.get(l_lan);
					if (l_ordre != null) {
						l_ordre.getValue().add(l_log);
					} else {
					}
				}
				for (Entry<String, Pair<Publicacio, List<LogsModificacions>>> l_linia : m_ordres.entrySet()) {
					Publicacio l_publicacio = l_linia.getValue().getKey();
					List<LogsModificacions> l_listLogs = l_linia.getValue().getValue();
					l_listLogs.forEach((log) -> l_publicacio.afegirLogModf(log));
				}
				return null;
			}

			@Override
			protected void done() {
				MainFrame.getInstance().getGlassPane().setVisible(false);
				view.Buidar();
				mostraLinies(view, JPanelBuilder.m_checkBox.isSelected());
			}
		};
		l_swingWorkerLogs.execute();
	}

	public OrdreProduccioFitxaTecnica getOrderFitxaTecnica(String p_lan) {
		OrdreProduccioFitxaTecnica ord = m_dadesBddFitxaDao.GetFromCP(p_lan);
		return ord;
	}

	public void pararThreads() {
		if (!l_swingWorkerLogs.isDone()) {
			l_swingWorkerLogs.cancel(true);
		}
	}

	public void removePublicacionsWithData(Calendar m_dataSeleccionada) {
		for (Entry<String, Pair<Publicacio, List<LogsModificacions>>> publicacio : m_ordres.entrySet()) {
			publicacio.getValue().getKey().removePublicacionsWithData(m_dataSeleccionada);
		}
	}

	public void addpublicacionsWithData(Vector<Calendar> vectorDatesSeleccionades, JTableLinies view) {
		Calendar notUset = new GregorianCalendar(); // Case when we want to fetch all data from the dataBase
		boolean filterBydate = false;
		populateOrdres(view, notUset, notUset, JPanelBuilder.m_checkBox.isSelected(), filterBydate);
		for (Entry<String, Pair<Publicacio, List<LogsModificacions>>> publicacio_ : m_ordres.entrySet()) {
			publicacio_.getValue().getKey().removeAllExcept(vectorDatesSeleccionades);
		}
		mostraLinies(view, JPanelBuilder.m_checkBox.isSelected());
		addLogsPublicacions(view);
	}

}
