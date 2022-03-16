package agendaproduccio.models.fitxatecnica.dao;

import agendaproduccio.models.fitxatecnica.model.OrdreProduccioFitxaTecnica;
import connexioBDD.ConnexionsBdd;
import connexioBDD.DataAccessLayer;

public class OrdreProduccioFitxaTecnicaDAO {
	private static OrdreProduccioFitxaTecnicaDAO m_singleton;

	private DataAccessLayer m_bddCP;
	private LiniaProduccioFitxaTecnicaDAO m_liniaProduccioDAO;

	private String m_sentenciaCP;

	public static OrdreProduccioFitxaTecnicaDAO GetInstance() {
		if (m_singleton == null) {
			m_singleton = new OrdreProduccioFitxaTecnicaDAO();
		}

		return m_singleton;
	}

	private OrdreProduccioFitxaTecnicaDAO() {
		m_bddCP = ConnexionsBdd.getInstance().m_bddMySqlControlPlanta;
		m_liniaProduccioDAO = LiniaProduccioFitxaTecnicaDAO.GetInstance();

		String l_campsCP[] = new String[35];
		l_campsCP[0] = "NI_Num_Orden_Produccion";
		l_campsCP[1] = "NI_Descripcion_2";
		l_campsCP[2] = "Ni_Num_Edicio";
		l_campsCP[3] = "(NI_Quantitat_Entregar * 1000)";
		l_campsCP[4] = "Mostres_Client";
		l_campsCP[5] = "Mostres_Comercial";
		l_campsCP[6] = "QuantitatMostresProduccio";
		l_campsCP[7] = "NI_Quantitat_Total_Planes";
		l_campsCP[8] = "Ni_format";
		l_campsCP[9] = "Ni_plegat";
		l_campsCP[10] = "NI_Te_Maqueta";
		l_campsCP[11] = "PaperCoberta";
		l_campsCP[12] = "PaperCobertaQualitat";
		l_campsCP[13] = "PaperCobertaAcabat";
		l_campsCP[14] = "NI_Ample_Bobina";
		l_campsCP[15] = "NI_Empaquetatge_Producte_Acabat";
		l_campsCP[16] = "CopiaCobertaA";
		l_campsCP[17] = "ManipuladorExternEnquadernat";
		l_campsCP[18] = "NI_Enquadernat";
		l_campsCP[19] = "NI_Dist_Tiratges_Publicacio";
		l_campsCP[20] = "NI_Observacions";
		l_campsCP[21] = "NI_Observacions_Encartament";
		l_campsCP[22] = "NI_Mida_Pagina";
		l_campsCP[23] = "NI_Mida_Obert";
		l_campsCP[24] = "NI_Mida_Plegat";
		l_campsCP[25] = "EsPaperPEFC";
		l_campsCP[26] = "QuantitatRoutageClient";
		l_campsCP[27] = "NI_Data_Prevista_Original";
		l_campsCP[28] = "NI_Hora_Prevista_Original";
		l_campsCP[29] = "NI_Data_Prevista_Cobertes";
		l_campsCP[30] = "NI_Hora_Prevista_Cobertes";
		l_campsCP[31] = "NI_Quantitat_Total_Tiratges";
		l_campsCP[32] = "NI_Codigo_Cliente";
		l_campsCP[33] = "NomClientCRM";
		l_campsCP[34] = "NI_Descripcio_Client";

		m_sentenciaCP = "";
		for (int i = 0; i < l_campsCP.length; i++) {
			m_sentenciaCP += i > 0 ? "," : "";
			m_sentenciaCP += l_campsCP[i];
		}
	}

