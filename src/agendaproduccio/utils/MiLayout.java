package agendaproduccio.utils;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;

class MiLayout implements LayoutManager 
{
	public MiLayout() 
	{
    }

  public void addLayoutComponent( String name,Component comp ) 
    		{
     		}

  public void removeLayoutComponent( Component comp ) 
   		{
   		}

  public Dimension preferredLayoutSize( Container parent ) 
   		{
        		Insets insets = parent.getInsets();
        		int numero = parent.getComponentCount();
        		int ancho = 0;
        		int alto = 0;
		for( int i=0; i < numero; i++ ) 
            			{
            			Component comp = parent.getComponent( i );
            			Dimension d = comp.getPreferredSize();
            			Point p = comp.getLocation();
            			if( ( p.x + d.width ) > ancho ) ancho = p.x + d.width;
            			if( ( p.y + d.height ) > alto ) alto = p.y + d.height;
            			}
        		return new Dimension( insets.left + insets.right + ancho,insets.top + insets.bottom + alto );
        		}

    	public Dimension minimumLayoutSize( Container parent ) 
    		{
        		Insets insets = parent.getInsets();
        		int numero = parent.getComponentCount();
        		int ancho = 0;
        		int alto = 0;
		for( int i=0; i < numero; i++ ) 
            			{
            			Component comp = parent.getComponent( i );
            			Dimension d = comp.getPreferredSize();
            			Point p = comp.getLocation();
            			if( ( p.x + d.width ) > ancho ) ancho = p.x + d.width;
            			if( ( p.y + d.height ) > alto ) alto = p.y + d.height;
            			}
        		return new Dimension( insets.left + insets.right + ancho,insets.top + insets.bottom + alto );
        		}

    	public void layoutContainer( Container parent ) 
    		{
        		int numero = parent.getComponentCount();
		for( int i=0; i < numero; i++ ) 
            			{
            			Component comp = parent.getComponent( i );
            			Dimension d = comp.getPreferredSize();
            			comp.setSize( d.width,d.height );
            			}
        		}
 }

