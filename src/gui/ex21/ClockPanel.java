package gui.ex21;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Calendar;

import javax.swing.JPanel;

public class ClockPanel extends JPanel {

	private int hour;
	private int minute;
	private int second;

	/**
	 * Create the panel.
	 */
	public ClockPanel() {
		hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		minute = Calendar.getInstance().get(Calendar.MINUTE);
		second = Calendar.getInstance().get(Calendar.SECOND);
		setBackground(Color.WHITE);

		new Thread (new Runnable () {
			public void run () {

				while(true) {

					try{
						Thread.sleep (1000);
					} catch (InterruptedException e){
					}
					hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
					minute = Calendar.getInstance().get(Calendar.MINUTE);
					second = Calendar.getInstance().get(Calendar.SECOND);
					repaint();
				}
			}
		}).start ();

	}


	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D)  g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		Dimension size = getSize();
		g2.clearRect(0, 0, size.width, size.height);

		Font font = new Font("Arial" ,Font.PLAIN, 50);
		g2.setFont(font);
		g2.setColor(Color.BLACK);
		g2.drawString(time, (size.width - g.getFontMetrics().stringWidth(time)) / 2, size.height / 2);
	}
}
