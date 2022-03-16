package agendaproduccio.models.fitxatecnica.dao;

import java.util.Vector;

import agendaproduccio.models.fitxatecnica.model.LiniaProduccioFitxaTecnica;
import agendaproduccio.models.fitxatecnica.model.OrdreProduccioFitxaTecnica;
import connexioBDD.ConnexionsBdd;
import connexioBDD.DataAccessLayer;

public class LiniaProduccioFitxaTecnicaDAO {
	private static LiniaProduccioFitxaTecnicaDAO m_singleton;

	private DataAccessLayer m_bddCP;

	private String m_sentenciaLiniaCP;

	public static LiniaProduccioFitxaTecnicaDAO GetInstance() {
		if (m_singleton == null) {
			m_singleton = new LiniaProduccioFitxaTecnicaDAO();
		}

		return m_singleton;
	}

	private LiniaProduccioFitxaTecnicaDAO() {
		m_bddCP = ConnexionsBdd.getInstance().m_bddMySqlControlPlanta;

		String l_campsLiniaCP[] = new String[48];
		l_campsLiniaCP[0] = "NI_Identificador_Tiratge";
		l_campsLiniaCP[1] = "TipusLinia";
		l_campsLiniaCP[2] = "NI_No_Planes_Totals_Tiratge";
		l_campsLiniaCP[3] = "Mida_Pagina";
		l_campsLiniaCP[4] = "NI_Format_Tiratge";
		l_campsLiniaCP[5] = "NI_Plegat_Tiratge";
		l_campsLiniaCP[6] = "NI_Nom_Maquina";
		l_campsLiniaCP[7] = "NI_Descripcion_2";
		l_campsLiniaCP[8] = "NI_Planes_Impreses_Tiratge";
		l_campsLiniaCP[9] = "NI_Proces_Refinat";
		l_campsLiniaCP[10] = "(NI_Cantidad * 1000)";
		l_campsLiniaCP[11] = "NM_Exemplars_Bons_Afegir";
		l_campsLiniaCP[12] = "NM_Exemplars_Guardar_PSF";
		l_campsLiniaCP[13] = "NI_Tipus_Papel_Bobina_Entera_1";// "NI_Codigo_Papel_Bobina_Entera_1";
		l_campsLiniaCP[14] = "NI_Marca_Papel_Bobina_Entera_1";
		l_campsLiniaCP[15] = "NI_Tipus_Papel_Media_Bobina";// "NI_Codigo_Papel_Media_Bobina";
		l_campsLiniaCP[16] = "NI_Marca_Papel_Media_Bobina";
		l_campsLiniaCP[17] = "Encolat_Linia";
		l_campsLiniaCP[18] = "Tallat_Linia";
		l_campsLiniaCP[19] = "NI_CODI_GRUP_PRODUCTO";
		l_campsLiniaCP[20] = "NI_Descripcion";
		l_campsLiniaCP[21] = "NI_Num_producto";
		l_campsLiniaCP[22] = "Encolat_Linia";
		l_campsLiniaCP[23] = "Tallat_Linia";
		l_campsLiniaCP[24] = "LANImpressioExterior";
		l_campsLiniaCP[25] = "MidaPestanya";
		l_campsLiniaCP[26] = "TipusProducteMaquinaFulla";
		l_campsLiniaCP[27] = "MidaFullaMaquinaFulla";
		l_campsLiniaCP[28] = "ExemplarsPerFullaMaquinaFulla";
		l_campsLiniaCP[29] = "Acabat1MaquinaFulla";
		l_campsLiniaCP[30] = "Acabat2MaquinaFulla";
		l_campsLiniaCP[31] = "Acabat3MaquinaFulla";
		l_campsLiniaCP[32] = "Pantone1MaquinaFulla";
		l_campsLiniaCP[33] = "Pantone2MaquinaFulla";
		l_campsLiniaCP[34] = "CodiPaperMaquinaFulla";
		l_campsLiniaCP[35] = "MarcaPaperMaquinaFulla";
		l_campsLiniaCP[36] = "CaraODorsMaquinaFulla";
		l_campsLiniaCP[37] = "QualitatPaperMaquinaFulla";
		l_campsLiniaCP[38] = "GramatgePaperMaquinaFulla";
		l_campsLiniaCP[39] = "NumeroCaraODorsMaquinaFulla";
		l_campsLiniaCP[40] = "NomFeinaMaquinaFulla";
		l_campsLiniaCP[41] = "NI_Trama_Filmacio";
		l_campsLiniaCP[42] = "NI_Planes_Reals_Color_Tir_4T";
		l_campsLiniaCP[43] = "NI_Dist_Color_Tiratge_Nom_Solna";
		l_campsLiniaCP[44] = "NI_Grm_Papel_Bobina_Entera_1";
		l_campsLiniaCP[45] = "NI_Ancho_Papel_Bobina_Entera_1";
		l_campsLiniaCP[46] = "NI_Grm_Papel_Media_Bobina";
		l_campsLiniaCP[47] = "NI_Ancho_Papel_Media_Bobina";

		m_sentenciaLiniaCP = "";
		for (int i = 0; i < l_campsLiniaCP.length; i++) {
			m_sentenciaLiniaCP += i > 0 ? "," : "";
			m_sentenciaLiniaCP += l_campsLiniaCP[i];
		}
	}

