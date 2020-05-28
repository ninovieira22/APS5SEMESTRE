package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaLogin {

	public JFrame frmTeladelogin;
	public JTextField txtLogin;
	public JPasswordField txtPassword;

// Inst�ncias dac classe que ser� iniciada ap�s o Login

	TelaMenu tm = new TelaMenu();
	TelaMenu window = new TelaMenu();

// M�todo main da classe, onde a tela fica vis�vel

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmTeladelogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

// Ap�s o main abrir a tela, o m�todo intialize carrega os itens para a tela 

	public TelaLogin() {
		initialize();
	}

// Itens que comp�em a tela (gr�fica)

	private void initialize() {
		frmTeladelogin = new JFrame();
		frmTeladelogin.setTitle("Inicio");
		frmTeladelogin.setBounds(100, 100, 450, 268);
		frmTeladelogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTeladelogin.getContentPane().setLayout(null);

		txtLogin = new JTextField();
		txtLogin.setBounds(90, 55, 192, 30);
		frmTeladelogin.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(90, 116, 192, 30);
		frmTeladelogin.getContentPane().add(txtPassword);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setBounds(289, 195, 121, 23);
		frmTeladelogin.getContentPane().add(btnContinuar);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(34, 55, 57, 30);
		frmTeladelogin.getContentPane().add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(34, 116, 74, 30);
		frmTeladelogin.getContentPane().add(lblSenha);

		/*
		 * ActionListeners dos bot�es (no caso a classe Login tem apenas o bot�o
		 * "Continuar"). O mesmo bot�o tem a fun��o de checar o login O Login e o
		 * Password tem os textos "capturados" (getText()) e � realizado a verifica��o.
		 * Caso esteja Ok, ele ir� acessar o sistema Acessando o sistema � incializado a
		 * classe TelaMenu (window.frame.setVisible(true) --> usado para deixar a tela
		 * Menu vis�vel tm.initialize (instaciada a classe tela menu e rodado o m�todo
		 * initialize.
		 */

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(txtLogin.getText(), new String(txtPassword.getPassword()))) {
					JOptionPane.showMessageDialog(null,
							" Bem vindo ao sistema de consulta de dados sobre a Febre Amarela!! ", "Mensagem",
							JOptionPane.INFORMATION_MESSAGE);
					window.frame.setVisible(true);
					tm.initialize();
				} else {
					JOptionPane.showMessageDialog(null, "Dados Invalidos!!", "Fa�a novamente",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

// M�todo checklogin, onde s�o passados os par�metros de Login e Password e retornado os mesmos.

	}

	public boolean checkLogin(String login, String password) {
		return login.contentEquals("usuario") && password.contentEquals("123");
	}
}
