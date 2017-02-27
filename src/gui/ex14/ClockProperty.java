package gui.ex14;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockProperty extends Frame {

	private Panel mainPanel = new Panel();
	GridBagLayout gbl = new GridBagLayout();
	private TimeDisplayer clock;
	ClockData clockData;
	ClockData originalData;

	public ClockProperty(TimeDisplayer clock, ClockData data) {
		setBounds(10, 10, 500, 300);
		setTitle("Property");
		this.clock = clock;
		clockData = new ClockData(data);
		originalData = new ClockData(data);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				clock.setClockData(originalData, false);
				setVisible(false);
			}
		});
		setMainPanel();
		add(mainPanel);

	}

	void addComponent(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbl.setConstraints(c, gbc);
		mainPanel.add(c);
	}

	private void setMainPanel() {
		mainPanel.setLayout(gbl);

		addFontComponents();
		addTextSizeComponents();
		addTextColorComponents();
		addBackColorComponents();
		addSelectButtons();
	}

	private void addSelectButtons() {

		Button ok = new Button("OK");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clock.setClockData(clockData, true);
				setVisible(false);
			}

		});
		Button cancel = new Button("cancel");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clock.setClockData(originalData, false);
				setVisible(false);
			}

		});

		addComponent(ok, 4, 5, 1, 1);
		addComponent(cancel, 5, 5, 1, 1);
	}

	private void addFontComponents() {
		addComponent(new Label("font"), 0, 1, 1, 1);

		Choice choice = new Choice();
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (int i = 0; i < fonts.length; i++) {
			choice.add(fonts[i]);
		}

		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				clockData.fontName = ((String) ev.getItem());
				clock.setClockData(clockData, false);
			}
		});

		addComponent(choice, 1, 1, 3, 1);
	}

	private void addTextSizeComponents() {
		addComponent(new Label("Text size"), 0, 0, 1, 1);

		Choice choice = new Choice();
		choice.addItem("Very Small");
		choice.addItem("Small");
		choice.addItem("A bit small");
		choice.addItem("A bit Large");
		choice.addItem("Large");
		choice.addItem("Very Large");
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {

				if (((String) ev.getItem()).equals("Very Small")) {
					clockData.ratio = 1.0;
				} else if (((String) ev.getItem()).equals("Small")) {
					clockData.ratio = 1.5;
				} else if (((String) ev.getItem()).equals("A bit small")) {
					clockData.ratio = 2.0;
				} else if (((String) ev.getItem()).equals("A bit Large")) {
					clockData.ratio = 2.5;
				} else if (((String) ev.getItem()).equals("Large")) {
					clockData.ratio = 3.0;
				} else if (((String) ev.getItem()).equals("Very Large")) {
					clockData.ratio = 3.5;
				}
				clock.setClockData(clockData, false);
			}

		});

		addComponent(choice, 1, 0, 3, 1);
	}

	private void addTextColorComponents() {
		addComponent(new Label("Text color"), 0, 2, 1, 1);

		Choice choice = new Choice();

		for (int i = 0; i < RichColors.richColors.length; i++) {
			choice.add(RichColors.richColors[i]);
		}
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				clockData.fontColor = RichColors.toRealColor(((String) ev.getItem()));
				clock.setClockData(clockData, false);
			}

		});
		addComponent(choice, 1, 2, 3, 1);

	}

	private void addBackColorComponents() {
		addComponent(new Label("Back color"), 0, 3, 1, 1);
		Choice choice = new Choice();

		for (int i = 0; i < RichColors.richColors.length; i++) {
			choice.add(RichColors.richColors[i]);
		}

		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				clockData.backColor = RichColors.toRealColor(((String) ev.getItem()));
				clock.setClockData(clockData, false);
			}

		});
		addComponent(choice, 1, 3, 3, 1);

	}

}
