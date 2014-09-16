package container.barchart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart extends ChartPanel {

	private static final long serialVersionUID = 1L;

	public BarChart(JFreeChart chart) {
		super(chart);
	}

	public static JFreeChart createBarChart() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1.0, "Row 1", "Column 1");
		dataset.addValue(5.0, "Row 1", "Column 2");
		dataset.addValue(3.0, "Row 1", "Column 3");
		dataset.addValue(2.0, "Row 2", "Column 1");
		dataset.addValue(3.0, "Row 2", "Column 2");
		dataset.addValue(2.0, "Row 2", "Column 3");

		JFreeChart chart = ChartFactory.createBarChart3D("Bar Chart Demo", // chart
																			// title
				"Kategorie", // domain axis label
				"Wert", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				false, // include legend
				false, // tooltips
				false // URLs
				);

		return chart;
	}

}
