package elements.base;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import main.GuiException;
import elements.menu.BaseMenuBar;

public class GuiRootPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 640;
	private static int HEIGHT = 480;

	public GuiRootPanel() throws GuiException {

		// GUI-Style
		setGuiStyle();

		// Basiseinstellungen
		setBasicRootpanelOptions();

		// Menubar
		this.setJMenuBar(new BaseMenuBar());

		// Contentpanel
		this.setContentPane(new GuiContentPanel());
	}

	private void setBasicRootpanelOptions() {
		this.setTitle("Neue GUI");
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setSize(new Dimension(getWidth(), getHeight()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addComponentListener(rootpanelListener());
		this.setVisible(true);
	}

	private void setGuiStyle() throws GuiException {
		try {

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			throw new GuiException(e);
		}
	}

	private ComponentListener rootpanelListener() {
		return new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				getContentPane().setSize(new Dimension(getWidth(), getHeight()));
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				//
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				//
			}

			@Override
			public void componentShown(ComponentEvent e) {
				repaint();
			}
		};
	}
}
