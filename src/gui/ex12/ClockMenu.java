package gui.ex12;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.ActionListener;

public class ClockMenu extends MenuBar {

	ClockMenu(ActionListener action) {
		Menu mainMenu =new Menu("Menu");
		mainMenu.add("Property");
		mainMenu.addActionListener(action);

		add(mainMenu);
	}



}
