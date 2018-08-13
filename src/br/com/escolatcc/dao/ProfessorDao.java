package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.escolatcc.bean.ContasBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.connection.ConnectionFactory;
import br.com.escolatcc.view.PainelAdministrador;

public class ProfessorDao {
	
	// Obter conexão
	private Connection conexao;

	public ProfessorDao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}

	// Método de login
	public void LoginProfessor(ContasBean cb) {

		String sql = "SELECT * FROM contas WHERE login LIKE ? AND password LIKE ?";

		try {

			// Preparar e executar query
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, "%" + cb.getLogin() + "%");
			pstmt.setString(2, "%" + String.valueOf(cb.getPassword()) + "%");

			// Obter resultado]
			ResultSet rs = pstmt.executeQuery();

			rs.last();
			
			// Verificar se o usuário está cadastrado
			if (((rs.getString("login")).equals(cb.getLogin()))
					&& ((rs.getString("password")).equals(cb.getPassword())
					&& ((rs.getString("permissao")).equals("professor")))) {

				// Instanciar pessoa e Setar id da conta pessoa que logou
				PessoaBean pb = new PessoaBean();
				pb.setIdConta(Integer.parseInt(rs.getString("idConta")));
				
				//TelaLoginProfessor.permissao = true;
				
			} else {
				//TelaLoginProfessor.permissao = false;
			}

			// Fechar conexão
			pstmt.close();

		} catch (Exception error) {
			//TelaLoginProfessor.permissao = false;
		}
	}

}
