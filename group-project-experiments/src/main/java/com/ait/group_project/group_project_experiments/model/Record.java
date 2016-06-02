package com.ait.group_project.group_project_experiments.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="records")
public class Record implements Comparable<Record> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int record_id;
	@Enumerated(EnumType.STRING)
	private RecordFormat record_format;
	@Column(nullable = false)
	private String artist;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String release_year;
	@Column(nullable = false)
	private String country;
	@Column(nullable = false)
	private String label;
	@Column(nullable = false)
	private String pressing;
	@Column(nullable = false)
	private String record_condition;
	private double price;
	private String description;
	private String additional_info;
	private String cover_image;
	
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public RecordFormat getRecord_format() {
		return record_format;
	}
	public void setRecord_format(RecordFormat record_format) {
		this.record_format = record_format;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getPressing() {
		return pressing;
	}
	public void setPressing(String pressing) {
		this.pressing = pressing;
	}
	public String getRecord_condition() {
		return record_condition;
	}
	public void setRecord_condition(String record_condition) {
		this.record_condition = record_condition;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdditional_info() {
		return additional_info;
	}
	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}
	public String getCover_image() {
		return cover_image;
	}
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	@Override
	public String toString() {
		return "id: " + record_id + "\nartist: " + artist + "\ntitle: " + title + "\ncountry: " + country + "\nlabel: " + label;
	}
	
	@Override
	public int compareTo(Record other) {
		if(this.getArtist().compareToIgnoreCase(other.getArtist()) > 0) {
			return 1;
		} 
		if(this.getArtist().compareToIgnoreCase(other.getArtist()) < 0) {
			return -1;
		}
		if(this.getArtist().compareToIgnoreCase(other.getArtist()) == 0) {
			if(this.getTitle().compareToIgnoreCase(other.getTitle()) > 0) {
				return 1;
			} else if(this.getTitle().compareToIgnoreCase(other.getTitle()) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;
	}
}
