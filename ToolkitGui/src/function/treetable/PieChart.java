package function.treetable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart extends ChartPanel {

	private static final long serialVersionUID = 1L;

	public PieChart() {
		super(createPieChart());
	}

	private static JFreeChart createPieChart() {
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Lustige Menschen", 10);
		pieDataset.setValue("Normale", 5);
		pieDataset.setValue("Vollidioten", 85);
		JFreeChart chart = ChartFactory.createPieChart(null, // Title
				pieDataset, // Dataset
				true,// legend
				true,// tooltips
				false// URL
				);
		chart.setAntiAlias(true);
		return chart;
	}
}
