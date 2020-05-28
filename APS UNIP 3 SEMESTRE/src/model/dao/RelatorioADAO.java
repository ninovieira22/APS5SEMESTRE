package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.ModelRelatorioA;
import model.bean.ModelRelatorioC;
import model.bean.ModelTelaCidades;
import view.TelaRelatorioA;

public class RelatorioADAO {

	public List<ModelRelatorioA> read() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ModelRelatorioA mra = new ModelRelatorioA();

		List<ModelRelatorioA> relatorioab = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT DISTINCT" + "    idciddoen," + "    nomecidade," + "    popuqtd,"
					+ "    popuano," + "    SUM(QtdInfec)," + "	((SUM(QtdInfec) * 100) / popuqtd),"
					+ "    SUM(qtdvac), " + "	((SUM(qtdvac) * 100) / popuqtd)," + "    SUM(qtdobito), "
					+ "	((SUM(qtdobito) * 100)/ popuqtd)"
					+ "FROM doencas INNER JOIN populacao ON idciddoen = idcidpopu AND doenano = popuano INNER JOIN local ON idcidpopu = idcidcidades WHERE "
					+ "popuano between 2000 AND 2010" + " GROUP BY idciddoen;");

			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelRelatorioA ra = new ModelRelatorioA();

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

				relatorioab.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioab;

	}

	public List<ModelRelatorioA> readForDesc(String desc, String desc2, String cid1, String cid2) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<ModelRelatorioA> relatorioab = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT DISTINCT" + "    idciddoen," + "    nomecidade," + "    popuqtd,"
					+ "    popuano," + "    SUM(QtdInfec)," + "	((SUM(QtdInfec) * 100) / popuqtd),"
					+ "    SUM(qtdvac), " + "	((SUM(qtdvac) * 100) / popuqtd)," + "    SUM(qtdobito), "
					+ "	((SUM(qtdobito) * 100)/ popuqtd)"
					+ "FROM doencas INNER JOIN populacao ON idciddoen = idcidpopu AND doenano = popuano INNER JOIN local ON idcidpopu = idcidcidades WHERE "
					+ "(popuano between ? AND ?) AND nomecidade in (? , ?)" + " GROUP BY idciddoen, popuano;");

			stmt.setString(1, desc);
			stmt.setString(2, desc2);
			stmt.setString(3, cid1);
			stmt.setString(4, cid2);
			rs = stmt.executeQuery();

			while (rs.next()) {

				ModelRelatorioA ra = new ModelRelatorioA();

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

				relatorioab.add(ra);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro!" + ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return relatorioab;

	}

}
