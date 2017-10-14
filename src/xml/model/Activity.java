package xml.model;

import java.util.Date;

public class Activity {
	private long id;
	private String name;
	private String description;
	private String place;
	private Date startDate;
	

	public Activity(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Activity() {
		this.id = 1;
		this.name = "generic";
		this.description = "doSomething";
		this.setPlace("somewhere");
		this.startDate = new Date();
	}
	
	public Activity(long id, String name, String description, String place, Date startDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.place = place;
		this.startDate = startDate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	// Modify to String to add the missing attributes.
	public String toString() {
		return "Name="+name+", Description="+description + "Place="+place+"StartDate="+startDate;
	}




}
