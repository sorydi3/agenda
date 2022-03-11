package connexioBDD;

// Classe per gestionar la connexi� amb la Bdd
// Modernitzaci� del Base de Dades.

import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

//import java.util.*;

public class DataAccessLayer
{
private Connection m_conn;
private Statement m_stmt;
private ResultSet m_rs;
private String m_path;

private String m_tipusConnexio, m_host, m_port, m_bdd, m_user, m_pass;
private int m_resultatOperacio, m_numeroFiles, m_numeroCamps;

private String m_retorna[][];
private String m_retorna1Camp[];

private LogFile m_logError;

// ---- M�todes de Connexi�
public DataAccessLayer(String p_tipusConnexio, String p_host, String p_port, String p_bdd, String p_user, String p_pass, LogFile p_logError)
{
	m_host = p_host;
	m_port = p_port;
	m_bdd = p_bdd;
	m_user = p_user;
	m_pass = p_pass;
	m_tipusConnexio = p_tipusConnexio;
	m_logError = p_logError;
	m_resultatOperacio = 0;
	m_path = "";
	this.connecta( );
}

public DataAccessLayer(String p_tipusConnexio, String p_host, String p_port, String p_bdd, String p_user, String p_pass)
{
	m_host = p_host;
	m_port = p_port;
	m_bdd = p_bdd;
	m_user = p_user;
	m_pass = p_pass;
	m_tipusConnexio = p_tipusConnexio;
	m_logError = new LogFile( "./DAL_log.txt" );
	m_resultatOperacio = 0;
	m_path = "";
	this.connecta( );
}

public void ShowInformacio()
{
	System.out.println( m_host + " - " + m_bdd + " - " + m_path );
}

public DataAccessLayer(String p_tipusConnexio, String p_path, String p_user, String p_pass)
{
	try
	{
		if ( p_tipusConnexio.equals( "ODBC" ) )
		{
			RandomAccessFile l_fd = new RandomAccessFile( p_path, "r" );
			m_host = l_fd.readLine( );
			l_fd.close( );
			m_tipusConnexio = p_tipusConnexio;
			m_logError = new LogFile( "./DAL_log.txt" );
			m_resultatOperacio = 0;
			m_path = p_path;
			this.connecta( );
		}
		else
		{
			RandomAccessFile l_fd = new RandomAccessFile( p_path, "r" );
			m_host = l_fd.readLine( );
			m_port = l_fd.readLine( );
			m_bdd = l_fd.readLine( );
			l_fd.close( );
			l_fd = null;

			m_user = p_user;
			m_pass = p_pass;
			m_path = p_path;

			m_tipusConnexio = p_tipusConnexio;
			m_logError = new LogFile( "./DAL_log.txt" );
			m_resultatOperacio = 0;
			this.connecta( );
		}
	}
	catch (Exception e)
	{
		System.out.println( "ERROR: " + e );
	}
}

public void connecta()
{
	m_conn = null;
	m_stmt = null;
	m_rs = null;
	try
	{
		if ( m_tipusConnexio.equalsIgnoreCase( "MYSQL" ) )
		{
			Class.forName( "com.mysql.jdbc.Driver" ).newInstance( );
			m_conn = DriverManager.getConnection( "jdbc:mysql://" + m_host + ":" + m_port + "/" + m_bdd + "?noDatetimeStringSync=true", m_user, m_pass );
			m_stmt = m_conn.createStatement( );
		}
		else if ( m_tipusConnexio.equalsIgnoreCase( "SQLSERVER" ) )
		{
			Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			m_conn = DriverManager.getConnection( "" + "jdbc:sqlserver://" + m_host + ":" + m_port + ";" + "databaseName=" + m_bdd + ";user=" + m_user + ";password=" + m_pass + ";" );
			//m_conn.setAutoCommit(false);
			m_stmt = m_conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );			
		}
		else if ( m_tipusConnexio.equalsIgnoreCase( "ODBC" ) )
		{
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" ).newInstance( );
			m_conn = DriverManager.getConnection( "jdbc:odbc:" + m_host );
			m_stmt = m_conn.createStatement( );
		}
	}
	catch (SQLException sex)
	{
		System.out.println( "SQLException: " + sex.getMessage( ) );
		System.out.println( "SQLState: " + sex.getSQLState( ) );
		System.out.println( "VendorError: " + sex.getErrorCode( ) );
		m_logError.write( "GestioBdd-Connecta(" + m_tipusConnexio + ")", sex.getMessage( ) );
	}
	catch (Exception ex)
	{
		m_logError.write( "GestioBdd-Connecta(" + m_tipusConnexio + ")", ex.getMessage( ) );
	}
}

