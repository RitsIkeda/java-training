package jpl.ch24.ex02;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CurrencyTable extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		CurrencyTable frame = new CurrencyTable();
		frame.setTitle("Currency Symbol Table");
		frame.setVisible(true);
	}

	public CurrencyTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		LineBorder border = new LineBorder(Color.BLACK);

		Locale[] locales = {Locale.US, Locale.JAPAN, Locale.CHINA, Locale.UK,Locale.GERMANY, Locale.KOREA };

		JLabel localeHead = new JLabel("Locale");
		localeHead.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(localeHead);

		JLabel currencyHead = new JLabel("Currency symbol");
		currencyHead.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(currencyHead);

		contentPane.setLayout(new GridLayout(locales.length + 1, 2));
		for(Locale locale : locales  ) {

			JLabel localeLabel = new JLabel(locale.getDisplayCountry());
			localeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			localeLabel.setBorder(border);
			contentPane.add(localeLabel);

			JLabel currencyLabel = new JLabel(Currency.getInstance(locale).getSymbol(locale));
			currencyLabel.setBorder(border);
			currencyLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(currencyLabel);
		}

	}

}
