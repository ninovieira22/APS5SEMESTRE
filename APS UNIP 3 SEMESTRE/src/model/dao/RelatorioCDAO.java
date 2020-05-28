package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.ModelRelatorioC;
import model.bean.ModelTelaCidades;
import view.TelaRelatorioC;

public class RelatorioCDAO {

	public List<ModelRelatorioC> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ModelRelatorioC rc = new ModelRelatorioC();

		List<ModelRelatorioC> relatorioaa = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT DISTINCT" + "    idciddoen," + "    nomecidade," + "    popuqtd,"
					+ "    popuano," + "    SUM(QtdInfec)," + "	((SUM(QtdInfec) * 100) / popuqtd),"
					+ "    SUM(qtdvac), " + "	((SUM(qtdvac) * 100) / popuqtd)," + "    SUM(qtdobito), "
					+ "	((SUM(qtdobito) * 100)/ popuqtd)"
					+ "FROM doencas INNER JOIN populacao ON idciddoen = idcidpopu AND doenano = popuano INNER JOIN local ON idcidpopu = idcidcidades WHERE "
					+ "popuano = 1999" + " GROUP BY idciddoen;");

			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelRelatorioC ra = new ModelRelatorioC();

				ra.setIdCidDoen(rs.getInt("IdCidDoen"));
				ra.setNomeCidade(rs.getString("NomeCidade"));
				ra.setPopuQtd(rs.getInt("PopuQtd"));
				ra.setPopuAno(rs.getInt("PopuAno"));
				ra.setQtdInfec(rs.getInt("SUM(QtdInfec)"));
				ra.setQtdInfec2(rs.getDouble("((SUM(QtdInfec) * 100) / popuqtd)"));
				ra.setQtdVac(rs.getInt("SUM(QtdVac)"));
				ra.setQtdVac2(rs.getDouble("((SUM(QtdVac) * 100) / popuqtd)"));
				ra.setQtdObito(rs.getInt("SUM(QtdObito)"));
				ra.setQtdObito2(rs.getDouble("((SUM(QtdObito) * 100)/ popuqtd)"));

				relatorioaa.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioaa;

	}

	public List<ModelRelatorioC> readForDesc(String desc, String desc2) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModelRelatorioC> relatorioaa = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT DISTINCT" + "    idciddoen," + "    nomecidade," + "    popuqtd,"
					+ "    popuano," + "    SUM(QtdInfec)," + "	((SUM(QtdInfec) * 100) / popuqtd),"
					+ "    SUM(qtdvac), " + "	((SUM(qtdvac) * 100) / popuqtd)," + "    SUM(qtdobito), "
					+ "	((SUM(qtdobito) * 100)/ popuqtd)"
					+ "FROM doencas INNER JOIN populacao ON idciddoen = idcidpopu AND doenano = popuano INNER JOIN local ON idcidpopu = idcidcidades WHERE "
					+ "popuano between ? AND ?" + " GROUP BY idciddoen, popuano;");

			stmt.setString(1, desc);
			stmt.setString(2, desc2);
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelRelatorioC ra = new ModelRelatorioC();

				ra.setIdCidDoen(rs.getInt("IdCidDoen"));
				ra.setNomeCidade(rs.getString("NomeCidade"));
				ra.setPopuQtd(rs.getInt("PopuQtd"));
				ra.setPopuAno(rs.getInt("PopuAno"));
				ra.setQtdInfec(rs.getInt("SUM(QtdInfec)"));
				ra.setQtdInfec2(rs.getDouble("((SUM(QtdInfec) * 100) / popuqtd)"));
				ra.setQtdVac(rs.getInt("SUM(QtdVac)"));
				ra.setQtdVac2(rs.getDouble("((SUM(QtdVac) * 100) / popuqtd)"));
				ra.setQtdObito(rs.getInt("SUM(QtdObito)"));
				ra.setQtdObito2(rs.getDouble("((SUM(QtdObito) * 100)/ popuqtd)"));

				relatorioaa.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioaa;

	}

}
