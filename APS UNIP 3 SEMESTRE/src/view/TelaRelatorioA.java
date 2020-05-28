package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.ModelRelatorioA;
import model.dao.RelatorioADAO;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaRelatorioA {

	public JFrame frame;
	public JTextField txtAno;
	public JTextField txtAno2;
	public JTable table;
	public JTextField cid1;
	public JTextField cid2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioA window = new TelaRelatorioA();
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
	public TelaRelatorioA() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioADAO rdao = new RelatorioADAO();

		for (ModelRelatorioA ra : rdao.read()) {
			modelo.addRow(new Object[] {

					ra.getIdCidDoen(), ra.getNomeCidade(), ra.getPopuQtd(), ra.getPopuAno(), ra.getQtdInfec(),
					ra.getQtdInfec2(), ra.getQtdVac(), ra.getQtdVac2(), ra.getQtdObito(), ra.getQtdObito2() });
		}
	}

	public void readJTableForDesc(String desc, String desc2, String cid1, String cid2) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioADAO rdao = new RelatorioADAO();

		for (ModelRelatorioA ra : rdao.readForDesc(desc, desc2, cid1, cid2)) {

			modelo.addRow(new Object[] {

					ra.getIdCidDoen(), ra.getNomeCidade(), ra.getPopuQtd(), ra.getPopuAno(), ra.getQtdInfec(),
					ra.getQtdInfec2(), ra.getQtdVac(), ra.getQtdVac2(), ra.getQtdObito(), ra.getQtdObito2() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Relat\u00F3rio A - Duas Cidades");
		frame.setBounds(100, 100, 734, 497);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(31, 33, 650, 161);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno.setBounds(403, 41, 113, 20);
		panel.add(txtAno);
		txtAno.setColumns(10);

		txtAno2 = new JTextField();
		txtAno2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno2.setBounds(403, 83, 113, 20);
		panel.add(txtAno2);
		txtAno2.setColumns(10);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(485, 129, 155, 23);
		panel.add(btnContinuar);

		JLabel lblAno = new JLabel("Ano \u00EDnicio:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAno.setBounds(318, 33, 74, 32);
		panel.add(lblAno);

		JLabel lblCidade = new JLabel("Cidades:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(44, 39, 113, 20);
		panel.add(lblCidade);

		cid1 = new JTextField();
		cid1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cid1.setBounds(114, 39, 121, 20);
		panel.add(cid1);
		cid1.setColumns(10);

		cid2 = new JTextField();
		cid2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cid2.setColumns(10);
		cid2.setBounds(114, 70, 121, 20);
		panel.add(cid2);

		JLabel lblAnoFim = new JLabel("Ano fim:");
		lblAnoFim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoFim.setBounds(318, 78, 74, 32);
		panel.add(lblAnoFim);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 205, 650, 226);
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
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Cidade", "Popula\u00E7\u00E3o", "Ano", "Infectados", "% de Infectados",
						"Vacinados", "% de Vacinados", "\u00D3bitos", "% de \u00D3bitos" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(23);
		table.getColumnModel().getColumn(1).setPreferredWidth(62);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(112);
		table.getColumnModel().getColumn(7).setPreferredWidth(109);
		table.getColumnModel().getColumn(9).setPreferredWidth(114);
		scrollPane.setViewportView(table);

		btnContinuar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnContinuarActionPerformed(evt);
			}

			public void btnContinuarActionPerformed(ActionEvent evt) {
				readJTableForDesc(txtAno.getText(), txtAno2.getText(), cid1.getText(), cid2.getText());
			}
		});

	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub

	}
}
