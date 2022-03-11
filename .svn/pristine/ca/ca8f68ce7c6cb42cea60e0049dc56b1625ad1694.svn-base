
package agendaproduccio.utils.grafdispersio;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import com.sun.java.swing.plaf.windows.WindowsBorders.DashedBorder;

import agendaproduccio.utils.DataHora;
import agendaproduccio.utils.GUIDefinition;

/**
 * He intentat que aquesta sigui una classe senzilla per fer grafs Primer la
 * instanciarem amb un new i li donarem una posici� i una mida Un cop fet aix�,
 * cridarem el m�tode EstablirNomSufixEix dues vegades (una per cada EIX)
 * Seguidament, definirem el tipus i rang de cada eix amb un dels m�todes
 * EstablirSeparadorsEix$ (essent $ el tipus de dades que es vulguin
 * representar) Si volem, podem afegir les zones que calgui (determinaran el
 * color dels punts) Un cop fet aix�, podem comen�ar a afegir valors al graf,
 * amb el m�tode AfegirValor Aquesta classe �s totalment reciclable: es pot
 * canviar de mida, canviar el nom i sufix dels eixos, el tipus de separadors,
 * etc. en qualsevol moment
 **/
public class GrafDispersio extends JLayeredPane
{
	// [ATR] Constants
	public static final int EIX_HORITZONTAL = 0;
	public static final int EIX_VERTICAL = 1;

	private final int VALOR_INDEFINIT = -1;
	public static final int VALOR_NUMERIC = 0;
	public static final int VALOR_TEXT = 1;
	public static final int VALOR_DATA = 2;

	public static final int SEPARADORS_BUITS = 0;
	public static final int SEPARADORS_DISCONTINUS = 1;
	public static final int SEPARADORS_CONTINUS = 2;

	public static final int GRAF_DISPERSIO = 0;
	public static final int GRAF_LINIES = 1;
	public static final int GRAF_BARRES_HORITZONTALS = 2;
	public static final int GRAF_BARRES_VERTICALS = 3;

	// [ATR] Gesti�
	private GUIDefinition m_gui;
	private DataHora m_dh;

	// [ATR] Dades
	private String m_nomEixX;
	private int m_tipusValorEixX;
	private double m_valorMaximEixX;
	private double m_valorMinimEixX;
	private long m_separacioIntervalsEixX;
	private String m_sufixValorX;

	private String m_nomEixY;
	private int m_tipusValorEixY;
	private double m_valorMaximEixY;
	private double m_valorMinimEixY;
	private long m_separacioIntervalsEixY;
	private String m_sufixValorY;

	private int m_tipusGraf;
	private int m_tipusMargeSeparadorsEixX;
	private int m_tipusMargeSeparadorsEixY;

	private TreeMap <Integer, Color> m_tmGrupsDades;

	// [ATR] Component
	private int m_margeX = 50;
	private int m_margeY = 50;

	private JLabel m_jlTitolGraf;

	private JLabel m_jlTitolEixX;
	private JLabel m_jlEixX;
	private JLabel m_jlTitolEixY;
	private JLabel m_jlEixY;
	private LinkedHashMap <Object, JLabel> m_lhmLabelsSeparadorsHoritzontal;
	private LinkedHashMap <Object, JLabel> m_lhmLabelsSeparadorsVertical;
	private TreeMap <Zona, JLabel> m_tmZones; // TODO Creacio de ZONES // TODO COLOR PER ZONES! AMB UN MAP O ALGO!
	private TreeMap <PuntValor, JLabelValor> m_tmPunts;

	private JLabel m_jlGraficsTipusGraf;

	// [ATR] Utils
	private MatteBorder m_mbMargeSeparadorEixHoritzontal, m_mbMargeSeparadorEixVertical;
	private DashedBorder m_dbMargeSeparadorEixHoritzontalDiscontinu, m_dbMargeSeparadorEixVerticalDiscontinu;
	private Integer m_capa1, m_capa2, m_capa3, m_capa4;
	private Calendar m_calendariAuxiliar1, m_calendariAuxiliar2;

	// [ATR] Reciclatge
	private Vector <JLabel> m_vLabelsSeparadorsReciclatge;
	private Vector <Zona> m_vZonesReciclatge;
	private Vector <JLabel> m_vLabelsZonaReciclatge;
	private Vector <PuntValor> m_vPuntsValorReciclatge;
	private Vector <JLabelValor> m_vJLabelsMultipleReciclatge;
	private MouseListener m_mlPuntsGraf;

