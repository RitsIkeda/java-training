package gui.ex12;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.Calendar;

public class TimeDisplayer extends Panel implements Runnable {

	private Thread timeThread = new Thread(this);
	private int hour;
	private int minute;
	private int second;
	private static final int PANEL_HEIGHT = 150;
	private static final int PANEL_WITDTH = 200;

	private int fontSize = 20;
	private String fontName = "Arial";
	private Color textColor = Color.black;

	private Font font = new Font(fontName, Font.PLAIN, fontSize);


	public void run() {

		while(true) {
			hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			minute = Calendar.getInstance().get(Calendar.MINUTE);
			second = Calendar.getInstance().get(Calendar.SECOND);

			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public TimeDisplayer() {
		setPreferredSize(new Dimension(PANEL_WITDTH, PANEL_HEIGHT));
		setBackground(Color.white);
		timeThread.start();
	}
	public void paint(Graphics g) {
		String time = String.format("%02d : %02d : %02d",hour,minute,second);

		Dimension size = getSize();
		Image image = createImage(size.width, size.height);
		Graphics buffer = image.getGraphics();

		buffer.setFont(font);
		buffer.setColor(textColor);
		buffer.drawString(time,
				(size.width - buffer.getFontMetrics().stringWidth(time)) / 2, size.height / 2);

		 g.drawImage(image, 0, 0, this);
	}

	public void chanegeFont(String fontName) {
		this.fontName = fontName;
		font = new Font(fontName, Font.PLAIN, fontSize);
	}
	public void chanegeTextSize(int fontSize) {
		this.fontSize = fontSize;
		font = new Font(fontName, Font.PLAIN, fontSize);
	}
	public void chanegeTextColor(Color color) {
		textColor = color;
	}
	public void chanegeBackColor(Color color) {
		setBackground(color);
	}

}
