package com.javaex.vo;


public class GuestbookVO  {
	
	private int guest_id;
	private String name;
	private String password;
	private String content;
	private String reg_date;
	
	public GuestbookVO() {
		super();
	}

	public GuestbookVO(int guest_id, String name, String password, String content, String reg_date) {
		super();
		this.guest_id = guest_id;
		this.name = name;
		this.password = password;
		this.content = content;
		this.reg_date = reg_date;
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "GuestbookVO [guest_id=" + guest_id + ", name=" + name + ", password=" + password + ", content="
				+ content + ", reg_date=" + reg_date + "]";
	}
	
	
}
