package com.app.exec;

public class ResourceNotFound extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFound() {
		super();
	}

	public ResourceNotFound(String arg0) {
		System.out.println("Resouce Not Found...");
	}

}
