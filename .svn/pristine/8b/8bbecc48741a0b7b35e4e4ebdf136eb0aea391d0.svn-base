package agendaproduccio.models.entitatsbddAgenda.daos;

import java.util.Calendar;
import java.util.Vector;

import agendaproduccio.models.entitatsbddAgenda.model.OrderLiniaRutaPNavison;
import agendaproduccio.models.entitatsbddAgenda.model.OrdrePNavisionFitxaTecnica;
import agendaproduccio.utils.DataHora;
import connexioBDD.ConnexionsBdd;
import connexioBDD.DataAccessLayer;

public class OrdrePNavisionFitxaTecnicaDAO {
	private static OrdrePNavisionFitxaTecnicaDAO m_singleton;
	private DataAccessLayer m_bdd;
	private String m_sentencia;
	private Object[][] m_camps;
	private DataHora m_dh = DataHora.getInstance();

	public static OrdrePNavisionFitxaTecnicaDAO GetInstance() {
		if (m_singleton == null) {
			m_singleton = new OrdrePNavisionFitxaTecnicaDAO();
		}
		return m_singleton;
	}

	private OrdrePNavisionFitxaTecnicaDAO() {
		m_bdd = ConnexionsBdd.getInstance().m_bddMySqlControlPlanta;

		m_camps = new String[132][2];
		m_camps[0][0] = "ordre_p_navision.uI_Id_Ordre_P_Navision";
		m_camps[1][0] = "ordre_p_navision.nM_Estado";
		m_camps[2][0] = "ordre_p_navision.nM_Estado_Anterior";
		m_camps[3][0] = "ordre_p_navision.nI_Num_Orden_Produccion";
		m_camps[4][0] = "ordre_p_navision.nI_Descripcion";
		m_camps[5][0] = "ordre_p_navision.nI_Descripcion_alias";
		m_camps[6][0] = "ordre_p_navision.nI_Descripcion_2";
		m_camps[7][0] = "ordre_p_navision.uI_Modificado";
		m_camps[8][0] = "ordre_p_navision.uI_Eliminado";
		m_camps[9][0] = "ordre_p_navision.nM_Repas_Visat";
		m_camps[10][0] = "ordre_p_navision.nI_Repas_Conformitat";
		m_camps[11][0] = "ordre_p_navision.uI_Repas_Encarregats";
		m_camps[12][0] = "ordre_p_navision.uI_Repas_Sabria";
		m_camps[13][0] = "ordre_p_navision.uI_Repas_Boada";
		m_camps[14][0] = "ordre_p_navision.uI_Repas_Carerach";
		m_camps[15][0] = "ordre_p_navision.nM_Repas_Comanda";
		m_camps[16][0] = "ordre_p_navision.nM_Repas_Informacio";
		m_camps[17][0] = "ordre_p_navision.uI_Nuevo";
		m_camps[18][0] = "ordre_p_navision.uI_Crea_Fitxer_RutaOPEstado";
		m_camps[19][0] = "ordre_p_navision.nI_Codigo_Cliente";
		m_camps[20][0] = "ordre_p_navision.nI_Nom_Capcalera";
		m_camps[21][0] = "ordre_p_navision.nI_Quantitat_Total_Planes";
		m_camps[22][0] = "ordre_p_navision.nI_Format";
		m_camps[23][0] = "ordre_p_navision.nI_Plegat";
		m_camps[24][0] = "ordre_p_navision.nI_Quantitat_Entregar";
		m_camps[25][0] = "ordre_p_navision.nI_Posicio_Pestanya";
		m_camps[26][0] = "ordre_p_navision.nI_Mida_Pestanya";
		m_camps[27][0] = "ordre_p_navision.nI_Dist_Tiratges_Publicacio";
		m_camps[28][0] = "ordre_p_navision.nI_Dist_Color_Publicacio";
		m_camps[29][0] = "ordre_p_navision.nI_Quantitat_Total_Tiratges";
		m_camps[30][0] = "ordre_p_navision.nI_Ample_Bobina";
		m_camps[31][0] = "ordre_p_navision.nI_Enquadernat";
		m_camps[32][0] = "ordre_p_navision.nI_Mida_Obert";
		m_camps[33][0] = "ordre_p_navision.nI_Mida_Pagina";
		m_camps[34][0] = "ordre_p_navision.nI_Mida_Plegat";
		m_camps[35][0] = "ordre_p_navision.nI_Planes_4_Tintes_Publicacio";
		m_camps[36][0] = "ordre_p_navision.nI_Planes_2_Tintes_Publicacio";
		m_camps[37][0] = "ordre_p_navision.nI_Te_Maqueta";
		m_camps[38][0] = "ordre_p_navision.nI_Te_Mostres_Color";
		m_camps[39][0] = "ordre_p_navision.nI_Suport_Entrega";
		m_camps[40][0] = "ordre_p_navision.nI_Sistema_Operatiu";
		m_camps[41][0] = "ordre_p_navision.nI_Format_Entrega";
		m_camps[42][0] = "ordre_p_navision.nI_Software_Maquetacio";
		m_camps[43][0] = "ordre_p_navision.nI_Umbral_Resolucio";
		m_camps[44][0] = "ordre_p_navision.nI_Observacions";
		m_camps[45][0] = "ordre_p_navision.nI_Num_Pedido";
		m_camps[46][0] = "ordre_p_navision.nI_Data_Prevista_Original";
		m_camps[47][0] = "ordre_p_navision.nI_Hora_Prevista_Original";
		m_camps[48][0] = "ordre_p_navision.nI_Data_Prevista_Cobertes";
		m_camps[49][0] = "ordre_p_navision.nI_Hora_Prevista_Cobertes";
		m_camps[50][0] = "ordre_p_navision.nI_Data_Prevista_Expedicions";
		m_camps[51][0] = "ordre_p_navision.nI_Hora_Prevista_Expedicions";
		m_camps[52][0] = "ordre_p_navision.nI_Data_Prevista_Client";
		m_camps[53][0] = "ordre_p_navision.nI_Hora_Prevista_Client";
		m_camps[54][0] = "ordre_p_navision.nI_Codigo_Variante";
		m_camps[55][0] = "ordre_p_navision.nI_Num_Orden_Produccion_Ant";
		m_camps[56][0] = "ordre_p_navision.nI_Num_Edicio";
		m_camps[57][0] = "ordre_p_navision.nI_Descripcio_Client";
		m_camps[58][0] = "ordre_p_navision.nI_Data_Capcalera";
		m_camps[59][0] = "ordre_p_navision.uI_Data_Real_Lliura_Originals";
		m_camps[60][0] = "ordre_p_navision.uI_Hora_Real_Lliura_Originals";
		m_camps[61][0] = "ordre_p_navision.uI_Estado_CP";
		m_camps[62][0] = "ordre_p_navision.uI_Repas_Expedicions";
		m_camps[63][0] = "ordre_p_navision.nI_Empaquetatge_Producte_Acabat";
		m_camps[64][0] = "ordre_p_navision.nI_Observacions_Encartament";
		m_camps[65][0] = "ordre_p_navision.uI_Faixes";
		m_camps[66][0] = "ordre_p_navision.nI_Pauta";
		m_camps[67][0] = "ordre_p_navision.modificable_x_NouPlus";
		m_camps[68][0] = "ordre_p_navision.nova_Ordre_Control_Clients";
		m_camps[69][0] = "ordre_p_navision.automatismeConfigurat";
		m_camps[70][0] = "ordre_p_navision.terminada_Navision";
		m_camps[71][0] = "ordre_p_navision.recalculada_Produccio";
		m_camps[72][0] = "ordre_p_navision.revisada_Produccio";
		m_camps[73][0] = "ordre_p_navision.terminada_Calculada";
		m_camps[74][0] = "ordre_p_navision.expedicio_Creada";
		m_camps[75][0] = "ordre_p_navision.numComandes";
		m_camps[76][0] = "ordre_p_navision.ha_Estat_Lanzada";
		m_camps[77][0] = "ordre_p_navision.tall_Linia";
		m_camps[78][0] = "ordre_p_navision.mostres_Comercial";
		m_camps[79][0] = "ordre_p_navision.mostres_Client";
		m_camps[80][0] = "ordre_p_navision.signada";
		m_camps[81][0] = "ordre_p_navision.signada_per";
		m_camps[82][0] = "ordre_p_navision.lanzada_per";
		m_camps[83][0] = "ordre_p_navision.referenciaPressupost";
		m_camps[84][0] = "ordre_p_navision.copiaCobertaA";
		m_camps[85][0] = "ordre_p_navision.motiuComandaCanviada";
		m_camps[86][0] = "ordre_p_navision.paperCoberta";
		m_camps[87][0] = "ordre_p_navision.expedit";
		m_camps[88][0] = "ordre_p_navision.expeditParcial";
		m_camps[89][0] = "ordre_p_navision.idPlanificacioPublicacioAssignada";
		m_camps[90][0] = "ordre_p_navision.idPlanificacioLiniaInteriorAssignada";
		m_camps[91][0] = "ordre_p_navision.idPlanificacioLiniaCobertaAssignada";
		m_camps[92][0] = "ordre_p_navision.assignadaPlanningProduccio";
		m_camps[93][0] = "ordre_p_navision.ordreTotalmentSubcontractada";
		m_camps[94][0] = "ordre_p_navision.paperCobertaQualitat";
		m_camps[95][0] = "ordre_p_navision.paperCobertaAcabat";
		m_camps[96][0] = "ordre_p_navision.treballExternImpressioRevisat";
		m_camps[97][0] = "ordre_p_navision.descartarPlanningExpedicions";
		m_camps[98][0] = "ordre_p_navision.idPublicacioComercial";
		m_camps[99][0] = "ordre_p_navision.idEdicioComercial";
		m_camps[100][0] = "ordre_p_navision.traspassadaCPExpedicions";
		m_camps[101][0] = "ordre_p_navision.gestioTransport";
		m_camps[102][0] = "ordre_p_navision.mailRetardEnviat";
		m_camps[103][0] = "ordre_p_navision.ha_Estat_Repas_Informacio";
		m_camps[104][0] = "ordre_p_navision.contactesVerificats";
		m_camps[105][0] = "ordre_p_navision.idComandaWeb";
		m_camps[106][0] = "ordre_p_navision.idUsuariWeb";
		m_camps[107][0] = "ordre_p_navision.idUsuariCRM";
		m_camps[108][0] = "ordre_p_navision.dataCreacio";
		m_camps[109][0] = "ordre_p_navision.manipuladorExternEnquadernat";
		m_camps[110][0] = "ordre_p_navision.esPaperPEFC";
		m_camps[111][0] = "ordre_p_navision.pendentActualitzarHistoric";
		m_camps[112][0] = "ordre_p_navision.lANInterior";
		m_camps[113][0] = "ordre_p_navision.nomClientCRM";
		m_camps[114][0] = "ordre_p_navision.quantitatMostresProduccio";
		m_camps[115][0] = "ordre_p_navision.quantitatRoutageClient";
		m_camps[116][0] = "ordre_p_navision.terminada_Anna";
		m_camps[117][0] = "ordre_p_navision.pathInsite";
		m_camps[118][0] = "ordre_p_navision.idPlanificacioProducte";
		m_camps[119][0] = "ordre_p_navision.generadaProduccioDirecteParte";
		m_camps[120][0] = "ordre_p_navision.dataPrevistaInterior";
		m_camps[121][0] = "ordre_p_navision.dataPrevistaCobertes";
		m_camps[122][0] = "ordre_p_navision.esPaperFSC";
		m_camps[123][0] = "ordre_p_navision.idComandaWebNova";
		m_camps[124][0] = "ordre_p_navision.idUsuariWebNova";
		m_camps[125][0] = "ordre_p_navision.mostrarIvaProforma";
		m_camps[126][0] = "ordre_p_navision.ivaProforma";
		m_camps[127][0] = "ordre_p_navision.mailRetardCobertaEnviat";
		m_camps[128][0] = "ordre_p_navision.enGestioPerComercial";
		m_camps[129][0] = "ordre_p_navision.calRecalcularCostos";
		m_camps[130][0] = "ordre_p_navision.jobTicketFet";
		m_camps[131][0] = "ordre_p_navision.dataJobTicketFet";

		m_sentencia = "";
		for (int i = 0; i < m_camps.length; i++) {
			m_sentencia += i > 0 ? "," : "";
			m_sentencia += m_camps[i][0];
		}
	}

