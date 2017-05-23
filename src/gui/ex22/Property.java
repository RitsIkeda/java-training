package gui.ex22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

public class Property extends JDialog {

	private final JPanel contentPanel = new JPanel();
	ClockPanel clock;
	ClockFrame frame;

	public Property(ClockFrame frame, ClockPanel clock) {
		this.clock = clock;
		this.frame = frame;
		setBounds(100, 100, 450, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setComponents();
	}

	private void setComponents() {
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{173, 100};
		gbl_contentPanel.rowHeights = new int[]{60, 60, 60, 60, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFont = new JLabel("Font");
			GridBagConstraints gbc_lblFont = new GridBagConstraints();
			gbc_lblFont.insets = new Insets(0, 0, 5, 5);
			gbc_lblFont.gridx = 0;
			gbc_lblFont.gridy = 0;
			contentPanel.add(lblFont, gbc_lblFont);
		}
		{
			String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(fonts);
			JComboBox<String> comboBox = new JComboBox<String>(model);
			comboBox.setBackground(Color.WHITE);
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					clock.font = new Font((String)e.getItem(),Font.PLAIN, clock.font.getSize());
				}
			});


			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 0;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblFontSize = new JLabel("Font Size");
			GridBagConstraints gbc_lblFontSize = new GridBagConstraints();
			gbc_lblFontSize.insets = new Insets(0, 0, 5, 5);
			gbc_lblFontSize.gridx = 0;
			gbc_lblFontSize.gridy = 1;
			contentPanel.add(lblFontSize, gbc_lblFontSize);
		}
		{
			String sizes[] = { "Small", "Normal", "Large", "XLarge" };
			double ratios[] = { 0.5, 1.0, 2.0 , 3.0 };

			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(sizes);
			JComboBox<String> comboBox = new JComboBox<String>(model);
			comboBox.setBackground(Color.WHITE);
			comboBox.setSelectedIndex(1);
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					int index = comboBox.getSelectedIndex();
					double ratio= ratios[index];
					frame.setSize((int) (frame.WITDH * ratio),
							(int) (frame.HEIGHT * ratio));
					clock.font = new Font(clock.font.getFontName() ,Font.PLAIN, (int) ( clock.FONT_SIZE * ratio) );
				}
			});
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 1;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblNewLabel = new JLabel("Font Color");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(RichColors.richColors);
			JComboBox<String> comboBox = new JComboBox<String>(model);
			comboBox.setBackground(Color.WHITE);
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					clock.fontColor = RichColors.toRealColor((String)e.getItem() );
				}
			});

			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 2;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Back Color");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(RichColors.richColors);
			JComboBox<String> comboBox = new JComboBox<String>(model);
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					clock.backColor = RichColors.toRealColor((String)e.getItem() );
				}
			});
			comboBox.setBackground(Color.WHITE);

			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 3;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Property.this.setVisible(false);
					}
				});

				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}


	class MyCellRenderer extends JLabel implements ListCellRenderer<String> {
		@Override
		public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected,
				boolean cellHasFocus) {

		    setText(value);
			if(index >= 0) {
				this.
				setBackground(RichColors.toRealColor(RichColors.richColors[index]));
			}
		    return this;
		}
	}

}
