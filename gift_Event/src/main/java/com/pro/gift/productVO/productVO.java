package com.pro.gift.productVO;

import java.util.Date;

public class productVO {
	private String pcode;
	private String price;
	private String item;
	private String imageFileName;
	private String pname;
	private String event;
	private String brand;
	private String creationDate;
	private String eventMonth;
	
	
	
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getEventMonth() {
		return eventMonth;
	}
	public void setEventMonth(String eventMonth) {
		this.eventMonth = eventMonth;
	}
	@Override
	public String toString() {
		return "productVO [pcode=" + pcode + ", price=" + price + ", item=" + item + ", imageFileName=" + imageFileName
				+ ", pname=" + pname + ", event=" + event + ", brand=" + brand + ", creationDate=" + creationDate
				+ ", eventMonth=" + eventMonth + "]";
	}
	
}
