package com.ydo4ki.openarrays.ftable;

public class FieldTableFormingException extends RuntimeException {
	public FieldTableFormingException(Exception e) {
		super("FTable creation failed", e);
	}
}
