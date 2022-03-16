package agendaproduccio.models.fitxatecnica.model;

public class LiniaProduccioFitxaTecnica implements Comparable<LiniaProduccioFitxaTecnica> {
	public int m_idTiratge;
	public String m_tipusTiratge;
	public String m_planesReals;
	public String m_midaPagina;
	public String m_format;
	public String m_plegat;
	public String m_maquina;
	public String m_plegatKomori;
	public String m_planesTiratge;
	public String m_pestanya;
	public String m_quantitat;
	public String m_bonsAfegir;
	public String m_psf;
	public String m_tipusPaperSencera;
	public String m_marcaPaperSencera;
	public String m_tipusPaperMitja;
	public String m_marcaPaperMitja;
	public String m_guillotina;
	public String m_desencartar;
	public String m_tallEnLinia;
	public String m_encolatEnLinia;
	public String m_alcar;
	public String m_codiGrupProducto;
	public String m_descripcio;
	public String m_codiPR;
	public String m_lanImpressioExterior;
	public String m_midaPestanya;
	public String m_tipusProducteMaquinaFulla;
	public String m_midaFullaMaquinaFulla;
	public int m_exemplarsPerFullaMaquinaFulla;
	public String m_acabat1MaquinaFulla;
	public String m_acabat2MaquinaFulla;
	public String m_acabat3MaquinaFulla;
	public String m_pantone1MaquinaFulla;
	public String m_pantone2MaquinaFulla;
	public String m_codiPaperMaquinaFulla;
	public String m_marcaPaperMaquinaFulla;
	public String m_caraODorsMaquinaFulla;
	public String m_qualitatPaperMaquinaFulla;
	public String m_gramatgePaperMaquinaFulla;
	public String m_numeroCaraODorsMaquinaFulla;
	public String m_nomFeinaMaquinaFulla;
	public String m_canviPlanxaOPlegat;
	public String m_tramaFilmacio;
	public String m_planesColor;
	public String m_distribucioColor;
	//public boolean m_visualitzar;
	public int m_numLinia;

	public String m_grmPaperBobinaSencera;
	public String m_amplePaperBobinaSencera;
	public String m_grmPaperMitjaBobina;
	public String m_amplePaperMitjaBobina;

	public LiniaProduccioFitxaTecnica() {
		this.SetDefault();
	}

	public void SetDefault() {
		m_idTiratge = 0;
		m_tipusTiratge = "";
		m_planesReals = "";
		m_midaPagina = "";
		m_format = "";
		m_plegat = "";
		m_maquina = "";
		m_plegatKomori = "";
		m_planesTiratge = "";
		m_pestanya = "";
		m_quantitat = "";
		m_bonsAfegir = "";
		m_psf = "";
		m_tipusPaperSencera = "";
		m_marcaPaperSencera = "";
		m_tipusPaperMitja = "";
		m_marcaPaperMitja = "";
		m_guillotina = "";
		m_desencartar = "";
		m_tallEnLinia = "";
		m_encolatEnLinia = "";
		m_alcar = "";
		m_codiGrupProducto = "";
		m_descripcio = "";
		m_codiPR = "";
		m_lanImpressioExterior = "";
		m_midaPestanya = "";
		m_tipusProducteMaquinaFulla = "";
		m_midaFullaMaquinaFulla = "";
		m_exemplarsPerFullaMaquinaFulla = 0;
		m_acabat1MaquinaFulla = "";
		m_acabat2MaquinaFulla = "";
		m_acabat3MaquinaFulla = "";
		m_pantone1MaquinaFulla = "";
		m_pantone2MaquinaFulla = "";
		m_codiPaperMaquinaFulla = "";
		m_marcaPaperMaquinaFulla = "";
		m_caraODorsMaquinaFulla = "";
		m_qualitatPaperMaquinaFulla = "";
		m_gramatgePaperMaquinaFulla = "";
		m_numeroCaraODorsMaquinaFulla = "";
		m_nomFeinaMaquinaFulla = "";
		m_canviPlanxaOPlegat = "";
		m_tramaFilmacio = "";
		m_planesColor = "";
		m_distribucioColor = "";
		// m_visualitzar = true;
		m_numLinia = 0;
		m_grmPaperBobinaSencera = "";
		m_amplePaperBobinaSencera = "";
		m_grmPaperMitjaBobina = "";
		m_amplePaperMitjaBobina = "";

	}

	public boolean EsMaquinaPlana() {
		return (m_maquina != null && m_maquina.toLowerCase().indexOf("heide") != -1);
	}

	@Override
	public int compareTo(LiniaProduccioFitxaTecnica p_linia) {
		if (this.m_idTiratge == p_linia.m_idTiratge) {
			if (this.m_numLinia > p_linia.m_numLinia) {
				return 1;
			} else if (this.m_numLinia < p_linia.m_numLinia) {
				return -1;
			} else {
				return 0;
			}
		} else {
			if (this.m_idTiratge == 0) {
				return -1;
			} else if (p_linia.m_idTiratge == 0) {
				return 1;
			} else if (this.m_idTiratge > p_linia.m_idTiratge) {
				return 1;
			} else if (this.m_idTiratge < p_linia.m_idTiratge) {
				return -1;
			}
		}

		return 0;
	}

