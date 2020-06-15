
package org.cat.proven.wolprayproject.models.persist;

/**
 *  Queries of the productDao.
 * 
 *  @author Lewis
 */
public abstract class UserQueries {
    public final static String SELECT_ALL_USERS = "SELECT * FROM users";
    public final static String SELECT_USER_WHERE_ROLE = "SELECT * FROM users WHERE role = ?";
    public final static String SELECT_WHERE_USERNAME = "SELECT * FROM users WHERE username = ?";
    public final static String SELECT_WHERE_MAIL = "SELECT * FROM users WHERE mail = ?";
    public final static String SELECT_WHERE_PHONE = "SELECT * FROM users WHERE phone = ?";
    public final static String SELECT_WHERE_ID = "SELECT * FROM users WHERE userid = ?";
    public final static String SELECT_IS_LOGGED = "SELECT * FROM online_users WHERE userid = ?";
    public final static String UPDATE_LOGOUT = "UPDATE online_users SET is_loged = 0 WHERE userid = ?";
    public final static String UPDATE_LOGIN = "UPDATE online_users SET is_loged = 1 WHERE userid = ?";
    public final static String INSERT_NEW_LOGGIN = "INSERT INTO online_users VALUES(?, 0)";
    public final static String INSERT_NEW_USER = "INSERT INTO users(username, mail, "
            + "password, streetname, streetnumber, "
            + "postal_code, phone, city, birthdate, "
            + "role) VALUES "
            + "(?,?,?,?,?,?,?,?,?,?)";

    public final static String UPDATE_USER = "UPDATE users set username = ?, mail = ?, "
            + "password = ?, streetname = ?, streetnumber = ?, "
            + "postal_code = ?, phone = ?, city = ?, birthdate = ?, "
            + "image_profile = null WHERE userid = ?";

    public final static String DELETE_USER = "DELETE FROM users WHERE userid = ?";
}
