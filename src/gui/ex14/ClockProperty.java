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
		addTemplate();
		addSelectButtons();
	}

	private void addTemplate() {
		addComponent(new Label("Template"), 0, 5, 1, 1);

		Choice choice = new Choice();
		choice.addItem("Simple");
		choice.addItem("Spring");
		choice.addItem("Summer");
		choice.addItem("Autumn");
		choice.addItem("Winter");
		choice.addItem("Pop");
		choice.addItem("Rock");
		choice.addItem("Dark");
		choice.addItem("Fashionable");
		choice.addItem("Funny");
		choice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (((String) ev.getItem()).equals("Simple")) {
					clockData.fontName = "Arial";
					clockData.fontColor = RichColors.toRealColor("Black");
					clockData.backColor = RichColors.toRealColor("White");
				} else if (((String) ev.getItem()).equals("Spring")) {
					clockData.fontName = "Monotype Corsiva";
					clockData.fontColor = RichColors.toRealColor("Fuchsia");
					clockData.backColor = RichColors.toRealColor("Linen");
				} else if (((String) ev.getItem()).equals("Summer")) {
					clockData.fontName = "Tw cen mt condensed extra bold";
					clockData.fontColor = RichColors.toRealColor("OrangeRed");
					clockData.backColor = RichColors.toRealColor("Blue");
				} else if (((String) ev.getItem()).equals("Autumn")) {
					clockData.fontName = "Algerian";
					clockData.fontColor = RichColors.toRealColor("DarkOrange");
					clockData.backColor = RichColors.toRealColor("Brown");
				} else if (((String) ev.getItem()).equals("Winter")) {
					clockData.fontName = "Californian FB";
					clockData.fontColor = RichColors.toRealColor("Blue");
					clockData.backColor = RichColors.toRealColor("AliceBlue");
				}else if (((String) ev.getItem()).equals("Pop")) {
					clockData.fontName = "Berlin Sans FB Demi";
					clockData.fontColor = RichColors.toRealColor("DarkOrange");
					clockData.backColor = RichColors.toRealColor("LightCyan");
				} else if (((String) ev.getItem()).equals("Rock")) {
					clockData.fontName = "Brush Script MT";
					clockData.fontColor = RichColors.toRealColor("Black");
					clockData.backColor = RichColors.toRealColor("Red");
				} else if (((String) ev.getItem()).equals("Dark")) {
					clockData.fontName = "Arabic Typesetting";
					clockData.fontColor = RichColors.toRealColor("White");
					clockData.backColor = RichColors.toRealColor("Black");
				} else if (((String) ev.getItem()).equals("Fashionable")) {
					clockData.fontName = "Vladimir Script";
					clockData.fontColor = RichColors.toRealColor("DarkRed");
					clockData.backColor = RichColors.toRealColor("Crimson");
				} else if (((String) ev.getItem()).equals("Funny")) {
					clockData.fontName = "Curlz MT";
					clockData.fontColor = RichColors.toRealColor("WhiteSmoke");
					clockData.backColor = RichColors.toRealColor("DarkOrchid");
				}
				clock.setClockData(clockData, false);
			}

		});

		addComponent(choice, 1, 5, 3, 1);



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

		addComponent(ok, 4, 6, 1, 1);
		addComponent(cancel, 5, 6, 1, 1);
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
					clockData.ratio = 4.0;
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
