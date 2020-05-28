package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import model.bean.ModelRelatorioB;
import model.dao.RelatorioADAO;
import model.dao.RelatorioBDAO;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class TelaRelatorioB {

	public JFrame frame;
	public JTextField cid1;
	public JTextField cid2;
	public JTextField cid3;
	public JTextField txtAno;
	public JTextField txtAno2;
	public JTable table;
	private JLabel lblAnoFim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioB window = new TelaRelatorioB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRelatorioB() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioBDAO rdao = new RelatorioBDAO();

		for (ModelRelatorioB ra : rdao.read()) {
			modelo.addRow(new Object[] {

					ra.getIdCidDoen(), ra.getNomeCidade(), ra.getPopuQtd(), ra.getPopuAno(), ra.getQtdInfec(),
					ra.getQtdInfec2(), ra.getQtdVac(), ra.getQtdVac2(), ra.getQtdObito(), ra.getQtdObito2() });
		}
	}

	public void readJTableForDesc(String desc, String desc2, String cid1, String cid2, String cid3) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioBDAO rdao = new RelatorioBDAO();

		for (ModelRelatorioB ra : rdao.readForDesc(desc, desc2, cid1, cid2, cid3)) {

			modelo.addRow(new Object[] {

					ra.getIdCidDoen(), ra.getNomeCidade(), ra.getPopuQtd(), ra.getPopuAno(), ra.getQtdInfec(),
					ra.getQtdInfec2(), ra.getQtdVac(), ra.getQtdVac2(), ra.getQtdObito(), ra.getQtdObito2() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Relat\u00F3rio B - 3 Cidades");
		frame.setBounds(100, 100, 786, 515);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		cid1 = new JTextField();
		cid1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cid1.setBounds(104, 53, 120, 20);
		frame.getContentPane().add(cid1);
		cid1.setColumns(10);

		cid2 = new JTextField();
		cid2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cid2.setBounds(104, 86, 120, 20);
		frame.getContentPane().add(cid2);
		cid2.setColumns(10);

		cid3 = new JTextField();
		cid3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cid3.setBounds(104, 117, 120, 20);
		frame.getContentPane().add(cid3);
		cid3.setColumns(10);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(553, 163, 170, 23);
		frame.getContentPane().add(btnContinuar);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno.setBounds(445, 55, 120, 20);
		frame.getContentPane().add(txtAno);
		txtAno.setColumns(10);

		txtAno2 = new JTextField();
		txtAno2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno2.setBounds(445, 94, 120, 20);
		frame.getContentPane().add(txtAno2);
		txtAno2.setColumns(10);

		JLabel lblCidade = new JLabel("Cidades:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(22, 52, 103, 23);
		frame.getContentPane().add(lblCidade);

		JLabel lblAno = new JLabel("Ano in\u00EDcio:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAno.setBounds(365, 52, 89, 23);
		frame.getContentPane().add(lblAno);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 197, 719, 255);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		lblAnoFim = new JLabel("Ano fim:");
		lblAnoFim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoFim.setBounds(365, 91, 89, 23);
		frame.getContentPane().add(lblAnoFim);

		btnContinuar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnContinuarActionPerformed(evt);
			}

			public void btnContinuarActionPerformed(ActionEvent evt) {
				readJTableForDesc(txtAno.getText(), txtAno2.getText(), cid1.getText(), cid2.getText(), cid3.getText());
			}
		});
	}
}