	public OrdrePNavisionFitxaTecnica Get(int p_id) {
		OrdrePNavisionFitxaTecnica l_finalResult = null;

		if (m_bdd.executaSQLSELECT("SELECT " + m_sentencia + " FROM ordre_p_navision WHERE uI_Id_Ordre_P_Navision = "
				+ p_id + " ORDER BY uI_Id_Ordre_P_Navision ASC ") > 0) {
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			l_finalResult = Fill(l_initialResult[0]);
		}
		return l_finalResult;
	}

	// M�tode generat autom�ticament com a exemple d'una SELECT de m�ltiples
	// files >> Substituir-lo pel primer m�tode d'aquest estil
	public Vector<OrdrePNavisionFitxaTecnica> GetUltims10() {
		Vector<OrdrePNavisionFitxaTecnica> l_vRes = new Vector<>();

		if (m_bdd.executaSQLSELECT(
				"SELECT " + m_sentencia + " FROM ordre_p_navision ORDER BY uI_Id_Ordre_P_Navision DESC LIMIT 10") > 0) {
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			for (int i = 0; i < l_initialResult.length; i++) {
				l_vRes.add(Fill(l_initialResult[i]));
			}
		}
		return l_vRes;
	}

	private OrdrePNavisionFitxaTecnica Fill(Object[] p_fila) {
		OrdrePNavisionFitxaTecnica l_res = new OrdrePNavisionFitxaTecnica();

		l_res.m_uI_Id_Ordre_P_Navision = p_fila[0] == null ? 0 : Integer.parseInt((String) p_fila[0]);
		l_res.m_nM_Estado = p_fila[1] == null ? "" : (String) p_fila[1];
		l_res.m_nM_Estado_Anterior = p_fila[2] == null ? "" : (String) p_fila[2];
		l_res.m_nI_Num_Orden_Produccion = p_fila[3] == null ? "" : (String) p_fila[3];
		l_res.m_nI_Descripcion = p_fila[4] == null ? "" : (String) p_fila[4];
		l_res.m_nI_Descripcion_alias = p_fila[5] == null ? "" : (String) p_fila[5];
		l_res.m_nI_Descripcion_2 = p_fila[6] == null ? "" : (String) p_fila[6];
		l_res.m_uI_Modificado = p_fila[7] == null ? false : p_fila[7].equals("1");
		l_res.m_uI_Eliminado = p_fila[8] == null ? false : p_fila[8].equals("1");
		l_res.m_nM_Repas_Visat = p_fila[9] == null ? false : p_fila[9].equals("1");
		l_res.m_nI_Repas_Conformitat = p_fila[10] == null ? false : p_fila[10].equals("1");
		l_res.m_uI_Repas_Encarregats = p_fila[11] == null ? false : p_fila[11].equals("1");
		l_res.m_uI_Repas_Sabria = p_fila[12] == null ? false : p_fila[12].equals("1");
		l_res.m_uI_Repas_Boada = p_fila[13] == null ? false : p_fila[13].equals("1");
		l_res.m_uI_Repas_Carerach = p_fila[14] == null ? false : p_fila[14].equals("1");
		l_res.m_nM_Repas_Comanda = p_fila[15] == null ? false : p_fila[15].equals("1");
		l_res.m_nM_Repas_Informacio = p_fila[16] == null ? false : p_fila[16].equals("1");
		l_res.m_uI_Nuevo = p_fila[17] == null ? false : p_fila[17].equals("1");
		l_res.m_uI_Crea_Fitxer_RutaOPEstado = p_fila[18] == null ? false : p_fila[18].equals("1");
		l_res.m_nI_Codigo_Cliente = p_fila[19] == null ? "" : (String) p_fila[19];
		l_res.m_nI_Nom_Capcalera = p_fila[20] == null ? "" : (String) p_fila[20];
		l_res.m_nI_Quantitat_Total_Planes = p_fila[21] == null ? "" : (String) p_fila[21];
		l_res.m_nI_Format = p_fila[22] == null ? "" : (String) p_fila[22];
		l_res.m_nI_Plegat = p_fila[23] == null ? "" : (String) p_fila[23];
		l_res.m_nI_Quantitat_Entregar = p_fila[24] == null ? "" : (String) p_fila[24];
		l_res.m_nI_Posicio_Pestanya = p_fila[25] == null ? "" : (String) p_fila[25];
		l_res.m_nI_Mida_Pestanya = p_fila[26] == null ? "" : (String) p_fila[26];
		l_res.m_nI_Dist_Tiratges_Publicacio = p_fila[27] == null ? "" : (String) p_fila[27];
		l_res.m_nI_Dist_Color_Publicacio = p_fila[28] == null ? "" : (String) p_fila[28];
		l_res.m_nI_Quantitat_Total_Tiratges = p_fila[29] == null ? 0 : Integer.parseInt((String) p_fila[29]);
		l_res.m_nI_Ample_Bobina = p_fila[30] == null ? "" : (String) p_fila[30];
		l_res.m_nI_Enquadernat = p_fila[31] == null ? "" : (String) p_fila[31];
		l_res.m_nI_Mida_Obert = p_fila[32] == null ? "" : (String) p_fila[32];
		l_res.m_nI_Mida_Pagina = p_fila[33] == null ? "" : (String) p_fila[33];
		l_res.m_nI_Mida_Plegat = p_fila[34] == null ? "" : (String) p_fila[34];
		l_res.m_nI_Planes_4_Tintes_Publicacio = p_fila[35] == null ? "" : (String) p_fila[35];
		l_res.m_nI_Planes_2_Tintes_Publicacio = p_fila[36] == null ? "" : (String) p_fila[36];
		l_res.m_nI_Te_Maqueta = p_fila[37] == null ? ' ' : (char) p_fila[37];
		;
		l_res.m_nI_Te_Mostres_Color = p_fila[38] == null ? ' ' : (char) p_fila[38];
		;
		l_res.m_nI_Suport_Entrega = p_fila[39] == null ? "" : (String) p_fila[39];
		l_res.m_nI_Sistema_Operatiu = p_fila[40] == null ? "" : (String) p_fila[40];
		l_res.m_nI_Format_Entrega = p_fila[41] == null ? "" : (String) p_fila[41];
		l_res.m_nI_Software_Maquetacio = p_fila[42] == null ? "" : (String) p_fila[42];
		l_res.m_nI_Umbral_Resolucio = p_fila[43] == null ? "" : (String) p_fila[43];
		l_res.m_nI_Observacions = p_fila[44] == null ? "" : (String) p_fila[44];
		l_res.m_nI_Num_Pedido = p_fila[45] == null ? "" : (String) p_fila[45];
		l_res.m_nI_Data_Prevista_Original = p_fila[46] == null ? "" : (String) p_fila[46];
		l_res.m_nI_Hora_Prevista_Original = p_fila[47] == null ? "" : (String) p_fila[47];
		l_res.m_nI_Data_Prevista_Cobertes = p_fila[48] == null ? "" : (String) p_fila[48];
		l_res.m_nI_Hora_Prevista_Cobertes = p_fila[49] == null ? "" : (String) p_fila[49];
		l_res.m_nI_Data_Prevista_Expedicions = p_fila[50] == null ? "" : (String) p_fila[50];
		l_res.m_nI_Hora_Prevista_Expedicions = p_fila[51] == null ? "" : (String) p_fila[51];
		l_res.m_nI_Data_Prevista_Client = p_fila[52] == null ? "" : (String) p_fila[52];
		l_res.m_nI_Hora_Prevista_Client = p_fila[53] == null ? "" : (String) p_fila[53];
		l_res.m_nI_Codigo_Variante = p_fila[54] == null ? "" : (String) p_fila[54];
		l_res.m_nI_Num_Orden_Produccion_Ant = p_fila[55] == null ? "" : (String) p_fila[55];
		l_res.m_nI_Num_Edicio = p_fila[56] == null ? "" : (String) p_fila[56];
		l_res.m_nI_Descripcio_Client = p_fila[57] == null ? "" : (String) p_fila[57];
		l_res.m_nI_Data_Capcalera = p_fila[58] == null ? "" : (String) p_fila[58];
		l_res.m_uI_Data_Real_Lliura_Originals = p_fila[59] == null ? null
				: m_dh.MySQLFormatToCalendarFormat((String) p_fila[59]);
		l_res.m_uI_Hora_Real_Lliura_Originals = p_fila[60] == null ? null
				: m_dh.MySQLFormatToCalendarFormat((String) p_fila[60]);
		l_res.m_uI_Estado_CP = p_fila[61] == null ? "" : (String) p_fila[61];
		l_res.m_uI_Repas_Expedicions = p_fila[62] == null ? false : p_fila[62].equals("1");
		l_res.m_nI_Empaquetatge_Producte_Acabat = p_fila[63] == null ? "" : (String) p_fila[63];
		l_res.m_nI_Observacions_Encartament = p_fila[64] == null ? "" : (String) p_fila[64];
		l_res.m_uI_Faixes = p_fila[65] == null ? "" : (String) p_fila[65];
		l_res.m_nI_Pauta = p_fila[66] == null ? "" : (String) p_fila[66];
		l_res.m_modificable_x_NouPlus = p_fila[67] == null ? false : p_fila[67].equals("1");
		l_res.m_nova_Ordre_Control_Clients = p_fila[68] == null ? false : p_fila[68].equals("1");
		l_res.m_automatismeConfigurat = p_fila[69] == null ? false : p_fila[69].equals("1");
		l_res.m_terminada_Navision = p_fila[70] == null ? false : p_fila[70].equals("1");
		l_res.m_recalculada_Produccio = p_fila[71] == null ? false : p_fila[71].equals("1");
		l_res.m_revisada_Produccio = p_fila[72] == null ? false : p_fila[72].equals("1");
		l_res.m_terminada_Calculada = p_fila[73] == null ? false : p_fila[73].equals("1");
		l_res.m_expedicio_Creada = p_fila[74] == null ? false : p_fila[74].equals("1");
		l_res.m_numComandes = p_fila[75] == null ? false : p_fila[75].equals("1");
		l_res.m_ha_Estat_Lanzada = p_fila[76] == null ? false : p_fila[76].equals("1");
		l_res.m_tall_Linia = p_fila[77] == null ? false : p_fila[77].equals("1");
		l_res.m_mostres_Comercial = p_fila[78] == null ? "" : (String) p_fila[78];
		l_res.m_mostres_Client = p_fila[79] == null ? "" : (String) p_fila[79];
		l_res.m_signada = p_fila[80] == null ? false : p_fila[80].equals("1");
		l_res.m_signada_per = p_fila[81] == null ? "" : (String) p_fila[81];
		l_res.m_lanzada_per = p_fila[82] == null ? "" : (String) p_fila[82];
		l_res.m_referenciaPressupost = p_fila[83] == null ? "" : (String) p_fila[83];
		l_res.m_copiaCobertaA = p_fila[84] == null ? "" : (String) p_fila[84];
		l_res.m_motiuComandaCanviada = p_fila[85] == null ? "" : (String) p_fila[85];
		l_res.m_paperCoberta = p_fila[86] == null ? "" : (String) p_fila[86];
		l_res.m_expedit = p_fila[87] == null ? false : p_fila[87].equals("1");
		l_res.m_expeditParcial = p_fila[88] == null ? false : p_fila[88].equals("1");
		l_res.m_idPlanificacioPublicacioAssignada = p_fila[89] == null ? 0 : Integer.parseInt((String) p_fila[89]);
		l_res.m_idPlanificacioLiniaInteriorAssignada = p_fila[90] == null ? 0 : Integer.parseInt((String) p_fila[90]);
		l_res.m_idPlanificacioLiniaCobertaAssignada = p_fila[91] == null ? 0 : Integer.parseInt((String) p_fila[91]);
		l_res.m_assignadaPlanningProduccio = p_fila[92] == null ? false : p_fila[92].equals("1");
		l_res.m_ordreTotalmentSubcontractada = p_fila[93] == null ? false : p_fila[93].equals("1");
		l_res.m_paperCobertaQualitat = p_fila[94] == null ? "" : (String) p_fila[94];
		l_res.m_paperCobertaAcabat = p_fila[95] == null ? "" : (String) p_fila[95];
		l_res.m_treballExternImpressioRevisat = p_fila[96] == null ? false : p_fila[96].equals("1");
		l_res.m_descartarPlanningExpedicions = p_fila[97] == null ? false : p_fila[97].equals("1");
		l_res.m_idPublicacioComercial = p_fila[98] == null ? 0 : Integer.parseInt((String) p_fila[98]);
		l_res.m_idEdicioComercial = p_fila[99] == null ? 0 : Integer.parseInt((String) p_fila[99]);
		l_res.m_traspassadaCPExpedicions = p_fila[100] == null ? false : p_fila[100].equals("1");
		l_res.m_gestioTransport = p_fila[101] == null ? "" : (String) p_fila[101];
		l_res.m_mailRetardEnviat = p_fila[102] == null ? false : p_fila[102].equals("1");
		l_res.m_ha_Estat_Repas_Informacio = p_fila[103] == null ? false : p_fila[103].equals("1");
		l_res.m_contactesVerificats = p_fila[104] == null ? false : p_fila[104].equals("1");
		l_res.m_idComandaWeb = p_fila[105] == null ? 0 : Integer.parseInt((String) p_fila[105]);
		l_res.m_idUsuariWeb = p_fila[106] == null ? 0 : Integer.parseInt((String) p_fila[106]);
		l_res.m_idUsuariCRM = p_fila[107] == null ? 0 : Integer.parseInt((String) p_fila[107]);
		l_res.m_dataCreacio = p_fila[108] == null ? null : m_dh.MySQLFormatToCalendarFormat((String) p_fila[108]);
		l_res.m_manipuladorExternEnquadernat = p_fila[109] == null ? "" : (String) p_fila[109];
		l_res.m_esPaperPEFC = p_fila[110] == null ? false : p_fila[110].equals("1");
		l_res.m_pendentActualitzarHistoric = p_fila[111] == null ? false : p_fila[111].equals("1");
		l_res.m_lANInterior = p_fila[112] == null ? "" : (String) p_fila[112];
		l_res.m_nomClientCRM = p_fila[113] == null ? "" : (String) p_fila[113];
		l_res.m_quantitatMostresProduccio = p_fila[114] == null ? 0 : Integer.parseInt((String) p_fila[114]);
		l_res.m_quantitatRoutageClient = p_fila[115] == null ? 0 : Integer.parseInt((String) p_fila[115]);
		l_res.m_terminada_Anna = p_fila[116] == null ? false : p_fila[116].equals("1");
		l_res.m_pathInsite = p_fila[117] == null ? "" : (String) p_fila[117];
		l_res.m_idPlanificacioProducte = p_fila[118] == null ? 0 : Integer.parseInt((String) p_fila[118]);
		l_res.m_generadaProduccioDirecteParte = p_fila[119] == null ? false : p_fila[119].equals("1");
		l_res.m_dataPrevistaInterior = p_fila[120] == null ? null
				: m_dh.MySQLFormatToCalendarFormat((String) p_fila[120]);
		l_res.m_dataPrevistaCobertes = p_fila[121] == null ? null
				: m_dh.MySQLFormatToCalendarFormat((String) p_fila[121]);
		l_res.m_esPaperFSC = p_fila[122] == null ? false : p_fila[122].equals("1");
		l_res.m_idComandaWebNova = p_fila[123] == null ? 0 : Integer.parseInt((String) p_fila[123]);
		l_res.m_idUsuariWebNova = p_fila[124] == null ? 0 : Integer.parseInt((String) p_fila[124]);
		l_res.m_mostrarIvaProforma = p_fila[125] == null ? false : p_fila[125].equals("1");
		l_res.m_ivaProforma = p_fila[126] == null ? 0 : Integer.parseInt((String) p_fila[126]);
		l_res.m_mailRetardCobertaEnviat = p_fila[127] == null ? false : p_fila[127].equals("1");
		l_res.m_enGestioPerComercial = p_fila[128] == null ? false : p_fila[128].equals("1");
		l_res.m_calRecalcularCostos = p_fila[129] == null ? false : p_fila[129].equals("1");
		l_res.m_jobTicketFet = p_fila[130] == null ? false : p_fila[130].equals("1");
		l_res.m_dataJobTicketFet = p_fila[131] == null ? null : m_dh.MySQLFormatToCalendarFormat((String) p_fila[131]);

		return l_res;
	}

	public Vector<OrdrePNavisionFitxaTecnica> getEntrades(Calendar p_dataInici, Calendar p_dataFinal) {
		Vector<OrdrePNavisionFitxaTecnica> l_vRes = new Vector<>();
		if (p_dataInici != null && p_dataFinal != null) {
			String l_strDini = m_dh.CalendarToStringAmericaAADDMM(p_dataInici);
			String l_strDfin = m_dh.CalendarToStringAmericaAADDMM(p_dataFinal);
			String l_query = Sentencias.BuildSelectFitxa(m_sentencia, l_strDini, l_strDfin);
			System.out.println(l_query);
			if (m_bdd.executaSQLSELECT(l_query) > 0) {
				String l_initialResult[][] = m_bdd.recuperaSQLSelect();
				for (int i = 0; i < l_initialResult.length; i++) {

					l_vRes.add(Fill(l_initialResult[i]));
				}
			}
		} else {
			System.out.println("DATE IS NULL!!!!");
		}

		return l_vRes;
	}

}
