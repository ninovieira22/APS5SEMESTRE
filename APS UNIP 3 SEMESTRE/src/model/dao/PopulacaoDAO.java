package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.ModelTelaCidades;
import model.bean.ModelTelaPopulacao;

public class PopulacaoDAO {

	public void create(ModelTelaPopulacao r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO populacao (IdCidPopu,PopuAno,PopuQtd)VALUES(?,?,?)");
			stmt.setInt(1, r.getIdCidPopu());
			stmt.setInt(2, r.getPopuAno());
			stmt.setInt(3, r.getPopuQtd());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	// ----------------------------------------------------------------------------------------------------

	public List<ModelTelaPopulacao> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModelTelaPopulacao> relatorioab = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM populacao");
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelTelaPopulacao ra = new ModelTelaPopulacao();

				ra.setIdCidPopu(rs.getInt("IdCidPopu"));
				ra.setPopuAno(rs.getInt("Popuano"));
				ra.setPopuQtd(rs.getInt("PopuQtd"));

				relatorioab.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioab;

	}

	public void update(ModelTelaPopulacao r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE populacao SET IdCidPopu = ?, PopuAno = ?, PopuQtd = ? WHERE IdCidPopu = ?");
			stmt.setInt(1, r.getIdCidPopu());
			stmt.setInt(2, r.getPopuAno());
			stmt.setInt(3, r.getPopuQtd());
			stmt.setInt(4, r.getIdCidPopu());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar alteração!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(ModelTelaPopulacao r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM populacao WHERE IdCidPopu = ?");
			stmt.setInt(1, r.getIdCidPopu());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
