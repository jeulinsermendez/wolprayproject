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
public class Promotion {
    private int id;
    private int clubId;
    private String name;
    private String description;
    private String coverUrl;

    public Promotion(int id, int clubId, String name, String description, String coverUrl) {
        this.id = id;
        this.clubId = clubId;
        this.name = name;
        this.description = description;
        this.coverUrl = coverUrl;
    }
    
    public Promotion(Map<String,Object> json) {
        this.id = (int) json.get("id");
        this.clubId = (int) json.get("clubId");
        this.name = (String) json.get("name");
        this.description = (String) json.get("description");
        this.coverUrl = (String) json.get("coverUrl");
    }
    

    public Promotion(int id) {
        this.id = id;
    }

    public Promotion() {
    }
    
    public Promotion(Promotion promotion) {
        this.id = promotion.id;
        this.clubId = promotion.clubId;
        this.name = promotion.name;
        this.description = promotion.description;
        this.coverUrl = promotion.coverUrl;
    }

    public int getId() {
        return id;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
    
    

    public void setId(int id) {
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
    

    /** equals()
	 * compares this Promotion to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other Promotion to compare to
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
				if (obj instanceof Promotion) {
				    Promotion other = (Promotion) obj;
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
        return "Promotion{" + "id=" + id + ", name=" + name + ", description=" + description + ", coverUrl=" + coverUrl + '}';
    }
    
    
}
