package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.GuiException;

public class DbUtils {

	public static void handleClose(ResultSet rs, PreparedStatement stmt) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				try {
					throw new GuiException(e);
				} catch (GuiException e1) {
					//
				}
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				try {
					throw new GuiException(e);
				} catch (GuiException e1) {
					//
				}
			}
		}

	}

}
