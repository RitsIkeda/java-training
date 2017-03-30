package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

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
	private JTextField instanceBox;

	public FieldDialog(Interpret interpret, String instanceName, Field field)
			throws IllegalArgumentException, IllegalAccessException {
		this.interpret = interpret;
		setBounds(100, 100, 423, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 205, 195, 0 };
		gbl_contentPanel.rowHeights = new int[] { 33, 33, 33, 33, 30, 30, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblInstanceName = new JLabel("Instance Name");
		GridBagConstraints gbc_lblInstanceName = new GridBagConstraints();
		gbc_lblInstanceName.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstanceName.gridx = 0;
		gbc_lblInstanceName.gridy = 0;
		contentPanel.add(lblInstanceName, gbc_lblInstanceName);

		JLabel lblName = new JLabel("Field Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.VERTICAL;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		contentPanel.add(lblName, gbc_lblName);

		instanceBox = new JTextField(instanceName);
		instanceBox.setEditable(false);
		instanceBox.setColumns(10);
		GridBagConstraints gbc_instanceBox = new GridBagConstraints();
		gbc_instanceBox.insets = new Insets(0, 0, 5, 5);
		gbc_instanceBox.fill = GridBagConstraints.BOTH;
		gbc_instanceBox.gridx = 0;
		gbc_instanceBox.gridy = 1;
		contentPanel.add(instanceBox, gbc_instanceBox);

		nameBox = new JTextField(field.getName());
		nameBox.setEditable(false);
		GridBagConstraints gbc_nameBox = new GridBagConstraints();
		gbc_nameBox.fill = GridBagConstraints.BOTH;
		gbc_nameBox.insets = new Insets(0, 0, 5, 0);
		gbc_nameBox.gridx = 1;
		gbc_nameBox.gridy = 1;
		contentPanel.add(nameBox, gbc_nameBox);
		nameBox.setColumns(10);

		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.fill = GridBagConstraints.VERTICAL;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		contentPanel.add(lblType, gbc_lblType);

		JLabel lblValuetostring = new JLabel("Value (toString)");
		GridBagConstraints gbc_lblValuetostring = new GridBagConstraints();
		gbc_lblValuetostring.fill = GridBagConstraints.VERTICAL;
		gbc_lblValuetostring.insets = new Insets(0, 0, 5, 0);
		gbc_lblValuetostring.gridx = 1;
		gbc_lblValuetostring.gridy = 2;
		contentPanel.add(lblValuetostring, gbc_lblValuetostring);

		typeBox = new JTextField(field.getType().toString());
		typeBox.setEditable(false);
		typeBox.setColumns(10);
		GridBagConstraints gbc_typeBox = new GridBagConstraints();
		gbc_typeBox.fill = GridBagConstraints.BOTH;
		gbc_typeBox.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox.gridx = 0;
		gbc_typeBox.gridy = 3;
		contentPanel.add(typeBox, gbc_typeBox);

		valueBox = new JTextField(field.get(interpret.getInstance(instanceName)).toString());
		valueBox.setEditable(false);
		valueBox.setColumns(10);
		GridBagConstraints gbc_valueBox = new GridBagConstraints();
		gbc_valueBox.fill = GridBagConstraints.BOTH;
		gbc_valueBox.insets = new Insets(0, 0, 5, 0);
		gbc_valueBox.gridx = 1;
		gbc_valueBox.gridy = 3;
		contentPanel.add(valueBox, gbc_valueBox);

		JLabel lblNewValue = new JLabel("New Value");
		GridBagConstraints gbc_lblNewValue = new GridBagConstraints();
		gbc_lblNewValue.gridwidth = 2;
		gbc_lblNewValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewValue.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewValue.gridx = 0;
		gbc_lblNewValue.gridy = 4;
		contentPanel.add(lblNewValue, gbc_lblNewValue);

		newValueBox = new JTextField();
		newValueBox.setColumns(10);
		GridBagConstraints gbc_newValueBox = new GridBagConstraints();
		gbc_newValueBox.gridwidth = 2;
		gbc_newValueBox.insets = new Insets(0, 0, 0, 5);
		gbc_newValueBox.fill = GridBagConstraints.BOTH;
		gbc_newValueBox.gridx = 0;
		gbc_newValueBox.gridy = 5;
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
							interpret.set(instanceName, field, newValueBox.getText());
							setVisible(false);
						} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
								| SecurityException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "フィールドを修正できません",
									JOptionPane.ERROR_MESSAGE);
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
