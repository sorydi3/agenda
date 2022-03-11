package agendaproduccio.models.entitatsbddAgenda.daos;

import connexioBDD.ConnexionsBdd;
import connexioBDD.DataAccessLayer;
import java.util.Vector;

import agendaproduccio.models.entitatsbddAgenda.model.LinOrdrePNavision;

public class LinOrdrePNavisionDAO
{
	private static LinOrdrePNavisionDAO m_singleton;
	private DataAccessLayer m_bdd;
	private String m_sentencia;
	private String[][] m_camps;


	public static LinOrdrePNavisionDAO GetInstance()
	{
		if( m_singleton == null )
		{
			m_singleton = new LinOrdrePNavisionDAO();
		}
		return m_singleton;
	}

	private LinOrdrePNavisionDAO()
	{
		m_bdd = ConnexionsBdd.getInstance().m_bddMySqlControlPlanta;

		m_camps = new String[118][2];
		m_camps[0][0] = "lin_ordre_p_navision.uI_Id_Lin_Ordre_P_Navision";
		m_camps[1][0] = "lin_ordre_p_navision.uI_Id_Ordre_P_Navision";
		m_camps[2][0] = "lin_ordre_p_navision.nI_Estado";
		m_camps[3][0] = "lin_ordre_p_navision.nI_Identificador_Tiratge";
		m_camps[4][0] = "lin_ordre_p_navision.nI_Num_Orden_Produccion";
		m_camps[5][0] = "lin_ordre_p_navision.nI_Num_Linea";
		m_camps[6][0] = "lin_ordre_p_navision.nI_Num_producto";
		m_camps[7][0] = "lin_ordre_p_navision.nI_Cod_variante";
		m_camps[8][0] = "lin_ordre_p_navision.nI_Descripcion";
		m_camps[9][0] = "lin_ordre_p_navision.nI_Descripcion_2";
		m_camps[10][0] = "lin_ordre_p_navision.nI_Cantidad";
		m_camps[11][0] = "lin_ordre_p_navision.nI_Num_Edicion";
		m_camps[12][0] = "lin_ordre_p_navision.nI_Nom_Maquina";
		m_camps[13][0] = "lin_ordre_p_navision.nI_Multiple_Produccio_Plec";
		m_camps[14][0] = "lin_ordre_p_navision.nI_Multiple_Produccio_Maquina";
		m_camps[15][0] = "lin_ordre_p_navision.nI_No_Planes_Totals_Tiratge";
		m_camps[16][0] = "lin_ordre_p_navision.nI_No_Planes_Color_Poss_Tir_4T";
		m_camps[17][0] = "lin_ordre_p_navision.nI_No_Planes_Color_Poss_Tir_2T";
		m_camps[18][0] = "lin_ordre_p_navision.nI_Dist_Color_Tiratge_Nom_Solna";
		m_camps[19][0] = "lin_ordre_p_navision.nI_Dist_Color_Tiratge_Nom_Kba";
		m_camps[20][0] = "lin_ordre_p_navision.uI_Tipus_Tinta";
		m_camps[21][0] = "lin_ordre_p_navision.nI_Format_Tiratge";
		m_camps[22][0] = "lin_ordre_p_navision.nI_Plegat_Tiratge";
		m_camps[23][0] = "lin_ordre_p_navision.nI_Planes_Impreses_Tiratge";
		m_camps[24][0] = "lin_ordre_p_navision.nI_Planes_Reals_Color_Tir_4T";
		m_camps[25][0] = "lin_ordre_p_navision.nI_Planes_Reals_Color_Tir_2T";
		m_camps[26][0] = "lin_ordre_p_navision.nI_Color_Segona_Tinta";
		m_camps[27][0] = "lin_ordre_p_navision.nI_Ordre_Execucio";
		m_camps[28][0] = "lin_ordre_p_navision.nI_Proces_Refinat";
		m_camps[29][0] = "lin_ordre_p_navision.nI_Trama_Filmacio";
		m_camps[30][0] = "lin_ordre_p_navision.nI_Codigo_Papel_Bobina_Entera_1";
		m_camps[31][0] = "lin_ordre_p_navision.nI_Desc_Papel_Bobina_Entera_1";
		m_camps[32][0] = "lin_ordre_p_navision.nI_Desc2_Papel_Bobina_Entera_1";
		m_camps[33][0] = "lin_ordre_p_navision.nI_Grm_Papel_Bobina_Entera_1";
		m_camps[34][0] = "lin_ordre_p_navision.nI_Ancho_Papel_Bobina_Entera_1";
		m_camps[35][0] = "lin_ordre_p_navision.nI_Calidad_Ppel_Bobina_Entera_1";
		m_camps[36][0] = "lin_ordre_p_navision.nI_Kg_Papel_Bobina_Entera_1";
		m_camps[37][0] = "lin_ordre_p_navision.nI_Marca_Papel_Bobina_Entera_1";
		m_camps[38][0] = "lin_ordre_p_navision.nI_Tipus_Papel_Bobina_Entera_1";
		m_camps[39][0] = "lin_ordre_p_navision.nI_Codigo_Papel_Bobina_Entera_2";
		m_camps[40][0] = "lin_ordre_p_navision.nI_Desc_Papel_Bobina_Entera_2";
		m_camps[41][0] = "lin_ordre_p_navision.nI_Desc2_Papel_Bobina_Entera_2";
		m_camps[42][0] = "lin_ordre_p_navision.nI_Grm_Papel_Bobina_Entera_2";
		m_camps[43][0] = "lin_ordre_p_navision.nI_Ancho_Papel_Bobina_Entera_2";
		m_camps[44][0] = "lin_ordre_p_navision.nI_Calidad_Ppel_Bobina_Entera_2";
		m_camps[45][0] = "lin_ordre_p_navision.nI_Kg_Papel_Bobina_Entera_2";
		m_camps[46][0] = "lin_ordre_p_navision.nI_Marca_Papel_Bobina_Entera_2";
		m_camps[47][0] = "lin_ordre_p_navision.nI_Tipus_Papel_Bobina_Entera_2";
		m_camps[48][0] = "lin_ordre_p_navision.nI_Codigo_Papel_Bobina_Entera_3";
		m_camps[49][0] = "lin_ordre_p_navision.nI_Desc_Papel_Bobina_Entera_3";
		m_camps[50][0] = "lin_ordre_p_navision.nI_Desc2_Papel_Bobina_Entera_3";
		m_camps[51][0] = "lin_ordre_p_navision.nI_Grm_Papel_Bobina_Entera_3";
		m_camps[52][0] = "lin_ordre_p_navision.nI_Ancho_Papel_Bobina_Entera_3";
		m_camps[53][0] = "lin_ordre_p_navision.nI_Calidad_Ppel_Bobina_Entera_3";
		m_camps[54][0] = "lin_ordre_p_navision.nI_Kg_Papel_Bobina_Entera_3";
		m_camps[55][0] = "lin_ordre_p_navision.nI_Marca_Papel_Bobina_Entera_3";
		m_camps[56][0] = "lin_ordre_p_navision.nI_Tipus_Papel_Bobina_Entera_3";
		m_camps[57][0] = "lin_ordre_p_navision.nI_Codigo_Papel_Media_Bobina";
		m_camps[58][0] = "lin_ordre_p_navision.nI_Desc_Papel_Media_Bobina";
		m_camps[59][0] = "lin_ordre_p_navision.nI_Desc2_Papel_Media_Bobina";
		m_camps[60][0] = "lin_ordre_p_navision.nI_Grm_Papel_Media_Bobina";
		m_camps[61][0] = "lin_ordre_p_navision.nI_Ancho_Papel_Media_Bobina";
		m_camps[62][0] = "lin_ordre_p_navision.nI_Calidad_Ppel_Media_Bobina";
		m_camps[63][0] = "lin_ordre_p_navision.nI_Kg_Papel_Media_Bobina";
		m_camps[64][0] = "lin_ordre_p_navision.nI_Marca_Papel_Media_Bobina";
		m_camps[65][0] = "lin_ordre_p_navision.nI_Tipus_Papel_Media_Bobina";
		m_camps[66][0] = "lin_ordre_p_navision.nM_Exemplars_Guardar_PSF";
		m_camps[67][0] = "lin_ordre_p_navision.nI_Cod_Unidad_Medida";
		m_camps[68][0] = "lin_ordre_p_navision.nM_Exemplars_Bons_Afegir";
		m_camps[69][0] = "lin_ordre_p_navision.nI_Num_Planes_Bobina_Entera_1";
		m_camps[70][0] = "lin_ordre_p_navision.nI_Num_Planes_Bobina_Entera_2";
		m_camps[71][0] = "lin_ordre_p_navision.nI_Num_Planes_Bobina_Entera_3";
		m_camps[72][0] = "lin_ordre_p_navision.nI_Num_Planes_Media_Bobina";
		m_camps[73][0] = "lin_ordre_p_navision.nI_Codi_Categoria_Producto";
		m_camps[74][0] = "lin_ordre_p_navision.nI_Codi_Grup_Producto";
		m_camps[75][0] = "lin_ordre_p_navision.nI_Num_Linea_Pedido";
		m_camps[76][0] = "lin_ordre_p_navision.planificat";
		m_camps[77][0] = "lin_ordre_p_navision.dataEntregaManipuladorExtern";
		m_camps[78][0] = "lin_ordre_p_navision.mida_Pagina";
		m_camps[79][0] = "lin_ordre_p_navision.encolat_Linia";
		m_camps[80][0] = "lin_ordre_p_navision.tallat_Linia";
		m_camps[81][0] = "lin_ordre_p_navision.planificat_Manipulat_Extern";
		m_camps[82][0] = "lin_ordre_p_navision.tipusLinia";
		m_camps[83][0] = "lin_ordre_p_navision.lANImpressioExterior";
		m_camps[84][0] = "lin_ordre_p_navision.pendentActualitzarHistoric";
		m_camps[85][0] = "lin_ordre_p_navision.midaPestanya";
		m_camps[86][0] = "lin_ordre_p_navision.tipusProducteMaquinaFulla";
		m_camps[87][0] = "lin_ordre_p_navision.midaFullaMaquinaFulla";
		m_camps[88][0] = "lin_ordre_p_navision.exemplarsPerFullaMaquinaFulla";
		m_camps[89][0] = "lin_ordre_p_navision.acabat1MaquinaFulla";
		m_camps[90][0] = "lin_ordre_p_navision.acabat2MaquinaFulla";
		m_camps[91][0] = "lin_ordre_p_navision.acabat3MaquinaFulla";
		m_camps[92][0] = "lin_ordre_p_navision.pantone1MaquinaFulla";
		m_camps[93][0] = "lin_ordre_p_navision.pantone2MaquinaFulla";
		m_camps[94][0] = "lin_ordre_p_navision.codiPaperMaquinaFulla";
		m_camps[95][0] = "lin_ordre_p_navision.marcaPaperMaquinaFulla";
		m_camps[96][0] = "lin_ordre_p_navision.caraODorsMaquinaFulla";
		m_camps[97][0] = "lin_ordre_p_navision.qualitatPaperMaquinaFulla";
		m_camps[98][0] = "lin_ordre_p_navision.gramatgePaperMaquinaFulla";
		m_camps[99][0] = "lin_ordre_p_navision.numeroCaraODorsMaquinaFulla";
		m_camps[100][0] = "lin_ordre_p_navision.nomFeinaMaquinaFulla";
		m_camps[101][0] = "lin_ordre_p_navision.iDsMarcaPaperMaquinaFulla";
		m_camps[102][0] = "lin_ordre_p_navision.nI_IDs_Marca_Papel_Bobina_Entera_1";
		m_camps[103][0] = "lin_ordre_p_navision.nI_IDs_Marca_Papel_Bobina_Entera_2";
		m_camps[104][0] = "lin_ordre_p_navision.nI_IDs_Marca_Papel_Media_Bobina";
		m_camps[105][0] = "lin_ordre_p_navision.totalCaresMaquinaFulla";
		m_camps[106][0] = "lin_ordre_p_navision.totalDorsMaquinaFulla";
		m_camps[107][0] = "lin_ordre_p_navision.consumPaperMagatzemRealitzat";
		m_camps[108][0] = "lin_ordre_p_navision.nI_KgrPaperBobinaSencera";
		m_camps[109][0] = "lin_ordre_p_navision.nI_TotalTorresSencera";
		m_camps[110][0] = "lin_ordre_p_navision.nI_KgrPaperMitjaBobina";
		m_camps[111][0] = "lin_ordre_p_navision.nI_TotalTorresMitja";
		m_camps[112][0] = "lin_ordre_p_navision.fullesNecessariesMaquinaFulla";
		m_camps[113][0] = "lin_ordre_p_navision.mostresClientMaquinaFulla";
		m_camps[114][0] = "lin_ordre_p_navision.mostresRoutageRotimpresMaquinaFulla";
		m_camps[115][0] = "lin_ordre_p_navision.esSegonaPassada";
		m_camps[116][0] = "lin_ordre_p_navision.numeroSegonaPassada";
		m_camps[117][0] = "lin_ordre_p_navision.totalSegonesPassades";

		m_sentencia = "";
		for( int i = 0; i < m_camps.length; i++ )
		{
			m_sentencia += i > 0? ",":"";
			m_sentencia += m_camps[i][0];
		}
	}

