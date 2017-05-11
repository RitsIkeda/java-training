package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConstructorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField instanceBox;
	private JTextField exeptionBox;
	private MainFrame owner;

	private Interpret interpret;
	private  Constructor<?> constructor;
	private String className;
	private String instanceName;
	private JTextField methodBox;

	private JTextField[] typeBoxes = new JTextField[10];
	private JTextField[] argBoxes = new JTextField[10];
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;

	/**
	 * Create the dialog.
	 */
	public ConstructorDialog(Interpret interpret, String className,  String instanceName, Constructor<?> constructor, MainFrame owner) {
		this.constructor = constructor;
		this.interpret = interpret;
		this.instanceName = instanceName;
		this.className = className;
		this.owner = owner;

		setBounds(100, 100, 538, 566);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblMethodName = new JLabel("Instance Name");
		lblMethodName.setBounds(12, 30, 115, 13);
		contentPanel.add(lblMethodName);

		instanceBox = new JTextField(instanceName);
		instanceBox.setEditable(false);
		instanceBox.setBounds(139, 27, 377, 19);
		instanceBox.setColumns(10);
		contentPanel.add(instanceBox);

		JLabel lblExeption = new JLabel("Exeption");
		lblExeption.setBounds(12, 447, 81, 13);
		contentPanel.add(lblExeption);

		exeptionBox = new JTextField();
		exeptionBox.setFont(new Font("MS UI Gothic", Font.PLAIN, 10));
		exeptionBox.setBounds(12, 464, 504, 25);
		exeptionBox.setColumns(10);
		contentPanel.add(exeptionBox);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 516, 381);
		contentPanel.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 26, 129, 233, 0 };
		gbl_panel.rowHeights = new int[] { 34, 31, 36, 34, 35, 34, 35, 38, 34, 35, 29, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
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
		gbc_lblArgmentspleaseSeparate.insets = new Insets(0, 0, 5, 0);
		gbc_lblArgmentspleaseSeparate.gridx = 2;
		gbc_lblArgmentspleaseSeparate.gridy = 0;
		panel.add(lblArgmentspleaseSeparate, gbc_lblArgmentspleaseSeparate);

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

		argBoxes[0] = new JTextField();
		argBoxes[0].setColumns(10);
		GridBagConstraints gbc_argBox0 = new GridBagConstraints();
		gbc_argBox0.insets = new Insets(0, 0, 5, 0);
		gbc_argBox0.fill = GridBagConstraints.BOTH;
		gbc_argBox0.gridx = 2;
		gbc_argBox0.gridy = 1;
		panel.add(argBoxes[0], gbc_argBox0);

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

		argBoxes[1] = new JTextField();
		argBoxes[1].setColumns(10);
		GridBagConstraints gbc_argBox1 = new GridBagConstraints();
		gbc_argBox1.insets = new Insets(0, 0, 5, 0);
		gbc_argBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox1.gridx = 2;
		gbc_argBox1.gridy = 2;
		panel.add(argBoxes[1], gbc_argBox1);

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

		argBoxes[2] = new JTextField();
		argBoxes[2].setColumns(10);
		GridBagConstraints gbc_argBox2 = new GridBagConstraints();
		gbc_argBox2.insets = new Insets(0, 0, 5, 0);
		gbc_argBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox2.gridx = 2;
		gbc_argBox2.gridy = 3;
		panel.add(argBoxes[2], gbc_argBox2);

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

		argBoxes[3] = new JTextField();
		argBoxes[3].setColumns(10);
		GridBagConstraints gbc_argBox3 = new GridBagConstraints();
		gbc_argBox3.insets = new Insets(0, 0, 5, 0);
		gbc_argBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox3.gridx = 2;
		gbc_argBox3.gridy = 4;
		panel.add(argBoxes[3], gbc_argBox3);

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

		argBoxes[4] = new JTextField();
		argBoxes[4].setColumns(10);
		GridBagConstraints gbc_argBox4 = new GridBagConstraints();
		gbc_argBox4.insets = new Insets(0, 0, 5, 0);
		gbc_argBox4.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox4.gridx = 2;
		gbc_argBox4.gridy = 5;
		panel.add(argBoxes[4], gbc_argBox4);

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

		argBoxes[5] = new JTextField();
		argBoxes[5].setColumns(10);
		GridBagConstraints gbc_argBox5 = new GridBagConstraints();
		gbc_argBox5.insets = new Insets(0, 0, 5, 0);
		gbc_argBox5.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox5.gridx = 2;
		gbc_argBox5.gridy = 6;
		panel.add(argBoxes[5], gbc_argBox5);

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

		argBoxes[6] = new JTextField();
		argBoxes[6].setColumns(10);
		GridBagConstraints gbc_argBox6 = new GridBagConstraints();
		gbc_argBox6.insets = new Insets(0, 0, 5, 0);
		gbc_argBox6.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox6.gridx = 2;
		gbc_argBox6.gridy = 7;
		panel.add(argBoxes[6], gbc_argBox6);

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

		argBoxes[7] = new JTextField();
		argBoxes[7].setColumns(10);
		GridBagConstraints gbc_argBox7 = new GridBagConstraints();
		gbc_argBox7.insets = new Insets(0, 0, 5, 0);
		gbc_argBox7.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox7.gridx = 2;
		gbc_argBox7.gridy = 8;
		panel.add(argBoxes[7], gbc_argBox7);

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

		argBoxes[8] = new JTextField();
		argBoxes[8].setColumns(10);
		GridBagConstraints gbc_argBox8 = new GridBagConstraints();
		gbc_argBox8.insets = new Insets(0, 0, 5, 0);
		gbc_argBox8.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox8.gridx = 2;
		gbc_argBox8.gridy = 9;
		panel.add(argBoxes[8], gbc_argBox8);

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

		argBoxes[9] = new JTextField();
		argBoxes[9].setColumns(10);
		GridBagConstraints gbc_argBox9 = new GridBagConstraints();
		gbc_argBox9.fill = GridBagConstraints.HORIZONTAL;
		gbc_argBox9.gridx = 2;
		gbc_argBox9.gridy = 10;
		panel.add(argBoxes[9], gbc_argBox9);

		JLabel lblFieldName = new JLabel("Class Name");
		lblFieldName.setBounds(12, 10, 115, 13);
		contentPanel.add(lblFieldName);

		methodBox = new JTextField(className);
		methodBox.setEditable(false);
		methodBox.setColumns(10);
		methodBox.setBounds(139, 7, 377, 19);
		contentPanel.add(methodBox);

		updateTypeBox();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Run");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						runMethod();
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

	private void runMethod() {
		try {
			interpret.runConstructor(className, instanceName, constructor, makeArgmentStrs());
			owner.addInstanceList(instanceName);
		
		} catch(InvocationTargetException e) {
			exeptionBox.setText(e.getCause().getClass().toString() );

		} catch (Exception e) {
			exeptionBox.setText(e.getClass().getName() + " " + e.getMessage());
			e.printStackTrace();
		}
	}


	private String[] makeArgmentStrs() {
		int length = constructor.getParameterTypes().length;
		String[] strs = new String[length];
		for (int i = 0; i < length; i++) {
			strs[i] = argBoxes[i].getText();
		}
		return strs;
	}

	private void updateTypeBox() {
		Class<?>[] c = constructor.getParameterTypes();
		for (int i = 0; i < typeBoxes.length; i++) {
			if (i < c.length) {
				typeBoxes[i].setText(c[i].getName());
			} else {
				typeBoxes[i].setText("no argment");
			}
		}

	}
}
