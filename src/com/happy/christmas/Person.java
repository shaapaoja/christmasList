package com.happy.christmas;

import java.util.List;
import java.util.UUID;

public class Person {
	private String name;
	private UUID personId;
	private List<Person> whiteList;
	private Person personSelected;
	private int whitelistIndex = -1;
	private boolean selected = false;
	
	public Person(String name, UUID personId) {
		this.name = name;
		this.personId = personId;
	}
	
	public void setPersonSelected(Person personSelected) {
		this.personSelected = personSelected; 
	}
	
	public int getWhitelistIndex() {
		return whitelistIndex;
	}

	public void setWhitelistIndex(int whitelistIndex) {
		this.whitelistIndex = whitelistIndex;
	}

	public UUID getPersonId() {
		return personId;
	}

	public List<Person> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(List<Person> whiteList) {
		this.whiteList = whiteList;
	}

	public Person getPersonSelected() {
		return personSelected;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
