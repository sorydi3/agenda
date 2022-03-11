package agendaproduccio.models.entitatsbddAgenda.daos;

public class Sentencias {

	public static String buildSentenciaJoinSELECT(String p_columnes, String l_strDini, String l_strDfin) {
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
				.append(" WHERE ").append(condicions(l_strDini, l_strDfin)).append(" ORDER BY ").append(ordering)
				.append(" ASC");
		l_sentencia = builder.toString();
		return l_sentencia;
	}

	private static String condicions(String p_data_inici, String p_data_final) {
		String condicion1 = "o.Terminada_Anna=0";
		// String nom_columna_data = "o.NI_Data_Prevista_Original";
		StringBuilder l_builder = new StringBuilder();
		l_builder.append(condicion1);
//		.append(" AND ")
//		.append(nom_columna_data)
//		.append(" BETWEEN ")
//		.append("'")
//		.append(p_data_inici)
//		.append("'")
//		.append(" AND ")
//		.append("'")
//		.append(p_data_final)
//		.append("'");
		return l_builder.toString();
	}
}
