package agendaproduccio.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class JScrollPaneTableGUI extends JScrollPane
{
	// ATRIBUTS
		// Components
			private JLabel m_jlAmagarScroll;	// JLabel blanc que oculta el detall platejat del header de la taula quan apareix l'scroll
	
	// M�TODES P�BLICS
		// Crear
			public JScrollPaneTableGUI()
			{
				super();
				EstablirEstilGUI();
			}
		
			public JScrollPaneTableGUI( Component p_view )
			{
				super(p_view);
				EstablirEstilGUI();
			}
			
		// Visualitzar
			@Override
			public void setSize( int p_width, int p_height )
			{
				super.setSize( p_width, p_height );
				m_jlAmagarScroll.setLocation( getWidth()-m_jlAmagarScroll.getWidth(), 0 );
				repaint();
			}
			
			@Override
			public void setSize( Dimension p_dim )
			{
				setSize( p_dim.width, p_dim.height );
			}
	
	// M�TODES PRIVATS
		// Visualitzar
			private void EstablirEstilGUI()
			{
				setBorder(null);
				setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				getVerticalScrollBar().setUnitIncrement(10);
				getViewport().setBackground(Color.white);
				
				m_jlAmagarScroll = new JLabel();
				m_jlAmagarScroll.setOpaque(true);
				m_jlAmagarScroll.setBorder(new MatteBorder( 0, 0, 5, 0,Color.green));
				//m_jlAmagarScroll.setSize(15,30);
				add( m_jlAmagarScroll );				
			}
}
