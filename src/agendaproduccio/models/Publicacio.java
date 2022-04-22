package agendaproduccio.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import agendaproduccio.models.entitatsbddAgenda.model.LogsModificacions;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison.Tipus;
import agendaproduccio.views.renderers.jtables.JTableLinies;

public class Publicacio {

	Map<Integer, List<OrderLiniaRutaPNavison>> m_tiratges; // Map<NumTiratge,list<Linies>>
	private boolean m_esDuplicat;

	public Publicacio() {
		m_tiratges = new HashMap<>();
		m_esDuplicat = false;
	}

	// separo per id tiratge
	public void afegirTiratge(int p_keytiratge, OrderLiniaRutaPNavison tiratge) {
		if (!m_tiratges.containsKey(p_keytiratge)) {
			m_tiratges.put(p_keytiratge, new ArrayList<>());
			m_tiratges.get(p_keytiratge).add(tiratge);
		} else {
			m_tiratges.get(p_keytiratge).add(tiratge);
		}
	}

	public void afegirLogModf(LogsModificacions p_log) {
		if (p_log.esModfGlobal()) {
			afegirLogPerTots(p_log);
		} else {
			OrderLiniaRutaPNavison l_linia = getLinia(p_log.getIdLinia());
			if (l_linia != null) {
				l_linia.afegirModf(p_log);
			} else {
				// no es troba el log i no es global :( somthing weird is happening
			}
		}
	}

	private void afegirLogPerTots(LogsModificacions p_log) {
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			for (OrderLiniaRutaPNavison tiratge : publicacio.getValue()) {
				tiratge.afegirModf(p_log);
			}
		}
	}

	// private

	public OrderLiniaRutaPNavison getLinia(int idLinia) {
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			for (OrderLiniaRutaPNavison tiratge : publicacio.getValue()) {
				if (tiratge.getIdLinia() == idLinia) {
					return tiratge;
				}
			}
		}
		return null;
	}

	// fill columns -> ctp | imp | enc | alc | gll | dse | mae |
	public void postProcessing() {
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			for (OrderLiniaRutaPNavison tiratge : publicacio.getValue()) {
				if (tiratge.esImpressio()) {
					this.setColumnsValues(publicacio.getKey(), tiratge);
				}
			}
		}
	}

	private void setColumnsValues(int p_numTiratge, OrderLiniaRutaPNavison tiratge) {
		this.setColumn(Tipus.RCTP, tiratge, p_numTiratge);
		this.setColumn(Tipus.IMPRESSIO, tiratge, p_numTiratge);
		this.setColumn(Tipus.ENCART, tiratge, p_numTiratge);
		this.setColumn(Tipus.ALC, tiratge, p_numTiratge);
		this.setColumn(Tipus.GUILL, tiratge, p_numTiratge);
		this.setColumn(Tipus.MAE, tiratge, p_numTiratge);
		this.setColumn(Tipus.DSE, tiratge, p_numTiratge);
	}

	private void setColumn(Tipus tipus, OrderLiniaRutaPNavison tiratge, int numTiratge) {
		// PER LA RESTA DE COLUMNES
		List<OrderLiniaRutaPNavison> l_tiratge = this.m_tiratges.get(numTiratge);
		String lan_prod = tiratge.m_nI_Num_Orden_Produccion_o;
		int index_el = l_tiratge.indexOf(new OrderLiniaRutaPNavison(tipus, lan_prod));
		if (index_el != -1) {
			OrderLiniaRutaPNavison l_ordre_tipus = l_tiratge.get(index_el);
			tiratge.setColumn(tipus, l_ordre_tipus.getM_uI_Estado_r());
		}

		int[] arrIndex = new int[] { 0, 90, 91 }; // possibles index
		if (tipus == Tipus.ALC || tipus == Tipus.DSE || tipus == Tipus.ENCART || tipus == Tipus.MAE) {
			int l_index = 0;
			boolean l_trobat = false;
			while (!l_trobat && l_index < arrIndex.length) {
				List<OrderLiniaRutaPNavison> llista_tiratge_global = this.m_tiratges.get(arrIndex[l_index]);
				if (llista_tiratge_global != null) {
					int index_el_global = llista_tiratge_global.indexOf(new OrderLiniaRutaPNavison(tipus, lan_prod));
					if (index_el_global != -1) {
						OrderLiniaRutaPNavison l_ordre_tipus_global = llista_tiratge_global.get(index_el_global);
						tiratge.setColumn(tipus, l_ordre_tipus_global.getM_uI_Estado_r());
						l_trobat = true;
					} else {
						if (tipus == Tipus.ALC) {
						}
					}
				}
				l_index++;
			}
		}
	}

	public void mostraTiratges(JTableLinies view, boolean filter) {
		postProcessing(); // OMPLE LES COLUMNES ctp | imp | enc | alc | gll | dse | mae |
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			if (publicacio.getKey() > 0) {
				for (OrderLiniaRutaPNavison tiratge : publicacio.getValue()) {
					if (tiratge.esImpressio() && (filter ? tiratge.esMenorDtaJobTicket() : true) && !m_esDuplicat) {
						view.AfegirFila(tiratge);
						m_esDuplicat = true;
					}
				}
				m_esDuplicat = false;
			}
		}
	}

	public String getLanPublicacio() {
		return this.m_tiratges.size() == 0 ? " " : this.m_tiratges.get(0).get(0).getM_nI_Num_Orden_Produccion_l();
	}

	public void removePublicacionsWithData(Calendar data) {
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			ListIterator<OrderLiniaRutaPNavison> iter = publicacio.getValue().listIterator();
			while (iter.hasNext()) {
				OrderLiniaRutaPNavison ordre = iter.next();
				if (ordre.esImpressio()) {
					if (ordre.getDataCalendar().equals(data)) {
						iter.remove();
					}
				}
			}
		}
	}

	public void removeAllExcept(Vector<Calendar> vectorDatesSeleccionades) {
		Vector<OrderLiniaRutaPNavison> removed = new Vector<OrderLiniaRutaPNavison>();
		for (Entry<Integer, List<OrderLiniaRutaPNavison>> publicacio : m_tiratges.entrySet()) {
			ListIterator<OrderLiniaRutaPNavison> iter = publicacio.getValue().listIterator();
			while (iter.hasNext()) {
				OrderLiniaRutaPNavison ordre = iter.next();
				if (!esUnadeLesDates(ordre, vectorDatesSeleccionades, removed)) {
					iter.remove();
				}
			}
		}
	}

	private boolean esUnadeLesDates(OrderLiniaRutaPNavison linies, Vector<Calendar> vectorDatesSeleccionades,
			Vector<OrderLiniaRutaPNavison> removed) {
		boolean trobat = false;
		ListIterator<Calendar> it = vectorDatesSeleccionades.listIterator();
		while (!trobat && it.hasNext()) {
			Calendar aux = it.next();
			if (compareCalendarDates(linies.getDataCalendar(), aux)) {
				trobat = true;
			}
		}

		return trobat;
	}

	private boolean compareCalendarDates(Calendar cal1, Calendar cal2) {
		boolean result = false;
		if (cal1 != null && cal2 != null) {
			result = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
					&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
					&& cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
		}
		return result;
	}
}
