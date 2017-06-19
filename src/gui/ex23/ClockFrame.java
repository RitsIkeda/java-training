package gui.ex23;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

public class ClockFrame extends JWindow  {

	private ClockPanel contentPane;


	public static void main(String[] args) {
		new ClockFrame().setVisible(true);
	}
	public final int WITDH = 500;
	public final int HEIGHT = 500;


	public ClockFrame() {
		setBounds(100, 100, WITDH, HEIGHT);
		contentPane = new ClockPanel(this);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


	}


}
