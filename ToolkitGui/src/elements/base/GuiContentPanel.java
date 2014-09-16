package elements.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class GuiContentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public GuiContentPanel() {

		setContentpanelGlobalSettings();
		this.addComponentListener(contentpanelListener());
	}

	/**
	 * Erzeugt ein Contentpanel mit einem oben mittigen Titel, einem
	 * Center-Frame und einem Frame links.
	 * 
	 * @param title
	 *            Titel des Panels
	 * @param cs
	 *            Platz für die Hauptfunktion
	 * @param ls
	 *            Platz für Menüs etc.
	 */
	public GuiContentPanel(String title, Component cs, Component ls) {

		setContentpanelGlobalSettings();
		this.add(new GuiTitlePanel(title), BorderLayout.NORTH);
		addComponent(ls, BorderLayout.WEST);
		addComponent(cs, BorderLayout.CENTER);
		this.addComponentListener(contentpanelListener());
	}

	/**
	 * Erzeugt ein Contentpanel mit einem oben mittigen Titel und einem
	 * Center-Frame.
	 * 
	 * @param title
	 *            Titel des Panels
	 * @param cs
	 *            Platz für die Hauptfunktion
	 */
	public GuiContentPanel(String title, Component cs) {

		setContentpanelGlobalSettings();
		this.add(new GuiTitlePanel(title), BorderLayout.NORTH);
		this.add(cs, BorderLayout.CENTER);
	}

	private void setContentpanelGlobalSettings() {
		BorderLayout guiLayout = new BorderLayout();
		guiLayout.maximumLayoutSize(getParent());
		this.setLayout(guiLayout);
		this.setBackground(Color.LIGHT_GRAY);
		this.addComponentListener(contentpanelListener());
	}

	private boolean addComponent(Component comp, String orientation) {
		if (comp != null && !"".equals(orientation)) {
			this.add(comp, orientation);
			return true;
		}
		return false;
	}

	private ComponentListener contentpanelListener() {
		return new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				repaint();
			}

			@Override
			public void componentResized(ComponentEvent e) {
				//
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				//
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				//
			}
		};
	}
}
