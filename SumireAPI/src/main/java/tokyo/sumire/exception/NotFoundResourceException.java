package tokyo.sumire.exception;

public class NotFoundResourceException extends RuntimeException {

	public NotFoundResourceException(Throwable th) {
		super("検索エラー", th);
	}

	public NotFoundResourceException() {
		super("検索エラー");
	}
}
