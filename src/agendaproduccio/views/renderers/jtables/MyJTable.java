package agendaproduccio.views.renderers.jtables;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.utils.JTableGUI;
import agendaproduccio.utils.MyJTextField;
import agendaproduccio.views.renderers.HighlightRenderer;
import agendaproduccio.views.renderers.IntegerRenderer;
import agendaproduccio.views.renderers.StringRenderer;

public class MyJTable extends JTableGUI {
	// ATR.
	private final int m_pla = 0;
	private final int m_com = 1;
	private final int m_part = 2;
	private final int m_capcelera = 3;
	private final int m_tir = 4;
	private final int m_maq = 5;
	private final int m_dh = 6;
	private final int m_tirada = 7;
	private final int m_pag = 8;
	private final int m_fp = 9;
	private final int m_paper = 10;
	private final int m_ctp = 11;
	private final int m_imp = 12;
	private final int m_enc = 13;
	private final int m_alc = 14;
	private final int m_gll = 15;
	private final int m_dse = 16;
	private final int m_mae = 17;
	private final int m_codColo = 18;
	private final int m_pathComandaPdf = 19;
	private final MyJTextField m_jtext;
	private boolean m_color;

	// --------------------- Constructors -------------------------------------
	public MyJTable() {
		super();
		this.m_jtext = null;
		this.configuraRenderers();
		ConfigurarColumnes();
	}

	public MyJTable(MyJTextField jtext) {
		super();
		m_jtext = jtext;
		this.configuraRenderers();
		ConfigurarColumnes();
	}

	// ------------------------ Modificadors ----------------------------------

	public void AfegirFila(Object p_capcelera) {
		BuidarFila();
		OrderLiniaRutaPNavison l_linia = (OrderLiniaRutaPNavison) p_capcelera;
		m_fila[m_pla] = false;
		m_fila[m_com] = l_linia.getIdComanda();
		m_fila[m_part] = l_linia.getParte();
		m_fila[m_capcelera] = l_linia.getDescription();
		m_fila[m_tir] = l_linia.m_nI_Identificador_Tiratge_l;
		m_fila[m_maq] = l_linia.getM_nI_Nom_Maquina_l();
		m_fila[m_dh] = l_linia.getDataHora();
		m_fila[m_tirada] = l_linia.getTirada();
		m_fila[m_pag] = l_linia.getM_nI_No_Planes_Totals_Tiratge_l();
		m_fila[m_fp] = l_linia.getM_nI_Plegat_Tiratge_l();
		m_fila[m_paper] = l_linia.getPaper();
		m_fila[m_ctp] = l_linia.getM_ctp();
		m_fila[m_imp] = l_linia.getM_imp();
		m_fila[m_enc] = l_linia.getM_enc();
		m_fila[m_alc] = l_linia.getM_alc();
		m_fila[m_gll] = l_linia.getM_gll();
		m_fila[m_dse] = l_linia.getM_dse();
		m_fila[m_mae] = l_linia.getM_mae();
		m_fila[m_codColo] = l_linia.GetEstat();
		m_fila[m_pathComandaPdf] = l_linia.getPathPdf();
		m_model.addRow(m_fila);
	}

	public void activateColorBackground() {
		this.m_color = true;
	}

	// MTD PRV
	@Override
	protected void ConfigurarTotalColumnes() {
		TOTAL_COLUMNES = 20;
	}

	@Override
	protected DefaultTableModel CrearModel() {
		m_fila[m_pla] = "Pla.";
		m_fila[m_com] = "Com.";
		m_fila[m_part] = "Part.";
		m_fila[m_capcelera] = "Cap\\çelera";
		m_fila[m_tir] = "Tir.";
		m_fila[m_maq] = "M\\àq.";
		m_fila[m_dh] = "D\\H";
		m_fila[m_tirada] = "Tirada";
		m_fila[m_pag] = "P\\àg.";

		m_fila[m_fp] = "F\\P";
		m_fila[m_paper] = "Paper";

		m_fila[m_ctp] = "CTP";
		m_fila[m_imp] = "IMP";

		m_fila[m_enc] = "ENC";
		m_fila[m_alc] = "AL\\Ç.";

		m_fila[m_gll] = "GLL";
		m_fila[m_dse] = "DSE";

		m_fila[m_mae] = "MAE";
		m_fila[m_codColo] = "Cod.Col.Comandes"; // amagat
		m_fila[m_pathComandaPdf] = "PathPdf"; // amagat
		DefaultTableModel l_model = new DefaultTableModel(m_fila, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 0:
					return Boolean.class;
				case 4:
					return Integer.class;
				case 18:
					return Integer.class;
				default:
					return String.class;
				}

			};

			public boolean isCellEditable(int p_row, int p_col) {
				return false;
			}

			public void setValueAt(Object p_obj, int p_row, int p_col) {
				super.setValueAt(p_obj, p_row, p_col);
			}

