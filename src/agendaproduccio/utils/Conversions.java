package agendaproduccio.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.text.View;

public class Conversions
{	
	private static Conversions m_singleton;
	public DecimalFormat m_decimalFormatter = new DecimalFormat("###,###.###");
	public DecimalFormat m_decimalFormatter0Decimal = new DecimalFormat("###,###");
	
public static Conversions getInstance()
{
    if( m_singleton == null )
    {
        m_singleton = new Conversions ( );
    }
    
    return m_singleton;
}  

public double ArrodonirDoubleToDouble2Decimals(double d) 
	{
	double valor=d;
	try
		{
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_DOWN);  		 
		valor=bd.doubleValue();
		}
	catch (Exception e)
		{	
		}
    return valor;
	}

public double ArrodonirDoubleToDouble3Decimals(double d) 
{
double valor=d;
try
	{
	BigDecimal bd = new BigDecimal(d);
	bd = bd.setScale(3,BigDecimal.ROUND_HALF_DOWN);  		 
	valor=bd.doubleValue();
	}
catch (Exception e)
	{	
	}
return valor;
}

public double ArrodonirDoubleToDouble1Decimals(double d) 
	{
	double valor=d;
	try
		{
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(1,BigDecimal.ROUND_HALF_DOWN);  		 
		valor=bd.doubleValue();
		}
	catch (Exception e)
		{	
		}
	return valor;
	}

public double ArrodonirDoubleToDouble1Decimals(double d, int p_tipusArrodoniment ) 
{
	if( d == 0 )
	{
		return 0;
	}
	
	double valor=d;
	try
	{
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(1,p_tipusArrodoniment);  		 
		valor=bd.doubleValue();
	}
	catch (Exception e)
	{	
	}
	return valor;
}

public int ArrodonirUPDoubleToInt(double preu)
	{
	
	int iret=0;
	String ret="";
	try
		{
		BigDecimal bd = new BigDecimal(preu);
		bd = bd.setScale(0,BigDecimal.ROUND_UP);  		 
		ret=""+bd.toString();
		}
	catch (Exception e)
		{
		ret="0";
		}
	try
		{
		iret= Integer.parseInt(ret);
		}
		catch (Exception e)
		{
		iret=0;
		}
	
	return (iret);
	}

/** M�TODE: M�tode que arrodoneix a multipla de 5 superior 
 *  Pex: 5.1 -> 10;
 *  	 5.9 -> 10;
 *  	 10.1 -> 15;	
 * */
public int ArrodonirUP5DoubleToInt( double p_preu )
{
	int l_temp;
	
	l_temp = ( BigDecimal.valueOf( p_preu ).setScale(0, RoundingMode.DOWN) ).intValue();
	
	if( l_temp % 5 != 0 )
	{
		l_temp = l_temp + 5;
		l_temp = l_temp - (l_temp % 5);
	}
	
	return l_temp;
}

public double ArrodonirUPDoubleToDouble1Decimals(double d) 
{
	double valor=d;
	try
	{
		if (d>0.00005) d=d-0.005; // Es posa aix� perque si entres un valor de 5.4 l'arrodoneix a 5.5, aix� nomes passa amb els X.4
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(1,BigDecimal.ROUND_UP);  		 
		valor=bd.doubleValue();
	}
	
	catch (Exception e)
	{	
		valor = d;
	}
	
	return valor;
}

public double ArrodonirUPDoubleToDouble2Decimals(double d) 
{
	double valor=d;
	try
	{
		if (d>0.00005) d=d-0.005; // Es posa aix� perque si entres un valor de 5.4 l'arrodoneix a 5.5, aix� nomes passa amb els X.4
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2,BigDecimal.ROUND_UP);  		 
		valor=bd.doubleValue();
	}
	
	catch (Exception e)
	{	
		valor = d;
	}
	System.out.println(""+d+" -> "+valor);
	return valor;
}

public String AfegirDecimalSiNoHiHa(String numero)
	{
	// Pasem format 10.000,3
	if (numero.indexOf(",")==-1) numero=numero+",0";
	return (numero);
	}

public String RetornaDouble3DecimalExcel(double hores)
	{
	String ret= String.format("%.3f", hores);
	String retnou="";
	for (int i=0;i<ret.length();i++)
		{
		if (ret.charAt(i)!='.') retnou=retnou+ret.charAt(i);
			else retnou=retnou+",";
		}
	return(retnou);  	
	}

public String RetornaDouble2DecimalExcel(double hores)
	{
	String ret= String.format("%.2f", hores);
	String retnou="";
	for (int i=0;i<ret.length();i++)
		{
		if (ret.charAt(i)!='.') retnou=retnou+ret.charAt(i);
			else retnou=retnou+",";
		}	
	return(retnou);  	
	}



