package com.github.leventarican.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Developer {
	
	@Id
	@GeneratedValue
	private long id;
	private String programmingLanguage;

	public Developer() {
	}

	public Developer(long id) {
		this.id = id;
	}
	
	public Developer(long id, String programmingLanguage) {
		this.id = id;
		this.programmingLanguage = programmingLanguage;
	}
	
	public long getId() {
		return id;
	}
	
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	
	@Override
	public String toString() {
		return "id: " + id + " programming language: " + programmingLanguage;
	}
}
