package gui.ex11;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockFrame extends Frame {

	private class closeAdapter extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	public void setDefaultCloseOperation() {
		addWindowListener(new closeAdapter());
	}
	
	
}
