package com.vankong.forward;


import com.vankong.utils.StringUtils;

public class BaseServerResponse {

	private String exceptionMessage;
	private String cookies;

	public String getCookies() {
		return cookies;
	}

	public void setCookies(String cookies) {
		this.cookies = cookies;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
