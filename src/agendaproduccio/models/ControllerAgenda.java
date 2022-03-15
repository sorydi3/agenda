package agendaproduccio.models;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import agendaproduccio.models.entitatsbddAgenda.daos.OrdreLiniaRutaDAO;
import agendaproduccio.models.entitatsbddAgenda.daos.OrdrePNavisionFitxaTecnicaDAO;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.entitatsbddAgenda.model.OrdrePNavisionFitxaTecnica;
import agendaproduccio.views.renderers.jtables.MyJTable;

public class ControllerAgenda {
	private OrdreLiniaRutaDAO m_dadesBddDao;
	private OrdrePNavisionFitxaTecnicaDAO m_dadesBddFitxaDao;
	private final Map<String, Publicacio> m_ordres;
	private final Map<String, OrdrePNavisionFitxaTecnica> m_ordresFitxaTec;
	public static ControllerAgenda m_instanceSingleton;
	
	private ControllerAgenda() {
		this.m_ordres = new HashMap<>();
		m_ordresFitxaTec = new HashMap<>();
		m_dadesBddDao = OrdreLiniaRutaDAO.GetInstance();
	}
	
	
	public static  ControllerAgenda getInstance() {
		if(m_instanceSingleton==null) {
			m_instanceSingleton = new ControllerAgenda();
		}
		return m_instanceSingleton;
	}

	public void populateViewJTable(MyJTable view, Calendar p_dataInici, Calendar p_dataFinal) {
		this.retreaveDataBdd(p_dataInici, p_dataFinal);
		retreaveDataBDDFitxaTecnica(p_dataInici, p_dataFinal);
		for (Entry<String, Publicacio> publicacio : m_ordres.entrySet()) {
			publicacio.getValue().mostraTiratges(view);
		}
	}

	public void clearData() {
		this.m_ordres.clear();
	}

	public void retreaveDataBdd(Calendar p_dataInici, Calendar p_dataFinal) {
		for (OrderLiniaRutaPNavison l_tiratge : m_dadesBddDao.GetEntreDates(p_dataInici, p_dataFinal)) {
			String l_key = l_tiratge.m_nI_Num_Orden_Produccion_o;
			int l_idtiratge = l_tiratge.getM_nI_Identificador_Tiratge_l();
			if (!m_ordres.containsKey(l_key)) {
				m_ordres.put(l_key, new Publicacio());
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);
				;
			} else {
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);
				;
			}
		}
	}

	public void retreaveDataBDDFitxaTecnica(Calendar p_dataInici, Calendar p_dataFinal) {
		for (OrdrePNavisionFitxaTecnica l_ordre : m_dadesBddFitxaDao.getEntrades(p_dataInici, p_dataFinal)) {
			String l_key = l_ordre.m_nI_Num_Orden_Produccion;
			if (!m_ordresFitxaTec.containsKey(l_key)) {
				m_ordresFitxaTec.put(l_key, l_ordre);
			} else {
				// m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);;
				// PER LANS REPETITS
			}
		}
	}

	public OrdrePNavisionFitxaTecnica getOrderFitxaTecnica(String lan) {
		return m_ordresFitxaTec.get(lan);
	}
}
