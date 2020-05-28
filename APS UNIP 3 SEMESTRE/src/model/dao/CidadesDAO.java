package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ModelTelaCidades;

public class CidadesDAO {

	public void create(ModelTelaCidades r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO local (IdCidCidades,NomeCidade,Estado,Regiao)VALUES(?,?,?,?)");
			stmt.setInt(1, r.getIdCidCidades());
			stmt.setString(2, r.getNomeCidade());
			stmt.setString(3, r.getEstado());
			stmt.setString(4, r.getRegiao());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<ModelTelaCidades> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModelTelaCidades> relatorioa = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM local");
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelTelaCidades ra = new ModelTelaCidades();

				ra.setIdCidCidades(rs.getInt("IdCidCidades"));
				ra.setNomeCidade(rs.getString("NomeCidade"));
				ra.setEstado(rs.getString("Estado"));
				ra.setRegiao(rs.getString("Regiao"));

				relatorioa.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioa;

	}

	public void update(ModelTelaCidades r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE local SET IdCidCidades = ?, NomeCidade = ?, Estado = ?, Regiao = ? WHERE IdCidCidades = ?");
			stmt.setInt(1, r.getIdCidCidades());
			stmt.setString(2, r.getNomeCidade());
			stmt.setString(3, r.getEstado());
			stmt.setString(4, r.getRegiao());
			stmt.setInt(5, r.getIdCidCidades());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar alteração!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(ModelTelaCidades r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM local WHERE IdCidCidades = ?");
			stmt.setInt(1, r.getIdCidCidades());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
