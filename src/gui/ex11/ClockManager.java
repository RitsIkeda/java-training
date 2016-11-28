package gui.ex11;
import javax.swing.BoxLayout;

public class ClockManager {


	public static void main(String args[]) {

		ClockFrame frame = new ClockFrame();
		frame.setBounds(10, 10, 300, 400);
		frame.setTitle("メモClock");
		frame.setDefaultCloseOperation();

		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));

		frame.add(new TimeDisplayer());
		frame.add(new MemoPanel(5,20));

		frame.setVisible(true);

	}

}
