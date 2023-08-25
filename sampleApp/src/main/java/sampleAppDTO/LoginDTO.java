package sampleAppDTO;

import java.io.Serializable;

public class LoginDTO implements Serializable{
	private String id;
	private String name;
	private String mail;
	
	public void setid(String id) {
		this.id = id;
	}
	
	public String getid() {
		return id;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return name;
	}
	
	public void setmail(String mail) {
		this.mail = mail;
	}
	
	public String getmail() {
		return mail;
	}
}
