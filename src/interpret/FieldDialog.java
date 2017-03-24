package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FieldDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameBox;
	private JTextField valueBox;
	private JTextField newValueBox;
	private JTextField typeBox;
	Interpret interpret;

	public FieldDialog(Interpret interpret, String fieldName, String typeName, String valueStr) {
		this.interpret = interpret;
		setBounds(100, 100, 318, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 187, 191, 0 };
		gbl_contentPanel.rowHeights = new int[] { 33, 33, 33, 33, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPanel.add(lblName, gbc_lblName);

		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.fill = GridBagConstraints.BOTH;
		gbc_lblType.insets = new Insets(0, 0, 5, 0);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 0;
		contentPanel.add(lblType, gbc_lblType);

		nameBox = new JTextField(fieldName);
		GridBagConstraints gbc_nameBox = new GridBagConstraints();
		gbc_nameBox.fill = GridBagConstraints.BOTH;
		gbc_nameBox.insets = new Insets(0, 0, 5, 5);
		gbc_nameBox.gridx = 0;
		gbc_nameBox.gridy = 1;
		contentPanel.add(nameBox, gbc_nameBox);
		nameBox.setColumns(10);

		typeBox = new JTextField(typeName);
		typeBox.setColumns(10);
		GridBagConstraints gbc_typeBox = new GridBagConstraints();
		gbc_typeBox.fill = GridBagConstraints.BOTH;
		gbc_typeBox.insets = new Insets(0, 0, 5, 0);
		gbc_typeBox.gridx = 1;
		gbc_typeBox.gridy = 1;
		contentPanel.add(typeBox, gbc_typeBox);

		JLabel lblValuetostring = new JLabel("Value (toString)");
		GridBagConstraints gbc_lblValuetostring = new GridBagConstraints();
		gbc_lblValuetostring.fill = GridBagConstraints.BOTH;
		gbc_lblValuetostring.insets = new Insets(0, 0, 5, 5);
		gbc_lblValuetostring.gridx = 0;
		gbc_lblValuetostring.gridy = 2;
		contentPanel.add(lblValuetostring, gbc_lblValuetostring);

		JLabel lblNewValue = new JLabel("New Value");
		GridBagConstraints gbc_lblNewValue = new GridBagConstraints();
		gbc_lblNewValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewValue.fill = GridBagConstraints.BOTH;
		gbc_lblNewValue.gridx = 1;
		gbc_lblNewValue.gridy = 2;
		contentPanel.add(lblNewValue, gbc_lblNewValue);

		valueBox = new JTextField(valueStr);
		valueBox.setColumns(10);
		GridBagConstraints gbc_valueBox = new GridBagConstraints();
		gbc_valueBox.fill = GridBagConstraints.BOTH;
		gbc_valueBox.insets = new Insets(0, 0, 0, 5);
		gbc_valueBox.gridx = 0;
		gbc_valueBox.gridy = 3;
		contentPanel.add(valueBox, gbc_valueBox);

		newValueBox = new JTextField();
		newValueBox.setColumns(10);
		GridBagConstraints gbc_newValueBox = new GridBagConstraints();
		gbc_newValueBox.fill = GridBagConstraints.BOTH;
		gbc_newValueBox.gridx = 1;
		gbc_newValueBox.gridy = 3;
		contentPanel.add(newValueBox, gbc_newValueBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							interpret.set(fieldName, newValueBox.getText(), typeName);
							setVisible(false);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							JOptionPane.showMessageDialog(null, e.getMessage() ,"フィールドを修正できません",JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
