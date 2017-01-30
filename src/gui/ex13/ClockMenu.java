package gui.ex13;

import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockMenu extends PopupMenu {

	ClockMenu(TimeDisplayer owner) {
		Menu Size = new Menu("Size");
		MenuItem small = new MenuItem("Small");
		MenuItem bitSmall  = new MenuItem("A bit small");
		MenuItem bitLarge = new MenuItem("A bit large");
		MenuItem Large = new MenuItem("Large");

		Size.add(small);
		small.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.changeRatio(1.0);
		        }
		      } );
		Size.add(bitSmall);
		bitSmall.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.changeRatio(1.5);
		        }
		      } );
		Size.add(bitLarge);
		bitLarge.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.changeRatio(2.0);
		        }
		      } );
		Size.add(Large);
		Large.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.changeRatio(3.0);
		        }
		      } );
		this.add(Size);

		Menu fontColor = new Menu("Text Color");
		MenuItem fontBlack = new MenuItem("Black");
		fontBlack.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeTextColor(Color.BLACK);
		        }
		      } );
		MenuItem fontRed = new MenuItem("Red");
		fontRed.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeTextColor(Color.RED);
		        }
		      } );
		MenuItem fontGreen = new MenuItem("Green");
		fontGreen.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeTextColor(Color.GREEN);
		        }
		      } );
		MenuItem fontBlue = new MenuItem("Blue");
		fontBlue.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeTextColor(Color.BLUE);
		        }
		      } );

		fontColor.add(fontBlack);
		fontColor.add(fontRed);
		fontColor.add(fontGreen);
		fontColor.add(fontBlue);
		this.add(fontColor);

		Menu backColor = new Menu("Back Color");
		MenuItem backWhite= new MenuItem("White");
		backWhite.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeBackColor(Color.WHITE);
		        }
		      } );
		MenuItem backRed = new MenuItem("Red");
		backRed.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeBackColor(new Color(255, 230,230));
		        }
		      } );
		MenuItem backGreen = new MenuItem("Green");
		backGreen.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeBackColor(new Color(230, 255,230));
		        }
		      } );
		MenuItem backBlue = new MenuItem("Blue");
		backBlue.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeBackColor(new Color(230, 230,255));
		        }
		      } );

		backColor.add(backWhite);
		backColor.add(backRed);
		backColor.add(backGreen);
		backColor.add(backBlue);
		this.add(backColor);

		Menu font = new Menu("Font");
		MenuItem arial= new MenuItem("Arial");
		arial.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeFont("Arial");
		        }
		      } );
		MenuItem georgia = new MenuItem("GEORGIA");
		georgia.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeFont("GEORGIA");
		        }
		      } );
		MenuItem batang = new MenuItem("Batang");
		batang.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeFont("Batang");
		        }
		      } );
		MenuItem century = new MenuItem("Century");
		century.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          owner.chanegeFont("Century");
		        }
		      } );

		font.add(arial);
		font.add(georgia);
		font.add(batang);
		font.add(century);
		this.add(font);

		MenuItem close = new MenuItem("Close");
		close.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		          System.exit(0);
		        }
		      } );

		this.add(close);

	}
}
