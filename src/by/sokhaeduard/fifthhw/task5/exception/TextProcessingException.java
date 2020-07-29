package by.sokhaeduard.fifthhw.task5.exception;

public class TextProcessingException extends Exception {
	private static final long serialVersionUID = 1L;

	public TextProcessingException() {
    }

    public TextProcessingException(String message) {
        super(message);
    }

    public TextProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextProcessingException(Throwable cause) {
        super(cause);
    }
}
