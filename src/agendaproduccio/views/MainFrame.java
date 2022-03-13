
package agendaproduccio.views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 * @author Ibrahima
 * SINGLETON CLASS ONLY ONE INSTANCE AT THE TIME 
 */
public class MainFrame extends JFrame {
	
	
	/*****************ATTRIBUTS*******************/

	private static final String MAIN_TITLE = "Agenda Producci� v0.2";
	
	/**
	 * new won't work
	 */
	private static MainFrame m_mainFrame;
	public  JPanel m_mainJpanel;
	
	
	/***************** CONSTRUCTOR **************************/
	
    private MainFrame() 
    {
    	this.showWindow();
    }
    
    
    
    /************************************* PUBLIC METHODS ***************************************/
    
    
    /**
     * return an instance of this class and also making sure there only be one at the time 
     * @return
     */
    
    public  static synchronized  MainFrame getInstance() {
    	if(m_mainFrame==null) {
    		m_mainFrame = new MainFrame();
        }
    	return m_mainFrame;
    }
    
    /**
     * Show the frame to the screen
     */
    public void activate() {
    	setVisible(true);
    }
    
    
    /**
     * Hide the frame from the screen
     */
    public void desactivate() {
    	setVisible(false);
    }
    
    
    public void setJPanell(JPanel jpanell) {
    	this.clear();
    	this.m_mainJpanel = jpanell;
    	this.showWindow();
    	this.activate();
    }
    
    
    public void clear() {
    	remove(m_mainJpanel);
    	
    }
    /************************************ PRIVATE METHODS ********************************************/
    
    /**
     * Display this frame to the screen
     */
    private void showWindow() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    		setSize(screenSize);
    		getContentPane().setLayout(new BorderLayout());
    		setVisible(false);
    		setTitle(MAIN_TITLE);
    		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            if(m_mainJpanel == null){
                m_mainJpanel = new MainJPanel(this);
            }
                add(m_mainJpanel);
    }
    
}
