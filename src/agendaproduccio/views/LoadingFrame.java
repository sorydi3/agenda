package agendaproduccio.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingFrame extends JComponent implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point point;

	public LoadingFrame() {
		super();
		setLayout(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon("./img/Ajax-loader.gif"));
		JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 500, 500));
		l_panel.setBackground(new Color(0, 0, 0, 0));
		l_panel.add(label);
		add(l_panel);
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent me)

			{

				// Consume the event, now the input is blocked

				me.consume();

				// Create beep sound, when mouse is pressed
				// CRE
				Toolkit.getDefaultToolkit().beep();

			}

		});
		amaga();
	}

	public void mostra() {
		setVisible(true);
	}

	public void amaga() {
		setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setVisible(e.getStateChange() == ItemEvent.SELECTED);
	}

	public void setPoint(Point p) {
		point = p;
	}

	protected void paintComponent(Graphics g) {
		if (point != null) {
			g.setColor(Color.red);
			g.fillOval(point.x - 10, point.y - 10, 20, 20);
		}
	}

}
