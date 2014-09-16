package elements.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import container.barchart.BarChartContainer;
import container.piechart.PieChartContainer;
import container.treetable.FileSystemTree;
import elements.base.GuiContentPanel;

public class MenuEnvironment extends JMenu {

	private static final long serialVersionUID = 1L;
	private GuiContentPanel cp;

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
		item.addActionListener(createPieChart(item.getText()));
		item.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.Event.CTRL_MASK));
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
		item.addActionListener(createTreeTable());
		return item;

	}

	private ActionListener createPieChart(final String title) {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp = new PieChartContainer("Pie Chart Example");
				repaintAll(cp);
			}
		};
		return newListener;
	}

	private ActionListener createBarChart() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cp = new BarChartContainer("Bar Chart Example");
				repaintAll(cp);
			}
		};
		return newListener;
	}

	private ActionListener createTreeTable() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final Component newPanel = new JScrollPane(new FileSystemTree(new File("D:/iTunes/iTunes Media/Music")));
				cp = new GuiContentPanel("Dateisystem", null, newPanel);
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
