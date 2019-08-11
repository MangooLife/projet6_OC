package com.thamarai.p6.Exception;

public class ResourceNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
        super();
    }
	
    public ResourceNotFoundException(Object resourId, Object type) {
        super(resourId != null ? "This "+ type +" id's missing :"+ resourId : null);
    }
}
