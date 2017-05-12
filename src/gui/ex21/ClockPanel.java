package gui.ex21;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JPanel;

public class ClockPanel extends JPanel implements MouseMotionListener {

	private int hour;
	private int minute;
	private int second;

	private int mx = 220;
	private int my = 300;

	/**
	 * Create the panel.
	 */
	public ClockPanel()  {
		hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		minute = Calendar.getInstance().get(Calendar.MINUTE);
		second = Calendar.getInstance().get(Calendar.SECOND);
		setBackground(Color.BLACK);
		addMouseMotionListener(this);

		new Thread (new Runnable () {
			public void run () {

				while(true) {

					try{
						Thread.sleep (50);
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

	private double x = 250;
	private double y = 250;
	private double vx = 50;
	private double vy = 0;

	private  Point moveMoon() {

		vx += (mx - x) * 0.05;
		vy += (my - y) * 0.05;


		if(Math.abs(vx) > 30) {
			vx = vx > 0 ? 30 : - 30;
		}
		if(Math.abs(vy) > 30) {
			vy = vy > 0 ? 30 : -30;
		}

		x += vx;
		y += vy;

		return new Point((int)x, (int)y);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D)  g;
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		String time = String.format("%02d : %02d : %02d", hour, minute, second);
		Dimension size = getSize();
		g2.setColor(new Color(0, 0,40,220));
		g2.fillRect(0, 0, size.width, size.height);

		Font font = new Font("Arial" ,Font.PLAIN, 50);
		g2.setFont(font);
		g2.setColor(Color.WHITE);
		g2.drawString(time, (size.width - g.getFontMetrics().stringWidth(time)) / 2, size.height / 2);
		Point p = moveMoon();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
                );

		g2.setColor(new Color(255, 255, 100));
		g2.fillOval(p.x, p.y, 10, 10);

		g2.setColor(new Color(100, 100,255,220));
		g2.fillOval(mx, my, 20, 20);

		g2.setColor(new Color(255, 255,244,40));

		makeStars(g2);


		//g2.setColor(Color.darkGray);
		//g2.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	private Random random = new Random();
	private int count = 100;
	private Point[] ps = new Point[15];
	void makeStars(Graphics2D g) {
		if(count > 30) {
			count = 0;
			for(int i = 0; i < ps.length; i++) {
				ps[i] = new Point(random.nextInt(getWidth()),random.nextInt(getHeight()));
			}
		} else {
			count++;
		}

		for(int i = 0; i < ps.length; i++) {
			g.drawLine(ps[i].x + 3, ps[i].y, ps[i].x - 3, ps[i].y);
			g.drawLine(ps[i].x , ps[i].y+ 3, ps[i].x, ps[i].y -3);
		}
	}

	@Override
	public void mouseDragged(MouseEvent paramMouseEvent) {
		// TODO 自動生成されたメソッド・スタブ

	}

	//private double mvx = 0;
	//private double mvy = 0;


	@Override
	public void mouseMoved(MouseEvent m) {
		mx = m.getX();
		my = m.getY();

	}
}
