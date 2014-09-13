package elements.base;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiTitlePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public GuiTitlePanel(String title) {
		this.setName("Titel");
		this.setBackground(Color.DARK_GRAY);

		JLabel appTitle = new JLabel(title);
		appTitle.setFont(new Font("Georgia", Font.PLAIN, 30));
		appTitle.setForeground(Color.WHITE);
		this.add(appTitle);
	}

}