	public LinOrdrePNavision Get( int p_id )
	{
		LinOrdrePNavision l_finalResult = null;

		if(m_bdd.executaSQLSELECT( "SELECT " +m_sentencia+ " FROM lin_ordre_p_navision WHERE uI_Id_Lin_Ordre_P_Navision = " +p_id+ " ORDER BY uI_Id_Lin_Ordre_P_Navision ASC ") > 0 )
		{
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			l_finalResult = Fill(l_initialResult[0]);
		}
		return l_finalResult;
	}

	// M�tode generat autom�ticament com a exemple d'una SELECT de m�ltiples files >> Substituir-lo pel primer m�tode d'aquest estil
	public Vector<LinOrdrePNavision> GetUltims10()
	{
		Vector<LinOrdrePNavision> l_vRes = new Vector<>();

		if(m_bdd.executaSQLSELECT( "SELECT " +m_sentencia+ " FROM lin_ordre_p_navision ORDER BY uI_Id_Lin_Ordre_P_Navision DESC LIMIT 10") > 0 )
		{
			String l_initialResult[][] = m_bdd.recuperaSQLSelect();

			for ( int i = 0 ; i < l_initialResult.length ; i++ )
			{
				l_vRes.add( Fill(l_initialResult[i]) );
			}
		}
		return l_vRes;
	}


