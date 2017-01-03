package gui.ex12;

public class ClockMain {


	public static void main(String args[]) {

		ClockManager frame = new ClockManager();
		frame.setBounds(10, 10, 210, 180);
		frame.setTitle("Clock");
		frame.setDefaultCloseOperation();

		frame.setVisible(true);
	}
}
