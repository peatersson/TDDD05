package model;

public class Contact {
	private String name;
	private String mail;
	private String number;
	private String info;
	
	public String getName(){
		return name;
		}
	public void setName(String newName){
		this.name = newName;
	}

	public String getMail(){
		return mail;
	}
	public void setMail(String newMail){
		this.mail = newMail;
	}
	
	public String getNumber(){
		return number;
	}
	public void setNumber(String newNumber){
		this.number = newNumber;
	}
	
	public String getInfo(){
		return info;
	}
	public void setInfo(String newInfo){
		this.info = newInfo;
	}
}
