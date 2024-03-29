package agendaproduccio.models.fitxatecnica.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FitxaTecnicaHTMLHeidelberg {
	private static FitxaTecnicaHTMLHeidelberg m_singleton;
	String planawebFT = "";
	String planawebDT = "";
	int qttTiratgesMaxim = 3;
	private static final String WIN_ID = "Windows"; // Utilitzat per identificar Microsoft.

	public static FitxaTecnicaHTMLHeidelberg getInstance() {
		if (m_singleton == null) {
			m_singleton = new FitxaTecnicaHTMLHeidelberg();
		}

		return m_singleton;
	}

	public FitxaTecnicaHTMLHeidelberg() {

	}

	public void ActualitzarFitxaTecnica(OrdreProduccioFitxaTecnica p_ordreProduccio) {
		planawebFT = "";
		planawebDT = "";
		escriureTiratgeGeneral(p_ordreProduccio);
		String l_path = "";
		if (isWindowsPlatform())
			l_path = "C:/Temp/";

		try {
			File m_file = new File(l_path + p_ordreProduccio.m_lan + ".html");
			m_file.delete();
			BufferedWriter output = new BufferedWriter(new FileWriter(m_file, true));
			output.write(planawebFT);
			l_path = m_file.getAbsolutePath();
			System.out.println("Path arxiu: " + l_path);
			output.close();

			output = null;
			m_file = null;
		} catch (Exception ex) {
			System.out.println("Ha Fallat el log de Simultaneitat TA!!!" + ex);
		}
		ObrirFirefox obrir = new ObrirFirefox(l_path);

	}

	public static boolean isWindowsPlatform() {
		// M�tode utilitzat dins del creador que serveix per identificar que la
		// plataforma es un windows o un Unix.
		String os = System.getProperty("os.name");
		if (os != null && os.startsWith(WIN_ID))
			return true;
		else
			return false;
	}

	private void escriureTiratgeGeneral(OrdreProduccioFitxaTecnica ordre) {

		String a = "1";
		planawebFT = "<html>";
		planawebFT += "<head>";
		planawebFT += "<title>Fitxa T�cnica de " + ordre.m_nom + "</title>";

		planawebFT += "<table border=\"1\" cellspacing=\"1\" cellpadding=\"0\" bordercolor=\"#ffffff\">";
		planawebFT += "<tr><td colspan=\"8\" bordercolor=\"#000000\" bgcolor=\"#c0c0c0\"><font face=\"Arial\" size=\"3\">Fitxa T�cnica</font></td></tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Nom Cap�alera</font></td>";
		planawebFT += "<td colspan=\"7\" align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"3\">&nbsp;"
				+ ordre.m_nom + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Num. Edici�</font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_numeroEdicio + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\"></font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Quantitat</font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ ordre.m_quanitat + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Quantitat total planes</font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_totalPagines + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\"></font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"></td>";
		planawebFT += "<td align=\"left\"></td>";

		planawebFT += "</tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";

		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Distribuci� de tiratges (publicaci�)</font></td>";
		planawebFT += "<td colspan=\"3\" align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_tiratges + "</font></b></td>";
		planawebFT += "<td align=\"left\" colspan=\"2\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Quantitat total de tiratges</font></td>";
		planawebFT += "<td align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_totalTiratges + "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Enquadernat</font></td>";
		planawebFT += "<td colspan=\"7\" align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_enquadernat + "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Data prevista lliur. originals</font></td>";
		planawebFT += "<td align=\"center\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_dataEntradaFitxersInterior + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Hora</font></td>";
		planawebFT += "<td align=\"center\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_horaEntradaFitxersInterior + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Data prevista lliurament Cobertes</font></td>";
		planawebFT += "<td align=\"center\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_dataEntradaFitxersCoberta + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Hora</font></td>";
		planawebFT += "<td align=\"center\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_horaEntradaFitxersCoberta + "</font></b></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "<td align=\"left\"></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Observacions generals:</font></td>";
		String l_observacions = "";
		if (ordre.m_observacionsGenerals != null) {
			l_observacions = ordre.m_observacionsGenerals.replaceAll("&lt;", "<");
			l_observacions = ordre.m_observacionsGenerals.replaceAll("&gt;", ">");
		} else
			l_observacions = ordre.m_observacionsGenerals = "";
		planawebFT += "<td colspan=\"7\" rowspan=\"4\" bordercolor=\"#000000\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ l_observacions + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";

		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Observacions preimpressi�:</font></td>";
		String observacions_preimpressio = "";
		String pec = "";
		planawebFT += "<td colspan=\"7\" rowspan=\"4\" bordercolor=\"#000000\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ pec + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Observacions encartament:</font></td>";

		String observacions_encartament = "";
		if (ordre.m_observacionsEncarts != null) {
			observacions_encartament = observacions_encartament.replaceAll("&lt;", "<");
			observacions_encartament = observacions_encartament.replaceAll("&gt;", ">");
		}
		planawebFT += "<td colspan=\"7\" rowspan=\"4\" bordercolor=\"#000000\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ observacions_encartament + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td></td></tr>";
		planawebFT += "<tr><td colspan=\"8\"></td></tr>";

		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Guillotina</font></td>";
		String l_guillotina = ordre.RetornaTiratgesAmbGuillotina();
		if (ordre.m_teGuillotina)
			l_guillotina = l_guillotina.equals("") ? "Com�" : l_guillotina + " - Com�";
		if (l_guillotina.equals("")) {
			a = "";
		} else {
			a = "X";
		}
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";
		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;" + l_guillotina
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";
		String l_alcat = ordre.RetornaTiratgesAmbAlcat();
		if ((ordre.m_teAlcat1 || ordre.m_teAlcat2))
			l_alcat = l_alcat.equals("") ? "Com�" : l_alcat + " - Com�";
		if (l_alcat.equals("")) {
			a = "";
		} else {
			a = "X";
		}
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Al�at</font></td>";
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";
		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;" + l_alcat
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";
		String l_encart = "";
		if (ordre.m_teEncartMaquina || ordre.m_teEncartManual) {
			a = "X";
			l_encart = "Com�";
		} else {
			a = "";
		}
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Encart</font></td>";
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";
		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;" + l_encart
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";

		String l_desencartar = ordre.RetornaTiratgesAmbDesencart();

		if (l_desencartar.equals("")) {
			a = "";
		} else {
			a = "X";
		}
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Desencart</font></td>";
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";
		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp;" + l_desencartar
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";
		String l_encolat = "";
		if (!ordre.esEncolatEnLinia()) {
			a = "";
		} else {
			a = "X";
			l_encolat = "Com�";
		}
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Encolat en Lin.</font></td>";
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";

		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp; " + l_encolat
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";
		String l_tallat = "";
		if (!ordre.esTallatEnLinia()) {
			a = "";
		} else {
			a = "X";
			l_tallat = "Com�";
		}
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Tall en Lin.</font></td>";
		planawebFT += "<td align=\"left\"\"><b><font face=\"Arial\" size=\"1\">[" + a + "]</font></b></td>";
		planawebFT += "<td colspan=\"6\" align=\"left\"\"><b><font face=\"Arial\" size=\"1\">&nbsp; " + l_tallat
				+ "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "<tr>";

		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Nom Client CRM: </font></td>";	
		planawebFT += "<td colspan=\"7\" align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_nomClientCRM + "</font></b></td>";
		planawebFT += "</tr>";
		planawebFT += "<tr>";
		planawebFT += "<td align=\"right\"><font face=\"Arial\" size=\"1\">Nom Client Navision: </font></td>";
		planawebFT += "<td colspan=\"7\" align=\"left\" bordercolor=\"#000000\"><b><font face=\"Arial\" size=\"1\">&nbsp;"
				+ ordre.m_NI_Descripcio_Client + "</font></b></td>";
		planawebFT += "</tr>";

		planawebFT += "</table><br>";

		int l_totalTiratges = ordre.retornaTotalTiratgesAMostrar();

		String l_taulaTiratges[][] = new String[l_totalTiratges + 1][17];

		l_taulaTiratges[0][0] = "<html><b></b></html>";
		l_taulaTiratges[0][1] = "<html><b>M�QUINA</b></html>";
		l_taulaTiratges[0][2] = "<html><b>DESCRIPCI�</b></html>";
		l_taulaTiratges[0][3] = "<html><b>TIPUS PRODUCCI�</b></html>";
		l_taulaTiratges[0][4] = "<html><b>P�GINES</b></html>";
		l_taulaTiratges[0][5] = "<html><b>MIDA P�GINA</b></html>";
		l_taulaTiratges[0][6] = "<html><b>PLEGAT</b></html>";
		l_taulaTiratges[0][7] = "<html><b>FOLIACI�</b></html>";
		l_taulaTiratges[0][8] = "<html><b>PESTANYA</b></html>";
		l_taulaTiratges[0][9] = "<html><b>DISTR. COLOR</b></html>";
		l_taulaTiratges[0][10] = "<html><b>PLANES 4T/2T</b></html>";
		l_taulaTiratges[0][11] = "<html><b>ACABATS</b></html>";
		l_taulaTiratges[0][12] = "<html><b>Q. IMPRIMIR</b></html>";
		l_taulaTiratges[0][13] = "<html><b>Q. PSF</b></html>";
		l_taulaTiratges[0][14] = "<html><b>MARCA PAPER 1/1</b></html>";
		l_taulaTiratges[0][15] = "<html><b>MARCA PAPER 1/2</b></html>";
		l_taulaTiratges[0][16] = "<html><b>TRAMA FILMACI�</b></html>";

		int l_tir = 1;
		int l_totalTiratgesPosats = 1;
		int i = 0;
		System.out.println("Total tiratges a posar: " + l_totalTiratges);
		while (i < ordre.m_llistaLiniaProduccio.size()) {
			LiniaProduccioFitxaTecnica l_liniaProduccio = ordre.m_llistaLiniaProduccio.get(i);
			System.out.println("Tiratge " + (i + 1));
			if (l_liniaProduccio.m_idTiratge == l_totalTiratgesPosats) {
				if (l_liniaProduccio.EsMaquinaPlana())// && l_liniaProduccio.m_visualitzar )
				{
					if (ordre.calMostrar(l_liniaProduccio)) {
						String NomFeinaFulla = "";
						if (!l_liniaProduccio.m_nomFeinaMaquinaFulla.equals(""))
							NomFeinaFulla = " - " + l_liniaProduccio.m_nomFeinaMaquinaFulla;
						if (l_liniaProduccio.m_tipusProducteMaquinaFulla.equals("Cara-Dors"))
							l_taulaTiratges[l_tir][0] = "<html><b>Tir." + l_liniaProduccio.m_idTiratge + " "
									+ l_liniaProduccio.m_caraODorsMaquinaFulla + NomFeinaFulla + "</b></html>";
						else
							l_taulaTiratges[l_tir][0] = "<html><b>Tir." + l_liniaProduccio.m_idTiratge + "</b></html>";
						l_taulaTiratges[l_tir][1] = l_liniaProduccio.m_maquina;
						l_taulaTiratges[l_tir][2] = l_liniaProduccio.m_tipusProducteMaquinaFulla;
						l_taulaTiratges[l_tir][3] = l_liniaProduccio.m_exemplarsPerFullaMaquinaFulla + " ex. per fulla";
						l_taulaTiratges[l_tir][4] = l_liniaProduccio.m_planesReals;
						l_taulaTiratges[l_tir][5] = l_liniaProduccio.m_midaPagina;
						l_taulaTiratges[l_tir][6] = l_liniaProduccio.m_plegat;
						l_taulaTiratges[l_tir][7] = l_liniaProduccio.m_planesTiratge;
						l_taulaTiratges[l_tir][8] = l_liniaProduccio.m_pestanya + " " + l_liniaProduccio.m_midaPestanya;
						l_taulaTiratges[l_tir][9] = l_liniaProduccio.m_distribucioColor;
						l_taulaTiratges[l_tir][10] = l_liniaProduccio.m_planesColor;
						l_taulaTiratges[l_tir][11] = l_liniaProduccio.retornaAcabats();
						if (!l_liniaProduccio.retornaPantones().equals(""))
							l_taulaTiratges[l_tir][11] = l_taulaTiratges[l_tir][11].equals("")
									? l_liniaProduccio.retornaPantones()
									: l_taulaTiratges[l_tir][11] + ", " + l_liniaProduccio.retornaPantones();
						l_taulaTiratges[l_tir][12] = l_liniaProduccio.RetornaQuantitatAImprimir();
						l_taulaTiratges[l_tir][13] = l_liniaProduccio.m_psf;
						l_taulaTiratges[l_tir][14] = l_liniaProduccio.retornaDescripcioPaperBobinaSencera() + "_"
								+ l_liniaProduccio.m_marcaPaperMaquinaFulla.toUpperCase();
						;
						l_taulaTiratges[l_tir][15] = "";
						l_taulaTiratges[l_tir][16] = l_liniaProduccio.m_tramaFilmacio;
						l_tir++;
					}
					if (i + 1 < ordre.m_llistaLiniaProduccio.size()) {
						LiniaProduccioFitxaTecnica l_liniaProduccioSeguent = ordre.m_llistaLiniaProduccio.get(i + 1);
						if (l_liniaProduccioSeguent.m_idTiratge > l_liniaProduccio.m_idTiratge)
							l_totalTiratgesPosats++;
					} else
						l_totalTiratgesPosats++;

				} else if (!l_liniaProduccio.EsMaquinaPlana()) {
					l_taulaTiratges[l_tir][0] = "<html><b>Tir." + l_liniaProduccio.m_idTiratge + "</b></html>";
					l_taulaTiratges[l_tir][1] = l_liniaProduccio.m_maquina;
					l_taulaTiratges[l_tir][2] = l_liniaProduccio.m_plegatKomori;
					l_taulaTiratges[l_tir][3] = "";
					l_taulaTiratges[l_tir][4] = l_liniaProduccio.m_planesReals;
					l_taulaTiratges[l_tir][5] = l_liniaProduccio.m_midaPagina;
					l_taulaTiratges[l_tir][6] = l_liniaProduccio.m_plegat;
					l_taulaTiratges[l_tir][7] = l_liniaProduccio.m_planesTiratge;
					l_taulaTiratges[l_tir][8] = l_liniaProduccio.m_pestanya + " " + l_liniaProduccio.m_midaPestanya;
					l_taulaTiratges[l_tir][9] = l_liniaProduccio.m_distribucioColor;
					l_taulaTiratges[l_tir][10] = l_liniaProduccio.m_planesColor;
					l_taulaTiratges[l_tir][11] = l_liniaProduccio.retornaAcabats();
					if (!l_liniaProduccio.retornaPantones().equals(""))
						l_taulaTiratges[l_tir][11] = l_taulaTiratges[l_tir][11].equals("")
								? l_liniaProduccio.retornaPantones()
								: l_taulaTiratges[l_tir][11] + ", " + l_liniaProduccio.retornaPantones();
					l_taulaTiratges[l_tir][12] = l_liniaProduccio.RetornaQuantitatAImprimir();
					l_taulaTiratges[l_tir][13] = l_liniaProduccio.m_psf;
					l_taulaTiratges[l_tir][14] = l_liniaProduccio.retornaDescripcioPaperBobinaSencera() + "_"
							+ l_liniaProduccio.m_marcaPaperSencera.toUpperCase();
					;
					l_taulaTiratges[l_tir][15] = l_liniaProduccio.retornaDescripcioPaperMitjaBobina() + "_"
							+ l_liniaProduccio.m_marcaPaperMitja.toUpperCase();
					;
					l_taulaTiratges[l_tir][16] = l_liniaProduccio.m_tramaFilmacio;
					l_tir++;
					l_totalTiratgesPosats++;
				}
				i++;
			} else {
				l_taulaTiratges[l_tir][0] = "<html><b>Tir." + l_tir + "</b></html>";
				l_taulaTiratges[l_tir][1] = "";
				l_taulaTiratges[l_tir][2] = "";
				l_taulaTiratges[l_tir][3] = "";
				l_taulaTiratges[l_tir][4] = "";
				l_taulaTiratges[l_tir][5] = "";
				l_taulaTiratges[l_tir][6] = "";
				l_taulaTiratges[l_tir][7] = "";
				l_taulaTiratges[l_tir][8] = "";
				l_taulaTiratges[l_tir][9] = "";
				l_taulaTiratges[l_tir][10] = "";
				l_taulaTiratges[l_tir][11] = "";
				l_taulaTiratges[l_tir][12] = "";
				l_taulaTiratges[l_tir][13] = "";
				l_taulaTiratges[l_tir][14] = "";
				l_taulaTiratges[l_tir][15] = "";
				l_taulaTiratges[l_tir][16] = "";
				l_tir++;
				l_totalTiratgesPosats++;
			}

		}

		for (int j = l_tir; j <= l_totalTiratges; j++) {
			l_taulaTiratges[l_tir][0] = "<html><b>Tir." + l_tir + "</b></html>";
			l_taulaTiratges[l_tir][1] = "";
			l_taulaTiratges[l_tir][2] = "";
			l_taulaTiratges[l_tir][3] = "";
			l_taulaTiratges[l_tir][4] = "";
			l_taulaTiratges[l_tir][5] = "";
			l_taulaTiratges[l_tir][6] = "";
			l_taulaTiratges[l_tir][7] = "";
			l_taulaTiratges[l_tir][8] = "";
			l_taulaTiratges[l_tir][9] = "";
			l_taulaTiratges[l_tir][10] = "";
			l_taulaTiratges[l_tir][11] = "";
			l_taulaTiratges[l_tir][12] = "";
			l_taulaTiratges[l_tir][13] = "";
			l_taulaTiratges[l_tir][14] = "";
			l_taulaTiratges[l_tir][15] = "";
			l_taulaTiratges[l_tir][16] = "";
			l_tir++;
			l_totalTiratgesPosats++;
		}

		planawebDT = "";
		int numTir = 1;
		int columna = 1;
		while (l_totalTiratges > 0) {
			if (l_totalTiratges <= qttTiratgesMaxim) {
				System.out.println("Pintem de tiratge " + numTir + " a " + (numTir + l_totalTiratges - 1));
				planawebFT += escriureTiratgeDetallat(numTir, numTir + l_totalTiratges - 1, columna, l_taulaTiratges);
				numTir = numTir + qttTiratgesMaxim + l_totalTiratges;
				l_totalTiratges = 0;
			} else {
				System.out.println("Pintem de tiratge " + numTir + " a " + (numTir + qttTiratgesMaxim - 1));
				planawebFT += escriureTiratgeDetallat(numTir, numTir + qttTiratgesMaxim - 1, columna, l_taulaTiratges);
				numTir = numTir + qttTiratgesMaxim;
				l_totalTiratges = l_totalTiratges - qttTiratgesMaxim;
			}
			columna++;
		}

		planawebFT += "</body></html>";
	}

	private String escriureTiratgeDetallat(int tirInici, int tirFi, int columna, String p_taulaTiratges[][]) {
		System.out.println("Tiratge ini: " + tirInici + " Tiratge fi: " + tirFi + " columna: " + columna);
		planawebDT = "";
		if (columna == 3)
			planawebDT += "<br><br><br><br><br><br><br><br><br><br>";

		planawebDT += "<table width=600 border='1' bordercolor='#000000' cellspacing='0' cellpadding='0'>";
		planawebDT += "<tr>";
		for (int l_camps = 0; l_camps < p_taulaTiratges[0].length; l_camps++) {
			planawebDT += "<td bgcolor='#C0C0C0' WIDTH=150><i><font face='Arial' size=1>" + p_taulaTiratges[0][l_camps]
					+ "</font></i></td>";
			for (int l_tiratge = tirInici; l_tiratge <= tirFi; l_tiratge++) {

				if (l_camps == 0)
					planawebDT += "<td bgcolor='#C0C0C0' WIDTH=100><b><font face='Arial' size=2>"
							+ p_taulaTiratges[l_tiratge][l_camps] + "</font></b></td>";
				else
					planawebDT += "<td WIDTH=150><font face='Arial' size=1>&nbsp;" + p_taulaTiratges[l_tiratge][l_camps]
							+ "</font></td>";
			}
			planawebDT += "</tr>";
		}
		planawebDT += "</table>";
		return (planawebDT);
	}

}