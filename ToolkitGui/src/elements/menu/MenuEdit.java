package elements.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuEdit extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuEdit() {
		super();
		this.setText("Bearbeiten");
		this.setMnemonic('E');
		this.add(copy());
		this.add(paste());
	}

	private JMenuItem copy() {
		JMenuItem item = new JMenuItem("Kopieren");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Copy");
			}
		});
		return item;

	}

	private JMenuItem paste() {
		JMenuItem item = new JMenuItem("Einfügen");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.Event.CTRL_MASK));
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Paste");
			}
		});
		return item;

	}
}
