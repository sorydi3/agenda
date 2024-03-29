package agendaproduccio.models.entitatsbddAgenda.dao;

public class Sentencias {

	public static String buildSentenciaJoinSELECT(String p_columnes, String l_strDini, String l_strDfin,
			boolean m_filterByDate) {
		// TAULAS
		String taula_lin_ordre_p_navision = "lin_ordre_p_navision l";
		String taula_rutes_ordre_p_navision = "rutes_ordre_p_navision r";
		String taula_ordre_p_navision = "ordre_p_navision o";
		String taula_ordre_comanda = "gestio_comandes c";

		//// ----------------------------------------------------

		String compare_taula_l_and_r = "l.UI_Id_Lin_Ordre_P_Navision = r.UI_Id_Lin_Ordre_P_Navision";
		String compare_taula_l_and_o = "o.NI_Num_Orden_Produccion = l.NI_Num_Orden_Produccion";
		String compare_taula_o_and_c = "o.NI_Num_Orden_Produccion = c.LAN";
		String ordering = "o.NI_Num_Orden_Produccion";
		String l_sentencia = "";
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT ").append(p_columnes).append(" FROM ").append(taula_lin_ordre_p_navision)
				.append(" LEFT JOIN ").append(taula_rutes_ordre_p_navision).append(" ON ").append(compare_taula_l_and_r) //
				.append(" LEFT JOIN ").append(taula_ordre_p_navision).append(" ON ").append(compare_taula_l_and_o) //
				.append(" LEFT JOIN ").append(taula_ordre_comanda).append(" ON ").append(compare_taula_o_and_c)
				.append(" WHERE ").append(condicions(l_strDini, l_strDfin, m_filterByDate)).append(" ORDER BY ")
				.append(ordering).append(" ASC");
		l_sentencia = builder.toString();
		return l_sentencia;
	}

	private static String condicions(String p_data_inici, String p_data_final, boolean m_filterByDate) {
		String condicion1 = "o.Terminada_Anna=0";
		String nom_columna_dataInteriors = "o.DataPrevistaInterior";
		String nom_columna_dataCoberters = "o.DataPrevistaCobertes";
		StringBuilder l_builder = new StringBuilder();
		l_builder.append(condicion1);
		if (m_filterByDate) {
			l_builder.append(" AND ( ");
			l_builder.append(condicioColumnaDataInterval(nom_columna_dataInteriors, p_data_inici, p_data_final));
			l_builder.append(" OR ");
			l_builder.append(condicioColumnaDataInterval(nom_columna_dataCoberters, p_data_inici, p_data_final));
			l_builder.append(" ) ");
		}
		return l_builder.toString();
	}

	public static String condicioColumnaDataInterval(String nomColumna, String p_data_inici, String p_data_final) {
		String l_data = " DATE(" + nomColumna + ") ";
		StringBuilder l_builder = new StringBuilder();
		l_builder.append("(");
		l_builder.append(nomColumna + " IS NOT NULL ");
		l_builder.append(" AND ").append(l_data).append(" >= ").append(formatStringToMySqlDate(p_data_inici))
				.append(" AND ").append(l_data).append(" <= ").append(formatStringToMySqlDate(p_data_final));
		l_builder.append(")");
		return l_builder.toString();
	}

	public static String condicioColumnaData(String nomColumna, String p_data_inici, String p_data_final) {
		String l_data = " DATE(" + nomColumna + ") ";
		StringBuilder l_builder = new StringBuilder();
		l_builder.append("(");
		l_builder.append(nomColumna + " IS NOT NULL ");
		l_builder.append(" AND ").append(l_data).append(" >= ").append(formatStringToMySqlDate(p_data_inici))
				.append(" AND ").append(l_data).append(" <= ").append(formatStringToMySqlDate(p_data_final));
		l_builder.append(")");
		return l_builder.toString();
	}

	public static String formatStringToMySqlDate(String date) {
		StringBuilder l_builder = new StringBuilder();
		l_builder.append("str_to_date('").append(date).append("','%d-%m-%Y') ");
		return l_builder.toString();
	}

	public static String BuildSelectLogs(String l_sentencia) {
		StringBuilder l_builder = new StringBuilder();
		String l_condicions = "  WHERE (NomCamp='Enquadernat' or NomCamp='Mida P�gina' or NomCamp like "
				+ "'Paper %' or NomCamp like 'Ampla%' or NomCamp='Distribuci� Tiratges' or "
				+ "NomCamp='Planes Publicaci�')";

		l_builder.append("SELECT ").append(l_sentencia).append(" FROM logs_modificacions ").append(l_condicions)
				.append(" ORDER BY").append(" Data desc");
		return l_builder.toString();
	}
}
