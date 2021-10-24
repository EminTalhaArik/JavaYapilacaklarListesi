package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Manager.ListManager;
import Model.List;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Manager.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class MainGUI extends JFrame {

	private String selectedTask;
	private String selectedOnem;
	private int selectedID;
	private JPanel contentPane;
	private JTable tblListTask;
	private JTextField txtAddTask;

	ListManager listManager = new ListManager();
	DefaultTableModel taskModel = null;
	Object[] taskData = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {

		taskModel = new DefaultTableModel();
		Object[] colTaskName = new Object[3];
		colTaskName[0] = "ID";
		colTaskName[1] = "Önem Düzeyi";
		colTaskName[2] = "Görev";

		taskModel.setColumnIdentifiers(colTaskName);
		taskData = new Object[3];

		for (int i = 0; i < listManager.getList().size(); i++) {

			taskData[0] = listManager.getList().get(i).getId();
			taskData[1] = listManager.getList().get(i).getOnem();
			taskData[2] = listManager.getList().get(i).getTask();

			taskModel.addRow(taskData);

		}

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\EclipseProjectsSpace\\Yap\u0131lacaklarListesi\\src\\yapilacaklarlistesiicon.png"));
		setTitle("Do Now");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 549);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("L\u00FCtfen Bir G\u00F6rev Giriniz : ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(44, 42, 209, 31);
		contentPane.add(lblNewLabel);

		txtAddTask = new JTextField();
		txtAddTask.setBounds(263, 42, 601, 31);
		contentPane.add(txtAddTask);
		txtAddTask.setColumns(10);

		JButton btnAdd = new JButton("Ekle");
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (txtAddTask.getText().length() == 0) {
					Helper.showMessage("fill");
				} else {

					boolean control = listManager.addTask(txtAddTask.getText());

					if (control) {
						Helper.showMessage("succes");
						txtAddTask.setText(null);
						updateTaskTable();
					}

				}

			}
		});

		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnAdd.setBounds(157, 107, 209, 52);
		contentPane.add(btnAdd);

		JButton btnProperties = new JButton("\u00D6zellikler");
		btnProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List selectedList = listManager.getFetch(selectedID);
				PropertyGUI propertyGUI = new PropertyGUI(selectedList);
				propertyGUI.setVisible(true);

			}
		});
		btnProperties.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnProperties.setEnabled(false);
		btnProperties.setBounds(601, 107, 209, 52);
		contentPane.add(btnProperties);

		JButton btnDelete = new JButton("Sil");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Helper.confirmMessage("sure")) {
					boolean control = listManager.deleteTask(selectedID);

					if (control) {
						Helper.showMessage("succes");
						updateTaskTable();
						btnDelete.setEnabled(false);
						btnProperties.setEnabled(false);
					}
				}
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnDelete.setBounds(376, 107, 209, 52);
		contentPane.add(btnDelete);

		JScrollPane paneTodo = new JScrollPane();
		paneTodo.setBounds(10, 199, 906, 312);
		contentPane.add(paneTodo);

		tblListTask = new JTable(taskModel);
		tblListTask.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblListTask.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {

					selectedID = Integer.parseInt(tblListTask.getValueAt(tblListTask.getSelectedRow(), 0).toString());

					btnDelete.setEnabled(true);
					btnProperties.setEnabled(true);

				} catch (Exception e2) {

				}

			}
		});

		paneTodo.setViewportView(tblListTask);
		
		JButton btnNewButton = new JButton("Yenile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTaskTable();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnNewButton.setBounds(831, 10, 85, 21);
		contentPane.add(btnNewButton);

	}

	public void updateTaskTable() {
		
		DefaultTableModel clearModel = (DefaultTableModel) tblListTask.getModel();
		clearModel.setRowCount(0);

		for (int i = 0; i < listManager.getList().size(); i++) {

			taskData[0] = listManager.getList().get(i).getId();
			taskData[1] = listManager.getList().get(i).getOnem();
			taskData[2] = listManager.getList().get(i).getTask();

			taskModel.addRow(taskData);

		}

	}
}
