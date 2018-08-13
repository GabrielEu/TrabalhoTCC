package br.com.escolatcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.escolatcc.bean.NotasBean;
import br.com.escolatcc.connection.ConnectionFactory;

public class NotasDao {

	private Connection conexao;

	public NotasDao() {
		ConnectionFactory cf = new ConnectionFactory();
		this.conexao = cf.obterConexao();
	}

	// Localizar o id primário da tabela "notas"
	public int descobrirIdNotas() {
		String sql = "SELECT MAX(notas.idNota)AS maxIdNota FROM notas";
		int idNota = 0;

		try {
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rs.getInt(0);
				idNota = rs.getInt("maxIdNota");
				stmt.execute(sql);
				stmt.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao localizar o id da tabela Notas");
		}
		return idNota;
	}

	// Cadastrar um registro na tabela "notas"
	public void CadastarNotas(NotasBean nb) {

		String sql = "INSERT INTO notas(idNota,nota,idAluno,idProfessor,idMateria) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, nb.getIdAluno());
			pstmt.setDouble(2, nb.getNota());
			pstmt.setInt(3, nb.getIdAluno());
			pstmt.setInt(4, nb.getIdProfessor());
			pstmt.setInt(5, nb.getIdMateria());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao cadastrar um registro na tabela notas");
		}
	}

	// Listar cadastros registrados na tabela "notas"
	public DefaultTableModel listarNotas() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("idNota");
		modelo.addColumn("nota");
		modelo.addColumn("idAluno");
		modelo.addColumn("idProfessor");
		modelo.addColumn("idMateria");

		String sql = "SELECT * FROM notas";
		try {
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getInt("idNota"), rs.getDouble("nota"), rs.getInt("idAluno"),
						rs.getInt("idProfessor"), rs.getInt("idMateria") });
			}

			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao listar os registros cadastrados na tabela notas");
		}
		return modelo;
	}

	// Alterar quaisquer registro cadastrado na tabela "notas"
	public void alterarNotas(NotasBean nb) {
		String sql = "UPDATE notas SET nota = ? WHERE idNota = ?";

		try {

			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setDouble(1, nb.getNota());
			pstmt.setInt(2, nb.getIdAluno());
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar o registro selecionado na tabela notas");

		}
	}

	// Excluir quaisquer registro cadastrado na tabela "notas"
	public void excluirNotas(int idNota) {
		String sql = "DELETE FROM notas WHERE idNota = ?";

		try {
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idNota);
			pstmt.execute();
			pstmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao deletar o registro selecionado da tabela notas");
		}
	}
}
