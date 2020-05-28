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

// Instâncias dac classe que será iniciada após o Login

	TelaMenu tm = new TelaMenu();
	TelaMenu window = new TelaMenu();

// Método main da classe, onde a tela fica visível

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

// Após o main abrir a tela, o método intialize carrega os itens para a tela 

	public TelaLogin() {
		initialize();
	}

// Itens que compõem a tela (gráfica)

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
		 * ActionListeners dos botões (no caso a classe Login tem apenas o botão
		 * "Continuar"). O mesmo botão tem a função de checar o login O Login e o
		 * Password tem os textos "capturados" (getText()) e é realizado a verificação.
		 * Caso esteja Ok, ele irá acessar o sistema Acessando o sistema é incializado a
		 * classe TelaMenu (window.frame.setVisible(true) --> usado para deixar a tela
		 * Menu visível tm.initialize (instaciada a classe tela menu e rodado o método
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
					JOptionPane.showMessageDialog(null, "Dados Invalidos!!", "Faça novamente",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

// Método checklogin, onde são passados os parâmetros de Login e Password e retornado os mesmos.

	}

	public boolean checkLogin(String login, String password) {
		return login.contentEquals("usuario") && password.contentEquals("123");
	}
}
