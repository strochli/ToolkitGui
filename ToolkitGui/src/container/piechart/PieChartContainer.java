package container.piechart;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import elements.base.GuiContentPanel;

public class PieChartContainer extends GuiContentPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel leftpanel;
	private JComboBox<String> cmb;
	private final ChartPanel pieChart;
	private final DefaultPieDataset dataset;
	private final Container mainpanel;

	public PieChartContainer(String title) {

		this.setPreferredSize(getMaximumSize());

		// Init Panels
		leftpanel = new JPanel();
		mainpanel = new JPanel();

		// Layout leftpanel
		BoxLayout leftPanelLayout = new BoxLayout(leftpanel, BoxLayout.Y_AXIS);
		leftpanel.setLayout(leftPanelLayout);

		// Comboboxes and Buttons for testing
		JComboBox<String> cmb = cmbEnv();
		JButton button1 = button("Button 1");
		JButton button2 = button("Button 2");

		// Left Panel
		leftpanel.add(cmb);
		leftpanel.add(button1);
		leftpanel.add(button2);

		// Create PieChart
		dataset = PieChart.createPieDataset(null, null);
		pieChart = new PieChart(PieChart.buildPieChart(dataset));

		// add to Main Panel
		mainpanel.add(pieChart);

		this.add(new GuiContentPanel(title, mainpanel, leftpanel));

	}

	private ActionListener alCmbChangedSelection() {
		ActionListener newListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				switch (cmb.getSelectedIndex()) {
				case 0:
					dataset.setValue("Normale Menschen", 20.0);
					dataset.setValue("Vollidioten", 200.0);
					dataset.setValue("Spacken", 300.0);
					break;
				case 1:
					dataset.setValue("Normale Menschen", 60.0);
					dataset.setValue("Vollidioten", 100.0);
					break;

				default:
					break;
				}
			}
		};
		return newListener;
	}

	private JButton button(String title) {
		JButton button = new JButton(title);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		return button;
	}

	/**
	 * Tipp von StackOverflow
	 * 
	 * JComboBox is misbehaving (the same as JTextField) in reporting an
	 * unbounded max height: should never show more than a single line. Remedy
	 * is the same: subclass and return a reasonable height
	 * 
	 * Source:
	 * http://stackoverflow.com/questions/7581846/swing-boxlayout-problem
	 * -with-jcombobox-without-using-setxxxsize
	 * 
	 * @return
	 */
	private JComboBox<String> cmbEnv() {
		cmb = new JComboBox<String>(new String[] { "Vollidioten", "Normale Menschen" }) {

			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getMaximumSize() {
				Dimension max = super.getMaximumSize();
				max.height = getPreferredSize().height;
				return max;
			}
		};
		cmb.setAlignmentX(Component.LEFT_ALIGNMENT);
		cmb.addActionListener(alCmbChangedSelection());
		return cmb;
	}

}
