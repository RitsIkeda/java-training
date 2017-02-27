package gui.ex14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.prefs.Preferences;

public class TimeDisplayer extends Frame implements Runnable {

	private Thread timeThread = new Thread(this);
	private int hour;
	private int minute;
	private int second;

	private final double BASE_HEIGHT = 160;
	private final double BASE_WIDHT = 200;

	private double ratioY = 1.5;
	private double ratioX = 1.5;

	private int wholeHeight = (int) (BASE_HEIGHT * ratioY);
	private int wholeWidth = (int) (BASE_WIDHT * ratioX);

	private int fontSize = 20;
	private String fontName = "Arial";
	private Color textColor = Color.black;
	private Color backColor = Color.white;

	Preferences userRoot = Preferences.userRoot();
	Preferences child = userRoot.node("child");

	private Font font;

	public void run() {

		while (true) {
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
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				TimeDisplayer.this.exit();
			}
		});

		loadClockData();
		setTitle("Have a nice day with  various colors.");
		setMenuBar(new PropertyMenu(this));

		timeThread.start();
	}

	public void loadClockData() {
		ClockData data = new ClockData();
		data.applyPreferences(child);

		ratioX = ratioY = data.ratio;
		wholeHeight = (int) (BASE_HEIGHT * ratioY);
		wholeWidth = (int) (BASE_WIDHT * ratioX);
		setPreferredSize(new Dimension(wholeWidth, wholeHeight));
		setBounds(data.startX, data.startY, wholeWidth, wholeHeight);
		chanegeTextSize(ratioY);
		setBackground(data.backColor);
		fontName = data.fontName;
		textColor = data.fontColor;

	}

	private class PropertyMenu extends MenuBar {

		PropertyMenu(TimeDisplayer clock) {
			Menu mainMenu = new Menu("Menu");
			mainMenu.add("Property");
			mainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					ClockData data = new ClockData();
					data.backColor = backColor;
					data.fontColor = textColor;
					data.ratio = ratioY;
					data.fontName = fontName;

					new ClockProperty(clock, data).setVisible(true);
				}
			});
			add(mainMenu);
		}

	}

	public void paint(Graphics g) {

		if (getSize().width != wholeWidth || getSize().width != wholeHeight) {
			changeRatio(getSize().width, getSize().height);
		}

		String time = String.format("%02d : %02d : %02d", hour, minute, second);

		Dimension size = getSize();
		Image image = createImage(size.width, size.height);
		Graphics buffer = image.getGraphics();
		drawFrame(buffer);

		buffer.setFont(font);
		buffer.setColor(textColor);
		buffer.drawString(time, (size.width - buffer.getFontMetrics().stringWidth(time)) / 2, size.height / 2);

		drawAnimationt(buffer, second);
		g.drawImage(image, 0, 0, this);

	}

	private Color getColorsFromSeed(int seed) {

		switch (seed % 5) {
		case 0:
			return new Color(255, 100, 100);
		case 1:
			return new Color(255, 230, 50);
		case 2:
			return new Color(100, 255, 100);
		case 3:
			return new Color(100, 255, 255);
		case 4:
			return new Color(100, 120, 255);
		case 5:
		default:
			return new Color(250, 100, 255);
		}

	}

	public void drawFrame(Graphics g) {
		g.setColor(new Color(50, 20, 20));
		// g.fillRoundRect(10, 10, (int) this.getSize().getWidth() -20,(int)
		// this.getSize().getHeight() -20, 40, 40);
		int frameSize = 2;
		g.fillRect(0, 0, (int) this.getSize().getWidth(), frameSize);
		g.fillRect(0, 0, frameSize, (int) this.getSize().getHeight());
		g.fillRect(0, (int) this.getSize().getHeight() - frameSize, (int) this.getSize().getWidth(), frameSize);
		g.fillRect((int) this.getSize().getWidth() - frameSize, frameSize, frameSize, (int) this.getSize().getHeight());
	}

	public void drawAnimationt(Graphics g, int seed) {

		g.setFont(font);
		final int height = ((int) this.getSize().getHeight() - (int) (40 * ratioY));
		int width = (int) (20 * ratioX);
		seed += 60;

		g.setColor(getColorsFromSeed(seed--));
		g.drawString("H", width, height);
		width += 14 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("a", width, height);
		width += 12 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("v", width, height);
		width += 12 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("e", width, height);
		width += 20 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("a", width, height);
		width += 20 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("n", width, height);
		width += 12 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("i", width, height);
		width += 8 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("c", width, height);
		width += 12 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("e", width, height);
		width += 22 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("D", width, height);
		width += 14 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("a", width, height);
		width += 12 * ratioX;
		g.setColor(getColorsFromSeed(seed--));
		g.drawString("y", width, height);

	}

	public void chanegeFont(String fontName) {
		this.fontName = fontName;
		font = new Font(fontName, Font.PLAIN, fontSize);
	}

	public void chanegeTextSize(double ratio) {
		this.fontSize = (int) (20 * ratio);
		font = new Font(fontName, Font.PLAIN, fontSize);
	}

	public void chanegeTextColor(Color color) {
		textColor = color;
	}

	public void chanegeBackColor(Color color) {
		backColor = color;
		setBackground(color);
	}

	public void setClockData(ClockData data, boolean save) {
		if (save) {
			data.savePreferences(child);
		}
		textColor = data.fontColor;
		backColor = data.backColor;
		setBackground(backColor);
		changeRatio(data.ratio);
		fontName = data.fontName;
	}

	public void changeRatio(double ratio) {
		this.ratioX = ratio;
		this.ratioY = ratio;
		wholeHeight = (int) (BASE_HEIGHT * ratio);
		wholeWidth = (int) (BASE_WIDHT * ratio);
		setSize(wholeWidth, wholeHeight);
		chanegeTextSize(ratio);
	}

	public void changeRatio(int width, int height) {
		this.ratioX = width / BASE_WIDHT;
		this.ratioY = height / BASE_HEIGHT;
		wholeHeight = height;
		wholeWidth = width;
		chanegeTextSize(Math.min(ratioX, ratioY));

	}

	public void exit() {
		ClockData.savePreferences(child, ratioY, backColor, textColor, fontName, getLocation().x, getLocation().y);
		System.exit(0);
	}

}
