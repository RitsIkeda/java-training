package jpl.ch14.ex02;

public class PrintJob {
    private String text;
    public PrintJob() {

    }
    public PrintJob(String text) {
        this.setText(text);
    }
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


}
