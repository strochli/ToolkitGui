package main;

import data.DerbyDB;
import elements.base.GUI;

public class RunGui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (DerbyDB.createDerbyDB())
			new GUI();
	}

}
