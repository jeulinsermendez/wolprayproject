package org.cat.proven.wolprayproject.models.pojo;

import java.util.List;

/**
 *
 * @author Lewis
 */
public class Bill {

    //Attributes
    private int id;
    private String dateBilling;
    private User user;
    private Club club;
    private int qantity;
    private List<Product> productList;
    private double total = 0;
    private Qr qrCode;

    
    //Constructors
    public Bill(int id, String dateBilling, User user, Club club, List<Product> productList, double total, Qr qrCode) {
        this.id = id;
        this.dateBilling = dateBilling;
        this.user = user;
        this.club = club;
        this.productList = productList;
        this.qrCode = qrCode;
        putTotalPrice();
    }

    public Bill(int id) {
        this.id = id;
    }

    public Bill() {
    }

    public Bill(Bill bill) {
        this.id = bill.id;
        this.dateBilling = bill.dateBilling;
        this.user = bill.user;
        this.club = bill.club;
        this.qantity = bill.qantity;
        this.productList = bill.productList;
        putTotalPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateBilling() {
        return dateBilling;
    }

    public void setDateBilling(String dateBilling) {
        this.dateBilling = dateBilling;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getQantity() {
        return qantity;
    }

    public void setQantity(int qantity) {
        this.qantity = qantity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Qr getQrCode() {
        return qrCode;
    }

    public void setQrCode(Qr qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * equals() compares this Bill to another one two persons are equals if
     * their nifs are equals.
     *
     * @param obj other: the other person to compare to
     * @return true if they are equals, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if (obj == null) {
            b = false;
        } else {
            if (obj == this) {
                b = true;
            } else {
                if (obj instanceof Bill) {
                    Bill other = (Bill) obj;
                    b = (this.id == other.id);
                } else {
                    b = false;
                }
            }
        }
        return b;
    }

    /**
     * put the total quantity of products purchased and the total price.
     */
    private void putTotalPrice() {
        if (productList != null) {
            this.qantity = productList.size();
            productList.forEach(prdct -> {
                this.total += prdct.getPrice();
            });
        }
    }
}
