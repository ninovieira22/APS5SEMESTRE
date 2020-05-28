package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaMenu {

	/*
	 * Criação das Strings para utilização nos Checkboxes (a ideia é que quando um
	 * estiver ativo, o restante estará inativado. Poderia também ter sido utilziado
	 * boolean ao invés de String.
	 */

	String a = "";
	String b = "";
	String d = "";
	String e = "";
	String f = "";
	String g = "";
	String h = "";

	public JFrame frame;

	/*
	 * Intâncias das classes que serão acessíveis a partir da classe Menu (todas as
	 * outras telas do programa, basicamente)
	 */

	TelaDesenvolvedores td = new TelaDesenvolvedores();
	TelaCidades tc = new TelaCidades();
	TelaRelatorioC trc = new TelaRelatorioC();
	TelaRelatorioA tra = new TelaRelatorioA();
	TelaRelatorioB trb = new TelaRelatorioB();
	TelaDoencas tdo = new TelaDoencas();
	TelaPopulacao tpo = new TelaPopulacao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu window = new TelaMenu();
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
	public TelaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Menu");
		frame.setBounds(100, 100, 688, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(127, 81, 395, 312);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JCheckBox cTelaCidades = new JCheckBox("1 - Visualizar Cidades [CRUD]");
		cTelaCidades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cTelaCidades.setBounds(6, 0, 275, 39);
		panel.add(cTelaCidades);

		JCheckBox cTelaDesenvolvedores = new JCheckBox("7 - Desenvolvedores");
		cTelaDesenvolvedores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cTelaDesenvolvedores.setBounds(6, 282, 213, 23);
		panel.add(cTelaDesenvolvedores);

		JCheckBox cRelatorioC = new JCheckBox("6 - Relat\u00F3rio C [Comparar cinco cidades]");
		cRelatorioC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cRelatorioC.setBounds(6, 238, 334, 23);
		panel.add(cRelatorioC);

		JCheckBox cRelatorioA = new JCheckBox("4 - Relat\u00F3rio A [Comparar duas cidades]");
		cRelatorioA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cRelatorioA.setBounds(6, 141, 334, 23);
		panel.add(cRelatorioA);

		JCheckBox cRelatorioB = new JCheckBox("5 - Relat\u00F3rio B [Comparar tr\u00EAs cidades]");
		cRelatorioB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cRelatorioB.setBounds(6, 191, 334, 23);
		panel.add(cRelatorioB);

		JCheckBox cTelaDoencas = new JCheckBox("2 - Visualizar Doen\u00E7as [CRUD]");
		cTelaDoencas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cTelaDoencas.setBounds(6, 45, 275, 39);
		panel.add(cTelaDoencas);

		JCheckBox cTelaPopulacao = new JCheckBox("3 - Visualizar Popula\u00E7\u00E3o [CRUD]");
		cTelaPopulacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cTelaPopulacao.setBounds(6, 87, 275, 39);
		panel.add(cTelaPopulacao);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(478, 419, 184, 23);
		frame.getContentPane().add(btnContinuar);

		JLabel lblSelecioneOQue = new JLabel("Selecione o que deseja:");
		lblSelecioneOQue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelecioneOQue.setBounds(210, 31, 283, 39);
		frame.getContentPane().add(lblSelecioneOQue);

		JLabel lblFebreAmarela = new JLabel("Consulta de Dados sobre a Febre Amarela");
		lblFebreAmarela.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblFebreAmarela.setBounds(10, 418, 440, 23);
		frame.getContentPane().add(lblFebreAmarela);

		/*
		 * Métodos para marcar o checkbox correto
		 */

		cTelaDesenvolvedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							a = "Desenvolvedores";
						b = "";
						d = "";
						e = "";
						f = "";
						h = "";
						g = "";
					}
				}
			}
		});

		cTelaCidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							b = "Cidades";
						a = "";
						d = "";
						e = "";
						f = "";
						g = "";
						h = "";
					}
				}
			}
		});

		cTelaDoencas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							g = "Doencas";
						a = "";
						d = "";
						e = "";
						f = "";
						h = "";
						b = "";
					}
				}
			}
		});

		cTelaPopulacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							h = "Populacao";
						a = "";
						d = "";
						e = "";
						f = "";
						g = "";
						b = "";
					}
				}
			}
		});

		cRelatorioC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							d = "RelatorioC";
						a = "";
						b = "";
						e = "";
						f = "";
						g = "";
						h = "";
					}
				}
			}
		});

		cRelatorioA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							e = "RelatorioA";
						a = "";
						b = "";
						d = "";
						f = "";
						g = "";
						h = "";
					}
				}
			}
		});

		cRelatorioB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							f = "RelatorioB";
						a = "";
						b = "";
						d = "";
						e = "";
						g = "";
						h = "";
					}
				}
			}
		});

		/*
		 * Métodos para que o botão "Continuar" ache a tela correta
		 */

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (a == "Desenvolvedores") {
								td.frame.setVisible(true);
								jck.setSelected(false);

							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (b == "Cidades") {
								tc.frame.setVisible(true);
								jck.setSelected(false);
							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (d == "RelatorioC") {
								trc.frame.setVisible(true);
								jck.setSelected(false);
							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (e == "RelatorioA") {
								tra.frame.setVisible(true);
								jck.setSelected(false);
							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (f == "RelatorioB") {
								trb.frame.setVisible(true);
								jck.setSelected(false);
							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (g == "Doencas") {
								tdo.frame.setVisible(true);
								jck.setSelected(false);
							}

						}
					}
				}
			}
		});

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component c : panel.getComponents()) {
					if (c.getClass().equals(JCheckBox.class)) {
						JCheckBox jck = (JCheckBox) c;
						if (jck.isSelected())
							;
						{
							if (h == "Populacao") {
								tpo.frame2.setVisible(true);
								jck.setSelected(false);

							}

						}
					}
				}
			}
		});

	}
}
