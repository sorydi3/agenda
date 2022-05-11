package agendaproduccio.utils;

import java.awt.Color;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public abstract class JTableGUI extends JTable {
	/*
	 * INSTRUCCIONS D'�S: � Les que hereden d'aquesta taula, han de tenir una
	 * crida a 'ConfigurarTaula( p_numColumnes )' en el seu creador � CrearModel()
	 * ha de retornar un model amb els noms de les columnes de la taula �
	 * ConfigurarColumnes() estableix l'amplada de les columnes, els seus renderers,
	 * comparadors, i si poden ser copiades � PrepararRendererCasella(renderer,
	 * row, col, casella) serveix per gestions a fer un cop es tenen dades (tooltip,
	 * canvis de background, etc.)
	 */

	// ATRIBUTS
	// Columnes
	protected int TOTAL_COLUMNES = 0;

	// Model i Sorter
	protected DefaultTableModel m_model;
	protected TableRowSorter<DefaultTableModel> m_sorter;

	// Altres
	protected Object[] m_fila;
	protected Comparator<String> m_comparadorEnters;

	// M�TODES P�BLICS
	// Crear
	public JTableGUI() {
		super();
		ConfigurarTaula();
	}

	// Actualitzar
	public void Buidar() {
		m_model.setRowCount(0);
	}

	// M�TODES PRIVATS
	// Abstractes
	protected abstract void ConfigurarTotalColumnes();

	protected abstract DefaultTableModel CrearModel();

	protected abstract void ConfigurarColumnes();

	protected abstract void configuraRenderers();
	
	protected abstract void ConfigurarSorter();

	// Actualitzar
	protected void BuidarFila() {
		for (int i = 0; i < TOTAL_COLUMNES; i++) {
			m_fila[i] = "";
		}
	}

	// Configurar
	private void ConfigurarTaula() {
		ConfigurarTotalColumnes();
		ConfigurarModel();
		ConfigurarSorter();
		ConfigurarVisualitzacio();
	}

	private void ConfigurarModel() {
		m_fila = new Object[TOTAL_COLUMNES];
		m_model = CrearModel();
		setModel(m_model);
	}

	public Comparator<String> getStringComparator() {
		// String format is xx.xx or x.xxx etc ...
		Comparator<String> l_comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int l_temp1, l_temp2;
				try {
					l_temp1 = Integer.parseInt(o1.replace(".", ""));
					l_temp2 = Integer.parseInt(o2.replace(".", ""));

					if (l_temp1 > l_temp2) {
						return -1;
					}	
					if (l_temp1 < l_temp2) {
						return 1;
					}
				} catch (Exception e) {
					System.out.println(" FAIL COMPARATOR TIRADA: " + e);
				}
				return 0;
			}
		};

		return l_comparator;
	}

	public Comparator<String> getDateComparator() {
		Comparator<String> l_comparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				String l_data1, l_data2;
				try {
					String l_hora;
					l_hora = (name1.substring(name1.indexOf(" ") + 1, name1.length())).trim();
					l_data1 = (name1.substring(0, name1.indexOf(" "))).trim();
					String l_data[] = l_data1.split("/");
					l_data1 = l_data[2] + "-" + l_data[1] + "-" + l_data[0] + " " + l_hora;
				} catch (Exception e) {
					l_data1 = "";
				}

				try {
					String l_hora;
					l_hora = (name2.substring(name2.indexOf(" ") + 1, name2.length())).trim();
					l_data2 = (name2.substring(0, name2.indexOf(" "))).trim();
					String l_data[] = l_data2.split("/");
					l_data2 = l_data[2] + "-" + l_data[1] + "-" + l_data[0] + " " + l_hora;
				} catch (Exception e) {
					l_data2 = "";
				}

				return l_data1.compareTo(l_data2);
			}
		};
		return l_comparator;
	}

	private void ConfigurarVisualitzacio() {
		// Opcions Generals
		getTableHeader().setReorderingAllowed(false);
		setRowHeight(20);
		setSelectionBackground(Color.cyan);
		setSelectionForeground(Color.black);

	}

	public TableRowSorter<DefaultTableModel> getSorter() {
		return this.m_sorter;
	}
}