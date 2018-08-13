package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.escolatcc.bean.ContasBean;
import br.com.escolatcc.bean.MateriasProfessorBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.bean.ProfessorBean;
import br.com.escolatcc.connection.ConnectionFactory;
import br.com.escolatcc.view.PainelAdministrador;
import br.com.escolatcc.view.PainelAluno;
import br.com.escolatcc.view.PainelProfessor;

public class LogarDao {

	// Obter conexão
	private Connection conexao;

	public LogarDao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}

	// Método de login
	public void LoginUsuario() {

		String sql = "SELECT * FROM contas WHERE login LIKE ? AND password LIKE ?";

		try {

			// Instanciar contas
			ContasBean cb = new ContasBean();

			// Preparar e executar query
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, "%" + cb.getLogin() + "%");
			pstmt.setString(2, "%" + String.valueOf(cb.getPassword()) + "%");

			// Obter resultado
			ResultSet rs = pstmt.executeQuery();
			rs.last();

			// Verificar se o usuário está cadastrado
			if (((rs.getString("login")).equals(cb.getLogin()))
					&& ((rs.getString("password")).equals(cb.getPassword()))) {

				// Instanciar pessoa e Setar id da conta pessoa que logou
				PessoaBean pb = new PessoaBean();
				pb.setIdConta(Integer.parseInt(rs.getString("idConta")));

				ListarDao ld = new ListarDao();
				AdquirirDadosDao ad = new AdquirirDadosDao();

				ld.listarInformacoes();

				// Verificar permissão do usuário
				if ((rs.getString("permissao")).equals(("administrador"))) {
					PainelAdministrador pa = new PainelAdministrador();
					pa.setVisible(true);
				} else if ((rs.getString("permissao")).equals("professor")) {
					ad.adquiriridMateria();
					ad.adquirirnomeMateria();

					PainelProfessor pp = new PainelProfessor();
					pp.setVisible(true);
				} else {
					PainelAluno pa = new PainelAluno();
					pa.setVisible(true);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto");
			}

			// Fechar conexão
			pstmt.close();

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error: " + error);
		}
	}

	
}
