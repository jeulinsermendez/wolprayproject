
package org.cat.proven.wolprayproject.models.persist;

/**
 * Queries of the ReseravtonDao.
 * 
 * @author Lewis
 */
public abstract class ReservationQueries {
    public final static String SELECT_ALL_RESERVATIONS = "SELECT * FROM reservations";
    public final static String SELECT_ALL_RESERVATIONS_WHERE_USER = "SELECT * FROM reservations WHERE userid = ?";
    public final static String SELECT_ALL_RESERVATIONS_WHERE_CLUB = "SELECT * FROM reservations WHERE clubid = ?";
    public final static String SELECT_ALL_RESERVATIONS_WHERE_DATE = "SELECT * FROM reservations WHERE date = ? and clubid = ?";
    public final static String INSERT_RESERVATION = "INSERT INTO reservations VALUES(?,?,?,?)";
    public final static String DELETE_RESERVATIONS_WHERE_TABLE = "DELETE FROM reservations WHERE tableid = ?";
    
}