			public Object getValueAt(int p_row, int p_col) {
				return (super.getValueAt(p_row, p_col));
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return super.getColumnCount();
			}

		};
		m_model = l_model;
		return l_model;
	}

	public void buidarTaula() {
		((DefaultTableModel) this.getModel()).setRowCount(0);
	}

	@Override
	protected void ConfigurarColumnes() {
		this.setBackground(Color.white);

		int l_max = 40;
		int l_min = 20;

		getColumnModel().getColumn(m_capcelera).setPreferredWidth(400);
		getColumnModel().getColumn(m_capcelera).setMinWidth(100);
		getColumnModel().getColumn(m_capcelera).setMaxWidth(400);

		getColumnModel().getColumn(m_pla).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_pla).setMinWidth(l_min);
		getColumnModel().getColumn(m_pla).setMaxWidth(l_max);

		getColumnModel().getColumn(m_part).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_part).setMinWidth(l_min);
		getColumnModel().getColumn(m_part).setMaxWidth(l_max);

		getColumnModel().getColumn(m_com).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_com).setMinWidth(l_min);
		getColumnModel().getColumn(m_com).setMaxWidth(l_max);

		getColumnModel().getColumn(m_tir).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_tir).setMinWidth(l_min);
		getColumnModel().getColumn(m_tir).setMaxWidth(l_max);

		getColumnModel().getColumn(m_maq).setPreferredWidth(150);
		getColumnModel().getColumn(m_maq).setMinWidth(20);
		getColumnModel().getColumn(m_maq).setMaxWidth(150);

		getColumnModel().getColumn(m_ctp).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_ctp).setMinWidth(l_min);
		getColumnModel().getColumn(m_ctp).setMaxWidth(l_max);

		getColumnModel().getColumn(m_imp).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_imp).setMinWidth(l_min);
		getColumnModel().getColumn(m_imp).setMaxWidth(l_max);

		getColumnModel().getColumn(m_enc).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_enc).setMinWidth(l_min);
		getColumnModel().getColumn(m_enc).setMaxWidth(l_max);

		getColumnModel().getColumn(m_alc).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_alc).setMinWidth(l_min);
		getColumnModel().getColumn(m_alc).setMaxWidth(l_max);

		getColumnModel().getColumn(m_gll).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_gll).setMinWidth(l_min);
		getColumnModel().getColumn(m_gll).setMaxWidth(l_max);

		getColumnModel().getColumn(m_dse).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_dse).setMinWidth(l_min);
		getColumnModel().getColumn(m_dse).setMaxWidth(l_max);

		getColumnModel().getColumn(m_mae).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_mae).setMinWidth(l_min);
		getColumnModel().getColumn(m_mae).setMaxWidth(l_max);

		getColumnModel().getColumn(m_pag).setPreferredWidth(l_max);
		getColumnModel().getColumn(m_pag).setMinWidth(l_min);
		getColumnModel().getColumn(m_pag).setMaxWidth(l_max);

		getColumnModel().getColumn(m_codColo).setPreferredWidth(30);
		getColumnModel().getColumn(m_codColo).setMinWidth(0);
		getColumnModel().getColumn(m_codColo).setMaxWidth(0);

		getColumnModel().getColumn(m_pla).setPreferredWidth(30);
		getColumnModel().getColumn(m_pla).setMinWidth(0);
		getColumnModel().getColumn(m_pla).setMaxWidth(0);

//		getColumnModel().getColumn(m_pathComandaPdf).setPreferredWidth(30);
//		getColumnModel().getColumn(m_pathComandaPdf).setMinWidth(0);
//		getColumnModel().getColumn(m_pathComandaPdf).setMaxWidth(0);

	}

	@Override
	protected void configuraRenderers() {
		setDefaultRenderer(String.class, new HighlightRenderer(m_jtext));
		setDefaultRenderer(String.class, new StringRenderer());
		setDefaultRenderer(Integer.class, new IntegerRenderer());
	}

	public void addClickListener() {
		MyJTable l_context = this;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int l_table_row = l_context.rowAtPoint(e.getPoint());
					int l_table_col = l_context.columnAtPoint(e.getPoint());
					int l_model_row = l_context.convertRowIndexToModel(l_table_row);
					int l_model_col = l_context.convertRowIndexToModel(l_table_col);
					showInfo(l_model_row, l_model_col);
				}
			}
		});
	}

	private void showInfo(int row, int col) {
		
	}
	
	private void mostraComanda() {
		
	}
	
	
//	private void mostraFitxa() {
//		OrdreProduccioFitxaTecnica l_ordre = m_ordreProduccioFitxaTecnicaDAO.GetFromCP( p_LAN );
//		m_generadorFitxaTecnicaHTML.ActualitzarFitxaTecnica( l_ordre );
//	}
//	//
}
