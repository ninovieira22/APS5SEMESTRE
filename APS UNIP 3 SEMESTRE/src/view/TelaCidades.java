package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.bean.ModelTelaCidades;
import model.dao.CidadesDAO;
import java.awt.Font;

public class TelaCidades extends javax.swing.JFrame {

	public JFrame frame;
	public JTable table;
	public JTextField txtID;
	public JTextField txtCidade;
	public JTextField txtRegiao;
	public JTextField txtEstado;
	public JTextField txtID2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultTableModel modelo = new DefaultTableModel();
					TelaCidades window = new TelaCidades();
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
	public TelaCidades() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		CidadesDAO rdao = new CidadesDAO();

		for (ModelTelaCidades r : rdao.read()) {
			modelo.addRow(new Object[] { r.getIdCidCidades(), r.getNomeCidade(), r.getRegiao(), r.getEstado() });
		}
	}

	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
		CidadesDAO rdao = new CidadesDAO();
		ModelTelaCidades r = new ModelTelaCidades();

		r.setIdCidCidades(Integer.parseInt(txtID.getText()));
		r.setNomeCidade(txtCidade.getText());
		r.setRegiao(txtRegiao.getText());
		r.setEstado(txtEstado.getText());
		rdao.create(r);

		txtCidade.setText("");
		txtRegiao.setText("");
		txtEstado.setText("");

		readJTable();

	}

	public void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {

		CidadesDAO rdao = new CidadesDAO();
		ModelTelaCidades r = new ModelTelaCidades();

		r.setIdCidCidades(Integer.parseInt(txtID.getText()));
		r.setNomeCidade(txtCidade.getText());
		r.setRegiao(txtRegiao.getText());
		r.setEstado(txtEstado.getText());
		r.setIdCidCidades(Integer.parseInt(txtID2.getText()));

		rdao.update(r);

		txtID.setText("");
		txtCidade.setText("");
		txtRegiao.setText("");
		txtEstado.setText("");
		txtID2.setText("");

		readJTable();

	}

	public void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {

		CidadesDAO rdao = new CidadesDAO();
		ModelTelaCidades r = new ModelTelaCidades();

		r.setIdCidCidades(Integer.parseInt(txtID2.getText()));

		rdao.delete(r);

		txtID.setText("");
		txtCidade.setText("");
		txtRegiao.setText("");
		txtEstado.setText("");
		txtID2.setText("");

		readJTable();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Cidades");
		frame.setBounds(100, 100, 735, 409);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 150, 677, 209);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, "" }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "ID", "Cidade", "Regi\u00E3o", "Estado" }));
		scrollPane.setViewportView(table);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(21, 36, 46, 14);
		frame.getContentPane().add(lblId);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(21, 61, 57, 23);
		frame.getContentPane().add(lblCidade);

		JLabel lblRegio = new JLabel("Regi\u00E3o:");
		lblRegio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegio.setBounds(21, 89, 57, 23);
		frame.getContentPane().add(lblRegio);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(21, 125, 57, 14);
		frame.getContentPane().add(lblEstado);

		JLabel id2 = new JLabel("ID: (Preencher apenas para Alterar/Excluir)");
		id2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id2.setBounds(213, 61, 328, 23);
		frame.getContentPane().add(id2);

		txtID = new JTextField();
		txtID.setBounds(72, 35, 107, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(72, 63, 107, 20);
		txtCidade.setColumns(10);
		frame.getContentPane().add(txtCidade);

		txtRegiao = new JTextField();
		txtRegiao.setBounds(72, 90, 107, 20);
		txtRegiao.setColumns(10);
		frame.getContentPane().add(txtRegiao);

		txtEstado = new JTextField();
		txtEstado.setBounds(72, 124, 107, 20);
		txtEstado.setColumns(10);
		frame.getContentPane().add(txtEstado);

		txtID2 = new JTextField();
		txtID2.setBounds(253, 92, 188, 20);
		frame.getContentPane().add(txtID2);
		txtID2.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(566, 46, 132, 23);
		frame.getContentPane().add(btnCadastrar);

		btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCadastrarActionPerformed(evt);
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlterar.setBounds(566, 80, 132, 23);
		frame.getContentPane().add(btnAlterar);

		btnAlterar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAlterarActionPerformed(evt);
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluir.setBounds(566, 114, 132, 23);
		frame.getContentPane().add(btnExcluir);

		btnExcluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExcluirActionPerformed(evt);
			}
		});
	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub

	}
}