public void desconnecta()
{
	try
	{
		if ( m_conn != null )
		{
			m_conn.close( );
			m_conn = null;
		}
		if ( m_stmt != null )
		{
			m_stmt.close( );
			m_stmt = null;
		}
		if ( m_rs != null )
		{
			m_rs.close( );
			m_rs = null;
		}
	}
	catch (SQLException sex)
	{
		m_logError.write( "GestioBdd-Desconnecta(" + m_tipusConnexio + ")", sex.getMessage( ) );
	}
}

public boolean EstaConnectat()
{
	if ( m_conn != null && m_stmt != null )
	{
		return true;
	}
	else
	{
		return false;
	}
}

// --- M�todes de Gestio Bdd

public void executaSQLSET( String p_sentencia )
{
	try
	{
		m_stmt.executeQuery( p_sentencia );	
	}
	catch (SQLException sqlEx)
	{
		this.connecta( );
		try
		{
			m_stmt.executeQuery( p_sentencia );
		}
		catch (SQLException sqlEx2)
		{
			m_logError.write( "DAL (SELECT): ", sqlEx2.getMessage( ) + " ->" + p_sentencia );
		}
	}
}

public int executaSQLSELECT( String p_sentencia, int p_numeroCamps )
{
	m_resultatOperacio = 0;
	try
	{
		m_rs = m_stmt.executeQuery( p_sentencia );
	}
	catch (SQLException sqlEx)
	{
		this.connecta( );
		try
		{
			m_rs = m_stmt.executeQuery( p_sentencia );
		}
		catch (SQLException sqlEx2)
		{
			m_resultatOperacio = -1;
			m_logError.write( "GestioBdd-executaSQLSelect(" + m_tipusConnexio + ")", sqlEx2.getMessage( ) + " ->" + p_sentencia );
		}
	}
	if ( m_tipusConnexio.equals( "ODBC" ) )
	{
		m_resultatOperacio = 0;
		/*
		 * try { while (m_rs.next()) { //String supplier = m_rs.getString(1);
		 * //System.out.println("Nombre: "+ supplier ); m_resultatOperacio++; } } catch
		 * (Exception e) { System.out.println("Petada: "+e); }
		 */
		System.out.println( "Fi llistem" );
	}
	else
	{
		// Determinem el n�mero de registres retornats
		if ( m_resultatOperacio == 0 )
		{
			try
			{
				if ( m_rs.last( ) )
				{
					m_resultatOperacio = m_rs.getRow( );
				}
			}
			catch (SQLException sqlEx3)
			{
				System.out.println( "Petada del numero de registres a la select" );
			}
		}
	}

	m_numeroFiles = m_resultatOperacio;
	m_numeroCamps = p_numeroCamps;
	return m_resultatOperacio;
}

/**
 * M�TODE: M�tode perfeccionat de les Select en qu� no cal especificar el n�mero
 * de camp que t� la Select
 */
public int executaSQLSELECT( String p_sentencia )
{
	m_resultatOperacio = 0;
	// System.out.println("m_rs: "+m_rs);
	try
	{
		m_rs = m_stmt.executeQuery( p_sentencia );	
	}
	catch (SQLException sqlEx)
	{
		this.connecta( );
		try
		{
			m_rs = m_stmt.executeQuery( p_sentencia );
		}
		catch (SQLException sqlEx2)
		{
			m_resultatOperacio = -1;
			m_logError.write( "DAL (SELECT): ", sqlEx2.getMessage( ) + " ->" + p_sentencia );
		}
	}

	// Determinem el n�mero de registres retornats
	if ( m_resultatOperacio == 0 )
	{
		try
		{
			if ( m_rs.last( ) )
			{
				m_resultatOperacio = m_rs.getRow( );
				m_numeroCamps = m_rs.getMetaData( ).getColumnCount( );
			}
		}
		catch (SQLException sqlEx3)
		{
			m_logError.write( "DAL (SELECT - N�mero Registres ): ", sqlEx3.getMessage( ) + " ->" + p_sentencia );
		}
	}

	m_numeroFiles = m_resultatOperacio;
	return m_resultatOperacio;
}

public Vector recuperaSQLSelectNavision()
{
	Vector llRegistres = new Vector( 1, 1 );
	try
	{
		while (m_rs.next( ))
		{
			String resultat[] = new String[ m_numeroCamps ];
			for ( int i = 0; i < m_numeroCamps; i++ )
			{
				String valor = m_rs.getString( i + 1 );
				if ( valor == null )
					valor = "";
				resultat[i] = valor;
			}
			llRegistres.add( resultat );
		}
		// System.out.println("Nombre: "+ supplier );
	}
	catch (Exception e)
	{

	}
	return (llRegistres);
}

