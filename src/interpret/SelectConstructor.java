package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Constructor;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class SelectConstructor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameBox;
	private Interpret interpret;
	private String instanceName;
	private String className;
	private MainFrame owner;
	private JList<String> constructorList;

	/**
	 * Create the dialog.
	 */
	public SelectConstructor(Interpret interpret, String className, String instanceName, String[] constroctos, MainFrame owner) {

		this.instanceName = instanceName;
		this.interpret = interpret;
		this.className = className;
		this.owner = owner;

		setBounds(100, 100, 450, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		nameBox = new JTextField(className);
		nameBox.setBounds(52, 10, 370, 19);
		contentPanel.add(nameBox);
		nameBox.setColumns(10);

		JLabel lblClass = new JLabel("Class");
		lblClass.setBounds(12, 13, 50, 13);
		contentPanel.add(lblClass);

		JPanel panel = new JPanel();
		panel.setBounds(12, 52, 410, 313);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 410, 313);
		panel.add(scrollPane);

		constructorList = new JList<String> ();
		constructorList.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return constroctos.length;
			}
			public String getElementAt(int index) {
				return constroctos[index];
			}
		});
		constructorList.setToolTipText("");
		scrollPane.setViewportView(constructorList);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						createConstrucor();
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
	private void createConstrucor() {

		int index = constructorList.getSelectedIndex();
		if (index == -1) {
			MessageUtil.invalidSelectError();
			return;
		}

		Constructor<?> constructor;
		try {
			constructor = interpret.getConstructorLists(className) [index];
			ConstructorDialog dialog = new ConstructorDialog(interpret, className, instanceName,  constructor, owner);
			dialog.setVisible(true);
			this.setVisible(false);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