	public OrdreProduccioFitxaTecnica GetFromCP(String p_lan) {
		String l_routageClient;
		OrdreProduccioFitxaTecnica l_ordreProduccio = null;

		if (m_bddCP.executaSQLSELECT(
				"SELECT " + m_sentenciaCP + " FROM ordre_p_navision WHERE NI_Num_Orden_Produccion = '" + p_lan + "'",
				35) > 0) {
			l_ordreProduccio = new OrdreProduccioFitxaTecnica();

			String l_resultatLAN[][] = m_bddCP.recuperaSQLSelect();

			l_ordreProduccio.m_lan = l_resultatLAN[0][0] == null ? "" : l_resultatLAN[0][0];
			l_ordreProduccio.m_nom = l_resultatLAN[0][1] == null ? "" : l_resultatLAN[0][1];
			l_ordreProduccio.m_numeroEdicio = l_resultatLAN[0][2] == null ? "" : l_resultatLAN[0][2];
			l_ordreProduccio.m_quanitat = l_resultatLAN[0][3] == null ? "0"
					: "" + ((int) (Double.parseDouble(l_resultatLAN[0][3]) + 0.1));
			l_ordreProduccio.m_mostresClient = l_resultatLAN[0][4] == null ? "" : l_resultatLAN[0][4];
			l_ordreProduccio.m_mostresCial = l_resultatLAN[0][5] == null ? "" : l_resultatLAN[0][5];
			l_ordreProduccio.m_mostresProduccio = l_resultatLAN[0][6] == null ? "" : l_resultatLAN[0][6];
			l_ordreProduccio.m_totalPagines = l_resultatLAN[0][7] == null ? "" : l_resultatLAN[0][7];
			l_ordreProduccio.m_format = l_resultatLAN[0][8] == null ? "" : l_resultatLAN[0][8];
			l_ordreProduccio.m_plegat = l_resultatLAN[0][9] == null ? "" : l_resultatLAN[0][9];
			// l_ordreProduccio.m_esSegonaEdicio = l_resultatLAN[0][10].equalsIgnoreCase(
			// "S" );
			l_ordreProduccio.m_esSegonaEdicio = l_resultatLAN[0][10] == null ? false
					: l_resultatLAN[0][10].equalsIgnoreCase("S");
			l_ordreProduccio.m_paperCobertaRotimpres = l_resultatLAN[0][11] == null ? "" : l_resultatLAN[0][11];
			l_ordreProduccio.m_paperCobertaRotimpres = l_resultatLAN[0][12] == null ? "" : l_resultatLAN[0][12];
			l_ordreProduccio.m_paperCobertaRotimpres += " "
					+ (l_resultatLAN[0][13] == null ? "" : l_resultatLAN[0][13]);
			l_ordreProduccio.m_paperInterior = l_resultatLAN[0][14] == null ? "" : l_resultatLAN[0][14];
			l_ordreProduccio.m_empaquetatge = l_resultatLAN[0][15] == null ? "" : l_resultatLAN[0][15];
			l_ordreProduccio.m_impressor = l_resultatLAN[0][16] == null ? "" : l_resultatLAN[0][16];
			l_ordreProduccio.m_manipulador = l_resultatLAN[0][17] == null ? "" : l_resultatLAN[0][17];
			l_ordreProduccio.m_enquadernat = l_resultatLAN[0][18] == null ? "" : l_resultatLAN[0][18];
			l_ordreProduccio.m_tiratges = l_resultatLAN[0][19] == null ? "" : l_resultatLAN[0][19];
			l_ordreProduccio.m_observacionsGenerals = l_resultatLAN[0][20] == null ? "" : l_resultatLAN[0][20];
			l_ordreProduccio.m_observacionsEncarts = l_resultatLAN[0][21] == null ? "" : l_resultatLAN[0][21];
			l_ordreProduccio.m_midaPagina = l_resultatLAN[0][22] == null ? "" : l_resultatLAN[0][22];
			l_ordreProduccio.m_midaObert = l_resultatLAN[0][23] == null ? "" : l_resultatLAN[0][23];
			l_ordreProduccio.m_midaPlegat = l_resultatLAN[0][24] == null ? "" : l_resultatLAN[0][24];
			l_ordreProduccio.m_esPaperPEFC = l_resultatLAN[0][25].equals("1");
			l_routageClient = l_resultatLAN[0][26];
			if (l_routageClient != null && !l_routageClient.equals("0")) {
				l_ordreProduccio.m_teRoutageClient = true;
				l_ordreProduccio.m_qRoutageClient = l_routageClient;
			}
			l_ordreProduccio.m_dataEntradaFitxersInterior = l_resultatLAN[0][27] == null ? "" : l_resultatLAN[0][27];
			l_ordreProduccio.m_horaEntradaFitxersInterior = l_resultatLAN[0][28] == null ? "" : l_resultatLAN[0][28];
			l_ordreProduccio.m_dataEntradaFitxersCoberta = l_resultatLAN[0][29] == null ? "" : l_resultatLAN[0][29];
			l_ordreProduccio.m_horaEntradaFitxersCoberta = l_resultatLAN[0][30] == null ? "" : l_resultatLAN[0][30];
			l_ordreProduccio.m_totalTiratges = Integer.parseInt(l_resultatLAN[0][31]);
			l_ordreProduccio.m_codiClient = l_resultatLAN[0][32] == null ? "" : l_resultatLAN[0][32];
			l_ordreProduccio.m_nomClientCRM = l_resultatLAN[0][33] == null ? "" : l_resultatLAN[0][33];
			l_ordreProduccio.m_NI_Descripcio_Client = l_resultatLAN[0][34] == null ? "" : l_resultatLAN[0][34];

			m_liniaProduccioDAO.FillFromCP(l_ordreProduccio);
		}

		return l_ordreProduccio;
	}
}