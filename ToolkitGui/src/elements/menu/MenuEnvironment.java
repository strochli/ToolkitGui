package elements.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import elements.base.GuiContentPanel;
import function.treetable.FileSystemTree;

public class MenuEnvironment extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuEnvironment() {
		super();
		this.setText("Bereich");
		this.setMnemonic('B');
		this.add(test());
		this.add(treeTableFunction());

	}

	private JMenuItem test() {
		JMenuItem item = new JMenuItem("Test");
		item.addActionListener(doSomething());
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.Event.CTRL_MASK));
		return item;

	}

	private JMenuItem treeTableFunction() {
		JMenuItem item = new JMenuItem("Dateisystem");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.Event.CTRL_MASK));
		item.addActionListener(startTreeTableFunction());
		return item;

	}

	private ActionListener doSomething() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("tüüüüüüt");
			}
		};
		return newListener;
	}

	private ActionListener startTreeTableFunction() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				final Component newPanel = new JScrollPane(new FileSystemTree(new File("D:/iTunes/iTunes Media/Music")));

				// Neues Contentpanel
				GuiContentPanel cp = new GuiContentPanel("Dateisystem", null, newPanel);

				// ContentPanel ans Rootpanel
				getRootPane().getContentPane().removeAll();
				getRootPane().getContentPane().add(cp);
				getRootPane().getContentPane().revalidate();
				getRootPane().getContentPane().repaint();
			}
		};
		return newListener;
	}
}
