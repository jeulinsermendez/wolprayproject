/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.pojo;

import java.util.List;
import java.util.Map;



/**
 *
 * @author Lewis
 */
public class Club {
    //Attributes
    private int id;
    private String name;
    private String streetName;
    private int streetNumber;
    private String postalCode;
    private String city;
    private String description;
    private String ambience;
    private String phone;
    private String dressCode;
    private String coverUrl;
    List<Slot> schedule;
    List<Table> tableList;
    List<Reservation> reservationList;
    List<Product> productList;
    
    
    //Constructors
    public Club(int id, String name, String streetName, int streetNumber, String postalCode, String City, String description, String ambience, String phone, String dressCode, String coverUrl, List<Slot> schedule, List<Table> tableList, List<Reservation> reservationList, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = City;
        this.description = description;
        this.ambience = ambience;
        this.phone = phone;
        this.dressCode = dressCode;
        this.coverUrl = coverUrl;
        this.schedule = schedule;
        this.tableList = tableList;
        this.reservationList = reservationList;
        this.productList = productList;
    }
   
 

    public Club(int id) {
        this.id = id;
    }
    
    public Club() {
    }

    public Club(Club club) {
        this.id = club.getId();
        this.name = club.getName();
        this.streetName = club.getStreetName();
        this.streetNumber = club.getStreetNumber();
        this.postalCode = club.getPostalCode();
        this.city = club.getCity();
        this.description = club.getDescription();
        this.ambience = club.getAmbience();
        this.phone = club.getPhone();
        this.dressCode = club.getDressCode();
        this.productList = club.getProductList();
        this.reservationList = club.getReservationList();
        this.tableList = club.getTableList();
        this.schedule = club.getSchedule();
    }
    
    /*public Club(Map<String,Object> json) {
        this.id = (int) json.get("id");
        this.name = (String) json.get("id");
        this.streetName = (String) json.get("id");
        this.streetNumber = club.getStreetNumber();
        this.postalCode = (String) json.get("id");
        this.city = (String) json.get("id");
        this.description = (String) json.get("id");
        this.ambience = (String) json.get("id");
        this.phone = (String) json.get("id");
        this.dressCode = (String) json.get("id");
        this.productList = club.getProductList();
        this.reservationList = club.getReservationList();
        this.tableList = club.getTableList();
        this.schedule = club.getSchedule();
    }*/


    
    //Accesors
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = City;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmbience() {
        return ambience;
    }

    public void setAmbience(String ambience) {
        this.ambience = ambience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Slot> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Slot> schedule) {
        this.schedule = schedule;
    }
    
    
    /** equals()
	 * compares this club to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other club to compare to
	 * @return true if they are equals, false otherwise
	 */
    @Override
    public boolean equals(Object obj) {
		boolean b = false;
		if (obj == null) {
			b= false;
		} else {
			if (obj == this) {
				b = true;
			} else {
				if (obj instanceof Club) {
				    Club other = (Club) obj;
				    b = (this.id == other.id);
				} else {
					b = false;
				}
			}
		}
		return b;
	}

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", name=" + name + ", streetName=" + streetName + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode + ", City=" + city + ", description=" + description + ", ambience=" + ambience + ", phone=" + phone + ", dressCode=" + dressCode + ", productList=" + ", schedule=" + schedule + '}';
    }
}
