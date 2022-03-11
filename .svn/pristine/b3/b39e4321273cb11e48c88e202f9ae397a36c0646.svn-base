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

	// Actualitzar
	protected void BuidarFila() {
		for (int i = 0; i < TOTAL_COLUMNES; i++) {
			m_fila[i] = "";
		}
	}

	// Configurar
	private void ConfigurarTaula() {
		ConfigurarTotalColumnes();
		// configuraRenderers();
		ConfigurarModel();
		ConfigurarSorter();
		ConfigurarVisualitzacio();
	}

	private void ConfigurarModel() {
		m_fila = new Object[TOTAL_COLUMNES];
		m_model = CrearModel();
		setModel(m_model);
	}
	
	
	
	private void ConfigurarSorter() {
		m_sorter = new TableRowSorter<DefaultTableModel>(m_model);
		setRowSorter(m_sorter);
		m_comparadorEnters = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				try {
					return (Integer.parseInt(o1)) - (Integer.parseInt(o2));
				} catch (Exception e) {
				}

				return o1.compareTo(o2);
			}
		};
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