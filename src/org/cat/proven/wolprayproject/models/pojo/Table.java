/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.pojo;

import com.google.gson.Gson;
import java.util.Map;

/**
 *
 * @author Lewis
 */
public class Table {
    //Attributes
    private int id;
    private int num;
    private boolean vip;
    private boolean reserved;

    //Constructors
    public Table(int id, int num, boolean vip, boolean reserved) {
        this.id = id;
        this.num = num;
        this.vip = vip;
        this.reserved = reserved;
    }
    
    public Table(String json) {
        Gson g = new Gson();
        Table table = g.fromJson(json, Table.class);
        this.id = table.getId();
        this.num = table.getNum();
        this.vip = table.isVip();
        this.reserved = table.isReserved();
    }
    
    
    public Table(int id) {
        this.id = id;
    }

    public Table() {
    }
    
    public Table(Table table) {
        this.id = table.getId();
        this.num = table.getNum();
        this.vip = table.isVip();
        this.reserved = table.isReserved();
    }
    
    public Table(Map<String,Object> json){
        this.id = (int)json.get("id");
        this.num = (int)json.get("num");
        this.vip = (boolean)json.get("vip");
        this.reserved = (boolean)json.get("reserved");
    }
    
    
    //accesors
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
    
    
    
    
    
    
    /** equals()
	 * compares this table to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other table to compare to
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
				if (obj instanceof Table) {
				    Table other = (Table) obj;
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
        return "Table{" + "id=" + id + ", num=" + num + ", vip=" + vip + ", reserved=" + reserved + '}';
    }
}
