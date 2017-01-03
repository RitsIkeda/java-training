package gui.ex12;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockManager extends Frame implements ActionListener {

	private TimeDisplayer timeDispalayer = new TimeDisplayer();
	private ClockProperty propertyFrame = new ClockProperty(this);

	ClockManager() {
		setResizable(false);
		add(timeDispalayer);
		setMenuBar(new ClockMenu(this));
	}

	private class closeAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	public void setDefaultCloseOperation() {
		addWindowListener(new closeAdapter());
	}
	private Color convertStrToBackColor(String color) {
		if(color.equals("White")) {
			return Color.white;
		} else if(color.equals("Red")) {
			return new Color(255,200,200);
		} else if(color.equals("Green")) {
			return new Color(200,255,200);
		} else if(color.equals("Blue")) {
			return new Color(200,200,255);
		} else  {
			return Color.white;
		}


	}
	private Color convertStrToTextColor(String color) {
		if(color.equals("Black")) {
			return Color.black;
		} else if(color.equals("Red")) {
			return Color.red;
		} else if(color.equals("Green")) {
			return Color.green;
		} else if(color.equals("Blue")) {
			return Color.blue;
		} else  {
			return Color.black;
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String[] strs = command.split(",", 0);

		if(strs[0].equals("Property")) {
			propertyFrame.setVisible(true);
		} else if(strs[0].equals("font")) {
			timeDispalayer.chanegeFont(strs[1]);
		} else if(strs[0].equals("textSize")) {
			timeDispalayer.chanegeTextSize( Integer.parseInt(strs[1]));
		} else if(strs[0].equals("textColor")) {
			timeDispalayer.chanegeTextColor(convertStrToTextColor(strs[1]));
		} else if(strs[0].equals("backColor")) {
			timeDispalayer.chanegeBackColor(convertStrToBackColor(strs[1]));
		}
	}


}
