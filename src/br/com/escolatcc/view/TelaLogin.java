package br.com.escolatcc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.escolatcc.bean.ContasBean;
import br.com.escolatcc.dao.LogarDao;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario;
	private JTextField campoSenha;

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(161, 167, 134, 46);
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Instanciar contas
				ContasBean cb = new ContasBean();
				cb.setLogin(campoUsuario.getText());
				cb.setPassword(campoSenha.getText());
				
				LogarDao ld = new LogarDao();
				ld.LoginUsuario();
				
			}
		});
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(115, 73, 50, 23);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(115, 119, 50, 23);
		contentPane.add(lblSenha);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(161, 74, 134, 20);
		contentPane.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(161, 120, 134, 20);
		contentPane.add(campoSenha);
	}
}
