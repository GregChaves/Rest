package com.chaves.Heroes.domain;

import java.io.Serializable;

/**
 * @author gregorio.de.chaves
 *
 */
public class ResponseTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String result;
	
	private int code;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
}