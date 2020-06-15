/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.persist;

/**
 *  Queries of the productDao.
 * 
 *  @author Lewis
 */
public abstract class PromotionQueries {
    
    public final static String SELECT_ALL = "SELECT * FROM promotions";
    public final static String SELECT_WHERE_ID = "SELECT * FROM promotions WHERE promotionid = ?";
    public final static String SELECT_PROMOTES_BY_DATE_START = "SELECT * FROM promotes WHERE start_date >= ?";
    public final static String SELECT_PROMOTES_BY_PRODUCT = "SELECT * FROM promotes WHERE productid = ?";
    public final static String SELECT_PROMOTION_BY_CLUB = "SELECT * FROM promotions WHERE clubid = ?";
    
}
