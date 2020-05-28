package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.ModelTelaCidades;
import model.bean.ModelTelaPopulacao;
import model.dao.CidadesDAO;
import model.dao.PopulacaoDAO;

import javax.swing.JLabel;
import java.awt.Font;

public class TelaPopulacao extends javax.swing.JFrame {

	public JFrame frame2;
	public JTextField txtID;
	public JTextField txtPopu;
	public JTextField txtAno;
	public JTextField txtID2;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPopulacao window = new TelaPopulacao();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPopulacao() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		PopulacaoDAO rdao = new PopulacaoDAO();

		for (ModelTelaPopulacao r : rdao.read()) {
			modelo.addRow(new Object[] { r.getIdCidPopu(), r.getPopuAno(), r.getPopuQtd(), });
		}
	}

	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

		PopulacaoDAO rdao = new PopulacaoDAO();
		ModelTelaPopulacao r = new ModelTelaPopulacao();

		r.setIdCidPopu(Integer.parseInt(txtID.getText()));
		r.setPopuAno(Integer.parseInt(txtAno.getText()));
		r.setPopuQtd(Integer.parseInt(txtPopu.getText()));

		rdao.create(r);

		txtID.setText("");
		txtAno.setText("");
		txtPopu.setText("");
		txtID2.setText("");

		readJTable();

	}

	public void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {

		PopulacaoDAO rdao = new PopulacaoDAO();
		ModelTelaPopulacao r = new ModelTelaPopulacao();

		r.setIdCidPopu(Integer.parseInt(txtID.getText()));
		r.setPopuAno(Integer.parseInt(txtAno.getText()));
		r.setPopuQtd(Integer.parseInt(txtPopu.getText()));
		r.setIdCidPopu(Integer.parseInt(txtID2.getText()));

		rdao.update(r);

		txtID.setText("");
		txtAno.setText("");
		txtPopu.setText("");
		txtID2.setText("");

		readJTable();

	}

	public void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {

		PopulacaoDAO rdao = new PopulacaoDAO();
		ModelTelaPopulacao r = new ModelTelaPopulacao();

		r.setIdCidPopu(Integer.parseInt(txtID2.getText()));

		rdao.delete(r);

		txtID.setText("");
		txtAno.setText("");
		txtPopu.setText("");
		txtID2.setText("");

		readJTable();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame2 = new JFrame();
		frame2.setTitle("Popula\u00E7\u00E3o");
		frame2.setBounds(100, 100, 773, 479);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(117, 42, 104, 20);
		frame2.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtPopu = new JTextField();
		txtPopu.setBounds(117, 71, 104, 20);
		frame2.getContentPane().add(txtPopu);
		txtPopu.setColumns(10);

		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(117, 104, 104, 20);
		frame2.getContentPane().add(txtAno);

		txtID2 = new JTextField();
		txtID2.setColumns(10);
		txtID2.setBounds(323, 139, 104, 20);
		frame2.getContentPane().add(txtID2);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(511, 39, 174, 23);
		frame2.getContentPane().add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlterar.setBounds(511, 70, 174, 23);
		frame2.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluir.setBounds(511, 101, 174, 23);
		frame2.getContentPane().add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 170, 682, 246);
		frame2.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "ID", "Ano", "Populacao" }));
		scrollPane.setViewportView(table);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 43, 46, 14);
		frame2.getContentPane().add(lblId);

		JLabel lblPopulacao = new JLabel("Populacao:");
		lblPopulacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPopulacao.setBounds(21, 70, 97, 19);
		frame2.getContentPane().add(lblPopulacao);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAno.setBounds(21, 105, 46, 14);
		frame2.getContentPane().add(lblAno);

		JLabel lblIdpreencherApenas = new JLabel("ID: (Preencher apenas para Alterar/Excluir)");
		lblIdpreencherApenas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdpreencherApenas.setBounds(21, 135, 328, 25);
		frame2.getContentPane().add(lblIdpreencherApenas);

		btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCadastrarActionPerformed(evt);
			}
		});

		btnAlterar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAlterarActionPerformed(evt);
			}
		});

		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcluirActionPerformed(evt);
			}
		});
	}
}
