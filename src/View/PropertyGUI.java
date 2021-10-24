package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Manager.Helper;
import Manager.ListManager;
import Model.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Color;

public class PropertyGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUpdate;
	private JTextField txtOnemGuncelle;
	static List list;
	ListManager listManager = new ListManager();
	private static MainGUI mainGUI = new MainGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyGUI frame = new PropertyGUI(list);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PropertyGUI(List list) {
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setTitle("\u00D6zellikler");
		setBounds(100, 100, 491, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUpdate = new JTextField();
		txtUpdate.setText(list.getTask());
		txtUpdate.setBounds(10, 61, 457, 30);
		contentPane.add(txtUpdate);
		txtUpdate.setColumns(10);

		JButton btnUpdateTask = new JButton("G\u00FCncelle");
		btnUpdateTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean control = listManager.updateTask(list.getId(), txtUpdate.getText());

				if (control) {
					Helper.showMessage("succes");

				}

			}
		});
		btnUpdateTask.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnUpdateTask.setBounds(10, 101, 178, 49);
		contentPane.add(btnUpdateTask);

		txtOnemGuncelle = new JTextField();
		txtOnemGuncelle.setText(list.getOnem());
		txtOnemGuncelle.setColumns(10);
		txtOnemGuncelle.setBounds(10, 201, 457, 30);
		contentPane.add(txtOnemGuncelle);

		JButton btnUpdateOnem = new JButton("G\u00FCncelle");
		btnUpdateOnem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean control = listManager.updateOnem(list.getId(), txtOnemGuncelle.getText());

				if (control) {
					Helper.showMessage("succes");

				}

			}
		});
		btnUpdateOnem.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnUpdateOnem.setBounds(289, 241, 178, 49);
		contentPane.add(btnUpdateOnem);

		JLabel lblNewLabel = new JLabel("G\u00F6rev G\u00FCncelle / De\u011Fi\u015Ftir");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 21, 262, 30);
		contentPane.add(lblNewLabel);

		JLabel lblGrevinnemDzeyini = new JLabel("G\u00F6revin \u00D6nem D\u00FCzeyini Giriniz : ");
		lblGrevinnemDzeyini.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblGrevinnemDzeyini.setBounds(184, 161, 283, 30);
		contentPane.add(lblGrevinnemDzeyini);
	}

}
