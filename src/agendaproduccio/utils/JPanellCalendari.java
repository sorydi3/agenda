package agendaproduccio.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import agendaproduccio.controllers.controllerbdd.ControllerAgenda;
import agendaproduccio.views.MainFrame;
import agendaproduccio.views.renderers.jtables.JTableLinies;
import javafx.util.Pair;

public class JPanellCalendari extends JPanel {
	private Vector<Pair<JButton, Boolean>> dies;

	private Calendar m_dataSeleccionada;
	private Calendar m_dataTemporal;

	private JLabel textdl, textdm, textdme, textdj, textdv, textds, textdg;
	private JLabel textMes;
	private Color m_colorFons, m_colorSelected;
	private Font m_font;
	private JButton butMesSeguent, butMesAnterior;
	private boolean m_permetDeseleccionarDia;
	private JLabel m_labelTito;

	private boolean isDone;

	private Calendar l_dataInici;

	private Calendar l_dataFinal;
	private JTableLinies m_jtaula;

	public JPanellCalendari() {
		isDone = true;
		dies = new Vector<Pair<JButton, Boolean>>(5, 1);
		setBackground(Color.green);
		setLayout(new MiLayout());
		setSize(new Dimension(145, 164));
		setPreferredSize(new Dimension(145, 164));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setOpaque(false);
		m_jtaula = null;
		m_colorFons = new Color(61, 65, 69);
		m_colorSelected = new Color(0, 128, 0);
		m_font = new Font("Arial", Font.BOLD, 12);

		m_labelTito = new JLabel("Data");
		m_labelTito.setLocation(0, 0);
		m_labelTito.setForeground(Color.black);
		m_labelTito.setFont(m_font);

		butMesAnterior = new JButton(new ImageIcon("./img/fletxaAEsquerra.gif"));
		butMesAnterior.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				SltMesAnterior();
			}
		});

		butMesAnterior.setLocation(3, 5);
		butMesAnterior.setBorder(BorderFactory.createEmptyBorder());
		add(butMesAnterior);

		butMesSeguent = new JButton(new ImageIcon("./img/fletxaADreta.gif"));
		butMesSeguent.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				SltMesSeguent();
			}
		});

		butMesSeguent.setBorder(BorderFactory.createEmptyBorder());
		butMesSeguent.setLocation(125, 5);
		add(butMesSeguent);

		textMes = new JLabel();
		textMes.setLocation(27, 2);
		textMes.setForeground(Color.black);
		textMes.setFont(m_font);
		add(textMes);

		textdl = new JLabel("dl");
		textdl.setFont(m_font);
		textdl.setForeground(Color.red);
		textdl.setLocation(6, 18);
		add(textdl);

		textdm = new JLabel("dm");
		textdm.setFont(m_font);
		textdm.setLocation(24, 18);
		textdm.setForeground(Color.red);
		add(textdm);

		textdme = new JLabel("dc");
		textdme.setFont(m_font);
		textdme.setLocation(46, 18);
		textdme.setForeground(Color.red);
		add(textdme);

		textdj = new JLabel("dj");
		textdj.setFont(m_font);
		textdj.setLocation(66, 18);
		textdj.setForeground(Color.red);
		add(textdj);

		textdv = new JLabel("dv");
		textdv.setFont(m_font);
		textdv.setLocation(85, 18);
		textdv.setForeground(Color.red);
		add(textdv);

		textds = new JLabel("ds");
		textds.setFont(m_font);
		textds.setLocation(105, 18);
		textds.setForeground(Color.red);
		add(textds);

		textdg = new JLabel("dg");
		textdg.setFont(m_font);
		textdg.setLocation(125, 18);
		textdg.setForeground(Color.red);
		add(textdg);

		int dia = 1;
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 7; x++) {
				if (dia <= 31) {

					JButton but = new JButton(
							"<html><font face='Arial' align='center' size=2><b>" + dia + "</b></font></html>");
					but.setName("" + dia);
					but.setHorizontalAlignment(SwingConstants.RIGHT);
					but.setIconTextGap(9);
					if (dia >= 10)
						but.setMargin(new Insets(-2, -9, 0, 0));
					else
						but.setMargin(new Insets(-2, -4, 0, 0));
					but.setBackground(m_colorFons);
					but.setForeground(Color.white);
					but.setLocation(3 + x * 20, 33 + y * 20);
					but.setSize(new Dimension(20, 20));
					but.setPreferredSize(new Dimension(20, 20));
					but.addMouseListener(new MouseAdapter() {
						public void mouseReleased(MouseEvent e) {
							SltSeleccionarDia(e);
						}
					});
					but.setVisible(false);
					dies.add(dia - 1, new Pair<JButton, Boolean>(but, false));
					add(but);
				}
				dia++;
			}
		}

		Date l_date = new Date();

		m_dataTemporal = new GregorianCalendar();
		m_dataTemporal.setTime(l_date);

		m_dataSeleccionada = new GregorianCalendar();
		m_dataSeleccionada.setTime(l_date);
		m_permetDeseleccionarDia = false;
		SetData();
		setVisible(true);
	}

	public void SetPermetDeseleccionarDia(boolean p_permetDeseleccionarDia) {
		m_permetDeseleccionarDia = p_permetDeseleccionarDia;
	}

	public void SltMesSeguent() {
		int mes = m_dataTemporal.get(Calendar.MONTH);
		int any = m_dataTemporal.get(Calendar.YEAR);

		if (mes == 11) {
			mes = 0;
			any = any + 1;
		} else {
			mes++;
		}

		m_dataTemporal.set(any, mes, 1, m_dataTemporal.get(Calendar.HOUR_OF_DAY), 0);

		this.ShowData();
	}

	public void SltMesAnterior() {
		int mes = m_dataTemporal.get(Calendar.MONTH);
		int any = m_dataTemporal.get(Calendar.YEAR);
		if (mes == 0) {
			mes = 11;
			any = any - 1;
		} else {
			mes--;
		}

		m_dataTemporal.set(any, mes, 1, m_dataTemporal.get(Calendar.HOUR_OF_DAY), 0);

		this.ShowData();
	}

	/**
	 * M�TODE: M�tode que et mostra el calendari a una determinada data
	 * (m_dataTemporal)
	 */
	private void ShowData() {
		int numDies = m_dataTemporal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int x = 0;
		Date dat = new Date();
		Calendar l_cal = new GregorianCalendar();
		l_cal.setTime(dat);
		int diaAct = l_cal.get(Calendar.DAY_OF_MONTH);
		int numdia = m_dataTemporal.get(Calendar.DAY_OF_WEEK);
		int l_setmana = m_dataTemporal.get(Calendar.WEEK_OF_YEAR);

		if (numdia == 1) {
			numdia = 7;
		} else {
			numdia--;
		}

		int y = 0;
		while (x < numDies) {
			((JButton) dies.get(x).getKey()).setLocation(3 + (numdia - 1) * 20, 33 + y * 20);
			((JButton) dies.get(x).getKey()).setVisible(true);

			if (m_dataTemporal != null && m_dataSeleccionada != null
					&& (m_dataTemporal.get(Calendar.MONTH) == m_dataSeleccionada.get(Calendar.MONTH))
					&& (x + 1 == m_dataSeleccionada.get(Calendar.DAY_OF_MONTH))
					&& (m_dataTemporal.get(Calendar.YEAR) == m_dataSeleccionada.get(Calendar.YEAR))) {
				((JButton) dies.get(x).getKey()).setBackground(m_colorSelected);
			} else {
				((JButton) dies.get(x).getKey()).setBackground(m_colorFons);
			}
			Boolean aux_ = dies.get(x).getValue();
			if (x == diaAct - 1) {
				((JButton) dies.get(x).getKey()).setBackground(Color.red);
			} else if (aux_) {
				((JButton) dies.get(x).getKey()).setBackground(m_colorSelected);
			} else {
				((JButton) dies.get(x).getKey()).setBackground(m_colorFons);
			}

			numdia++;

			if (numdia == 8) {
				if (l_setmana == 52) {
					l_setmana = 0;
				}

				l_setmana++;
				numdia = 1;
				y++;
			}
			x++;
		}

		for (int z = x; z < 31; z++) {
			((JButton) dies.get(z).getKey()).setVisible(false);
		}

		String mes = new String("");
		int m = m_dataTemporal.get(Calendar.MONTH);
		if (m == 0)
			mes = "Gener";
		if (m == 1)
			mes = "Febrer";
		if (m == 2)
			mes = "Mar�";
		if (m == 3)
			mes = "Abril";
		if (m == 4)
			mes = "Maig";
		if (m == 5)
			mes = "Juny";
		if (m == 6)
			mes = "Juliol";
		if (m == 7)
			mes = "Agost";
		if (m == 8)
			mes = "Setembre";
		if (m == 9)
			mes = "Octubre";
		if (m == 10)
			mes = "Novembre";
		if (m == 11)
			mes = "Decembre";

		textMes.setText(mes + ", " + m_dataTemporal.get(Calendar.YEAR));
		getllistaDatasSeleccionades();
	}

	protected void SltSeleccionarDia(MouseEvent e) {
		JButton l_diaSeleccionat = (JButton) e.getComponent();
		setBackGroundButtons(e);
		if (m_dataSeleccionada == null) {
			m_dataSeleccionada = new GregorianCalendar();
			m_dataSeleccionada.set(m_dataTemporal.get(Calendar.YEAR), m_dataTemporal.get(Calendar.MONTH),
					Integer.parseInt(l_diaSeleccionat.getName()), 0, 0, 0);
		} else if (m_permetDeseleccionarDia) {
			if (m_dataSeleccionada.get(Calendar.YEAR) == m_dataTemporal.get(Calendar.YEAR)
					&& m_dataSeleccionada.get(Calendar.MONTH) == m_dataTemporal.get(Calendar.MONTH)
					&& m_dataSeleccionada.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(l_diaSeleccionat.getName())) {
				m_dataSeleccionada = null;
			} else {
				m_dataSeleccionada.set(m_dataTemporal.get(Calendar.YEAR), m_dataTemporal.get(Calendar.MONTH),
						Integer.parseInt(l_diaSeleccionat.getName()), 0, 0, 0);
			}
		} else {
			m_dataSeleccionada.set(m_dataTemporal.get(Calendar.YEAR), m_dataTemporal.get(Calendar.MONTH),
					Integer.parseInt(l_diaSeleccionat.getName()), 0, 0, 0);

			dies.get(Integer.parseInt(l_diaSeleccionat.getName()));
			boolean isSelected = dies.get(Integer.parseInt(l_diaSeleccionat.getName()) - 1).getValue();
			dies.remove(Integer.parseInt(l_diaSeleccionat.getName()) - 1);
			dies.add(Integer.parseInt(l_diaSeleccionat.getName()) - 1,
					new Pair<JButton, Boolean>(l_diaSeleccionat, isSelected ? false : true));
		}
		this.ShowData();
		fillTable(JPanelBuilder.m_checkBox.isSelected());
	}

	private void setBackGroundButtons(MouseEvent e) {
		JButton l_diaSeleccionat = (JButton) e.getComponent();
		l_diaSeleccionat.setBackground(Color.red);
	}

	public void SetEnabled(boolean p_enabled) {
		textdl.setEnabled(p_enabled);
		textdm.setEnabled(p_enabled);
		textdme.setEnabled(p_enabled);
		textdj.setEnabled(p_enabled);
		textdv.setEnabled(p_enabled);
		textds.setEnabled(p_enabled);
		textdg.setEnabled(p_enabled);
		m_labelTito.setEnabled(p_enabled);
		butMesSeguent.setEnabled(p_enabled);
		butMesAnterior.setEnabled(p_enabled);

		for (int i = 0; i < dies.size(); i++) {
			dies.get(i).getKey().setEnabled(p_enabled);
		}

		textMes.setEnabled(p_enabled);

		this.updateUI();
	}

	private void fillTable(boolean filter) {
		if (isDone) {
			setDate();
			m_jtaula.buidarTaula();
			ControllerAgenda.getInstance().clearData();
			SwingWorker<Void, Void> l_swingWorker = new SwingWorker<Void, Void>() {
				@Override
				protected Void doInBackground() throws Exception {
					isDone = false;
					MainFrame.getInstance().getGlassPane().setVisible(true);
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							if (!getllistaDatasSeleccionades().isEmpty()) {
								ControllerAgenda.getInstance().addpublicacionsWithData(getllistaDatasSeleccionades(),
										m_jtaula);
							} else {
								Calendar dummyData = new GregorianCalendar();
								ControllerAgenda.getInstance().populateViewJTable(m_jtaula, dummyData, dummyData,
										filter, false);
							}
						}
					});
					return null;
				}

				@Override
				protected void done() {
					isDone = true;
				}
			};
			l_swingWorker.execute();
		}
	}

	private void setDate() {
		l_dataInici = GetDataCalendarFormat();
		l_dataInici.set(Calendar.HOUR_OF_DAY, 0);
		l_dataInici.set(Calendar.MINUTE, 0);
		l_dataInici.set(Calendar.SECOND, 0);

		l_dataFinal = GetDataCalendarFormat();
		l_dataFinal.set(Calendar.HOUR_OF_DAY, 23);
		l_dataFinal.set(Calendar.MINUTE, 59);
		l_dataFinal.set(Calendar.SECOND, 59);
	}

	/**
	 * M�TODE: M�tode que mostra al calendari amb al data p_data. Format p_data:
	 * AAAA-MM-DD
	 */
	public void SetData(String p_data) {
		try {
			String l_dataHora[] = p_data.split(" ");
			String l_data[] = l_dataHora[0].split("-");

			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, Integer.parseInt(l_data[0]));
			m_dataTemporal.set(Calendar.MONTH, (Integer.parseInt(l_data[1]) - 1));

			if (m_dataSeleccionada == null) {
				m_dataSeleccionada = Calendar.getInstance();
			}

			m_dataSeleccionada.set(Calendar.DAY_OF_MONTH, Integer.parseInt(l_data[2]));
			m_dataSeleccionada.set(Calendar.YEAR, Integer.parseInt(l_data[0]));
			m_dataSeleccionada.set(Calendar.MONTH, (Integer.parseInt(l_data[1]) - 1));
		} catch (Exception e) {
			m_dataSeleccionada = null;

			Calendar l_calendar = Calendar.getInstance();
			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, l_calendar.get(Calendar.YEAR));
			m_dataTemporal.set(Calendar.MONTH, l_calendar.get(Calendar.MONTH));
		}

		this.ShowData();
	}

	/**
	 * M�TODE: M�tode que mostra al calendari amb al data p_data. Format
	 * p_data:DD/MM/AAAA
	 */
	public void SetDataDDMMAAAA(String p_data) {
		try {
			p_data = p_data.trim();
			String l_data[] = p_data.split("/");

			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, Integer.parseInt(l_data[2]));
			m_dataTemporal.set(Calendar.MONTH, (Integer.parseInt(l_data[1]) - 1));

			if (m_dataSeleccionada == null) {
				m_dataSeleccionada = new GregorianCalendar();
			}

			m_dataSeleccionada.set(Calendar.DAY_OF_MONTH, Integer.parseInt(l_data[0]));
			m_dataSeleccionada.set(Calendar.MONTH, (Integer.parseInt(l_data[1]) - 1));
			m_dataSeleccionada.set(Calendar.YEAR, Integer.parseInt(l_data[2]));
		} catch (Exception e) {
			m_dataSeleccionada = null;

			Calendar l_calendar = Calendar.getInstance();
			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, l_calendar.get(Calendar.YEAR));
			m_dataTemporal.set(Calendar.MONTH, l_calendar.get(Calendar.MONTH));
		}

		this.ShowData();
	}

	public Vector<Calendar> getllistaDatasSeleccionades() {
		Vector<Calendar> lvec = new Vector<Calendar>();
		for (Pair<JButton, Boolean> calendar : dies) {
			Calendar cal = new GregorianCalendar();
			cal.set(m_dataTemporal.get(Calendar.YEAR), m_dataTemporal.get(Calendar.MONTH),
					Integer.parseInt(calendar.getKey().getName()));
			if (calendar.getValue()) {
				lvec.add(cal);
			}
		}
		return lvec;
	}

	public void SetData(Calendar p_data) {
		try {
			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, p_data.get(Calendar.YEAR));
			m_dataTemporal.set(Calendar.MONTH, p_data.get(Calendar.MONTH));

			if (m_dataSeleccionada == null) {
				m_dataSeleccionada = Calendar.getInstance();
			}

			m_dataSeleccionada.set(Calendar.DAY_OF_MONTH, p_data.get(Calendar.DAY_OF_MONTH));
			m_dataSeleccionada.set(Calendar.YEAR, p_data.get(Calendar.YEAR));
			m_dataSeleccionada.set(Calendar.MONTH, p_data.get(Calendar.MONTH));

		} catch (Exception e) {
			System.out.println("PETADA setdata: " + e);
			m_dataSeleccionada = null;

			Calendar l_calendar = Calendar.getInstance();
			m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
			m_dataTemporal.set(Calendar.YEAR, l_calendar.get(Calendar.YEAR));
			m_dataTemporal.set(Calendar.MONTH, l_calendar.get(Calendar.MONTH));
		}
		System.out.println(
				"posem data temporal " + DataHora.getInstance().CalendarFormatToDDMMAAAAHHMMSS(m_dataTemporal));
		System.out.println(
				"posem data seleccionada " + DataHora.getInstance().CalendarFormatToDDMMAAAAHHMMSS(m_dataSeleccionada));
		this.ShowData();
	}

	/** M�TODE: M�tode que mostra al calendari la data actual */
	public void SetData() {
		if (m_dataSeleccionada == null) {
			m_dataSeleccionada = Calendar.getInstance();
		}

		m_dataSeleccionada.setTime(new Date());

		m_dataTemporal.set(Calendar.DAY_OF_MONTH, 1);
		m_dataTemporal.set(Calendar.YEAR, m_dataSeleccionada.get(Calendar.YEAR));
		m_dataTemporal.set(Calendar.MONTH, m_dataSeleccionada.get(Calendar.MONTH));

		this.ShowData();
	}

	public Calendar GetDataCalendarFormat() {
		if (m_dataSeleccionada != null) {
			m_dataSeleccionada.set(Calendar.HOUR_OF_DAY, 0);
			m_dataSeleccionada.set(Calendar.MINUTE, 0);
			m_dataSeleccionada.set(Calendar.SECOND, 0);
			m_dataSeleccionada.set(Calendar.MILLISECOND, 0);
		}

		return m_dataSeleccionada;
	}

	public String GetDataJavaFormat() {
		String l_data = "";
		if (m_dataSeleccionada == null) {
			return null;
		}

		String sany = "" + m_dataSeleccionada.get(Calendar.YEAR);

		int mes = (m_dataSeleccionada.get(Calendar.MONTH) + 1);
		String smes = "" + mes;
		if (mes < 10)
			smes = "0" + mes;

		int dia = m_dataSeleccionada.get(Calendar.DAY_OF_MONTH);
		String sdia = "" + dia;

		if (dia < 10)
			sdia = "0" + dia;

		l_data = sdia + "/" + smes + "/" + sany;

		return l_data;
	}

	public void setTitle(String p_titol) {
	}

	public void setJtable(JTableLinies m_jtaula2) {
		this.m_jtaula = m_jtaula2;
	}
}