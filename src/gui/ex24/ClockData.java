package gui.ex24;

import java.awt.Color;
import java.util.prefs.Preferences;

public class ClockData {

	public double ratio = 1.0;
	public Color backColor = Color.BLACK;
	public Color fontColor = Color.WHITE;
	public String fontName = "Arial";
	public int startX = 10;
	public int startY = 10;

	public ClockData() {

	}

	public ClockData(Color backColor, Color fontColor, String fontName, double ratio) {
		this.backColor = backColor;
		this.fontColor = fontColor;
		this.fontName = fontName;
		this.ratio = ratio;
	}

	public static void savePreferences(Preferences p, double ratio, Color backColor, Color fontColor, String fontName,
			int x, int y) {

		p.putDouble("ratio_space", ratio);
		p.putInt("backR_space", backColor.getRed());
		p.putInt("backG_space", backColor.getGreen());
		p.putInt("backB_space", backColor.getBlue());
		p.putInt("fontR_space", fontColor.getRed());
		p.putInt("fontG_space", fontColor.getGreen());
		p.putInt("fontB_space", fontColor.getBlue());
		p.put("font_space", fontName);
		p.putInt("x_space", x);
		p.putInt("y_space", y);
	}

	public void savePreferences(Preferences p) {
		p.putDouble("ratio_space", ratio);
		p.putInt("backR_space", backColor.getRed());
		p.putInt("backG_space", backColor.getGreen());
		p.putInt("backB_space", backColor.getBlue());
		p.putInt("fontR_space", fontColor.getRed());
		p.putInt("fontG_space", fontColor.getGreen());
		p.putInt("fontB_space", fontColor.getBlue());
		p.put("font_space", fontName);
		p.putInt("x_space", startX);
		p.putInt("y_space", startY);
	}

	public void applyPreferences(Preferences p) {
		ratio = p.getDouble("ratio_space", 1.0);
		backColor = new Color(p.getInt("backR_space", 0), p.getInt("backG_space", 0), p.getInt("backB_space", 0));
		fontColor = new Color(p.getInt("fontR_space", 255), p.getInt("fontG_space", 255), p.getInt("fontB_space", 255));
		fontName = p.get("font_space", "Arial");
		startX = p.getInt("x_space", 10);
		startY = p.getInt("y_space", 10);
	}

}
