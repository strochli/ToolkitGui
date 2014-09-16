package container.piechart;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class PieChart extends ChartPanel {

	private static final long serialVersionUID = 1L;

	public PieChart(JFreeChart chart) {
		super(chart);
	}

	public static DefaultPieDataset createPieDataset(Double val1, Double val2) {

		DefaultPieDataset pieDataset = new DefaultPieDataset();

		if (val1 == null)
			val1 = 10.0D;

		if (val2 == null)
			val2 = 100.0D;

		pieDataset.setValue("Normale Menschen", new Double(val1));
		pieDataset.setValue("Vollidioten", new Double(val2));

		return pieDataset;
	}

	public static JFreeChart buildPieChart(DefaultPieDataset pieDataset) {
		JFreeChart chart = ChartFactory.createPieChart3D("Ergebnis", // Title
				pieDataset, // Dataset
				true,// legend
				true,// tooltips
				true// URL
				);
		chart.setAntiAlias(true);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint("Vollidioten", new Color(237, 0, 57));
		plot.setSectionPaint("Normale Menschen", new Color(70, 125, 180));
		plot.setSimpleLabels(true);
		plot.setForegroundAlpha(0.5f);
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setLabelGenerator(new CustomLabelGenerator());
		return chart;
	}
}
