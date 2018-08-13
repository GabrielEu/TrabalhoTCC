package br.com.escolatcc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.escolatcc.bean.MateriasProfessorBean;
import br.com.escolatcc.bean.PessoaBean;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelProfessor extends JFrame {

	private JPanel contentPane;

	public PainelProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 984, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Portal do Professor");
		lblTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		lblTitulo.setForeground(Color.RED);
		lblTitulo.setBounds(192, 11, 452, 98);
		panel.add(lblTitulo);

		JMenu mnTurmas = new JMenu("Turmas");
		mnTurmas.setBackground(Color.WHITE);
		mnTurmas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		mnTurmas.setDelay(0);
		mnTurmas.setBounds(10, 131, 129, 79);
		contentPane.add(mnTurmas);

		JMenuItem menuItem = new JMenuItem("1\u00B01");
		mnTurmas.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("1\u00B03");
		mnTurmas.add(menuItem_1);

		JMenu mnAdicionarNotas = new JMenu("Adicionar Notas");
		mnAdicionarNotas.setBackground(Color.WHITE);
		mnAdicionarNotas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		mnAdicionarNotas.setDelay(0);
		mnAdicionarNotas.setBounds(290, 131, 197, 79);
		contentPane.add(mnAdicionarNotas);

		JMenuItem menuItem_2 = new JMenuItem("1\u00B01");
		mnAdicionarNotas.add(menuItem_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(563, 116, 221, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// Instanciar dados da classe
		PessoaBean pb = new PessoaBean();
		MateriasProfessorBean mp = new MateriasProfessorBean();
		
		JLabel lblNome = new JLabel(pb.getNomePessoa());
		lblNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNome.setBounds(10, 11, 201, 39);
		panel_1.add(lblNome);

		JLabel lblMateria = new JLabel(mp.getNomeMateria());
		lblMateria.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMateria.setBounds(10, 75, 201, 39);
		panel_1.add(lblMateria);

		JLabel lblTelefone = new JLabel(String.valueOf(pb.getNumero()));
		lblTelefone.setBounds(10, 130, 201, 39);
		panel_1.add(lblTelefone);

		JLabel lblEmail = new JLabel(pb.getEmail());
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(10, 180, 201, 39);
		panel_1.add(lblEmail);

		JButton btnVoltar = new JButton("Trocar de Usuario");
		btnVoltar.setBounds(31, 309, 143, 52);
		panel_1.add(btnVoltar);

		JButton btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.setBounds(103, 415, 118, 30);
		panel_1.add(btnAlterarSenha);
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
