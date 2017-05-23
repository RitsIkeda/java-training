package gui.ex22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class ClockFrame extends JFrame {

	private ClockPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ClockFrame().setVisible(true);
	}
	public final int WITDH = 500;
	public final int HEIGHT = 500;

	/**
	 * Create the frame.
	 */
	public ClockFrame() {
		setTitle("Space Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WITDH, HEIGHT);
		contentPane = new ClockPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmProperty = new JMenuItem("Property");
		mntmProperty.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e) {
		    	  Property prop = new Property( ClockFrame.this, contentPane);
		    	  prop.setVisible(true);
		        }});
		mnMenu.add(mntmProperty);
		setContentPane(contentPane);
	}

}
