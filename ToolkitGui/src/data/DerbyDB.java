package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.GuiException;

public class DerbyDB {

	private final static String protocol = "jdbc:derby:";

	/**
	 * Erzeugt eine Derby-DB.
	 * 
	 * Tabelle testdata Enthält die Spalten id(int), description(varchar,50),
	 * value(int) und lastupdated(date) mit 10 Testdatensätzen.
	 * 
	 */

	static int sampleDataCount = 0;

	public static boolean createDerbyDB() {

		// Datenbank erstellen, falls nicht vorhanden
		createDatabaseIfNotExisting();

		// Alte Tabellen löschen
		truncateTableTestdata();

		// Tabelle testdata erstellen
		createTableTestdata();

		// Beispieldaten einspielen
		insertSampleData();

		// Beispieldaten überprüfen
		checkSampleData();
		if (sampleDataCount == 10) {
			return true;
		}
		return false;
	}

	private static boolean createDatabaseIfNotExisting() {

		try {

			DriverManager.getConnection(getProtocol() + "db/derbyDB;ifexists=true");
			// Query
			return true;

		} catch (SQLException e) {
			try {
				DriverManager.getConnection(getProtocol() + "db/derbyDB;create=true");
				return true;

			} catch (SQLException e1) {
				try {
					throw new GuiException(e);
				} catch (GuiException e2) {
					//
				}
			}
		}
		return false;
	}

	private static boolean truncateTableTestdata() {

		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = DriverManager.getConnection(getProtocol() + "db/derbyDB;ifexists=true");

			// Query zur Überprüfung, ob die Tabelle existiert
			String query = "TRUNCATE TABLE testdata";
			stmt = con.prepareStatement(query);
			stmt.execute();
			return true;

		} catch (SQLException e) {
			//
		} finally {
			DbUtils.handleClose(null, stmt);
		}
		return false;
	}

	private static boolean createTableTestdata() {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			Connection con = DriverManager.getConnection(getProtocol() + "db/derbyDB;ifexists=true");
			// Query
			String query;
			query = "CREATE TABLE testdata(id INTEGER NOT NULL PRIMARY KEY, description varchar(100), value INTEGER)";
			stmt = con.prepareStatement(query);

			if (stmt.executeUpdate() == 0) {
				return true;
			}

		} catch (SQLException e) {
			try {
				throw new GuiException(e);
			} catch (GuiException e1) {
				//
			}
		} finally {
			DbUtils.handleClose(rs, stmt);
		}
		return false;
	}

	private static boolean insertSampleData() {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			Connection con = DriverManager.getConnection(getProtocol() + "db/derbyDB;ifexists=true");
			// Query
			String query = "INSERT INTO testdata VALUES (?,?,?)";

			insertDataset(con, query, 1, "Waffeln", 100);
			insertDataset(con, query, 2, "Waffeln", 120);
			insertDataset(con, query, 3, "Waffeln", 180);
			insertDataset(con, query, 4, "Waffeln", 50);
			insertDataset(con, query, 5, "Waffeln", 10);
			insertDataset(con, query, 6, "Schokolade", 300);
			insertDataset(con, query, 7, "Schokolade", 220);
			insertDataset(con, query, 8, "Schokolade", 600);
			insertDataset(con, query, 9, "Schokolade", 30);
			insertDataset(con, query, 10, "Schokolade", 700);

		} catch (SQLException e) {
			try {
				throw new GuiException(e);
			} catch (GuiException e1) {
				//
			}
		} finally {
			DbUtils.handleClose(rs, stmt);
		}
		return false;
	}

	private static void insertDataset(Connection con, String query, int index, String desc, int amount) throws SQLException {
		PreparedStatement stmt;
		stmt = con.prepareStatement(query);
		stmt.setInt(1, index);
		stmt.setString(2, desc);
		stmt.setInt(3, amount);
		stmt.executeUpdate();
		stmt.close();
	}

	private static boolean checkSampleData() {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			Connection con = DriverManager.getConnection(getProtocol() + "db/derbyDB;ifexists=true");
			// Query
			String query;
			query = " SELECT * FROM testdata";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
				sampleDataCount++;
			}

		} catch (SQLException e) {
			try {
				throw new GuiException(e);
			} catch (GuiException e1) {
				//
			}
		} finally {
			DbUtils.handleClose(rs, stmt);
		}
		return false;
	}

	public static String getProtocol() {
		return protocol;
	}

}
