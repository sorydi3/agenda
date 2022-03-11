package agendaproduccio.models;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import agendaproduccio.models.entitatsbddAgenda.daos.OrdreLiniaRutaDAO;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.views.renderers.jtables.MyJTable;

public class ControllerAgenda {
	private OrdreLiniaRutaDAO m_dadesBddDao;
	private final Map<String, Publicacio> m_ordres;

	public ControllerAgenda() {
		this.m_ordres = new HashMap<>();
		m_dadesBddDao = OrdreLiniaRutaDAO.GetInstance();
	}

	public void populateViewJTable(MyJTable view, Calendar p_dataInici, Calendar p_dataFinal) {
		this.retreaveDataBdd(p_dataInici, p_dataFinal);
		for(Entry<String, Publicacio> publicacio : m_ordres.entrySet()) {
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
			if(!m_ordres.containsKey(l_key)) {
				m_ordres.put(l_key,new Publicacio());
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);;
			}else {
				m_ordres.get(l_key).afegirTiratge(l_idtiratge, l_tiratge);;
			}
		}
	}
}
