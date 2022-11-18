package utils;

/**
 * create multiple Custom Exception classes at the framework level (as
 * subclasses of the RuntimeException) and can use them wherever we want to
 * provide some useful customized message
 */
public class FrameworkException extends RuntimeException {
	private Integer errorCode;

	public FrameworkException() {
	}

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}

	public FrameworkException(Throwable cause) {
		super(cause);
	}

	public FrameworkException(String message, Throwable cause, ErrorCodes errorCode) {
		super(message, cause);
		this.errorCode = errorCode.getCode();
	}

	public FrameworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

enum ErrorCodes {

	VALIDATION_PARSE_ERROR(123);

	private int code;

	ErrorCodes(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	}

	