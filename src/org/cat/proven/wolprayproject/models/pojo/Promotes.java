
package org.cat.proven.wolprayproject.models.pojo;

import java.sql.Date;

public class Promotes {
    private int productID;
    private int promotionId;
    private double discount;
    private Date startDate;
    private Date endDate;

    public Promotes(int productID, int promotionId, double discount, Date startDate, Date endDate) {
        this.productID = productID;
        this.promotionId = promotionId;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Promotes{" + "productID=" + productID + ", promotionId=" + promotionId + ", discount=" + discount + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

 
    
    
    
}
