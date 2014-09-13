package elements.base;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JTextArea;

public class GuiTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;

	public GuiTextArea() {

		this.addComponentListener(textfieldListener());
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.DARK_GRAY);
	}

	private ComponentListener textfieldListener() {
		return new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent e) {
				//
			}

			@Override
			public void componentResized(ComponentEvent e) {
				setText("Weite: " + String.valueOf(getWidth() - 100) + ", Höhe: " + String.valueOf(getHeight() - 100));
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
