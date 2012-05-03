package com.qq.common;

import java.io.*;
import java.util.*;
public class Usr implements Serializable{
	private String usrId;
    private String password;
    public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
