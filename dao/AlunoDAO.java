package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.AlunoBean;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO(Connection conn){
		this.connection = conn;
	}

	public void insertAluno(AlunoBean alunoBean){
		String sql = "INSERT INTO alunos"
				+ "\n(nome, idade, anoEscolar)"
				+ "\nValues(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, alunoBean.getNome());
			ps.setInt(2, alunoBean.getIdade());
			ps.setString(3, alunoBean.getAnoEscolar());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}	


