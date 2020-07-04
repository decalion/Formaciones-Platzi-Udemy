package com.icaballero.app.upload.storage;

public class StorageException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6989249476948470578L;

	public StorageException(String message) {
		super(message);
	}
	
	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}

}
