package gui.ex23;

import java.awt.Color;

public class RichColors {

	public static final String[] richColors = { "AliceBlue", "AntiqueWhite", "Aqua", "Aquamarine", "Azure", "Beige",
			"Bisque", "Black", "BlanchedAlmond", "Blue", "BlueViolet", "Brown", "BurlyWood", "CadetBlue", "Chartreuse",
			"Chocolate", "Coral", "CornflowerBlue", "Cornsilk", "Crimson", "Cyan", "DarkBlue", "DarkCyan",
			"DarkGoldenrod", "DarkGray", "DarkGreen", "DarkKhaki", "DarkMagenta", "DarkOliveGreen", "DarkOrange",
			"DarkOrchid", "DarkRed", "DarkSalmon", "DarkSeaGreen", "DarkSlateBlue", "DarkSlateGray", "DarkTurquoise",
			"DarkViolet", "DeepPink", "DeepSkyBlue", "DimGray", "DodgerBlue", "Firebrick", "FloralWhite", "ForestGreen",
			"Fuchsia", "Gainsboro", "GhostWhite", "Gold", "Goldenrod", "Gray", "Green", "GreenYellow", "Honeydew",
			"HotPink", "IndianRed", "Indigo", "Ivory", "Khaki", "Lavender", "LavenderBlush", "LawnGreen",
			"LemonChiffon", "LightBlue", "LightCoral", "LightCyan", "LightGoldenrodYellow", "LightGreen", "LightGray",
			"LightPink", "LightSalmon", "LightSeaGreen", "LightSkyBlue", "LightSlateGray", "LightSteelBlue",
			"LightYellow", "Lime", "LimeGreen", "Linen", "Magenta", "Maroon", "MediumAquamarine", "MediumBlue",
			"MediumOrchid", "MediumPurple", "MediumSeaGreen", "MediumSlateBlue", "MediumSpringGreen", "MediumTurquoise",
			"MediumVioletRed", "MidnightBlue", "MintCream", "MistyRose", "Moccasin", "NavajoWhite", "Navy", "OldLace",
			"Olive", "OliveDrab", "Orange", "OrangeRed", "Orchid", "PaleGoldenrod", "PaleGreen", "PaleTurquoise",
			"PaleVioletRed", "PapayaWhip", "PeachPuff", "Peru", "Pink", "Plum", "PowderBlue", "Purple", "Red",
			"RosyBrown", "RoyalBlue", "SaddleBrown", "Salmon", "SandyBrown", "SeaGreen", "SeaShell", "Sienna", "Silver",
			"SkyBlue", "SlateBlue", "SlateGray", "Snow", "SpringGreen", "SteelBlue", "Tan", "Teal", "Thistle", "Tomato",
			"Turquoise", "Violet", "Wheat", "White", "WhiteSmoke", "Yellow", "YellowGreen" };

