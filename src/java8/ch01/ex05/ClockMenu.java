package java8.ch01.ex05;


import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;

public class ClockMenu extends PopupMenu {

	ClockMenu(TimeDisplayer owner) {
		Menu Size = new Menu("Size");
		MenuItem small = new MenuItem("Small");
		MenuItem bitSmall  = new MenuItem("A bit small");
		MenuItem bitLarge = new MenuItem("A bit large");
		MenuItem Large = new MenuItem("Large");

		Size.add(small);
		small.addActionListener( e -> {
		          owner.changeRatio(1.0);
		        }
		       );
		Size.add(bitSmall);
		bitSmall.addActionListener(e -> {
		          owner.changeRatio(1.5);
		        });
		Size.add(bitLarge);

		bitLarge.addActionListener(e -> {
		          owner.changeRatio(2.0);
		        });
		Size.add(Large);
		Large.addActionListener(e -> {
		          owner.changeRatio(3.0);
		        });
		this.add(Size);

		Menu fontColor = new Menu("Text Color");
		MenuItem fontBlack = new MenuItem("Black");
		fontBlack.addActionListener(e -> {
		          owner.chanegeTextColor(Color.BLACK);
		        });
		MenuItem fontRed = new MenuItem("Red");
		fontRed.addActionListener(e -> {
		          owner.chanegeTextColor(Color.RED);
		        });
		MenuItem fontGreen = new MenuItem("Green");
		fontGreen.addActionListener(e -> {
		          owner.chanegeTextColor(Color.GREEN);
		        });
		MenuItem fontBlue = new MenuItem("Blue");
		fontBlue.addActionListener(e -> {
		          owner.chanegeTextColor(Color.BLUE);
		        });

		fontColor.add(fontBlack);
		fontColor.add(fontRed);
		fontColor.add(fontGreen);
		fontColor.add(fontBlue);
		this.add(fontColor);

		Menu backColor = new Menu("Back Color");
		MenuItem backWhite= new MenuItem("White");

		backWhite.addActionListener(e -> {
		          owner.chanegeBackColor(Color.WHITE);
		        });
		MenuItem backRed = new MenuItem("Red");
		backRed.addActionListener(e -> {
		          owner.chanegeBackColor(new Color(255, 230,230));
		        });
		MenuItem backGreen = new MenuItem("Green");
		backGreen.addActionListener(e -> {
		          owner.chanegeBackColor(new Color(230, 255,230));
		        });
		MenuItem backBlue = new MenuItem("Blue");
		backBlue.addActionListener(e -> {
		          owner.chanegeBackColor(new Color(230, 230,255));
		        });

		backColor.add(backWhite);
		backColor.add(backRed);
		backColor.add(backGreen);
		backColor.add(backBlue);
		this.add(backColor);

		Menu font = new Menu("Font");
		MenuItem arial= new MenuItem("Arial");
		arial.addActionListener(e -> {
		          owner.chanegeFont("Arial");
		        });
		MenuItem georgia = new MenuItem("GEORGIA");
		georgia.addActionListener(e -> {
		          owner.chanegeFont("GEORGIA");
		        });
		MenuItem batang = new MenuItem("Batang");
		batang.addActionListener(e -> {
		          owner.chanegeFont("Batang");
		        });
		MenuItem century = new MenuItem("Century");
		century.addActionListener(e -> {
		          owner.chanegeFont("Century");
		        });

		font.add(arial);
		font.add(georgia);
		font.add(batang);
		font.add(century);
		this.add(font);

		MenuItem close = new MenuItem("Close");
		close.addActionListener(e -> {
		          System.exit(0);
		        });

		this.add(close);

	}
}
