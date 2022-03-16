package agendaproduccio.models.fitxatecnica.model;

import java.util.Vector;

public class OrdreProduccioFitxaTecnica 
{
	public String m_lan;
	public String m_nom;
	public String m_numeroEdicio;
	public String m_quanitat;
	public String m_mostresClient;
	public String m_mostresCial;
	public String m_mostresProduccio;
	public String m_totalPagines;
	public String m_format;
	public String m_plegat;
	public boolean m_esSegonaEdicio;
	public String m_paperCobertaExterior;
	public String m_paperCobertaRotimpres;
	public String m_paperInterior;
	public String m_empaquetatge;
	public String m_impressor;
	public String m_manipulador;
	public String m_enquadernat;
	public String m_tiratges;
	public String m_observacionsGenerals;
	public String m_observacionsEncarts;
	public String m_midaPagina;
	public String m_midaObert;
	public String m_midaPlegat;
	public boolean m_esPaperPEFC;
	public boolean m_teAlcat1;
	public String m_qAlcat1;
	public boolean m_teAlcat2;
	public String m_qAlcat2;
	public boolean m_teEncartMaquina;
	public String m_qEncartMaquina;
	public boolean m_teEncartManual;
	public String m_qEncartManual;
	public boolean m_teTancament;
	public String m_qTancament;
	public boolean m_teCaixes;
	public String m_qCaixes;
	public boolean m_tePlegat14;
	public String m_qPlegat14;
	public boolean m_teRoutageRotimpres;
	public String m_qRoutageRotimpres;
	public boolean m_teRoutageClient;
	public String m_qRoutageClient;
	public boolean m_teGuillotina;	
	public boolean m_teFlejar;
	public boolean m_teEmbossar;
	public String m_dataEntradaFitxersCoberta;
	public String m_horaEntradaFitxersCoberta;
	public String m_dataEntradaFitxersInterior;
	public String m_horaEntradaFitxersInterior;
	public int m_totalTiratges;
	public String m_codiClient;
	public String m_nomClientCRM;
	public String m_NI_Descripcio_Client;
	
