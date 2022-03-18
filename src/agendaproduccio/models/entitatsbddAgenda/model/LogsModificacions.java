package agendaproduccio.models.entitatsbddAgenda.model;

import java.util.Calendar;

import agendaproduccio.utils.DataHora;

public class LogsModificacions {
	public int m_id;
	public int m_uI_Id_Lin_Ordre_P_Navision;
	public String m_nI_Num_Orden_Produccion;
	public String m_usuari;
	public String m_valor_Antic;
	public String m_valor_Nou;
	public String m_descripcio;
	public Calendar m_data;
	public int m_numTiratge;
	public String m_nomCamp;
	public boolean m_validatPreimpressio;
	public boolean m_repasInformacio;
	private DataHora m_dh = DataHora.getInstance();

	public LogsModificacions() {
		this.SetDefault();
	}

	public void SetDefault() {
		m_id = 0;
		m_uI_Id_Lin_Ordre_P_Navision = 0;
		m_nI_Num_Orden_Produccion = "";
		m_usuari = "";
		m_valor_Antic = "";
		m_valor_Nou = "";
		m_descripcio = "";
		m_data = null;
		m_numTiratge = 0;
		m_nomCamp = "";
		m_validatPreimpressio = false;
		m_repasInformacio = false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("<hr>");
		builder.append("<div><font>");
		builder.append("<b>Nom camp: </b>");
		builder.append(m_nomCamp);
		builder.append("<br>");
		builder.append("<b> Data: </b>");
		builder.append(m_data.getTime());
		builder.append("<br>");
		builder.append(" <b>Usuari: </b>");
		builder.append(m_usuari);
		builder.append("<br>");
		builder.append("<b>Antic </b>");
		builder.append(m_valor_Antic);
		builder.append("  <b>Nou: </b>");
		builder.append(m_valor_Nou);
		builder.append("<br>");
		builder.append("<b>Descripcio: </b>");
		builder.append("<br>");
		builder.append(m_descripcio);
		builder.append("</font></div>");
		builder.append("<hr>");
		builder.append("\n");
		return builder.toString();
	}

	public boolean esModfGlobal() {
		return m_uI_Id_Lin_Ordre_P_Navision == 0;
	}

	public int getNumTiratge() {
		return this.m_numTiratge;
	}

	public int getIdLinia() {
		return this.m_uI_Id_Lin_Ordre_P_Navision;
	}

}
