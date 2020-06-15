/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.pojo;

import java.sql.Date;
import java.util.Map;

/**
 *
 * @author Lewis
 */
public class Reservation {
    private int tableId;
    private int clubId;
    private int userId;
    private Date date;

    public Reservation(int tableId, int clubId, int userId, Date date) {
        this.tableId = tableId;
        this.clubId = clubId;
        this.userId = userId;
        this.date = date;
    }
    
    public Reservation(Map<String,Object> json) {
        this.tableId = (int) json.get("tableId");
        this.clubId = (int) json.get("clubId");
        this.userId = (int) json.get("userId");
        this.date = (Date) json.get("date");
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClunId(int clunId) {
        this.clubId = clunId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    @Override
    public String toString() {
        return "Reservation{" + "tableId=" + tableId + ", clunId=" + clubId + ", userId=" + userId + ", date=" + date + '}';
    }
    
    
}
