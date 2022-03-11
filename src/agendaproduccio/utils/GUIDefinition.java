package agendaproduccio.utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GUIDefinition
{
	private static GUIDefinition m_singleton;
	public Color m_colorFonsPanellDialog;
	public Color m_colorFonsPanell;
	public Color m_colorBorderPanell;
	public Color m_colorMenuSeleccionat;
	public Color m_colorMenuNoSeleccionat;
	public Color m_colorVerd;
	public Color m_colorVerdClar;
	public Color m_colorVerdBorder;
	public Color m_colorHistoric;
	public Color m_colorFont;
	public Color m_colorGrocClar;
	public Color m_colorGrocFosc;
	public Color m_colorNoSeleccionat;
	public Color m_colorFonsTaula;
	public Color m_colorFilaSeleccionada;
	public Color m_colorFilaSeleccionadaFosc;
	public Color m_colorVermellArxivat = new Color( 255, 179, 179 );

	public Color m_colorVerdClar1 = new Color( 176, 255, 176 );
	public Color m_colorVerdClar2 = new Color( 156, 246, 156 );
	public Color m_colorVerdIntermig = new Color( 100, 255, 100 );
	public Color m_colorVerdFosc = new Color( 50, 150, 50 );

	public Color m_colorVermell = new Color( 255, 0, 0 );
	public Color m_colorVermellClar1 = new Color( 255, 125, 125 );
	public Color m_colorVermellClar2 = new Color( 255, 95, 95 );

	public Color m_colorNegre50;
	public Color m_colorNegre75;
	public Color m_colorGris100;
	public Color m_colorGris130;
	public Color m_colorGris150;
	public Color m_colorGris180;
	public Color m_colorGris200;
	public Color m_colorGris220;
	public Color m_colorGris228;
	public Color m_colorGris230;
	public Color m_colorGris240;
	public Color m_colorBlanc250;
	public Color m_colorBlanc255;

	public ImageIcon m_iconEditar;
	public ImageIcon m_iconEditarUnselected;
	public ImageIcon m_iconEditarBlanc;
	public ImageIcon m_iconPreus;
	public ImageIcon m_iconPreusUnselected;
	public ImageIcon m_iconVerificar;
	public ImageIcon m_iconVerificarUnselected;
	public ImageIcon m_iconVerificar12x12;
	public ImageIcon m_iconVerificarBlau;
	public ImageIcon m_iconEnviar;
	public ImageIcon m_iconEnviarSelected;
	public ImageIcon m_iconEnviarUnselected;
	public ImageIcon m_iconTrucarSelected;
	public ImageIcon m_iconVeure;
	public ImageIcon m_iconVeureUnselected;
	public ImageIcon m_iconVeureBlau;
	public ImageIcon m_iconSettings;
	public ImageIcon m_iconSettingsWhite;
	public ImageIcon m_iconSettings16;
	public ImageIcon m_iconWarning;
	public ImageIcon m_iconWarningBlanc;
	public ImageIcon m_gifWarning;
	public ImageIcon m_iconUp;
	public ImageIcon m_iconDown;
	public ImageIcon m_iconArxiuAdjunt;
	public ImageIcon m_iconDelete;
	public ImageIcon m_iconDeleteVermell;
	public ImageIcon m_iconDeleteVermell10px;
	public ImageIcon m_iconDetails;
	public ImageIcon m_iconDetailUnselected;
	public ImageIcon m_iconDetailsBlau;
	public ImageIcon m_iconaRevista;
	public ImageIcon m_iconaCamio;
	public ImageIcon m_delegarSeguimentPressupost;
	public ImageIcon m_iconNota;
	public ImageIcon m_iconAfegir;
	public ImageIcon m_iconAfegirBlanc;
	public ImageIcon m_iconaUpdate;
	public ImageIcon m_iconEnrrera;
	public ImageIcon m_iconAvancar;
	public ImageIcon m_iconReexpedicio;
	public ImageIcon m_iconDefinicio;
	public ImageIcon m_iconaEsborrarCreu;
	public ImageIcon m_iconaCreuBlanca;
	public ImageIcon m_iconaCheck;
	public ImageIcon m_iconaExclamacioNegre;
	public ImageIcon m_iconCamioPetita;
	public ImageIcon m_iconCamioGran;
	public ImageIcon m_iconCamioGranSeleccionat;
	public ImageIcon m_iconOperariProduccioGran;
	public ImageIcon m_iconOperariProduccioGranSeleccionat;
	public ImageIcon m_iconHistoric;
	public ImageIcon m_iconHistoricSeleccionat;
	public ImageIcon m_iconComandaWeb;
	public ImageIcon m_iconPdf;
	public ImageIcon m_iconPdfBlanc;
	public ImageIcon m_anterior;
	public ImageIcon m_seguent;
	public ImageIcon m_festiu;
	public ImageIcon m_calendari;
	public ImageIcon m_calendari1;
	public ImageIcon m_calendari1Blanc;
	public ImageIcon m_afegirPersona;
	public ImageIcon m_iconDesar;
	public ImageIcon m_iconNovaPublicacio;
	public ImageIcon m_iconCercleVerd;
	public ImageIcon m_iconCercleVermell;
	public ImageIcon m_iconWeb;
	public ImageIcon m_iconWebDelete;
	public ImageIcon m_iconPersona32;
	public ImageIcon m_iconPersonaBlack32;
	public ImageIcon m_iconPdfBlack24;
	public ImageIcon m_iconCamio24;
	public ImageIcon m_imgConjuntFitxers;
	public ImageIcon m_iconTlf;
	public ImageIcon m_iconEmail;
	public ImageIcon m_iconComentaris;
	public ImageIcon m_imgTickClicat;
	public ImageIcon m_imgTickDesclicat;
	public ImageIcon img_tickBlau24;
	public ImageIcon m_imgTickVerd24;
	public ImageIcon m_imgCreuVermella24;
	public ImageIcon m_imgAvisGroc;
	public ImageIcon m_imgAvisVermell;
	public ImageIcon m_imgAvisVermell24;
	public ImageIcon m_imgAvisVermellClar;
	public ImageIcon m_imgEditarN50;
	public ImageIcon m_imgDesarHardDisc32;
	public ImageIcon m_imgDesarHardDiscBlanc32;
	public ImageIcon m_imgRetrocedir32;
	public ImageIcon m_imgRetrocedirBlanc32;
	public ImageIcon m_imgArxiuClient;
	public ImageIcon m_imgArxiuPublicacio;
	public ImageIcon m_imgArxiuNou;
	public ImageIcon m_imgObrirNovaPestanya;
	public ImageIcon m_imgFletxaAmunt;
	public ImageIcon m_imgFletxaAvall;
	public ImageIcon img_segonaEdicio;
	public ImageIcon img_segonaEdicioBlanc;
	public ImageIcon img_veureUll;
	public ImageIcon img_veureUllBlanc;
	public ImageIcon img_euroVermell;
	public ImageIcon img_euroVermell16;
	public ImageIcon img_copiar;
	public ImageIcon img_copiarBlanc;
	public ImageIcon img_calendariTic;
	public ImageIcon img_calendariTicBlanc;
	public ImageIcon img_arxivarBlanc;
	public ImageIcon m_iconaContactesNoSeleccionat;
	public ImageIcon m_iconaContactesSeleccionat;
	public ImageIcon m_imgCopiar;
	public ImageIcon m_imgInformacio;
	public ImageIcon m_imgInformacio24;

	public ImageIcon img_configuracioSeleccionat;
	public ImageIcon img_configuracioNoSeleccionat;
	public ImageIcon img_calendariSeleccionat;
	public ImageIcon img_calendariNoSeleccionat;
	public ImageIcon img_refrescar;
	public ImageIcon img_actualitzarSTD;
	public ImageIcon img_actualitzarSTDBlanc;
	public ImageIcon img_personBlack;
	public ImageIcon img_personRed;
	public ImageIcon img_carpetaBlanca;
	public ImageIcon img_carpetaVermella;
	public ImageIcon img_rellotge;
	public ImageIcon img_webPujarBlanc;
	public ImageIcon img_webPujatBlanc;
	public ImageIcon img_webPujarNegre;
	public ImageIcon img_webPujatNegre;
	public ImageIcon img_desplegableBlanc;
	public ImageIcon img_configuracioMailBlanc;
	public ImageIcon img_configuracioMail;
	public ImageIcon img_calendar_selected;
	public ImageIcon img_bloquejat;
	
	// -------- || AGENDA3.0  ---------
	
	public ImageIcon img_xml;
	public ImageIcon img_printer;
	public ImageIcon img_reload;

	// Cursors
	final public Cursor m_cursorEspera = new Cursor( Cursor.WAIT_CURSOR );
	final public Cursor m_cursorDefault = new Cursor( Cursor.DEFAULT_CURSOR );
	final public Cursor m_cursorDit = new Cursor( Cursor.HAND_CURSOR );

	public Font m_fontTitol;
	public Font m_fontNormal;
	public Font m_fontNegreta;
	public Font m_fontNegreta9;
	public Font m_fontNegreta11;
	public Font m_fontNegreta14;
	public Font m_fontNegreta16;
	
	public Font m_fontNegreta13;
	public Font m_fontNegreta12;
	public Font m_fontCursiva;
	public Font m_fontNormal14;
	public Font m_fontNormal12;
	public Font m_fontNormal13;
	public Font m_fontNormal9;
	public Font m_fontNormal10;
	public Font m_fontCursiva13;

	public Font m_fontNegretaGruixuda12;

	public Color m_colorVerdConfirmatPlanificador;
	public Color m_colorVermellPendentPlanificador;

	// Estats planificador
	public Color m_colorPlanificacioNoConfirmada = new Color( 20, 20, 20 );
	public Color m_colorPlanificacioAmbComanda = new Color( 128, 0, 128 );
	public Color m_colorPlanificacioAfegidaManualment = Color.blue;// new Color(135,206,235);
	public Color m_colorPlanificacioPendentDeConfirmar = new Color( 255, 128, 255 );// Color.RED;//new Color(205,92,92);
	public Color m_colorPlanificacioConfirmada = new Color( 31, 110, 66 );// Color.green;//new Color(67,195,94);
	public Color m_colorPlanificacioVariesFeinesMateixDia = new Color( 112, 146, 190 );// Color.orange;

	public Color m_colorPlanificacioFestiuNacional = new Color( 139, 69, 19 ); // Marro
	public Color m_colorPlanificacioFestiuFrances = Color.orange;
	public Color m_colorPlanificacioFestiuNacionaliFrances = Color.red;

	



	public Color m_colorPlanificacioLiniaProducteInterior = new Color( 255, 255, 200 );
	public Color m_colorPlanificacioLiniaProducteCoberta = new Color( 255, 230, 170 );
	public Color m_colorPlanificacioLiniaTransport = new Color( 255, 220, 255 );

	public Color m_colorGris = new Color( 255, 200, 200 );
	public Color m_colorRosaFosc = new Color( 255, 125, 125 );

	public Color m_colorPlanificacioAccioAcabada = Color.LIGHT_GRAY;
	public Color m_colorPlanificacioAccioEngegada = Color.GREEN;
	public Color m_colorPlanificacioAccioIncidencia = Color.RED;
	public Color m_colorPlanificacioAccioPausada = Color.ORANGE;

	public Cursor m_cursorDeplanificarProduccio;
	public Color m_colorBlauClar;
	public Color m_colorBlauClar2;
	public Color m_colorBlauGrisos;
	public Color m_colorNegreBlavos;
	public Icon m_imgRotativa;

	public static GUIDefinition GetInstance()
	{
		if ( m_singleton == null )
		{
			m_singleton = new GUIDefinition( );
		}

		return m_singleton;
	}

	private GUIDefinition()
	{
		m_colorFonsPanellDialog = new Color( 255, 255, 255 );
		m_colorFonsPanell = new Color( 243, 245, 246 );
		m_colorBorderPanell = new Color( 194, 200, 205 );
		m_colorMenuSeleccionat = new Color( 224, 220, 231 );
		m_colorMenuNoSeleccionat = Color.white;
		m_colorVerd = new Color( 67, 195, 94 );
		m_colorVerdClar = new Color( 67, 195, 94, 40 );
		m_colorVerdBorder = new Color( 31, 110, 66 );
		m_colorHistoric = new Color( 136, 142, 148 );
		m_colorFont = new Color( 90, 90, 90 );
		m_colorGrocClar = new Color( 255, 255, 221 );
		m_colorGrocFosc = new Color( 255, 255, 136 );
		m_colorNoSeleccionat = new Color( 61, 65, 69 );
		m_colorFonsTaula = new Color( 243, 245, 246 );
		m_colorFilaSeleccionada = new Color( 125, 191, 235 );
		m_colorFilaSeleccionadaFosc = new Color( 100, 110, 200 );
		m_colorNegre50 = new Color( 50, 50, 50 );
		m_colorNegre75 = new Color( 75, 75, 75 );
		m_colorGris100 = new Color( 100, 100, 100 );
		m_colorGris130 = new Color( 130, 130, 130 );
		m_colorGris150 = new Color( 150, 150, 150 );
		m_colorGris180 = new Color( 180, 180, 180 );
		m_colorGris200 = new Color( 200, 200, 200 );
		m_colorGris220 = new Color( 220, 220, 220 );
		m_colorGris228 = new Color( 228, 228, 228 );
		m_colorGris230 = new Color( 230, 230, 230 );
		m_colorGris240 = new Color( 240, 240, 240 );
		m_colorBlanc250 = new Color( 250, 250, 250 );
		m_colorBlanc255 = new Color( 255, 255, 255 );
		m_colorBlauClar = new Color( 235, 240, 255 );
		m_colorBlauClar2 = new Color( 200, 200, 255 );
		m_colorBlauGrisos = new Color( 220, 220, 235 );
		m_colorNegreBlavos = new Color( 70, 70, 90 );

		m_fontNegretaGruixuda12 = new Font( "Arial Bold", Font.BOLD, 14 ); // BD Cartoon Shout o Arial Black

		m_fontTitol = new Font( "Arial", Font.BOLD, 15 );
		m_fontNormal = new Font( "Arial", Font.PLAIN, 12 );
		m_fontNegreta = new Font( "Arial", Font.BOLD, 12 );
		m_fontNegreta9 = new Font( "Arial", Font.BOLD, 9 );
		m_fontNegreta11 = new Font( "Arial", Font.BOLD, 11 );
		m_fontNegreta14 = new Font( "Arial", Font.BOLD, 14 );
		m_fontNegreta16 = new Font( "Arial", Font.BOLD, 16 );
		// m_fontNegreta18 = new Font("Arial",Font.BOLD,14);
		m_fontNegreta13 = new Font( "Arial", Font.BOLD, 13 );
		m_fontNegreta12 = new Font( "Arial", Font.BOLD, 12 );
		m_fontCursiva = new Font( "Arial", Font.ITALIC, 12 );
		m_fontCursiva13 = new Font( "Arial", Font.ITALIC, 13 );
		m_fontNormal14 = new Font( "Arial", Font.PLAIN, 14 );
		m_fontNormal12 = new Font( "Arial", Font.PLAIN, 12 );
		m_fontNormal13 = new Font( "Arial", Font.PLAIN, 13 );
		m_fontNormal9 = new Font( "Arial", Font.PLAIN, 9 );
		m_fontNormal10 = new Font( "Arial", Font.PLAIN, 10 );

		m_iconEditar = new ImageIcon( "./img/img_editar.png" );
		m_iconEditarUnselected = new ImageIcon( "./img/img_editar_unselected.png" );
		m_iconEditarBlanc = new ImageIcon( "./img/img_editar_blanc.png" );
		m_iconPreus = new ImageIcon( "./img/img_euro.png" );
		m_iconPreusUnselected = new ImageIcon( "./img/img_euro_unselected.png" );
		m_iconVerificar = new ImageIcon( "./img/img_save.png" );
		m_iconVerificar12x12 = new ImageIcon( "./img/img_save_12x12.png" );
		m_iconVerificarUnselected = new ImageIcon( "./img/img_save_unselected.png" );
		m_iconVerificarBlau = new ImageIcon( "./img/img_save_blau.png" );
		m_iconEnviar = new ImageIcon( "./img/img_sobre.png" );
		m_iconEnviarSelected = new ImageIcon( "./img/img_email_selected.png" );
		m_iconEnviarUnselected = new ImageIcon( "./img/img_email_unselected.png" );
		m_iconTrucarSelected = new ImageIcon( "./img/img_trucar_selected.png" );
		m_iconVeure = new ImageIcon( "./img/img_print.png" );
		m_iconVeureUnselected = new ImageIcon( "./img/img_print_unselected.png" );
		m_iconVeureBlau = new ImageIcon( "./img/img_print_blau.png" );
		m_iconSettings = new ImageIcon( "./img/img_settings_black.png" );
		m_iconSettingsWhite = new ImageIcon( "./img/img_configuracio_16_blanc.png" );
		m_iconSettings16 = new ImageIcon( "./img/img_configuracio_16.png" );
		m_iconWarning = new ImageIcon( "./img/img_warning.png" );
		m_iconWarningBlanc = new ImageIcon( "./img/img_warning_blanc.png" );
		m_gifWarning = new ImageIcon( "./img/gif_warning.gif" );
		m_iconUp = new ImageIcon( "./img/img_up.png" );
		m_iconDown = new ImageIcon( "./img/img_down.png" );
		m_iconArxiuAdjunt = new ImageIcon( "./img/img_arxiu_adjunt.png" );
		m_iconDelete = new ImageIcon( "./img/img_paperera2.png" );
		m_iconDeleteVermell = new ImageIcon( "./img/img_delete_vermell.png" );
		m_iconDeleteVermell10px = new ImageIcon( "./img/img_delete_vermell_10.png" );
		m_iconDetails = new ImageIcon( "./img/img_details.png" );
		m_iconDetailUnselected = new ImageIcon( "./img/img_details_unselected.png" );
		m_iconDetailsBlau = new ImageIcon( "./img/img_details_blau.png" );
		m_iconaRevista = new ImageIcon( "./img/img_revista3.png" );
		m_iconaCamio = new ImageIcon( "./img/img_camio.png" );
		m_delegarSeguimentPressupost = new ImageIcon( "./img/img_delegar.png" );
		m_iconNota = new ImageIcon( "./img/img_nota.png" );
		m_iconAfegir = new ImageIcon( "./img/img_add.png" );
		m_iconAfegirBlanc = new ImageIcon( "./img/img_add_blanc.png" );
		m_iconaUpdate = new ImageIcon( "./img/img_update_16.png" );
		m_iconEnrrera = new ImageIcon( "./img/img_enrrera.png" );
		m_iconAvancar = new ImageIcon( "./img/img_avancar.png" );
		m_iconReexpedicio = new ImageIcon( "./img/img_distribution.png" );
		m_iconDefinicio = new ImageIcon( "./img/img_dicionari.png" );
		m_iconaEsborrarCreu = new ImageIcon( "./img/img_delete.png" );
		m_iconaCreuBlanca = new ImageIcon( "./img/img_delete_blanc.png" );
		m_iconaCheck = new ImageIcon( "./img/img_check.png" );
		m_iconaExclamacioNegre = new ImageIcon( "./img/exclamacio_negre.png" );
		m_iconCamioPetita = new ImageIcon( "./img/img_camio_16px.png" );
		m_iconCamioGran = new ImageIcon( "./img/img_camio_32px.png" );
		m_iconCamioGranSeleccionat = new ImageIcon( "./img/img_camioSeleccionat.png" );
		m_iconOperariProduccioGran = new ImageIcon( "./img/img_produccio.png" );
		m_iconOperariProduccioGranSeleccionat = new ImageIcon( "./img/img_produccioSeleccionat.png" );
		m_iconHistoric = new ImageIcon( "./img/img_historic.png" );
		m_iconHistoricSeleccionat = new ImageIcon( "./img/img_historicSeleccionat.png" );
		m_iconComandaWeb = new ImageIcon( "./img/img_comanda_web.png" );
		m_iconPdf = new ImageIcon( "./img/img_pdf.png" );
		m_iconPdfBlanc = new ImageIcon( "./img/img_pdf_blanc.png" );
		m_anterior = new ImageIcon( "./img/img_anterior.png" );
		m_seguent = new ImageIcon( "./img/img_seguent.png" );
		m_festiu = new ImageIcon( "./img/img_festius.png" );
		m_iconDesar = new ImageIcon( "./img/img_save_hard_disc.png" );
		m_iconNovaPublicacio = new ImageIcon( "./img/img_novaPublicacio.png" );
		m_iconCercleVerd = new ImageIcon( "./img/img_cercleVerd.png" );
		m_iconCercleVermell = new ImageIcon( "./img/img_cercleVermell.png" );
		m_iconWeb = new ImageIcon( "./img/img_web.png" );
		m_iconWebDelete = new ImageIcon( "./img/img_web_delete.png" );
		m_iconPersona32 = new ImageIcon( "./img/person_32px.png" );
		m_iconPersonaBlack32 = new ImageIcon( "./img/personblack_32px.png" );
		m_iconPdfBlack24 = new ImageIcon( "./img/pdfblack_24px.png" );
		m_iconCamio24 = new ImageIcon( "./img/camio_24px.png" );
		m_imgConjuntFitxers = new ImageIcon( "./img/img_conjuntFitxers.png" );
		m_iconTlf = new ImageIcon( "./img/img_telefon16.png" );
		m_iconEmail = new ImageIcon( "./img/img_mail16.png" );
		m_iconComentaris = new ImageIcon( "./img/img_comentaris.png" );
		m_imgTickClicat = new ImageIcon( "./img/img_tickClicat.png" );
		m_imgTickDesclicat = new ImageIcon( "./img/img_tickDesclicat.png" );
		img_tickBlau24 = new ImageIcon( "./img/img_tickBlau24.png" );
		m_imgTickVerd24 = new ImageIcon( "./img/img_tickVerd24.png" );
		m_imgCreuVermella24 = new ImageIcon( "./img/img_creuVermella24.png" );
		m_imgAvisGroc = new ImageIcon( "./img/img_avisGroc.png" );
		m_imgAvisVermell = new ImageIcon( "./img/img_avisVermell.png" );
		m_imgAvisVermell24 = new ImageIcon( "./img/img_avisVermell24.png" );
		m_imgAvisVermellClar = new ImageIcon( "./img/img_avisVermellClar.png" );
		m_imgEditarN50 = new ImageIcon( "./img/img_editarN50.png" );
		m_imgDesarHardDisc32 = new ImageIcon( "./img/img_save_hard_disc_32.png" );
		m_imgDesarHardDiscBlanc32 = new ImageIcon( "./img/img_save_hard_disc_blanc_32.png" );
		m_imgRetrocedir32 = new ImageIcon( "./img/img_enrere_32.png" );
		m_imgRetrocedirBlanc32 = new ImageIcon( "./img/img_enrere_blanc_32.png" );
		m_imgArxiuClient = new ImageIcon( "./img/img_arxiu_client.png" );
		m_imgArxiuPublicacio = new ImageIcon( "./img/img_arxiu_publicacio.png" );
		m_imgArxiuNou = new ImageIcon( "./img/img_arxiu_nou.png" );
		m_imgObrirNovaPestanya = new ImageIcon( "./img/img_obrirNovaPestanya.png" );
		m_imgFletxaAmunt = new ImageIcon( "./img/img_fletxaAmunt.png" );
		m_imgFletxaAvall = new ImageIcon( "./img/img_fletxaAvall.png" );
		img_segonaEdicio = new ImageIcon( "./img/img_segonaEdicio.png" );
		img_segonaEdicioBlanc = new ImageIcon( "./img/img_segonaEdicioBlanc.png" );
		img_veureUll = new ImageIcon( "./img/img_veure.png" );
		img_veureUllBlanc = new ImageIcon( "./img/img_veureBlanc.png" );
		img_euroVermell = new ImageIcon( "./img/img_euroVermell.png" );
		img_euroVermell16 = new ImageIcon( "./img/img_euroVermell16.png" );
		img_copiar = new ImageIcon( "./img/img_copiar.png" );
		img_copiarBlanc = new ImageIcon( "./img/img_copiar_blanc.png" );
		img_calendariTic = new ImageIcon( "./img/img_calendariTic.png" );
		img_calendariTicBlanc = new ImageIcon( "./img/img_calendariTicBlanc.png" );
		img_arxivarBlanc = new ImageIcon( "./img/img_arxivar_blanc.png" );
		img_configuracioSeleccionat = new ImageIcon( "./img/img_configuracioSeleccionat.png" );
		img_configuracioNoSeleccionat = new ImageIcon( "./img/img_configuracioNoSeleccionat.png" );
		m_iconaContactesNoSeleccionat = new ImageIcon( "./img/img_contactesNoSeleccionat.png" );
		m_iconaContactesSeleccionat = new ImageIcon( "./img/img_contactesSeleccionat.png" );
		img_calendariSeleccionat = new ImageIcon( "./img/img_calendariSeleccionat.png" );
		img_calendariNoSeleccionat = new ImageIcon( "./img/img_calendariNoSeleccionat.png" );
		img_refrescar = new ImageIcon( "./img/img_refrescar.png" );
		img_actualitzarSTD = new ImageIcon( "./img/img_actualitzarSTD.png" );
		img_actualitzarSTDBlanc = new ImageIcon( "./img/img_actualitzarSTDBlanc.png" );
		img_personBlack = new ImageIcon( "./img/img_person_black.png" );
		img_personRed = new ImageIcon( "./img/img_person_red.png" );
		img_carpetaBlanca = new ImageIcon( "./img/img_carpetaBlanca.png" );
		img_carpetaVermella = new ImageIcon( "./img/img_carpetaVermella.png" );
		img_rellotge = new ImageIcon( "./img/img_rellotge.png" );
		m_imgCopiar = new ImageIcon( "./img/img_copiar.png" );
		img_webPujarBlanc = new ImageIcon( "./img/img_webPujarBlanc.png" );
		img_webPujatBlanc = new ImageIcon( "./img/img_webPujatBlanc.png" );
		img_webPujarNegre = new ImageIcon( "./img/img_webPujarNegre.png" );
		img_webPujatNegre = new ImageIcon( "./img/img_webPujatNegre.png" );
		m_imgRotativa = new ImageIcon( "./img/img_rotativa.png" );
		m_imgInformacio = new ImageIcon( "./img/img_informacio.png" );
		m_imgInformacio24 = new ImageIcon( "./img/img_informacio24.png" );
		img_desplegableBlanc = new ImageIcon( "./img/img_desplegableBlanc.png" );
		img_configuracioMailBlanc = new ImageIcon( "./img/img_configuracioMailBlanc.png" );
		img_configuracioMail = new ImageIcon( "./img/img_configuracioMail.png" );
		// m_calendari = new ImageIcon( "./img/img_calendari.png" );
		m_calendari = new ImageIcon( "./img/img_calendari_24x24.png" );
		m_calendari1 = new ImageIcon( "./img/img_calendari1.png" );
		m_calendari1Blanc = new ImageIcon( "./img/img_calendari1blanc.png" );
		img_calendar_selected = new ImageIcon( "./img/img_calendar_selected.png" );
		img_bloquejat = new ImageIcon( "./img/img_bloquejat.png" );
		
		
		img_xml = new ImageIcon("./img/img_xml.png");
		img_reload = new ImageIcon("./img/img_reload.png");
		img_printer = new ImageIcon("./img/img_printer.png");
		// Colors Planificador
		m_colorVerdConfirmatPlanificador = new Color( 67, 195, 94 );
		m_colorVermellPendentPlanificador = Color.red;

		Image im = Toolkit.getDefaultToolkit( ).createImage( "./img/img_paperera2.png" );

		m_cursorDeplanificarProduccio = Toolkit.getDefaultToolkit( ).createCustomCursor( im, new Point( 10, 10 ), "WILL" );
	}

}