package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.com.escolatcc.bean.AlunoBean;
import br.com.escolatcc.bean.ContasBean;
import br.com.escolatcc.bean.EnderecoBean;
import br.com.escolatcc.bean.MateriasProfessorBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.bean.ProfessorBean;
import br.com.escolatcc.bean.SalaBean;
import br.com.escolatcc.connection.ConnectionFactory;
import br.com.escolatcc.view.TelaLogin;

public class CadastrarDao {

	// Obter conexão
	private Connection conexao;

	public CadastrarDao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}

	// Gerar matrícula
	public int gerarMatrícula() {

		String sql = "SELECT MAX(matricula) FROM aluno";
		int pegarUltimaMatrícula = 0;

		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			pegarUltimaMatrícula = rs.getInt("matricula") + 1;

			stmt.close();

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error: " + error, "", 0);
		}

		return pegarUltimaMatrícula;

	}

	// Método para cadastrar aluno
	public void cadastrarAlunos() {

		String sql = "INSERT INTO aluno VALUES (null, ?, ?, ?, ?)";

		try {

			// Instanciar aluno
			AlunoBean ab = new AlunoBean();
			AdquirirDadosDao ad = new AdquirirDadosDao();

			// Preparar e executar query
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, ad.ultimoIdPessoa());
			pstmt.setInt(2, gerarMatrícula());
			pstmt.setString(3, ab.getDataDeInicio());
			pstmt.setInt(4, ab.getIdSala());
			pstmt.executeQuery();

			pstmt.close();

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Error: " + error, "", 0);
		}
	}

	// Método para cadastrar professor
	public void cadastrarProfessor() {

		String sql = "INSERT INTO professor VALUES (null, ?, ?)";

		try {

			// Instanciar professor
			ProfessorBean pb = new ProfessorBean();
			AdquirirDadosDao ad = new AdquirirDadosDao();

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(pb.getMateriaProfessor(), 1);
			pstmt.setInt(ad.ultimoIdPessoa(), 2);
			pstmt.executeQuery();

			pstmt.close();

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro: " + error, "", 0);
		}

	}

	// Cadastro para a tabela de "pessoa"
	public void cadastrarPessoas() {
		String sql = "INSERT INTO pessoa (idPessoa,nomePessoa,nascimentoPessoa,idEnderecoPessoa,numero,email,"
				+ "sexo,rg,cpf,aluno,funcionario,professor,idConta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			// Instanciar pessoa
			PessoaBean pb = new PessoaBean();

			// Preparar SQL
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdPessoa());
			pstmt.setString(2, pb.getNomePessoa());
			pstmt.setInt(3, pb.getNascimentoPessoa());
			pstmt.setInt(4, pb.getIdEnderecoPessoa());
			pstmt.setInt(5, pb.getNumero());
			pstmt.setString(6, pb.getEmail());
			pstmt.setString(7, pb.getSexo());
			pstmt.setInt(8, pb.getRg());
			pstmt.setInt(9, pb.getCpf());
			pstmt.setBoolean(10, pb.isAluno());
			pstmt.setBoolean(11, pb.isFuncionario());
			pstmt.setBoolean(12, pb.isProfessor());
			pstmt.setInt(13, pb.getIdConta());

			pstmt.execute();

			pstmt.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Falha ao executar o cadastro da tabela Pessoa");

		}
	}

	// Cadastrar uma conta
	public void CadastarConta() {

		String sql = "INSERT INTO contas (idConta,login,password,permissao) VALUES (?,?,?,?)";
		
		ContasBean cb = new ContasBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, cb.getIdConta());
			pstmt.setString(2, cb.getLogin());
			pstmt.setString(3, cb.getPassword());
			pstmt.setString(4, cb.getPermissao());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastar um registro na tabela contas");
		}

	}

	// Cadastrar informações na tabela de "endereco"
	public void CadastraEndereco() {
		String sql = "INSERT INTO endereco (idEndereco,numeroCasa,cepEndereco,ruaEndereco,bairroEndereco,cidadeEndereco) VALUES (?,?,?,?,?,?)";

		EnderecoBean eb = new EnderecoBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, eb.getIdEndereco());
			pstmt.setInt(2, eb.getNumeroCasa());
			pstmt.setInt(3, eb.getCepEndereco());
			pstmt.setString(4, eb.getRuaEndereco());
			pstmt.setString(5, eb.getBairroEndereco());
			pstmt.setString(6, eb.getCidadeEndereco());
			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar informações na tabela de endereco");
		}

	}

	// Cadastrar um registro na tabela "materiasProfessor"
	public void CadastrarMateriasProfessor() {
		String sql = "INSERT INTO materiasProfessor(idMateria,nomeMateria) VALUES (?,?)";
		
		MateriasProfessorBean mpb = new MateriasProfessorBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, mpb.getIdMateria());
			pstmt.setString(2, mpb.getNomeMateria());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastar um registro na tabela materiasProfessor ");
		}

	}

	// Cadastrar um registro na tabela "sala"
	public void CadastarSala() {
		
		String sql = "INSERT INTO sala (idTurma,sala,quantidadeAlunos,serie,turno) VALUES (?,?,?,?,?)";
		
		SalaBean sb = new SalaBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, sb.getIdTurma());
			pstmt.setString(2, sb.getSala());
			pstmt.setInt(3, sb.getQuantidadeAlunos());
			pstmt.setString(4, sb.getSerie());
			pstmt.setString(5, sb.getTurno());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar os registros cadastrados na tabela sala");
		}
	}
}
