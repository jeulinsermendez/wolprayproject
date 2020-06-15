package org.cat.proven.wolprayproject.models.persist;


import java.util.*;
import org.cat.proven.wolprayproject.models.pojo.Bill;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Qr;
import org.cat.proven.wolprayproject.models.pojo.User;


public class BillDao {

    public BillDao() {
    }


    public List<Bill> findAllfBills() {
        // TODO implement here
        return null;
    }

    public List<Bill> findBillsByDate(Date date) {
        // TODO implement here
        return null;
    }

    public Bill findBillByQr(Qr qrf) {
        // TODO implement here
        return null;
    }

    public List<Bill> findBillsByClub(Club club) {
        // TODO implement here
        return null;
    }

    public List<Bill> findBillsByUser(User user) {
        // TODO implement here
        return null;
    }

    public int addBill(Bill bill) {
        // TODO implement here
        return 0;
    }

    public int removeBill(Bill bill) {
        // TODO implement here
        return 0;
    }

    public int modifyBill(Bill bill) {
        // TODO implement here
        return 0;
    }

    public Bill findBillById(String id) {
        // TODO implement here
        return null;
    }

    public int payBill(User user, Bill bill) {
        // TODO implement here
        return 0;
    }

}