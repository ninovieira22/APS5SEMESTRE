package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.ModelRelatorioC;
import model.bean.ModelTelaCidades;
import model.dao.CidadesDAO;
import model.dao.RelatorioCDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class TelaRelatorioC {

	public JFrame frame;
	public JTable table;
	public JTextField txtAno;
	public JTextField txtAno2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioC window = new TelaRelatorioC();
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
	public TelaRelatorioC() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioCDAO rdao = new RelatorioCDAO();

		for (ModelRelatorioC ra : rdao.read()) {
			modelo.addRow(new Object[] {

					ra.getIdCidDoen(), ra.getNomeCidade(), ra.getPopuQtd(), ra.getPopuAno(), ra.getQtdInfec(),
					ra.getQtdInfec2(), ra.getQtdVac(), ra.getQtdVac2(), ra.getQtdObito(), ra.getQtdObito2() });
		}
	}

	public void readJTableForDesc(String desc, String desc2) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		RelatorioCDAO rdao = new RelatorioCDAO();

		for (ModelRelatorioC ra : rdao.readForDesc(desc, desc2)) {

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
		frame.setTitle("Relat\u00F3rio C - Todas as Cidades Por Ano");
		frame.setBounds(100, 100, 790, 522);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 165, 716, 291);
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
						{ null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Cidade", "Popula\u00E7\u00E3o", "Ano", "Infectados", "% de Infectados",
						"Vacinados", "% de Vacinados", "\u00D3bitos", "% de \u00D3bitos" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(24);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(33);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(91);
		table.getColumnModel().getColumn(7).setMinWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(65);
		table.getColumnModel().getColumn(9).setPreferredWidth(98);
		table.getColumnModel().getColumn(9).setMinWidth(40);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBounds(27, 11, 716, 130);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblFim = new JLabel("Ano fim:");
		lblFim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFim.setBounds(84, 85, 86, 17);
		panel.add(lblFim);

		txtAno = new JTextField();
		txtAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno.setBounds(153, 49, 131, 20);
		panel.add(txtAno);
		txtAno.setColumns(10);

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConcluir.setBounds(376, 49, 196, 53);
		panel.add(btnConcluir);

		txtAno2 = new JTextField();
		txtAno2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAno2.setColumns(10);
		txtAno2.setBounds(153, 85, 131, 20);
		panel.add(txtAno2);

		JLabel lblAnoIncio = new JLabel("Ano in\u00EDcio:");
		lblAnoIncio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoIncio.setBounds(84, 47, 86, 24);
		panel.add(lblAnoIncio);

		btnConcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConcluirActionPerformed(evt);
			}

			public void btnConcluirActionPerformed(ActionEvent evt) {
				readJTableForDesc(txtAno.getText(), txtAno2.getText());
			}
		});

	}
}
