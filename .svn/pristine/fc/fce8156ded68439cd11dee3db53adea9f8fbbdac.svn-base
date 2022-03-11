package connexioBDD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

public class LogFile {
	private String m_nomFitxer;
	private String m_error;

	private File m_file;
	private Writer output;

	public LogFile(String p_nomFitxer) {
		m_nomFitxer = p_nomFitxer;
	}

	public void write(String p_origen, String p_error) {
		try {
			m_file = new File(m_nomFitxer);
			output = new BufferedWriter(new FileWriter(m_file, true));

			m_error = p_origen + "-" + (new Date()).toString();
			m_error += "\r\n\t" + p_error;

			output.write(m_error);
			output.write("\r\n");
			output.close();

			System.out.println("LOGFILE: " + m_error);
			output = null;
			m_file = null;
		} catch (Exception ex) {
			System.out.println("Ha Fallat el log de Simultaneitat TA!!!" + ex);
		}
	}
	
   public void escriure(String texte)
   	{
		try {
			m_file = new File(m_nomFitxer);
			output = new BufferedWriter(new FileWriter(m_file, true));
			output.write(texte);
			output.close();
			output = null;
			m_file = null;
		} catch (Exception ex) {
			System.out.println("Ha Fallat el log de Simultaneitat TA!!!" + ex);
		}
	   
   	}
   
   public void escriureln(String texte)
  	{
		try {
			m_file = new File(m_nomFitxer);
			output = new BufferedWriter(new FileWriter(m_file, true));

			output.write(texte);
			output.write("\r\n");
			output.close();
			output = null;
			m_file = null;
		} catch (Exception ex) {
			System.out.println("Ha Fallat el log de Simultaneitat TA!!!" + ex);
		}
	   
  	}
   
}