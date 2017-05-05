package model;

public class Contact {
	private String name;
	private String mail;
	private int number;
	private String info;
	
	public Contact(String name, String mail, int number, String info){
		this.name = name;
		this.mail = mail;
		this.number = number;
		this.info = info;
	}
	
	
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
	
	
	public int getNumber(){
		return number;
	}
	public void setNumber(int newNumber){
		this.number = newNumber;
	}
	
	
	public String getInfo(){
		return info;
	}
	public void setInfo(String newInfo){
		this.info = newInfo;
	}
}
