package gui.ex12;

import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockProperty extends Frame {

	private Panel mainPanel = new Panel();
	GridBagLayout gbl = new GridBagLayout();
	private ActionListener action;

	public ClockProperty(ActionListener action) {
		setBounds(10, 10, 320, 200);
		setTitle("Propety");
		this.action = action;

		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		setMainPanel();
		add(mainPanel);

	}


    void addComponent( Component c, int x, int y, int w, int h) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbl.setConstraints(c, gbc);
        mainPanel.add(c);
    }



	private void setMainPanel() {
		mainPanel.setLayout(gbl);

		addFontComponents();
		addTextSizeComponents();
		addTextColorComponents();
		addBackColorComponents();
	}

	private void addFontComponents() {
		addComponent(new Label("font"),0,0,1,1);

		Button arial = new Button("Arial");
		arial.setActionCommand("font,Arial");
		arial.addActionListener(action);
		addComponent(arial,1,0,1,1);

		Button georgia = new Button("GEORGIA");
		georgia.setActionCommand("font,GEORGIA");
		georgia.addActionListener(action);
		addComponent(georgia,2,0,1,1);

		Button batang = new Button("Batang");
		batang.setActionCommand("font,Batang");
		batang.addActionListener(action);
		addComponent(batang,3,0,1,1);

		Button century = new Button("Century");
		century.setActionCommand("font,Century");
		century.addActionListener(action);
		addComponent(century,4,0,1,1);
	}

	private void addTextSizeComponents() {
		addComponent(new Label("text size"),0,1,1,1);

		Button size15 = new Button("15");
		size15.setActionCommand("textSize,15");
		size15.addActionListener(action);
		addComponent(size15,1,1,1,1);

		Button size20 = new Button("20");
		size20.setActionCommand("textSize,20");
		size20.addActionListener(action);
		addComponent(size20,2,1,1,1);

		Button size25 = new Button("25");
		size25.setActionCommand("textSize,25");
		size25.addActionListener(action);
		addComponent(size25,3,1,1,1);

		Button size30 = new Button("30");
		size30.setActionCommand("textSize,30");
		size30.addActionListener(action);
		addComponent(size30,4,1,1,1);
	}


	private void addTextColorComponents() {
		addComponent(new Label("text color"),0,2,1,1);

		Button black = new Button("Black");
		black.setActionCommand("textColor,Black");
		black.addActionListener(action);
		addComponent(black,1,2,1,1);

		Button red = new Button("Red");
		red.setActionCommand("textColor,Red");
		red.addActionListener(action);
		addComponent(red,2,2,1,1);

		Button green = new Button("Green");
		green.setActionCommand("textColor,Green");
		green.addActionListener(action);
		addComponent(green,3,2,1,1);

		Button blue = new Button("Blue");
		blue.setActionCommand("textColor,Blue");
		blue.addActionListener(action);
		addComponent(blue,4,2,1,1);
	}


	private void addBackColorComponents() {
		addComponent(new Label("back color"),0,3,1,1);

		Button white = new Button("White");
		white.setActionCommand("backColor,White");
		white.addActionListener(action);
		addComponent(white,1,3,1,1);

		Button red = new Button("Red");
		red.setActionCommand("backColor,Red");
		red.addActionListener(action);
		addComponent(red,2,3,1,1);

		Button green = new Button("Green");
		green.setActionCommand("backColor,Green");
		green.addActionListener(action);
		addComponent(green,3,3,1,1);

		Button blue = new Button("Blue");
		blue.setActionCommand("backColor,Blue");
		blue.addActionListener(action);
		addComponent(blue,4,3,1,1);
	}

}
