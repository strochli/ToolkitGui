package elements.menu;

import javax.swing.JMenuBar;

public class BaseMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public BaseMenuBar() {
		super();
		this.add(new MenuFile());
		this.add(new MenuEdit());
		this.add(new MenuEnvironment());
	}

}
