package connexioBDD;

//import interficie.*;
import java.io.RandomAccessFile;

//import java.util.*;

public class ConnexioBD {
	public String nomServidorBD;
	public String Port;
	public String nomBD;

	public ConnexioBD(String path) {
		Port = "";
		nomBD = "";
		String cadena;
		try {
			RandomAccessFile fd = new RandomAccessFile(path, "r");// "./ConnexioBD/connexio.txt",
																	// "r");
			cadena = fd.readLine();
			nomServidorBD = cadena;
			cadena = fd.readLine();
			Port = cadena;
			cadena = fd.readLine();
			nomBD = cadena;
			fd.close();
		} catch (Exception e) {
			cadena = "";
			System.out.println("ERROR: " + e);
		}
	}

}