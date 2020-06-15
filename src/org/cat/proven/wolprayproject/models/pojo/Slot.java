/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.pojo;

import java.util.Map;

/**
 *
 * @author Lewis
 */
public class Slot {
    private int id;
    private int clubId;
    private String openingTime;
    private String closingTime;
    private String day;

    public Slot(int id, int clubId, String openingTime, String closingTime, String day) {
        this.id = id;
        this.clubId = clubId;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
    }
    
    
    public Slot(Map<String,Object> json) {
        this.id = (int) json.get("id");
        this.clubId = (int) json.get("clubId");
        this.openingTime = (String) json.get("openingTime");
        this.closingTime = (String) json.get("closingTime");
        this.day = (String) json.get("day");
    }
    
    
    

    public Slot(int id) {
        this.id = id;
    }

    public Slot() {
    }
    
    public Slot(Slot slot) {
        this.id = slot.id;
        this.openingTime = slot.openingTime;
        this.closingTime = slot.closingTime;
        this.day = slot.day;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    /** equals()
	 * compares this Slot to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other person to compare to
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
				if (obj instanceof Slot) {
				    Slot other = (Slot) obj;
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
        return "Slot{" + "id=" + id + ", openingTime=" + openingTime + ", closingTime=" + closingTime + ", day=" + day + '}';
    }
    
    
    
}
