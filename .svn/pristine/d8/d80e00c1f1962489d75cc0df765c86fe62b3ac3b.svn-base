package agendaproduccio.models.fitxatecnica.model;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.border.*;
import java.net.URL;
import java.io.*;
import java.util.*;


public class ObrirFirefox
	{
	//Classe que em permet des d'un PC/UNIX poder obrir el navegador web per tal de poder ensenyar la paginacio en format 
	//html. D'aquesta manera, estant en un navegador de ultima generació, puc posar codi Javascript de tal manera que em 
	//permeti poder fer interactuar a l'usuari molt més fàcilment.
	
	//Constants    	
    	private static final String WIN_ID = "Windows";	// Utilitzat per identificar Microsoft.
    	private static final String WIN_PATH = "iexplore";	//Executable utilitzat per tal de carregar l'explorer
    	private static final String WIN_FLAG = "";	//Això en principi tenia url.dll,FileProtocolHandler ja que s'utilitzava amb rundll32
    	private static final String UNIX_PATH = "netscape";	//Browser per defecte en un entorn Unix, Linux....
    	private static final String UNIX_FLAG = "-remote openURL";	//Paràmetre per veure el fitxer html en un Unix.
    	
    	public ObrirFirefox(String Pdf)
    		{
    		//Mètode creador de la classe que em permet engegar el browser associant-li directament la plana html que volem
    		//ensenyar.
    				String NomFitxer=Pdf;
    				//NomFitxer=NomFitxer+numOrdre+".html";
        		boolean windows = isWindowsPlatform();
        		String cmd = null;
        		try
        			{
            			if (windows)
            				{
                			//cmd = WIN_PATH + " " + WIN_FLAG + " " + NomFitxer;
                			//cmd = WIN_PATH + " " + WIN_FLAG + " " +"file://"+System.getProperty("user.dir") +System.getProperty("file.separator")+NomFitxer;
                			cmd = WIN_PATH + " " + WIN_FLAG + " " +""+NomFitxer;
                			
                			//System.out.println("El cmd: "+cmd);
                			Process p = Runtime.getRuntime().exec(cmd);
                		
            				}
            			else
            				{
            				 Runtime.getRuntime().exec(new String[]{"/usr/bin/open",Pdf});                                     
            				 
                			/*cmd = UNIX_PATH + " " + UNIX_FLAG + "(" + NomFitxer + ")";
                			Process p = Runtime.getRuntime().exec(cmd);
                			//Això es per tal que s'esperi el sistema fins que s'obri el Netscape en Unix.
                			try
                				{
                    				int exitCode = p.waitFor();
                    				if (exitCode != 0)
                    					{
                        					cmd = UNIX_PATH + " "  + NomFitxer;
                        					p = Runtime.getRuntime().exec(cmd);
                    					}
                				}
                			catch(InterruptedException x)
                				{
                    				System.err.println("Error intentant engegar el browser");
                    				System.err.println("Error: " + x);
                				}*/
            				}
        			}
        		catch(IOException x)
        			{
            			//Quan no es pot obrir el browser
            			System.err.println("No es pot executar el browser");
            			System.err.println("Error: " + x);
        			}
    		}

/*   String llegirArxiuPath()
   	{
		String cadena;
		try 
			{
       RandomAccessFile fd = new RandomAccessFile("./ConnexioBD/path.txt", "r");
       cadena=fd.readLine();
       } 
       catch (Exception e) 
      	{
      	cadena="";
      	System.out.println("ERROR: "+e); 
      	}   	
    return(cadena);
   	}*/

	public static boolean isWindowsPlatform()
    		{
    		//Mètode utilitzat dins del creador que serveix per identificar que la plataforma es un windows o un Unix.
        		String os = System.getProperty("os.name");
        		if ( os != null && os.startsWith(WIN_ID)) return true;
        		else return false;
    		}
    	}


