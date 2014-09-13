package elements.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuFile extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuFile() {
		super();
		this.setText("Datei");
		this.setMnemonic('D');
		this.add(open());
		this.add(close());
	}

	private JMenuItem open() {
		JMenuItem item = new JMenuItem("÷ffnen");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("÷ffnen");
			}
		});
		return item;

	}

	private JMenuItem close() {
		JMenuItem item = new JMenuItem("Schlieﬂen");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK));
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Finito");
				System.exit(0);
			}
		});
		return item;

	}

}
