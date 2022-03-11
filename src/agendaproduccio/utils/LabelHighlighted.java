package agendaproduccio.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import javax.swing.JLabel;

public class LabelHighlighted extends JLabel {
	private List<Rectangle2D> rectangles = new ArrayList<>();
	private Color colorHighlight = Color.WHITE;

	public LabelHighlighted() {

	}

	public void reset() {
		rectangles.clear();
		repaint();
	}

	public void highlightText(String textToHighlight) {

		if (textToHighlight == null) {
			return;
		}
		reset();

		final String textToMatch = textToHighlight.toLowerCase().trim();
		if (textToMatch.length() == 0) {
			return;
		}
		textToHighlight = textToHighlight.trim();

		final String labelText = getText().toLowerCase();
		if (labelText.contains(textToMatch)) {
			java.awt.FontMetrics fm = getFontMetrics(getFont());
			float w = -1;
			final float h = fm.getHeight() + 10;
			int i = 0;
			while (true) {
				i = labelText.indexOf(textToMatch, i);
				if (i == -1) {
					break;
				}
				if (w == -1) {

					String matchingText = getText().substring(i, i + textToHighlight.length());
					w = fm.stringWidth(matchingText);
				}

				String preText = getText().substring(0, i);

				float x = fm.stringWidth(preText);

				rectangles.add(new Rectangle2D.Float(x, i, w, h));
				i = i + textToMatch.length();
			}
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (rectangles.size() > 0) {
			Graphics2D g2d = (Graphics2D) g;
			Color c = g2d.getColor();
			for (Rectangle2D rectangle : rectangles) {
				g2d.setColor(colorHighlight);
				g2d.fill(rectangle);
				g2d.setColor(Color.RED);
				g2d.draw(rectangle);
			}
			g2d.setColor(c);
		}
		super.paintComponent(g);

	}
}