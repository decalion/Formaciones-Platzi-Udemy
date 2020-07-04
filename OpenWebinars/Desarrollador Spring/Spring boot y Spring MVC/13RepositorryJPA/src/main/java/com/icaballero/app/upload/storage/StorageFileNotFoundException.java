package com.icaballero.app.upload.storage;

public class StorageFileNotFoundException extends StorageException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7444609844012659087L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
