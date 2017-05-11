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
	private JList<String> elementList;
	private DefaultListModel<String> instanceModel = new DefaultListModel<String>();

	public int flexibleInt = 4;
	public String flexibleStr = "Edit Me";

	private Method[] methods;

	private JTextField nameField;
	private JTextField lengthBox;

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	public void addInstanceList(String name) {
		instanceModel.addElement(name);
		instanceList.setSelectedIndex(instanceModel.getSize() - 1);
	}

	private void createObj() {
		String name = nameField.getText();
		if (name.contains("[") || name.contains("]") ) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前が不正です。", "Invalid Name", JOptionPane.ERROR_MESSAGE);
			return;
		}
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
		// if( setFieldAndMethods(name) ) {classNameField.getText()
		addInstanceList(name);
		// }
	}

	private void selectConstroctor() {
		String name = nameField.getText();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前を入力ください。", "Name Empty", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(interpret.exits(name)) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前が重複しています。", "Name Doubling", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String className =  classNameField.getText();

		SelectConstructor sc;
		try {
			sc = new SelectConstructor(interpret, className, name, interpret.getConstructorStrs(className), this);
			sc.setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			MessageUtil.showClassError();
			e.printStackTrace();
		}


	}
	private void setElementFields(String name) {
		String elements[] = interpret.getElementStrs(name);
		elementList.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return elements.length;
			}

			public String getElementAt(int index) {
				return elements[index];
			}
		});

	}
	private void setEmpty(JList<String> list) {
		list.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return 0;
			}

			public String getElementAt(int index) {
				return "";
			}
		});
		/*
		for(int i =0;  i < list.getModel().getSize(); i ++) {
			list.remove(i);
		}*/

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

		} catch (NullPointerException e) {
			throw e;
		}
		catch (Exception e) {
			MessageUtil.showClassError();
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public MainFrame() {
		getContentPane().setLocation(-25, -478);

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
		createObj.setBounds(25, 88, 136, 39);
		getContentPane().add(createObj);

		JButton constructorBtn = new JButton("Arbitrary Constructor");
		constructorBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectConstroctor();
			}
		});
		constructorBtn.setBounds(237, 88, 179, 39);
		getContentPane().add(constructorBtn);

		classNameField = new JTextField();
		classNameField.setBounds(136, 10, 526, 29);
		getContentPane().add(classNameField);
		classNameField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(258, 108, -217, 95);
		getContentPane().add(textArea);

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
		btnMethodSelect.setBounds(321, 667, 136, 29);
		getContentPane().add(btnMethodSelect);

		JLabel lblNewLabel = new JLabel("Class Name");
		lblNewLabel.setBounds(24, 18, 73, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblInstanceName = new JLabel("Instance Name");
		lblInstanceName.setBounds(12, 57, 106, 13);
		getContentPane().add(lblInstanceName);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(136, 49, 526, 29);
		getContentPane().add(nameField);

		JPanel panel = new JPanel();
		panel.setBounds(25, 155, 314, 160);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 0, 314, 157);
		panel.add(scrollPane_1);

		instanceList = new JList<String>();
		instanceList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent paramListSelectionEvent) {

					String name = instanceList.getSelectedValue();
					if(interpret.isArray(name)) {
						setElementFields(name);
						setEmpty(itemList);
						setEmpty(methodList);
					} else {
						setFieldAndMethods(name);
						setEmpty(elementList);
					}
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
		lblMethods.setBounds(25, 459, 106, 13);
		getContentPane().add(lblMethods);

		JLabel lblElements = new JLabel("Elements Of Array");
		lblElements.setBounds(25, 331, 106, 13);
		getContentPane().add(lblElements);

		JButton createArrayBtn = new JButton("Create Array");
		createArrayBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createArray();
			}
		});
		createArrayBtn.setBounds(478, 88, 147, 39);
		getContentPane().add(createArrayBtn);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(25, 354, 314, 95);
		getContentPane().add(scrollPane_3);

		elementList = new JList<String>();
		elementList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				setElementInfo();
			}
		});


		scrollPane_3.setViewportView(elementList);

		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(637, 85, 106, 13);
		getContentPane().add(lblLength);

		lengthBox = new JTextField();
		lengthBox.setColumns(10);
		lengthBox.setBounds(637, 108, 42, 19);
		getContentPane().add(lengthBox);

		JButton setElementBtn = new JButton("set elemet");
		setElementBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				int index = elementList.getSelectedIndex();
				String target = instanceList.getSelectedValue();
				if(index >= 0 && !target.isEmpty()) {
					(new ElementDialog(interpret, target,index, MainFrame.this )).setVisible(true);
				}
			}
		});
		setElementBtn.setBounds(227, 328, 112, 19);
		getContentPane().add(setElementBtn);
	}

	private void selectFieldEvent() {
		String fieldName = itemList.getSelectedValue();
		if (fieldName == null) {
			MessageUtil.invalidSelectError();
			return;
		}
		if (fieldName.equals(NULL_INSTANCE_STR)) {
			return;
		}
		try {
			Field field = interpret.getField(instanceList.getSelectedValue(), fieldName);
			// FieldDialog dialog = new FieldDialog(interpret, field.getName(),
			// field.getType().toString(),
			// field.get(interpret.getInstance()).toString() );
			if(!interpret.isArray( instanceList.getSelectedValue())) {
				FieldDialog dialog = new FieldDialog(interpret, instanceList.getSelectedValue(), field);
				dialog.setVisible(true);
			} else {
				if(elementList.getSelectedValue() == null) {
					return;
				}
				FieldDialog dialog = new FieldDialog(interpret, elementList.getSelectedValue(), field);
				dialog.setVisible(true);
			}


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
			if(!interpret.isArray( instanceList.getSelectedValue())) {
				MethodDialog dialog = new MethodDialog(interpret, instanceList.getSelectedValue(), method);
				dialog.setVisible(true);
			} else {
				if(elementList.getSelectedValue() == null) {
					return;
				}
				MethodDialog dialog = new MethodDialog(interpret, elementList.getSelectedValue(), method);
				dialog.setVisible(true);
			}
		} catch (SecurityException | IllegalArgumentException | ClassNotFoundException e) {
			MessageUtil.notFoundMethodError(e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
	}

	private void createArray() {
		int length = 0;
		try {
			length  = Integer.parseInt(lengthBox.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "配列長を正しく指定してください。", "Invalid Length", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String name = nameField.getText();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前を入力ください。", "Name Empty", JOptionPane.ERROR_MESSAGE);
			return;
		}
		name += "[]";
		if(interpret.exits(name)) {
			JOptionPane.showMessageDialog(null, "インスタンスの名前が重複しています。", "Name Doubling", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String className = classNameField.getText();

		try {
			interpret.createArray(className, name, length);
		} catch (ClassNotFoundException e) {
			MessageUtil.showClassError();
			e.printStackTrace();
			return;
		} catch (IllegalAccessException e) {
			MessageUtil.cannotCreateObjError();
			e.printStackTrace();
			return;
		}
		addInstanceList(name);
	}
	private static final String NULL_INSTANCE_STR =  "This instance is Null";

	public void setElementInfo() {
		String name = elementList.getSelectedValue();
		try {
			if(interpret.getInstance(name) == null) {
				throw new NullPointerException();
			}

			setFieldAndMethods(name);
		} catch(NullPointerException e) {
			//e.printStackTrace();
			itemList.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return 1;
				}
				public String getElementAt(int index) {
					return NULL_INSTANCE_STR;
				}
			});

		}
	}

}