	public void FillFromCP(OrdreProduccioFitxaTecnica p_ordreProduccio) {
		String l_codiGP;

		Vector<LiniaProduccioFitxaTecnica> l_llistaLiniaTemporal = new Vector<LiniaProduccioFitxaTecnica>();

		p_ordreProduccio.m_llistaLiniaProduccio.removeAllElements();
		if (m_bddCP.executaSQLSELECT("SELECT " + m_sentenciaLiniaCP
				+ " FROM lin_ordre_p_navision WHERE NI_Num_Orden_Produccion = '" + p_ordreProduccio.m_lan
				+ "' AND NI_Codi_Grup_Producto not like 'pr-ar%' and  NI_Codi_Grup_Producto <> 'pr-tdig' and NI_Codi_Grup_Producto <> 'pr-rctp' and NI_Codi_Grup_Producto <> 'PR-RECOLL' and NI_Codi_Grup_Producto <> 'PR-IMPREV' and NI_Descripcion not like 'neteja%' ORDER BY NI_Identificador_Tiratge,CaraODorsMaquinaFulla,NumeroCaraODorsMaquinaFulla",
				48) > 0) {
			String l_resultatLinia[][] = m_bddCP.recuperaSQLSelect();

			for (int i = 0; i < l_resultatLinia.length; i++) {
				l_codiGP = l_resultatLinia[i][19];

				if (l_codiGP.equalsIgnoreCase("PR-IMPR")) {
					LiniaProduccioFitxaTecnica l_liniaProduccio = new LiniaProduccioFitxaTecnica();
					l_liniaProduccio.m_idTiratge = Integer.parseInt(l_resultatLinia[i][0]);
					l_liniaProduccio.m_tipusTiratge = l_resultatLinia[i][1] == null ? "" : l_resultatLinia[i][1];
					l_liniaProduccio.m_planesReals = l_resultatLinia[i][2] == null ? "" : l_resultatLinia[i][2];
					l_liniaProduccio.m_midaPagina = l_resultatLinia[i][3] == null ? "" : l_resultatLinia[i][3];
					l_liniaProduccio.m_format = l_resultatLinia[i][4] == null ? "" : l_resultatLinia[i][4];
					l_liniaProduccio.m_plegat = l_resultatLinia[i][5] == null ? "" : l_resultatLinia[i][5];
					l_liniaProduccio.m_maquina = l_resultatLinia[i][6] == null ? "" : l_resultatLinia[i][6];
					l_liniaProduccio.m_plegatKomori = l_resultatLinia[i][7] == null ? "" : l_resultatLinia[i][7];
					l_liniaProduccio.m_planesTiratge = l_resultatLinia[i][8] == null ? "" : l_resultatLinia[i][8];
					l_liniaProduccio.m_pestanya = l_resultatLinia[i][9] == null ? "" : l_resultatLinia[i][9];
					l_liniaProduccio.m_quantitat = l_resultatLinia[i][10] == null ? "0"
							: "" + (int) (Double.parseDouble(l_resultatLinia[i][10]) + .01);
					l_liniaProduccio.m_bonsAfegir = l_resultatLinia[i][11] == null ? "" : l_resultatLinia[i][11];
					l_liniaProduccio.m_psf = l_resultatLinia[i][12] == null ? "" : l_resultatLinia[i][12];
					l_liniaProduccio.m_tipusPaperSencera = l_resultatLinia[i][13] == null ? "" : l_resultatLinia[i][13];
					l_liniaProduccio.m_marcaPaperSencera = l_resultatLinia[i][14] == null ? "" : l_resultatLinia[i][14];
					l_liniaProduccio.m_tipusPaperMitja = l_resultatLinia[i][15] == null ? "" : l_resultatLinia[i][15];
					l_liniaProduccio.m_marcaPaperMitja = l_resultatLinia[i][16] == null ? "" : l_resultatLinia[i][16];
					l_liniaProduccio.m_encolatEnLinia = l_resultatLinia[i][17].equals("0") ? "" : "SI";
					l_liniaProduccio.m_tallEnLinia = l_resultatLinia[i][18].equals("0") ? "" : "SI";
					l_liniaProduccio.m_codiGrupProducto = l_resultatLinia[i][19] == null ? "" : l_resultatLinia[i][19];
					l_liniaProduccio.m_descripcio = l_resultatLinia[i][20] == null ? "" : l_resultatLinia[i][20];
					l_liniaProduccio.m_codiPR = l_resultatLinia[i][21] == null ? "" : l_resultatLinia[i][21];
					l_liniaProduccio.m_encolatEnLinia = l_resultatLinia[i][22].equals("1") ? "SI" : "";
					l_liniaProduccio.m_tallEnLinia = l_resultatLinia[i][23].equals("1") ? "SI" : "";
					l_liniaProduccio.m_lanImpressioExterior = l_resultatLinia[i][24] == null ? ""
							: l_resultatLinia[i][24];
					l_liniaProduccio.m_midaPestanya = l_resultatLinia[i][25] == null ? "" : l_resultatLinia[i][25];
					l_liniaProduccio.m_tipusProducteMaquinaFulla = l_resultatLinia[i][26] == null ? ""
							: l_resultatLinia[i][26];
					l_liniaProduccio.m_midaFullaMaquinaFulla = l_resultatLinia[i][27] == null ? ""
							: l_resultatLinia[i][27];
					l_liniaProduccio.m_exemplarsPerFullaMaquinaFulla = Integer.parseInt(l_resultatLinia[i][28]);
					l_liniaProduccio.m_acabat1MaquinaFulla = l_resultatLinia[i][29] == null ? ""
							: l_resultatLinia[i][29];
					l_liniaProduccio.m_acabat2MaquinaFulla = l_resultatLinia[i][30] == null ? ""
							: l_resultatLinia[i][30];
					l_liniaProduccio.m_acabat3MaquinaFulla = l_resultatLinia[i][31] == null ? ""
							: l_resultatLinia[i][31];
					l_liniaProduccio.m_pantone1MaquinaFulla = l_resultatLinia[i][32] == null ? ""
							: l_resultatLinia[i][32];
					l_liniaProduccio.m_pantone2MaquinaFulla = l_resultatLinia[i][33] == null ? ""
							: l_resultatLinia[i][33];
					l_liniaProduccio.m_codiPaperMaquinaFulla = l_resultatLinia[i][34] == null ? ""
							: l_resultatLinia[i][34];
					l_liniaProduccio.m_marcaPaperMaquinaFulla = l_resultatLinia[i][35] == null ? ""
							: l_resultatLinia[i][35];
					l_liniaProduccio.m_caraODorsMaquinaFulla = l_resultatLinia[i][36] == null ? ""
							: l_resultatLinia[i][36];
					l_liniaProduccio.m_qualitatPaperMaquinaFulla = l_resultatLinia[i][37] == null ? ""
							: l_resultatLinia[i][37];
					l_liniaProduccio.m_gramatgePaperMaquinaFulla = l_resultatLinia[i][38] == null ? ""
							: l_resultatLinia[i][38];
					l_liniaProduccio.m_numeroCaraODorsMaquinaFulla = l_resultatLinia[i][39] == null ? ""
							: l_resultatLinia[i][39];
					l_liniaProduccio.m_nomFeinaMaquinaFulla = l_resultatLinia[i][40] == null ? ""
							: l_resultatLinia[i][40];
					l_liniaProduccio.m_tramaFilmacio = l_resultatLinia[i][41] == null ? "" : l_resultatLinia[i][41];
					l_liniaProduccio.m_planesColor = l_resultatLinia[i][42] == null ? "" : l_resultatLinia[i][42];
					l_liniaProduccio.m_distribucioColor = l_resultatLinia[i][43] == null ? "" : l_resultatLinia[i][43];
					l_liniaProduccio.m_grmPaperBobinaSencera = l_resultatLinia[i][44] == null ? ""
							: l_resultatLinia[i][44];
					l_liniaProduccio.m_amplePaperBobinaSencera = l_resultatLinia[i][45] == null ? ""
							: l_resultatLinia[i][45];
					l_liniaProduccio.m_grmPaperMitjaBobina = l_resultatLinia[i][46] == null ? ""
							: l_resultatLinia[i][46];
					l_liniaProduccio.m_amplePaperMitjaBobina = l_resultatLinia[i][47] == null ? ""
							: l_resultatLinia[i][47];

					p_ordreProduccio.m_llistaLiniaProduccio.add(l_liniaProduccio);
				} else {
					LiniaProduccioFitxaTecnica l_liniaProduccio = new LiniaProduccioFitxaTecnica();
					l_liniaProduccio.m_idTiratge = Integer.parseInt(l_resultatLinia[i][0]);
					l_liniaProduccio.m_tipusTiratge = l_resultatLinia[i][1] == null ? "" : l_resultatLinia[i][1];
					l_liniaProduccio.m_quantitat = l_resultatLinia[i][10] == null ? "0"
							: "" + (int) (Double.parseDouble(l_resultatLinia[i][10]) + .01);
					l_liniaProduccio.m_codiGrupProducto = l_resultatLinia[i][19] == null ? "" : l_resultatLinia[i][19];
					l_liniaProduccio.m_descripcio = l_resultatLinia[i][20] == null ? "" : l_resultatLinia[i][20];
					l_liniaProduccio.m_codiPR = l_resultatLinia[i][21] == null ? "" : l_resultatLinia[i][21];

					l_llistaLiniaTemporal.add(l_liniaProduccio);
				}
			}

			for (int i = 0; i < l_llistaLiniaTemporal.size(); i++) {
				LiniaProduccioFitxaTecnica l_liniaProduccioTemporal = l_llistaLiniaTemporal.get(i);

				if (l_liniaProduccioTemporal.m_codiGrupProducto.equalsIgnoreCase("PR-GUILL")) {
					if (l_liniaProduccioTemporal.m_idTiratge == 0 || l_liniaProduccioTemporal.m_idTiratge > 70) {
						p_ordreProduccio.m_teGuillotina = true;
					} else {
						for (int x = 0; x < p_ordreProduccio.m_llistaLiniaProduccio.size(); x++) {
							LiniaProduccioFitxaTecnica l_liniaProduccioOriginal = p_ordreProduccio.m_llistaLiniaProduccio
									.get(x);
							if (l_liniaProduccioOriginal.m_idTiratge == l_liniaProduccioTemporal.m_idTiratge) {
								if (l_liniaProduccioOriginal.EsMaquinaPlana()) {
									l_liniaProduccioOriginal.m_guillotina = l_liniaProduccioOriginal
											.RetornaQuantitatAImprimir();// (Integer.parseInt(l_liniaProduccioOriginal.m_quantitat)+Integer.parseInt(l_liniaProduccioOriginal.m_bonsAfegir))+"
																			// ex.
																			// ("+((int)((double)Integer.parseInt(l_liniaProduccioOriginal.m_quantitat+l_liniaProduccioOriginal.m_bonsAfegir)/l_liniaProduccioOriginal.m_exemplarsPerFullaMaquinaFulla))+"
																			// f.)";///l_liniaProduccioTemporal.m_descripcio+"
																			// - "+
																			// l_liniaProduccioTemporal.m_quantitat;
								} else {
									l_liniaProduccioOriginal.m_guillotina = l_liniaProduccioTemporal.m_quantitat
											+ " ex.";
								}
								x = p_ordreProduccio.m_llistaLiniaProduccio.size() + 1;
							}
						}
					}
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-TANCAMENT.DIA")) {
					p_ordreProduccio.m_teTancament = true;
					p_ordreProduccio.m_qTancament = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-ENCART.MAN.")) {
					p_ordreProduccio.m_teEncartManual = true;
					p_ordreProduccio.m_qEncartManual = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-CAIXES")) {
					p_ordreProduccio.m_teCaixes = true;
					p_ordreProduccio.m_qCaixes = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-ENCART.MAQ.")) {
					p_ordreProduccio.m_teEncartMaquina = true;
					p_ordreProduccio.m_qEncartMaquina = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-TREB.EXT.MAN.EST")
						&& l_liniaProduccioTemporal.m_descripcio.equalsIgnoreCase("ROUTAGE")) {
					p_ordreProduccio.m_teRoutageRotimpres = true;
					p_ordreProduccio.m_qRoutageRotimpres = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-FLEJAR")) {
					p_ordreProduccio.m_teFlejar = true;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-TREB.EXT.MAN.EST")
						&& l_liniaProduccioTemporal.m_descripcio.equalsIgnoreCase("EMBOSSAR")) {
					p_ordreProduccio.m_teEmbossar = true;
				} else if (l_liniaProduccioTemporal.m_codiPR.equals("PR-ALÇ.PLEG.1/4")) {
					p_ordreProduccio.m_tePlegat14 = true;
					p_ordreProduccio.m_qPlegat14 = l_liniaProduccioTemporal.m_quantitat;
				} else if (l_liniaProduccioTemporal.m_codiPR.indexOf("PR-DESENC.") != -1) {
					for (int x = 0; x < p_ordreProduccio.m_llistaLiniaProduccio.size(); x++) {
						LiniaProduccioFitxaTecnica l_liniaProduccioOriginal = p_ordreProduccio.m_llistaLiniaProduccio
								.get(x);
						if (l_liniaProduccioOriginal.m_idTiratge == l_liniaProduccioTemporal.m_idTiratge) {
							l_liniaProduccioOriginal.m_desencartar = l_liniaProduccioTemporal.m_quantitat;
							x = p_ordreProduccio.m_llistaLiniaProduccio.size() + 1;
						}
					}
				} else if (l_liniaProduccioTemporal.m_codiGrupProducto.equalsIgnoreCase("PR-ALÇ")
						&& l_liniaProduccioTemporal.m_codiPR.indexOf("PR-AL") != -1) {
					if (l_liniaProduccioTemporal.m_idTiratge == 0 || l_liniaProduccioTemporal.m_idTiratge > 70) {
						if (!p_ordreProduccio.m_teAlcat1) {
							p_ordreProduccio.m_teAlcat1 = true;
							p_ordreProduccio.m_qAlcat1 = l_liniaProduccioTemporal.m_quantitat;
						} else if (!p_ordreProduccio.m_teAlcat2) {
							p_ordreProduccio.m_teAlcat2 = true;
							p_ordreProduccio.m_qAlcat2 = l_liniaProduccioTemporal.m_quantitat;
						}
					} else {
						for (int x = 0; x < p_ordreProduccio.m_llistaLiniaProduccio.size(); x++) {
							LiniaProduccioFitxaTecnica l_liniaProduccioOriginal = p_ordreProduccio.m_llistaLiniaProduccio
									.get(x);
							if (l_liniaProduccioOriginal.m_idTiratge == l_liniaProduccioTemporal.m_idTiratge) {
								l_liniaProduccioOriginal.m_alcar = l_liniaProduccioTemporal.m_quantitat;
								x = p_ordreProduccio.m_llistaLiniaProduccio.size() + 1;
							}
						}
					}
				}
			}
		}

	}

}