	public String RetornaQuantitatAImprimir() {

		String l_quantitat = "";
		int l_quant = ((int) (Double.parseDouble(m_quantitat))) + Integer.parseInt(m_bonsAfegir);
		if (EsMaquinaPlana()) {
			l_quantitat = l_quant + " ex. (" + ((int) ((double) l_quant / m_exemplarsPerFullaMaquinaFulla)) + " f.)";
		} else {
			l_quantitat = l_quant + " ex.";
		}
		return (l_quantitat);
	}

	public String RetornaPerSiFalten() {
		String l_quantitat = "";
		if (EsMaquinaPlana()) {
			l_quantitat = m_psf + " ex. ("
					+ ((int) ((double) Integer.parseInt(m_psf) / m_exemplarsPerFullaMaquinaFulla)) + " f.)";
		} else {
			l_quantitat = m_psf + " ex.";
		}
		return (l_quantitat);
	}

	public String retornaDescripcioPaperBobinaSencera() {
		String codi = "";
		if (m_maquina.indexOf("HEIDELB") >= 0) {
			if (m_qualitatPaperMaquinaFulla.equals("ES"))
				codi = "ESM" + ((int) Double.parseDouble(m_gramatgePaperMaquinaFulla)) + "_" + m_midaFullaMaquinaFulla;// +"
																														// "+m_marcaPaperMaquinaFulla;
			else
				codi = m_qualitatPaperMaquinaFulla + "" + ((int) Double.parseDouble(m_gramatgePaperMaquinaFulla)) + "_"
						+ m_midaFullaMaquinaFulla;// +" "+m_marcaPaperMaquinaFulla;
		} else {
			try {
				if ((m_grmPaperBobinaSencera.equals("")) || (Double.parseDouble(m_grmPaperBobinaSencera) == 0.0))
					codi = "";
				else {
					String gr = "";
					String cm = "";
					if (m_grmPaperBobinaSencera.indexOf(".0") != -1)
						gr = m_grmPaperBobinaSencera.substring(0, m_grmPaperBobinaSencera.indexOf("."));
					else
						gr = m_grmPaperBobinaSencera;
					if (m_amplePaperBobinaSencera.indexOf(".0") != -1)
						cm = m_amplePaperBobinaSencera.substring(0, m_amplePaperBobinaSencera.indexOf("."));
					else
						cm = m_amplePaperBobinaSencera;
					codi = m_tipusPaperSencera + "_" + gr + "/" + cm;// +"_"+m_marcaPaperSencera;
				}
			} catch (Exception ex) {
				codi = "";
			}
		}
		return (codi);
	}

	public String retornaDescripcioPaperMitjaBobina() {
		String codi = "";
		try {
			if ((m_grmPaperMitjaBobina.equals("")) || (Double.parseDouble(m_grmPaperMitjaBobina) == 0.0))
				codi = "";
			else {
				String gr = "";
				String cm = "";
				if (m_grmPaperMitjaBobina.indexOf(".0") != -1)
					gr = m_grmPaperMitjaBobina.substring(0, m_grmPaperMitjaBobina.indexOf("."));
				else
					gr = m_grmPaperMitjaBobina;
				if (m_amplePaperMitjaBobina.indexOf(".0") != -1)
					cm = m_amplePaperMitjaBobina.substring(0, m_amplePaperMitjaBobina.indexOf("."));
				else
					cm = m_amplePaperMitjaBobina;
				codi = m_tipusPaperMitja + "_" + gr + "/" + cm;// +"_"+m_marcaPaperMitja;
			}
		} catch (Exception ex) {
			codi = "";
		}
		return (codi);
	}

	public String retornaPantones() {
		String l_pantones = "";
		if (!m_pantone1MaquinaFulla.equals(""))
			l_pantones = m_pantone1MaquinaFulla;
		if (!m_pantone2MaquinaFulla.equals(""))
			l_pantones = l_pantones.equals("") ? m_pantone2MaquinaFulla : l_pantones + ", " + m_pantone2MaquinaFulla;
		return (l_pantones);
	}

	public String retornaAcabats() {
		String l_acabats = "";
		if (!m_acabat1MaquinaFulla.equals(""))
			l_acabats = m_acabat1MaquinaFulla;
		if (!m_acabat2MaquinaFulla.equals(""))
			l_acabats = l_acabats.equals("") ? m_acabat2MaquinaFulla : l_acabats + ", " + m_acabat2MaquinaFulla;
		if (!m_acabat3MaquinaFulla.equals(""))
			l_acabats = l_acabats.equals("") ? m_acabat3MaquinaFulla : l_acabats + ", " + m_acabat3MaquinaFulla;
		return (l_acabats);
	}

}