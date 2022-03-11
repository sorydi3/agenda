package agendaproduccio.utils.grafdispersio;

import java.awt.Color;


public class Zona implements Comparable<Zona>
{
	public PuntValor m_valorsInici;
	public PuntValor m_valorsFinal; 
	public int m_area;
	public Color m_color;
	public String m_descripcio;
	
	public Zona()
	{
		m_valorsInici = new PuntValor( );
		m_valorsFinal = new PuntValor( );
		SetDefault();
	}
	
	public void SetDefault()
	{
		m_valorsInici.m_valorX = 0;
		m_valorsInici.m_valorY = 0;
		m_valorsFinal.m_valorX = 0;
		m_valorsFinal.m_valorY = 0;
		m_valorsInici.m_posicioX = 0;
		m_valorsInici.m_posicioY = 0;
		m_valorsFinal.m_posicioX = 0;
		m_valorsFinal.m_posicioY = 0;
		m_area = 0;
		
		m_color = null;
		m_descripcio = "";
	}

	public boolean ContePunt( int p_posX, int p_posY )
	{
		return p_posX>=m_valorsInici.m_posicioX && p_posX<=m_valorsFinal.m_posicioX && p_posY>=m_valorsInici.m_posicioY && p_posY<=m_valorsFinal.m_posicioY;
	}
	
	@Override
	public int compareTo( Zona z )
	{
		int l_res = this.m_area - z.m_area;
		if ( l_res == 0 )
		{
			if ( !this.equals( z ) )
			{
				l_res = m_valorsInici.m_posicioX-z.m_valorsInici.m_posicioX;  
				if ( l_res == 0 )
				{
					l_res = m_valorsInici.m_posicioY-z.m_valorsInici.m_posicioY; 
					if ( l_res == 0 )
					{
						l_res = m_valorsFinal.m_posicioX-z.m_valorsFinal.m_posicioX;  
						if ( l_res==0 )
						{
							l_res = m_valorsFinal.m_posicioY-z.m_valorsFinal.m_posicioY;  
							if ( l_res==0 )
							{
								l_res = -1;
							}
						}
					}
				}
			}			
		}
		return l_res;
	}
	
	@Override
	public boolean equals( Object p_obj )
	{
		boolean l_iguals = false;
		if ( p_obj instanceof Zona )
		{
			Zona l_objZona = (Zona)p_obj;
			l_iguals = (m_valorsInici.equals( l_objZona.m_valorsInici ) && m_valorsFinal.equals( l_objZona.m_valorsFinal ));				
		}
		return l_iguals;
	}
}