	private LinOrdrePNavision Fill(String[] p_fila)
	{
		

		LinOrdrePNavision l_res = new LinOrdrePNavision();

		l_res.m_uI_Id_Lin_Ordre_P_Navision = p_fila[0] == null ? 0 : Integer.parseInt( p_fila[0] );
		l_res.m_uI_Id_Ordre_P_Navision = p_fila[1] == null ? 0 : Integer.parseInt( p_fila[1] );
		l_res.m_nI_Estado = p_fila[2] == null ? "" : p_fila[2];
		l_res.m_nI_Identificador_Tiratge = p_fila[3] == null ? 0 : Integer.parseInt( p_fila[3] );
		l_res.m_nI_Num_Orden_Produccion = p_fila[4] == null ? "" : p_fila[4];
		l_res.m_nI_Num_Linea = p_fila[5] == null ? "" : p_fila[5];
		l_res.m_nI_Num_producto = p_fila[6] == null ? "" : p_fila[6];
		l_res.m_nI_Cod_variante = p_fila[7] == null ? "" : p_fila[7];
		l_res.m_nI_Descripcion = p_fila[8] == null ? "" : p_fila[8];
		l_res.m_nI_Descripcion_2 = p_fila[9] == null ? "" : p_fila[9];
		l_res.m_nI_Cantidad = p_fila[10] == null ? "" : p_fila[10];
		l_res.m_nI_Num_Edicion = p_fila[11] == null ? "" : p_fila[11];
		l_res.m_nI_Nom_Maquina = p_fila[12] == null ? "" : p_fila[12];
		l_res.m_nI_Multiple_Produccio_Plec = p_fila[13] == null ? "" : p_fila[13];
		l_res.m_nI_Multiple_Produccio_Maquina = p_fila[14] == null ? "" : p_fila[14];
		l_res.m_nI_No_Planes_Totals_Tiratge = p_fila[15] == null ? "" : p_fila[15];
		l_res.m_nI_No_Planes_Color_Poss_Tir_4T = p_fila[16] == null ? "" : p_fila[16];
		l_res.m_nI_No_Planes_Color_Poss_Tir_2T = p_fila[17] == null ? "" : p_fila[17];
		l_res.m_nI_Dist_Color_Tiratge_Nom_Solna = p_fila[18] == null ? "" : p_fila[18];
		l_res.m_nI_Dist_Color_Tiratge_Nom_Kba = p_fila[19] == null ? "" : p_fila[19];
		l_res.m_uI_Tipus_Tinta = p_fila[20] == null ? "" : p_fila[20];
		l_res.m_nI_Format_Tiratge = p_fila[21] == null ? "" : p_fila[21];
		l_res.m_nI_Plegat_Tiratge = p_fila[22] == null ? "" : p_fila[22];
		l_res.m_nI_Planes_Impreses_Tiratge = p_fila[23] == null ? "" : p_fila[23];
		l_res.m_nI_Planes_Reals_Color_Tir_4T = p_fila[24] == null ? "" : p_fila[24];
		l_res.m_nI_Planes_Reals_Color_Tir_2T = p_fila[25] == null ? "" : p_fila[25];
		l_res.m_nI_Color_Segona_Tinta = p_fila[26] == null ? "" : p_fila[26];
		l_res.m_nI_Ordre_Execucio = p_fila[27] == null ? 0 : Integer.parseInt( p_fila[27] );
		l_res.m_nI_Proces_Refinat = p_fila[28] == null ? "" : p_fila[28];
		l_res.m_nI_Trama_Filmacio = p_fila[29] == null ? "" : p_fila[29];
		l_res.m_nI_Codigo_Papel_Bobina_Entera_1 = p_fila[30] == null ? "" : p_fila[30];
		l_res.m_nI_Desc_Papel_Bobina_Entera_1 = p_fila[31] == null ? "" : p_fila[31];
		l_res.m_nI_Desc2_Papel_Bobina_Entera_1 = p_fila[32] == null ? "" : p_fila[32];
		l_res.m_nI_Grm_Papel_Bobina_Entera_1 = p_fila[33] == null ? "" : p_fila[33];
		l_res.m_nI_Ancho_Papel_Bobina_Entera_1 = p_fila[34] == null ? "" : p_fila[34];
		l_res.m_nI_Calidad_Ppel_Bobina_Entera_1 = p_fila[35] == null ? "" : p_fila[35];
		l_res.m_nI_Kg_Papel_Bobina_Entera_1 = p_fila[36] == null ? "" : p_fila[36];
		l_res.m_nI_Marca_Papel_Bobina_Entera_1 = p_fila[37] == null ? "" : p_fila[37];
		l_res.m_nI_Tipus_Papel_Bobina_Entera_1 = p_fila[38] == null ? "" : p_fila[38];
		l_res.m_nI_Codigo_Papel_Bobina_Entera_2 = p_fila[39] == null ? "" : p_fila[39];
		l_res.m_nI_Desc_Papel_Bobina_Entera_2 = p_fila[40] == null ? "" : p_fila[40];
		l_res.m_nI_Desc2_Papel_Bobina_Entera_2 = p_fila[41] == null ? "" : p_fila[41];
		l_res.m_nI_Grm_Papel_Bobina_Entera_2 = p_fila[42] == null ? "" : p_fila[42];
		l_res.m_nI_Ancho_Papel_Bobina_Entera_2 = p_fila[43] == null ? "" : p_fila[43];
		l_res.m_nI_Calidad_Ppel_Bobina_Entera_2 = p_fila[44] == null ? "" : p_fila[44];
		l_res.m_nI_Kg_Papel_Bobina_Entera_2 = p_fila[45] == null ? "" : p_fila[45];
		l_res.m_nI_Marca_Papel_Bobina_Entera_2 = p_fila[46] == null ? "" : p_fila[46];
		l_res.m_nI_Tipus_Papel_Bobina_Entera_2 = p_fila[47] == null ? "" : p_fila[47];
		l_res.m_nI_Codigo_Papel_Bobina_Entera_3 = p_fila[48] == null ? "" : p_fila[48];
		l_res.m_nI_Desc_Papel_Bobina_Entera_3 = p_fila[49] == null ? "" : p_fila[49];
		l_res.m_nI_Desc2_Papel_Bobina_Entera_3 = p_fila[50] == null ? "" : p_fila[50];
		l_res.m_nI_Grm_Papel_Bobina_Entera_3 = p_fila[51] == null ? "" : p_fila[51];
		l_res.m_nI_Ancho_Papel_Bobina_Entera_3 = p_fila[52] == null ? "" : p_fila[52];
		l_res.m_nI_Calidad_Ppel_Bobina_Entera_3 = p_fila[53] == null ? "" : p_fila[53];
		l_res.m_nI_Kg_Papel_Bobina_Entera_3 = p_fila[54] == null ? "" : p_fila[54];
		l_res.m_nI_Marca_Papel_Bobina_Entera_3 = p_fila[55] == null ? "" : p_fila[55];
		l_res.m_nI_Tipus_Papel_Bobina_Entera_3 = p_fila[56] == null ? "" : p_fila[56];
		l_res.m_nI_Codigo_Papel_Media_Bobina = p_fila[57] == null ? "" : p_fila[57];
		l_res.m_nI_Desc_Papel_Media_Bobina = p_fila[58] == null ? "" : p_fila[58];
		l_res.m_nI_Desc2_Papel_Media_Bobina = p_fila[59] == null ? "" : p_fila[59];
		l_res.m_nI_Grm_Papel_Media_Bobina = p_fila[60] == null ? "" : p_fila[60];
		l_res.m_nI_Ancho_Papel_Media_Bobina = p_fila[61] == null ? "" : p_fila[61];
		l_res.m_nI_Calidad_Ppel_Media_Bobina = p_fila[62] == null ? "" : p_fila[62];
		l_res.m_nI_Kg_Papel_Media_Bobina = p_fila[63] == null ? "" : p_fila[63];
		l_res.m_nI_Marca_Papel_Media_Bobina = p_fila[64] == null ? "" : p_fila[64];
		l_res.m_nI_Tipus_Papel_Media_Bobina = p_fila[65] == null ? "" : p_fila[65];
		l_res.m_nM_Exemplars_Guardar_PSF = p_fila[66] == null ? 0 : Integer.parseInt( p_fila[66] );
		l_res.m_nI_Cod_Unidad_Medida = p_fila[67] == null ? "" : p_fila[67];
		l_res.m_nM_Exemplars_Bons_Afegir = p_fila[68] == null ? 0 : Integer.parseInt( p_fila[68] );
		l_res.m_nI_Num_Planes_Bobina_Entera_1 = p_fila[69] == null ? "" : p_fila[69];
		l_res.m_nI_Num_Planes_Bobina_Entera_2 = p_fila[70] == null ? "" : p_fila[70];
		l_res.m_nI_Num_Planes_Bobina_Entera_3 = p_fila[71] == null ? false : p_fila[71].equals("1");
		l_res.m_nI_Num_Planes_Media_Bobina = p_fila[72] == null ? "" : p_fila[72];
		l_res.m_nI_Codi_Categoria_Producto = p_fila[73] == null ? "" : p_fila[73];
		l_res.m_nI_Codi_Grup_Producto = p_fila[74] == null ? "" : p_fila[74];
		l_res.m_nI_Num_Linea_Pedido = p_fila[75] == null ? "" : p_fila[75];
		l_res.m_planificat = p_fila[76] == null ? false : p_fila[76].equals("1");
		l_res.m_dataEntregaManipuladorExtern = p_fila[77] == null ? "" : p_fila[77];
		l_res.m_mida_Pagina = p_fila[78] == null ? "" : p_fila[78];
		l_res.m_encolat_Linia = p_fila[79] == null ? false : p_fila[79].equals("1");
		l_res.m_tallat_Linia = p_fila[80] == null ? false : p_fila[80].equals("1");
		l_res.m_planificat_Manipulat_Extern = p_fila[81] == null ? false : p_fila[81].equals("1");
		l_res.m_tipusLinia = p_fila[82] == null ? "" : p_fila[82];
		l_res.m_lANImpressioExterior = p_fila[83] == null ? "" : p_fila[83];
		l_res.m_pendentActualitzarHistoric = p_fila[84] == null ? false : p_fila[84].equals("1");
		l_res.m_midaPestanya = p_fila[85] == null ? "" : p_fila[85];
		l_res.m_tipusProducteMaquinaFulla = p_fila[86] == null ? "" : p_fila[86];
		l_res.m_midaFullaMaquinaFulla = p_fila[87] == null ? "" : p_fila[87];
		l_res.m_exemplarsPerFullaMaquinaFulla = p_fila[88] == null ? 0 : Integer.parseInt( p_fila[88] );
		l_res.m_acabat1MaquinaFulla = p_fila[89] == null ? "" : p_fila[89];
		l_res.m_acabat2MaquinaFulla = p_fila[90] == null ? "" : p_fila[90];
		l_res.m_acabat3MaquinaFulla = p_fila[91] == null ? "" : p_fila[91];
		l_res.m_pantone1MaquinaFulla = p_fila[92] == null ? "" : p_fila[92];
		l_res.m_pantone2MaquinaFulla = p_fila[93] == null ? "" : p_fila[93];
		l_res.m_codiPaperMaquinaFulla = p_fila[94] == null ? "" : p_fila[94];
		l_res.m_marcaPaperMaquinaFulla = p_fila[95] == null ? "" : p_fila[95];
		l_res.m_caraODorsMaquinaFulla = p_fila[96] == null ? "" : p_fila[96];
		l_res.m_qualitatPaperMaquinaFulla = p_fila[97] == null ? "" : p_fila[97];
		l_res.m_gramatgePaperMaquinaFulla = p_fila[98] == null ? 0 : Double.parseDouble( p_fila[98] );
		l_res.m_numeroCaraODorsMaquinaFulla = p_fila[99] == null ? 0 : Integer.parseInt( p_fila[99] );
		l_res.m_nomFeinaMaquinaFulla = p_fila[100] == null ? "" : p_fila[100];
		l_res.m_iDsMarcaPaperMaquinaFulla = p_fila[101] == null ? "" : p_fila[101];
		l_res.m_nI_IDs_Marca_Papel_Bobina_Entera_1 = p_fila[102] == null ? "" : p_fila[102];
		l_res.m_nI_IDs_Marca_Papel_Bobina_Entera_2 = p_fila[103] == null ? "" : p_fila[103];
		l_res.m_nI_IDs_Marca_Papel_Media_Bobina = p_fila[104] == null ? "" : p_fila[104];
		l_res.m_totalCaresMaquinaFulla = p_fila[105] == null ? 0 : Integer.parseInt( p_fila[105] );
		l_res.m_totalDorsMaquinaFulla = p_fila[106] == null ? 0 : Integer.parseInt( p_fila[106] );
		l_res.m_consumPaperMagatzemRealitzat = p_fila[107] == null ? false : p_fila[107].equals("1");
		l_res.m_nI_KgrPaperBobinaSencera = p_fila[108] == null ? 0 : Integer.parseInt( p_fila[108] );
		l_res.m_nI_TotalTorresSencera = p_fila[109] == null ? 0 : Integer.parseInt( p_fila[109] );
		l_res.m_nI_KgrPaperMitjaBobina = p_fila[110] == null ? 0 : Integer.parseInt( p_fila[110] );
		l_res.m_nI_TotalTorresMitja = p_fila[111] == null ? 0 : Integer.parseInt( p_fila[111] );
		l_res.m_fullesNecessariesMaquinaFulla = p_fila[112] == null ? 0 : Integer.parseInt( p_fila[112] );
		l_res.m_mostresClientMaquinaFulla = p_fila[113] == null ? 0 : Integer.parseInt( p_fila[113] );
		l_res.m_mostresRoutageRotimpresMaquinaFulla = p_fila[114] == null ? 0 : Integer.parseInt( p_fila[114] );
		l_res.m_esSegonaPassada = p_fila[115] == null ? false : p_fila[115].equals("1");
		l_res.m_numeroSegonaPassada = p_fila[116] == null ? 0 : Integer.parseInt( p_fila[116] );
		l_res.m_totalSegonesPassades = p_fila[117] == null ? 0 : Integer.parseInt( p_fila[117] );

		return l_res;
	}

