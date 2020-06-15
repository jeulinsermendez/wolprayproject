package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.Date;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Product;
import org.cat.proven.wolprayproject.models.pojo.Reservation;
import org.cat.proven.wolprayproject.models.pojo.Slot;
import org.cat.proven.wolprayproject.models.pojo.Table;

/**
 * Manages access to database data.
 * 
 * @author Lewis
 */
public class ClubDao {

    private Connection conn;

    /**
     * Empty builder.
     */
    public ClubDao() {
    }

    /**
     * Search all clubs from the database.
     *
     * @return list of clubs from the database.
     */
    public List<Club> findAllClubs() {
        System.out.println("Find all clubs entry");
        List<Club> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            if (conn != null) {
                Statement smt = conn.createStatement();
                ResultSet rs = smt.executeQuery(ClubQueries.SELECT_ALL_CLUBS);
                while (rs.next()) {
                    Club club = getClub(rs);
                    if (club != null) {
                        result.add(club);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION: "+ex);
            result = null;
        }
        return result;
    }

    /**
     * Find club from the database with a given id from the controller.
     *
     * @param id:Id of the club to find.
     * @return Club object, null in case of error.
     */
    public Club findClubById(int id) {
        Club result = null;

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = getClub(rs);
            }
        } catch (SQLException ex) {
            result = null;
        }

        return result;
    }