	public static Color toRealColor(String color) {

		switch (color) {
		case "AliceBlue":
			return new Color(240, 248, 255);
		case "AntiqueWhite":
			return new Color(250, 235, 215);
		case "Aqua":
			return new Color(0, 255, 255);
		case "Aquamarine":
			return new Color(127, 255, 212);
		case "Azure":
			return new Color(240, 255, 255);
		case "Beige":
			return new Color(245, 245, 220);
		case "Bisque":
			return new Color(255, 228, 196);
		case "Black":
			return new Color(0, 0, 0);
		case "BlanchedAlmond":
			return new Color(255, 235, 205);
		case "Blue":
			return new Color(0, 0, 255);
		case "BlueViolet":
			return new Color(138, 43, 226);
		case "Brown":
			return new Color(165, 42, 42);
		case "BurlyWood":
			return new Color(222, 184, 135);
		case "CadetBlue":
			return new Color(95, 158, 160);
		case "Chartreuse":
			return new Color(127, 255, 0);
		case "Chocolate":
			return new Color(210, 105, 30);
		case "Coral":
			return new Color(255, 127, 80);
		case "CornflowerBlue":
			return new Color(100, 149, 237);
		case "Cornsilk":
			return new Color(255, 248, 220);
		case "Crimson":
			return new Color(220, 20, 60);
		case "Cyan":
			return new Color(0, 255, 255);
		case "DarkBlue":
			return new Color(0, 0, 139);
		case "DarkCyan":
			return new Color(0, 139, 139);
		case "DarkGoldenrod":
			return new Color(184, 134, 11);
		case "DarkGray":
			return new Color(169, 169, 169);
		case "DarkGreen":
			return new Color(0, 100, 0);
		case "DarkKhaki":
			return new Color(189, 183, 107);
		case "DarkMagenta":
			return new Color(139, 0, 139);
		case "DarkOliveGreen":
			return new Color(85, 107, 47);
		case "DarkOrange":
			return new Color(255, 140, 0);
		case "DarkOrchid":
			return new Color(153, 50, 204);
		case "DarkRed":
			return new Color(139, 0, 0);
		case "DarkSalmon":
			return new Color(233, 150, 122);
		case "DarkSeaGreen":
			return new Color(143, 188, 139);
		case "DarkSlateBlue":
			return new Color(72, 61, 139);
		case "DarkSlateGray":
			return new Color(47, 79, 79);
		case "DarkTurquoise":
			return new Color(0, 206, 209);
		case "DarkViolet":
			return new Color(148, 0, 211);
		case "DeepPink":
			return new Color(255, 20, 147);
		case "DeepSkyBlue":
			return new Color(0, 191, 255);
		case "DimGray":
			return new Color(105, 105, 105);
		case "DodgerBlue":
			return new Color(30, 144, 255);
		case "Firebrick":
			return new Color(178, 34, 34);
		case "FloralWhite":
			return new Color(255, 250, 240);
		case "ForestGreen":
			return new Color(34, 139, 34);
		case "Fuchsia":
			return new Color(255, 0, 255);
		case "Gainsboro":
			return new Color(220, 220, 220);
		case "GhostWhite":
			return new Color(248, 248, 255);
		case "Gold":
			return new Color(255, 215, 0);
		case "Goldenrod":
			return new Color(218, 165, 32);
		case "Gray":
			return new Color(128, 128, 128);
		case "Green":
			return new Color(0, 128, 0);
		case "GreenYellow":
			return new Color(173, 255, 47);
		case "Honeydew":
			return new Color(240, 255, 240);
		case "HotPink":
			return new Color(255, 105, 180);
		case "IndianRed":
			return new Color(205, 92, 92);
		case "Indigo":
			return new Color(75, 0, 130);
		case "Ivory":
			return new Color(255, 255, 240);
		case "Khaki":
			return new Color(240, 230, 140);
		case "Lavender":
			return new Color(230, 230, 250);
		case "LavenderBlush":
			return new Color(255, 240, 245);
		case "LawnGreen":
			return new Color(124, 252, 0);
		case "LemonChiffon":
			return new Color(255, 250, 205);
		case "LightBlue":
			return new Color(173, 216, 230);
		case "LightCoral":
			return new Color(240, 128, 128);
		case "LightCyan":
			return new Color(224, 255, 255);
		case "LightGoldenrodYellow":
			return new Color(250, 250, 210);
		case "LightGreen":
			return new Color(144, 238, 144);
		case "LightGray":
			return new Color(211, 211, 211);
		case "LightPink":
			return new Color(255, 182, 193);
		case "LightSalmon":
			return new Color(255, 160, 122);
		case "LightSeaGreen":
			return new Color(32, 178, 170);
		case "LightSkyBlue":
			return new Color(135, 206, 250);
		case "LightSlateGray":
			return new Color(119, 136, 153);
		case "LightSteelBlue":
			return new Color(176, 196, 222);
		case "LightYellow":
			return new Color(255, 255, 224);
		case "Lime":
			return new Color(0, 255, 0);
		case "LimeGreen":
			return new Color(50, 205, 50);
		case "Linen":
			return new Color(250, 240, 230);
		case "Magenta":
			return new Color(255, 0, 255);
		case "Maroon":
			return new Color(128, 0, 0);
		case "MediumAquamarine":
			return new Color(102, 205, 170);
		case "MediumBlue":
			return new Color(0, 0, 205);
		case "MediumOrchid":
			return new Color(186, 85, 211);
		case "MediumPurple":
			return new Color(147, 112, 219);
		case "MediumSeaGreen":
			return new Color(60, 179, 113);
		case "MediumSlateBlue":
			return new Color(123, 104, 238);
		case "MediumSpringGreen":
			return new Color(0, 250, 154);
		case "MediumTurquoise":
			return new Color(72, 209, 204);
		case "MediumVioletRed":
			return new Color(199, 21, 133);
		case "MidnightBlue":
			return new Color(25, 25, 112);
		case "MintCream":
			return new Color(245, 255, 250);
		case "MistyRose":
			return new Color(255, 228, 225);
		case "Moccasin":
			return new Color(255, 228, 181);
		case "NavajoWhite":
			return new Color(255, 222, 173);
		case "Navy":
			return new Color(0, 0, 128);
		case "OldLace":
			return new Color(253, 245, 230);
		case "Olive":
			return new Color(128, 128, 0);
		case "OliveDrab":
			return new Color(107, 142, 35);
		case "Orange":
			return new Color(255, 165, 0);
		case "OrangeRed":
			return new Color(255, 69, 0);
		case "Orchid":
			return new Color(218, 112, 214);
		case "PaleGoldenrod":
			return new Color(238, 232, 170);
		case "PaleGreen":
			return new Color(152, 251, 152);
		case "PaleTurquoise":
			return new Color(175, 238, 238);
		case "PaleVioletRed":
			return new Color(219, 112, 147);
		case "PapayaWhip":
			return new Color(255, 239, 213);
		case "PeachPuff":
			return new Color(255, 218, 185);
		case "Peru":
			return new Color(205, 133, 63);
		case "Pink":
			return new Color(255, 192, 203);
		case "Plum":
			return new Color(221, 160, 221);
		case "PowderBlue":
			return new Color(176, 224, 230);
		case "Purple":
			return new Color(128, 0, 128);
		case "Red":
			return new Color(255, 0, 0);
		case "RosyBrown":
			return new Color(188, 143, 143);
		case "RoyalBlue":
			return new Color(65, 105, 225);
		case "SaddleBrown":
			return new Color(139, 69, 19);
		case "Salmon":
			return new Color(250, 128, 114);
		case "SandyBrown":
			return new Color(244, 164, 96);
		case "SeaGreen":
			return new Color(46, 139, 87);
		case "SeaShell":
			return new Color(255, 245, 238);
		case "Sienna":
			return new Color(160, 82, 45);
		case "Silver":
			return new Color(192, 192, 192);
		case "SkyBlue":
			return new Color(135, 206, 235);
		case "SlateBlue":
			return new Color(106, 90, 205);
		case "SlateGray":
			return new Color(112, 128, 144);
		case "Snow":
			return new Color(255, 250, 250);
		case "SpringGreen":
			return new Color(0, 255, 127);
		case "SteelBlue":
			return new Color(70, 130, 180);
		case "Tan":
			return new Color(210, 180, 140);
		case "Teal":
			return new Color(0, 128, 128);
		case "Thistle":
			return new Color(216, 191, 216);
		case "Tomato":
			return new Color(255, 99, 71);
		case "Turquoise":
			return new Color(64, 224, 208);
		case "Violet":
			return new Color(238, 130, 238);
		case "Wheat":
			return new Color(245, 222, 179);
		case "White":
			return new Color(255, 255, 255);
		case "WhiteSmoke":
			return new Color(245, 245, 245);
		case "Yellow":
			return new Color(255, 255, 0);
		case "YellowGreen":
			return new Color(154, 205, 50);

		}

		return new Color(0, 0, 0);
	}

}
