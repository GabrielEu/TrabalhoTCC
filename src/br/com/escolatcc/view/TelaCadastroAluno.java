package br.com.escolatcc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.escolatcc.dao.CadastrarDao;

import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoNascimento;
	private JTextField campoEndereco;
	private JTextField campoNumeroCasa;
	private JTextField campoCep;
	private JTextField campoBairro;
	private JTextField campoCidade;
	private JTextField campoMatricula;
	private JTextField campoDataMatricula;
	private JTextField campoSala;
	private JTextField campoTurma;
	private JTextField campoLogin;
	private JTextField campoSenha;

	public TelaCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 984, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCadastroDeAluno = new JLabel("Cadastro de Aluno");
		lblCadastroDeAluno.setBounds(221, 28, 352, 47);
		panel.add(lblCadastroDeAluno);
		lblCadastroDeAluno.setForeground(Color.GREEN);
		lblCadastroDeAluno.setFont(new Font("Arial", Font.PLAIN, 40));

		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(563, 116, 221, 445);
		contentPane.add(panel_1);

		JLabel label_1 = new JLabel("nome");
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(24, 28, 174, 31);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("9999999");
		label_2.setFont(new Font("Arial", Font.PLAIN, 17));
		label_2.setBounds(24, 76, 174, 31);
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("email@email");
		label_3.setFont(new Font("Arial", Font.PLAIN, 17));
		label_3.setBounds(24, 118, 174, 31);
		panel_1.add(label_3);

		JButton btnTrocarUsuario = new JButton("Trocar de Usu\u00E1rio");
		btnTrocarUsuario.setFocusPainted(false);
		btnTrocarUsuario.setBackground(UIManager.getColor("Button.background"));
		btnTrocarUsuario.setBounds(38, 318, 160, 39);
		panel_1.add(btnTrocarUsuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 160, 188, 2);
		panel_1.add(separator);

		campoNome = new JTextField();
		campoNome.setBounds(79, 140, 429, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(44, 140, 71, 20);
		contentPane.add(lblNewLabel);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(44, 171, 54, 20);
		contentPane.add(lblCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(317, 171, 34, 20);
		contentPane.add(lblRg);

		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(44, 202, 71, 20);
		contentPane.add(lblNascimento);

		campoNascimento = new JTextField();
		campoNascimento.setColumns(10);
		campoNascimento.setBounds(118, 202, 150, 20);
		contentPane.add(campoNascimento);

		JRadioButton rdbtnNewRadioButtonMasculino = new JRadioButton("masculino");
		rdbtnNewRadioButtonMasculino.setBounds(274, 198, 109, 23);
		contentPane.add(rdbtnNewRadioButtonMasculino);

		JRadioButton rdbtnNewRadioButtonFeminino = new JRadioButton("feminino");
		rdbtnNewRadioButtonFeminino.setBounds(399, 200, 109, 23);
		contentPane.add(rdbtnNewRadioButtonFeminino);

		JFormattedTextField campoCpf = new JFormattedTextField();
		campoCpf.setBounds(72, 171, 235, 20);
		contentPane.add(campoCpf);

		JFormattedTextField campoRg = new JFormattedTextField();
		campoRg.setBounds(348, 171, 160, 20);
		contentPane.add(campoRg);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(44, 233, 63, 20);
		contentPane.add(lblEndereo);

		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(104, 233, 279, 20);
		contentPane.add(campoEndereco);

		JLabel lblNmero = new JLabel("N\u00FAmero: ");
		lblNmero.setBounds(387, 230, 63, 20);
		contentPane.add(lblNmero);

		campoNumeroCasa = new JTextField();
		campoNumeroCasa.setColumns(10);
		campoNumeroCasa.setBounds(437, 233, 71, 20);
		contentPane.add(campoNumeroCasa);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(382, 264, 42, 20);
		contentPane.add(lblCep);

		campoCep = new JTextField();
		campoCep.setColumns(10);
		campoCep.setBounds(422, 264, 86, 20);
		contentPane.add(campoCep);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(44, 264, 54, 20);
		contentPane.add(lblBairro);

		campoBairro = new JTextField();
		campoBairro.setColumns(10);
		campoBairro.setBounds(87, 264, 285, 20);
		contentPane.add(campoBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(44, 295, 54, 20);
		contentPane.add(lblCidade);

		campoCidade = new JTextField();
		campoCidade.setColumns(10);
		campoCidade.setBounds(97, 295, 411, 20);
		contentPane.add(campoCidade);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		lblMatrcula.setBounds(44, 344, 63, 20);
		contentPane.add(lblMatrcula);

		campoMatricula = new JTextField();
		campoMatricula.setColumns(10);
		campoMatricula.setBounds(102, 344, 71, 20);
		contentPane.add(campoMatricula);

		JLabel lblDataDaMatrcula = new JLabel("Data da Matr\u00EDcula:");
		lblDataDaMatrcula.setBounds(183, 344, 109, 20);
		contentPane.add(lblDataDaMatrcula);

		campoDataMatricula = new JTextField();
		campoDataMatricula.setColumns(10);
		campoDataMatricula.setBounds(287, 344, 86, 20);
		contentPane.add(campoDataMatricula);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(382, 344, 42, 20);
		contentPane.add(lblSala);

		campoSala = new JTextField();
		campoSala.setColumns(10);
		campoSala.setBounds(422, 344, 86, 20);
		contentPane.add(campoSala);

		JLabel lblTurma = new JLabel("Ano/S\u00E9rie:");
		lblTurma.setBounds(44, 374, 63, 20);
		contentPane.add(lblTurma);

		campoTurma = new JTextField();
		campoTurma.setColumns(10);
		campoTurma.setBounds(104, 374, 71, 20);
		contentPane.add(campoTurma);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(44, 428, 54, 20);
		contentPane.add(lblLogin);

		campoLogin = new JTextField();
		campoLogin.setColumns(10);
		campoLogin.setBounds(82, 428, 189, 20);
		contentPane.add(campoLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(281, 428, 54, 20);
		contentPane.add(lblSenha);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(335, 428, 173, 20);
		contentPane.add(campoSenha);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setBackground(UIManager.getColor("Button.background"));
		btnCadastrar.setBounds(38, 191, 160, 39);
		panel_1.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Instanciar pessoa e setar informações
				
				
				CadastrarDao ad = new CadastrarDao();
				ad.cadastrarPessoas();

			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(38, 375, 160, 40);
		panel_1.add(btnSair);
		btnSair.setIcon(null);
		btnSair.setFocusPainted(false);
		btnSair.setBackground(UIManager.getColor("Button.background"));

		JButton btnCancelarEVoltar = new JButton("Cancelar e voltar");
		btnCancelarEVoltar.setBounds(38, 257, 160, 39);
		panel_1.add(btnCancelarEVoltar);
		btnCancelarEVoltar.setFocusPainted(false);
		btnCancelarEVoltar.setBackground(UIManager.getColor("Button.background"));

	}
}