    /**
     *
     * Find club from the database with a given name from the controller.
     *
     * @param name: name of the club to find.
     * @return Club object, null in case of error.
     */
    public Club findClubByName(String name) {
        Club result = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_NAME);
            ps.setString(1, name.toLowerCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = getClub(rs);
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    /**
     * Find a listo of clubs from the database with a given city from the
     * controller.
     *
     * @param city: City of the clubs to find.
     * @return list of clubs from the database with a same attribute, null in
     * case of error.
     */
    public List<Club> findClubsBycity(String city) {
        List<Club> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_CITY);
            ps.setString(1, city);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = getClub(rs);
                if (club != null) {
                    result.add(club);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     * Find a listo of clubs from the database with a given ambience from the
     * controller.
     *
     * @param ambience: Ambience of the clubs to find.
     * @return return list of clubs from the database with a same attribute,
     * null in case of error.
     */
    public List<Club> findClubsByAmbience(String ambience) {
        List<Club> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_AMBIENCE);
            ps.setString(1, ambience);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = getClub(rs);
                if (club != null) {
                    result.add(club);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     * Find a listo of clubs from the database with a given dress code from the
     * controller.
     *
     * @param dressCode: Dress code of the clubs to find.
     * @return return list of clubs from the database with a same attribute,
     * null in case of error.
     */
    public List<Club> findClubsByDressCode(String dressCode) {
        List<Club> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_DRESS_CODE);
            ps.setString(1, dressCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = getClub(rs);
                if (club != null) {
                    result.add(club);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     * Find a listo of clubs from the database with a given postal code from the
     * controller.
     *
     * @param cp: Postal code of the clubs to find.
     * @return return list of clubs from the database with a same attribute,
     * null in case of error.
     */
    public List<Club> findClubsByPostalCode(String cp) {
        List<Club> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ClubQueries.SELECT_CLUB_WHERE_POSTAL_CODE);
            ps.setString(1, cp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = getClub(rs);
                if (club != null) {
                    result.add(club);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     * Construct a club object with a given result set.
     *
     * @param rs : Result set with which to build the club object.
     * @return club object, null in case of error.
     */
    private Club getClub(ResultSet rs) {
        Club club;
        try {
            int id = rs.getInt("clubid");
            String name = rs.getString("clubname");
            String streetName = rs.getString("streetname");
            int streetNumber = rs.getInt("streetnumber");
            String postalCode = rs.getString("postal_code");
            String city = rs.getString("city");
            String description = rs.getString("description");
            String ambience = rs.getString("ambience");
            String phone = rs.getString("phone");
            String dressCode = rs.getString("dress_code");
            String coverUrl = rs.getString("cover_url");
            List<Table> tableList = getTableList(id);
            List<Slot> schedule = getSchedule(id);
            List<Reservation> reservations = getReservationList(id);
            List<Product> productList = getProductListInAClub(id);

            club = new Club(id, name, streetName, streetNumber, postalCode,
                    city, description, ambience, phone, dressCode, coverUrl, schedule,
                    tableList, reservations, productList);

        } catch (SQLException ex) {
            club = null;
        }
        return club;
    }

    /**
     * Find a listo of tables from the database with a given club id from the
     * controller.
     *
     * @param id: Id of the tables to find.
     * @return list of tables from the database with a same clubid, null in case
     * of error.
     */
    private List<Table> getTableList(int id) {
        List<Table> result = new ArrayList<>();
        String query = "SELECT * FROM tables WHERE clubid = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Table table = getTable(rs);
                if (table != null) {
                    result.add(table);
                }
            }
        } catch (SQLException ex) {
        }
        return result;
    }

    /**
     * Construct a table object with a given result set.
     *
     * @param rs : Result set with which to build the club object.
     * @return table object, null in case of error.
     */
    private Table getTable(ResultSet rs) {
        Table table;
        try {
            int tableid = rs.getInt("tableid");
            int tablenum = rs.getInt("num_table");
            boolean vip;
            int isVip = rs.getInt("VIP");
            if (isVip == 0) {
                vip = false;
            } else {
                vip = true;
            }
            table = validateTable(tableid, tablenum, vip);

        } catch (SQLException ex) {
            table = null;
        }
        return table;
    }

    /**
     * Build a table object by checking if it is reserved or not.
     *
     * @param tableid : Id of the table to build.
     * @param tablenum: Num of the table to build.
     * @param vip: Boolean object to check if it is vip.
     * @return Table marked as served if reserved, table available otherwise.
     */
    private Table validateTable(int tableid, int tablenum, boolean vip) {
        Table table = null;
        String query = "SELECT tableid FROM reservations WHERE tableid = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tableid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int isreserved = rs.getInt("tableid");
                if (isreserved > 0) {
                    table = new Table(tableid, tablenum, vip, true);
                }
            } else {
                table = new Table(tableid, tablenum, vip, false);
            }

        } catch (SQLException ex) {
            table = new Table(tableid, tablenum, vip, false);
        }
        return table;
    }

    
    /**
     * Find a listo of slots from the database with a given club id from the controller.
     * 
     * @param id: Id of the slots to find.
     * @return list of slots from the database with a same clubid, null in case of error.
     */
    private List<Slot> getSchedule(int id) {
        List<Slot> result = new ArrayList<>();
        String query = "SELECT * FROM slots WHERE clubid = ?";
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Slot slot = getSlot(rs);
                if(slot != null){
                    result.add(slot);
                }
            }
        } catch (SQLException ex) {
            result = null;
        }

        return result;
    }

    
    /**
     *Find a listo of reservations from the database with a given club id from the controller.
     * 
     * @param id: Id of the slots to find.
     * @return list of reservations from the database with a same clubid, null in case of error.
     */
    private List<Reservation> getReservationList(int id) {
        List<Reservation> result = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE clubid = ? and date >= now()";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = getReservation(rs);
                if (reservation != null) {
                    result.add(reservation);
                }
            }

        } catch (SQLException ex) {
        }
        return result;
    }

    
    /**
     * Construct a reservation object with a given result set.
     * 
     * @param rs : Result set with which to build the reservation object.
     * @return reservation object, null in case of error.
     */
    private Reservation getReservation(ResultSet rs) {
        Reservation reservation;
        try {
            int tableId = rs.getInt("tableid");
            System.out.println("La tabla id de reserva es " + tableId);
            int clubid = rs.getInt("clubid");
            int userid = rs.getInt("userid");
            Date date = rs.getDate("date");
            reservation = new Reservation(tableId, clubid, userid, date);
        } catch (SQLException ex) {
            reservation = null;
        }

        return reservation;
    }

    
    /**
     * Find a listo of products from the database with a given club id from the controller.
     * 
     * @param id: clubid of the product to find.
     * @return list of clubs from the database with a same clubid, null in case of error.
     */
    private List<Product> getProductListInAClub(int id) {
        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM products WHERE clubid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = getProduct(rs);
                if (product != null) {
                    result.add(product);
                }
            }
        } catch (SQLException e) {
        }

        return result;
    }

    
    
    /**
     * Construct a product object with a given result set.
     * 
     * @param rs : Result set with which to build the product object.
     * @return product object, null in case of error.
     */
    private Product getProduct(ResultSet rs){
        Product product;
        try {
            int productId = rs.getInt("productid");
            String productName = rs.getString("productname");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            String imageUrl = rs.getString("image_url");
            String category = rs.getString("category");
            int status = rs.getInt("status");
            boolean isInTock;
            isInTock = status == 1;
            product = new Product(productId, productName, category, description, price, imageUrl, isInTock);
        } catch (SQLException e) {
            product = null;
        }

        return product;
    }


    /**
     *Construct a slot object with a given result set.
     * 
     * @param rs : Result set with which to build the slot object.
     * @return slot object, null in case of error.
     */
    private Slot getSlot(ResultSet rs) {
        Slot slot;
        
        try {
            int slotId = rs.getInt("slotid");
            int clubId = rs.getInt("clubid");
            String openingTime = rs.getString("opening_time");
            String closingTime = rs.getString("closing_time");
            String day = rs.getString("day");
            slot = new Slot(slotId, clubId, openingTime, closingTime, day);
        } catch (SQLException e) {
            slot = null;
        }
        return slot;
    }

}
