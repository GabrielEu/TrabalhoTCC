package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import br.com.escolatcc.bean.AlunoBean;
import br.com.escolatcc.bean.MateriasProfessorBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.bean.ProfessorBean;
import br.com.escolatcc.bean.SalaBean;
import br.com.escolatcc.connection.ConnectionFactory;

public class AdquirirDadosDao {

	private Connection conexao;

	public AdquirirDadosDao() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conexao = cf.obterConexao();

	}

	// Adquirir data atual
	public void adquirirDataAtual() {

		// LocalDateTime
		LocalDateTime tempo = LocalDateTime.now();

		// Classes para separar as informações
		int dia = tempo.getDayOfMonth();
		int mes = tempo.getMonthValue();
		int ano = tempo.getYear();

		// Instanciar e setar tempo atual
		AlunoBean ab = new AlunoBean();
		ab.setDataDeInicio(ano + "-" + mes + "-" + dia);

	}

	// Adquirir o id da tabela contas
	public int ultimoIdConta() {

		// Criar sql
		String sql = "SELECT MAX(contas.idConta)AS maxidConta FROM contas";

		// Variável para retornar o id da conta
		int idConta = 0;

		try {
			// Preparar a sql
			Statement stmt = conexao.createStatement();

			// Executar a sql e adquirir o resultado
			ResultSet rs = stmt.executeQuery(sql);
			rs.last();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao pegar o ultimo id da tabela conta");

		}

		// Retornar id da conta
		return idConta;
	}

	// Adquirir o último id da tabela pessoa
	public int ultimoIdPessoa() {

		// Criar sql
		String sql = "SELECT MAX(idPessoa) FROM pessoa";

		// Variável para retornar o id da última pessoa
		int maiorId = 0;

		try {

			// Preparar sql
			Statement stmt = conexao.createStatement();

			// Executar a sql e adquirir o resultado
			ResultSet rs = stmt.executeQuery(sql);

			// Atribuir valor a variáel
			maiorId = rs.getInt("idPessoa");

			// Fechar conexão
			stmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar as informações da tabela de pessoa");
		}

		// Retornar maior id
		return maiorId;
	}

	// Adquirir id da matéria do professor
	public int adquiriridMateria() {

		// Criar sql
		String sql = "SELECT materiaProfessor FROM professor WHERE idPessoa = ?";

		// Variável para retornar o id da matéria
		int idMateria = 0;

		try {

			// Instanciar PessoasBean
			PessoaBean pb = new PessoaBean();

			// Preparar sql
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdConta());

			// Executar a sql e adquirir o resultado
			ResultSet rs = pstmt.executeQuery();
			rs.last();

			// ATribuir valor a variável
			idMateria = rs.getInt("materiaProfessor");

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error: " + error);
		}

		// Retornar valor
		return idMateria;
	}

	// Adquirir matéria do professor
	public void adquirirnomeMateria() {

		// Criar sql
		String sql = "SELECT nomeMateria FROM materiasprofessor WHERE idMateria = ?";

		try {

			// Instanciar professor
			ProfessorBean pb = new ProfessorBean();

			// Preparar e executar o sql
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, adquiriridMateria());

			// Executar sql e adquirir o resultado
			ResultSet rs = pstmt.executeQuery();
			rs.last();

			// Instanciar e adquirir o nome da matéria
			MateriasProfessorBean mp = new MateriasProfessorBean();
			mp.setNomeMateria(rs.getString("nomeMateria"));

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro: " + error);
		}

	}

	// Adquirir id registrado na tabela "materiasProfessor"
	public int adquirirIdMateriasProfessor() {
		
		// Criar sql
		String sql = "SELECT MAX(materiasProfessor.idMateria)AS maxidMateria FROM materiasProfessor";
		
		// Variável para retornar o id
		int idMateria = 0;
		
		try {
			
			// Preparar SQL
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			rs.last();
			idMateria = rs.getInt("maxidMateria");
			stmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao localizar o id registrado na tabela MateriasProfessor");
		}
		return idMateria;
	}

	// Adquirir o id cadastrado na tabela "Professor"
	public int adquirirIdProfessor() {
		String sql = "SELECT MAX(professor.idProfessor)AS maxIdProfessor FROM professor";
		int idProfessor = 0;

		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				rs.getInt(0);
				idProfessor = rs.getInt("maxIdProfessor");
				stmt.execute(sql);
				stmt.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao localizar o id registrado na tabela professor");
		}
		return idProfessor;
	}

	// Adquirir o id da tabela "sala"
	public int adquirirIdSala() {
		String sql = "SELECT MAX(sala.idTurma)AS maxidTurma FROM sala";
		int idTurma = 0;
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				rs.getInt(0);
				idTurma = rs.getInt("maxidTurma");
				stmt.execute(sql);
				stmt.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao localizar o id da tabela sala");
		}

		return idTurma;
	}

	// Adquirir idTurma
	public int adquirirIdTurma() {
		String sql = "SELECT sala.idTurma FROM sala WHERE sala.serie LIKE ?";
		int pegarIdTurma = 0;

		try {

			SalaBean sb = new SalaBean();

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, sb.getSerie());

			// Executar query
			ResultSet rs = pstmt.executeQuery();
			rs.last();

			sb.setIdTurma(rs.getInt("idTurma"));
			pegarIdTurma = rs.getInt("idTurma");

			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}

		return pegarIdTurma;

	}

	// Adquirir quantidadeAlunos
	public int adquirirquantidadeAluno() {
		String sql = "SELECT sala.quantidadeAlunos FROM sala WHERE idTurma = ?";
		int quantidadeAluno = 0;

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, adquirirIdTurma());

			ResultSet rs = pstmt.executeQuery();

			quantidadeAluno = rs.getInt("quantidadeAlunos");

			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
		}

		return quantidadeAluno;

	}

	// Acrescentar 1 aluno na quatidade de alunos
	public void mais1Aluno() {
		String sql = "UPDATE sala SET sala.quantidadeAlunos = ? WHERE idTurma = ?";

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, adquirirquantidadeAluno());
			pstmt.setInt(2, adquirirIdTurma());
			pstmt.executeQuery();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro 0ha");
		}

	}

	// Adquirir o id registrado na tabela "Aluno"
	public int adquirirIdAluno() {
		String sql = "SELECT MAX(aluno.idAluno)AS maxIdAluno FROM aluno";
		int idAluno = 0;
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				rs.getInt(0);
				idAluno = rs.getInt("maxIdAluno");
				stmt.execute(sql);
				stmt.close();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao localizar o id da tabela Aluno");
		}
		return idAluno;
	}
}
