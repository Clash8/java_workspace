package it.prova.motociclettajdbc.dao;

import it.prova.motociclettajdbc.connection.MyConnection;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotociclettaDAO {
	// =============================================== LIST
	public List<Motocicletta> elencaTuttiQuelliAttualmenteSullaBaseDati() {

		Connection connection = null;
		ResultSet rs = null;
		Statement s = null;
		Motocicletta temp;
		List<Motocicletta> result = new ArrayList<>();

		try {
			connection = MyConnection.getConnection();
			s = connection.createStatement();

			rs = s.executeQuery("select * from motocicletta;");

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setId(rs.getLong("id"));
				temp.setModello(rs.getString("modello"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				temp.setDataImmatricolazione(rs.getDate("dataImmatricolazione"));
				result.add(temp);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				s.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// =============================================== INSERT
	public int insert(Motocicletta input) {

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement(
					"INSERT INTO motocicletta (modello, cilindrata, dataimmatricolazione) " + "VALUES (?, ?, ?) ");
			ps.setString(1, input.getModello());
			ps.setInt(2, input.getCilindrata());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataImmatricolazione().getTime()));

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// =============================================== UPDATE
	public int update(Motocicletta input) {

		if (input == null || input.getId() < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("UPDATE motocicletta SET modello=?, cilindrata=?, dataimmatricolazione=? where id = ?;");
			ps.setString(1, input.getModello());
			ps.setInt(2, input.getCilindrata());
			// quando si fa il setDate serve un tipo java.sql.Date
			ps.setDate(3, new java.sql.Date(input.getDataImmatricolazione().getTime()));
			ps.setLong(4, input.getId());

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// =============================================== DELETE
	public int delete(Long idElementToDelete) {

		if (idElementToDelete == null || idElementToDelete < 1) {
			return 0;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("DELETE from motocicletta where id=?;");
			ps.setLong(1, idElementToDelete);

			result = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	// =============================================== FINDBYID
	public Motocicletta findById(Long input) {

		if (input == null || input < 1) {
			return null;
		}

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta result = null;

		try {

			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("select * from motocicletta u where u.id=?;");
			ps.setLong(1, input);

			rs = ps.executeQuery();

			if (rs.next()) {
				result = new Motocicletta();
				result.setId(rs.getLong("id"));
				result.setModello(rs.getString("modello"));
				result.setCilindrata(rs.getInt("cilindrata"));
				result.setDataImmatricolazione(rs.getDate("dataimmatricolazione"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

//			// =============================================== BY Nome and Cognome
	public List<Motocicletta> selectByModelloIniziaPer(String modello) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Motocicletta temp = null;
		List<Motocicletta> result = new ArrayList<>();

		try {
			connection = MyConnection.getConnection();
			ps = connection.prepareStatement("select * from motocicletta u where u.modello like ?");
			ps.setString(1, modello + '%');

			rs = ps.executeQuery();

			while (rs.next()) {
				temp = new Motocicletta();
				temp.setId(rs.getLong("id"));
				temp.setModello(rs.getString("modello"));
				temp.setCilindrata(rs.getInt("cilindrata"));
				temp.setDataImmatricolazione(rs.getDate("dataImmatricolazione"));
				result.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//deleteByCognome(String cognomeInput) ,
	//public List<Lavoratore> findAllNatiTra(Date before, Date after)
	//public int contaQuantiLavoratoriConIlCognome (String cognomeInput)
//
//	public int deleteByCognome(String cognomeInput) {
//		if (cognomeInput == null || cognomeInput.isEmpty()) {
//			return 0;
//		}
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//		int result = 0;
//
//		try {
//
//			connection = MyConnection.getConnection();
//			ps = connection.prepareStatement("DELETE from lavoratore where cognome LIKE ?;");
//			ps.setString(1, cognomeInput);
//
//			result = ps.executeUpdate();
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		} finally {
//			try {
//				ps.close();
//				connection.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return result;
//	}
//
//	public List<Lavoratore> findAllNatiTra(Date before, Date after) {
//		Connection connection = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Lavoratore temp = null;
//		List<Lavoratore> result = new ArrayList<Lavoratore>();
//
//		try {
//
//			connection = MyConnection.getConnection();
//			ps = connection.prepareStatement("select * from lavoratore where datadinascita between ? and ? ");
//			ps.setDate(1, new java.sql.Date(before.getTime()));
//			ps.setDate(2, new java.sql.Date(after.getTime()));
//
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				temp = new Lavoratore();
//				temp.setId(rs.getLong("id"));
//				temp.setNome(rs.getString("nome"));
//				temp.setCognome(rs.getString("cognome"));
//				temp.setDataDiNascita(rs.getDate("datadinascita"));
//				temp.setRal(rs.getInt("ral"));
//				result.add(temp);
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		} finally {
//			try {
//				rs.close();
//				ps.close();
//				connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	public int contaQuantiLavoratoriConIlCognome (String cognomeInput) {
//		if (cognomeInput == null || cognomeInput.isEmpty()) {
//			return 0;
//		}
//
//		Connection connection = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		int result = 0;
//
//		try {
//
//			connection = MyConnection.getConnection();
//			ps = connection.prepareStatement("select count(*) from lavoratore where cognome=?;");
//			ps.setString(1, cognomeInput);
//
//			rs = ps.executeQuery();
//
//			if (rs.next()) {
//				result = rs.getInt(1);
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		} finally {
//			try {
//				rs.close();
//				ps.close();
//				connection.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		return result;
//	}
}
