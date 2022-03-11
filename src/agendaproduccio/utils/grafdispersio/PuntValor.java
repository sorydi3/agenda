package agendaproduccio.utils.grafdispersio;

import java.util.Calendar;

public class PuntValor implements Comparable<PuntValor>
{
	public int m_id;
	public String m_descripcio;
	public Object m_valorX, m_valorY;
	public int m_posicioX, m_posicioY;
	public int m_grup;
	
	public PuntValor()
	{
		SetDefault( );
	}

	public void SetDefault()
	{
		m_id = 0;
		m_descripcio = "";
		m_valorX = null;
		m_valorY = null;	
		m_posicioX = 0;
		m_posicioY = 0;
		m_grup = 0;
	}
	
	public void Actualitzar( Object p_valorX, Object p_valorY, int p_id, String p_descripcioPersonalitzada, int p_grup )
	{
		
		if ( p_valorX instanceof Calendar )
		{
			m_valorX = (double)((Calendar)p_valorX).getTimeInMillis( );
		}
		else
		{
			m_valorX = p_valorX;			
		}	
		
		if ( p_valorY instanceof Calendar )
		{
			m_valorY = (double)((Calendar)p_valorY).getTimeInMillis( );
		}
		else
		{
			m_valorY = p_valorY;
		}
		
		m_id = p_id;
		m_descripcio = p_descripcioPersonalitzada;
		m_grup = p_grup;
	}
	
	@Override
	public int compareTo( PuntValor p_pv )
	{
		int l_res = 0;
		if ( !this.equals( p_pv ) )
		{	
			l_res = m_posicioX - p_pv.m_posicioX;
			if ( l_res == 0 )
			{
				l_res = m_posicioY - p_pv.m_posicioY;	
				if ( l_res == 0 )
				{
					l_res = m_grup - p_pv.m_grup;
				}
			}			
		}
		return l_res;
	}
	
	@Override
	public boolean equals( Object p_obj )
	{
		boolean l_iguals = false;
		if ( p_obj instanceof PuntValor )
		{
			PuntValor l_pvObj = ( PuntValor ) p_obj;
			l_iguals = ValorsIguals( this.m_valorX, l_pvObj.m_valorX ) && ValorsIguals( this.m_valorY, l_pvObj.m_valorY ) && ( this.m_grup==-1 || l_pvObj.m_grup==-1 || this.m_grup==l_pvObj.m_grup);
		}
		
		return l_iguals;
	}
	
	@Override
	public int hashCode()
	{
		int l_res = (m_valorX+","+m_valorY+","+m_grup).hashCode( );
		return l_res;
	}
	
	private boolean ValorsIguals( Object p_obj1, Object p_obj2 )
	{
		boolean l_iguals = false;
		if ( (p_obj1 instanceof Double && p_obj2 instanceof Double) || (p_obj1 instanceof Integer && p_obj2 instanceof Integer) )
		{
			l_iguals = Double.parseDouble( ""+p_obj1 ) == Double.parseDouble( ""+p_obj2 );
		}
		else if ( p_obj1 instanceof Calendar && p_obj2 instanceof Calendar )
		{
			l_iguals = ( (Calendar)p_obj1 ).equals( (Calendar)p_obj2 );
		}
		else if ( p_obj1 instanceof String && p_obj2 instanceof String )
		{
			l_iguals = (""+p_obj1).equals(""+p_obj2);
		}
		return l_iguals;
	}
}
