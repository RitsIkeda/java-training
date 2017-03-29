package interpret;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainFrame extends JFrame {
	private JTextField classNameField;
	private JList<String> itemList;
	private Interpret interpret = new Interpret();
	private JList<String> methodList;
	private JList<String> instanceList;
	private DefaultListModel<String> instanceModel = new DefaultListModel<String>();

	public int flexibleInt = 4;
	public String flexibleStr = "Edit Me";

	private Method[] methods;

	private enum AnlyzeMode {
		NONE, FIELD__MODE, METHOD_MODE, CREATE_OBJ_MODE, ARRAY_MODE
	}

	AnlyzeMode currentMode = AnlyzeMode.NONE;
	private JTextField nameField;

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	private void createObj() {
		String name = nameField.getText();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前を入力ください。", "Name Empty", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			interpret.createInstance(classNameField.getText(), name);
		} catch (InstantiationException | IllegalAccessException e) {
			MessageUtil.cannotCreateObjError();
			e.printStackTrace();
			return;
		} catch (ClassNotFoundException e) {
			MessageUtil.showClassError();
			e.printStackTrace();
			return;
		}
		// if( setFieldAndMethods(name) ) {
		instanceModel.addElement(name);
		instanceList.setSelectedIndex(instanceModel.getSize() - 1);
		// }
	}

	private boolean setFieldAndMethods(String name) {
		try {
			String fields[] = interpret.getFirldListsOfInstance(name);
			itemList.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return fields.length;
				}

				public String getElementAt(int index) {
					return fields[index];
				}
			});

			methods = interpret.getMethodListsOfInstance(name);
			methodList.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return methods.length;
				}

				public String getElementAt(int index) {
					return methods[index].toString();
				}
			});

		} catch (Exception e) {
			MessageUtil.showClassError();
			return false;
		}
		return true;

	}

	public MainFrame() {

		// instanceModel.set

		setResizable(false);
		setTitle("インタプリタ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 707, 734);
		getContentPane().setLayout(null);

		JButton createObj = new JButton("Create Object");
		createObj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createObj();
			}
		});
		createObj.setBounds(82, 88, 136, 39);
		getContentPane().add(createObj);

		JButton btnNewButton = new JButton("Arbitrary Constructor");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "This function will be coming soon.", "Sorry",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(270, 88, 179, 39);
		getContentPane().add(btnNewButton);

		classNameField = new JTextField();
		classNameField.setBounds(136, 10, 480, 29);
		getContentPane().add(classNameField);
		classNameField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(258, 108, -217, 95);
		getContentPane().add(textArea);

		JButton btnCreateArray = new JButton("Create Array");
		btnCreateArray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "This function will be coming soon.", "Sorry",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnCreateArray.setBounds(480, 88, 136, 39);
		getContentPane().add(btnCreateArray);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setBounds(369, 160, 306, 273);
		getContentPane().add(fieldPanel);
		fieldPanel.setLayout(null);

		itemList = new JList<String>();
		itemList.setBounds(1, 10, 287, 257);
		fieldPanel.add(itemList);
		itemList.setBackground(new Color(255, 255, 255));
		itemList.setToolTipText("");

		JScrollPane scrollPane = new JScrollPane(itemList);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 306, 272);

		fieldPanel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton selectBtn = new JButton("Field Select");
		selectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectFieldEvent();
			}
		});
		selectBtn.setBounds(451, 443, 136, 29);
		getContentPane().add(selectBtn);

		JPanel methodPanel = new JPanel();
		methodPanel.setLayout(null);
		methodPanel.setBounds(25, 477, 664, 187);
		getContentPane().add(methodPanel);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(0, 0, 664, 187);
		methodPanel.add(scrollPane_2);

		methodList = new JList<String>();
		scrollPane_2.setViewportView(methodList);
		methodList.setToolTipText("");
		methodList.setBackground(Color.WHITE);

		JButton btnMethodSelect = new JButton("Method Select");
		btnMethodSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectMethodEvent();
			}
		});
		btnMethodSelect.setBounds(307, 674, 136, 29);
		getContentPane().add(btnMethodSelect);

		JLabel lblNewLabel = new JLabel("Class Name");
		lblNewLabel.setBounds(24, 18, 73, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblInstanceName = new JLabel("Instance Name");
		lblInstanceName.setBounds(12, 57, 106, 13);
		getContentPane().add(lblInstanceName);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(136, 49, 480, 29);
		getContentPane().add(nameField);

		JPanel panel = new JPanel();
		panel.setBounds(25, 160, 314, 273);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 314, 276);
		panel.add(scrollPane_1);

		instanceList = new JList<String>();
		instanceList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				setFieldAndMethods(instanceList.getSelectedValue());
			}
		});
		scrollPane_1.setViewportView(instanceList);
		instanceList.setModel(instanceModel);

		JLabel lblCreatedInstances = new JLabel("Created Instances");
		lblCreatedInstances.setBounds(25, 137, 106, 13);
		getContentPane().add(lblCreatedInstances);

		JLabel lblFields = new JLabel("Fields");
		lblFields.setBounds(369, 137, 106, 13);
		getContentPane().add(lblFields);

		JLabel lblMethods = new JLabel("Methods");
		lblMethods.setBounds(25, 451, 106, 13);
		getContentPane().add(lblMethods);
	}

	private void selectFieldEvent() {
		String fieldName = itemList.getSelectedValue();
		if (fieldName == null) {
			MessageUtil.invalidSelectError();
			return;
		}
		try {
			Field field = interpret.getField(instanceList.getSelectedValue(), fieldName);
			// FieldDialog dialog = new FieldDialog(interpret, field.getName(),
			// field.getType().toString(),
			// field.get(interpret.getInstance()).toString() );
			FieldDialog dialog = new FieldDialog(interpret, instanceList.getSelectedValue(), field);
			dialog.setVisible(true);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			MessageUtil.notFoundFieldError(e.getMessage());
			System.out.println(e.getMessage());
			return;
		}
	}

	private void selectMethodEvent() {
		int index = methodList.getSelectedIndex();
		if (index == -1) {
			MessageUtil.invalidSelectError();
			return;
		}
		try {
			Method method = interpret.getMethodListsOfInstance(instanceList.getSelectedValue())[index];
			// FieldDialog dialog = new FieldDialog(interpret, field.getName(),
			// field.getType().toString(),
			// field.get(interpret.getInstance()).toString() );
			MethodDialog dialog = new MethodDialog(interpret, instanceList.getSelectedValue(), method);
			dialog.setVisible(true);

		} catch (SecurityException | IllegalArgumentException | ClassNotFoundException e) {
			MessageUtil.notFoundMethodError(e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
	}
}
