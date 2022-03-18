package agendaproduccio.controllers.controllerbdd;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import agendaproduccio.models.Publicacio;
import agendaproduccio.models.entitatsbddAgenda.daos.LogsModificacionsDAO;
import agendaproduccio.models.entitatsbddAgenda.daos.OrdreLiniaRutaDAO;
import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.fitxatecnica.dao.OrdreProduccioFitxaTecnicaDAO;
import agendaproduccio.models.fitxatecnica.model.OrdreProduccioFitxaTecnica;
import agendaproduccio.views.renderers.jtables.MyJTable;

public class ControllerAgenda {
	private OrdreLiniaRutaDAO m_dadesBddDao;
	private OrdreProduccioFitxaTecnicaDAO m_dadesBddFitxaDao;
	private LogsModificacionsDAO m_logsDao;
	private final Map<String, Publicacio> m_ordres;
	private final Map<String, LogsModificacions> m_logsModifLinies;
	public static ControllerAgenda m_instanceSingleton;

	private ControllerAgenda() {
		this.m_ordres = new HashMap<>();
		m_logsModifLinies = new HashMap<>();
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

	public void populateViewJTable(MyJTable view, Calendar p_dataInici, Calendar p_dataFinal) {
		this.retreaveDataBdd(p_dataInici, p_dataFinal);
		addLogsPublicacions();
		for (Entry<String, Publicacio> publicacio : m_ordres.entrySet()) {
			publicacio.getValue().mostraTiratges(view);
		}
	}

	public void clearData() {
		this.m_ordres.clear();
	}

	private void retreaveDataBdd(Calendar p_dataInici, Calendar p_dataFinal) {
		for (OrderLiniaRutaPNavison l_tiratge : m_dadesBddDao.GetEntreDates(p_dataInici, p_dataFinal)) {
			String l_key = l_tiratge.m_nI_Num_Orden_Produccion_o;
			int l_idtiratge = l_tiratge.getM_nI_Identificador_Tiratge_l();
			if (!m_ordres.containsKey(l_key)) {
				m_ordres.put(l_key, new Publicacio());
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);
			} else {
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);
			}
		}
	}

	public void addLogsPublicacions() {
		//millorar, nomes fer un selecte
		for (Entry<String, Publicacio> l_llistaPublicacio : m_ordres.entrySet()) {
			Publicacio l_publicacio = l_llistaPublicacio.getValue();
			for (LogsModificacions l_log : m_logsDao.getEntrades(l_llistaPublicacio.getKey())) {
				//System.out.println(l_log);
				l_publicacio.afegirLogModf(l_log);
			}
		}
		System.out.println("hellow");
	}

	public OrdreProduccioFitxaTecnica getOrderFitxaTecnica(String p_lan) {
		OrdreProduccioFitxaTecnica ord = m_dadesBddFitxaDao.GetFromCP(p_lan);
		return ord;
	}
}