	public boolean Save( LinOrdrePNavision p_object )
	{
		int l_resultatSave;
		String l_sentenciaPart1;
		String l_sentenciaPart2;

		m_camps[1][1] = "" + p_object.m_uI_Id_Ordre_P_Navision;
		m_camps[2][1] = p_object.m_nI_Estado == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Estado )+ "'";
		m_camps[3][1] = "" + p_object.m_nI_Identificador_Tiratge;
		m_camps[4][1] = p_object.m_nI_Num_Orden_Produccion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Orden_Produccion )+ "'";
		m_camps[5][1] = p_object.m_nI_Num_Linea == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Linea )+ "'";
		m_camps[6][1] = p_object.m_nI_Num_producto == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_producto )+ "'";
		m_camps[7][1] = p_object.m_nI_Cod_variante == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Cod_variante )+ "'";
		m_camps[8][1] = p_object.m_nI_Descripcion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Descripcion )+ "'";
		m_camps[9][1] = p_object.m_nI_Descripcion_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Descripcion_2 )+ "'";
		m_camps[10][1] = p_object.m_nI_Cantidad == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Cantidad )+ "'";
		m_camps[11][1] = p_object.m_nI_Num_Edicion == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Edicion )+ "'";
		m_camps[12][1] = p_object.m_nI_Nom_Maquina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Nom_Maquina )+ "'";
		m_camps[13][1] = p_object.m_nI_Multiple_Produccio_Plec == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Multiple_Produccio_Plec )+ "'";
		m_camps[14][1] = p_object.m_nI_Multiple_Produccio_Maquina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Multiple_Produccio_Maquina )+ "'";
		m_camps[15][1] = p_object.m_nI_No_Planes_Totals_Tiratge == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_No_Planes_Totals_Tiratge )+ "'";
		m_camps[16][1] = p_object.m_nI_No_Planes_Color_Poss_Tir_4T == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_No_Planes_Color_Poss_Tir_4T )+ "'";
		m_camps[17][1] = p_object.m_nI_No_Planes_Color_Poss_Tir_2T == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_No_Planes_Color_Poss_Tir_2T )+ "'";
		m_camps[18][1] = p_object.m_nI_Dist_Color_Tiratge_Nom_Solna == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Dist_Color_Tiratge_Nom_Solna )+ "'";
		m_camps[19][1] = p_object.m_nI_Dist_Color_Tiratge_Nom_Kba == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Dist_Color_Tiratge_Nom_Kba )+ "'";
		m_camps[20][1] = p_object.m_uI_Tipus_Tinta == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_uI_Tipus_Tinta )+ "'";
		m_camps[21][1] = p_object.m_nI_Format_Tiratge == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Format_Tiratge )+ "'";
		m_camps[22][1] = p_object.m_nI_Plegat_Tiratge == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Plegat_Tiratge )+ "'";
		m_camps[23][1] = p_object.m_nI_Planes_Impreses_Tiratge == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Planes_Impreses_Tiratge )+ "'";
		m_camps[24][1] = p_object.m_nI_Planes_Reals_Color_Tir_4T == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Planes_Reals_Color_Tir_4T )+ "'";
		m_camps[25][1] = p_object.m_nI_Planes_Reals_Color_Tir_2T == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Planes_Reals_Color_Tir_2T )+ "'";
		m_camps[26][1] = p_object.m_nI_Color_Segona_Tinta == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Color_Segona_Tinta )+ "'";
		m_camps[27][1] = "" + p_object.m_nI_Ordre_Execucio;
		m_camps[28][1] = p_object.m_nI_Proces_Refinat == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Proces_Refinat )+ "'";
		m_camps[29][1] = p_object.m_nI_Trama_Filmacio == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Trama_Filmacio )+ "'";
		m_camps[30][1] = p_object.m_nI_Codigo_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codigo_Papel_Bobina_Entera_1 )+ "'";
		m_camps[31][1] = p_object.m_nI_Desc_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc_Papel_Bobina_Entera_1 )+ "'";
		m_camps[32][1] = p_object.m_nI_Desc2_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc2_Papel_Bobina_Entera_1 )+ "'";
		m_camps[33][1] = p_object.m_nI_Grm_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Grm_Papel_Bobina_Entera_1 )+ "'";
		m_camps[34][1] = p_object.m_nI_Ancho_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Ancho_Papel_Bobina_Entera_1 )+ "'";
		m_camps[35][1] = p_object.m_nI_Calidad_Ppel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Calidad_Ppel_Bobina_Entera_1 )+ "'";
		m_camps[36][1] = p_object.m_nI_Kg_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Kg_Papel_Bobina_Entera_1 )+ "'";
		m_camps[37][1] = p_object.m_nI_Marca_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Marca_Papel_Bobina_Entera_1 )+ "'";
		m_camps[38][1] = p_object.m_nI_Tipus_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Tipus_Papel_Bobina_Entera_1 )+ "'";
		m_camps[39][1] = p_object.m_nI_Codigo_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codigo_Papel_Bobina_Entera_2 )+ "'";
		m_camps[40][1] = p_object.m_nI_Desc_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc_Papel_Bobina_Entera_2 )+ "'";
		m_camps[41][1] = p_object.m_nI_Desc2_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc2_Papel_Bobina_Entera_2 )+ "'";
		m_camps[42][1] = p_object.m_nI_Grm_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Grm_Papel_Bobina_Entera_2 )+ "'";
		m_camps[43][1] = p_object.m_nI_Ancho_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Ancho_Papel_Bobina_Entera_2 )+ "'";
		m_camps[44][1] = p_object.m_nI_Calidad_Ppel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Calidad_Ppel_Bobina_Entera_2 )+ "'";
		m_camps[45][1] = p_object.m_nI_Kg_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Kg_Papel_Bobina_Entera_2 )+ "'";
		m_camps[46][1] = p_object.m_nI_Marca_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Marca_Papel_Bobina_Entera_2 )+ "'";
		m_camps[47][1] = p_object.m_nI_Tipus_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Tipus_Papel_Bobina_Entera_2 )+ "'";
		m_camps[48][1] = p_object.m_nI_Codigo_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codigo_Papel_Bobina_Entera_3 )+ "'";
		m_camps[49][1] = p_object.m_nI_Desc_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc_Papel_Bobina_Entera_3 )+ "'";
		m_camps[50][1] = p_object.m_nI_Desc2_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc2_Papel_Bobina_Entera_3 )+ "'";
		m_camps[51][1] = p_object.m_nI_Grm_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Grm_Papel_Bobina_Entera_3 )+ "'";
		m_camps[52][1] = p_object.m_nI_Ancho_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Ancho_Papel_Bobina_Entera_3 )+ "'";
		m_camps[53][1] = p_object.m_nI_Calidad_Ppel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Calidad_Ppel_Bobina_Entera_3 )+ "'";
		m_camps[54][1] = p_object.m_nI_Kg_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Kg_Papel_Bobina_Entera_3 )+ "'";
		m_camps[55][1] = p_object.m_nI_Marca_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Marca_Papel_Bobina_Entera_3 )+ "'";
		m_camps[56][1] = p_object.m_nI_Tipus_Papel_Bobina_Entera_3 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Tipus_Papel_Bobina_Entera_3 )+ "'";
		m_camps[57][1] = p_object.m_nI_Codigo_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codigo_Papel_Media_Bobina )+ "'";
		m_camps[58][1] = p_object.m_nI_Desc_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc_Papel_Media_Bobina )+ "'";
		m_camps[59][1] = p_object.m_nI_Desc2_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Desc2_Papel_Media_Bobina )+ "'";
		m_camps[60][1] = p_object.m_nI_Grm_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Grm_Papel_Media_Bobina )+ "'";
		m_camps[61][1] = p_object.m_nI_Ancho_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Ancho_Papel_Media_Bobina )+ "'";
		m_camps[62][1] = p_object.m_nI_Calidad_Ppel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Calidad_Ppel_Media_Bobina )+ "'";
		m_camps[63][1] = p_object.m_nI_Kg_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Kg_Papel_Media_Bobina )+ "'";
		m_camps[64][1] = p_object.m_nI_Marca_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Marca_Papel_Media_Bobina )+ "'";
		m_camps[65][1] = p_object.m_nI_Tipus_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Tipus_Papel_Media_Bobina )+ "'";
		m_camps[66][1] = "" + p_object.m_nM_Exemplars_Guardar_PSF;
		m_camps[67][1] = p_object.m_nI_Cod_Unidad_Medida == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Cod_Unidad_Medida )+ "'";
		m_camps[68][1] = "" + p_object.m_nM_Exemplars_Bons_Afegir;
		m_camps[69][1] = p_object.m_nI_Num_Planes_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Planes_Bobina_Entera_1 )+ "'";
		m_camps[70][1] = p_object.m_nI_Num_Planes_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Planes_Bobina_Entera_2 )+ "'";
		m_camps[71][1] = p_object.m_nI_Num_Planes_Bobina_Entera_3? "1":"0";
		m_camps[72][1] = p_object.m_nI_Num_Planes_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Planes_Media_Bobina )+ "'";
		m_camps[73][1] = p_object.m_nI_Codi_Categoria_Producto == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codi_Categoria_Producto )+ "'";
		m_camps[74][1] = p_object.m_nI_Codi_Grup_Producto == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Codi_Grup_Producto )+ "'";
		m_camps[75][1] = p_object.m_nI_Num_Linea_Pedido == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_Num_Linea_Pedido )+ "'";
		m_camps[76][1] = p_object.m_planificat? "1":"0";
		m_camps[77][1] = p_object.m_dataEntregaManipuladorExtern == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_dataEntregaManipuladorExtern )+ "'";
		m_camps[78][1] = p_object.m_mida_Pagina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_mida_Pagina )+ "'";
		m_camps[79][1] = p_object.m_encolat_Linia? "1":"0";
		m_camps[80][1] = p_object.m_tallat_Linia? "1":"0";
		m_camps[81][1] = p_object.m_planificat_Manipulat_Extern? "1":"0";
		m_camps[82][1] = p_object.m_tipusLinia == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_tipusLinia )+ "'";
		m_camps[83][1] = p_object.m_lANImpressioExterior == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_lANImpressioExterior )+ "'";
		m_camps[84][1] = p_object.m_pendentActualitzarHistoric? "1":"0";
		m_camps[85][1] = p_object.m_midaPestanya == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_midaPestanya )+ "'";
		m_camps[86][1] = p_object.m_tipusProducteMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_tipusProducteMaquinaFulla )+ "'";
		m_camps[87][1] = p_object.m_midaFullaMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_midaFullaMaquinaFulla )+ "'";
		m_camps[88][1] = "" + p_object.m_exemplarsPerFullaMaquinaFulla;
		m_camps[89][1] = p_object.m_acabat1MaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_acabat1MaquinaFulla )+ "'";
		m_camps[90][1] = p_object.m_acabat2MaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_acabat2MaquinaFulla )+ "'";
		m_camps[91][1] = p_object.m_acabat3MaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_acabat3MaquinaFulla )+ "'";
		m_camps[92][1] = p_object.m_pantone1MaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_pantone1MaquinaFulla )+ "'";
		m_camps[93][1] = p_object.m_pantone2MaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_pantone2MaquinaFulla )+ "'";
		m_camps[94][1] = p_object.m_codiPaperMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_codiPaperMaquinaFulla )+ "'";
		m_camps[95][1] = p_object.m_marcaPaperMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_marcaPaperMaquinaFulla )+ "'";
		m_camps[96][1] = p_object.m_caraODorsMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_caraODorsMaquinaFulla )+ "'";
		m_camps[97][1] = p_object.m_qualitatPaperMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_qualitatPaperMaquinaFulla )+ "'";
		m_camps[98][1] = "'" + p_object.m_gramatgePaperMaquinaFulla + "'";
		m_camps[99][1] = "" + p_object.m_numeroCaraODorsMaquinaFulla;
		m_camps[100][1] = p_object.m_nomFeinaMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nomFeinaMaquinaFulla )+ "'";
		m_camps[101][1] = p_object.m_iDsMarcaPaperMaquinaFulla == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_iDsMarcaPaperMaquinaFulla )+ "'";
		m_camps[102][1] = p_object.m_nI_IDs_Marca_Papel_Bobina_Entera_1 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_IDs_Marca_Papel_Bobina_Entera_1 )+ "'";
		m_camps[103][1] = p_object.m_nI_IDs_Marca_Papel_Bobina_Entera_2 == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_IDs_Marca_Papel_Bobina_Entera_2 )+ "'";
		m_camps[104][1] = p_object.m_nI_IDs_Marca_Papel_Media_Bobina == null? null: "'" + m_bdd.PrepararStringPerBaseDeDades( p_object.m_nI_IDs_Marca_Papel_Media_Bobina )+ "'";
		m_camps[105][1] = "" + p_object.m_totalCaresMaquinaFulla;
		m_camps[106][1] = "" + p_object.m_totalDorsMaquinaFulla;
		m_camps[107][1] = p_object.m_consumPaperMagatzemRealitzat? "1":"0";
		m_camps[108][1] = "" + p_object.m_nI_KgrPaperBobinaSencera;
		m_camps[109][1] = "" + p_object.m_nI_TotalTorresSencera;
		m_camps[110][1] = "" + p_object.m_nI_KgrPaperMitjaBobina;
		m_camps[111][1] = "" + p_object.m_nI_TotalTorresMitja;
		m_camps[112][1] = "" + p_object.m_fullesNecessariesMaquinaFulla;
		m_camps[113][1] = "" + p_object.m_mostresClientMaquinaFulla;
		m_camps[114][1] = "" + p_object.m_mostresRoutageRotimpresMaquinaFulla;
		m_camps[115][1] = p_object.m_esSegonaPassada? "1":"0";
		m_camps[116][1] = "" + p_object.m_numeroSegonaPassada;
		m_camps[117][1] = "" + p_object.m_totalSegonesPassades;

		l_sentenciaPart1 = "";
		l_sentenciaPart2 = "";
		if(p_object.m_uI_Id_Lin_Ordre_P_Navision == 0 )
		{
			for(int i = 1; i < m_camps.length; i++ )
			{
				l_sentenciaPart1 += l_sentenciaPart1.length() > 0?",":"";
				l_sentenciaPart1 += m_camps[i][0];

				l_sentenciaPart2 += l_sentenciaPart2.length() > 0?",":"";
				l_sentenciaPart2 +=m_camps[i][1];
			}

			l_resultatSave = m_bdd.executaSQLINSERT( "INSERT INTO lin_ordre_p_navision (" +l_sentenciaPart1+ ") VALUES (" +l_sentenciaPart2+ ")" );
			p_object.m_uI_Id_Lin_Ordre_P_Navision = l_resultatSave;
		}
		else
		{
			for( int i = 1; i < m_camps.length; i++ )
			{
				l_sentenciaPart1 += l_sentenciaPart1.length() > 0?",":"";
				l_sentenciaPart1 += m_camps[i][0] +" = "+ m_camps[i][1];
			}

			l_resultatSave = m_bdd.executaSQLUPDATE( "UPDATE lin_ordre_p_navision SET " +l_sentenciaPart1+" WHERE uI_Id_Lin_Ordre_P_Navision = " +p_object.m_uI_Id_Lin_Ordre_P_Navision );
		}

		return l_resultatSave != -1;
	}

	public void Delete( LinOrdrePNavision p_objectToErase )
	{
		m_bdd.executaSQLDELETE( "DELETE FROM lin_ordre_p_navision WHERE uI_Id_Lin_Ordre_P_Navision = " +p_objectToErase.m_uI_Id_Lin_Ordre_P_Navision );
	}
}