	public Vector<LiniaProduccioFitxaTecnica> m_llistaLiniaProduccio;
	
public OrdreProduccioFitxaTecnica()
{
	m_llistaLiniaProduccio = new Vector<LiniaProduccioFitxaTecnica>(0);
	this.SetDefault();
}

public void SetDefault()
{	
	m_lan = "";
	m_nom = "";
	m_numeroEdicio = "";
	m_quanitat = "";
	m_mostresClient = "";
	m_mostresCial = "";
	m_mostresProduccio = "";
	m_totalPagines = "";
	m_format = "";
	m_plegat = "";
	m_esSegonaEdicio = false;
	m_paperCobertaExterior = "";
	m_paperCobertaRotimpres = "";
	m_paperInterior = "";
	m_empaquetatge = "";
	m_impressor = "";
	m_manipulador = "";
	m_enquadernat = "";
	m_tiratges = "";
	m_observacionsGenerals = "";
	m_observacionsEncarts = "";
	m_midaPagina = "";
	m_midaObert = "";
	m_midaPlegat = "";
	m_esPaperPEFC = false;
	m_teAlcat1 = false;
	m_qAlcat1 = "";
	m_teAlcat2 = false;
	m_qAlcat2 = "";
	m_teEncartMaquina = false;
	m_qEncartMaquina = "";
	m_teEncartManual = false;
	m_qEncartManual = "";
	m_teTancament = false;
	m_qTancament = "";
	m_teCaixes = false;
	m_qCaixes = "";
	m_tePlegat14 = false;
	m_qPlegat14 = "";
	m_teRoutageRotimpres = false;
	m_qRoutageClient = "";
	m_teGuillotina = false;
	m_teFlejar = false;
	m_teEmbossar = false;
	m_teRoutageRotimpres = false;
	m_qRoutageRotimpres = "";
	m_teRoutageClient = false;
	m_qRoutageClient = "";
	m_dataEntradaFitxersCoberta = "";
	m_horaEntradaFitxersCoberta = "";
	m_dataEntradaFitxersInterior = "";
	m_horaEntradaFitxersInterior = "";
	m_totalTiratges = 0;
	m_codiClient="";
	m_nomClientCRM="";
	m_NI_Descripcio_Client="";

	
	m_llistaLiniaProduccio.removeAllElements();
}

public String GetPaperCoberta()
{
	if( m_paperCobertaRotimpres != null && m_paperCobertaRotimpres.length() > 2 )
	{
		return m_paperCobertaRotimpres;
	}
	else if( m_paperCobertaExterior != null && m_paperCobertaExterior.length() > 2 )
	{
		return m_paperCobertaExterior;
	}
	
	return "";
}

public String GetDataHoraEntradaFitxersCobertes()
{
	String l_data;
	
	l_data = "";
	if( m_dataEntradaFitxersCoberta != null && m_dataEntradaFitxersCoberta.length() > 0 )
	{
		l_data = m_dataEntradaFitxersCoberta;
	}
	
	if( m_horaEntradaFitxersCoberta != null && m_horaEntradaFitxersCoberta.length() > 0 )
	{
		l_data += l_data.length() > 0? " ":"";
		l_data += m_horaEntradaFitxersCoberta;
	}
	
	return l_data;
}

public String GetDataHoraEntradaFitxersInterior()
{
	String l_data;
	
	l_data = "";
	if( m_dataEntradaFitxersInterior != null && m_dataEntradaFitxersInterior.length() > 0 )
	{
		l_data = m_dataEntradaFitxersInterior;
	}
	
	if( m_horaEntradaFitxersInterior != null && m_horaEntradaFitxersInterior.length() > 0 )
	{
		l_data += l_data.length() > 0? " ":"";
		l_data += m_horaEntradaFitxersInterior;
	}
	
	return l_data;
}

public boolean calMostrar(LiniaProduccioFitxaTecnica l_linia)
	{
	boolean cal=true;
	if ((l_linia.m_maquina.indexOf("HEIDELB")>=0)&&(l_linia.m_tipusProducteMaquinaFulla.equals("Cara-Dors")))
		{
		int totalCares=0;
		int totalDors=0;
		for (int i=0;i<m_llistaLiniaProduccio.size();i++)
			{
			LiniaProduccioFitxaTecnica l_liniaTemp= m_llistaLiniaProduccio.get(i);
			if (l_linia.m_idTiratge==l_liniaTemp.m_idTiratge)
				{
				if (l_linia.m_caraODorsMaquinaFulla.equals("Cara")) totalCares++;
				if (l_linia.m_caraODorsMaquinaFulla.equals("Dors")) totalDors++;
				}
			}
		if ((totalCares==1)&&(totalDors==1))
			{
			if (l_linia.m_caraODorsMaquinaFulla.equals("Cara")) cal=true;
				else cal=false;
			}
			else if ((totalCares==0)||(totalDors==0)) cal=true;
		}
		else
		{
		if ((l_linia.m_maquina.indexOf("HEIDELB")>=0)&&(l_linia.m_tipusProducteMaquinaFulla.equals("Tiro-Retiro"))&&(l_linia.m_caraODorsMaquinaFulla.equals("Dors"))) cal=false;
		}

	return (cal);
	}


public String retornaTitolTiratgeDetallatAMostrar(LiniaProduccioFitxaTecnica l_linia)
	{
	String l_strTiratge="Tiratge "+l_linia.m_idTiratge;
	if (l_linia.m_maquina.indexOf("HEIDELB")>=0)
		{
		if (l_linia.m_tipusProducteMaquinaFulla.equals("Cara-Dors"))
			{
			int totalCares=0;			
			int totalDors=0;
			for (int i=0;i<m_llistaLiniaProduccio.size();i++)
				{
				LiniaProduccioFitxaTecnica l_liniaTemp= m_llistaLiniaProduccio.get(i);
				if (l_linia.m_idTiratge==l_liniaTemp.m_idTiratge)
					{
					if (l_linia.m_caraODorsMaquinaFulla.equals("Cara")) totalCares++;
					if (l_linia.m_caraODorsMaquinaFulla.equals("Dors")) totalDors++;
					}
				}
			if ((totalCares>1)||(totalDors>1)||(totalCares==0)||(totalDors==0))
				{
				l_strTiratge = l_strTiratge+" "+l_linia.m_caraODorsMaquinaFulla+" "+l_linia.m_numeroCaraODorsMaquinaFulla;
				}
			}
		}
	return (l_strTiratge);
	}

public String RetornaTiratgesAmbGuillotina()
	{
	String l_guillotina="";
	for (int i=0;i<m_llistaLiniaProduccio.size();i++)
		{
		LiniaProduccioFitxaTecnica l_linia =m_llistaLiniaProduccio.get(i);
		if (!l_linia.m_guillotina.equals("")) l_guillotina = l_guillotina.equals("")?(l_guillotina="Tir. "+l_linia.m_idTiratge):(l_guillotina=l_guillotina+" - Tir. "+l_linia.m_idTiratge);
		}
	return (l_guillotina);
	}

public String RetornaTiratgesAmbAlcat()
	{
	String l_alcar="";
	for (int i=0;i<m_llistaLiniaProduccio.size();i++)
		{
		LiniaProduccioFitxaTecnica l_linia =m_llistaLiniaProduccio.get(i);
		if (!l_linia.m_alcar.equals("")) l_alcar = l_alcar.equals("")?(l_alcar="Tir. "+l_linia.m_idTiratge):(l_alcar=l_alcar+" - Tir. "+l_linia.m_idTiratge);
		}
	return (l_alcar);
	}

public String RetornaTiratgesAmbDesencart()
	{
	String l_desencart="";
	for (int i=0;i<m_llistaLiniaProduccio.size();i++)
		{
		LiniaProduccioFitxaTecnica l_linia =m_llistaLiniaProduccio.get(i);
		if (!l_linia.m_desencartar.equals("")) l_desencart = l_desencart.equals("")?(l_desencart="Tir. "+l_linia.m_idTiratge):(l_desencart=l_desencart+" - Tir. "+l_linia.m_idTiratge);
		}
	return (l_desencart);
	}	

public boolean esEncolatEnLinia()
	{
	boolean l_hoes=false;
	if (m_enquadernat.equals("ENCOLAT EN LINIA")) l_hoes=true;
	return (l_hoes);
	}

public boolean esTallatEnLinia()
	{
	boolean l_hoes=false;
	if (m_enquadernat.equals("TALLAT EN LINIA")) l_hoes=true;
	return (l_hoes);
	}

public int retornaTotalTiratgesAMostrar()
	{
	int l_total=0;
	
	
	for( int i = 0; i < m_llistaLiniaProduccio.size(); i++ )
		{
		LiniaProduccioFitxaTecnica l_liniaProduccio = m_llistaLiniaProduccio.get( i );
		if( l_liniaProduccio.EsMaquinaPlana())// && l_liniaProduccio.m_visualitzar )
			{
			if (calMostrar(l_liniaProduccio)) 
				{
				l_total++;
				}
			}
			else if( !l_liniaProduccio.EsMaquinaPlana() ) 
				{
				l_total++;

				}
		}
	
	l_total = l_total + RetornaQuantitatTiratgesNoDefinits();
	return (l_total);
	}

public int RetornaQuantitatTiratgesNoDefinits()
	{
	int l_totalTiratgesNoDefinits=0;
	for (int i=0;i<m_totalTiratges;i++)
		{
		int l_idTiratge=i+1;
		boolean l_trobat=false;
		int j=0;
		LiniaProduccioFitxaTecnica l_linia=null;
		while ((!l_trobat)&&(j<m_llistaLiniaProduccio.size()))
			{
			l_linia = m_llistaLiniaProduccio.get(j);
			if (l_linia.m_idTiratge == l_idTiratge) l_trobat=true;
				else j++;
			}
		if (!l_trobat) l_totalTiratgesNoDefinits++;
		}
	return (l_totalTiratgesNoDefinits);
	}

}