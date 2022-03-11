package agendaproduccio.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DataHora
{

	private static DataHora m_singleton;
	String ConfiguracioHoraria = "";

	private DataHora()
	{
		ConfiguracioHoraria = "Europe/Madrid";
	}

	public static DataHora getInstance()
	{
		if ( m_singleton == null )
		{
			m_singleton = new DataHora( );
		}
		return m_singleton;
	}

	public Calendar RetornaDataActual()
	{
		// Retorna un Calendar amb la data i hora actuals del sistema
		Calendar Hora = new GregorianCalendar( );
		Hora.setTimeZone( TimeZone.getTimeZone( ConfiguracioHoraria ) );
		Date dat = new Date( );
		Hora.setTime( dat );
		return (Hora);
	}

	public String RetornaDataAcualDDMMAAAAA()
	{
		int l_numero;
		String l_data;
		Calendar l_calendari;

		l_calendari = Calendar.getInstance( );

		l_data = "";

		l_numero = l_calendari.get( Calendar.DAY_OF_MONTH );
		l_data = l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.MONTH ) + 1;
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.YEAR );
		l_data += "" + l_numero;

		return l_data;
	}

	public String RetornaDataAcualDDMMAAAAAHHMM()
	{
		int l_numero;
		String l_data;
		Calendar l_calendari;

		l_calendari = Calendar.getInstance( );

		l_data = "";

		l_numero = l_calendari.get( Calendar.DAY_OF_MONTH );
		l_data = l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.MONTH ) + 1;
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.YEAR );
		l_data += "" + l_numero;

		l_numero = l_calendari.get( Calendar.HOUR_OF_DAY );
		l_data += " " + l_numero;

		l_numero = l_calendari.get( Calendar.MINUTE );
		l_data += ":" + l_numero;

		return l_data;
	}

	public String RetornaDataAcualDDMMAAAAAHHMMSS()
	{
		int l_numero;
		String l_data;
		Calendar l_calendari;

		l_calendari = Calendar.getInstance( );

		l_data = "";

		l_numero = l_calendari.get( Calendar.DAY_OF_MONTH );
		l_data = l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.MONTH ) + 1;
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += "/";
		l_numero = l_calendari.get( Calendar.YEAR );
		l_data += "" + l_numero;

		l_data += " ";
		l_numero = l_calendari.get( Calendar.HOUR_OF_DAY );
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += ":";
		l_numero = l_calendari.get( Calendar.MINUTE );
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		l_data += ":";
		l_numero = l_calendari.get( Calendar.SECOND );
		l_data += l_numero < 10 ? "0" + l_numero : "" + l_numero;

		return l_data;
	}

	public String RetornaDataAcualAA()
	{
		String l_data;
		Calendar l_calendari;

		l_calendari = Calendar.getInstance( );
		l_data = "" + l_calendari.get( Calendar.YEAR );
		l_data = l_data.substring( 2, l_data.length( ) );

		return l_data;
	}

	public int retornaSetmanaMes( Calendar c, int diaInici1aSetmana, int diaFiUltimaSetmana )
	{
		/*
		 * Retorna a quina setmana del mes es troba la data del calendari entrat;
		 * considerant que la primera setmana �s la primera que cont� un
		 * "dia de la setmana 'diaInici1aSetmana'" (p.e., diaInici1aSetmana = 5 ->
		 * llavors la primera setmana del m�s es la primera que cont� un divendres), i
		 * la �ltima setmana del mes �s la �ltima que cont� un
		 * "dia de la setmana 'diaFiUltimaSetmana'" (p.e., diaFiUltimaSetmana = 3 ->
		 * llavors la �ltima setmana del mes �s la �ltima que cont� un dimecres)
		 */
		int diaMes = c.get( Calendar.DAY_OF_MONTH );
		int diaSemana = RetornaNumeroDia( c );
		int primerDomingo = diaMes - diaSemana; // ahora estamos en el domingo inmediatamente anterior
		if ( primerDomingo < 1 )
		{ // nos hemos ido al mes anterior, NO es v�lido!
			primerDomingo = primerDomingo + 7; // ahora ya estamos en el mes actual (primera semana NATURAL, aunque puede no
												// ser la primera semana DE TRABAJO)
		}
		while (primerDomingo > 7)
			primerDomingo = primerDomingo - 7;
		// AHORA primerDomingo = primer Domingo NATURAL, pero no necesariamente DE
		// TRABAJO
		int primerDomingoTrabajo = primerDomingo;
		if ( (primerDomingo + diaInici1aSetmana) < 8 )
			primerDomingoTrabajo = primerDomingoTrabajo + 7; // el primer Domingo DE TRABAJO est� en la semana que viene
		// AHORA primerDomingoTrabajo = primer Domingo DE TRABAJO
		if ( (diaMes >= (primerDomingoTrabajo - 6)) && (diaMes <= (primerDomingoTrabajo)) )
			return 1; // est� en la primera semana DE TRABAJO
		else if ( diaMes < (primerDomingoTrabajo - 6) )
			return 5; // est� en la �ltima semana del MES ANTERIOR
		else if ( (diaMes >= (primerDomingoTrabajo + 1)) && (diaMes <= (primerDomingoTrabajo + 7)) )
			return 2; // est� en la segunda semana DE TRABAJO
		else if ( (diaMes >= (primerDomingoTrabajo + 8)) && (diaMes <= (primerDomingoTrabajo + 14)) )
			return 3; // est� en la tercera semana DE TRABAJO
		int finMes = c.getActualMaximum( Calendar.DAY_OF_MONTH );
		Calendar aux = (Calendar) c.clone( );
		aux.add( Calendar.DAY_OF_YEAR, finMes - diaMes );
		int auxDiaSemana = RetornaNumeroDia( aux );
		int ultimoLunes = finMes - auxDiaSemana + 1; // ahora estamos en el �ltimo lunes NATURAL del mes
		int ultimoLunesTrabajo = ultimoLunes;
		if ( (ultimoLunesTrabajo + diaFiUltimaSetmana - 1) > finMes )
		{ // La �ltima semana NATURAL cuenta como PRIMERA semana DE TRABAJO del mes que
			// viene
			ultimoLunesTrabajo = ultimoLunesTrabajo - 7;
		}
		// AHORA ultimoLunes (natural y de trabajo) son correctos
		if ( diaMes > (ultimoLunesTrabajo + 6) )
			return 1; // primera semana DE TRABAJO del mes que viene
		if ( (diaMes >= (ultimoLunesTrabajo)) && (diaMes <= (ultimoLunesTrabajo + 6)) )
			return 5; // �ltima semana DE TRABAJO del mes actual
		else if ( (diaMes >= (primerDomingoTrabajo + 15)) && (diaMes <= (primerDomingoTrabajo + 21)) )
			return 4; // est� en la cuarta semana DE TRABAJO
		return 5;
	}

	public boolean pertanyUltimaSetmana( Calendar c, int diaInici1aSetmana, int diaFiUltimaSetmana )
	{
		/*
		 * Retorna 'true' si la data del calendari entrat pertany a l'�ltima setmana del
		 * mes; aix� �s, l'�ltima d'aquest que cont� un
		 * "dia de la setmana 'diaFiUltimaSetmana'" (p.e., diaFiUltimaSetmana = 3 ->
		 * llavors la �ltima setmana del mes �s la �ltima que cont� un dimecres)
		 */
		int diesMes = c.getActualMaximum( Calendar.DAY_OF_MONTH );
		int diaActual = c.get( Calendar.DAY_OF_MONTH );
		Calendar aux = (Calendar) c.clone( );
		int diferenciaDias = diesMes - diaActual;
		aux.add( Calendar.DAY_OF_YEAR, +diferenciaDias );
		int diaSemanaOriginal = RetornaNumeroDia( c );
		int diaSemanaFinal = RetornaNumeroDia( aux );
		if ( diaSemanaFinal < diaFiUltimaSetmana )
		{ // la semana donde est� el �ltimo d�a del mes no cuenta
			aux.add( Calendar.DAY_OF_YEAR, -diaSemanaFinal );
			int ultimoDomingo = aux.get( Calendar.DAY_OF_MONTH );
			if ( (diaActual <= ultimoDomingo) && (diaActual >= (ultimoDomingo - 6)) )
				return true;
			else
				return false;
		}
		else
		{ // la semana donde est� el �ltimo d�a del mes s� cuenta como semana
			if ( (diaActual <= diesMes) && (diaActual >= (diesMes - diaSemanaFinal + 1)) )
				return true;
			else
				return false;
		}
	}

	public Calendar StringAmericaAAMMDDToCalendar( String datahora )
	{
		try
		{
			// Donat un String amb la data i la hora (aaaa-mm-dd hh:mm) retorna un Calendar
			if ( (datahora != null) && (datahora.length( ) > 14) )
			{
				Calendar c;
				c = new GregorianCalendar( );
				c.setTimeZone( TimeZone.getTimeZone( ConfiguracioHoraria ) );
				String dia, mes, any, h, m, s;
				int i = 0;
				any = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
				{
					any = any + datahora.charAt( i );
					i++;
				}
				i++;
				mes = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
				{
					mes = mes + datahora.charAt( i );
					i++;
				}
				i++;
				dia = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
				{
					dia = dia + datahora.charAt( i );
					i++;
				}
				i++;
				h = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
				{
					h = h + datahora.charAt( i );
					i++;
				}
				i++;
				m = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
				{
					m = m + datahora.charAt( i );
					i++;
				}
				i++;
				s = "";
				while ((i < datahora.length( )) && (datahora.charAt( i ) != '.'))
				{
					s = s + datahora.charAt( i );
					i++;
				}

				if ( h.equals( "null" ) )
				{
					h = "00";
					m = "00";
					s = "00";
				}
				else if ( m.equals( "null" ) )
				{
					m = "00";
					s = "00";
				}
				else if ( s.equals( "null" ) )
				{
					s = "00";
				}

				c.set( Integer.parseInt( any ), (Integer.parseInt( mes ) - 1), Integer.parseInt( dia ), Integer.parseInt( h ), Integer.parseInt( m ), Integer.parseInt( s ) );
				return (c);
			}
			else
				return (null);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public Calendar StringAmericaAAMMDDUTCToCalendarMadrid( String datahora )
	{
		// Donat un String amb la data i la hora (aaaa-mm-dd hh:mm) retorna un Calendar
		if ( (datahora != null) && (datahora.length( ) > 14) )
		{
			Calendar c;
			c = new GregorianCalendar( );
			c.setTimeZone( TimeZone.getTimeZone( "UTC" ) );

			String dia, mes, any, h, m, s;
			int i = 0;
			any = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-'))
			{
				any = any + datahora.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-'))
			{
				mes = mes + datahora.charAt( i );
				i++;
			}
			i++;
			dia = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
			{
				dia = dia + datahora.charAt( i );
				i++;
			}
			i++;
			h = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				h = h + datahora.charAt( i );
				i++;
			}
			i++;
			m = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				m = m + datahora.charAt( i );
				i++;
			}
			i++;
			s = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '.'))
			{
				s = s + datahora.charAt( i );
				i++;
			}
			c.set( Integer.parseInt( any ), (Integer.parseInt( mes ) - 1), Integer.parseInt( dia ), Integer.parseInt( h ), Integer.parseInt( m ), Integer.parseInt( s ) );

			Calendar c2;
			c2 = new GregorianCalendar( );
			c2.setTimeZone( TimeZone.getTimeZone( "Europe/Madrid" ) );
			c2.setTimeInMillis( c.getTimeInMillis( ) );
			return (c2);
		}
		else
			return (null);
	}

	public String StringAmericaAAMMDDToStringDataEuropeu( String datahora )
	{
		// Donat un String amb la data i la hora (aaaa-mm-dd hh:mm) retorna un Calendar
		if ( (datahora != null) && (datahora.length( ) >= 10) )
		{
			String dia, mes, any;
			int i = 0;
			any = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-'))
			{
				any = any + datahora.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-'))
			{
				mes = mes + datahora.charAt( i );
				i++;
			}
			i++;
			dia = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
			{
				dia = dia + datahora.charAt( i );
				i++;
			}
			return ("" + dia + "-" + mes + "-" + any);
		}
		else
			return ("");
	}

	public Calendar StringEuropeuToCalendar( String datahora )
	{
		// Donat un String amb la data i la hora (dd-mm-aaaa hh:mm) retorna un Calendar
		// System.out.println("Data: "+datahora);
		if ( (datahora != null) && (datahora.length( ) > 10) )
		{
			Calendar c;
			c = new GregorianCalendar( );
			c.setTimeZone( TimeZone.getTimeZone( ConfiguracioHoraria ) );
			String dia, mes, any, h, m, s;
			int i = 0;
			dia = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
			{
				dia = dia + datahora.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
			{
				mes = mes + datahora.charAt( i );
				i++;
			}
			i++;
			any = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
			{
				any = any + datahora.charAt( i );
				i++;
			}
			i++;
			h = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				h = h + datahora.charAt( i );
				i++;
			}
			i++;
			m = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				m = m + datahora.charAt( i );
				i++;
			}
			i++;
			s = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '.'))
			{
				s = s + datahora.charAt( i );
				i++;
			}
			if ( s.equals( "" ) )
				s = "0";
			if ( any.length( ) == 2 )
				any = "20" + any;
			try
			{
				c.set( Integer.parseInt( any ), (Integer.parseInt( mes ) - 1), Integer.parseInt( dia ), Integer.parseInt( h ), Integer.parseInt( m ), Integer.parseInt( s ) );
			}
			catch (Exception e)
			{
				System.out.println( "Petada al convertir hora a calendar: " + e );
				c = null;
			}
			return (c);
		}
		else
			return (null);
	}

	public String StringNomesDataEuropeuToStringDataEuropeuEstandaritzat( String datahora )
	{
		// Donat un String amb la data i la hora (dd-mm-aaaa hh:mm) retorna un Calendar
		String novaData = "";
		if ( (datahora != null) && (datahora.length( ) > 5) )
		{
			String dia, mes, any, h, m, s;
			int i = 0;
			dia = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
			{
				dia = dia + datahora.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != '-') && (datahora.charAt( i ) != '/'))
			{
				mes = mes + datahora.charAt( i );
				i++;
			}
			i++;
			any = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
			{
				any = any + datahora.charAt( i );
				i++;
			}
			String sdia = "" + dia;
			if ( dia.length( ) == 1 )
				dia = "0" + dia;
			if ( mes.length( ) == 1 )
				mes = "0" + mes;
			if ( any.length( ) == 2 )
				any = "20" + any;
			novaData = "" + dia + "/" + mes + "/" + any;
		}
		return (novaData);
	}

	public String StringNomesHoraToHoraEstandaritzat( String datahora )
	{
		// Donat un String amb la data i la hora (dd-mm-aaaa hh:mm) retorna un Calendar
		// System.out.println("Data: "+datahora);
		String novaHora = "";
		if ( (datahora != null) && (datahora.length( ) == 5) )
		{
			boolean ok = true;
			if ( !((datahora.charAt( 0 ) == '0') || (datahora.charAt( 0 ) == '1') || (datahora.charAt( 0 ) == '2') || (datahora.charAt( 0 ) == '3') || (datahora.charAt( 0 ) == '4') || (datahora.charAt( 0 ) == '5') || (datahora.charAt( 0 ) == '6') || (datahora.charAt( 0 ) == '7') || (datahora.charAt( 0 ) == '8') || (datahora.charAt( 0 ) == '9')) )
				ok = false;
			if ( !((datahora.charAt( 1 ) == '0') || (datahora.charAt( 1 ) == '1') || (datahora.charAt( 0 ) == '2') || (datahora.charAt( 1 ) == '3') || (datahora.charAt( 1 ) == '4') || (datahora.charAt( 1 ) == '5') || (datahora.charAt( 1 ) == '6') || (datahora.charAt( 1 ) == '7') || (datahora.charAt( 1 ) == '8') || (datahora.charAt( 1 ) == '9')) )
				ok = false;
			if ( !(datahora.charAt( 4 ) == ':') )
				ok = false;
			if ( !((datahora.charAt( 3 ) == '0') || (datahora.charAt( 3 ) == '1') || (datahora.charAt( 3 ) == '2') || (datahora.charAt( 3 ) == '3') || (datahora.charAt( 3 ) == '4') || (datahora.charAt( 3 ) == '5') || (datahora.charAt( 3 ) == '6') || (datahora.charAt( 3 ) == '7') || (datahora.charAt( 3 ) == '8') || (datahora.charAt( 3 ) == '9')) )
				ok = false;
			if ( !((datahora.charAt( 4 ) == '0') || (datahora.charAt( 4 ) == '1') || (datahora.charAt( 4 ) == '2') || (datahora.charAt( 4 ) == '3') || (datahora.charAt( 4 ) == '4') || (datahora.charAt( 4 ) == '5') || (datahora.charAt( 4 ) == '6') || (datahora.charAt( 4 ) == '7') || (datahora.charAt( 4 ) == '8') || (datahora.charAt( 4 ) == '9')) )
				ok = false;
			if ( !ok )
				novaHora = "";
		}
		return (novaHora);
	}

	public Calendar StringEuropeuSenseSegonsToCalendar( String datahora )
	{
		// Donat un String amb la data i la hora (dd-mm-aaaa hh:mm) retorna un Calendar
		// System.out.println("Data:"+datahora);
		if ( (datahora != null) && (datahora.length( ) > 10) )
		{
			Calendar c;
			c = new GregorianCalendar( );
			c.setTimeZone( TimeZone.getTimeZone( ConfiguracioHoraria ) );
			String dia, mes, any, h, m;
			int i = 0;
			dia = "";
			while ((i < datahora.length( )) && ((datahora.charAt( i ) != '/') && (datahora.charAt( i ) != '-')))
			{
				dia = dia + datahora.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < datahora.length( )) && ((datahora.charAt( i ) != '/') && (datahora.charAt( i ) != '-')))
			{
				mes = mes + datahora.charAt( i );
				i++;
			}
			i++;
			any = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ' '))
			{
				any = any + datahora.charAt( i );
				i++;
			}
			i++;
			h = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				h = h + datahora.charAt( i );
				i++;
			}
			i++;
			m = "";
			while ((i < datahora.length( )) && (datahora.charAt( i ) != ':'))
			{
				m = m + datahora.charAt( i );
				i++;
			}
			try
			{
				c.set( Integer.parseInt( any ), (Integer.parseInt( mes ) - 1), Integer.parseInt( dia ), Integer.parseInt( h ), Integer.parseInt( m ), 0 );
			}
			catch (Exception e)
			{
				c = null;
			}

			return (c);
		}
		else
			return (null);
	}

	public boolean ComprovarHHMM( String p_dataHora, boolean p_potSerNull )
	{
		if ( p_dataHora == null || p_dataHora.length( ) <= 0 )
		{
			if ( p_potSerNull )
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat( "hh:mm" );

		try
		{
			dateFormat.parse( p_dataHora );
		}
		catch (ParseException e)
		{
			return false;
		}
		return true;

	}

	public Calendar StringAmericaAAMMDDToCalendar( String data, int hora, int minut, int segons )
	{
		// Donat un String amb la data i la hora (aaaa-mm-dd hh:mm) retorna un Calendar
		if ( (data != null) && (data.length( ) > 5) )
		{
			Calendar c;
			c = new GregorianCalendar( );
			c.setTimeZone( TimeZone.getTimeZone( "Europe/Madrid" ) );
			String dia, mes, any;
			int i = 0;
			any = "";
			while ((i < data.length( )) && (data.charAt( i ) != '-'))
			{
				any = any + data.charAt( i );
				i++;
			}
			i++;
			mes = "";
			while ((i < data.length( )) && (data.charAt( i ) != '-'))
			{
				mes = mes + data.charAt( i );
				i++;
			}
			i++;
			dia = "";
			while ((i < data.length( )) && (data.charAt( i ) != ' '))
			{
				dia = dia + data.charAt( i );
				i++;
			}
			c.set( Integer.parseInt( any ), (Integer.parseInt( mes ) - 1), Integer.parseInt( dia ), hora, minut, segons );
			return (c);
		}
		else
			return (null);
	}

	public String CalendarToStringEuropeuNomesData( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int dia = datahora.get( Calendar.DAY_OF_MONTH );
			String sdia = "" + dia;
			if ( dia < 10 )
				sdia = "0" + dia;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			ret = "" + sdia + "/" + smes + "/" + datahora.get( Calendar.YEAR );
		}
		return (ret);
	}

	public String CalendarToStringEuropeuDDMM( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int dia = datahora.get( Calendar.DAY_OF_MONTH );
			String sdia = "" + dia;
			if ( dia < 10 )
				sdia = "0" + dia;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			ret = "" + sdia + "/" + smes;
		}
		return (ret);
	}

	public String CalendarToStringEuropeuNomesDataAnys2Digits( Calendar datahora )
	{
		String ret = "";
		if ( (datahora != null) )
		{
			int dia = datahora.get( Calendar.DAY_OF_MONTH );
			String sdia = "" + dia;
			if ( dia < 10 )
				sdia = "0" + dia;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			String l_any = "";
			try
			{
				l_any = ("" + datahora.get( Calendar.YEAR )).substring( 2, 4 );
			}
			catch (Exception e)
			{

			}
			ret = "" + sdia + "/" + smes + "/" + l_any;
		}
		return (ret);
	}

	/** @return HH:MM */
	public String CalendarToStringEuropeuNomesHora( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			ret = "" + sh + ":" + sm;
		}
		return (ret);
	}

	public String RetornaDiaReduitiHora( Calendar datahora )
	{
		int h = datahora.get( Calendar.HOUR_OF_DAY );
		String sh = "" + h;
		int m = datahora.get( Calendar.MINUTE );
		String sm = "" + m;
		if ( m < 10 )
			sm = "0" + m;
		String ret = RetornaDiaSetmanaReduit( datahora ) + " " + sh + ":" + sm;
		return (ret);
	}

	public String RetornaDiaReduitNumeroDiaiHora( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;

			int d = datahora.get( Calendar.DAY_OF_MONTH );
			String sd = "" + d;
			if ( d < 10 )
				sd = "0" + d;

			ret = RetornaDiaSetmanaReduit( datahora ) + " " + sd + " " + sh + ":" + sm;
		}
		return (ret);
	}

	public String CalendarToStringEuropeu( Calendar datahora )
	{
		if ( datahora == null )
		{
			return "";
		}
		else
		{
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			String ret = "" + datahora.get( Calendar.DAY_OF_MONTH ) + "-" + (datahora.get( Calendar.MONTH ) + 1) + "-" + datahora.get( Calendar.YEAR ) + " " + sh + ":" + sm + ":00";
			return (ret);
		}
	}

	public String CalendarToStringEuropeuAmbSegons( Calendar datahora )
	{
		if ( datahora == null )
		{
			return "";
		}
		else
		{
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			int s = datahora.get( Calendar.SECOND );
			String ss = "" + s;
			if ( s < 10 )
				ss = "0" + s;

			String ret = "" + datahora.get( Calendar.DAY_OF_MONTH ) + "-" + (datahora.get( Calendar.MONTH ) + 1) + "-" + datahora.get( Calendar.YEAR ) + " " + sh + ":" + sm + ":" + ss;
			return (ret);
		}
	}

	public String DoubleToHoresMinuts( double _hores )
	{
		boolean negatiu = (_hores < 0.0);
		int hores = (int) (_hores);
		int minuts = (int) (_hores * 60);
		int min = (int) (((int) minuts) % 60);
		if ( negatiu )
		{
			hores = hores * (-1);
			min = min * (-1);
		}
		String h = "" + hores;
		String m = "" + min;
		if ( hores < 10 )
			h = "0" + h;
		if ( min < 10 )
			m = "0" + m;
		if ( negatiu )
			return ("-" + h + ":" + m);
		else
			return (h + ":" + m);
	}

	public String CalendarToStringEuropeuNomesNumeros( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int dia = datahora.get( Calendar.DAY_OF_MONTH );
			String sdia = "" + dia;
			if ( dia < 10 )
				sdia = "0" + dia;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			int hora = datahora.get( Calendar.HOUR_OF_DAY );
			String shora = "" + hora;
			if ( hora < 10 )
				shora = "0" + hora;
			int minut = datahora.get( Calendar.MINUTE );
			String sminut = "" + minut;
			if ( minut < 10 )
				sminut = "0" + minut;
			int segon = datahora.get( Calendar.SECOND );
			String ssegons = "" + segon;
			if ( segon < 10 )
				ssegons = "0" + segon;
			ret = "" + sdia + smes + datahora.get( Calendar.YEAR ) + shora + sminut + ssegons;
		}
		return (ret);
	}

	public String CalendarToStringAmericaNomesNumeros( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int dia = datahora.get( Calendar.DAY_OF_MONTH );
			String sdia = "" + dia;
			if ( dia < 10 )
				sdia = "0" + dia;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			int hora = datahora.get( Calendar.HOUR_OF_DAY );
			String shora = "" + hora;
			if ( hora < 10 )
				shora = "0" + hora;
			int minut = datahora.get( Calendar.MINUTE );
			String sminut = "" + minut;
			if ( minut < 10 )
				sminut = "0" + minut;
			int segon = datahora.get( Calendar.SECOND );
			String ssegons = "" + segon;
			if ( segon < 10 )
				ssegons = "0" + segon;
			ret = "" + datahora.get( Calendar.YEAR ) + smes + sdia + shora + sminut + ssegons;
		}
		return (ret);
	}

	public String CalendarToStringEuropeuSenseSegons( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int d = datahora.get( Calendar.DAY_OF_MONTH );
			String sd = "" + d;
			if ( d < 10 )
				sd = "0" + d;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;

			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			ret = "" + sd + "/" + smes + "/" + datahora.get( Calendar.YEAR ) + " " + sh + ":" + sm;
		}
		return (ret);
	}

	public String CalendarToStringEuropeuSenseHores( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int d = datahora.get( Calendar.DAY_OF_MONTH );
			String sd = "" + d;
			if ( d < 10 )
				sd = "0" + d;
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;

			ret = "" + sd + "/" + smes + "/" + datahora.get( Calendar.YEAR );
		}
		return (ret);
	}

	public boolean EsCapDeSetmana( Calendar data )
	{
		boolean esCapDeSetmana = false;
		int dia = data.get( Calendar.DAY_OF_WEEK );
		if ( (dia == 1) || (dia == 7) )
			esCapDeSetmana = true;
		return (esCapDeSetmana);
	}

	public String RetornaDiaSetmana( Calendar data )
	{
		String ret = "";
		int dia = data.get( Calendar.DAY_OF_WEEK );
		if ( dia == 1 )
			ret = "Diumenge";
		if ( dia == 2 )
			ret = "Dilluns";
		if ( dia == 3 )
			ret = "Dimarts";
		if ( dia == 4 )
			ret = "Dimecres";
		if ( dia == 5 )
			ret = "Dijous";
		if ( dia == 6 )
			ret = "Divendres";
		if ( dia == 7 )
			ret = "Dissabte";
		return (ret);
	}

	public int RetornaNumeroDia( Calendar data )
	{
		int dia = data.get( Calendar.DAY_OF_WEEK );
		if ( dia == 1 )
			dia = 7;
		else if ( dia == 2 )
			dia = 1;
		else if ( dia == 3 )
			dia = 2;
		else if ( dia == 4 )
			dia = 3;
		else if ( dia == 5 )
			dia = 4;
		else if ( dia == 6 )
			dia = 5;
		else if ( dia == 7 )
			dia = 6;
		return (dia);
	}

	public String RetornaHora( Calendar datahora )
	{
		if ( datahora == null )
			return ("");
		else
		{
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			String ret = sh + ":" + sm;
			return (ret);
		}
	}

	public String RetornaDiaiHora( Calendar datahora )
	{
		if ( datahora == null )
			return ("");
		else
		{
			int d = datahora.get( Calendar.DAY_OF_MONTH );
			String sd = "" + d;
			if ( d < 10 )
				sd = "0" + d;
			int h = datahora.get( Calendar.HOUR_OF_DAY );
			String sh = "" + h;
			if ( h < 10 )
				sh = "0" + h;
			int m = datahora.get( Calendar.MINUTE );
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			String ret = sd + "-" + sh + ":" + sm;
			return (ret);
		}
	}

	public String RetornaDataComplerta( Calendar calData )
	{
		String ret = RetornaDiaSetmana( calData ) + ", " + calData.get( Calendar.DAY_OF_MONTH ) + " " + RetornaMes( calData ) + " de " + calData.get( Calendar.YEAR );
		return (ret);
	}

	public String RetornaDDMMAAAA( Calendar calData )
	{
		String l_data = "";

		if ( calData != null )
		{
			l_data = calData.get( Calendar.DAY_OF_MONTH ) + "/" + (calData.get( Calendar.MONTH ) + 1) + "/" + calData.get( Calendar.YEAR );
		}

		return l_data;
	}

	public String RetornaDataComplertaHTML( Calendar calData )
	{
		String ret = "<html><center>" + RetornaDiaSetmana( calData ) + ", <br> " + calData.get( Calendar.DAY_OF_MONTH ) + " " + RetornaMes( calData ) + " " + calData.get( Calendar.YEAR ) + "</center></html>";
		return (ret);
	}

	public String RetornaIntervalDatesComplertesHTML( Calendar calDataInici, Calendar calDataFi )
	{
		String ret = "<html><center>del " + calDataInici.get( Calendar.DAY_OF_MONTH ) + " " + RetornaMes( calDataInici );
		ret = ret + " <br> al " + calDataFi.get( Calendar.DAY_OF_MONTH ) + " " + RetornaMes( calDataFi ) + "</center></html>";
		return (ret);
	}

	public String RetornaMes( Calendar data )
	{
		String ret = "";
		int mes = data.get( Calendar.MONTH ) + 1;
		if ( mes == 1 )
			ret = "Gener";
		if ( mes == 2 )
			ret = "Febrer";
		if ( mes == 3 )
			ret = "Mar�";
		if ( mes == 4 )
			ret = "Abril";
		if ( mes == 5 )
			ret = "Maig";
		if ( mes == 6 )
			ret = "Juny";
		if ( mes == 7 )
			ret = "Juliol";
		if ( mes == 8 )
			ret = "Agost";
		if ( mes == 9 )
			ret = "Setembre";
		if ( mes == 10 )
			ret = "Octubre";
		if ( mes == 11 )
			ret = "Novembre";
		if ( mes == 12 )
			ret = "Desembre";
		return (ret);
	}

	public String RetornaDiaSetmanaReduit( Calendar data )
	{
		String ret = "";
		if ( data != null )
		{
			int dia = data.get( Calendar.DAY_OF_WEEK );
			if ( dia == 1 )
				ret = "DG";
			if ( dia == 2 )
				ret = "DL";
			if ( dia == 3 )
				ret = "DM";
			if ( dia == 4 )
				ret = "DC";
			if ( dia == 5 )
				ret = "DJ";
			if ( dia == 6 )
				ret = "DV";
			if ( dia == 7 )
				ret = "DS";
		}
		return (ret);
	}

	public String RetornaDiaSetmanaReduitiData( Calendar data )
	{
		String ret = "";
		if ( data != null )
		{
			int dia = data.get( Calendar.DAY_OF_WEEK );
			if ( dia == 1 )
				ret = "DG";
			if ( dia == 2 )
				ret = "DL";
			if ( dia == 3 )
				ret = "DM";
			if ( dia == 4 )
				ret = "DC";
			if ( dia == 5 )
				ret = "DJ";
			if ( dia == 6 )
				ret = "DV";
			if ( dia == 7 )
				ret = "DS";
			String numdia = "" + data.get( Calendar.DAY_OF_MONTH );
			if ( numdia.length( ) == 1 )
				numdia = "0" + numdia;
			String mes = "" + (data.get( Calendar.MONTH ) + 1);
			if ( mes.length( ) == 1 )
				mes = "0" + mes;
			ret = ret + " " + numdia + "/" + mes;
		}
		return (ret);
	}

	public String RetornaDiaSetmanaiData( Calendar data )
	{
		String ret = "";
		if ( data != null )
		{
			int dia = data.get( Calendar.DAY_OF_WEEK );
			if ( dia == 1 )
				ret = "Diumenge";
			if ( dia == 2 )
				ret = "Dilluns";
			if ( dia == 3 )
				ret = "Dimarts";
			if ( dia == 4 )
				ret = "Dimecres";
			if ( dia == 5 )
				ret = "Dijous";
			if ( dia == 6 )
				ret = "Divendres";
			if ( dia == 7 )
				ret = "Dissabte";
			String numdia = "" + data.get( Calendar.DAY_OF_MONTH );
			if ( numdia.length( ) == 1 )
				numdia = "0" + numdia;
			String mes = "" + (data.get( Calendar.MONTH ) + 1);
			if ( mes.length( ) == 1 )
				mes = "0" + mes;
			ret = ret + " " + numdia + "/" + mes;
		}
		return (ret);
	}

	public String RetornaDiaSetmanaiHora( Calendar data )
	{
		String ret = "";
		if ( data != null )
		{
			int dia = data.get( Calendar.DAY_OF_WEEK );
			if ( dia == 1 )
				ret = "Diumenge";
			if ( dia == 2 )
				ret = "Dilluns";
			if ( dia == 3 )
				ret = "Dimarts";
			if ( dia == 4 )
				ret = "Dimecres";
			if ( dia == 5 )
				ret = "Dijous";
			if ( dia == 6 )
				ret = "Divendres";
			if ( dia == 7 )
				ret = "Dissabte";
			String hora = "" + data.get( Calendar.HOUR_OF_DAY );
			if ( hora.length( ) == 1 )
				hora = "0" + hora;
			String minut = "" + (data.get( Calendar.MINUTE ));
			if ( minut.length( ) == 1 )
				minut = "0" + minut;
			ret = ret + " " + hora + ":" + minut;
		}
		return (ret);
	}

	public String RetornaDiaSetmanaReduitiDataAmbAny( Calendar data )
	{
		String ret = "";
		if ( data != null )
		{
			int dia = data.get( Calendar.DAY_OF_WEEK );
			if ( dia == 1 )
				ret = "DG";
			if ( dia == 2 )
				ret = "DL";
			if ( dia == 3 )
				ret = "DM";
			if ( dia == 4 )
				ret = "DC";
			if ( dia == 5 )
				ret = "DJ";
			if ( dia == 6 )
				ret = "DV";
			if ( dia == 7 )
				ret = "DS";
			String numdia = "" + data.get( Calendar.DAY_OF_MONTH );
			if ( numdia.length( ) == 1 )
				numdia = "0" + numdia;
			String mes = "" + (data.get( Calendar.MONTH ) + 1);
			if ( mes.length( ) == 1 )
				mes = "0" + mes;
			int any = data.get( Calendar.YEAR ) - 2000;
			ret = ret + " " + numdia + "/" + mes + "/" + any;
		}
		return (ret);
	}

	public String CalendarToStringAmericaAAMMDD( Calendar datahora )
	{
		String ret = "";
		if ( datahora == null )
			ret = null;
		else
		{
			ret = "" + datahora.get( Calendar.YEAR ) + "-" + (datahora.get( Calendar.MONTH ) + 1) + "-" + datahora.get( Calendar.DAY_OF_MONTH ) + " " + datahora.get( Calendar.HOUR_OF_DAY ) + ":" + datahora.get( Calendar.MINUTE ) + ":" + datahora.get( Calendar.SECOND );
		}
		return (ret);
	}

	public String CalendarToStringAmericaAAMMDDNomesData( Calendar datahora )
	{
		String ret = "";
		if ( datahora == null )
			ret = null;
		else
		{
			int d = datahora.get( Calendar.DAY_OF_MONTH );
			String sd = "" + d;
			if ( d < 10 )
				sd = "0" + d;
			int m = datahora.get( Calendar.MONTH ) + 1;
			String sm = "" + m;
			if ( m < 10 )
				sm = "0" + m;
			ret = "" + datahora.get( Calendar.YEAR ) + "-" + sm + "-" + sd;
		}
		return (ret);
	}

	public String CalendarToStringAmericaAADDMM( Calendar datahora )
	{
		String l_data;
		int l_temp;

		l_data = "" + datahora.get( Calendar.YEAR );

		l_data += "-";
		l_temp = datahora.get( Calendar.DAY_OF_MONTH );
		l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

		l_data += "-";
		l_temp = datahora.get( Calendar.MONTH ) + 1;
		l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

		l_data += " ";
		l_temp = datahora.get( Calendar.HOUR_OF_DAY );
		l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

		l_data += ":";
		l_temp = datahora.get( Calendar.MINUTE );
		l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

		l_data += ":";
		l_temp = datahora.get( Calendar.SECOND );
		l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

		return l_data;
	}

	/**
	 * M�TODE: M�tode que donada una data en format DD/MM/AAAA o DD/MM/AAAA HH:MM:SS
	 * retorna en format AAAA/MM/DD o AAAA/MM/DD HH:MM:SS
	 */
	public String JavaFormatToMySQLFormat( String p_data )
	{
		try
		{
			p_data = p_data.trim( );

			if ( p_data.indexOf( " " ) != -1 )
			{
				String l_hora;
				l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.length( ) );
				p_data = p_data.substring( 0, p_data.indexOf( " " ) );

				l_hora = l_hora.trim( );
				p_data = p_data.trim( );

				String l_data[] = p_data.split( "/" );
				return l_data[2] + "/" + l_data[1] + "/" + l_data[0] + " " + l_hora;
			}
			else
			{
				String l_data[] = p_data.split( "/" );
				return l_data[2] + "/" + l_data[1] + "/" + l_data[0];
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * M�TODE: M�tode que donada una data en format DD/MM/AAAA o DD/MM/AAAA HH:MM:SS
	 * retorna en format AAAAMMDD000000 o AAAAMMDDHHMMSS
	 */
	public String JavaFormatToString( String p_data )
	{
		String l_dataFinal;

		try
		{
			p_data = p_data.trim( );

			if ( p_data.indexOf( " " ) != -1 )
			{
				String l_hora;
				l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.length( ) );
				p_data = p_data.substring( 0, p_data.indexOf( " " ) );

				l_hora = l_hora.trim( );
				p_data = p_data.trim( );

				String l_data[] = p_data.split( "/" );
				l_hora = l_hora.replace( ":", "" );

				l_dataFinal = l_data[2] + "" + l_data[1] + "" + l_data[0] + "" + l_hora;
				l_dataFinal = l_dataFinal.replace( " ", "" );
			}
			else
			{
				String l_data[] = p_data.split( "/" );
				l_dataFinal = l_data[2] + "" + l_data[1] + "" + l_data[0] + "000000";
			}
		}
		catch (Exception e)
		{
			l_dataFinal = null;
		}

		return l_dataFinal;
	}

	/**
	 * M�TODE: M�tode que donada una data en format AAAA/MM/DD o AAAA/MM/DD HH:MM:SS
	 * o AAAA-MM-DD o AAAA-MM-DD HH:MM:SS retorna en format DD/MM/AAAA o DD/MM/AAAA
	 * HH:MM:SS
	 */
	public String MySQLFormatToJavaFormat( String p_data )
	{
		try
		{
			p_data = p_data.trim( );

			if ( p_data.indexOf( " " ) != -1 )
			{
				String l_hora;
				l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.length( ) );
				p_data = p_data.substring( 0, p_data.indexOf( " " ) );

				l_hora = l_hora.trim( );
				p_data = p_data.trim( );

				if ( p_data.indexOf( "/" ) != -1 )
				{
					String l_data[] = p_data.split( "/" );
					return l_data[2] + "/" + l_data[1] + "/" + l_data[0] + " " + l_hora;
				}
				else if ( p_data.indexOf( "-" ) != -1 )
				{
					String l_data[] = p_data.split( "-" );
					return l_data[2] + "/" + l_data[1] + "/" + l_data[0] + " " + l_hora;
				}
				else
				{
					return null;
				}
			}
			else
			{
				if ( p_data.indexOf( "/" ) != -1 )
				{
					String l_data[] = p_data.split( "/" );
					return l_data[2] + "/" + l_data[1] + "/" + l_data[0];
				}
				else if ( p_data.indexOf( "-" ) != -1 )
				{
					String l_data[] = p_data.split( "-" );
					return l_data[2] + "/" + l_data[1] + "/" + l_data[0];
				}
				else
				{
					return null;
				}
			}
		}
		catch (Exception e)
		{
			return null;
		}
	}

	/**
	 * M�TODE: M�tode que donada una data en format AAAA/MM/DD o AAAA/MM/DD HH:MM:SS
	 * o AAAA-MM-DD o AAAA-MM-DD HH:MM:SS retorna un Calendar
	 */
	public Calendar MySQLFormatToCalendarFormat( String p_data )
	{
		String l_hora = null;
		Calendar l_calendar = null;

		try
		{
			p_data = p_data.trim( );

			if ( p_data.indexOf( " " ) != -1 )
			{
				l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.length( ) );
				p_data = p_data.substring( 0, p_data.indexOf( " " ) );
			}

			p_data = p_data.trim( );

			if ( p_data.indexOf( "/" ) != -1 )
			{
				String l_data[] = p_data.split( "/" );
				l_calendar = Calendar.getInstance( );
				l_calendar.set( Integer.parseInt( l_data[0] ), (Integer.parseInt( l_data[1] ) - 1), Integer.parseInt( l_data[2] ), 0, 0, 0 );
				l_calendar.set( Calendar.MILLISECOND, 0 );
			}
			else if ( p_data.indexOf( "-" ) != -1 )
			{
				String l_data[] = p_data.split( "-" );
				l_calendar = Calendar.getInstance( );
				l_calendar.set( Integer.parseInt( l_data[0] ), (Integer.parseInt( l_data[1] ) - 1), Integer.parseInt( l_data[2] ), 0, 0, 0 );
				l_calendar.set( Calendar.MILLISECOND, 0 );
			}

			if ( l_hora != null )
			{
				l_hora = l_hora.trim( );
				String l_horaDiv[] = l_hora.split( ":" );
				l_calendar.set( Calendar.HOUR_OF_DAY, Integer.parseInt( l_horaDiv[0] ) );
				l_calendar.set( Calendar.MINUTE, Integer.parseInt( l_horaDiv[1] ) );
				l_calendar.set( Calendar.SECOND, Integer.parseInt( l_horaDiv[2] ) );
			}
		}
		catch (Exception e)
		{
			l_calendar = null;
		}

		return l_calendar;
	}

	public Calendar MySQLFormatToCalendarFormatAmbMilisegons( String p_data )
	{
		int l_milisegons = 0;
		String l_hora = null;
		Calendar l_calendar = null;

		try
		{
			p_data = p_data.trim( );

			if ( p_data.indexOf( " " ) != -1 )
			{
				if ( p_data.indexOf( "." ) != -1 )
				{
					l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.indexOf( "." ) );
					l_milisegons = Integer.parseInt( p_data.substring( p_data.indexOf( "." ) + 1 ) );
				}
				else
				{
					l_hora = p_data.substring( p_data.indexOf( " " ) + 1, p_data.length( ) );
				}

				p_data = p_data.substring( 0, p_data.indexOf( " " ) );
			}

			p_data = p_data.trim( );

			if ( p_data.indexOf( "/" ) != -1 )
			{
				String l_data[] = p_data.split( "/" );
				l_calendar = Calendar.getInstance( );
				l_calendar.set( Integer.parseInt( l_data[0] ), (Integer.parseInt( l_data[1] ) - 1), Integer.parseInt( l_data[2] ), 0, 0, 0 );
			}
			else if ( p_data.indexOf( "-" ) != -1 )
			{
				String l_data[] = p_data.split( "-" );
				l_calendar = Calendar.getInstance( );
				l_calendar.set( Integer.parseInt( l_data[0] ), (Integer.parseInt( l_data[1] ) - 1), Integer.parseInt( l_data[2] ), 0, 0, 0 );
			}

			if ( l_hora != null )
			{
				l_hora = l_hora.trim( );
				String l_horaDiv[] = l_hora.split( ":" );
				l_calendar.set( Calendar.HOUR_OF_DAY, Integer.parseInt( l_horaDiv[0] ) );
				l_calendar.set( Calendar.MINUTE, Integer.parseInt( l_horaDiv[1] ) );
				l_calendar.set( Calendar.SECOND, Integer.parseInt( l_horaDiv[2] ) );
			}

			l_calendar.set( Calendar.MILLISECOND, l_milisegons );
		}
		catch (Exception e)
		{
			l_calendar = null;
		}

		return l_calendar;
	}

	/**
	 * M�TODE: M�tode que donada una data en format Calendar retorna en format
	 * AAAA/MM/DD o AAAA/MM/DD HH:MM:SS
	 */
	public String CalendarFormatToMySQLFormat( Calendar p_data )
	{
		String l_data;
		int l_temp;

		try
		{
			l_data = "" + p_data.get( Calendar.YEAR );

			l_data += "/";
			l_temp = p_data.get( Calendar.MONTH ) + 1;
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += "/";
			l_temp = p_data.get( Calendar.DAY_OF_MONTH );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += " ";
			l_temp = p_data.get( Calendar.HOUR_OF_DAY );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += ":";
			l_temp = p_data.get( Calendar.MINUTE );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += ":";
			l_temp = p_data.get( Calendar.SECOND );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;
		}
		catch (Exception e)
		{
			l_data = null;
		}

		return l_data;
	}

	/**
	 * M�TODE: M�tode que donada una data en format Calendar retorna en format
	 * DD/mm/AAAA HH:MM
	 */
	public String CalendarFormatToDDMMAAAAHHMM( Calendar p_data )
	{
		String l_data;
		int l_temp;

		try
		{
			l_temp = p_data.get( Calendar.DAY_OF_MONTH );
			l_data = l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += "/";
			l_temp = p_data.get( Calendar.MONTH ) + 1;
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += "/";
			l_data += "" + p_data.get( Calendar.YEAR );

			l_data += " ";
			l_temp = p_data.get( Calendar.HOUR_OF_DAY );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += ":";
			l_temp = p_data.get( Calendar.MINUTE );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;
		}
		catch (Exception e)
		{
			l_data = null;
		}

		return l_data;
	}

	/**
	 * M�TODE: M�tode que donada una data en format Calendar retorna en format
	 * DD/mm/AAAA HH:MM
	 */
	public String CalendarFormatToDDMMAAAAHHMMSS( Calendar p_data )
	{
		String l_data;
		int l_temp;

		try
		{
			l_temp = p_data.get( Calendar.DAY_OF_MONTH );
			l_data = l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += "/";
			l_temp = p_data.get( Calendar.MONTH ) + 1;
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += "/";
			l_data += "" + p_data.get( Calendar.YEAR );

			l_data += " ";
			l_temp = p_data.get( Calendar.HOUR_OF_DAY );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += ":";
			l_temp = p_data.get( Calendar.MINUTE );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;

			l_data += ":";
			l_temp = p_data.get( Calendar.SECOND );
			l_data += l_temp < 10 ? "0" + l_temp : "" + l_temp;
		}
		catch (Exception e)
		{
			l_data = null;
		}

		return l_data;
	}

	/**
	 * M�TODE: M�tode que donada una data en format DD/MM/AAAA HH:MM retorna un
	 * Calendar
	 */
	public Calendar DDMMAAAAHHMMtoCalendarFormat( String p_data )
	{
		Calendar l_calendar;
		l_calendar = Calendar.getInstance( );

		try
		{
			String l_dataHoraDividida[] = p_data.trim( ).split( " " );

			String l_dataDividida[] = l_dataHoraDividida[0].split( "/" );
			l_calendar.set( Calendar.DAY_OF_MONTH, Integer.parseInt( l_dataDividida[0] ) );
			l_calendar.set( Calendar.MONTH, Integer.parseInt( l_dataDividida[1] ) - 1 );
			l_calendar.set( Calendar.YEAR, Integer.parseInt( l_dataDividida[2] ) );

			String l_horaDividida[] = l_dataHoraDividida[1].split( ":" );
			l_calendar.set( Calendar.HOUR_OF_DAY, Integer.parseInt( l_horaDividida[0] ) );
			l_calendar.set( Calendar.MINUTE, Integer.parseInt( l_horaDividida[1] ) );
			l_calendar.set( Calendar.SECOND, 0 );
			l_calendar.set( Calendar.MILLISECOND, 0 );
		}
		catch (Exception e)
		{
			l_calendar = null;
		}

		return l_calendar;
	}

	public String CalendarFormatToMySQLFormatAmbMilisegons( Calendar p_data )
	{
		String l_data = CalendarFormatToMySQLFormat( p_data );
		if ( l_data != null )
		{
			l_data += ".";

			int l_ms = p_data.get( Calendar.MILLISECOND );
			if ( l_ms < 100 )
			{
				l_data += "0";

				if ( l_ms < 10 )
				{
					l_data += "0";
				}
			}

			l_data += l_ms;
		}

		return l_data;
	}

	/*** M�TODE: retorna true si DD-MM-AAAA es correcte */
	public boolean ComprovarDDMMAAA( String p_dataHora, boolean p_potSerNull )
	{
		if ( p_dataHora == null || p_dataHora.length( ) <= 0 )
		{
			if ( p_potSerNull )
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat( "mm/dd/yyyy" );

		try
		{
			dateFormat.parse( p_dataHora );
		}
		catch (ParseException e)
		{
			return false;
		}
		return true;
	}

	public Calendar Arrodonira15MinutsCapEnrrera( Calendar cal )
	{
		while ((cal.get( Calendar.MINUTE ) != 0) && (cal.get( Calendar.MINUTE ) != 15) && (cal.get( Calendar.MINUTE ) != 30) && (cal.get( Calendar.MINUTE ) != 45))
		{
			cal.add( Calendar.MINUTE, -1 );
		}
		return (cal);
	}

	/**
	 * M�TODE: M�tode que donades dues dates del format DD/MM/AAAA o DD/MM/AAAA
	 * HH:MM:SS retorna 0: Si Avui esta entra les dues dates -1: Si avui �s m�s tard
	 * que les dues dates 1: Si avui �s m�s aviat que les dues dates -2: Si hi ha
	 * error
	 */
	public int IsTodayBetweenTwoDates( Calendar p_dataInicial, Calendar p_dataFinal )
	{
		long l_dataInicial, l_dataFinal, l_dataActual;

		try
		{
			l_dataInicial = p_dataInicial.getTimeInMillis( );
		}
		catch (Exception e)
		{
			return -2;
		}

		try
		{
			l_dataFinal = p_dataFinal.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataFinal = (long) 9999999999999.0;
		}

		if ( l_dataInicial == -2 && l_dataFinal == 9999999999999.0 )
		{
			return -2;
		}

		l_dataActual = Calendar.getInstance( ).getTimeInMillis( );
		if ( l_dataActual < l_dataInicial )
		{
			return 1;
		}
		else if ( l_dataActual > l_dataFinal )
		{
			return -1;
		}
		else if ( l_dataActual >= l_dataInicial && l_dataActual <= l_dataFinal )
		{
			return 0;
		}

		return -2;
	}

	/**
	 * M�TODE: M�tode que donat un Calendar retorna true si est� entre
	 * p_dataInicial, p_dataFinal
	 */

	public boolean IsDataBetweenTwoDates( Calendar p_dataAnalitzar, Calendar p_dataInicial, Calendar p_dataFinal )
	{
		long l_dataInicial, l_dataFinal, l_dataAnalitzar;

		try
		{
			p_dataAnalitzar.set( Calendar.MILLISECOND, 0 );
			l_dataAnalitzar = p_dataAnalitzar.getTimeInMillis( );
		}
		catch (Exception e)
		{
			return false;
		}

		try
		{
			p_dataInicial.set( Calendar.MILLISECOND, 0 );
			l_dataInicial = p_dataInicial.getTimeInMillis( );
		}
		catch (Exception e)
		{
			return false;
		}

		try
		{
			p_dataFinal.set( Calendar.MILLISECOND, 0 );
			l_dataFinal = p_dataFinal.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataFinal = (long) 9999999999999.0;
		}

		if ( l_dataInicial <= l_dataAnalitzar && l_dataAnalitzar <= l_dataFinal )
		{
			return true;
		}

		return false;
	}

	public boolean DataInicialMesPetitaDataFinal( Calendar p_dataInicial, Calendar p_dataFinal )
	{
		if ( p_dataInicial == null && p_dataFinal == null )
		{
			return true;
		}
		else if ( p_dataInicial != null && p_dataFinal == null )
		{
			return true;
		}
		else if ( p_dataInicial == null && p_dataFinal != null )
		{
			return false;
		}
		else
		{
			p_dataInicial.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataInicial.set( Calendar.MINUTE, 0 );
			p_dataInicial.set( Calendar.SECOND, 0 );
			p_dataInicial.set( Calendar.MILLISECOND, 0 );

			p_dataFinal.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataFinal.set( Calendar.MINUTE, 0 );
			p_dataFinal.set( Calendar.SECOND, 0 );
			p_dataFinal.set( Calendar.MILLISECOND, 0 );

			return p_dataInicial.getTimeInMillis( ) <= p_dataFinal.getTimeInMillis( );
		}
	}

	public boolean CoincideixIntervalTemps( Calendar p_dataInici1, Calendar p_dataFi1, Calendar p_dataInici2, Calendar p_dataFi2 )
	{
		long l_dataInicial1, l_dataFinal1, l_dataInicial2, l_dataFinal2;

		try
		{
			p_dataInici1.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataInici1.set( Calendar.MINUTE, 0 );
			p_dataInici1.set( Calendar.SECOND, 0 );
			p_dataInici1.set( Calendar.MILLISECOND, 0 );
			l_dataInicial1 = p_dataInici1.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataInicial1 = (long) 9999999999999.0;
		}

		try
		{
			p_dataFi1.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataFi1.set( Calendar.MINUTE, 0 );
			p_dataFi1.set( Calendar.SECOND, 0 );
			p_dataFi1.set( Calendar.MILLISECOND, 0 );
			l_dataFinal1 = p_dataFi1.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataFinal1 = (long) 9999999999999.0;
		}

		try
		{
			p_dataInici2.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataInici2.set( Calendar.MINUTE, 0 );
			p_dataInici2.set( Calendar.SECOND, 0 );
			p_dataInici2.set( Calendar.MILLISECOND, 0 );
			l_dataInicial2 = p_dataInici2.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataInicial2 = (long) 9999999999999.0;
		}

		try
		{
			p_dataFi2.set( Calendar.HOUR_OF_DAY, 0 );
			p_dataFi2.set( Calendar.MINUTE, 0 );
			p_dataFi2.set( Calendar.SECOND, 0 );
			p_dataFi2.set( Calendar.MILLISECOND, 0 );
			l_dataFinal2 = p_dataFi2.getTimeInMillis( );
		}
		catch (Exception e)
		{
			l_dataFinal2 = (long) 9999999999999.0;
		}

		if ( (l_dataInicial1 == 9999999999999.0 && l_dataFinal1 == 9999999999999.0) || (l_dataInicial2 == 9999999999999.0 && l_dataFinal2 == 9999999999999.0) )
		{
			return false;
		}
		else if ( l_dataFinal1 == 9999999999999.0 && l_dataFinal2 == 9999999999999.0 )
		{
			return true;
		}
		else if ( (l_dataFinal1 <= l_dataInicial2 || l_dataFinal2 <= l_dataInicial1) && l_dataInicial1 != l_dataInicial2 )
		{
			return false;
		}
		else if ( l_dataInicial1 == l_dataFinal1 && l_dataInicial2 == l_dataFinal2 && l_dataInicial1 == l_dataInicial2 )
		{
			return false;
		}

		// Sense Data Final
		if ( l_dataFinal1 == 9999999999999.0 )
		{
			if ( l_dataInicial2 > l_dataInicial1 )
			{
				return false;
			}
		}

		return true;
	}

	public boolean EsMateixaData( Calendar p_data1, Calendar p_data2, boolean p_noComprarHores )
	{
		long l_data1Long, l_data2Long;
		Calendar l_data1, l_data2;

		l_data1Long = 0;
		l_data2Long = 0;

		try
		{
			if ( p_noComprarHores )
			{
				l_data1 = (Calendar) p_data1.clone( );
				l_data1.set( Calendar.HOUR_OF_DAY, 0 );
				l_data1.set( Calendar.MINUTE, 0 );
				l_data1.set( Calendar.SECOND, 0 );
				l_data1.set( Calendar.MILLISECOND, 0 );
				l_data1Long = l_data1.getTimeInMillis( );
			}
			else
			{
				p_data1.set( Calendar.MILLISECOND, 0 );
				l_data1Long = p_data1.getTimeInMillis( );
			}
		}
		catch (Exception e)
		{
			l_data1Long = (long) 9999999999999.0;
		}

		try
		{
			if ( p_noComprarHores )
			{
				l_data2 = (Calendar) p_data2.clone( );
				l_data2.set( Calendar.HOUR_OF_DAY, 0 );
				l_data2.set( Calendar.MINUTE, 0 );
				l_data2.set( Calendar.SECOND, 0 );
				l_data2.set( Calendar.MILLISECOND, 0 );
				l_data2Long = l_data2.getTimeInMillis( );
			}
			else
			{
				p_data2.set( Calendar.MILLISECOND, 0 );
				l_data2Long = p_data2.getTimeInMillis( );
			}
		}
		catch (Exception e)
		{
			l_data2Long = (long) 9999999999999.0;
		}

		return l_data1Long == l_data2Long;
	}

	public Calendar RetornaDiaIniciSetmanaActual()
	{
		Calendar l_data = RetornaDataActual( );
		while (l_data.get( Calendar.DAY_OF_WEEK ) != Calendar.MONDAY)
		{
			l_data.add( Calendar.DAY_OF_YEAR, -1 );
		}
		return (l_data);
	}

	public Calendar RetornaDiaFinalSetmanaActual()
	{
		Calendar l_data = RetornaDataActual( );
		while (l_data.get( Calendar.DAY_OF_WEEK ) != Calendar.SUNDAY)
		{
			l_data.add( Calendar.DAY_OF_YEAR, 1 );
		}
		return (l_data);
	}

	public Calendar RetornaDiaIniciSetmanaSeguent( Calendar p_data )
	{
		Calendar l_data = (Calendar) p_data.clone( );
		while (l_data.get( Calendar.DAY_OF_WEEK ) != Calendar.MONDAY)
		{
			l_data.add( Calendar.DAY_OF_YEAR, +1 );
		}
		return (l_data);
	}

	/** M�TODE: M�tode que ens retorna la data d'avui en format AAAAMMDDHHMMSS */
	public String RetornaAvuiAAAAMMSSHHMMSS()
	{
		int l_temporal;
		Calendar l_calendari;
		String l_data;

		l_calendari = Calendar.getInstance( );
		l_calendari.set( Calendar.MILLISECOND, 0 );

		l_temporal = (l_calendari.get( Calendar.YEAR ));
		l_data = "" + l_temporal;

		l_temporal = (l_calendari.get( Calendar.MONTH ) + 1);
		l_data += l_temporal < 10 ? ("0" + l_temporal) : ("" + l_temporal);

		l_temporal = l_calendari.get( Calendar.DAY_OF_MONTH );
		l_data += l_temporal < 10 ? ("0" + l_temporal) : ("" + l_temporal);

		l_temporal = l_calendari.get( Calendar.HOUR_OF_DAY );
		l_data += l_temporal < 10 ? ("0" + l_temporal) : ("" + l_temporal);

		l_temporal = l_calendari.get( Calendar.MINUTE );
		l_data += l_temporal < 10 ? ("0" + l_temporal) : ("" + l_temporal);

		l_temporal = l_calendari.get( Calendar.SECOND );
		l_data += l_temporal < 10 ? ("0" + l_temporal) : ("" + l_temporal);

		return l_data;
	}

	public String CalendarToStringEuropeuFormal( Calendar p_data )
	{
		try
		{
			String l_day = IntToStringMinimDosDigits( p_data.get( Calendar.DAY_OF_MONTH ) );
			String l_month = IntToStringMinimDosDigits( p_data.get( Calendar.MONTH ) + 1 );
			int l_year = p_data.get( Calendar.YEAR );
			String l_hour = IntToStringMinimDosDigits( p_data.get( Calendar.HOUR_OF_DAY ) );
			String l_minute = IntToStringMinimDosDigits( p_data.get( Calendar.MINUTE ) );

			return l_day + "-" + l_month + "-" + l_year + " " + l_hour + ":" + l_minute;
		}
		catch (NullPointerException e)
		{
			return null;
		}

	}

	private String IntToStringMinimDosDigits( int p_number )
	{
		if ( p_number < 10 )
			return "0" + p_number;
		return "" + p_number;
	}

	public String DataFormal( String p_data )
	{
		String l_dataFinal = "";
		Scanner l_s = new Scanner( p_data );
		l_s.useDelimiter( "-" );

		while (l_s.hasNext( ))
		{
			l_dataFinal = "-" + l_s.next( ) + l_dataFinal;
		}

		l_s.close( );
		return l_dataFinal.substring( 1 );
	}

	public String HoraFormal( String p_hora )
	{
		return p_hora.substring( 0, p_hora.length( ) - 3 );
	}

	public String CalendarToStringDataHoraSimplificadaInvertida( Calendar p_data )
	{
		int l_any = p_data.get( Calendar.YEAR );
		int l_mes = p_data.get( Calendar.MONTH ) + 1;
		int l_dia = p_data.get( Calendar.DAY_OF_MONTH );
		int l_hora = p_data.get( Calendar.HOUR_OF_DAY );
		int l_min = p_data.get( Calendar.MINUTE );
		int l_seg = p_data.get( Calendar.SECOND );

		String l_res = "" + l_any;
		l_res += (l_mes < 10 ? "0" : "") + l_mes;
		l_res += (l_dia < 10 ? "0" : "") + l_dia;
		l_res += (l_hora < 10 ? "0" : "") + l_hora;
		l_res += (l_min < 10 ? "0" : "") + l_min;
		l_res += (l_seg < 10 ? "0" : "") + l_seg;

		return l_res;
	}

	public String CalendarToStringDataSimplificadaInvertida( Calendar p_data )
	{
		int l_any = p_data.get( Calendar.YEAR );
		int l_mes = p_data.get( Calendar.MONTH ) + 1;
		int l_dia = p_data.get( Calendar.DAY_OF_MONTH );

		String l_res = "" + l_any;
		l_res += (l_mes < 10 ? "0" : "") + l_mes;
		l_res += (l_dia < 10 ? "0" : "") + l_dia;
		return l_res;
	}

	public String DataHoraSimplificadaInvertida( String l_data )
	{
		Scanner s = new Scanner( l_data );

		s.useDelimiter( "-" );

		if ( l_data.contains( "/" ) )
			s.useDelimiter( "/" );

		String l_dia = s.next( );
		if ( Integer.parseInt( l_dia ) < 10 )
		{
			l_dia = "0" + l_dia;
		}
		String l_mes = s.next( );
		if ( Integer.parseInt( l_mes ) < 10 )
		{
			l_mes = "0" + l_mes;
		}
		s.useDelimiter( " " );
		String l_any = s.next( ).replaceAll( "-", "" ).replaceAll( "/", "" );

		s.useDelimiter( ":" );
		String l_hora = s.next( ).replaceAll( " ", "" );
		String l_minut = s.next( );
		String l_segon = s.next( );

		s.close( );

		String l_dataFinal = l_any + l_mes + l_dia + l_hora + l_minut + l_segon;

		return l_dataFinal;
	}

	public long DiferenciaEnDies( Calendar p_dataInici, Calendar p_dataFinal )
	{
		long diff = (p_dataFinal.getTimeInMillis( )) - (p_dataInici.getTimeInMillis( ));
		return TimeUnit.DAYS.convert( diff, TimeUnit.MILLISECONDS );
	}

	public long DiferenciaEnHores( Calendar p_dataInici, Calendar p_dataFinal )
	{
		long diff = (p_dataFinal.getTimeInMillis( )) - (p_dataInici.getTimeInMillis( ));
		return TimeUnit.HOURS.convert( diff, TimeUnit.MILLISECONDS );
	}

	public long DiferenciaEnMinuts( Calendar p_dataInici, Calendar p_dataFinal )
	{
		long diff = (p_dataFinal.getTimeInMillis( )) - (p_dataInici.getTimeInMillis( ));
		return TimeUnit.MINUTES.convert( diff, TimeUnit.MILLISECONDS );
	}

	public String DiferenciaDiesHoresMinutsString( Calendar p_dataInici, Calendar p_dataFinal )
	{
		long diff = (p_dataFinal.getTimeInMillis( )) - (p_dataInici.getTimeInMillis( ));
		long l_dies = TimeUnit.DAYS.convert( diff, TimeUnit.MILLISECONDS );
		long l_hores = TimeUnit.HOURS.convert( diff, TimeUnit.MILLISECONDS ) % 24;
		long l_min = TimeUnit.MINUTES.convert( diff, TimeUnit.MILLISECONDS ) % 60;
		return l_dies + "d, " + l_hores + "h, " + l_min + "m";
	}

	public Calendar MySQLFormatNomesHoraToCalendarFormat( String p_hora )
	{
		Scanner l_scan = new Scanner( p_hora );
		l_scan.useDelimiter( ":" );

		Calendar l_res = new GregorianCalendar( );
		l_res.set( Calendar.DAY_OF_MONTH, 1 );
		l_res.set( Calendar.MONTH, Calendar.JANUARY );
		l_res.set( Calendar.HOUR_OF_DAY, l_scan.nextInt( ) );
		l_res.set( Calendar.MINUTE, l_scan.nextInt( ) );
		l_res.set( Calendar.SECOND, 0 );

		l_scan.close( );

		return l_res;
	}

	public String retornaMMAA( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int mes = (datahora.get( Calendar.MONTH ) + 1);
			String smes = "" + mes;
			if ( mes < 10 )
				smes = "0" + mes;
			ret = "" + smes + "/" + (("" + datahora.get( Calendar.YEAR )).substring( 2, 4 ));
		}
		return (ret);
	}

	public String CalendarFormatToMySQLFormatData( Calendar p_data )
	{
		String ret = "" + p_data.get( Calendar.YEAR ) + "-";
		if ( p_data.get( Calendar.MONTH ) + 1 < 10 )
		{
			ret = ret + "0" + (p_data.get( Calendar.MONTH ) + 1) + "-";
		}
		else
		{
			ret = ret + (p_data.get( Calendar.MONTH ) + 1) + "-";
		}
		if ( p_data.get( Calendar.DAY_OF_MONTH ) < 10 )
		{
			ret = ret + "0" + p_data.get( Calendar.DAY_OF_MONTH );
		}
		else
		{
			ret = ret + p_data.get( Calendar.DAY_OF_MONTH );
		}
		return (ret);
	}

	public Calendar StringHoraToCalendar( String p_hora )
	{
		String l_hores[] = p_hora.split( ":" );

		Calendar l_res = new GregorianCalendar( );
		l_res.set( Calendar.DAY_OF_MONTH, 1 );
		l_res.set( Calendar.MONTH, Calendar.JANUARY );
		l_res.set( Calendar.HOUR_OF_DAY, Integer.parseInt( l_hores[0] ) );
		if ( l_hores.length > 1 )
			l_res.set( Calendar.MINUTE, Integer.parseInt( l_hores[1] ) );
		else
			l_res.set( Calendar.MINUTE, 0 );
		if ( l_hores.length > 2 )
			l_res.set( Calendar.SECOND, Integer.parseInt( l_hores[2] ) );
		else
			l_res.set( Calendar.SECOND, 0 );
		return l_res;
	}

	public String CalendarHoraToString( Calendar datahora )
	{
		String ret = "";
		if ( datahora != null )
		{
			int hora = (datahora.get( Calendar.HOUR_OF_DAY ));
			String shora = "" + hora;
			if ( hora < 10 )
				shora = "0" + hora;
			int minuts = (datahora.get( Calendar.MINUTE ));
			String sminuts = "" + minuts;
			if ( minuts < 10 )
				sminuts = "0" + minuts;
			int segons = (datahora.get( Calendar.SECOND ));
			String ssegons = "" + segons;
			if ( segons < 10 )
				ssegons = "0" + segons;
			ret = "" + shora + ":" + sminuts + ":" + ssegons;
		}
		return (ret);
	}

	public String RetornaDiaMesHoraMinut( Calendar p_data )
	{
		int l_mes = p_data.get( Calendar.MONTH ) + 1;
		int l_dia = p_data.get( Calendar.DAY_OF_MONTH );
		int l_hora = p_data.get( Calendar.HOUR_OF_DAY );
		int l_min = p_data.get( Calendar.MINUTE );

		String l_res = "";
		l_res += (l_dia < 10 ? "0" : "") + l_dia + "/";
		l_res += (l_mes < 10 ? "0" : "") + l_mes + " ";
		l_res += (l_hora < 10 ? "0" : "") + l_hora + ":";
		l_res += (l_min < 10 ? "0" : "") + l_min;
		return l_res;
	}

	public String RetornaDiaMes( Calendar p_data )
	{
		int l_mes = p_data.get( Calendar.MONTH ) + 1;
		int l_dia = p_data.get( Calendar.DAY_OF_MONTH );

		String l_res = "";
		l_res += (l_dia < 10 ? "0" : "") + l_dia + "/";
		l_res += (l_mes < 10 ? "0" : "") + l_mes;
		return l_res;
	}

	public Calendar DiaMesHoresMinutsToCalendar( String p_stringData )
	{
		Calendar l_res = new GregorianCalendar( );

		String l_stringDataAux = "" + p_stringData;

		String l_dia = l_stringDataAux.substring( 0, l_stringDataAux.indexOf( "/" ) );
		l_stringDataAux = l_stringDataAux.replace( l_dia + "/", "" );

		String l_mes = l_stringDataAux.substring( 0, l_stringDataAux.indexOf( " " ) );
		l_stringDataAux = l_stringDataAux.replace( l_mes + " ", "" );

		String l_hora = l_stringDataAux.substring( 0, l_stringDataAux.indexOf( ":" ) );
		l_stringDataAux = l_stringDataAux.replace( l_hora + ":", "" );

		String l_min = l_stringDataAux;

		try
		{
			l_res.set( Calendar.MONTH, (Integer.parseInt( l_mes ) - 1) );
			l_res.set( Calendar.DAY_OF_MONTH, Integer.parseInt( l_dia ) );
			l_res.set( Calendar.HOUR_OF_DAY, Integer.parseInt( l_hora ) );
			l_res.set( Calendar.MINUTE, Integer.parseInt( l_min ) );
			l_res.set( Calendar.SECOND, 0 );
			l_res.set( Calendar.MILLISECOND, 0 );
		}
		catch (Exception e)
		{
			System.err.println( "ERROR PARSEJANT CALENDARI" );
		}

		return l_res;
	}

	public String CalendarToHHMM( Calendar p_cal )
	{
		String l_res = "";

		int l_hora = p_cal.get( Calendar.HOUR_OF_DAY );
		int l_min = p_cal.get( Calendar.MINUTE );

		l_res += (l_hora < 10 ? "0" : "") + l_hora;
		l_res += ":";
		l_res += (l_min < 10 ? "0" : "") + l_min;

		return l_res;
	}

	/*
	 * public int retornaDiesDiferencia(Calendar calendar1, Calendar calendar2) { //
	 * si alg�n par�metro es null devolvemos 0 if (calendar1 == null || calendar1 ==
	 * null) { return 0; }
	 * 
	 * 
	 * 
	 * calendar1 = setMidnight(calendar1);
	 * 
	 * calendar2 = setMidnight(calendar2);
	 * 
	 * 
	 * 
	 * // comprobamos cu�l es mayor para setearlo correctamente
	 * 
	 * if (calendar2.compareTo(calendar1) > 0) {
	 * 
	 * calendar1.setTime(date1);
	 * 
	 * calendar2.setTime(date2);
	 * 
	 * 
	 * 
	 * } else {
	 * 
	 * calendar1.setTime(date2);
	 * 
	 * calendar2.setTime(date1);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * int days = 0;
	 * 
	 * 
	 * 
	 * // mientras la fecha del calendario 2 sea mayor que la fecha del calendario 1
	 * 
	 * while (calendar1.compareTo(calendar2) < 0) {
	 * 
	 * calendar1.add(Calendar.DAY_OF_MONTH, 1); // suma un d�a al calendario 1
	 * 
	 * days++;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * return days;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public static Date setMidnight(Date date) {
	 * 
	 * Calendar calendar = Calendar.getInstance();
	 * 
	 * calendar.setTime(date);
	 * 
	 * 
	 * 
	 * calendar.set(Calendar.HOUR_OF_DAY, 0);
	 * 
	 * calendar.set(Calendar.MINUTE, 0);
	 * 
	 * calendar.set(Calendar.SECOND, 0);
	 * 
	 * calendar.set(Calendar.MILLISECOND, 0);
	 * 
	 * 
	 * 
	 * return calendar.getTime();
	 * 
	 * }
	 */

}
