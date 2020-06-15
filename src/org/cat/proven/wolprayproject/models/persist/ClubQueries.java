
package org.cat.proven.wolprayproject.models.persist;


/**
 *  Queries of the ClubDao.
 * 
 * @author Lewis
 */
public abstract class ClubQueries {
    public final static String SELECT_ALL_CLUBS = "SELECT * FROM clubs";
    public final static String SELECT_CLUB_WHERE_ID = "SELECT * FROM clubs WHERE clubid = ?";
    public final static String SELECT_CLUB_WHERE_NAME = "SELECT * FROM clubs WHERE LOWER(clubname) = ?";
    public final static String SELECT_CLUB_WHERE_CITY = "SELECT * FROM clubs WHERE city = ?";
    public final static String SELECT_CLUB_WHERE_AMBIENCE = "SELECT * FROM clubs WHERE ambience = ?";
    public final static String SELECT_CLUB_WHERE_DRESS_CODE = "SELECT * FROM clubs WHERE dress_code = ?";
    public final static String SELECT_CLUB_WHERE_POSTAL_CODE = "SELECT * FROM clubs WHERE postal_code = ?";
    
}
