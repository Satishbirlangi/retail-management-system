package com.myapp.spring.responseType;

public class ResponseType {

	private int errcode;
	private String status;
	private String message;
	private String run;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public ResponseType(String run) {
		this.run = run;
	}

	public ResponseType() {
	}

}
