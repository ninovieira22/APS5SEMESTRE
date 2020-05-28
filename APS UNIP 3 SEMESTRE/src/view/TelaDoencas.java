package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.ModelTelaDoencas;
import model.bean.ModelTelaPopulacao;
import model.dao.DoencasDAO;
import model.dao.PopulacaoDAO;

import javax.swing.JLabel;
import java.awt.Font;

public class TelaDoencas {

	public JFrame frame;
	public JTextField txtID;
	public JTextField txtDoen;
	public JTextField txtInfec;
	public JTextField txtVac;
	public JTextField txtObito;
	public JTextField txtSexo;
	public JTextField txtID2;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDoencas window = new TelaDoencas();
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
	public TelaDoencas() {
		initialize();
		readJTable();
	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		DoencasDAO rdao = new DoencasDAO();

		for (ModelTelaDoencas r : rdao.read()) {
			modelo.addRow(new Object[] { r.getIdCidDoen(), r.getDoenAno(), r.getQtdInfec(), r.getQtdVac(),
					r.getQtdObito(), r.getSexo(), });
		}
	}

	public void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {

		DoencasDAO rdao = new DoencasDAO();
		ModelTelaDoencas r = new ModelTelaDoencas();

		r.setIdCidDoen(Integer.parseInt(txtID.getText()));
		r.setDoenAno(Integer.parseInt(txtDoen.getText()));
		r.setQtdInfec(Integer.parseInt(txtInfec.getText()));
		r.setQtdVac(Integer.parseInt(txtVac.getText()));
		r.setQtdObito(Integer.parseInt(txtObito.getText()));
		r.setsexo(txtSexo.getText());

		rdao.create(r);

		txtID.setText("");
		txtDoen.setText("");
		txtInfec.setText("");
		txtVac.setText("");
		txtObito.setText("");
		txtSexo.setText("");

		readJTable();

	}

	public void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {

		DoencasDAO rdao = new DoencasDAO();
		ModelTelaDoencas r = new ModelTelaDoencas();

		r.setIdCidDoen(Integer.parseInt(txtID.getText()));
		r.setDoenAno(Integer.parseInt(txtDoen.getText()));
		r.setQtdInfec(Integer.parseInt(txtInfec.getText()));
		r.setQtdVac(Integer.parseInt(txtVac.getText()));
		r.setQtdObito(Integer.parseInt(txtObito.getText()));
		r.setsexo(txtSexo.getText());
		r.setIdCidDoen(Integer.parseInt(txtID2.getText()));

		rdao.update(r);

		txtID.setText("");
		txtDoen.setText("");
		txtInfec.setText("");
		txtVac.setText("");
		txtObito.setText("");
		txtSexo.setText("");

		readJTable();

	}

	public void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {

		DoencasDAO rdao = new DoencasDAO();
		ModelTelaDoencas r = new ModelTelaDoencas();

		r.setIdCidDoen(Integer.parseInt(txtID2.getText()));

		rdao.delete(r);

		txtID.setText("");
		txtDoen.setText("");
		txtInfec.setText("");
		txtVac.setText("");
		txtObito.setText("");
		txtSexo.setText("");

		readJTable();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Doen\u00E7as");
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
		frame.setBounds(100, 100, 797, 496);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(117, 30, 123, 20);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);

		txtDoen = new JTextField();
		txtDoen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoen.setColumns(10);
		txtDoen.setBounds(117, 61, 123, 20);
		frame.getContentPane().add(txtDoen);

		txtInfec = new JTextField();
		txtInfec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInfec.setColumns(10);
		txtInfec.setBounds(117, 92, 123, 20);
		frame.getContentPane().add(txtInfec);

		txtVac = new JTextField();
		txtVac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVac.setColumns(10);
		txtVac.setBounds(117, 123, 123, 20);
		frame.getContentPane().add(txtVac);

		txtObito = new JTextField();
		txtObito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtObito.setColumns(10);
		txtObito.setBounds(117, 154, 123, 20);
		frame.getContentPane().add(txtObito);

		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSexo.setColumns(10);
		txtSexo.setBounds(117, 185, 123, 20);
		frame.getContentPane().add(txtSexo);

		txtID2 = new JTextField();
		txtID2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID2.setColumns(10);
		txtID2.setBounds(334, 103, 123, 20);
		frame.getContentPane().add(txtID2);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(596, 72, 143, 23);
		frame.getContentPane().add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlterar.setBounds(596, 103, 143, 23);
		frame.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluir.setBounds(596, 137, 143, 23);
		frame.getContentPane().add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 219, 727, 215);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "ID", "Ano", "Infectados", "Vacinados", "\u00D3bitos", "Sexo" }));
		scrollPane.setViewportView(table);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblId.setBounds(20, 31, 46, 14);
		frame.getContentPane().add(lblId);

		JLabel lblNewLabel = new JLabel("Ano:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 62, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblInfectados = new JLabel("Infectados:");
		lblInfectados.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblInfectados.setBounds(20, 89, 95, 23);
		frame.getContentPane().add(lblInfectados);

		JLabel lblVacinados = new JLabel("Vacinados:");
		lblVacinados.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblVacinados.setBounds(20, 123, 95, 14);
		frame.getContentPane().add(lblVacinados);

		JLabel lblbitos = new JLabel("\u00D3bitos:");
		lblbitos.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblbitos.setBounds(20, 157, 71, 14);
		frame.getContentPane().add(lblbitos);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSexo.setBounds(20, 188, 46, 14);
		frame.getContentPane().add(lblSexo);

		JLabel lblId_1 = new JLabel("ID: (Preencher apenas para Alterar/Excluir)");
		lblId_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblId_1.setBounds(262, 72, 324, 20);
		frame.getContentPane().add(lblId_1);

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
