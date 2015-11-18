package com.cooladata.dal.base.exceptions;

public class NotValidDataException extends RuntimeException{
	
	public NotValidDataException(String msg)
	{
		super("NotValidData :"+msg);
	}

}
