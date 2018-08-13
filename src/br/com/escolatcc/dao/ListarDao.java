package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.escolatcc.bean.AlunoBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.connection.ConnectionFactory;

public class ListarDao {

	private Connection conexao;

	public ListarDao() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conexao = cf.obterConexao();

	}

	// Listar os registros cadastrados da tabela "Aluno"
	public void listarAlunos() {

		String sql = "SELECT * FROM aluno";

		try {

			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// Setar os dados dos alunos e pegar os dados de outras tabelas
				/*
				 * rs.getInt("idAluno"); rs.getInt("idPessoa"); rs.getInt("Matricula");
				 * rs.getString("dataDeInicio"); rs.getInt("idSaça"); rs.getInt("idSerie");
				 */
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro: " + error);
		}
	}

	// Listar registros cadastrados da tabela "conta"
	public DefaultTableModel listarContas() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("idConta");
		modelo.addColumn("login");
		modelo.addColumn("password");
		modelo.addColumn("permissao");

		String sql = "SELECT * FROM contas";

		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("idConta"), rs.getString("login"), rs.getString("password"),
						rs.getString("permissao") });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar os registos do cadastro da tabela contas");
		}
		return modelo;

	}

	// Listagem de login adm
	public void listarInformacoes() {

		String sql = "SELECT nomePessoa, numero, email FROM pessoa WHERE idConta = ?";

		try {

			// Instanciar classe
			PessoaBean pb = new PessoaBean();

			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdConta());

			// Executar query
			ResultSet rs = pstmt.executeQuery();

			rs.last();

			pb.setNomePessoa(rs.getString("nomePessoa"));
			pb.setNumero(Integer.parseInt(rs.getString("numero")));
			pb.setEmail(rs.getString("email"));

			// Fechar conexão
			pstmt.close();

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro: " + error, "", 0);
		}

	}

	// Listar registros cadastrados na tabela "materiasProrfessor"
	public DefaultTableModel listarMateriasProfessor() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("idMateria");
		modelo.addColumn("nomeMateria");

		String sql = "SELECT * FROM materiasProfessor";

		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getInt("idMateria"), rs.getString("nomeMateria") });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar os registros cadastrados na tabela materiasProfessor");
		}
		return modelo;
	}

	// Listar informações das pessoas cadastradas da tabela "pessoa"
	public void listarPessoas() {

		String sql = "SELECT * FROM pessoa";

		try {
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Setar as informações
				/*
				 * rs.getInt("idPessoa"); rs.getString("nomePessoa");
				 * rs.getInt("nascimentoPessoa"); rs.getInt("idEnderecoPessoa");
				 * rs.getInt("numero"); rs.getString("email"); rs.getString("sexo");
				 * rs.getInt("rg"); rs.getInt("cpf"); rs.getBoolean("aluno");
				 * rs.getBoolean("funcionario"); rs.getBoolean("professor");
				 * rs.getInt("idConta");
				 */
			}
		} catch (

		Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar as informações da tabela de pessoa");
		}

	}

	// Listar os registros cadastrados da tabela "sala"
	public DefaultTableModel listarSala() {
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("idTurma");
		modelo.addColumn("sala");
		modelo.addColumn("quantidadeAlunos");
		modelo.addColumn("serie");
		modelo.addColumn("turno");

		String sql = "SELECT * FROM sala";
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getInt("idTurma"), rs.getString("sala"), rs.getInt("quantidadeAlunos"),
						rs.getString("serie"), rs.getString("turno") });
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar os registros cadastrados da tabela sala");
		}

		return modelo;

	}

	// Listar informações da tabela "Endereco"
	public void listarEndereco() {

		String sql = "SELECT * FROM endereco";

		try {

			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				rs.getInt("idEndereco");
				rs.getInt("numeroCasa");
				rs.getInt("cepEndereco");
				rs.getString("ruaEndereco");
				rs.getString("bairroEndereco");
				rs.getString("cidadeEndereco");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar as informações da tabela Endereco");
		}

	}

	// Adquirir salas para listar
	public void listarSalas() {
		String sql = "SELECT sala.serie FROM sala";

		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			for (int i = 0; rs.next(); i++) {
				AlunoBean ab = new AlunoBean();
				ab.seriesESalas[i] = rs.getString("serie");
				ab.indice++;

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "APRENDE A FAZER CERTO FDP");
		}
	}
}
