package container.piechart;

import java.text.AttributedString;

import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;

@SuppressWarnings("rawtypes")
public class CustomLabelGenerator implements PieSectionLabelGenerator {

	@Override
	public String generateSectionLabel(final PieDataset dataset, final Comparable key) {
		String result = null;
		if (dataset != null) {
			result = key.toString() + " - " + dataset.getValue(key);
		}
		return result;
	}

	@Override
	public AttributedString generateAttributedSectionLabel(PieDataset dataset, Comparable key) {
		//
		return null;
	}

}