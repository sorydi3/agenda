package agendaproduccio.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelBuilder {
	private static final int DIMENTION_CONTAINER_CALENDAR = 165;
	public static int DIMENTION_WIDTH_CALENDAR;
	public static int DIMENTION_WIDTH_BUTTONS = 100;
	public static int DIMENTION_HEIGHT_BUTTONS = 80;
	public static MyJTextField m_jtextField;
	public static JPanellCalendari m_calendari_inici;
	public static JPanellCalendari m_calendari_final;
	public static JComboBox<String> m_jcombo;
	public static JButton m_jButtonXml;
	public static JButton m_imprimir;
	public static JButton m_refresh;
	public static JPanel m_pPanel;
	private static JLabel titol_inici;
	private static JLabel titol_final;

	public static JPanel BuildHeader(JPanel p_panel) {
		m_pPanel = p_panel;
		JPanel l_jpanel = new JPanel(new BorderLayout());
		Dimension l_dim = new Dimension(p_panel.getWidth(), DIMENTION_CONTAINER_CALENDAR);
		l_jpanel.setPreferredSize(l_dim);
		l_jpanel.setBackground(Color.gray);
		JPanel l_JPanelRightSide = BuildRightSide();
		JPanel l_JPanelLeftSide = buildLeftSide();
		l_jpanel.add(l_JPanelLeftSide, BorderLayout.WEST);
		l_jpanel.add(l_JPanelRightSide, BorderLayout.CENTER);
		setPreferredSize();
		return l_jpanel;
	}

	private static JPanel buildLeftSide() {
		JPanel l_JpanelLeft = new JPanel(new BorderLayout()); // global
		titol_inici = new JLabel("<html><b>Data ini.</b></html>");
		titol_final = new JLabel("<html><b>Data fin.</b></html>");
		// JPanel l_JPaneltitols = createLabelsCalendar(titol_inici, titol_final, 80);
		// l_JpanelLeft.add(l_JPaneltitols, BorderLayout.NORTH);
		JPanel l_JPanelCalendars = createLabelsCalendar(m_calendari_inici, m_calendari_final, 20);
		l_JpanelLeft.add(l_JPanelCalendars, BorderLayout.CENTER);
		return l_JpanelLeft;
	}

	private static JPanel BuildRightSide() {
		JPanel l_jpanel = new JPanel(new BorderLayout());
		// JPanel l_search = BuildSearchBart();
		JPanel l_right = BuildComboButtons();
		// l_jpanel.add(l_search, BorderLayout.NORTH);
		l_jpanel.add(l_right, BorderLayout.CENTER);
		return l_jpanel;
	}

	private static JPanel BuildComboButtons() {
		addItemsCombo();
		setImageIconsButtons();
		JPanel l_jpanel = new JPanel(new BorderLayout());
		l_jpanel.setBackground(Color.green);
		JPanel l_search = BuildSearchBart();
		JPanel l_jpanelCombo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel l_jpanelButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 40));
		// l_jpanelCombo.add(m_jcombo);
		l_jpanel.add(l_search, BorderLayout.WEST);

		// l_jpanelButtons.add(m_jButtonXml);
		// l_jpanelButtons.add(m_imprimir);
		l_jpanelButtons.add(m_refresh);
		l_jpanel.add(l_jpanelButtons, BorderLayout.CENTER);
		return l_jpanel;
	}

	private static JPanel BuildSearchBart() {
		int hgap = 65;
		JPanel l_jpanelSearchBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, hgap)); // JPanel SearchBart
		// l_jpanelSearchBar.setPreferredSize(new Dimension(m_pPanel.getWidth(), 50));
		l_jpanelSearchBar.add(m_jtextField);
		return l_jpanelSearchBar;
	}

	private static void addItemsCombo() {
		m_jcombo.addItem("hola");
		m_jcombo.addItem("whatsapp");
		m_jcombo.addItem("lalala");
	}

	private static void setPreferredSize() {
		m_jtextField.setPreferredSize(new Dimension(400, 30));
		m_jcombo.setPreferredSize(new Dimension(200, 30));
		m_jButtonXml.setPreferredSize(new Dimension(DIMENTION_WIDTH_BUTTONS, DIMENTION_HEIGHT_BUTTONS));
		m_imprimir.setPreferredSize(new Dimension(DIMENTION_WIDTH_BUTTONS, DIMENTION_HEIGHT_BUTTONS));
		m_refresh.setPreferredSize(new Dimension(DIMENTION_WIDTH_BUTTONS, DIMENTION_HEIGHT_BUTTONS));
	}

	private static void setImageIconsButtons() {
		m_jButtonXml.setIcon(GUIDefinition.GetInstance().img_xml);
		m_imprimir.setIcon(GUIDefinition.GetInstance().img_printer);
		m_refresh.setIcon(GUIDefinition.GetInstance().img_reload);
	}

	public static JPanel createLabelsCalendar(Component left, Component right, int p_margin) {
		int hGap = 15;
		JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, p_margin, hGap));// 20 calendar
		l_panel.add(left);
		l_panel.add(right);
		return l_panel;
	}

}
