package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.escolatcc.connection.ConnectionFactory;

public class ExcluirDao {

	private Connection conexao;

	public ExcluirDao() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conexao = cf.obterConexao();

	}

	// Excluir quaisquer registro cadastrado na tabela "Aluno"
	public void excluirAluno(int idAluno) {

		String sql = "DELETE FROM aluno WHERE idAluno = ?";

		try {

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idAluno);
			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}
	}

	// Excluir quaisquer registro cadastrado na tabela "contas"
	public void excluirContas(int idConta) {
		String sql = "DELETE FROM contas WHERE idConta = ?";

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar este registro na tabela contas");
		}
	}

	// Excluir um determinado registro da tabela "endereco"
	public void excluirEndereco(int idEndereco) {
		String sql = "DELETE FROM endereco WHERE idEndereco = ?";

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idEndereco);
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir um determinado registro da tabela endereco");
		}
	}

	// Excluir quaiser registro cadastrado na tabela "materiasProfessor"
	public void excluirMateriasProfessor(int idMateria) {
		String sql = "DELETE FROM materiasProfessor WHERE idMateria = ?";
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idMateria);
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar o registro selecionado na tabela materiasProfessor");
		}
	}

	// Excluir todas as informações da tabela "pessoa"
	public void excluirPessoa(int idPessoa) {
		String sql = "DELETE FROM pessoa WHERE idPessoa = ?";
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idPessoa);
			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao excluir informações gerais da tabela pessoa");
		}
	}

	// Excluir quaisquer registro cadastro da tabela "sala"
	public void excluirSala(int idTurma) {
		String sql = "DELETE FROM sala WHERE idTurma = ?";
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idTurma);
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar o registro selecionado na tabela sala");
		}
	}

}
