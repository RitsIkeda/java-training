package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MethodDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField instanceBox;
	private JTextField argmentsBox;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private Interpret interpret;
	private Method method;
	private String instanceName;
	private JTextField methodBox;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	private JTextField[] typeBoxes = new JTextField[10];
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblUseCreatedInstances;

	/**
	 * Create the dialog.
	 */
	public MethodDialog(Interpret interpret, String instanceName, Method method) {
		this.method = method;
		this.interpret = interpret;
		this.instanceName = instanceName;

		setBounds(100, 100, 538, 593);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblMethodName = new JLabel("Instance Name");
		lblMethodName.setBounds(12, 10, 115, 13);
		contentPanel.add(lblMethodName);

		instanceBox = new JTextField(instanceName);
		instanceBox.setEditable(false);
		instanceBox.setBounds(139, 7, 377, 19);
		instanceBox.setColumns(10);
		contentPanel.add(instanceBox);

		JLabel lblRtrunType = new JLabel("Return Type");
		lblRtrunType.setBounds(12, 447, 81, 13);
		contentPanel.add(lblRtrunType);

		textField_3 = new JTextField();
		textField_3.setBounds(87, 444, 146, 19);
		textField_3.setColumns(10);
		contentPanel.add(textField_3);

		JLabel lblRetunValue = new JLabel("Return Value");
		lblRetunValue.setBounds(281, 447, 81, 13);
		contentPanel.add(lblRetunValue);

		textField_4 = new JTextField();
		textField_4.setBounds(360, 444, 150, 19);
		textField_4.setColumns(10);
		contentPanel.add(textField_4);

		JLabel lblExeption = new JLabel("Exeption");
		lblExeption.setBounds(12, 470, 81, 13);
		contentPanel.add(lblExeption);

		textField_5 = new JTextField();
		textField_5.setBounds(12, 495, 504, 19);
		textField_5.setColumns(10);
		contentPanel.add(textField_5);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 516, 381);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 26, 129, 233, 103, 0 };
		gbl_panel.rowHeights = new int[] { 34, 31, 36, 34, 35, 34, 35, 38, 34, 35, 29, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTyoe = new JLabel("Type");
		GridBagConstraints gbc_lblTyoe = new GridBagConstraints();
		gbc_lblTyoe.insets = new Insets(0, 0, 5, 5);
		gbc_lblTyoe.gridx = 1;
		gbc_lblTyoe.gridy = 0;
		panel.add(lblTyoe, gbc_lblTyoe);

		JLabel lblArgmentspleaseSeparate = new JLabel("Argments Value");
		GridBagConstraints gbc_lblArgmentspleaseSeparate = new GridBagConstraints();
		gbc_lblArgmentspleaseSeparate.insets = new Insets(0, 0, 5, 5);
		gbc_lblArgmentspleaseSeparate.gridx = 2;
		gbc_lblArgmentspleaseSeparate.gridy = 0;
		panel.add(lblArgmentspleaseSeparate, gbc_lblArgmentspleaseSeparate);

		lblUseCreatedInstances = new JLabel("Use instances");
		GridBagConstraints gbc_lblUseCreatedInstances = new GridBagConstraints();
		gbc_lblUseCreatedInstances.insets = new Insets(0, 0, 5, 0);
		gbc_lblUseCreatedInstances.gridx = 3;
		gbc_lblUseCreatedInstances.gridy = 0;
		panel.add(lblUseCreatedInstances, gbc_lblUseCreatedInstances);

		JLabel label = new JLabel("0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);

		typeBoxes[0] = new JTextField();
		typeBoxes[0].setEditable(false);
		typeBoxes[0].setColumns(10);
		GridBagConstraints gbc_typeBox1 = new GridBagConstraints();
		gbc_typeBox1.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox1.gridx = 1;
		gbc_typeBox1.gridy = 1;
		panel.add(typeBoxes[0], gbc_typeBox1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		label_1 = new JLabel("1");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		panel.add(label_1, gbc_label_1);

		typeBoxes[1] = new JTextField();
		typeBoxes[1].setEditable(false);
		typeBoxes[1].setColumns(10);
		GridBagConstraints gbc_typeBox2 = new GridBagConstraints();
		gbc_typeBox2.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox2.gridx = 1;
		gbc_typeBox2.gridy = 2;
		panel.add(typeBoxes[1], gbc_typeBox2);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);

		JCheckBox checkBox = new JCheckBox("");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 3;
		gbc_checkBox.gridy = 2;
		panel.add(checkBox, gbc_checkBox);

		label_2 = new JLabel("2");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		panel.add(label_2, gbc_label_2);

		typeBoxes[2] = new JTextField();
		typeBoxes[2].setEditable(false);
		typeBoxes[2].setColumns(10);
		GridBagConstraints gbc_typeBox3 = new GridBagConstraints();
		gbc_typeBox3.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox3.gridx = 1;
		gbc_typeBox3.gridy = 3;
		panel.add(typeBoxes[2], gbc_typeBox3);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel.add(textField_2, gbc_textField_2);

		JCheckBox checkBox_1 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_1.gridx = 3;
		gbc_checkBox_1.gridy = 3;
		panel.add(checkBox_1, gbc_checkBox_1);

		label_3 = new JLabel("3");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		panel.add(label_3, gbc_label_3);

		typeBoxes[3] = new JTextField();
		typeBoxes[3].setEditable(false);
		typeBoxes[3].setColumns(10);
		GridBagConstraints gbc_typeBox4 = new GridBagConstraints();
		gbc_typeBox4.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox4.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox4.gridx = 1;
		gbc_typeBox4.gridy = 4;
		panel.add(typeBoxes[3], gbc_typeBox4);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 4;
		panel.add(textField_6, gbc_textField_6);

		JCheckBox checkBox_2 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_2.gridx = 3;
		gbc_checkBox_2.gridy = 4;
		panel.add(checkBox_2, gbc_checkBox_2);

		label_4 = new JLabel("4");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		panel.add(label_4, gbc_label_4);

		typeBoxes[4] = new JTextField();
		typeBoxes[4].setEditable(false);
		typeBoxes[4].setColumns(10);
		GridBagConstraints gbc_typeBox5 = new GridBagConstraints();
		gbc_typeBox5.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox5.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox5.gridx = 1;
		gbc_typeBox5.gridy = 5;
		panel.add(typeBoxes[4], gbc_typeBox5);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 5;
		panel.add(textField_7, gbc_textField_7);

		JCheckBox checkBox_3 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_3.gridx = 3;
		gbc_checkBox_3.gridy = 5;
		panel.add(checkBox_3, gbc_checkBox_3);

		label_5 = new JLabel("5");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 6;
		panel.add(label_5, gbc_label_5);

		typeBoxes[5] = new JTextField();
		typeBoxes[5].setEditable(false);
		typeBoxes[5].setColumns(10);
		GridBagConstraints gbc_typeBox6 = new GridBagConstraints();
		gbc_typeBox6.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox6.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox6.gridx = 1;
		gbc_typeBox6.gridy = 6;
		panel.add(typeBoxes[5], gbc_typeBox6);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 6;
		panel.add(textField_8, gbc_textField_8);

		JCheckBox checkBox_4 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_4.gridx = 3;
		gbc_checkBox_4.gridy = 6;
		panel.add(checkBox_4, gbc_checkBox_4);

		label_6 = new JLabel("6");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 7;
		panel.add(label_6, gbc_label_6);

		typeBoxes[6] = new JTextField();
		typeBoxes[6].setEditable(false);
		typeBoxes[6].setColumns(10);
		GridBagConstraints gbc_typeBox7 = new GridBagConstraints();
		gbc_typeBox7.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox7.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox7.gridx = 1;
		gbc_typeBox7.gridy = 7;
		panel.add(typeBoxes[6], gbc_typeBox7);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 2;
		gbc_textField_9.gridy = 7;
		panel.add(textField_9, gbc_textField_9);

		JCheckBox checkBox_5 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_5 = new GridBagConstraints();
		gbc_checkBox_5.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_5.gridx = 3;
		gbc_checkBox_5.gridy = 7;
		panel.add(checkBox_5, gbc_checkBox_5);

		label_7 = new JLabel("7");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 8;
		panel.add(label_7, gbc_label_7);

		typeBoxes[7] = new JTextField();
		typeBoxes[7].setEditable(false);
		typeBoxes[7].setColumns(10);
		GridBagConstraints gbc_typeBox8 = new GridBagConstraints();
		gbc_typeBox8.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox8.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox8.gridx = 1;
		gbc_typeBox8.gridy = 8;
		panel.add(typeBoxes[7], gbc_typeBox8);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 8;
		panel.add(textField_10, gbc_textField_10);

		JCheckBox checkBox_6 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_6 = new GridBagConstraints();
		gbc_checkBox_6.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_6.gridx = 3;
		gbc_checkBox_6.gridy = 8;
		panel.add(checkBox_6, gbc_checkBox_6);

		label_8 = new JLabel("8");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.anchor = GridBagConstraints.EAST;
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 9;
		panel.add(label_8, gbc_label_8);

		typeBoxes[8] = new JTextField();
		typeBoxes[8].setEditable(false);
		typeBoxes[8].setColumns(10);
		GridBagConstraints gbc_typeBox9 = new GridBagConstraints();
		gbc_typeBox9.insets = new Insets(0, 0, 5, 5);
		gbc_typeBox9.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox9.gridx = 1;
		gbc_typeBox9.gridy = 9;
		panel.add(typeBoxes[8], gbc_typeBox9);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 2;
		gbc_textField_11.gridy = 9;
		panel.add(textField_11, gbc_textField_11);

		JCheckBox checkBox_7 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_7 = new GridBagConstraints();
		gbc_checkBox_7.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox_7.gridx = 3;
		gbc_checkBox_7.gridy = 9;
		panel.add(checkBox_7, gbc_checkBox_7);

		label_9 = new JLabel("9");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 10;
		panel.add(label_9, gbc_label_9);

		typeBoxes[9] = new JTextField();
		typeBoxes[9].setEditable(false);
		typeBoxes[9].setColumns(10);
		GridBagConstraints gbc_typeBox10 = new GridBagConstraints();
		gbc_typeBox10.insets = new Insets(0, 0, 0, 5);
		gbc_typeBox10.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeBox10.gridx = 1;
		gbc_typeBox10.gridy = 10;
		panel.add(typeBoxes[9], gbc_typeBox10);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.insets = new Insets(0, 0, 0, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 2;
		gbc_textField_12.gridy = 10;
		panel.add(textField_12, gbc_textField_12);

		JCheckBox checkBox_8 = new JCheckBox("");
		GridBagConstraints gbc_checkBox_8 = new GridBagConstraints();
		gbc_checkBox_8.gridx = 3;
		gbc_checkBox_8.gridy = 10;
		panel.add(checkBox_8, gbc_checkBox_8);

		JLabel lblFieldName = new JLabel("Method Name");
		lblFieldName.setBounds(12, 33, 115, 13);
		contentPanel.add(lblFieldName);

		methodBox = new JTextField(method.getName());
		methodBox.setEditable(false);
		methodBox.setColumns(10);
		methodBox.setBounds(139, 30, 377, 19);
		contentPanel.add(methodBox);

		updateTypeBox();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Run");
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

	private void updateTypeBox() {
		Class<?>[] c = method.getParameterTypes();
		for (int i = 0; i < typeBoxes.length; i++) {
			if (i < c.length) {
				typeBoxes[i].setText(c[i].getName());
			} else {
				typeBoxes[i].setText("no argment");
			}
		}

	}
}
