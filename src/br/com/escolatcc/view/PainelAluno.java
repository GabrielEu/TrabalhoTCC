package br.com.escolatcc.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class PainelAluno extends JFrame {

	private JPanel contentPane;

	public PainelAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 984, 120);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Portal do Aluno");
		lblTitulo.setBounds(230, 11, 452, 98);
		lblTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblTitulo.setForeground(SystemColor.textHighlight);
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(563, 116, 221, 445);
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 11, 201, 39);
		panel_1.add(lblNome);
		
		JLabel lblMateria = new JLabel("Turma");
		lblMateria.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMateria.setBounds(10, 75, 201, 39);
		panel_1.add(lblMateria);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 130, 201, 39);
		panel_1.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(10, 180, 201, 39);
		panel_1.add(lblEmail);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 230, 201, 39);
		panel_1.add(lblEndereco);
		
		JButton btnVoltar = new JButton("Trocar de Usuario");
		btnVoltar.setBounds(31, 309, 154, 52);
		panel_1.add(btnVoltar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(31, 372, 129, 52);
		panel_1.add(btnSair);
		
		JButton btnNotas = new JButton("Notas");
		btnNotas.setBounds(34, 200, 202, 58);
		contentPane.add(btnNotas);
		
		JButton btnHorarioDasAulas = new JButton("Horario das aulas");
		btnHorarioDasAulas.setBounds(34, 131, 202, 58);
		contentPane.add(btnHorarioDasAulas);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaLogin login = new TelaLogin();
				login.setVisible(true);
				dispose();
				
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