public String RetornaDouble1DecimalExcel(double hores)
	{
	String ret= String.format("%.1f", hores);
	String retnou="";
	for (int i=0;i<ret.length();i++)
		{
		if (ret.charAt(i)!='.') retnou=retnou+ret.charAt(i);
			else retnou=retnou+",";
		}
	return(retnou);  	
	}

public String RetornaDouble0DecimalExcel(double hores)
	{
	String retnou="";
	try
		{
		BigDecimal bd = new BigDecimal(hores);
		//	bd = bd.setScale(3,BigDecimal.ROUND_HALF_EVEN);
		bd = bd.setScale(0,BigDecimal.ROUND_UP);  		 
		String ret=""+bd.toString();
		//	ret.replaceAll("\\\\.",",");
		retnou="";
		for (int i=0;i<ret.length();i++)
			{
			if (ret.charAt(i)!='.') retnou=retnou+ret.charAt(i);
				else retnou=retnou+",";
			}
		}
		catch (Exception e)
		{
		retnou="0,0";
		}
	return (retnou);
	}


public double StringExcelToDouble(String doubleExcel)
	{
	double valor=0.0;
	doubleExcel=doubleExcel.replaceAll(",",".");
	try
		{
		valor=Double.parseDouble(doubleExcel);
		}
		catch (Exception ex)
		{
		valor=0.0;
		}
	return (valor);
	}

public double StringPercentatgeExcelToDouble(String doubleExcel)
	{
	System.out.println("Valor percentatge original: "+doubleExcel);
	double valor=0.0;
	doubleExcel=doubleExcel.replaceAll(",",".");
	doubleExcel=doubleExcel.replaceAll(" ","");
	doubleExcel=doubleExcel.replaceAll("%","");
	System.out.println("Valor percentatge modificat: "+doubleExcel);
	try
		{
		valor=Double.parseDouble(doubleExcel);
		}
		catch (Exception ex)
		{
		valor=0.0;
		}
	return (valor);
	}

public String RetornaNomesNumeros(String str)
	{
	String nouSTR="";
	if (nouSTR!=null)
		{
		for (int i=0;i<str.length();i++)
			{
			if ((str.charAt(i)=='0')||(str.charAt(i)=='1')||(str.charAt(i)=='2')||(str.charAt(i)=='3')||(str.charAt(i)=='4')||(str.charAt(i)=='5')||(str.charAt(i)=='6')||(str.charAt(i)=='7')||(str.charAt(i)=='8')||(str.charAt(i)=='9')) nouSTR=nouSTR+str.charAt(i);
			}
		}
	return (nouSTR);
	}

public String RetornaDoubleSenseDecimalsSiSon0(double valor)
	{
	String valorArr=""+ArrodonirUPDoubleToDouble1Decimals(valor);
	valorArr=valorArr.replaceAll("\\.0", "");
	return (valorArr);
	}

public String RetornaDoubleSenseDecimalsSiSon0(String valorstr)
	{	
	double valor=0;
	try
		{
		valor=Double.parseDouble(valorstr);
		}
		catch (Exception e)
		{			
		}
	String valorArr=""+ArrodonirUPDoubleToDouble1Decimals(valor);
	valorArr=valorArr.replaceAll("\\.0", "");
	return (valorArr);
	}

private static final JLabel resizer = new JLabel();

/**Returns the preferred size to set a component at in order to render
 * an html string.  You can specify the size of one dimension.*/
    public static java.awt.Dimension getPreferredSizeLabel(String html,
                                                      boolean width, int prefSize) {
 
        resizer.setText(html);
 
        View view = (View) resizer.getClientProperty(
                javax.swing.plaf.basic.BasicHTML.propertyKey);
 
        view.setSize(width?prefSize:0,width?0:prefSize);
 
        float w = view.getPreferredSpan(View.X_AXIS);
        float h = view.getPreferredSpan(View.Y_AXIS);
 
        return new java.awt.Dimension((int) Math.ceil(w),
                (int) Math.ceil(h));
    }	

    public String removeAllHTMLTags(String entrada)
    	{
    	return (entrada.replaceAll("\\<.*?>",""));
    	}
    

	public String RemoveAccentsAndLowerCase( String p_input ) 
	{	
	   if( p_input == null )
	   {
			return "";
	   }
		
	   String l_original = "��������������������";
	   String l_ascii = "aaaeeeiiiooouuueaiou";
	   String l_output = p_input.toLowerCase();
	   
	   for ( int  i = 0;  i < l_original.length(); i++ )
	   {
		   l_output = l_output.replace( l_original.charAt(i), l_ascii.charAt(i) );
	   }
	   
	   return l_output;
	}

	
	public String retornaDoubleFormatExcel0Decimal(double valor)
		{
		String valorFormatat = ""+m_decimalFormatter0Decimal.format(valor);
		return (valorFormatat);
		}

	public String RetornaEnterAmbPuntDeMilers(int valor)
		{
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		return (formatea.format(valor));		
		}

}