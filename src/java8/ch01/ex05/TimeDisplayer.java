package java8.ch01.ex05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;

public class TimeDisplayer extends Window implements  MouseListener,MouseMotionListener {
	ClockMenu menu = new ClockMenu(this);

	private int hour;
	private int minute;
	private int second;

	private final double  BASE_HEIGHT = 160;
	private final double  BASE_WIDHT = 200;
	private double ratio = 1.5;

	private int wholeHeight =(int) (BASE_HEIGHT * ratio);
	private int wholeWidth = (int) (BASE_WIDHT * ratio);

	private int fontSize = 20;
	private String fontName = "Arial";
	private Color textColor = Color.black;

	private Font font;

	public TimeDisplayer() {
		super(new Frame());
		addMouseListener(this);
		addMouseMotionListener(this);
		add(menu);
		setPreferredSize(new Dimension(wholeWidth, wholeHeight));
		setBounds(10,10,wholeWidth,wholeHeight);
		chanegeTextSize(ratio);
		setBackground(Color.WHITE);
		new Thread( () -> {
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
		}).start();
	}
	private boolean selectedMouse = false;
	public void paint(Graphics g) {
		String time = String.format("%02d : %02d : %02d",hour,minute,second);

		Dimension size = getSize();
		Image image = createImage(size.width, size.height);
		Graphics buffer = image.getGraphics();
		drawFrame(buffer);

		buffer.setFont(font);
		buffer.setColor(textColor);
		buffer.drawString(time,
				(size.width - buffer.getFontMetrics().stringWidth(time)) / 2, size.height / 2);


		if(selectedMouse) {
			 drawAnimationt(buffer, second );
		 }

		 g.drawImage(image, 0, 0, this);

	}
	private Color getColorsFromSeed(int seed) {


		switch(seed % 5) {
			case 0:
				return new Color(255, 120, 120);
			case 1:
				return new Color(255, 240, 80);
			case 2:
				return new Color(120, 255, 120);
			case 3:
				return new Color(120, 255, 255);
			case 4:
				return new Color(120, 120, 255);
			case 5:
			default:
				return new Color(250, 120, 255);
		}

	}
	public void drawFrame(Graphics g) {
		g.setColor( new Color(50, 20, 20) );
		//g.fillRoundRect(10, 10, (int) this.getSize().getWidth() -20,(int) this.getSize().getHeight() -20, 40, 40);
		int frameSize = 2;
		g.fillRect(0, 0, (int) this.getSize().getWidth(),frameSize);
		g.fillRect(0, 0,  frameSize, (int) this.getSize().getHeight() );
		g.fillRect(0,(int) this.getSize().getHeight() -frameSize,  (int) this.getSize().getWidth(),frameSize);
		g.fillRect((int) this.getSize().getWidth() -frameSize,  frameSize, frameSize, (int) this.getSize().getHeight() );
	}

	public void drawAnimationt(Graphics g, int seed ) {

		g.setFont(font);
		final int height = ((int) this.getSize().getHeight() -(int) ( 40 *  ratio));
		int width = (int) (20 * ratio);
		seed += 60;

		g.setColor( getColorsFromSeed(seed--));
		g.drawString("H",width, height );
		width += 14 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("a",width, height );
		width += 12 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("v",width, height );
		width += 12 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("e", width, height );
		width += 20 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("a",   width ,height );
		width += 20 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("n",   width ,height );
		width += 12 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("i",   width, height );
		width += 8 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("c",   width, height );
		width += 12 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("e",   width, height );
		width += 22 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("D",   width, height );
		width += 14 * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("a",   width, height );
		width += 12  * ratio;
		g.setColor( getColorsFromSeed(seed--));
		g.drawString("y",   width, height );

	}

	public void chanegeFont(String fontName) {
		this.fontName = fontName;
		font = new Font(fontName, Font.PLAIN, fontSize);
	}
	public void chanegeTextSize(double ratio ) {
		this.fontSize = (int) (20 * ratio);
		font = new Font(fontName, Font.PLAIN,fontSize);
	}
	public void chanegeTextColor(Color color) {
		textColor = color;
	}
	public void chanegeBackColor(Color color) {
		setBackground(color);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			menu.show(this, e.getX(), e.getY());
		}
	}

	private int xOnApli, yOnApli;
	@Override
	public void mousePressed(MouseEvent e) {
		xOnApli = e.getXOnScreen() - this.getX();
		yOnApli = e.getYOnScreen() - this.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		selectedMouse = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		selectedMouse = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.setLocation(e.getXOnScreen() - xOnApli, e.getYOnScreen() - yOnApli);
	}

	@Override
	public void mouseMoved(MouseEvent paramMouseEvent) {


	}
	public void changeRatio(double ratio) {
		this.ratio = ratio;
		wholeHeight =(int)( BASE_HEIGHT * ratio);
		wholeWidth =(int)( BASE_WIDHT * ratio);
		setSize(wholeWidth, wholeHeight);

		chanegeTextSize(ratio);
	}


}
