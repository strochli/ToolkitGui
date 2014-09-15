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
import function.treetable.BarChart;
import function.treetable.FileSystemTree;
import function.treetable.PieChart;

public class MenuEnvironment extends JMenu {

	private static final long serialVersionUID = 1L;

	public MenuEnvironment() {
		super();
		this.setText("Funktionen");
		this.setMnemonic('F');
		this.add(pieChart());
		this.add(barChart());
		this.add(treeTableFunction());

	}

	private JMenuItem pieChart() {
		JMenuItem item = new JMenuItem("Pie Charts");
		item.addActionListener(createPieChart());
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.Event.CTRL_MASK));
		return item;

	}

	private JMenuItem barChart() {
		JMenuItem item = new JMenuItem("Bar Charts");
		item.addActionListener(createBarChart());
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.Event.CTRL_MASK));
		return item;

	}

	private JMenuItem treeTableFunction() {
		JMenuItem item = new JMenuItem("Dateisystem");
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.Event.CTRL_MASK));
		item.addActionListener(startTreeTableFunction());
		return item;

	}

	private ActionListener createPieChart() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Neues Contentpanel
				GuiContentPanel cp = new GuiContentPanel("Pie Chart Example", new PieChart());

				// ContentPanel ans Rootpanel
				repaintAll(cp);

			}
		};
		return newListener;
	}

	private ActionListener createBarChart() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Neues Contentpanel
				GuiContentPanel cp = new GuiContentPanel("Bar Chart Example", new BarChart());

				// ContentPanel ans Rootpanel
				repaintAll(cp);

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
				repaintAll(cp);
			}
		};
		return newListener;
	}

	private void repaintAll(GuiContentPanel cp) {
		getRootPane().getContentPane().removeAll();
		getRootPane().getContentPane().add(cp);
		getRootPane().getContentPane().revalidate();
		getRootPane().getContentPane().repaint();
	}
}
