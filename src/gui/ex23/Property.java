package gui.ex23;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class Property extends JPopupMenu {

	private final JPanel contentPanel = new JPanel();
	ClockPanel clock;
	ClockFrame frame;

	public Property(ClockFrame frame, ClockPanel clock) {
		this.clock = clock;
		this.frame = frame;
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		createMenu();
	}

	private void createMenu() {

		{
			JMenu parent = new JMenu("Font");
			String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			for(String font : fonts){
				JMenuItem child = new JMenuItem(font);
				child.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent e) {
						clock.font = new Font(font,Font.PLAIN, clock.font.getSize());
					}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
				parent.add(child);
			}
			this.add(parent);
		}
		{
			JMenu parent = new JMenu("Font Size");
			String sizes[] = { "Small", "Normal", "Large", "XLarge" };
			double ratios[] = { 0.5, 1.0, 2.0 , 3.0 };
			for(int i = 0; i < sizes.length; i++) {
				JMenuItem child = new JMenuItem(sizes[i]);
				double ratio= ratios[i];
				child.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent e) {
						frame.setSize((int) (frame.WITDH * ratio),
								(int) (frame.HEIGHT * ratio));
						clock.font = new Font(clock.font.getFontName() ,Font.PLAIN, (int) ( clock.FONT_SIZE * ratio) );
					}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
				parent.add(child);
			}
			this.add(parent);
		}
		{
			JMenu parent = new JMenu("Font Color");
			String colors[] = RichColors.richColors;
			for(String color : colors){
				JMenuItem child = new JMenuItem(color);
				child.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent e) {
						clock.fontColor = RichColors.toRealColor(color);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
				parent.add(child);
			}
			this.add(parent);
		}
		{
			JMenu parent = new JMenu("Back Color");
			String colors[] = RichColors.richColors;
			for(String color : colors){
				JMenuItem child = new JMenuItem(color);
				child.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {}
					@Override
					public void mousePressed(MouseEvent e) {
						clock.backColor = RichColors.toRealColor(color);
					}
					@Override
					public void mouseExited(MouseEvent arg0) {}
					@Override
					public void mouseEntered(MouseEvent arg0) {}
					@Override
					public void mouseClicked(MouseEvent arg0) {}
				});
				parent.add(child);
			}
			this.add(parent);

		}
		{
			JMenuItem parent = new JMenuItem("Close");
			parent.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
			});
			this.add(parent);

		}
	}

}
