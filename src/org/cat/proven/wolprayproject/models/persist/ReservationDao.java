package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Reservation;
import org.cat.proven.wolprayproject.models.pojo.User;




/**
 * Manages access to database data.
 * 
 * @author Lewis
 */
public class ReservationDao {

    private Connection conn;

    /**
     * Empty builder.
     */
    public ReservationDao() {
    }

    
    /**
     * Add a list of reservations given from the controller.
     * 
     * @param reservationList: Reservations list to add.
     * @return True if adds them all, false otherwise.
     */
    public boolean addReservation(List<Reservation> reservationList) {
        boolean itsReserved;
        
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(ReservationQueries.INSERT_RESERVATION);

            for (Reservation reservation : reservationList) {
                ps.setInt(1, reservation.getTableId());
                ps.setInt(2, reservation.getClubId());
                ps.setInt(3, reservation.getUserId());
                ps.setDate(4, reservation.getDate());
                ps.executeUpdate();
            }
            conn.commit();
            itsReserved = true;
            
        } catch (SQLException e) {
            try {
                conn.rollback();
                
            } catch (SQLException ex) {}
            itsReserved = false;
        }
        return itsReserved;
    }

    
    /**
     * Find a reservation list from the database with a given user from the controller.
     * 
     * @param user: User who has made reservations.
     * @return list of reservation from the database with a same attribute, null in case of error.
     */
    public List<Reservation> findReservationsByUser(User user) {
        List<Reservation> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ReservationQueries.SELECT_ALL_RESERVATIONS_WHERE_USER);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = getReservation(rs);
                if (reservation != null) {
                    result.add(reservation);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    
    /**
     * Find a reservation list from the database with a given date from the controller.
     * 
     * @param date: Date of reservations.
     * @param clubId: Club id of reservations.
     * @return list of reservation from the database with a same attribute, null in case of error.
     */
    public List<Reservation> findReservationsByDate(String date, int clubId){
        List<Reservation> result = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ReservationQueries.SELECT_ALL_RESERVATIONS_WHERE_DATE);
            ps.setString(1, date.trim());
            ps.setInt(2, clubId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = getReservation(rs);
                if (reservation != null) {
                    result.add(reservation);
                }
            }

        } catch (SQLException e) {
            result = null;
        }

        return result;
    }

    /**
     *Find a reservation list from the database with a given club from the controller.
     * 
     * @param club: club of reservations.
     * @return list of reservation from the database with a same attribute, null in case of error.
     */
    public List<Reservation> findReservationsByClub(Club club) {
        List<Reservation> result = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ReservationQueries.SELECT_ALL_RESERVATIONS_WHERE_CLUB);
            ps.setInt(1, club.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = getReservation(rs);
                if (reservation != null) {
                    result.add(reservation);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
    
    public boolean removeReservations(List<Reservation> reservations) {
        boolean isRemoved  = false;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ReservationQueries.DELETE_RESERVATIONS_WHERE_TABLE);
            for(Reservation reservation: reservations){
                ps.setInt(1, reservation.getTableId());
                ps.executeUpdate();
            }
            isRemoved  = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isRemoved  = false;
        }
        
        return isRemoved;
    }

    
    private Reservation getReservation(ResultSet rs) {
        Reservation reservation;

        try {
            int tableId = rs.getInt("tableid");
            int clubId = rs.getInt("clubid");
            int userId = rs.getInt("userid");
            Date date = rs.getDate("date");
            reservation = new Reservation(tableId, clubId, userId, date);
        } catch (SQLException e) {
            e.printStackTrace();
            reservation = null;
        }
        return reservation;
    }

}
