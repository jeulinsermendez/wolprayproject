package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.cat.proven.wolprayproject.models.pojo.User;

/**
 *
 * Manages access to database data
 *
 * @author Lewis
 */
public class UserDao {

    private Connection conn;

    /**
     * Empty builder.
     */
    public UserDao() {
    }

    /**
     *
     * Add a user into the database given from the controller
     *
     * @param user : User to add.
     * @return 1 if it has added, -3 otherwise.
     */
    public int addUser(User user) {
        int result = -3;

        try {
            conn = DBConnect.getConnection();

            if (conn != null) {

                PreparedStatement ps = conn.prepareStatement(UserQueries.INSERT_NEW_USER);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getMail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getStreetName());
                ps.setInt(5, user.getStreetNumber());
                ps.setString(6, user.getPostalCode());
                ps.setString(7, user.getPhone());
                ps.setString(8, user.getCity());
                ps.setString(9, user.getBirthDate());
                ps.setString(10, user.getRole());
                ps.executeUpdate();
                result = 1;

            }
        } catch (SQLException ex) {

            result = -3;
        }
        newLoginUser(findUserByEmail(user.getMail()));
        return result;
    }

    /**
     * Search all the users from the database.
     *
     * @return list of users from the database.
     */
    public List<User> findAllUsers() {

        List<User> result = new ArrayList<>();

        try {

            conn = DBConnect.getConnection();

            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_ALL_USERS);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    User user = getUser(rs);

                    if (user != null) {
                        result.add(user);
                    }

                }
            }

        } catch (SQLException ex) {

            result = null;

        }

        return result;
    }

    /**
     *
     * Find user from the database with a given email from the controller.
     *
     * @param email :Email of the user to find.
     * @return User object, null in case of error.
     */
    public User findUserByEmail(String email) {
        User user = null;

        try {

            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_WHERE_MAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = getUser(rs);
            }

        } catch (SQLException ex) {

            user = null;

        }
        return user;
    }

    /**
     *
     * Find user from the database with a given user name from the controller.
     *
     * @param userName: User name of the user to find.
     * @return User object, null in case of error.
     */
    public User findUserByUserName(String userName) {

        User user = null;

        try {

            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_WHERE_USERNAME);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = getUser(rs);
            }
        } catch (SQLException ex) {

            user = null;

        }
        return user;
    }

    /**
     *
     * Find a listo of users from the database with a given role from the
     * controller.
     *
     * @param role: Role fof the users to find.
     * @return list of users from the database with a same role, null in case of
     * error.
     */
    public List<User> findUserByRole(String role) {

        List<User> result = new ArrayList<>();

        try {

            conn = DBConnect.getConnection();
            if (conn != null) {

                PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_USER_WHERE_ROLE);
                ps.setString(1, role);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    User user = getUser(rs);

                    if (user != null) {
                        result.add(user);
                    }

                }
            }
        } catch (SQLException ex) {

            result = null;

        }

        return result;
    }

    /**
     * Find user from the database with a given phone from the controller.
     *
     * @param phone: Phone of the user to find.
     * @return User object, null in case of error.
     */
    public User findUserByPhone(String phone) {
        User user = null;

        try {

            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_WHERE_PHONE);
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = getUser(rs);
            }

        } catch (SQLException ex) {

            user = null;

        }
        return user;
    }

    /**
     *
     * Modify a user into the database given from the controller.
     *
     * @param user : User to modify.
     * @return -2 if the username already exists in the other user of the
     * database, -1 if the email already exists in the other user of the
     * database, 0 if the phone already exists in the other user of the
     * database, 1 if it has managed to modify it, -3 otherwise.
     */
    public int modifyUser(User user) {
        int result = validateForModifyUser(user);

        if (result > 0) {
            try {
                conn = DBConnect.getConnection();

                if (conn != null) {

                    PreparedStatement ps = conn.prepareStatement(UserQueries.UPDATE_USER);
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getMail());
                    ps.setString(3, user.getPassword());
                    ps.setString(4, user.getStreetName());
                    ps.setInt(5, user.getStreetNumber());
                    ps.setString(6, user.getPostalCode());
                    ps.setString(7, user.getPhone());
                    ps.setString(8, user.getCity());
                    ps.setString(9, user.getBirthDate());
                    ps.setInt(10, user.getId());
                    ps.executeUpdate();
                    result = 1;

                }

            } catch (SQLException ex) {

                result = -3;

            }
        }
        return result;
    }

    /**
     *
     * Remove user from the database given from the controller.
     *
     * @param user : User to remove.
     * @return  1 if the user is
     * removed, 0 otherwise.
     */
    public int removeUser(User user) {
        int result = 0;

        try {
            conn = DBConnect.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(UserQueries.DELETE_USER);
                ps.setInt(1, user.getId());
                ps.executeUpdate();
                result = 1;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = 0;
        }

        return result;
    }

    /**
     * Find user from the database with a given id.
     *
     * @param id: id of the user to find.
     * @return User object, null in case of error.
     */
    public User findUserById(int id) {
        User user = null;

        try {

            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_WHERE_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = getUser(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            user = null;

        }
        return user;
    }

    /**
     * Construct a user object with a given result set.
     *
     * @param rs : Result set with which to build the user object.
     * @return user object, null in case of error.
     */
    private User getUser(ResultSet rs) {
        User user;

        try {

            int id = rs.getInt("userid");
            String userName = rs.getString("username");
            String mail = rs.getString("mail");
            String password = rs.getString("password");
            String streetName = rs.getString("streetname");
            int streetNumber = rs.getInt("streetnumber");
            String postalCode = rs.getString("postal_code");
            String phone = rs.getString("phone");
            String city = rs.getString("city");
            String birthDate = rs.getString("birthdate");
            String role = rs.getString("role");
            String imageProfile = rs.getString("image_profile");
            user = new User(id, userName, mail, password, streetName, streetNumber, postalCode, phone, city, birthDate, role, imageProfile);

        } catch (SQLException ex) {

            user = null;

        }
        return user;
    }

    /**
     * Validates whether the user can be modified to the database.
     *
     * @param user: User to validate.
     * @return -2 if the username already exists in other user from the
     * database, -1 if the email already exists in other user from the database,
     * 0 if the phone already exists in other user from the database, 1 if you
     * can modified it.
     */
    private int validateForModifyUser(User user) {
        int result;

        User otherUser = validateDates("select * from users where userid != "
                + user.getId() + " and username = '" + user.getUserName() + "'");
        if (otherUser == null) {

            otherUser = validateDates("select * from users where userid != "
                    + user.getId() + " and mail = '" + user.getMail() + "'");
            if (otherUser == null) {
                otherUser = validateDates("select * from users where userid != "
                        + user.getId() + " and phone = '" + user.getPhone() + "'");
                if (otherUser == null) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else {
                result = -1;
            }
        } else {
            result = -2;
        }

        return result;
    }

    /**
     * Search a user in the database with a given query
     *
     * @param query : Query with which the query will be performed
     * @return user object, null in case of error.
     */
    private User validateDates(String query) {
        User user = null;
        try {
            conn = DBConnect.getConnection();
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(query);
            if (rs.next()) {
                user = getUser(rs);
            }
        } catch (SQLException ex) {
            user = null;
        }
        return user;
    }

    public boolean validateSession(User user) {
        boolean isValidated = false;

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_IS_LOGGED);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int isLoggin = rs.getInt("is_loged");
                if (isLoggin == 0) {
                    isValidated = loginUser(user);
                }
            }
        } catch (SQLException e) {
            isValidated = true;
        }

        return isValidated;
    }

    public void newLoginUser(User user) {
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.INSERT_NEW_LOGGIN);
            ps.setInt(1, user.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean logoutUser(User user) {
        boolean result = false;
        try {
            boolean validateIfLoged = validateLogout(user);
            if (validateIfLoged) {
                conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(UserQueries.UPDATE_LOGOUT);
                ps.setInt(1, user.getId());

                int igout = ps.executeUpdate();
                if (igout > 0) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    private boolean loginUser(User user) {
        boolean result = false;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.UPDATE_LOGIN);
            ps.setInt(1, user.getId());
            int isLoged = ps.executeUpdate();
            if (isLoged > 0) {
                result = true;
            }

        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    private boolean validateLogout(User user) {
        boolean result = false;

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_IS_LOGGED);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int is_loged = rs.getInt("is_loged");
                if (is_loged == 1) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            result = false;
        }
        return result;
    }

    public boolean deleteLogin(User user) {
        boolean result = false;

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserQueries.SELECT_IS_LOGGED);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean is_loged = removeLogin(user.getId());
                if (is_loged) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    private boolean removeLogin(int userId) {
        boolean isRemoved = false;
        String query = "DELETE FROM online_users WHERE userid = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            if(ps.executeUpdate() > 0){
                isRemoved = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            isRemoved = false;
        }

        return isRemoved;
    }

}
