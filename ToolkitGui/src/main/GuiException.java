package main;

public class GuiException extends Throwable {

	private static final long serialVersionUID = 1L;

	public GuiException(Exception e) {
		System.out.println(e);

	}

	public GuiException(GuiException e) {
		System.out.println(e);
	}
}
