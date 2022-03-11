package agendaproduccio.models.entitatsbddAgenda.daos;

import connexioBDD.ConnexionsBdd;
import connexioBDD.DataAccessLayer;
import java.util.Vector;

import agendaproduccio.models.entitatsbddAgenda.model.RutesOrdrePNavision;
import agendaproduccio.utils.DataHora;


public class RutesOrdrePNavisionDAO	
{
	private static RutesOrdrePNavisionDAO m_singleton;
	private DataAccessLayer m_bdd;
	private String m_sentencia;
	private String[][] m_camps;
	private DataHora m_dh = DataHora.getInstance();


	public static RutesOrdrePNavisionDAO GetInstance()
	{
		if( m_singleton == null )
		{
			m_singleton = new RutesOrdrePNavisionDAO();
		}
		return m_singleton;
	}

	private RutesOrdrePNavisionDAO()
	{
		m_bdd = ConnexionsBdd.getInstance().m_bddMySqlControlPlanta;

		m_camps = new String[110][2];
		m_camps[0][0] = "rutes_ordre_p_navision.uI_Id_Ruta_Ordre_P_Navision";
		m_camps[1][0] = "rutes_ordre_p_navision.uI_Id_Lin_Ordre_P_Navision";
		m_camps[2][0] = "rutes_ordre_p_navision.uI_Id_Centre_Maquina";
		m_camps[3][0] = "rutes_ordre_p_navision.uI_Id_Centre_Treball";
		m_camps[4][0] = "rutes_ordre_p_navision.nM_Data_Inici_Estimada";
		m_camps[5][0] = "rutes_ordre_p_navision.nM_Data_Final_Estimada";
		m_camps[6][0] = "rutes_ordre_p_navision.uI_Estado";
		m_camps[7][0] = "rutes_ordre_p_navision.nI_Descripcion";
		m_camps[8][0] = "rutes_ordre_p_navision.uI_Data_Inici";
		m_camps[9][0] = "rutes_ordre_p_navision.uI_Data_Final";
		m_camps[10][0] = "rutes_ordre_p_navision.nI_Num_Centro_Trabajo";
		m_camps[11][0] = "rutes_ordre_p_navision.nI_Num_operacion";
		m_camps[12][0] = "rutes_ordre_p_navision.nI_Num_operacion_siguiente";
		m_camps[13][0] = "rutes_ordre_p_navision.nI_Num_operacion_anterior";
		m_camps[14][0] = "rutes_ordre_p_navision.nI_Tipo";
		m_camps[15][0] = "rutes_ordre_p_navision.nM_Tiempo_ejecucion";
		m_camps[16][0] = "rutes_ordre_p_navision.nM_Cod_ud_medida_tiempo_ejec";
		m_camps[17][0] = "rutes_ordre_p_navision.nI_Num_orden_produccion";
		m_camps[18][0] = "rutes_ordre_p_navision.uI_Data_Inici_Pausa";
		m_camps[19][0] = "rutes_ordre_p_navision.uI_Data_Final_Pausa";
		m_camps[20][0] = "rutes_ordre_p_navision.uI_Durada_Estimada";
		m_camps[21][0] = "rutes_ordre_p_navision.uI_Durada";
		m_camps[22][0] = "rutes_ordre_p_navision.uI_Durada_Pausa";
		m_camps[23][0] = "rutes_ordre_p_navision.uI_Quantitat_Relacionada";
		m_camps[24][0] = "rutes_ordre_p_navision.uI_Data_Inici_Incidencia";
		m_camps[25][0] = "rutes_ordre_p_navision.uI_Data_Final_Incidencia";
		m_camps[26][0] = "rutes_ordre_p_navision.uI_Durada_Incidencia";
		m_camps[27][0] = "rutes_ordre_p_navision.uI_Estat_Anterior";
		m_camps[28][0] = "rutes_ordre_p_navision.uI_Crea_Fitxer_RutaOPh";
		m_camps[29][0] = "rutes_ordre_p_navision.nI_Num_Ruta";
		m_camps[30][0] = "rutes_ordre_p_navision.nI_Num_Ruta_Referencia";
		m_camps[31][0] = "rutes_ordre_p_navision.uI_Ma_Obra";
		m_camps[32][0] = "rutes_ordre_p_navision.uI_Generar_PDF";
		m_camps[33][0] = "rutes_ordre_p_navision.uI_PDF_Fet";
		m_camps[34][0] = "rutes_ordre_p_navision.uI_Data_Final_Real";
		m_camps[35][0] = "rutes_ordre_p_navision.uI_Enviat_1";
		m_camps[36][0] = "rutes_ordre_p_navision.uI_Enviat_2";
		m_camps[37][0] = "rutes_ordre_p_navision.uI_Enviat_3";
		m_camps[38][0] = "rutes_ordre_p_navision.uI_Enviat_4";
		m_camps[39][0] = "rutes_ordre_p_navision.uI_Enviat_M";
		m_camps[40][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_1";
		m_camps[41][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_2";
		m_camps[42][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_3";
		m_camps[43][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_4";
		m_camps[44][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_M";
		m_camps[45][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_1";
		m_camps[46][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_2";
		m_camps[47][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_3";
		m_camps[48][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_4";
		m_camps[49][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_M";
		m_camps[50][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_1";
		m_camps[51][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_2";
		m_camps[52][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_3";
		m_camps[53][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_4";
		m_camps[54][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_M";
		m_camps[55][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_1";
		m_camps[56][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_2";
		m_camps[57][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_3";
		m_camps[58][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_4";
		m_camps[59][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_M";
		m_camps[60][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_1";
		m_camps[61][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_2";
		m_camps[62][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_3";
		m_camps[63][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_4";
		m_camps[64][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_M";
		m_camps[65][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_1";
		m_camps[66][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_2";
		m_camps[67][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_3";
		m_camps[68][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_4";
		m_camps[69][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_M";
		m_camps[70][0] = "rutes_ordre_p_navision.uI_Enc_Personal_1";
		m_camps[71][0] = "rutes_ordre_p_navision.uI_Enc_Personal_2";
		m_camps[72][0] = "rutes_ordre_p_navision.uI_Enc_Personal_3";
		m_camps[73][0] = "rutes_ordre_p_navision.uI_Enc_Personal_4";
		m_camps[74][0] = "rutes_ordre_p_navision.uI_Enc_Personal_M";
		m_camps[75][0] = "rutes_ordre_p_navision.uI_Enviat_5";
		m_camps[76][0] = "rutes_ordre_p_navision.uI_Enc_Data_Inici_5";
		m_camps[77][0] = "rutes_ordre_p_navision.uI_Enc_Data_Final_5";
		m_camps[78][0] = "rutes_ordre_p_navision.uI_Enc_Quantitat_5";
		m_camps[79][0] = "rutes_ordre_p_navision.uI_Enc_NumEtts_5";
		m_camps[80][0] = "rutes_ordre_p_navision.uI_Enc_Descripcio_5";
		m_camps[81][0] = "rutes_ordre_p_navision.uI_Enc_Observacions_5";
		m_camps[82][0] = "rutes_ordre_p_navision.uI_Enc_Personal_5";
		m_camps[83][0] = "rutes_ordre_p_navision.uI_Info_Final_Entrada";
		m_camps[84][0] = "rutes_ordre_p_navision.traspasat";
		m_camps[85][0] = "rutes_ordre_p_navision.uI_Veure_Imprevist";
		m_camps[86][0] = "rutes_ordre_p_navision.nI_Identificador_Tiratge";
		m_camps[87][0] = "rutes_ordre_p_navision.cip3_generat";
		m_camps[88][0] = "rutes_ordre_p_navision.revisada";
		m_camps[89][0] = "rutes_ordre_p_navision.quantitat_Total_Incidencies";
		m_camps[90][0] = "rutes_ordre_p_navision.temps_Total_Incidencies";
		m_camps[91][0] = "rutes_ordre_p_navision.observacio_Revisada";
		m_camps[92][0] = "rutes_ordre_p_navision.cost_Imprevistos";
		m_camps[93][0] = "rutes_ordre_p_navision.bobines_Modificades";
		m_camps[94][0] = "rutes_ordre_p_navision.visibleAbansCTP";
		m_camps[95][0] = "rutes_ordre_p_navision.verificaMostres";
		m_camps[96][0] = "rutes_ordre_p_navision.reparteixMostres";
		m_camps[97][0] = "rutes_ordre_p_navision.pendentActualitzarHistoric";
		m_camps[98][0] = "rutes_ordre_p_navision.observacionsReparteixMostres";
		m_camps[99][0] = "rutes_ordre_p_navision.caraODorsMaquinaFulla";
		m_camps[100][0] = "rutes_ordre_p_navision.numeroCaraODorsMaquinaFulla";
		m_camps[101][0] = "rutes_ordre_p_navision.consumPaperMagatzemRealitzat";
		m_camps[102][0] = "rutes_ordre_p_navision.dataHoraIniciJDF";
		m_camps[103][0] = "rutes_ordre_p_navision.dataHoraFinalJDF";
		m_camps[104][0] = "rutes_ordre_p_navision.datesJDFCalculades";
		m_camps[105][0] = "rutes_ordre_p_navision.ediIgnorarDesviacioFlejar";
		m_camps[106][0] = "rutes_ordre_p_navision.ediIgnorarSolapaments";
		m_camps[107][0] = "rutes_ordre_p_navision.ediIgnorarPreparacioCurta";
		m_camps[108][0] = "rutes_ordre_p_navision.revisatCostosProduccio";
		m_camps[109][0] = "rutes_ordre_p_navision.revisorCostosProduccio";

		m_sentencia = "";
		for( int i = 0; i < m_camps.length; i++ )
		{
			m_sentencia += i > 0? ",":"";
			m_sentencia += m_camps[i][0];
		}
	}

	public RutesOrdrePNavision Get( int p_id )
	{
		RutesOrdrePNavision l_finalResult = null;

		if(m_bdd.executaSQLSELECT( "SELECT " +m_sentencia+ " FROM rutes_ordre_p_navision WHERE uI_Id_Ruta_Ordre_P_Navision = " +p_id+ " ORDER BY uI_Id_Ruta_Ordre_P_Navision ASC ") > 0 )
		{
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			l_finalResult = Fill(l_initialResult[0]);
		}
		return l_finalResult;
	}

	// M�tode generat autom�ticament com a exemple d'una SELECT de m�ltiples files >> Substituir-lo pel primer m�tode d'aquest estil
	public Vector<RutesOrdrePNavision> GetUltims10()
	{
		Vector<RutesOrdrePNavision> l_vRes = new Vector<>();

		if(m_bdd.executaSQLSELECT( "SELECT " +m_sentencia+ " FROM rutes_ordre_p_navision ORDER BY uI_Id_Ruta_Ordre_P_Navision DESC LIMIT 10") > 0 )
		{
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			for ( int i = 0 ; i < l_initialResult.length ; i++ )
			{
				l_vRes.add( Fill(l_initialResult[i]) );
			}
		}
		return l_vRes;
	}


	private RutesOrdrePNavision Fill(String[] p_fila)
	{
		RutesOrdrePNavision l_res = new RutesOrdrePNavision();

		l_res.m_uI_Id_Ruta_Ordre_P_Navision = p_fila[0] == null ? 0 : Integer.parseInt( p_fila[0] );
		l_res.m_uI_Id_Lin_Ordre_P_Navision = p_fila[1] == null ? 0 : Integer.parseInt( p_fila[1] );
		l_res.m_uI_Id_Centre_Maquina = p_fila[2] == null ? 0 : Integer.parseInt( p_fila[2] );
		l_res.m_uI_Id_Centre_Treball = p_fila[3] == null ? 0 : Integer.parseInt( p_fila[3] );
		l_res.m_nM_Data_Inici_Estimada = p_fila[4] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[4]);
		l_res.m_nM_Data_Final_Estimada = p_fila[5] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[5]);
		l_res.m_uI_Estado = p_fila[6] == null ? "" : p_fila[6];
		l_res.m_nI_Descripcion = p_fila[7] == null ? "" : p_fila[7];
		l_res.m_uI_Data_Inici = p_fila[8] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[8]);
		l_res.m_uI_Data_Final = p_fila[9] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[9]);
		l_res.m_nI_Num_Centro_Trabajo = p_fila[10] == null ? "" : p_fila[10];
		l_res.m_nI_Num_operacion = p_fila[11] == null ? 0 : Integer.parseInt( p_fila[11] );
		l_res.m_nI_Num_operacion_siguiente = p_fila[12] == null ? "" : p_fila[12];
		l_res.m_nI_Num_operacion_anterior = p_fila[13] == null ? "" : p_fila[13];
		l_res.m_nI_Tipo = p_fila[14] == null ? "" : p_fila[14];
		l_res.m_nM_Tiempo_ejecucion = p_fila[15] == null ? "" : p_fila[15];
		l_res.m_nM_Cod_ud_medida_tiempo_ejec = p_fila[16] == null ? "" : p_fila[16];
		l_res.m_nI_Num_orden_produccion = p_fila[17] == null ? "" : p_fila[17];
		l_res.m_uI_Data_Inici_Pausa = p_fila[18] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[18]);
		l_res.m_uI_Data_Final_Pausa = p_fila[19] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[19]);
		l_res.m_uI_Durada_Estimada = p_fila[20] == null ? 0 : Integer.parseInt( p_fila[20] );
		l_res.m_uI_Durada = p_fila[21] == null ? 0 : Integer.parseInt( p_fila[21] );
		l_res.m_uI_Durada_Pausa = p_fila[22] == null ? 0 : Integer.parseInt( p_fila[22] );
		l_res.m_uI_Quantitat_Relacionada = p_fila[23] == null ? 0 : Integer.parseInt( p_fila[23] );
		l_res.m_uI_Data_Inici_Incidencia = p_fila[24] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[24]);
		l_res.m_uI_Data_Final_Incidencia = p_fila[25] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[25]);
		l_res.m_uI_Durada_Incidencia = p_fila[26] == null ? 0 : Integer.parseInt( p_fila[26] );
		l_res.m_uI_Estat_Anterior = p_fila[27] == null ? false : p_fila[27].equals("1");
		l_res.m_uI_Crea_Fitxer_RutaOPh = p_fila[28] == null ? false : p_fila[28].equals("1");
		l_res.m_nI_Num_Ruta = p_fila[29] == null ? 0 : Integer.parseInt( p_fila[29] );
		l_res.m_nI_Num_Ruta_Referencia = p_fila[30] == null ? 0 : Integer.parseInt( p_fila[30] );
		l_res.m_uI_Ma_Obra = p_fila[31] == null ? 0 : Integer.parseInt( p_fila[31] );
		l_res.m_uI_Generar_PDF = p_fila[32] == null ? false : p_fila[32].equals("1");
		l_res.m_uI_PDF_Fet = p_fila[33] == null ? false : p_fila[33].equals("1");
		l_res.m_uI_Data_Final_Real = p_fila[34] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[34]);
		l_res.m_uI_Enviat_1 = p_fila[35] == null ? false : p_fila[35].equals("1");
		l_res.m_uI_Enviat_2 = p_fila[36] == null ? false : p_fila[36].equals("1");
		l_res.m_uI_Enviat_3 = p_fila[37] == null ? false : p_fila[37].equals("1");
		l_res.m_uI_Enviat_4 = p_fila[38] == null ? false : p_fila[38].equals("1");
		l_res.m_uI_Enviat_M = p_fila[39] == null ? false : p_fila[39].equals("1");
		l_res.m_uI_Enc_Data_Inici_1 = p_fila[40] == null ? "" : p_fila[40];
		l_res.m_uI_Enc_Data_Inici_2 = p_fila[41] == null ? "" : p_fila[41];
		l_res.m_uI_Enc_Data_Inici_3 = p_fila[42] == null ? "" : p_fila[42];
		l_res.m_uI_Enc_Data_Inici_4 = p_fila[43] == null ? "" : p_fila[43];
		l_res.m_uI_Enc_Data_Inici_M = p_fila[44] == null ? "" : p_fila[44];
		l_res.m_uI_Enc_Data_Final_1 = p_fila[45] == null ? "" : p_fila[45];
		l_res.m_uI_Enc_Data_Final_2 = p_fila[46] == null ? "" : p_fila[46];
		l_res.m_uI_Enc_Data_Final_3 = p_fila[47] == null ? "" : p_fila[47];
		l_res.m_uI_Enc_Data_Final_4 = p_fila[48] == null ? "" : p_fila[48];
		l_res.m_uI_Enc_Data_Final_M = p_fila[49] == null ? "" : p_fila[49];
		l_res.m_uI_Enc_Quantitat_1 = p_fila[50] == null ? "" : p_fila[50];
		l_res.m_uI_Enc_Quantitat_2 = p_fila[51] == null ? "" : p_fila[51];
		l_res.m_uI_Enc_Quantitat_3 = p_fila[52] == null ? "" : p_fila[52];
		l_res.m_uI_Enc_Quantitat_4 = p_fila[53] == null ? "" : p_fila[53];
		l_res.m_uI_Enc_Quantitat_M = p_fila[54] == null ? "" : p_fila[54];
		l_res.m_uI_Enc_NumEtts_1 = p_fila[55] == null ? "" : p_fila[55];
		l_res.m_uI_Enc_NumEtts_2 = p_fila[56] == null ? "" : p_fila[56];
		l_res.m_uI_Enc_NumEtts_3 = p_fila[57] == null ? "" : p_fila[57];
		l_res.m_uI_Enc_NumEtts_4 = p_fila[58] == null ? "" : p_fila[58];
		l_res.m_uI_Enc_NumEtts_M = p_fila[59] == null ? "" : p_fila[59];
		l_res.m_uI_Enc_Descripcio_1 = p_fila[60] == null ? "" : p_fila[60];
		l_res.m_uI_Enc_Descripcio_2 = p_fila[61] == null ? "" : p_fila[61];
		l_res.m_uI_Enc_Descripcio_3 = p_fila[62] == null ? "" : p_fila[62];
		l_res.m_uI_Enc_Descripcio_4 = p_fila[63] == null ? "" : p_fila[63];
		l_res.m_uI_Enc_Descripcio_M = p_fila[64] == null ? "" : p_fila[64];
		l_res.m_uI_Enc_Observacions_1 = p_fila[65] == null ? "" : p_fila[65];
		l_res.m_uI_Enc_Observacions_2 = p_fila[66] == null ? "" : p_fila[66];
		l_res.m_uI_Enc_Observacions_3 = p_fila[67] == null ? "" : p_fila[67];
		l_res.m_uI_Enc_Observacions_4 = p_fila[68] == null ? "" : p_fila[68];
		l_res.m_uI_Enc_Observacions_M = p_fila[69] == null ? "" : p_fila[69];
		l_res.m_uI_Enc_Personal_1 = p_fila[70] == null ? "" : p_fila[70];
		l_res.m_uI_Enc_Personal_2 = p_fila[71] == null ? "" : p_fila[71];
		l_res.m_uI_Enc_Personal_3 = p_fila[72] == null ? "" : p_fila[72];
		l_res.m_uI_Enc_Personal_4 = p_fila[73] == null ? "" : p_fila[73];
		l_res.m_uI_Enc_Personal_M = p_fila[74] == null ? "" : p_fila[74];
		l_res.m_uI_Enviat_5 = p_fila[75] == null ? false : p_fila[75].equals("1");
		l_res.m_uI_Enc_Data_Inici_5 = p_fila[76] == null ? "" : p_fila[76];
		l_res.m_uI_Enc_Data_Final_5 = p_fila[77] == null ? "" : p_fila[77];
		l_res.m_uI_Enc_Quantitat_5 = p_fila[78] == null ? "" : p_fila[78];
		l_res.m_uI_Enc_NumEtts_5 = p_fila[79] == null ? "" : p_fila[79];
		l_res.m_uI_Enc_Descripcio_5 = p_fila[80] == null ? "" : p_fila[80];
		l_res.m_uI_Enc_Observacions_5 = p_fila[81] == null ? "" : p_fila[81];
		l_res.m_uI_Enc_Personal_5 = p_fila[82] == null ? "" : p_fila[82];
		l_res.m_uI_Info_Final_Entrada = p_fila[83] == null ? false : p_fila[83].equals("1");
		l_res.m_traspasat = p_fila[84] == null ? false : p_fila[84].equals("1");
		l_res.m_uI_Veure_Imprevist = p_fila[85] == null ? false : p_fila[85].equals("1");
		l_res.m_nI_Identificador_Tiratge = p_fila[86] == null ? 0 : Integer.parseInt( p_fila[86] );
		l_res.m_cip3_generat = p_fila[87] == null ? false : p_fila[87].equals("1");
		l_res.m_revisada = p_fila[88] == null ? false : p_fila[88].equals("1");
		l_res.m_quantitat_Total_Incidencies = p_fila[89] == null ? 0 : Integer.parseInt( p_fila[89] );
		l_res.m_temps_Total_Incidencies = p_fila[90] == null ? 0 : Integer.parseInt( p_fila[90] );
		l_res.m_observacio_Revisada = p_fila[91] == null ? false : p_fila[91].equals("1");
		l_res.m_cost_Imprevistos = p_fila[92] == null ? 0 : Double.parseDouble( p_fila[92] );
		l_res.m_bobines_Modificades = p_fila[93] == null ? false : p_fila[93].equals("1");
		l_res.m_visibleAbansCTP = p_fila[94] == null ? false : p_fila[94].equals("1");
		l_res.m_verificaMostres = p_fila[95] == null ? "" : p_fila[95];
		l_res.m_reparteixMostres = p_fila[96] == null ? "" : p_fila[96];
		l_res.m_pendentActualitzarHistoric = p_fila[97] == null ? false : p_fila[97].equals("1");
		l_res.m_observacionsReparteixMostres = p_fila[98] == null ? "" : p_fila[98];
		l_res.m_caraODorsMaquinaFulla = p_fila[99] == null ? "" : p_fila[99];
		l_res.m_numeroCaraODorsMaquinaFulla = p_fila[100] == null ? 0 : Integer.parseInt( p_fila[100] );
		l_res.m_consumPaperMagatzemRealitzat = p_fila[101] == null ? false : p_fila[101].equals("1");
		l_res.m_dataHoraIniciJDF = p_fila[102] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[102]);
		l_res.m_dataHoraFinalJDF = p_fila[103] == null ? null : m_dh.MySQLFormatToCalendarFormat(p_fila[103]);
		l_res.m_datesJDFCalculades = p_fila[104] == null ? false : p_fila[104].equals("1");
		l_res.m_ediIgnorarDesviacioFlejar = p_fila[105] == null ? false : p_fila[105].equals("1");
		l_res.m_ediIgnorarSolapaments = p_fila[106] == null ? false : p_fila[106].equals("1");
		l_res.m_ediIgnorarPreparacioCurta = p_fila[107] == null ? false : p_fila[107].equals("1");
		l_res.m_revisatCostosProduccio = p_fila[108] == null ? false : p_fila[108].equals("1");
		l_res.m_revisorCostosProduccio = p_fila[109] == null ? "" : p_fila[109];

		return l_res;
	}

	public boolean Save( RutesOrdrePNavision p_object )
	{
		int l_resultatSave;
		String l_sentenciaPart1;
		String l_sentenciaPart2;

		m_camps[1][1] = "" + p_object.m_uI_Id_Lin_Ordre_P_Navision;
		m_camps[2][1] = "" + p_object.m_uI_Id_Centre_Maquina;
		m_camps[3][1] = "" + p_object.m_uI_Id_Centre_Treball;
		m_camps[4][1] = p_object.m_nM_Data_Inici_Estimada == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_nM_Data_Inici_Estimada )+ "'";
		m_camps[5][1] = p_object.m_nM_Data_Final_Estimada == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_nM_Data_Final_Estimada )+ "'";
		m_camps[6][1] = p_object.m_uI_Estado == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Estado )+ "'";
		m_camps[7][1] = p_object.m_nI_Descripcion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Descripcion )+ "'";
		m_camps[8][1] = p_object.m_uI_Data_Inici == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Inici )+ "'";
		m_camps[9][1] = p_object.m_uI_Data_Final == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Final )+ "'";
		m_camps[10][1] = p_object.m_nI_Num_Centro_Trabajo == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Centro_Trabajo )+ "'";
		m_camps[11][1] = "" + p_object.m_nI_Num_operacion;
		m_camps[12][1] = p_object.m_nI_Num_operacion_siguiente == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_operacion_siguiente )+ "'";
		m_camps[13][1] = p_object.m_nI_Num_operacion_anterior == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_operacion_anterior )+ "'";
		m_camps[14][1] = p_object.m_nI_Tipo == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Tipo )+ "'";
		m_camps[15][1] = p_object.m_nM_Tiempo_ejecucion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nM_Tiempo_ejecucion )+ "'";
		m_camps[16][1] = p_object.m_nM_Cod_ud_medida_tiempo_ejec == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nM_Cod_ud_medida_tiempo_ejec )+ "'";
		m_camps[17][1] = p_object.m_nI_Num_orden_produccion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_orden_produccion )+ "'";
		m_camps[18][1] = p_object.m_uI_Data_Inici_Pausa == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Inici_Pausa )+ "'";
		m_camps[19][1] = p_object.m_uI_Data_Final_Pausa == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Final_Pausa )+ "'";
		m_camps[20][1] = "" + p_object.m_uI_Durada_Estimada;
		m_camps[21][1] = "" + p_object.m_uI_Durada;
		m_camps[22][1] = "" + p_object.m_uI_Durada_Pausa;
		m_camps[23][1] = "" + p_object.m_uI_Quantitat_Relacionada;
		m_camps[24][1] = p_object.m_uI_Data_Inici_Incidencia == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Inici_Incidencia )+ "'";
		m_camps[25][1] = p_object.m_uI_Data_Final_Incidencia == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Final_Incidencia )+ "'";
		m_camps[26][1] = "" + p_object.m_uI_Durada_Incidencia;
		m_camps[27][1] = p_object.m_uI_Estat_Anterior? "1":"0";
		m_camps[28][1] = p_object.m_uI_Crea_Fitxer_RutaOPh? "1":"0";
		m_camps[29][1] = "" + p_object.m_nI_Num_Ruta;
		m_camps[30][1] = "" + p_object.m_nI_Num_Ruta_Referencia;
		m_camps[31][1] = "" + p_object.m_uI_Ma_Obra;
		m_camps[32][1] = p_object.m_uI_Generar_PDF? "1":"0";
		m_camps[33][1] = p_object.m_uI_PDF_Fet? "1":"0";
		m_camps[34][1] = p_object.m_uI_Data_Final_Real == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_uI_Data_Final_Real )+ "'";
		m_camps[35][1] = p_object.m_uI_Enviat_1? "1":"0";
		m_camps[36][1] = p_object.m_uI_Enviat_2? "1":"0";
		m_camps[37][1] = p_object.m_uI_Enviat_3? "1":"0";
		m_camps[38][1] = p_object.m_uI_Enviat_4? "1":"0";
		m_camps[39][1] = p_object.m_uI_Enviat_M? "1":"0";
		m_camps[40][1] = p_object.m_uI_Enc_Data_Inici_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_1 )+ "'";
		m_camps[41][1] = p_object.m_uI_Enc_Data_Inici_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_2 )+ "'";
		m_camps[42][1] = p_object.m_uI_Enc_Data_Inici_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_3 )+ "'";
		m_camps[43][1] = p_object.m_uI_Enc_Data_Inici_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_4 )+ "'";
		m_camps[44][1] = p_object.m_uI_Enc_Data_Inici_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_M )+ "'";
		m_camps[45][1] = p_object.m_uI_Enc_Data_Final_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_1 )+ "'";
		m_camps[46][1] = p_object.m_uI_Enc_Data_Final_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_2 )+ "'";
		m_camps[47][1] = p_object.m_uI_Enc_Data_Final_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_3 )+ "'";
		m_camps[48][1] = p_object.m_uI_Enc_Data_Final_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_4 )+ "'";
		m_camps[49][1] = p_object.m_uI_Enc_Data_Final_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_M )+ "'";
		m_camps[50][1] = p_object.m_uI_Enc_Quantitat_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_1 )+ "'";
		m_camps[51][1] = p_object.m_uI_Enc_Quantitat_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_2 )+ "'";
		m_camps[52][1] = p_object.m_uI_Enc_Quantitat_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_3 )+ "'";
		m_camps[53][1] = p_object.m_uI_Enc_Quantitat_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_4 )+ "'";
		m_camps[54][1] = p_object.m_uI_Enc_Quantitat_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_M )+ "'";
		m_camps[55][1] = p_object.m_uI_Enc_NumEtts_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_1 )+ "'";
		m_camps[56][1] = p_object.m_uI_Enc_NumEtts_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_2 )+ "'";
		m_camps[57][1] = p_object.m_uI_Enc_NumEtts_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_3 )+ "'";
		m_camps[58][1] = p_object.m_uI_Enc_NumEtts_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_4 )+ "'";
		m_camps[59][1] = p_object.m_uI_Enc_NumEtts_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_M )+ "'";
		m_camps[60][1] = p_object.m_uI_Enc_Descripcio_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_1 )+ "'";
		m_camps[61][1] = p_object.m_uI_Enc_Descripcio_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_2 )+ "'";
		m_camps[62][1] = p_object.m_uI_Enc_Descripcio_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_3 )+ "'";
		m_camps[63][1] = p_object.m_uI_Enc_Descripcio_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_4 )+ "'";
		m_camps[64][1] = p_object.m_uI_Enc_Descripcio_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_M )+ "'";
		m_camps[65][1] = p_object.m_uI_Enc_Observacions_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_1 )+ "'";
		m_camps[66][1] = p_object.m_uI_Enc_Observacions_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_2 )+ "'";
		m_camps[67][1] = p_object.m_uI_Enc_Observacions_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_3 )+ "'";
		m_camps[68][1] = p_object.m_uI_Enc_Observacions_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_4 )+ "'";
		m_camps[69][1] = p_object.m_uI_Enc_Observacions_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_M )+ "'";
		m_camps[70][1] = p_object.m_uI_Enc_Personal_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_1 )+ "'";
		m_camps[71][1] = p_object.m_uI_Enc_Personal_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_2 )+ "'";
		m_camps[72][1] = p_object.m_uI_Enc_Personal_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_3 )+ "'";
		m_camps[73][1] = p_object.m_uI_Enc_Personal_4 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_4 )+ "'";
		m_camps[74][1] = p_object.m_uI_Enc_Personal_M == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_M )+ "'";
		m_camps[75][1] = p_object.m_uI_Enviat_5? "1":"0";
		m_camps[76][1] = p_object.m_uI_Enc_Data_Inici_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Inici_5 )+ "'";
		m_camps[77][1] = p_object.m_uI_Enc_Data_Final_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Data_Final_5 )+ "'";
		m_camps[78][1] = p_object.m_uI_Enc_Quantitat_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Quantitat_5 )+ "'";
		m_camps[79][1] = p_object.m_uI_Enc_NumEtts_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_NumEtts_5 )+ "'";
		m_camps[80][1] = p_object.m_uI_Enc_Descripcio_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Descripcio_5 )+ "'";
		m_camps[81][1] = p_object.m_uI_Enc_Observacions_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Observacions_5 )+ "'";
		m_camps[82][1] = p_object.m_uI_Enc_Personal_5 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Enc_Personal_5 )+ "'";
		m_camps[83][1] = p_object.m_uI_Info_Final_Entrada? "1":"0";
		m_camps[84][1] = p_object.m_traspasat? "1":"0";
		m_camps[85][1] = p_object.m_uI_Veure_Imprevist? "1":"0";
		m_camps[86][1] = "" + p_object.m_nI_Identificador_Tiratge;
		m_camps[87][1] = p_object.m_cip3_generat? "1":"0";
		m_camps[88][1] = p_object.m_revisada? "1":"0";
		m_camps[89][1] = "" + p_object.m_quantitat_Total_Incidencies;
		m_camps[90][1] = "" + p_object.m_temps_Total_Incidencies;
		m_camps[91][1] = p_object.m_observacio_Revisada? "1":"0";
		m_camps[92][1] = "'" + p_object.m_cost_Imprevistos + "'";
		m_camps[93][1] = p_object.m_bobines_Modificades? "1":"0";
		m_camps[94][1] = p_object.m_visibleAbansCTP? "1":"0";
		m_camps[95][1] = p_object.m_verificaMostres == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_verificaMostres )+ "'";
		m_camps[96][1] = p_object.m_reparteixMostres == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_reparteixMostres )+ "'";
		m_camps[97][1] = p_object.m_pendentActualitzarHistoric? "1":"0";
		m_camps[98][1] = p_object.m_observacionsReparteixMostres == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_observacionsReparteixMostres )+ "'";
		m_camps[99][1] = p_object.m_caraODorsMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_caraODorsMaquinaFulla )+ "'";
		m_camps[100][1] = "" + p_object.m_numeroCaraODorsMaquinaFulla;
		m_camps[101][1] = p_object.m_consumPaperMagatzemRealitzat? "1":"0";
		m_camps[102][1] = p_object.m_dataHoraIniciJDF == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_dataHoraIniciJDF )+ "'";
		m_camps[103][1] = p_object.m_dataHoraFinalJDF == null? null: "'" + m_dh.CalendarFormatToMySQLFormat( p_object.m_dataHoraFinalJDF )+ "'";
		m_camps[104][1] = p_object.m_datesJDFCalculades? "1":"0";
		m_camps[105][1] = p_object.m_ediIgnorarDesviacioFlejar? "1":"0";
		m_camps[106][1] = p_object.m_ediIgnorarSolapaments? "1":"0";
		m_camps[107][1] = p_object.m_ediIgnorarPreparacioCurta? "1":"0";
		m_camps[108][1] = p_object.m_revisatCostosProduccio? "1":"0";
		m_camps[109][1] = p_object.m_revisorCostosProduccio == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_revisorCostosProduccio )+ "'";

		l_sentenciaPart1 = "";
		l_sentenciaPart2 = "";
		if(p_object.m_uI_Id_Ruta_Ordre_P_Navision == 0 )
		{
			for(int i = 1; i < m_camps.length; i++ )
			{
				l_sentenciaPart1 += l_sentenciaPart1.length() > 0?",":"";
				l_sentenciaPart1 += m_camps[i][0];

				l_sentenciaPart2 += l_sentenciaPart2.length() > 0?",":"";
				l_sentenciaPart2 +=m_camps[i][1];
			}

			l_resultatSave = m_bdd.executaSQLINSERT( "INSERT INTO rutes_ordre_p_navision (" +l_sentenciaPart1+ ") VALUES (" +l_sentenciaPart2+ ")" );
			p_object.m_uI_Id_Ruta_Ordre_P_Navision = l_resultatSave;
		}
		else
		{
			for( int i = 1; i < m_camps.length; i++ )
			{
				l_sentenciaPart1 += l_sentenciaPart1.length() > 0?",":"";
				l_sentenciaPart1 += m_camps[i][0] +" = "+ m_camps[i][1];
			}

			l_resultatSave = m_bdd.executaSQLUPDATE( "UPDATE rutes_ordre_p_navision SET " +l_sentenciaPart1+" WHERE uI_Id_Ruta_Ordre_P_Navision = " +p_object.m_uI_Id_Ruta_Ordre_P_Navision );
		}

		return l_resultatSave != -1;
	}

	public void Delete( RutesOrdrePNavision p_objectToErase )
	{
		m_bdd.executaSQLDELETE( "DELETE FROM rutes_ordre_p_navision WHERE uI_Id_Ruta_Ordre_P_Navision = " +p_objectToErase.m_uI_Id_Ruta_Ordre_P_Navision );
	}
}
