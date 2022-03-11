package agendaproduccio.utils.grafdispersio;

import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class JLabelValor extends JLabel
{	
	// [ATR] Dades
		public int m_id;
		public String m_descripcio;
		public int m_numeroElements;
	
	// [MTD] Creaci�
		public JLabelValor()
		{
			super();
			SetDefault( );
		}
		
		public void SetDefault()
		{
			m_id = 0;
			m_descripcio = "";
			m_numeroElements = 0;
			RefrescarDescripcioToolTip( );
		}

	// [MTD] Actualitzacio
		public void EstablirDades( int p_id, String p_descripcio )
		{
			m_id = p_id;
			m_descripcio = p_descripcio;
		}
		
	// [MTD] Gesti� Aparicions
		public void AfegirAparicio()
		{
			m_numeroElements++;
			RefrescarDescripcioToolTip( );
		}
	
		public void EliminarAparicio()
		{
			m_numeroElements--;
			RefrescarDescripcioToolTip( );		
		}
		
		public int NumeroAparicions()
		{
			return m_numeroElements;
		}
		
		private void RefrescarDescripcioToolTip()
		{
			String l_descripcioFinal = "";
			
			if ( !m_descripcio.isEmpty( ) )
			{
				l_descripcioFinal += m_descripcio;
				
				if ( m_numeroElements > 1 )
				{
					l_descripcioFinal += "<br>* "+m_numeroElements+" elements";
				}
			}
			else if ( m_numeroElements > 1 )
			{
				l_descripcioFinal += "* "+m_numeroElements+" elements";
			}
			
			setToolTipText( l_descripcioFinal );
		}
		
		public void EliminarMouseListeners()
		{
			for ( MouseListener l_ml : getMouseListeners( ) )
			{
				removeMouseListener( l_ml );
			}
		}
}
