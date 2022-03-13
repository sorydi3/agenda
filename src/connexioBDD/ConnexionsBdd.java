package connexioBDD;

import agendaproduccio.utils.DataHora;

public class ConnexionsBdd
{
private static ConnexionsBdd m_singleton;

public DataAccessLayer m_bddMySqlCrm;
public DataAccessLayer m_bddMySqlPressupostos;
public DataAccessLayer m_bddMySqlPressupostosThread;
public DataAccessLayer m_bddMySqlPressupostosDaemonUpdate;
public DataAccessLayer m_bddMySqlPressupostosAvisosCalendari;
public DataAccessLayer m_bddMySqlControlPlanta;
public DataAccessLayer m_bddMySqlConnexioWeb;
public DataAccessLayer m_bddMySqlConnexioWebAlterEgo;
public DataAccessLayer m_bddMateriesPrimes;
public DataAccessLayer m_bddMySqlErpControlPlanta;
private DataAccessLayer m_bddSQLServerHistoricCP;
private DataAccessLayer m_bddMySqlHistoricCP;
private DataAccessLayer m_bddMySqlExpedicions;
public DataAccessLayer m_bddControlPlantaTraspassades;
public DataAccessLayer m_bddMySqlERP4;

private ConnexionsBdd()
{
	

	m_bddMySqlControlPlanta = new DataAccessLayer( "MYSQL", "./config/Connexiocontrolplanta.txt", "root", "Ibrahima_22" );
	m_bddMySqlControlPlanta.ShowInformacio( );
	
	m_bddMySqlERP4 = null;
	if ( System.getProperty("user.name").equals("oliveras") || System.getProperty("user.name").equals("nievas") || System.getProperty("user.name").equals("serra"))
	{
		m_bddMySqlERP4 = new DataAccessLayer( "MYSQL", "./config/ConnexioERP4.txt", "root", "Ibrahima_22" );
		m_bddMySqlERP4.ShowInformacio( );
	}
}


public DataAccessLayer RetornaConnexioERPControlPlanta()
{
	if ( m_bddMySqlErpControlPlanta == null )
	{
		m_bddMySqlErpControlPlanta = new DataAccessLayer( "MYSQL", "./config/ConnexioERPControlplanta.txt", "root", "Ibrahima_22" );
		m_bddMySqlErpControlPlanta.ShowInformacio( );
	}
	return (m_bddMySqlErpControlPlanta);
}

public DataAccessLayer RetornaConnexioSQLServerHistoricCP()
{
	if ( m_bddSQLServerHistoricCP == null )
	{
		m_bddSQLServerHistoricCP = new DataAccessLayer( "SQLSERVER", "./config/ConnexioSQLServerHistoricCP.txt", "sa", "produccio" );
		m_bddSQLServerHistoricCP.ShowInformacio( );
	}
	return (m_bddSQLServerHistoricCP);
}

public DataAccessLayer RetornaConnexioMySQLHistoricCP()
{
	if ( m_bddMySqlHistoricCP == null )
	{
		m_bddMySqlHistoricCP = new DataAccessLayer( "MYSQL", "./config/ConnexioMySQLHistoricCP.txt", "root", "Ibrahima_22" );
		m_bddMySqlHistoricCP.ShowInformacio( );
	}
	return (m_bddMySqlHistoricCP);
}

public DataAccessLayer RetornaConnexioMYSQLExpedicions()
{
	if ( m_bddMySqlExpedicions == null )
	{
		m_bddMySqlExpedicions = new DataAccessLayer( "MYSQL", "./config/ConnexioExpedicions.txt", "root", "lpc1232001" );
		m_bddMySqlExpedicions.ShowInformacio( );
	}
	return (m_bddMySqlExpedicions);
}

public DataAccessLayer FerConnexioWeb()
{
	if ( m_bddMySqlConnexioWeb == null )
	{
		System.out.println( "Fem connexi� a web " + DataHora.getInstance( ).CalendarToStringEuropeu( DataHora.getInstance( ).RetornaDataActual( ) ) );
		m_bddMySqlConnexioWeb = new DataAccessLayer( "MYSQL", "./config/ConnexioWeb.txt", "rotimpr_user", "No^F0.{B9)_n" );
		m_bddMySqlConnexioWeb.ShowInformacio( );
		System.out.println( "Fi connexi� a web " + DataHora.getInstance( ).CalendarToStringEuropeu( DataHora.getInstance( ).RetornaDataActual( ) ) );
	}
	else
	{
		m_bddMySqlConnexioWeb.connecta( );
	}

	return m_bddMySqlConnexioWeb;
}

public void DesconnectarWeb()
{
	if ( m_bddMySqlConnexioWeb != null )
	{
		m_bddMySqlConnexioWeb.desconnecta( );
	}
}

public DataAccessLayer FerConnexioWebAlterEgo()
{
	if ( m_bddMySqlConnexioWebAlterEgo == null )
	{
		m_bddMySqlConnexioWebAlterEgo = new DataAccessLayer( "MYSQL", "./config/ConnexioWebAlterEgo.txt", "pznspexzhc", "qd9aYwePaa" );
		// m_bddMySqlConnexioWebAlterEgo = new DataAccessLayer( "MYSQL", "./config/ConnexioWebAlterEgo.txt", "busdjgmgxv", "kc75zq8PAT" );
		m_bddMySqlConnexioWebAlterEgo.ShowInformacio( );
	}
	/*
	 * else { m_bddMySqlConnexioWebAlterEgo.connecta( ); }
	 */

	return m_bddMySqlConnexioWebAlterEgo;
}

public void DesconnectarWebAlterEgo()
{
	try
	{
		if ( m_bddMySqlConnexioWebAlterEgo != null )
		{
			m_bddMySqlConnexioWebAlterEgo.desconnecta( );
			m_bddMySqlConnexioWebAlterEgo = null;
		}
	}
	catch (Exception e)
	{
		m_bddMySqlConnexioWebAlterEgo = null;
	}
}

public static ConnexionsBdd getInstance()
{
	if ( m_singleton == null )
	{
		m_singleton = new ConnexionsBdd( );
	}
	return m_singleton;
}

/*
 * public DataAccessLayer RetornaConnexioSQLServerBobines() { if (
 * m_bddBobinesSQLServer == null ) { m_bddBobinesSQLServer = new
 * DataAccessLayer( "SQLSERVER", "./config/ConnexioBobinesSQLServer.txt", "sa",
 * "admin123" ); m_bddBobinesSQLServer.ShowInformacio( ); } else
 * m_bddBobinesSQLServer.connecta( ); return (m_bddBobinesSQLServer); }
 */

/*
 * public void DesconnectarSQLServerBobines() { if ( m_bddBobinesSQLServer !=
 * null ) { m_bddBobinesSQLServer.desconnecta( ); } }
 */
public DataAccessLayer RetornaConnexioMySQLControlPlantaTraspassades()
{
	if ( m_bddControlPlantaTraspassades == null )
	{
		System.out.println( "m_bddControlPlantaTraspassades �s NULL" );
		m_bddControlPlantaTraspassades = new DataAccessLayer( "MYSQL", "./config/ConnexioControlPlantaTraspassades.txt", "root", "lpc1232001" );
		m_bddControlPlantaTraspassades.ShowInformacio( );
	}
	else
	{
		System.out.println( "m_bddControlPlantaTraspassades �s diferent de NULL esta connectat: " + m_bddControlPlantaTraspassades.estaConnectat( ) );
		if ( !m_bddControlPlantaTraspassades.estaConnectat( ) )
			m_bddControlPlantaTraspassades.connecta( );
	}
	return (m_bddControlPlantaTraspassades);
}

public void DesconnectarConnexioMySQLControlPlantaTraspassades()
{
	if ( m_bddControlPlantaTraspassades != null )
	{
		m_bddControlPlantaTraspassades.desconnecta( );
	}
}

public void ConnectarConnexioMySQLControlPlantaTraspassades()
{
	if ( m_bddControlPlantaTraspassades != null )
	{
		m_bddControlPlantaTraspassades.connecta( );
	}
}
}