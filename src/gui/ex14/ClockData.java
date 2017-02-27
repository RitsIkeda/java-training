package gui.ex14;

import java.awt.Color;
import java.util.prefs.Preferences;

public class ClockData {

	public double ratio = 2.0;
	public Color backColor = Color.WHITE;
	public Color fontColor = Color.BLACK;
	public String fontName = "Arial";
	public int startX = 10;
	public int startY = 10;

	public ClockData() {

	}

	public ClockData(ClockData data) {
		backColor = data.backColor;
		fontColor = data.fontColor;
		fontName = data.fontName;
		ratio = data.ratio;
		startX = data.startX;
		startY = data.startY;

	}

	public static void savePreferences(Preferences p, double ratio, Color backColor, Color fontColor, String fontName,
			int x, int y) {

		p.putDouble("ratio_niceDay", ratio);
		p.putInt("backR_niceDay", backColor.getRed());
		p.putInt("backG_niceDay", backColor.getGreen());
		p.putInt("backB_niceDay", backColor.getBlue());
		p.putInt("fontR_niceDay", fontColor.getRed());
		p.putInt("fontG_niceDay", fontColor.getGreen());
		p.putInt("fontB_niceDay", fontColor.getBlue());
		p.put("font_niceDay", fontName);
		p.putInt("x_niceDay", x);
		p.putInt("y_niceDay", y);

	}

	public void savePreferences(Preferences p) {
		p.putDouble("ratio_niceDay", ratio);
		p.putInt("backR_niceDay", backColor.getRed());
		p.putInt("backG_niceDay", backColor.getGreen());
		p.putInt("backB_niceDay", backColor.getBlue());
		p.putInt("fontR_niceDay", fontColor.getRed());
		p.putInt("fontG_niceDay", fontColor.getGreen());
		p.putInt("fontB_niceDay", fontColor.getBlue());
		p.put("font_niceDay", fontName);
		p.putInt("x_niceDay", startX);
		p.putInt("y_niceDay", startY);

	}

	public void applyPreferences(Preferences p) {
		ratio = p.getDouble("ratio_niceDay", 2.0);
		backColor = new Color(p.getInt("backR_niceDay", 255), p.getInt("backG_niceDay", 255),
				p.getInt("backB_niceDay", 255));
		fontColor = new Color(p.getInt("fontR_niceDay", 0), p.getInt("fontG_niceDay", 0), p.getInt("fontB_niceDay", 0));
		fontName = p.get("font_niceDay", "Arial");
		startX = p.getInt("x_niceDay", 10);
		startY = p.getInt("y_niceDay", 10);
	}

}
