package agendaproduccio.models.entitatsbddAgenda.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderLiniaRutaPNavison {
	public enum Tipus {
		IMPRESSIO, RCTP, ENCART, GUILL, TDIGITAL, ALC, IMPREVISTOS, FLEJAR, RECOLL, ALTRES, EXTERIOR, MAE, DSE
	}

	// ----- COLUMNES ORDER_P_NAVISION
	private List<LogsModificacions> m_modfLinia;

	public String m_nI_Num_Orden_Produccion_o;
	public String m_nI_Descripcion_2_o;
	public String m_nI_Data_Prevista_Original_o;
	public String m_nI_Hora_Prevista_Original_o;
	public String m_nI_Ample_Bobina_o;
	public boolean m_terminada_Navision_o;
	public String m_uI_Estado_CP_o;
	public boolean m_nM_Repas_Informacio_o;
	public boolean m_numComandes_o;
	public boolean m_signada_o;
	public String m_nI_Data_Prevista_Cobertes_o;
	public String m_nI_Hora_Prevista_Cobertes_o;

	// ----- COLUMNES TAULA RUTA_ORDER_P_NAVISION

	public String m_uI_Estado_r;
	public String m_NI_Num_Centro_Trabajo_r;

	// ----- COLUMNES TAULA LINIA_ORDER_P_NAVISION
	public int m_IdLinia_l;
	public String m_nI_Num_Orden_Produccion_l;
	public int m_nI_Identificador_Tiratge_l;
	public String m_nI_Cantidad_l;
	public String m_nI_No_Planes_Totals_Tiratge_l;
	public String m_nI_Format_Tiratge_l;
	public String m_nI_Plegat_Tiratge_l;
	public String m_nI_Nom_Maquina_l;
	public String m_nI_Codi_Grup_Producto_l;
	public boolean m_planificat_l;
	public int m_uI_Id_Lin_Ordre_P_Navision_l;
	public boolean m_planificat_Manipulat_Extern_l;
	public String m_dataEntregaManipuladorExtern_l;
	public String m_nI_Tipus_Papel_Bobina_Entera_1_l;
	public String m_nI_Tipus_Papel_Bobina_Entera_2_l;
	public String m_nI_Tipus_Papel_Bobina_Entera_3_l;
	public String m_qualitatPaperMaquinaFulla_l;
	public String m_CaraODorsMaquinaFulla_l;
	public String m_GramatgePaperMaquinaFulla_l;
	public String m_tipusProducteMaquinaFulla_l;

	// COLUMNES TAULA COMANDES
	public int m_idComanda_c;
	public String m_Path_c;

	private Tipus m_tipus;
	private String m_ctp, m_imp, m_enc, m_alc, m_dse, m_mae, m_gll;
	// public String

	public OrderLiniaRutaPNavison() {
		this.setDefault();
	}

	public OrderLiniaRutaPNavison(Tipus p_tipus, String p_ordentProduccio) {
		this.setDefault();
		this.m_tipus = p_tipus;
		this.m_nI_Num_Orden_Produccion_o = p_ordentProduccio;
	}

	public String getNLogs() {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<b>");
		builder.append(m_nI_Descripcion_2_o);
		builder.append("</b>");
		int n = 3;
		if (m_modfLinia.size() > n) {
			for (int i = 0; i < n; i++) {
				builder.append(m_modfLinia.get(i));
			}
		} else {
			m_modfLinia.forEach((log) -> builder.append(log));
		}
		builder.append("</html>");
		return builder.toString();
	}

	public void setDefault() {
		// COLUMNES TAULA ORDER_P_NAVISION
		m_modfLinia = new ArrayList<>();
		m_nI_Num_Orden_Produccion_o = "";
		m_nI_Descripcion_2_o = "";
		m_nI_Data_Prevista_Original_o = "";
		m_nI_Hora_Prevista_Original_o = "";
		m_nI_Ample_Bobina_o = "";
		m_terminada_Navision_o = false;
		m_uI_Estado_CP_o = "";
		m_nM_Repas_Informacio_o = false;
		m_numComandes_o = false;
		m_signada_o = false;
		m_nI_Data_Prevista_Cobertes_o = "";
		m_nI_Hora_Prevista_Cobertes_o = "";

		// ----- COLUMNES TAULA RUTA_ORDER_P_NAVISION

		m_uI_Estado_r = "";

		// ----- COLUMNES TAULA LINIA_ORDER_P_NAVISION
		m_nI_Num_Orden_Produccion_l = "";
		m_nI_Identificador_Tiratge_l = 0;
		m_nI_Cantidad_l = "";
		m_nI_No_Planes_Totals_Tiratge_l = "";
		m_nI_Format_Tiratge_l = "";
		m_nI_Plegat_Tiratge_l = "";
		m_nI_Nom_Maquina_l = "";
		m_nI_Codi_Grup_Producto_l = "";
		m_planificat_l = false;
		m_uI_Id_Lin_Ordre_P_Navision_l = 0;
		m_dataEntregaManipuladorExtern_l = "";
		m_planificat_Manipulat_Extern_l = false;
		m_nI_Tipus_Papel_Bobina_Entera_1_l = "";
		m_nI_Tipus_Papel_Bobina_Entera_2_l = "";
		m_nI_Tipus_Papel_Bobina_Entera_3_l = "";
		m_qualitatPaperMaquinaFulla_l = "";
		m_NI_Num_Centro_Trabajo_r = "";
		m_CaraODorsMaquinaFulla_l = "";
		m_GramatgePaperMaquinaFulla_l = "";
		m_tipusProducteMaquinaFulla_l = "";

		// COLUMNES TAULA COMANDES
		m_idComanda_c = 0;
		m_Path_c = "";

		// ------- -------

		m_ctp = "";
		m_imp = "";
		m_enc = "";
		m_alc = "";
		m_dse = "";
		m_mae = "";
		m_gll = "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(m_nI_Num_Orden_Produccion_o, m_tipus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof OrderLiniaRutaPNavison))
			return false;
		OrderLiniaRutaPNavison other = (OrderLiniaRutaPNavison) obj;
		return other.m_tipus == this.m_tipus && m_nI_Num_Orden_Produccion_o.equals(other.m_nI_Num_Orden_Produccion_o);

	}

	public void setTipus() {
		switch (this.m_nI_Codi_Grup_Producto_l) {
		case "PR-SUB.IM":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-FLEJAR":
			this.m_tipus = Tipus.FLEJAR;
			break;
		case "PR-TDIG":
			this.m_tipus = Tipus.TDIGITAL;
			break;
		case "PR-AR.AL":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-IMPREV":
			this.m_tipus = Tipus.IMPREVISTOS;
			break;
		case "PR-RCTP":
			this.m_tipus = Tipus.RCTP;
			break;
		case "PR-AL�":
			this.m_tipus = Tipus.ALC;
			break;
		case "PR-AR.IM":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-RECOLL":
			this.m_tipus = Tipus.RECOLL;
			break;
		case "PR-IMPR":
			this.m_tipus = Tipus.IMPRESSIO;
			break;
		case "PR-SUB.MAN":
			this.m_tipus = Tipus.MAE;
			break;
		case "PR-PREP.BO":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-GUILL":
			this.m_tipus = Tipus.GUILL;
			break;
		case "PR-DSENC":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-MMAN":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-ENC":
			this.m_tipus = Tipus.ENCART;
			break;
		case "PR-REFDIS":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-AR.PLE":
			this.m_tipus = Tipus.ALTRES;
			break;
		case "PR-PLEGAR":
			this.m_tipus = Tipus.ALTRES;
			break;
		default:
			this.m_tipus = Tipus.ALTRES;
			break;

		}
	}

	@Override
	public String toString() {
		return "{" + " m_nI_Num_Orden_Produccion_o='" + getM_nI_Num_Orden_Produccion_o() + "'"
				+ ", m_nI_Descripcion_2_o='" + "" + "'" + ", m_nI_Data_Prevista_Original_o='"
				+ getM_nI_Data_Prevista_Original_o() + "'" + ", m_nI_Hora_Prevista_Original_o='"
				+ getM_nI_Hora_Prevista_Original_o() + "'" + ", m_nI_Ample_Bobina_o='" + "" + "'"
				+ ", m_terminada_Navision_o='" + "" + "'" + ", m_uI_Estado_CP_o='" + isLanzada() + "'"
				+ ", m_nM_Repas_Informacio_o='" + isM_nM_Repas_Informacio_o() + "'" + ", m_numComandes_o='"
				+ isComandes() + "'" + ", m_signada_o='" + isSignada() + "'" + ", m_nI_Data_Prevista_Cobertes_o='"
				+ getM_nI_Data_Prevista_Cobertes_o() + "'" + ", m_nI_Hora_Prevista_Cobertes_o='"
				+ getM_nI_Hora_Prevista_Cobertes_o() + "'" + ", m_uI_Estado_r='" + getM_uI_Estado_r() + "'"
				+ ", m_NI_Num_Centro_Trabajo_r='" + getM_NI_Num_Centro_Trabajo_r() + "'"
				+ ", m_nI_Num_Orden_Produccion_l='" + getM_nI_Num_Orden_Produccion_l() + "'"
				+ ", m_nI_Identificador_Tiratge_l='" + getM_nI_Identificador_Tiratge_l() + "'" + ", m_nI_Cantidad_l='"
				+ getM_nI_Cantidad_l() + "'" + ", m_nI_No_Planes_Totals_Tiratge_l='"
				+ getM_nI_No_Planes_Totals_Tiratge_l() + "'" + ", m_nI_Format_Tiratge_l='" + getM_nI_Format_Tiratge_l()
				+ "'" + ", m_nI_Plegat_Tiratge_l='" + getM_nI_Plegat_Tiratge_l() + "'" + ", m_nI_Nom_Maquina_l='"
				+ getM_nI_Nom_Maquina_l() + "'" + ", m_nI_Codi_Grup_Producto_l='" + getM_nI_Codi_Grup_Producto_l() + "'"
				+ ", m_planificat_l='" + isM_planificat_l() + "'" + ", m_uI_Id_Lin_Ordre_P_Navision_l='"
				+ getM_uI_Id_Lin_Ordre_P_Navision_l() + "'" + ", m_planificat_Manipulat_Extern_l='"
				+ isM_planificat_Manipulat_Extern_l() + "'" + ", m_dataEntregaManipuladorExtern_l='"
				+ getM_dataEntregaManipuladorExtern_l() + "'" + ", m_nI_Tipus_Papel_Bobina_Entera_1_l='"
				+ getM_nI_Tipus_Papel_Bobina_Entera_1_l() + "'" + ", m_nI_Tipus_Papel_Bobina_Entera_2_l='"
				+ getM_nI_Tipus_Papel_Bobina_Entera_2_l() + "'" + ", m_nI_Tipus_Papel_Bobina_Entera_3_l='"
				+ getM_nI_Tipus_Papel_Bobina_Entera_3_l() + "'" + ", m_qualitatPaperMaquinaFulla_l='"
				+ getM_qualitatPaperMaquinaFulla_l() + "'" + "}";
	}

	public boolean esImpressio() {
		return this.m_nI_Codi_Grup_Producto_l.equalsIgnoreCase("PR-IMPR");
	}

	public String getPaper() {
		StringBuilder l_builder = new StringBuilder();
		if (!treballExterior()) {
			if (this.matcher("KOMORI?", this.m_nI_Nom_Maquina_l) || this.matcher("KBA?", this.m_nI_Nom_Maquina_l)) {
				String l_paper = "";
				if (!this.m_nI_Tipus_Papel_Bobina_Entera_1_l.isEmpty()) {
					l_paper = this.m_nI_Tipus_Papel_Bobina_Entera_1_l;
				} else if (!this.m_nI_Tipus_Papel_Bobina_Entera_2_l.isEmpty()) {
					l_paper = this.m_nI_Tipus_Papel_Bobina_Entera_2_l;
				} else {
					l_paper = this.m_nI_Tipus_Papel_Bobina_Entera_3_l;
				}
				l_builder.append(l_paper).append("");
				String bobina = this.m_nI_Ample_Bobina_o;
				String str_aux = bobina.substring(bobina.indexOf(' '), bobina.length() - 1);
				l_builder.append(str_aux);
			} else if (this.matcher("HEIDELBERG?", this.m_nI_Nom_Maquina_l)) {
				l_builder.append(this.m_qualitatPaperMaquinaFulla_l).append("_")
						.append(this.m_GramatgePaperMaquinaFulla_l);
			}

		}
		return l_builder.toString();
	}

	public String getCTP() {
		if (m_nI_Codi_Grup_Producto_l.equalsIgnoreCase("PR-RCTP")) {
			return this.m_uI_Estado_r.substring(0, 4) + ".";
		}
		return "";

	}

	public String getIMP() {
		String l_str = "";
		if (m_nI_Codi_Grup_Producto_l.equalsIgnoreCase("PR-IMPR")) {
			l_str = this.m_uI_Estado_r.substring(0, 4) + ".";
		}

		if (treballExterior()) {
			l_str = "Ext.";
		}
		return l_str;
	}

	public String getData() {
		return treballExterior() ? "" : this.m_nI_Data_Prevista_Original_o;
	}

	public String getDataHora() {
		return !treballExterior()
				? new StringBuilder().append(this.getData()).append(" ").append(this.getMHora()).toString()
				: "";
	}

	private boolean matcher(String p_regex, String p_str) {
		Pattern l_p = Pattern.compile(p_regex);
		Matcher l_m = l_p.matcher(p_str);
		return l_m.find();
	}

	public String getMHora() {
		return m_nI_Hora_Prevista_Original_o;
	}

	public void setMHora(String m_nI_Hora_Prevista_Original_o) {
		this.m_nI_Hora_Prevista_Original_o = m_nI_Hora_Prevista_Original_o;
	}

	public String getM_uI_Estado_r() {
		return m_uI_Estado_r.substring(0, 4) + ".";
	}

	public void setM_uI_Estado_r(String m_uI_Estado_r) {
		this.m_uI_Estado_r = m_uI_Estado_r;
	}

	public int getM_nI_Identificador_Tiratge_l() {
		return m_nI_Identificador_Tiratge_l;
	}

	public String getDescription() {
		return formaHTML(this.m_nI_Descripcion_2_o);
	}

	public String formaHTML(String content) {
		StringBuilder builder = new StringBuilder();
		String l_maquina = " - ";
		if (this.m_tipusProducteMaquinaFulla_l.equals("Tiro-Retiro")) {
			if (m_CaraODorsMaquinaFulla_l.equals("Cara")) {
				l_maquina += "Tiro";
			} else {
				l_maquina += "Retiro";
			}
		} else {
			l_maquina += this.m_CaraODorsMaquinaFulla_l;
		}
		builder.append("<html>").append(content).append("<b>").append(l_maquina).append("</b>").append("</html>");
		return builder.toString();
	}

	public void setM_nI_Identificador_Tiratge_l(int m_nI_Identificador_Tiratge_l) {
		this.m_nI_Identificador_Tiratge_l = m_nI_Identificador_Tiratge_l;
	}

	public String getM_nI_Nom_Maquina_l() {
		String l_str = m_nI_Nom_Maquina_l;
		if (treballExterior()) {
			l_str = "Exterior";
		}
		return l_str;
	}

	public String getTirada() {
		BigDecimal l_bd = new BigDecimal(Double.parseDouble(this.m_nI_Cantidad_l) * 1000);
		BigDecimal str = l_bd.setScale(0, BigDecimal.ROUND_HALF_EVEN);
		return !treballExterior() ? String.valueOf((int) str.doubleValue()) : "";
	}

	public boolean treballExterior() {
		return this.matcher("CT SUB.?", m_NI_Num_Centro_Trabajo_r);
	}

	public String getM_nI_Num_Orden_Produccion_o() {
		return this.m_nI_Num_Orden_Produccion_o;
	}

	public String getM_nI_Data_Prevista_Original_o() {
		return this.m_nI_Data_Prevista_Original_o;
	}

	public String getM_nI_Hora_Prevista_Original_o() {
		return this.m_nI_Hora_Prevista_Original_o;
	}

	public void setM_nI_Ample_Bobina_o(String m_nI_Ample_Bobina_o) {
		this.m_nI_Ample_Bobina_o = m_nI_Ample_Bobina_o;
	}

	public boolean isLanzada() {
		return this.m_uI_Estado_CP_o.equalsIgnoreCase("Lanzada");
	}

	public int GetEstat() {
		if (isLanzada() && isComandes() && !isSignada()) {
			return 4;
		} else if (isLanzada()) {
			return 3;
		} else if (isComandes() && !isSignada()) {
			return 1;
		} else if (isSignada() && !isLanzada()) {
			return 2;
		}
		return 0;
	}

	public void setM_uI_Estado_CP_o(String m_uI_Estado_CP_o) {
		this.m_uI_Estado_CP_o = m_uI_Estado_CP_o;
	}

	public boolean isM_nM_Repas_Informacio_o() {
		return this.m_nM_Repas_Informacio_o;
	}

	public boolean getM_nM_Repas_Informacio_o() {
		return this.m_nM_Repas_Informacio_o;
	}

	public void setM_nM_Repas_Informacio_o(boolean m_nM_Repas_Informacio_o) {
		this.m_nM_Repas_Informacio_o = m_nM_Repas_Informacio_o;
	}

	public boolean isComandes() {
		return this.m_numComandes_o;
	}

	public boolean isSignada() {
		return this.m_signada_o;
	}

	public String getM_nI_Data_Prevista_Cobertes_o() {
		return this.m_nI_Data_Prevista_Cobertes_o;
	}

	public void setM_nI_Data_Prevista_Cobertes_o(String m_nI_Data_Prevista_Cobertes_o) {
		this.m_nI_Data_Prevista_Cobertes_o = m_nI_Data_Prevista_Cobertes_o;
	}

	public String getM_nI_Hora_Prevista_Cobertes_o() {
		return this.m_nI_Hora_Prevista_Cobertes_o;
	}

	public void setM_nI_Hora_Prevista_Cobertes_o(String m_nI_Hora_Prevista_Cobertes_o) {
		this.m_nI_Hora_Prevista_Cobertes_o = m_nI_Hora_Prevista_Cobertes_o;
	}

	public String getM_NI_Num_Centro_Trabajo_r() {
		return this.m_NI_Num_Centro_Trabajo_r;
	}

	public void setM_NI_Num_Centro_Trabajo_r(String m_NI_Num_Centro_Trabajo_r) {
		this.m_NI_Num_Centro_Trabajo_r = m_NI_Num_Centro_Trabajo_r;
	}

	public String getM_nI_Num_Orden_Produccion_l() {
		return this.m_nI_Num_Orden_Produccion_l;
	}

	public void setM_nI_Num_Orden_Produccion_l(String m_nI_Num_Orden_Produccion_l) {
		this.m_nI_Num_Orden_Produccion_l = m_nI_Num_Orden_Produccion_l;
	}

	public String getM_nI_Cantidad_l() {
		return this.m_nI_Cantidad_l;
	}

	public String getM_nI_No_Planes_Totals_Tiratge_l() {
		return !treballExterior() ? this.m_nI_No_Planes_Totals_Tiratge_l : "";
	}

	public String getM_nI_Format_Tiratge_l() {
		return this.m_nI_Format_Tiratge_l;
	}

	public String getM_nI_Plegat_Tiratge_l() {
		return !treballExterior() ? this.m_nI_Plegat_Tiratge_l : "";
	}

	public String getM_nI_Codi_Grup_Producto_l() {
		return this.m_nI_Codi_Grup_Producto_l;
	}

	public boolean isM_planificat_l() {
		return this.m_planificat_l;
	}

	public boolean getM_planificat_l() {
		return this.m_planificat_l;
	}

	public int getM_uI_Id_Lin_Ordre_P_Navision_l() {
		return this.m_uI_Id_Lin_Ordre_P_Navision_l;
	}

	public void setM_uI_Id_Lin_Ordre_P_Navision_l(int m_uI_Id_Lin_Ordre_P_Navision_l) {
		this.m_uI_Id_Lin_Ordre_P_Navision_l = m_uI_Id_Lin_Ordre_P_Navision_l;
	}

	public boolean isM_planificat_Manipulat_Extern_l() {
		return this.m_planificat_Manipulat_Extern_l;
	}

	public boolean getM_planificat_Manipulat_Extern_l() {
		return this.m_planificat_Manipulat_Extern_l;
	}

	public String getM_dataEntregaManipuladorExtern_l() {
		return this.m_dataEntregaManipuladorExtern_l;
	}

	public String getM_nI_Tipus_Papel_Bobina_Entera_1_l() {
		return this.m_nI_Tipus_Papel_Bobina_Entera_1_l;
	}

	public String getM_nI_Tipus_Papel_Bobina_Entera_2_l() {
		return this.m_nI_Tipus_Papel_Bobina_Entera_2_l;
	}

	public String getM_nI_Tipus_Papel_Bobina_Entera_3_l() {
		return this.m_nI_Tipus_Papel_Bobina_Entera_3_l;
	}

	public String getM_qualitatPaperMaquinaFulla_l() {
		return this.m_qualitatPaperMaquinaFulla_l;
	}

	public void setColumn(Tipus tipus, String m_uI_Estado_r2) {
		switch (tipus) {
		case ENCART: { // #Tiratge =0 or #Tiratge>=90
			if (this.m_nI_Identificador_Tiratge_l == 0 || this.m_nI_Identificador_Tiratge_l >= 90) {
				this.m_enc = "";
			}
		}
			break;
		case RCTP:
			this.m_ctp = m_uI_Estado_r2;
			break;

		case GUILL: // Tiratge
			this.m_gll = m_uI_Estado_r2;
			break;

		case IMPRESSIO:
			this.m_imp = this.m_uI_Estado_r;
			break;

		case MAE: { // #Tiratge == 0 or #Tiratge>=90
			this.m_mae = "Ext.";
		}
			break;

		case DSE: // Tiratge
			break;

		case ALC: { // #Tiratge == 0 or #Tiratge>=90
			this.m_alc = m_uI_Estado_r2;
		}
			break;

		default:
			break;
		}
		// IMPRESSIO,RCTP,ENCART,GUILL,TDIGITAL,ALC,IMPREVISTOS,FLEJAR,RECOLL,ALTRES,EXTERIOR,
		// MAE, DSE
	}

	public String getM_ctp() {
		return m_ctp;
	}

	public String getM_imp() {
		return m_imp.substring(0, 4) + ".";
	}

	public String getM_enc() {
		return m_enc;
	}

	public String getM_alc() {
		return m_alc;
	}

	public String getM_dse() {
		return m_dse;
	}

	public String getM_mae() {
		return m_mae;
	}

	public Tipus getM_tipus() {
		return m_tipus;
	}

	public String getM_gll() {
		// TODO Auto-generated method stub
		return this.m_gll;
	}

	public String getIdComanda() {
		return this.m_idComanda_c == 0 ? " " : "Com.";
	}

	public String getParte() {
		// TODO Auto-generated method stub
		String str = "Part.";
		return str;
	}

	public String getPathPdf() {
		return this.m_Path_c;
	}

	public int getIdLinia() {
		return this.m_IdLinia_l;
	}

	public void afegirModf(LogsModificacions modf) {
		this.m_modfLinia.add(modf);
	}
	
	
	public List<LogsModificacions> getLogs() {
		return m_modfLinia;
	}

}
