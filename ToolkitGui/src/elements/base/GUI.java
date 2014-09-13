package elements.base;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.GuiException;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUI() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new GuiRootPanel();
				} catch (GuiException e) {
					try {
						throw new GuiException(e);
					} catch (GuiException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
