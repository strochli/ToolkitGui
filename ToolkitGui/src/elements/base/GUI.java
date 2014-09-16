package elements.base;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.GuiException;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	public GUI() {

		SwingUtilities.invokeLater(new Runnable() {

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