	// [MTD] Creaci�
	public GrafDispersio()
	{
		m_gui = GUIDefinition.GetInstance( );
		m_dh = DataHora.getInstance( );
		setBackground( m_gui.m_colorBlanc255 );
		setLayout( null );

		m_mbMargeSeparadorEixHoritzontal = new MatteBorder( 0, 0, 0, 1, m_gui.m_colorGris220 );
		m_dbMargeSeparadorEixHoritzontalDiscontinu = new DashedBorder( m_gui.m_colorGris220 )
		{
			@Override
			public void paintBorder( Component comp, Graphics g, int x, int y, int w, int h )
			{
				Graphics2D gg = (Graphics2D) g;
				gg.setColor( m_gui.m_colorGris220 );
				gg.setStroke( new BasicStroke( 0, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]
				{ 1 }, 0 ) );
				gg.drawLine( w - 1, 1, w - 1, h - 1 );
			}
		};
		m_mbMargeSeparadorEixVertical = new MatteBorder( 1, 0, 0, 0, m_gui.m_colorGris220 );
		m_dbMargeSeparadorEixVerticalDiscontinu = new DashedBorder( m_gui.m_colorGris220 )
		{
			@Override
			public void paintBorder( Component comp, Graphics g, int x, int y, int w, int h )
			{
				Graphics2D gg = (Graphics2D) g;
				gg.setColor( m_gui.m_colorGris220 );
				gg.setStroke( new BasicStroke( 0, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]
				{ 1 }, 0 ) );
				gg.drawLine( x - 1, 0, w - 1, 0 );
			}
		};

		m_capa1 = new Integer( 1 );
		m_capa2 = new Integer( 2 );
		m_capa3 = new Integer( 3 );
		m_capa4 = new Integer( 4 );
		m_calendariAuxiliar1 = new GregorianCalendar( );
		m_calendariAuxiliar2 = new GregorianCalendar( );
		m_mlPuntsGraf = null;

		m_tipusGraf = GRAF_DISPERSIO;
		m_tipusMargeSeparadorsEixX = SEPARADORS_DISCONTINUS;
		m_tipusMargeSeparadorsEixY = SEPARADORS_DISCONTINUS;

		m_jlTitolGraf = new JLabel( "", SwingConstants.CENTER );
		m_jlTitolGraf.setLocation( 0, 0 );
		m_jlTitolGraf.setFont( m_gui.m_fontNegreta14 );
		m_jlTitolGraf.setForeground( m_gui.m_colorNegre50 );
		add( m_jlTitolGraf );

		m_nomEixX = "Eix X";
		m_tipusValorEixX = VALOR_INDEFINIT;
		m_valorMaximEixX = 100;
		m_valorMinimEixX = 0;
		m_separacioIntervalsEixX = 10;
		m_sufixValorX = "x";

		m_nomEixY = "Eix Y";
		m_tipusValorEixY = VALOR_INDEFINIT;
		m_valorMaximEixY = 100;
		m_valorMinimEixY = 0;
		m_separacioIntervalsEixY = 10;
		m_sufixValorY = "y";

		m_tmGrupsDades = new TreeMap <>( );

		m_jlTitolEixX = new JLabel( m_nomEixX, JLabel.CENTER );
		m_jlTitolEixX.setForeground( m_gui.m_colorNegre50 );
		m_jlTitolEixX.setFont( m_gui.m_fontNegreta12 );
		add( m_jlTitolEixX, m_capa2 );

		m_jlEixX = new JLabel( );
		m_jlEixX.setBackground( m_gui.m_colorNegre50 );
		m_jlEixX.setOpaque( true );
		add( m_jlEixX, m_capa3 );

		m_jlTitolEixY = new JLabel( m_nomEixY, JLabel.CENTER );
		m_jlTitolEixY.setLocation( 0, 0 );
		m_jlTitolEixY.setForeground( m_gui.m_colorNegre50 );
		m_jlTitolEixY.setFont( m_gui.m_fontNegreta12 );
		add( m_jlTitolEixY, m_capa2 );

		m_jlEixY = new JLabel( "Eix Y", JLabel.LEFT );
		m_jlEixY.setBorder( new MatteBorder( 0, 0, 0, 2, m_gui.m_colorNegre50 ) );
		m_jlEixY.setForeground( m_gui.m_colorNegre50 );
		m_jlEixY.setFont( m_gui.m_fontNegreta14 );
		add( m_jlEixY, m_capa3 );

		m_lhmLabelsSeparadorsHoritzontal = new LinkedHashMap <>( );
		m_lhmLabelsSeparadorsVertical = new LinkedHashMap <>( );
		m_tmZones = new TreeMap <>( );
		m_tmPunts = new TreeMap <>( );

		m_vLabelsSeparadorsReciclatge = new Vector <>( );
		m_vZonesReciclatge = new Vector <>( );
		m_vLabelsZonaReciclatge = new Vector <>( );
		m_vPuntsValorReciclatge = new Vector <>( );
		m_vJLabelsMultipleReciclatge = new Vector <>( );

		m_jlGraficsTipusGraf = new JLabel( )
		{
			@Override
			public void paintComponent( Graphics g )
			{
				super.paintComponent( g );
				PintarTipusGraf( g );
			}
		};
		m_jlGraficsTipusGraf.setLocation( 0, 0 );
		add( m_jlGraficsTipusGraf, m_capa2 );

		setSize( 700, 560 );
	}

	public void EstablirTipusGraf( int p_tipusGraf )
	{
		if ( (m_tipusGraf == GRAF_BARRES_HORITZONTALS || m_tipusGraf == GRAF_BARRES_VERTICALS) && p_tipusGraf != GRAF_BARRES_HORITZONTALS && p_tipusGraf != GRAF_BARRES_VERTICALS )
		{
			for ( JLabelValor l_jlValor : m_tmPunts.values( ) )
			{
				l_jlValor.setVisible( true );
			}
		}

		m_tipusGraf = p_tipusGraf;
		repaint( );
	}

	// [MTD] Gesti� dels Eixos
	public void EstablirNomGraf( String p_nomGraf )
	{
		m_jlTitolGraf.setText( p_nomGraf );
	}

	public void EstablirNomSufixEix( int p_tipusEix, String p_nomEix, String p_sufixEix )
	{
		if ( p_tipusEix == EIX_HORITZONTAL )
		{
			m_nomEixX = p_nomEix;
			m_sufixValorX = p_sufixEix;
			m_jlTitolEixX.setText( "<html><p>" + p_nomEix + "</p></html>" );
		}
		else if ( p_tipusEix == EIX_VERTICAL )
		{
			m_nomEixY = p_nomEix;
			m_jlTitolEixY.setText( "<html><p>" + p_nomEix + "</p></html>" );
			m_sufixValorY = p_sufixEix;
		}
		RefrescarPosicionsValors( );
	}

	public void EstablirTipusSeparadorsHoritzontalsVerticals( int p_tipusSeparadorHoritzontal, int p_tipusSeparadorVertical )
	{
		m_tipusMargeSeparadorsEixX = p_tipusSeparadorHoritzontal;
		m_tipusMargeSeparadorsEixY = p_tipusSeparadorVertical;

		Border l_border = ObtenirSeparador( EIX_HORITZONTAL, m_tipusMargeSeparadorsEixX );
		for ( JLabel l_jlSeparador : m_lhmLabelsSeparadorsHoritzontal.values( ) )
		{
			l_jlSeparador.setBorder( l_border );
		}

		l_border = ObtenirSeparador( EIX_VERTICAL, m_tipusMargeSeparadorsEixY );
		for ( JLabel l_jlSeparador : m_lhmLabelsSeparadorsVertical.values( ) )
		{
			l_jlSeparador.setBorder( l_border );
		}

		repaint( );
	}

	public void EstablirSeparadorsEixNumeric( int p_tipusEix, double p_valorMin, double p_valorMax, double p_separacioValors )
	{
		if ( p_tipusEix == EIX_HORITZONTAL )
		{
			m_tipusValorEixX = VALOR_NUMERIC;
			m_separacioIntervalsEixX = (long) p_separacioValors;
			m_valorMinimEixX = p_valorMin;
			m_valorMaximEixX = ObtenirNouMaximCoincidentAmbIntervals( p_valorMin, p_valorMax, p_separacioValors ); // Fer que sigui proporcional
			CrearSeparacionsIntervalsHoritzontals( );
		}
		else
		{
			m_tipusValorEixY = VALOR_NUMERIC;
			m_separacioIntervalsEixY = (long) p_separacioValors;
			m_valorMinimEixY = p_valorMin;
			m_valorMaximEixY = ObtenirNouMaximCoincidentAmbIntervals( p_valorMin, p_valorMax, p_separacioValors ); // Fer que sigui proporcional
			CrearSeparacionsIntervalsVerticals( );
		}

		EliminarValors( );
		EliminarZonesAfegides( );
	}

	public void EstablirSeparadorsEixDates( int p_tipusEix, Calendar p_dataInici, Calendar p_dataFinal, int p_diesIntervalSeparacio )
	{
		m_calendariAuxiliar1.setTime( p_dataInici.getTime( ) );
		m_calendariAuxiliar1.set( Calendar.HOUR_OF_DAY, 0 );
		m_calendariAuxiliar1.set( Calendar.MINUTE, 0 );
		m_calendariAuxiliar1.set( Calendar.SECOND, 0 );
		m_calendariAuxiliar1.set( Calendar.MILLISECOND, 0 );

		m_calendariAuxiliar2.setTime( p_dataFinal.getTime( ) );
		m_calendariAuxiliar2.set( Calendar.HOUR_OF_DAY, 0 );
		m_calendariAuxiliar2.set( Calendar.MINUTE, 0 );
		m_calendariAuxiliar2.set( Calendar.SECOND, 0 );
		m_calendariAuxiliar2.set( Calendar.MILLISECOND, 0 );
		m_calendariAuxiliar2.add( Calendar.DAY_OF_MONTH, 1 );

		if ( p_tipusEix == EIX_HORITZONTAL )
		{
			m_tipusValorEixX = VALOR_DATA;
			m_separacioIntervalsEixX = p_diesIntervalSeparacio * 24 * 3600; 
			m_valorMinimEixX = m_calendariAuxiliar1.getTimeInMillis( ) / 1000;
			m_valorMaximEixX = ObtenirNouMaximCoincidentAmbIntervals( m_valorMinimEixX, m_calendariAuxiliar2.getTimeInMillis( ) / 1000, m_separacioIntervalsEixX );
			
			m_separacioIntervalsEixX = m_separacioIntervalsEixX *1000;
			m_valorMinimEixX = m_valorMinimEixX * 1000;
			m_valorMaximEixX = m_valorMaximEixX * 1000;
			CrearSeparacionsIntervalsHoritzontals( );
		}
		else if ( p_tipusEix == EIX_VERTICAL )
		{
			m_tipusValorEixY = VALOR_DATA;
			m_separacioIntervalsEixY = p_diesIntervalSeparacio * 24 * 3600;
			m_valorMinimEixY = m_calendariAuxiliar1.getTimeInMillis( ) / 1000;
			m_valorMaximEixY = ObtenirNouMaximCoincidentAmbIntervals( m_valorMinimEixY, m_calendariAuxiliar2.getTimeInMillis( ) / 1000, m_separacioIntervalsEixY );

			m_separacioIntervalsEixY = m_separacioIntervalsEixY *1000;
			m_valorMinimEixY = m_valorMinimEixY * 1000;
			m_valorMaximEixY = m_valorMaximEixY * 1000;
			CrearSeparacionsIntervalsVerticals( );
		}

		// Si hem canviat el tipus de l'eix eliminem tots els valors, altrament els
		// refresquem
		EliminarValors( );
		EliminarZonesAfegides( );
	}

	public void EstablirSeparadorsEixText( int p_tipusEix, Vector <String> p_vDades )
	{
		if ( p_tipusEix == EIX_HORITZONTAL )
		{
			m_tipusValorEixX = VALOR_TEXT;
			m_valorMinimEixX = -1;
			m_valorMaximEixX = -1;
			CrearSeparacionsIntervalsHoritzontals( p_vDades );
		}
		else if ( p_tipusEix == EIX_VERTICAL )
		{
			m_tipusValorEixY = VALOR_TEXT;
			m_valorMinimEixY = -1;
			m_valorMaximEixY = -1;
			CrearSeparacionsIntervalsVerticals( p_vDades );
		}

		// Si hem canviat el tipus de l'eix eliminem tots els valors, altrament els
		// refresquem
		EliminarValors( );
		EliminarZonesAfegides( );
	}

	public void RefrescarPosicionsSeparadors()
	{
		// Recol�loquem Separadors Eix Horitzontal
		int l_alcadaSeparador = getHeight( ) - m_margeY;
		if ( m_tipusValorEixX != VALOR_TEXT )
		{
			int l_ampladaSeparador = m_margeX;
			for ( Object l_valorSepX : m_lhmLabelsSeparadorsHoritzontal.keySet( ) )
			{
				JLabel l_jlSepX = m_lhmLabelsSeparadorsHoritzontal.get( l_valorSepX );
				l_jlSepX.setSize( l_ampladaSeparador, l_alcadaSeparador );
				l_jlSepX.setLocation( TransformarValorEnPosicioX( l_valorSepX ) - l_ampladaSeparador, m_margeY );
			}
		}
		else
		{
			int l_margeDreta = getWidth( ) - m_margeX * 2; // *2 perqu� tamb� li he de restar la mida del propi label
			int l_espaiPerCategoria = (int) Math.ceil( m_jlEixX.getWidth( ) / (m_lhmLabelsSeparadorsHoritzontal.size( ) - 1.00) );

			int l_posAct = m_margeX;
			for ( JLabel l_jlSepX : m_lhmLabelsSeparadorsHoritzontal.values( ) )
			{
				l_jlSepX.setSize( m_margeX, l_alcadaSeparador );
				l_jlSepX.setLocation( Math.min( l_margeDreta, l_posAct - m_margeX ), m_margeY ); // Li resto a X la mida del propi label
				l_posAct += l_espaiPerCategoria;
			}
		}

		// Recol�loquem Separadors Eix Vertical
		l_alcadaSeparador = m_margeY / 2;
		int l_ampladaSeparador = getWidth( ) - m_margeX;
		if ( m_tipusValorEixY != VALOR_TEXT )
		{
			for ( Object l_valorSepY : m_lhmLabelsSeparadorsVertical.keySet( ) )
			{
				JLabel l_jlSepY = m_lhmLabelsSeparadorsVertical.get( l_valorSepY );
				l_jlSepY.setLocation( 0, TransformarValorEnPosicioY( l_valorSepY ) );
				l_jlSepY.setSize( l_ampladaSeparador, l_alcadaSeparador );
			}
		}
		else
		{
			int l_espaiPerCategoria = (int) Math.ceil( m_jlEixY.getHeight( ) / (m_lhmLabelsSeparadorsVertical.size( ) - 1.00) );
			int l_posAct = getHeight( ) - m_margeY;
			for ( JLabel l_jlSepY : m_lhmLabelsSeparadorsVertical.values( ) )
			{
				l_jlSepY.setLocation( 0, Math.max( m_margeY, l_posAct ) );
				l_jlSepY.setSize( l_ampladaSeparador, l_alcadaSeparador );
				l_posAct -= l_espaiPerCategoria;
			}
		}

		repaint( );
	}

	// [MTD] Gesti� de Zones
	public void AfegirZonaConcreta( Object p_valorXini, Object p_valorYini, Object p_valorXfin, Object p_valorYfin, String p_descripcio, Color p_color, boolean p_representar )
	{
		Zona l_zona = ObtenirZona( );

		l_zona.m_valorsInici.m_valorX = TransformarValorEnFormatGraf( EIX_HORITZONTAL, p_valorXini );
		l_zona.m_valorsInici.m_valorY = TransformarValorEnFormatGraf( EIX_VERTICAL, p_valorYfin );

		l_zona.m_valorsFinal.m_valorX = TransformarValorEnFormatGraf( EIX_HORITZONTAL, p_valorXfin );
		l_zona.m_valorsFinal.m_valorY = TransformarValorEnFormatGraf( EIX_VERTICAL, p_valorYini );

		l_zona.m_valorsInici.m_posicioX = TransformarValorEnPosicioX( l_zona.m_valorsInici.m_valorX );
		l_zona.m_valorsInici.m_posicioY = TransformarValorEnPosicioY( l_zona.m_valorsInici.m_valorY );

		l_zona.m_valorsFinal.m_posicioX = TransformarValorEnPosicioX( l_zona.m_valorsFinal.m_valorX );
		l_zona.m_valorsFinal.m_posicioY = TransformarValorEnPosicioY( l_zona.m_valorsFinal.m_valorY );

		l_zona.m_descripcio = p_descripcio;
		l_zona.m_color = p_color;

		l_zona.m_area = (l_zona.m_valorsFinal.m_posicioX - l_zona.m_valorsInici.m_posicioX) * (l_zona.m_valorsFinal.m_posicioY - l_zona.m_valorsInici.m_posicioY);

		if ( !m_tmZones.containsKey( l_zona ) )
		{
			JLabel l_jlZona = null;
			if ( p_representar )
			{
				boolean l_liniesHoritzontals = l_zona.m_valorsInici.m_posicioY != m_margeY || l_zona.m_valorsFinal.m_posicioY != (getHeight( ) - m_margeY); // Dibuixarem linies horitzontals si no ocupa totes les Y
				boolean l_liniesVerticals = l_zona.m_valorsInici.m_posicioX != m_margeX || l_zona.m_valorsFinal.m_posicioX != (getWidth( ) - m_margeX); // Dibuixarem linies verticals si no ocupa totes les X

				if ( l_liniesHoritzontals || l_liniesVerticals )
				{
					l_jlZona = ObtenirJLabelZona( );
					((MatteBorderModificable) l_jlZona.getBorder( )).Modificar( l_liniesHoritzontals ? 1 : 0, l_liniesVerticals ? 1 : 0, l_liniesHoritzontals ? 1 : 0, l_liniesVerticals ? 1 : 0, l_zona.m_color );
					l_jlZona.setLocation( l_zona.m_valorsInici.m_posicioX - 1, l_zona.m_valorsInici.m_posicioY );
					l_jlZona.setSize( (l_zona.m_valorsFinal.m_posicioX - l_zona.m_valorsInici.m_posicioX) + 1, (l_zona.m_valorsFinal.m_posicioY - l_zona.m_valorsInici.m_posicioY) + 1 );
					add( l_jlZona, m_capa2 );
				}
			}

			m_tmZones.put( l_zona, l_jlZona );
		}

		RefrescarPosicionsValors( );
	}

	public void AfegirZonaHoritzontal( Object p_valorYini, Object p_valorYfin, String p_descripcio, Color p_color, boolean p_representar )
	{
		Object l_minimEixX = m_valorMinimEixX;
		Object l_maximEixX = m_valorMaximEixX;
		if ( m_tipusValorEixX == VALOR_TEXT )
		{
			Vector <JLabel> l_vValorsEixX = new Vector <>( m_lhmLabelsSeparadorsHoritzontal.values( ) );
			if ( !l_vValorsEixX.isEmpty( ) )
			{
				l_minimEixX = l_vValorsEixX.get( 0 ).getText( );
				l_maximEixX = l_vValorsEixX.get( l_vValorsEixX.size( ) - 1 ).getText( );
			}
		}

		AfegirZonaConcreta( l_minimEixX, p_valorYini, l_maximEixX, p_valorYfin, p_descripcio, p_color, p_representar );
	}

	public void AfegirZonaVertical( Object p_valorXini, Object p_valorXfin, String p_descripcio, Color p_color, boolean p_representar )
	{
		Object l_minimEixY = m_valorMinimEixY;
		Object l_maximEixY = m_valorMaximEixY;
		if ( m_tipusValorEixY == VALOR_TEXT )
		{
			Vector <JLabel> l_vValorsEixY = new Vector <>( m_lhmLabelsSeparadorsVertical.values( ) );
			if ( !l_vValorsEixY.isEmpty( ) )
			{
				l_minimEixY = l_vValorsEixY.get( 0 ).getText( );
				l_maximEixY = l_vValorsEixY.get( l_vValorsEixY.size( ) - 1 ).getText( );
			}
		}

		AfegirZonaConcreta( p_valorXini, l_minimEixY, p_valorXfin, l_maximEixY, p_descripcio, p_color, p_representar );
	}

	public void EliminarZonesAfegides()
	{
		for ( Zona l_zona : m_tmZones.keySet( ) )
		{
			JLabel l_jlZona = m_tmZones.get( l_zona );
			if ( l_jlZona != null )
			{
				remove( l_jlZona );
				ReciclarJLabelZona( l_jlZona );
			}

			ReciclarZona( l_zona );
		}

		m_tmZones.clear( );

		// Posar Zona de "Dins de Graf"
		Object l_minimEixY = m_valorMinimEixY;
		Object l_maximEixY = m_valorMaximEixY;
		if ( m_tipusValorEixY == VALOR_TEXT )
		{
			Vector <JLabel> l_vValorsEixY = new Vector <>( m_lhmLabelsSeparadorsVertical.values( ) );
			if ( !l_vValorsEixY.isEmpty( ) )
			{
				l_minimEixY = l_vValorsEixY.get( 0 ).getText( );
				l_maximEixY = l_vValorsEixY.get( l_vValorsEixY.size( ) - 1 ).getText( );
			}
		}

		AfegirZonaHoritzontal( l_minimEixY, l_maximEixY, "", Color.BLACK, false );
	}

	public void RefrescarPosicionsZones()
	{
		// Xapussa Xtreme: es fa dues vegades perqu� en cas contrari no acaba de
		// funcionar per b� zones verticals, no s� per qu�...
		for ( int i = 0; i < 2; i++ )
		{
			for ( Zona l_zona : m_tmZones.keySet( ) )
			{
				// Obtenim el label
				JLabel l_jlZona = m_tmZones.get( l_zona );

				// Recalculem el punt de la zona
				l_zona.m_valorsInici.m_posicioX = TransformarValorEnPosicioX( l_zona.m_valorsInici.m_valorX );
				l_zona.m_valorsInici.m_posicioY = TransformarValorEnPosicioY( l_zona.m_valorsInici.m_valorY );

				l_zona.m_valorsFinal.m_posicioX = TransformarValorEnPosicioX( l_zona.m_valorsFinal.m_valorX );
				l_zona.m_valorsFinal.m_posicioY = TransformarValorEnPosicioY( l_zona.m_valorsFinal.m_valorY );

				l_zona.m_area = (l_zona.m_valorsFinal.m_posicioX - l_zona.m_valorsInici.m_posicioX) * (l_zona.m_valorsFinal.m_posicioY - l_zona.m_valorsInici.m_posicioY);

				// Editem el label, si n'hi ha
				if ( l_jlZona != null )
				{
					l_jlZona.setLocation( l_zona.m_valorsInici.m_posicioX - 1, l_zona.m_valorsInici.m_posicioY );
					l_jlZona.setSize( (l_zona.m_valorsFinal.m_posicioX - l_zona.m_valorsInici.m_posicioX) + 1, (l_zona.m_valorsFinal.m_posicioY - l_zona.m_valorsInici.m_posicioY) + 1 );
					l_jlZona.repaint( );
				}
			}
			repaint( );
		}
	}

	// [MTD] Gesti� de Grups
	public void AfegirGrup( int p_grup, Color p_colorGrup )
	{
		m_tmGrupsDades.put( p_grup, p_colorGrup );
	}

	public void TreureGrup( int p_grup )
	{
		if ( m_tmGrupsDades.containsKey( p_grup ) )
		{
			m_tmGrupsDades.remove( p_grup );
		}
	}

	public void EliminarGrups()
	{
		m_tmGrupsDades.clear( );
		m_tmGrupsDades.put( 0, Color.DARK_GRAY );
	}

	// [MTD] Gesti� de Valors
	public void AfegirValor( Object p_valorX, Object p_valorY )
	{
		AfegirValor( p_valorX, p_valorY, 0, "", 0 );
	}

	public void AfegirValor( Object p_valorX, Object p_valorY, int p_id, String p_descripcio )
	{
		AfegirValor( p_valorX, p_valorY, p_id, p_descripcio, 0 );
	}

	public void AfegirValor( Object p_valorX, Object p_valorY, int p_grup )
	{
		AfegirValor( p_valorX, p_valorY, 0, "", p_grup );
	}

	public void AfegirValor( Object p_valorX, Object p_valorY, int p_id, String p_descripcio, int p_grup )
	{
		// Creo un PuntValor amb el que ens ha arribat
		PuntValor l_puntValor = ObtenirPuntValor( );
		l_puntValor.Actualitzar( p_valorX, p_valorY, p_id, p_descripcio, p_grup );
		if ( m_tmPunts.containsKey( l_puntValor ) ) // Si tenim un altre punt on coincideixen els valors, l'actualitzem
		{
			JLabelValor l_jlValor = m_tmPunts.get( l_puntValor );
			l_jlValor.AfegirAparicio( );

			ReciclarPuntValor( l_puntValor );
		}
		else // Altrament, si �s un punt nou
		{
			try
			{
				String l_descripcioValor = l_puntValor.m_descripcio;
				if ( l_descripcioValor.isEmpty( ) )
				{
					ObtenirDescripcioValors( p_valorX, p_valorY );
				}

				// Obtinc el punt segons els valors
				int l_posicioX = TransformarValorEnPosicioX( p_valorX );
				int l_posicioY = TransformarValorEnPosicioY( p_valorY );

				l_puntValor.m_posicioX = l_posicioX; // Al PuntValor desem els originals
				l_puntValor.m_posicioY = l_posicioY;

				Color l_colorZona = Color.RED;
				Zona l_zona = ObtenirZonaPerPosicio( l_posicioX, l_posicioY );
				if ( l_zona == null ) // Vol dir que est� fora del graf
				{
					l_puntValor.m_grup = -1; // Si est� fora del map, el grup �s -1 indistintament
					if ( l_posicioX < m_margeX )
					{
						l_posicioX = m_margeX;
						l_descripcioValor += "<br>** El valor de " + m_nomEixX + " no arriba al l�mit m�nim";
					}
					else if ( l_posicioX > getWidth( ) - m_margeX )
					{
						l_posicioX = getWidth( ) - m_margeX;
						l_descripcioValor += "<br>** El valor de " + m_nomEixX + " sobrepassa el l�mit m�xim";
					}

					if ( l_posicioY < m_margeY )
					{
						l_posicioY = m_margeY;
						l_descripcioValor += "<br>** El valor de " + m_nomEixY + " sobrepassa el l�mit m�xim";
					}
					else if ( l_posicioY > getWidth( ) - m_margeY )
					{
						l_posicioY = getWidth( ) - m_margeY;
						l_descripcioValor += "<br>** El valor de " + m_nomEixY + " no arriba al l�mit m�nim";
					}
				}
				else
				{
					if ( !l_zona.m_descripcio.isEmpty( ) )
					{
						l_descripcioValor += "<br>** " + l_zona.m_descripcio;
					}
					l_colorZona = l_zona.m_color;
				}

				// Genero el LabelMultiple amb les dades que he obtingut i l'afegeixo al map
				JLabelValor l_jlValor = ObtenirJLabelMultiple( );
				l_jlValor.setLocation( (int) (l_posicioX - Math.ceil( l_jlValor.getWidth( ) / 2.00 )), (int) (l_posicioY - Math.ceil( l_jlValor.getHeight( ) / 2.00 )) );
				l_jlValor.setBackground( l_colorZona );
				l_jlValor.setVisible( true );
				l_jlValor.EstablirDades( l_puntValor.m_id, "<html><p>" + l_descripcioValor + "</p></html>" );
				l_jlValor.AfegirAparicio( );

				if ( m_mlPuntsGraf != null )
				{
					l_jlValor.addMouseListener( m_mlPuntsGraf );
				}

				add( l_jlValor, m_capa4 );
				m_tmPunts.put( l_puntValor, l_jlValor );
			}
			catch (NumberFormatException nfe)
			{
				System.err.println( "ERROR DE VALOR EN INTENTAR POSAR (" + p_valorX + ", " + p_valorY + ") AL GRAF" );
				nfe.printStackTrace( );
			}
		}
	}

	public void EliminarValor( Object p_valorX, Object p_valorY )
	{
		EliminarValor( p_valorX, p_valorY, 0 );
	}

	public void EliminarValor( Object p_valorX, Object p_valorY, int p_grup )
	{
		PuntValor l_puntValor = ObtenirPuntValor( );
		l_puntValor.Actualitzar( p_valorX, p_valorY, 0, "", p_grup );

		if ( m_tmPunts.containsKey( l_puntValor ) )
		{
			for ( PuntValor l_keyPuntValor : m_tmPunts.keySet( ) )
			{
				if ( l_puntValor.equals( l_keyPuntValor ) )
				{
					JLabelValor l_jlValor = m_tmPunts.get( l_puntValor );
					l_jlValor.EliminarAparicio( );

					if ( l_jlValor.NumeroAparicions( ) <= 0 )
					{
						remove( l_jlValor );
						m_tmPunts.remove( l_keyPuntValor );

						ReciclarJLabelMultiple( l_jlValor );
						ReciclarPuntValor( l_keyPuntValor );

						repaint( );
					}

					ReciclarPuntValor( l_puntValor );
					break;
				}
			}
		}
	}

	public void EliminarValors()
	{
		for ( PuntValor l_keyPuntValor : m_tmPunts.keySet( ) )
		{
			JLabelValor l_jlValor = m_tmPunts.get( l_keyPuntValor );
			remove( l_jlValor );

			ReciclarJLabelMultiple( l_jlValor );
			ReciclarPuntValor( l_keyPuntValor );
		}
		m_tmPunts.clear( );

		repaint( );
	}

	public void RefrescarPosicionsValors()
	{
		// Treiem tots els labels de valors
		Vector <PuntValor> l_vPuntsValor = new Vector <>( );
		for ( PuntValor l_puntValor : m_tmPunts.keySet( ) )
		{
			l_vPuntsValor.add( l_puntValor );

			JLabelValor l_jlValor = m_tmPunts.get( l_puntValor );
			remove( l_jlValor );
			ReciclarJLabelMultiple( l_jlValor );
		}
		m_tmPunts.clear( );

		// Els tornem a introduir
		for ( PuntValor l_puntValor : l_vPuntsValor )
		{
			Object l_valorX = TransformarValorEnFormatGraf( EIX_HORITZONTAL, l_puntValor.m_valorX );
			Object l_valorY = TransformarValorEnFormatGraf( EIX_VERTICAL, l_puntValor.m_valorY );

			AfegirValor( l_valorX, l_valorY, l_puntValor.m_id, l_puntValor.m_descripcio, l_puntValor.m_grup );
			ReciclarPuntValor( l_puntValor );
		}

		repaint( );
	}

	public void EstablirListenerValors( MouseListener p_ml )
	{
		m_mlPuntsGraf = p_ml;

		for ( PuntValor l_pv : m_tmPunts.keySet( ) )
		{
			m_tmPunts.get( l_pv ).addMouseListener( m_mlPuntsGraf );
		}
	}

	// [MTD] Privats Auxiliars
	private void CrearSeparacionsIntervalsHoritzontals()
	{
		ReciclarLabelsSeparadors( EIX_HORITZONTAL );

		int l_ampladaSeparador = m_margeX;
		int l_alcadaSeparador = getHeight( ) - m_margeY;

		double l_valorAux = m_valorMinimEixX;
		while (l_valorAux <= m_valorMaximEixX)
		{
			// Obtenim label, determinem posici� i mida, i l'afegim
			JLabel l_jlSepX = ObtenirLabelSeparador( );
			l_jlSepX.setSize( l_ampladaSeparador, l_alcadaSeparador );
			l_jlSepX.setLocation( TransformarValorEnPosicioX( l_valorAux ) - l_ampladaSeparador, m_margeY );
			l_jlSepX.setBorder( ObtenirSeparador( EIX_HORITZONTAL, m_tipusMargeSeparadorsEixX ) );
			l_jlSepX.setHorizontalTextPosition( JLabel.RIGHT );
			l_jlSepX.setVerticalTextPosition( JLabel.BOTTOM );
			l_jlSepX.setHorizontalAlignment( JLabel.RIGHT );
			l_jlSepX.setVerticalAlignment( JLabel.BOTTOM );
			add( l_jlSepX, m_capa1 );
			m_lhmLabelsSeparadorsHoritzontal.put( l_valorAux, l_jlSepX );

			// Determinem el text del label
			l_jlSepX.setText( l_valorAux == m_valorMinimEixX ? "" : ObtenirDescripcioSeparador( m_tipusValorEixX, l_valorAux ) + " " );

			l_valorAux += m_separacioIntervalsEixX;
		}
	}

	private void CrearSeparacionsIntervalsHoritzontals( Vector <String> p_vDades )
	{
		ReciclarLabelsSeparadors( EIX_HORITZONTAL );
		p_vDades.add( 0, "" );

		int l_alcadaSeparador = getHeight( ) - m_margeY;
		int l_margeDreta = getWidth( ) - m_margeX * 2; // *2 perqu� tamb� li he de restar la mida del propi label
		int l_espaiPerCategoria = (int) Math.ceil( m_jlEixX.getWidth( ) / (p_vDades.size( ) - 1.00) );

		int l_posAct = m_margeX;
		for ( String l_categoria : p_vDades )
		{
			// Obtenim label, determinem posici� i mida, i l'afegim
			JLabel l_jlSepX = ObtenirLabelSeparador( );
			l_jlSepX.setSize( Math.min( m_margeX, l_espaiPerCategoria ), l_alcadaSeparador );
			l_jlSepX.setLocation( Math.min( l_margeDreta, l_posAct - m_margeX ), m_margeY ); // Li resto a X la mida del propi label
			l_jlSepX.setBorder( ObtenirSeparador( EIX_HORITZONTAL, m_tipusMargeSeparadorsEixX ) );
			l_jlSepX.setHorizontalTextPosition( JLabel.RIGHT );
			l_jlSepX.setVerticalTextPosition( JLabel.BOTTOM );
			l_jlSepX.setHorizontalAlignment( JLabel.RIGHT );
			l_jlSepX.setVerticalAlignment( JLabel.BOTTOM );
			add( l_jlSepX, m_capa1 );
			m_lhmLabelsSeparadorsHoritzontal.put( l_categoria, l_jlSepX );

			// Determinem el text del label
			l_jlSepX.setText( l_categoria );

			l_posAct += l_espaiPerCategoria;
		}
	}

	private void CrearSeparacionsIntervalsVerticals()
	{
		ReciclarLabelsSeparadors( EIX_VERTICAL );
		int l_ampladaSeparador = getWidth( ) - m_margeX;
		int l_alcadaSeparador = m_margeY / 2;

		double l_valorAux = m_valorMinimEixY;
		while (l_valorAux <= m_valorMaximEixY)
		{
			// Obtenim label, determinem posici� i mida, i l'afegim
			JLabel l_jlSepY = ObtenirLabelSeparador( );
			l_jlSepY.setLocation( 0, TransformarValorEnPosicioY( l_valorAux ) );
			l_jlSepY.setSize( l_ampladaSeparador, l_alcadaSeparador );
			l_jlSepY.setBorder( ObtenirSeparador( EIX_VERTICAL, m_tipusMargeSeparadorsEixY ) );
			l_jlSepY.setHorizontalTextPosition( JLabel.LEFT );
			l_jlSepY.setVerticalTextPosition( JLabel.TOP );
			l_jlSepY.setHorizontalAlignment( JLabel.LEFT );
			l_jlSepY.setVerticalAlignment( JLabel.TOP );
			add( l_jlSepY, m_capa1 );
			m_lhmLabelsSeparadorsVertical.put( l_valorAux, l_jlSepY );

			// Determinem el text del label
			l_jlSepY.setText( ObtenirDescripcioSeparador( m_tipusValorEixY, l_valorAux ) );

			// Determinem el seg�ent label a posar
			l_valorAux += m_separacioIntervalsEixY;
		}
	}

	private void CrearSeparacionsIntervalsVerticals( Vector <String> p_vDades )
	{
		ReciclarLabelsSeparadors( EIX_VERTICAL );
		p_vDades.add( 0, "" );

		int l_alcadaSeparador = m_margeY / 2;
		int l_ampladaSeparador = getWidth( ) - m_margeX;
		int l_espaiPerCategoria = (int) Math.ceil( m_jlEixY.getHeight( ) / (p_vDades.size( ) - 1.00) );

		int l_posAct = getHeight( ) - m_margeY;
		for ( String l_categoria : p_vDades )
		{
			// Obtenim label, determinem posici� i mida, i l'afegim
			JLabel l_jlSepY = ObtenirLabelSeparador( );
			l_jlSepY.setLocation( 0, Math.max( m_margeY, l_posAct ) );
			l_jlSepY.setSize( l_ampladaSeparador, Math.min( l_alcadaSeparador, l_espaiPerCategoria ) );
			l_jlSepY.setBorder( ObtenirSeparador( EIX_VERTICAL, m_tipusMargeSeparadorsEixY ) );
			l_jlSepY.setHorizontalTextPosition( JLabel.LEFT );
			l_jlSepY.setVerticalTextPosition( JLabel.TOP );
			l_jlSepY.setHorizontalAlignment( JLabel.LEFT );
			l_jlSepY.setVerticalAlignment( JLabel.TOP );
			add( l_jlSepY, m_capa1 );
			m_lhmLabelsSeparadorsVertical.put( l_categoria, l_jlSepY );

			// Determinem el text del label
			l_jlSepY.setText( l_categoria );

			// Determinem el seg�ent label a posar
			l_posAct -= l_espaiPerCategoria;
		}
	}

	private Zona ObtenirZonaPerPosicio( int p_posX, int p_posY )
	{
		Zona l_res = null;
		for ( Zona l_zona : m_tmZones.keySet( ) )
		{
			if ( l_zona.ContePunt( p_posX, p_posY ) )
			{
				l_res = l_zona;
				break;
			}
		}
		return l_res;
	}

	private String ObtenirDescripcioSeparador( int p_tipusValorEix, double p_valor )
	{
		String l_desc = "" + p_valor;
		if ( p_tipusValorEix == VALOR_NUMERIC )
		{
			if ( p_valor % 1 == 0 )
			{
				l_desc = "" + (int) p_valor;
			}
		}
		else if ( p_tipusValorEix == VALOR_DATA )
		{
			m_calendariAuxiliar1.setTimeInMillis( (long) p_valor );
			l_desc = m_dh.RetornaDiaMes( m_calendariAuxiliar1 );
		}

		return l_desc;
	}

	private String ObtenirDescripcioValors( Object p_valorX, Object p_valorY )
	{
		String l_strValorX = "" + p_valorX;
		if ( m_tipusValorEixX == VALOR_DATA )
		{
			if ( p_valorX instanceof Calendar )
			{
				m_calendariAuxiliar1.setTime( ((Calendar) p_valorX).getTime( ) );
			}
			else
			{
				m_calendariAuxiliar1.setTimeInMillis( Long.parseLong( "" + p_valorX ) );
			}

			l_strValorX = m_dh.CalendarToStringEuropeuSenseSegons( m_calendariAuxiliar1 );
		}

		if ( !m_sufixValorX.isEmpty( ) )
		{
			l_strValorX += " " + m_sufixValorX;
		}

		String l_strValorY = "" + p_valorY;
		if ( m_tipusValorEixY == VALOR_DATA )
		{
			if ( p_valorY instanceof Calendar )
			{
				m_calendariAuxiliar1.setTime( ((Calendar) p_valorY).getTime( ) );
			}
			else
			{
				m_calendariAuxiliar1.setTimeInMillis( Long.parseLong( "" + p_valorY ) );
			}

			l_strValorY = m_dh.CalendarToStringEuropeuSenseSegons( m_calendariAuxiliar1 );
		}

		if ( !m_sufixValorY.isEmpty( ) )
		{
			l_strValorY += " " + m_sufixValorY;
		}

		return l_strValorX + ", " + l_strValorY;
	}

	private double ObtenirNouMaximCoincidentAmbIntervals( double p_valorMin, double p_valorMax, double p_interval )
	{
		double l_valorMaxFinal = p_valorMax;
		if ( ((p_valorMax / p_interval) % p_valorMin != 0) ) // Si sumant la separaci� no arribem al final exacte, agafem el seguent n�mero
		{
			l_valorMaxFinal = p_valorMin;
			while (l_valorMaxFinal < p_valorMax)
			{
				l_valorMaxFinal += p_interval;
			}
		}
		return l_valorMaxFinal;
	}

	private Object TransformarValorEnFormatGraf( int p_eix, Object p_valor )
	{
		Object l_res = p_valor;
		if ( (p_eix == EIX_HORITZONTAL && m_tipusValorEixX == VALOR_DATA) || (p_eix == EIX_VERTICAL && m_tipusValorEixY == VALOR_DATA) )
		{
			try
			{
				Calendar l_resAux = new GregorianCalendar( );
				l_resAux.setTimeInMillis( (long) Double.parseDouble( "" + p_valor ) );

				l_res = l_resAux;
			}
			catch (NumberFormatException nfe)
			{
			}
		}
		return l_res;
	}

	private int TransformarValorEnPosicioX( Object p_valorX )
	{
		double l_posicioX = 0;
		if ( m_tipusValorEixX == VALOR_TEXT )
		{
			// Parsing del valor
			String l_valorX = "" + p_valorX;

			// Retornem la posici� de la seva categoria (HA D'EXISTIR ABANS!)
			for ( Object l_categoria : m_lhmLabelsSeparadorsHoritzontal.keySet( ) )
			{
				if ( l_valorX.equals( "" + l_categoria ) )
				{
					JLabel l_jlSeparador = m_lhmLabelsSeparadorsHoritzontal.get( l_categoria );
					l_posicioX = l_jlSeparador.getX( ) + l_jlSeparador.getWidth( );
					break;
				}
			}
		}
		else
		{
			// Parsing del valor
			double l_valorX = 0;
			if ( m_tipusValorEixX == VALOR_DATA && p_valorX instanceof Calendar )
			{
				l_valorX = ((Calendar) p_valorX).getTimeInMillis( );
			}
			else
			{
				l_valorX = Double.parseDouble( "" + p_valorX );
			}

			// Calculem >> P = ( PM - Pm ) * (( V - Vm )/( VM - Vm ))) + Pm (EIX NORMAL)
			l_posicioX = (getWidth( ) - m_margeX) - m_margeX; // ( Posicio Maxima - Posicio minima )
			l_posicioX *= ((l_valorX - m_valorMinimEixX) / (m_valorMaximEixX - m_valorMinimEixX)); // (( Valor buscat - Valor minim ) / ( Valor Maxim - Valor minim ))
			l_posicioX += m_margeX; // Posicio minima
		}

		return (int) Math.ceil( l_posicioX );
	}

	private int TransformarValorEnPosicioY( Object p_valorY )
	{
		double l_posicioY = 0;
		if ( m_tipusValorEixY == VALOR_TEXT )
		{
			// Parsing del valor
			String l_valorY = "" + p_valorY;

			// Retornem la posici� de la seva categoria (HA D'EXISTIR ABANS!)
			for ( Object l_categoria : m_lhmLabelsSeparadorsVertical.keySet( ) )
			{
				if ( l_valorY.equals( "" + l_categoria ) )
				{
					l_posicioY = m_lhmLabelsSeparadorsVertical.get( l_categoria ).getY( );
					break;
				}
			}
		}
		else
		{
			// Parsing del valor
			double l_valorY = 0;
			if ( m_tipusValorEixY == VALOR_DATA && p_valorY instanceof Calendar )
			{
				l_valorY = ((Calendar) p_valorY).getTimeInMillis( );
			}
			else
			{
				l_valorY = Double.parseDouble( "" + p_valorY );
			}

			// Calculem >> P = ( PM - Pm ) * (( V - VM )/( Vm - VM )) + Pm (EIX INVERTIT)
			l_posicioY = (getHeight( ) - m_margeY) - m_margeY; // ( Posicio Maxima - Posicio minima )
			l_posicioY *= ((l_valorY - m_valorMaximEixY) / (m_valorMinimEixY - m_valorMaximEixY)); // ( Valor buscat - Valor Maxim ) / ( Valor minim - Valor maxim )
			l_posicioY += m_margeY; // Posicio minima
		}
		return (int) Math.ceil( l_posicioY );
	}

	// [MTD] Visualitzaci�
	public void EstablirMarges( int p_margeX, int p_margeY )
	{
		m_margeX = p_margeX;
		m_margeY = p_margeY;
		setSize( getSize( ) );
	}

	@Override
	public void setSize( Dimension d )
	{
		setSize( d.width, d.height );
	}

	@Override
	public void setSize( int width, int height )
	{
		super.setSize( width, height );
		m_jlGraficsTipusGraf.setSize( width, height );

		ReescalarEixos( );
		RefrescarPosicionsSeparadors( );
		repaint( );
		RefrescarPosicionsZones( );
		RefrescarPosicionsValors( );
	}

	private void ReescalarEixos()
	{
		m_jlTitolGraf.setSize( getWidth( ), m_margeY );

		m_jlTitolEixX.setLocation( getWidth( ) - m_margeX, getHeight( ) - m_margeY * 2 );
		m_jlTitolEixX.setSize( m_margeX, m_margeY * 2 );
		m_jlEixX.setSize( getWidth( ) - m_margeX * 2, 2 );
		m_jlEixX.setLocation( m_margeX, getHeight( ) - m_margeY );

		m_jlTitolEixY.setSize( m_margeX * 2, m_margeY );
		m_jlEixY.setSize( 2, 2 + getHeight( ) - m_margeY * 2 );
		m_jlEixY.setLocation( m_margeX - 2, m_margeY );
	}

	private Border ObtenirSeparador( int p_tipusEix, int p_tipusSeparador )
	{
		Border l_res = null;
		if ( p_tipusSeparador != SEPARADORS_BUITS )
		{
			if ( p_tipusEix == EIX_VERTICAL )
			{
				if ( p_tipusSeparador == SEPARADORS_CONTINUS )
				{
					l_res = m_mbMargeSeparadorEixVertical;
				}
				else if ( p_tipusSeparador == SEPARADORS_DISCONTINUS )
				{
					l_res = m_dbMargeSeparadorEixVerticalDiscontinu;
				}
			}
			else if ( p_tipusEix == EIX_HORITZONTAL )
			{
				if ( p_tipusSeparador == SEPARADORS_CONTINUS )
				{
					l_res = m_mbMargeSeparadorEixHoritzontal;
				}
				else if ( p_tipusSeparador == SEPARADORS_DISCONTINUS )
				{
					l_res = m_dbMargeSeparadorEixHoritzontalDiscontinu;
				}
			}
		}

		return l_res;
	}

	private void PintarTipusGraf( Graphics g )
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke( new BasicStroke( 2 ) );

		if ( m_tipusGraf == GRAF_LINIES )
		{
			TreeMap <Integer, Point> l_tmPosicionsGrups = new TreeMap <>( );

			for ( PuntValor l_pv : m_tmPunts.keySet( ) )
			{
				if ( l_pv.m_grup != -1 )
				{
					if ( !l_tmPosicionsGrups.containsKey( l_pv.m_grup ) ) // Si encara no hem vist el grup, instanciem un punt erroni
					{
						Point l_puntInicial = new Point( -1, -1 );
						l_tmPosicionsGrups.put( l_pv.m_grup, l_puntInicial );

						if ( !m_tmGrupsDades.containsKey( l_pv.m_grup ) ) // Si el grup no existeix, en general, posem el grup nou
						{
							int l_r = (int) (255 * Math.random( ));
							int l_g = (int) (255 * Math.random( ));
							int l_b = (int) (255 * Math.random( ));

							AfegirGrup( l_pv.m_grup, new Color( l_r, l_g, l_b ) );
						}
					}

					Point l_punt = l_tmPosicionsGrups.get( l_pv.m_grup );
					if ( l_punt.x == -1 )
					{
						l_punt.x = l_pv.m_posicioX;
						l_punt.y = l_pv.m_posicioY;
					}
					else
					{
						g2d.setColor( m_tmGrupsDades.get( l_pv.m_grup ) );

						g2d.drawLine( l_punt.x, l_punt.y, l_pv.m_posicioX, l_pv.m_posicioY );
						l_punt.x = l_pv.m_posicioX;
						l_punt.y = l_pv.m_posicioY;
					}
				}
			}
		}
		else if ( m_tipusGraf == GRAF_BARRES_HORITZONTALS || m_tipusGraf == GRAF_BARRES_VERTICALS )
		{
			LinkedHashMap <JLabel, PuntValor> l_lhmBarraPunt = new LinkedHashMap <>( );
			if ( m_tipusGraf == GRAF_BARRES_VERTICALS )
			{
				for ( JLabel l_jlSeparador : m_lhmLabelsSeparadorsHoritzontal.values( ) )
				{
					l_lhmBarraPunt.put( l_jlSeparador, null );
				}

				for ( PuntValor l_puntValor : m_tmPunts.keySet( ) )
				{
					for ( JLabel l_jlSeparador : l_lhmBarraPunt.keySet( ) )
					{
						if ( l_jlSeparador.getX( ) < l_puntValor.m_posicioX && l_puntValor.m_posicioX <= (l_jlSeparador.getX( ) + l_jlSeparador.getWidth( ) + 1) )
						{
							if ( l_puntValor.m_posicioY < m_jlEixX.getY( ) )
							{
								l_lhmBarraPunt.put( l_jlSeparador, l_puntValor );
								break;
							}
						}
					}

					m_tmPunts.get( l_puntValor ).setVisible( false );
				}

				for ( JLabel l_jlSeparador : l_lhmBarraPunt.keySet( ) )
				{
					PuntValor l_pv = l_lhmBarraPunt.get( l_jlSeparador );

					if ( l_pv != null )
					{
						if ( !m_tmGrupsDades.containsKey( l_pv.m_grup ) )
						{
							int l_r = (int) (255 * Math.random( ));
							int l_g = (int) (255 * Math.random( ));
							int l_b = (int) (255 * Math.random( ));

							m_tmGrupsDades.put( l_pv.m_grup, new Color( l_r, l_g, l_b ) );
						}
						g2d.setColor( m_tmGrupsDades.get( l_pv.m_grup ) );

						int l_xInicial = l_jlSeparador.getX( );
						int l_yInicial = l_pv.m_posicioY;
						int l_amplada = l_jlSeparador.getWidth( );
						int l_alcada = getHeight( ) - m_margeY - l_yInicial;
						g2d.fillRect( l_xInicial, l_yInicial, l_amplada, l_alcada );
					}
				}
			}
		}
	}

	// [MTD] Reciclatge Separadors
	private JLabel ObtenirLabelSeparador()
	{
		JLabel l_jlReciclat = null;
		if ( m_vLabelsSeparadorsReciclatge.isEmpty( ) )
		{
			l_jlReciclat = new JLabel( );
			l_jlReciclat.setForeground( m_gui.m_colorGris130 );
			l_jlReciclat.setFont( m_gui.m_fontNegreta12 );
		}
		else
		{
			l_jlReciclat = m_vLabelsSeparadorsReciclatge.get( 0 );
			l_jlReciclat.setBorder( null );
			l_jlReciclat.setText( "" );

			m_vLabelsSeparadorsReciclatge.remove( 0 );
		}
		return l_jlReciclat;
	}

	private void ReciclarLabelsSeparadors( int p_tipusEix )
	{
		if ( p_tipusEix == EIX_HORITZONTAL )
		{
			for ( JLabel l_jlSep : m_lhmLabelsSeparadorsHoritzontal.values( ) )
			{
				remove( l_jlSep );
				ReciclarLabelSeparador( l_jlSep );
			}
			m_lhmLabelsSeparadorsHoritzontal.clear( );
		}
		else
		{
			for ( JLabel l_jlSep : m_lhmLabelsSeparadorsVertical.values( ) )
			{
				remove( l_jlSep );
				ReciclarLabelSeparador( l_jlSep );
			}
			m_lhmLabelsSeparadorsVertical.clear( );
		}
	}

	private void ReciclarLabelSeparador( JLabel p_jlReciclar )
	{
		if ( m_vLabelsSeparadorsReciclatge.size( ) < 30 )
		{
			m_vLabelsSeparadorsReciclatge.add( p_jlReciclar );
		}
	}

	// [MTD] Reciclatge de Zones
	private Zona ObtenirZona()
	{
		Zona l_res = null;
		if ( m_vZonesReciclatge.isEmpty( ) )
		{
			l_res = new Zona( );
		}
		else
		{
			l_res = m_vZonesReciclatge.get( 0 );
			l_res.SetDefault( );

			m_vZonesReciclatge.remove( 0 );
		}
		return l_res;
	}

	private void ReciclarZona( Zona p_zona )
	{
		if ( m_vZonesReciclatge.size( ) < 7 )
		{
			m_vZonesReciclatge.add( p_zona );
		}
	}

	private JLabel ObtenirJLabelZona()
	{
		JLabel l_jlRes = null;
		if ( m_vLabelsZonaReciclatge.isEmpty( ) )
		{
			l_jlRes = new JLabel( );
			l_jlRes.setBorder( new MatteBorderModificable( 0, 0, 0, 0, Color.WHITE ) );
		}
		else
		{
			l_jlRes = m_vLabelsZonaReciclatge.get( 0 );
			m_vLabelsZonaReciclatge.remove( 0 );
		}
		return l_jlRes;
	}

	private void ReciclarJLabelZona( JLabel p_jlZona )
	{
		if ( m_vLabelsZonaReciclatge.size( ) < 7 )
		{
			m_vLabelsZonaReciclatge.add( p_jlZona );
		}
	}

	// [MTD] Reciclatge de Valors i Punts
	private PuntValor ObtenirPuntValor()
	{
		PuntValor l_res = null;
		if ( m_vPuntsValorReciclatge.isEmpty( ) )
		{
			l_res = new PuntValor( );
		}
		else
		{
			l_res = m_vPuntsValorReciclatge.get( 0 );
			l_res.SetDefault( );

			m_vPuntsValorReciclatge.remove( 0 );
		}
		return l_res;
	}

	private void ReciclarPuntValor( PuntValor p_puntValor )
	{
		if ( m_vPuntsValorReciclatge.size( ) < 50 )
		{
			m_vPuntsValorReciclatge.add( p_puntValor );
		}
	}

	private JLabelValor ObtenirJLabelMultiple()
	{
		JLabelValor l_res = null;
		if ( m_vJLabelsMultipleReciclatge.isEmpty( ) )
		{
			l_res = new JLabelValor( );
			l_res.setSize( 7, 7 );
			l_res.setOpaque( true );
			l_res.setBackground( Color.BLACK );
		}
		else
		{
			l_res = m_vJLabelsMultipleReciclatge.get( 0 );
			l_res.SetDefault( );

			m_vJLabelsMultipleReciclatge.remove( 0 );
		}
		return l_res;
	}

	private void ReciclarJLabelMultiple( JLabelValor p_jlMultiple )
	{
		if ( m_vJLabelsMultipleReciclatge.size( ) < 30 )
		{
			p_jlMultiple.EliminarMouseListeners( );
			m_vJLabelsMultipleReciclatge.add( p_jlMultiple );
		}
	}

	public int ObtenirNumeroZones()
	{
		return m_tmZones.size( );
	}
}
