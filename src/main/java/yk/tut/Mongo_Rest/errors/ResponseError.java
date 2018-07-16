package yk.tut.Mongo_Rest.errors;

public class ResponseError {

	private Integer code;
	private String message;
	
	public ResponseError(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
