package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.escolatcc.bean.AlunoBean;
import br.com.escolatcc.bean.ContasBean;
import br.com.escolatcc.bean.EnderecoBean;
import br.com.escolatcc.bean.MateriasProfessorBean;
import br.com.escolatcc.bean.PessoaBean;
import br.com.escolatcc.bean.SalaBean;
import br.com.escolatcc.connection.ConnectionFactory;

public class AlterarDao {

	private Connection conexao;

	public AlterarDao() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conexao = cf.obterConexao();

	}

	// Alterar quaisquer registro cadastrado na tabela "Aluno"
	public void alterarAluno() {

		String sql = "UPDATE aluno SET matricula = ? , dataDeInicio = ? WHERE idAluno = ?";

		try {

			AlunoBean ab = new AlunoBean();

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, ab.getMatricula());
			pstmt.setString(2, ab.getDataDeInicio());
			pstmt.setInt(3, ab.getIdAluno());
			pstmt.execute();
			pstmt.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar um registro cadastrado na tabela aluno");
		}
	}

	// Alterar quaiquer registro da tabela "contas"
	public void alterarConta() {
		String sql = "UPDATE contas SET login = ? , password = ? , permissao = ? WHERE idConta = ?";

		ContasBean cb = new ContasBean();

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, cb.getLogin());
			pstmt.setString(2, cb.getPassword());
			pstmt.setString(3, cb.getPermissao());
			pstmt.setInt(4, cb.getIdConta());
			pstmt.execute();
			pstmt.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar o registro na tabela contas");
		}
	}

	// Alterar informações sobre a tablea "endereco" já existentes
	public void alterarEndereco() {

		String sql = "UPDATE endereco SET numeroCasa = ? , cepEndereco = ? , ruaEndereco = ? , bairroEndereco = ? , cidadeEndereco = ? WHERE idEndereco";

		EnderecoBean eb = new EnderecoBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, eb.getNumeroCasa());
			pstmt.setInt(2, eb.getCepEndereco());
			pstmt.setString(3, eb.getRuaEndereco());
			pstmt.setString(4, eb.getBairroEndereco());
			pstmt.setString(5, eb.getCidadeEndereco());
			pstmt.setInt(6, eb.getIdEndereco());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar as informações na tabela de endereco");

		}

	}

	// Alterar quaisquer registro cadastrado na tabela "materiasProfessor"
	public void alterarMateriasProfessor() {
		String sql = "UPDATE materiasProfessor SET nomeMateria = ? WHERE idMateria = ?";

		MateriasProfessorBean mp = new MateriasProfessorBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, mp.getNomeMateria());
			pstmt.setInt(2, mp.getIdMateria());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Falhas ao alterar quaisquer registro cadastrado na tabela materiasProfessor");
		}
	}

	// Alterar informações da tabela "pessoa"
	public void alterarPessoa() {
		String sql = "UPDATE pessoa SET nome = ? , nascimentoPessoa = ? , numero = ? , email = ? , sexo = ? , rg = ? , cpf = ? , aluno = ? "
				+ ", funcionario = ? , professor = ? WHERE idPessoa = ? ";
		
		PessoaBean pb = new PessoaBean();
		
		try {

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getNomePessoa());
			pstmt.setInt(2, pb.getNascimentoPessoa());
			pstmt.setInt(3, pb.getNumero());
			pstmt.setString(4, pb.getEmail());
			pstmt.setString(5, pb.getSexo());
			pstmt.setInt(6, pb.getRg());
			pstmt.setInt(7, pb.getCpf());
			pstmt.setBoolean(8, pb.isAluno());
			pstmt.setBoolean(9, pb.isFuncionario());
			pstmt.setBoolean(10, pb.isProfessor());
			pstmt.setInt(11, pb.getIdPessoa());

			pstmt.execute();

			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha na alteração da tabela Pessoa");
		}
	}

	// Alterar quaisquer registro cadastrado na tabela "sala"
	public void alterarSala() {

		String sql = "UPDATE sala SET sala = ? , quantidadeAlunos = ? , serie = ? , turno = ? WHERE idTurma = ?";
		
		SalaBean sb = new SalaBean();
		
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, sb.getSala());
			pstmt.setInt(2, sb.getQuantidadeAlunos());
			pstmt.setString(3, sb.getSerie());
			pstmt.setString(4, sb.getTurno());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar o registro selecionado na tabela sala");
		}
	}
}
