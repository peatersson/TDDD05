package domain;

import java.math.BigDecimal;

public class Car {
	private String name;
	private BigDecimal price;
 
	public BigDecimal getPrice(){
		return price;
	}
	public String getName(){
		return name;
	}
	public void setPrice(BigDecimal newPrice){
		this.price = newPrice;
	}
	public void setName(String newName){
		this.name = newName;
	}
}