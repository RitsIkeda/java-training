package jpl.ch24.ex03;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ParseDateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputBox;
	private JTextField fullBox;
	private JTextField longBox;
	private JTextField mediumBox;
	private JTextField shortBox;
	private JComboBox<String> comboBox;
	private JButton parseBtn;

	public static void main(String[] args) {
		ParseDateFrame frame = new ParseDateFrame();
		frame.setTitle("Date Parser");
		frame.setVisible(true);
	}

	private void tryParse() {
		String input = inputBox.getText();
		Locale locale = Locale.getAvailableLocales()[comboBox.getSelectedIndex()];
		String[] results = DateParser.parseDateStr(input, locale);
		fullBox.setText(results[0]);
		longBox.setText(results[1]);
		mediumBox.setText(results[2]);
		shortBox.setText(results[3]);
	}

	public ParseDateFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setComponents();
	}

	private void setComponents() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{140, 141, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		parseBtn = new JButton("parseDate");
		parseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tryParse();
			}
		});
		GridBagConstraints gbc_parseBtn = new GridBagConstraints();
		gbc_parseBtn.insets = new Insets(0, 0, 5, 5);
		gbc_parseBtn.gridx = 0;
		gbc_parseBtn.gridy = 0;
		contentPane.add(parseBtn, gbc_parseBtn);

		inputBox = new JTextField();
		GridBagConstraints gbc_inputBox = new GridBagConstraints();
		gbc_inputBox.insets = new Insets(0, 0, 5, 0);
		gbc_inputBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputBox.gridx = 1;
		gbc_inputBox.gridy = 0;
		contentPane.add(inputBox, gbc_inputBox);
		inputBox.setColumns(10);

		JLabel localLabel = new JLabel("Locale");
		GridBagConstraints gbc_localLabel = new GridBagConstraints();
		gbc_localLabel.insets = new Insets(0, 0, 5, 5);
		gbc_localLabel.gridx = 0;
		gbc_localLabel.gridy = 1;
		contentPane.add(localLabel, gbc_localLabel);

		ComboBoxModel<String> model = new DefaultComboBoxModel<String>(DateParser.getLocaleNames());
		comboBox = new JComboBox<String>(model);
		comboBox.setBackground(Color.WHITE);
		comboBox.setSelectedIndex(62);//japan
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);

		JLabel fullLabel = new JLabel("FULL Format");
		GridBagConstraints gbc_fullLabel = new GridBagConstraints();
		gbc_fullLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fullLabel.gridx = 0;
		gbc_fullLabel.gridy = 2;
		contentPane.add(fullLabel, gbc_fullLabel);

		fullBox = new JTextField();
		GridBagConstraints gbc_fullBox = new GridBagConstraints();
		gbc_fullBox.insets = new Insets(0, 0, 5, 0);
		gbc_fullBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_fullBox.gridx = 1;
		gbc_fullBox.gridy = 2;
		contentPane.add(fullBox, gbc_fullBox);
		fullBox.setColumns(10);

		JLabel longLabel = new JLabel("LONG Format");
		GridBagConstraints gbc_longLabel = new GridBagConstraints();
		gbc_longLabel.insets = new Insets(0, 0, 5, 5);
		gbc_longLabel.gridx = 0;
		gbc_longLabel.gridy = 3;
		contentPane.add(longLabel, gbc_longLabel);

		longBox = new JTextField();
		GridBagConstraints gbc_longBox = new GridBagConstraints();
		gbc_longBox.insets = new Insets(0, 0, 5, 0);
		gbc_longBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_longBox.gridx = 1;
		gbc_longBox.gridy = 3;
		contentPane.add(longBox, gbc_longBox);
		longBox.setColumns(10);

		JLabel mediumLabel = new JLabel("MEDIUM Format");
		GridBagConstraints gbc_mediumLabel = new GridBagConstraints();
		gbc_mediumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mediumLabel.gridx = 0;
		gbc_mediumLabel.gridy = 4;
		contentPane.add(mediumLabel, gbc_mediumLabel);

		mediumBox = new JTextField();
		GridBagConstraints gbc_mediumBox = new GridBagConstraints();
		gbc_mediumBox.insets = new Insets(0, 0, 5, 0);
		gbc_mediumBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_mediumBox.gridx = 1;
		gbc_mediumBox.gridy = 4;
		contentPane.add(mediumBox, gbc_mediumBox);
		mediumBox.setColumns(10);

		JLabel shortLabel = new JLabel("SHORT Format");
		GridBagConstraints gbc_shortLabel = new GridBagConstraints();
		gbc_shortLabel.insets = new Insets(0, 0, 0, 5);
		gbc_shortLabel.gridx = 0;
		gbc_shortLabel.gridy = 5;
		contentPane.add(shortLabel, gbc_shortLabel);

		shortBox = new JTextField();
		GridBagConstraints gbc_shortBox = new GridBagConstraints();
		gbc_shortBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_shortBox.gridx = 1;
		gbc_shortBox.gridy = 5;
		contentPane.add(shortBox, gbc_shortBox);
		shortBox.setColumns(10);
	}

}
