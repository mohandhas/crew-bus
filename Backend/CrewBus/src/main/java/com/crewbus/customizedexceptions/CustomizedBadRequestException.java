package com.crewbus.customizedexceptions;

public class CustomizedBadRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomizedBadRequestException (String s)
	{
		super(s);
	}
}
