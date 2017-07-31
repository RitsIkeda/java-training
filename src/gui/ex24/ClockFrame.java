package gui.ex24;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class ClockFrame extends JFrame {

	private ClockPanel clock;
	private Preferences child;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ClockFrame().setVisible(true);
	}

	public final int WITDH = 500;
	public final int HEIGHT = 500;
	private ClockData data = new ClockData();

	/**
	 * Create the frame.
	 */
	public ClockFrame() {
		setTitle("Space Clock");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowClosing());

		Preferences userRoot = Preferences.userRoot();
		child = userRoot.node("child");
		data.applyPreferences(child);

		setBounds(data.startX, data.startY, (int) (WITDH * data.ratio), (int) (HEIGHT * data.ratio));
		clock = new ClockPanel();
		clock.setBackground(Color.WHITE);
		clock.setBorder(new EmptyBorder(5, 5, 5, 5));
		clock.setLayout(new BorderLayout(0, 0));

		clock.font = new Font(data.fontName, Font.PLAIN, (int) (data.ratio * clock.FONT_SIZE));
		clock.fontColor = data.fontColor;
		clock.backColor = data.backColor;

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmProperty = new JMenuItem("Property");
		mntmProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property prop = new Property(ClockFrame.this, clock,
						new ClockData(clock.backColor, clock.fontColor, clock.font.getFontName(), clock.ratio));
				prop.setVisible(true);
			}
		});
		mnMenu.add(mntmProperty);
		setContentPane(clock);
	}

	class WindowClosing extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			data.startX = ClockFrame.this.getX();
			data.startY = ClockFrame.this.getY();
			data.backColor = clock.backColor;
			data.fontColor = clock.fontColor;
			data.fontName = clock.font.getName();
			data.ratio = clock.ratio;
			data.savePreferences(child);

			System.exit(0);
		}
	}

}