public String[][] recuperaSQLSelect()
{
	int f, c;
	m_retorna = null;
	m_retorna1Camp = null;
	m_retorna = new String[ 0 ][ 0 ];
	if ( m_numeroFiles <= 0 )
	{
		return m_retorna;
	}
	m_retorna = null;
	m_retorna = new String[ m_numeroFiles ][ m_numeroCamps ];
	try
	{
		m_rs.first( );
		f = 0;
		while (f < m_numeroFiles)
		{
			c = 0;
			while (c < m_numeroCamps)
			{
				try
				{
					m_retorna[f][c] = m_rs.getString( c + 1 );
					// System.out.println("Nom "+(c+1)+": "+m_rs.getString(c + 1));
				}
				catch (SQLException sqlEx)
				{
					m_retorna[f][c] = null;
				}
				c++;
			}
			m_rs.next( );
			f++;
		}
		m_rs.close( );
	}
	catch (Exception sex)
	{
	}
	m_rs = null;
	return m_retorna;
}

public int recuperaNumeroFiles()
{
	return m_numeroFiles;
}

public String[] recuperaSQLSelect1Camp()
{
	int f;
	m_retorna = null;
	m_retorna1Camp = null;
	if ( m_numeroFiles <= 0 )
	{
		return null;
	}
	m_retorna1Camp = new String[ m_numeroFiles ];
	try
	{
		m_rs.first( );
		f = 0;
		while (f < m_numeroFiles)
		{
			try
			{
				m_retorna1Camp[f] = m_rs.getString( 1 );
			}
			catch (SQLException sqlEx)
			{
				m_retorna1Camp[f] = null;
			}
			m_rs.next( );
			f++;
		}
		m_rs.close( );
	}
	catch (Exception sex)
	{
	}
	m_rs = null;
	return m_retorna1Camp;
}

public double recuperaSQLSelectDouble()
{
	try
	{
		m_rs.first( );
		return m_rs.getDouble( 1 );
	}
	catch (SQLException sqlEx)
	{
		return 0;
	}
}

public int executaSQLINSERT( String p_sentencia )
{
	try
	{
		m_stmt.executeUpdate( p_sentencia, Statement.RETURN_GENERATED_KEYS );
		m_rs = m_stmt.getGeneratedKeys( );
		if ( m_rs.next( ) )
		{
			m_resultatOperacio = m_rs.getInt( 1 );
		}
		else
		{
			m_resultatOperacio = -1;
		}
	}
	catch (SQLException sqlEx)
	{

		this.connecta( );
		try
		{
			m_stmt.executeUpdate( p_sentencia, Statement.RETURN_GENERATED_KEYS );
			m_stmt.getGeneratedKeys( );
			if ( m_rs.next( ) )
			{
				m_resultatOperacio = m_rs.getInt( 1 );
			}
			else
			{
				m_resultatOperacio = -1;
			}
		}
		catch (SQLException sqlEx2)
		{
			m_resultatOperacio = -1;
			m_logError.write( "GestioBdd- INSERT(" + m_tipusConnexio + ")", sqlEx + " -> " + p_sentencia );
		}
	}

	return m_resultatOperacio;
}

public int executaSQLDELETE( String p_sentencia )
{
	return this.executaSQL( "executaSQLDelete", p_sentencia );
}

public int executaSQLUPDATE( String p_sentencia )
{
	return this.executaSQL( "executaSQLUpdate", p_sentencia );
}

private int executaSQL( String p_origen, String p_sentencia )
{
	m_resultatOperacio = 0;
	try
	{
		m_stmt.executeUpdate( p_sentencia, Statement.RETURN_GENERATED_KEYS );
	}
	catch (SQLException sqlEx)
	{
		this.connecta( );
		try
		{
			m_stmt.executeUpdate( p_sentencia );
		}
		catch (SQLException sqlEx2)
		{
			m_resultatOperacio = -1;
			m_logError.write( "GestioBdd-" + p_origen + "(" + m_tipusConnexio + ")", sqlEx + " -> " + p_sentencia );
		}
	}
	return m_resultatOperacio;
}

// M�tode que es retorna la connexi� per poder-la utiltizar amb l'iReport
public Connection getConnection()
{
	if ( m_conn == null )
	{
		this.connecta( );
	}
	return m_conn;
}

public boolean estaConnectat()
{
	if ( m_conn == null )
		return (false);
	else
		return (true);
}

public String PrepararStringPerBaseDeDades( String ent )
{
	String sort = "";
	if ( ent != null )
	{
		sort = ent.replace( "\\", "/" );
		// sort=sort.replaceAll("\'","\\\\'"); // Funciona per MySQL, per� no per
		// SQLServer
		sort = sort.replaceAll( "\'", "''" );// En teoria funciona per MySQL i per SQLServer
	}

	return (sort);
}

public String ObtenirNomBaseDeDades()
{
	return ""+m_bdd;
}

}
