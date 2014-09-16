package container.barchart;

import java.awt.Container;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import elements.base.GuiContentPanel;

public class BarChartContainer extends GuiContentPanel {

	private static final long serialVersionUID = 1L;
	private final ChartPanel barChart;
	private final Container mainpanel;

	public BarChartContainer(String title) {

		this.setPreferredSize(getMaximumSize());

		// Init Panels
		mainpanel = new JPanel();

		// Create PieChart
		barChart = new BarChart(BarChart.createBarChart());

		// add to Main Panel
		mainpanel.add(barChart);

		this.add(new GuiContentPanel(title, mainpanel));

	}

}
