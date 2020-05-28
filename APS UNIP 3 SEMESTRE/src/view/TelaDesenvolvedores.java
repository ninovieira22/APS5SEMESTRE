package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class TelaDesenvolvedores {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDesenvolvedores window = new TelaDesenvolvedores();
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
	public TelaDesenvolvedores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 317, 233);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDesenvolvedores = new JLabel("Desenvolvedores");
		lblDesenvolvedores.setBounds(6, 6, 203, 25);
		lblDesenvolvedores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		frame.getContentPane().add(lblDesenvolvedores);

		JLabel lblFernando = new JLabel("Fernando Junior");
		lblFernando.setBounds(6, 42, 172, 19);
		lblFernando.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblFernando);

		JLabel lblLucas = new JLabel("Lucas Vieira");
		lblLucas.setBounds(6, 132, 172, 19);
		lblLucas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblLucas);

		JLabel lblKaue = new JLabel("Kaue Siqueto");
		lblKaue.setBounds(6, 72, 172, 19);
		lblKaue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblKaue);

		JLabel lblPedro = new JLabel("Pedro Camargo");
		lblPedro.setBounds(6, 162, 172, 19);
		lblPedro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblPedro);

		JLabel lblKaue_1 = new JLabel("Kaue In\u00E1cio");
		lblKaue_1.setBounds(6, 102, 172, 19);
		lblKaue_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblKaue_1);

	}

	public static void addActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub

	}

}
