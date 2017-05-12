package interpret;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class ElementDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField targetBox;
	//private Interpret interpret;
	private JList<String> instanceList;
	private JTextField indexBox;


	/**
	 * Create the dialog.
	 */
	public ElementDialog(Interpret interpret, String target, int index, MainFrame main) {
		//this.interpret = interpret;

		setBounds(100, 100, 472, 444);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(25, 59, 410, 300);
			contentPanel.add(panel);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.setBounds(0, 0, 410, 300);
				panel.add(scrollPane);
				{
					String[] instances = interpret.getInstances();
					instanceList = new JList<String> ();
					instanceList.setModel(new AbstractListModel<String>() {
						public int getSize() {
							return instances.length;
						}
						public String getElementAt(int index) {
							return instances[index];
						}
					});
					instanceList.setToolTipText("");
					scrollPane.setViewportView(instanceList);
				}
			}
		}

		JLabel lblTarget = new JLabel("Target");
		lblTarget.setBounds(25, 13, 50, 13);
		contentPanel.add(lblTarget);

		targetBox = new JTextField(target);
		targetBox.setEditable(false);
		targetBox.setColumns(10);
		targetBox.setBounds(72, 10, 221, 19);
		contentPanel.add(targetBox);
		{
			JLabel lblInstanceList = new JLabel("Instance List");
			lblInstanceList.setBounds(25, 36, 83, 13);
			contentPanel.add(lblInstanceList);
		}
		{
			JLabel lblIndex = new JLabel("Index");
			lblIndex.setBounds(305, 13, 33, 13);
			contentPanel.add(lblIndex);
		}
		{
			indexBox = new JTextField(Integer.toString(index));
			indexBox.setEditable(false);
			indexBox.setColumns(10);
			indexBox.setBounds(350, 10, 71, 19);
			contentPanel.add(indexBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton setButton = new JButton("Set Instance");
				setButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent paramMouseEvent) {
						try {
							interpret.setElement(target, index, instanceList.getSelectedValue());
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "配列要素のセットに失敗しました。", "Invalid Instance",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						JOptionPane.showMessageDialog(null, "配列要素のセットに成功しました。", "Element has setted",
								JOptionPane.DEFAULT_OPTION);
						main.setElementInfo();
					}
				});
				setButton.setActionCommand("OK");
				buttonPane.add(setButton);
				getRootPane().setDefaultButton(setButton);
			}
			{
				JButton cancelBtn = new JButton("Close");
				cancelBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent paramMouseEvent) {
						setVisible(false);
					}
				});
				cancelBtn.setActionCommand("OK");
				buttonPane.add(cancelBtn);
			}
		}
	}
}
