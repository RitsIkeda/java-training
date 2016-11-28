package gui.ex11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

public class MemoPanel extends Panel {

	TextArea memoArea;
	Label textLabl = new Label("メモ");

	MemoPanel(int rows, int columns) {
		setBackground(new Color(200,250,200));
		setLayout(new BorderLayout());

		memoArea = new TextArea(rows,columns);
		memoArea.setFont(new Font("メイリオ", Font.PLAIN,16));

		textLabl.setFont(new Font("メイリオ", Font.ITALIC, 22));


		add(textLabl,BorderLayout.NORTH);
		add(memoArea,BorderLayout.CENTER);
	}

}
