package br.com.escolatcc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.escolatcc.bean.PessoaBean;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PainelAdministrador extends JFrame {

	private JPanel contentPane;

	public PainelAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 984, 120);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labeltitulo = new JLabel("Portal do Aministrador");
		labeltitulo.setBounds(195, 37, 389, 47);
		panel.add(labeltitulo);
		labeltitulo.setFont(new Font("Arial", Font.PLAIN, 40));
		labeltitulo.setForeground(Color.GREEN);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(563, 116, 221, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnVoltar = new JButton("Sair");
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(SystemColor.menu);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltar.setBounds(38, 379, 160, 39);
		panel_1.add(btnVoltar);
		
		// Instanciar dados da classe pessoa
		PessoaBean pb = new PessoaBean();
		
		JLabel campoNomeAdm = new JLabel(pb.getNomePessoa());
		campoNomeAdm.setFont(new Font("Arial", Font.PLAIN, 20));
		campoNomeAdm.setBounds(24, 28, 174, 31);
		panel_1.add(campoNomeAdm);
		
		JLabel campoTelefoneAdm = new JLabel(String.valueOf(pb.getNumero()));
		campoTelefoneAdm.setFont(new Font("Arial", Font.PLAIN, 17));
		campoTelefoneAdm.setBounds(24, 76, 174, 31);
		panel_1.add(campoTelefoneAdm);
		
		JLabel campoEmail = new JLabel(pb.getEmail());
		campoEmail.setFont(new Font("Arial", Font.PLAIN, 17));
		campoEmail.setBounds(24, 118, 174, 31);
		panel_1.add(campoEmail);
		
		JButton btnTrocarUsuario = new JButton("Trocar de usu\u00E1rio");
		btnTrocarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				TelaLogin tl = new TelaLogin();
				tl.setVisible(true);
			}
		});
		
		btnTrocarUsuario.setFocusPainted(false);
		btnTrocarUsuario.setBackground(SystemColor.menu);
		btnTrocarUsuario.setBounds(38, 318, 160, 39);
		panel_1.add(btnTrocarUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 274, 188, 2);
		panel_1.add(separator);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar novo Aluno");
		btnCadastrarAluno.setFocusPainted(false);
		btnCadastrarAluno.setBackground(SystemColor.menu);
		btnCadastrarAluno.setBounds(86, 194, 210, 39);
		contentPane.add(btnCadastrarAluno);
		
		btnCadastrarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroAluno tca = new TelaCadastroAluno();
				tca.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar novo Professor");
		btnCadastrarProfessor.setFocusPainted(false);
		btnCadastrarProfessor.setBackground(SystemColor.menu);
		btnCadastrarProfessor.setBounds(86, 234, 210, 39);
		contentPane.add(btnCadastrarProfessor);
		
		JButton btnCadastrarFuncionario = new JButton("Cadastrar novo Funcion\u00E1rio");
		btnCadastrarFuncionario.setFocusPainted(false);
		btnCadastrarFuncionario.setBackground(SystemColor.menu);
		btnCadastrarFuncionario.setBounds(86, 273, 210, 39);
		contentPane.add(btnCadastrarFuncionario);
		
		JButton btnInformacoesAluno = new JButton("Infoma\u00E7\u00F5es Aluno");
		btnInformacoesAluno.setFocusPainted(false);
		btnInformacoesAluno.setBackground(SystemColor.menu);
		btnInformacoesAluno.setBounds(86, 342, 210, 39);
		contentPane.add(btnInformacoesAluno);
		
		JButton btnInformacoesProfessor = new JButton("Informa\u00E7\u00F5es Professor");
		btnInformacoesProfessor.setFocusPainted(false);
		btnInformacoesProfessor.setBackground(SystemColor.menu);
		btnInformacoesProfessor.setBounds(86, 382, 210, 39);
		contentPane.add(btnInformacoesProfessor);
		
		JButton btnInformacoesFuncionario = new JButton("Informa\u00E7\u00F5es Funcion\u00E1rio");
		btnInformacoesFuncionario.setFocusPainted(false);
		btnInformacoesFuncionario.setBackground(SystemColor.menu);
		btnInformacoesFuncionario.setBounds(86, 421, 210, 39);
		contentPane.add(btnInformacoesFuncionario);
	}
}
