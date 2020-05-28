package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.ModelTelaDoencas;
import model.bean.ModelTelaPopulacao;

public class DoencasDAO {

	public void create(ModelTelaDoencas r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"INSERT INTO doencas (IdCidDoen,DoenAno,QtdInfec, QtdVac, QtdObito, Sexo)VALUES(?,?,?,?,?,?)");
			stmt.setInt(1, r.getIdCidDoen());
			stmt.setInt(2, r.getDoenAno());
			stmt.setInt(3, r.getQtdInfec());
			stmt.setInt(4, r.getQtdVac());
			stmt.setInt(5, r.getQtdObito());
			stmt.setString(6, r.getSexo());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso!");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar cadastro!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<ModelTelaDoencas> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModelTelaDoencas> relatorioabc = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM doencas");
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelTelaDoencas ra = new ModelTelaDoencas();

				ra.setIdCidDoen(rs.getInt("IdCidDoen"));
				ra.setDoenAno(rs.getInt("DoenAno"));
				ra.setQtdInfec(rs.getInt("QtdInfec"));
				ra.setQtdVac(rs.getInt("QtdVac"));
				ra.setQtdObito(rs.getInt("QtdObito"));
				ra.setsexo(rs.getString("Sexo"));

				relatorioabc.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioabc;

	}

	public void update(ModelTelaDoencas r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE doencas SET IdCidDoen = ?, DoenAno = ?, QtdInfec = ?, QtdVac = ?, QtdObito = ?, Sexo = ?  WHERE IdCidDoen = ?");
			stmt.setInt(1, r.getIdCidDoen());
			stmt.setInt(2, r.getDoenAno());
			stmt.setInt(3, r.getQtdInfec());
			stmt.setInt(4, r.getQtdVac());
			stmt.setInt(5, r.getQtdObito());
			stmt.setString(6, r.getSexo());
			stmt.setInt(7, r.getIdCidDoen());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar alteração!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(ModelTelaDoencas r) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM doencas WHERE IdCidDoen = ?");
			stmt.setInt(1, r.getIdCidDoen());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão!");
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
