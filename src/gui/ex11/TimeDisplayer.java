package gui.ex11;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Calendar;

public class TimeDisplayer extends Panel implements Runnable {

	private Thread timeThread = new Thread(this);
	private int hour;
	private int minute;
	private int second;
	private static final int PANEL_HEIGHT = 150;
	private static final int PANEL_WITDTH = 200;

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
		setBackground(new Color(200,200,255));
		timeThread.start();
	}
	public void paint(Graphics g) {
		g.setFont(new Font("メイリオ", Font.BOLD, 22));
		g.drawString(String.format("%02d時 %02d分 %02d秒",hour,minute,second)
				,PANEL_WITDTH / 5, PANEL_HEIGHT / 2);
	}
}
