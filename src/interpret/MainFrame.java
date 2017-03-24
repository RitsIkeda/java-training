package interpret;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame {
	private JTextField classNameField;
	private JList<String> itemList;
	private Interpret interpret = new Interpret();

	private enum AnlyzeMode {
		NONE,
		FIELD__MODE,
		METHOD_MODE,
		CREATE_OBJ_MODE,
		ARRAY_MODE
	}
	AnlyzeMode currentMode = AnlyzeMode.NONE;

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	private void createObj() {
		try {

			String fields[] = interpret.getFirldLists(classNameField.getText());
			itemList.setModel(new AbstractListModel<String>() {
				public int getSize() {
					return fields.length;
				}
				public String getElementAt(int index) {
					return fields[index];
				}
			});

		} catch(Exception e) {
			MessageUtil.showClassError();
		}

		try {
			interpret.createInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			MessageUtil.cannotCreateObjError();
			e.printStackTrace();
		}

	}


	public MainFrame() {
		setResizable(false);
		setTitle("インタプリタ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 504);
		getContentPane().setLayout(null);

		JButton createObj = new JButton("Create Object");
		createObj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createObj();
			}
		});
		createObj.setBounds(82, 54, 136, 39);
		getContentPane().add(createObj);

		JButton btnNewButton = new JButton("Arbitrary Constructor");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "This function will be coming soon.","Sorry" ,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(269, 54, 179, 39);
		getContentPane().add(btnNewButton);

		classNameField = new JTextField();
		classNameField.setBounds(122, 10, 480, 29);
		getContentPane().add(classNameField);
		classNameField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(258, 108, -217, 95);
		getContentPane().add(textArea);

		JButton btnCreateArray = new JButton("Create Array");
		btnCreateArray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "This function will be coming soon.","Sorry",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnCreateArray.setBounds(480, 54, 136, 39);
		getContentPane().add(btnCreateArray);

		JPanel fieldPanel = new JPanel();
		fieldPanel.setBounds(27, 103, 306, 305);
		getContentPane().add(fieldPanel);
		fieldPanel.setLayout(null);

		itemList = new JList<String>();
		itemList.setBounds(1, 10, 287, 257);
		fieldPanel.add(itemList);
		itemList.setBackground(new Color(255, 255, 255));
		itemList.setToolTipText("");

		JScrollPane scrollPane = new JScrollPane(itemList);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 10, 306, 295);

		fieldPanel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton selectBtn = new JButton("Field Select");
		selectBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectFieldEvent();
			}
		});
		selectBtn.setBounds(110, 418, 136, 29);
		getContentPane().add(selectBtn);

		JPanel methodPanel = new JPanel();
		methodPanel.setLayout(null);
		methodPanel.setBounds(353, 103, 336, 305);
		getContentPane().add(methodPanel);

				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_2.setBounds(12, 10, 312, 295);
				methodPanel.add(scrollPane_2);

				JList<String> list = new JList<String>();
				scrollPane_2.setViewportView(list);
				list.setToolTipText("");
				list.setBackground(Color.WHITE);

		JButton btnMethodSelect = new JButton("Method Select");
		btnMethodSelect.setBounds(466, 422, 136, 29);
		getContentPane().add(btnMethodSelect);
	}

	private void selectFieldEvent() {
		String fieldName = itemList.getSelectedValue();
		if(fieldName == null) {
			MessageUtil.invalidSelectError();
			return;
		}


		try{
			Field field = interpret.getField(fieldName);
			FieldDialog dialog = new FieldDialog(interpret, field.getName(), field.getType().toString(), field.get(interpret.getInstance()).toString() );
			dialog.setVisible(true);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException  e) {
			MessageUtil.notFoundFieldError();
			System.out.println(e.getMessage());
			return;
		}
	}

}




