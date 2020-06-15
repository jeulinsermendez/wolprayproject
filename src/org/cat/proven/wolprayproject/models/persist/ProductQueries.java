/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cat.proven.wolprayproject.models.persist;

/**
 *  Queries of the ProductDao.
 * 
 *  @author Lewis
 */
public abstract class ProductQueries {
    
    public final static String SELECT_PROMOTES_BY_PROMOTION = "SELECT * FROM promotes WHERE promotionid = ? and";
    public final static String SELECT_PRODUCT_WHERE_NAME = "SELECT * FROM products WHERE poductname = ?";
    public final static String SELECT_PRODUCT_WHERE_ID = "SELECT * FROM products WHERE productid = ?";
    
}
