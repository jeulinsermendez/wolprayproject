package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Product;
import org.cat.proven.wolprayproject.models.pojo.Promotes;
import org.cat.proven.wolprayproject.models.pojo.Promotion;


/**
 * Manages access to database data.
 * 
 * @author Lewis
 */
public class PromotionDao {

    private Connection conn;

    
    /**
     * Empty builder.
     */
    public PromotionDao() {
    }

    /**
     * Find Promotion from the database with a  given id from the controller.
     * 
     * @param id:Id of the Promotion to find.
     * @return  Promotion object, null in case of error.
     */
    public Promotion findPromotionById(int id) {
        Promotion promotion = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_WHERE_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                promotion = getPromotion(rs);
            }

        } catch (SQLException e) {
            promotion = null;
        }
        return promotion;
    }

    /**
     * Find Promotion from the database with a  given id from the controller.
     * 
     * @param name: Name of the Promotion to find.
     * @return  Promotion object, null in case of error.
     */
    public Promotion findPromotionByname(String name) {
        Promotion promotion = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_WHERE_ID);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                promotion = getPromotion(rs);
            }
        } catch (SQLException e) {
            promotion = null;
        }
        return promotion;
    }

    
    /**
     * Find a Promotion list from the database with a given date from the controller.
     * 
     * @param date: Date of Promotion.
     * @return list of Promotion from the database with a same attribute, null in case of error.
     */
    public List<Promotion> findPromotionsByDate(String date) {
        List<Promotion> result = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_PROMOTES_BY_DATE_START);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promotes promote = getPromote(rs);
                if (promote != null) {
                    Promotion promotion = findPromotionById(promote.getPromotionId());
                    if (promotion != null) {
                        result.add(promotion);
                    }
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    
    /**
     * Find Promotion from the database with a  given product from the controller.
     * 
     * @param product: product of the Promotion to find.
     * @return  Promotion object, null in case of error.
     */
    public Promotion findPromotionsByProduct(Product product) {
        
        Promotion result = null;
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_PROMOTES_BY_PRODUCT);
            ps.setInt(1, product.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Promotes promote = getPromote(rs);
                if (promote != null) {
                    result = findPromotionById(promote.getPromotionId());
                }
            }
        } catch (SQLException e) {
            result = null;
        }

        return result;
    }

    /**
     * Find a Promotion list from the database with a given date from the controller.
     * 
     * @param club: Club of Promotion.
     * @return list of Promotion from the database with a same attribute, null in case of error.
     */
    public List<Promotion> findPromotionsByClub(Club club) {
        List<Promotion> result = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_PROMOTION_BY_CLUB);
            ps.setInt(1, club.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promotion promotion = getPromotion(rs);
                if (promotion != null) {
                    result.add(promotion);
                }
            }

        } catch (SQLException e) {
        }

        return result;
    }

    
    /**
     * Find all Promotion from the database.
     * 
     * @return list of Promotion from the database with a same attribute, null in case of error.
     */
    public List<Promotion> findAllPromotions() {
        List<Promotion> result = new ArrayList<>();

        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(PromotionQueries.SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promotion promotion = getPromotion(rs);
                if (promotion != null) {
                    result.add(promotion);
                }
            }
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    
    
    /**
     * Construct a Promotion object with a given result set.
     * 
     * @param rs : Result set with which to build the Promotion object.
     * @return Promotes object, null in case of error.
     */
    private Promotion getPromotion(ResultSet rs) {
        Promotion result;
        try {
            int id = rs.getInt("promotionid");
            int clubId = rs.getInt("clubid");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String coverUrl = rs.getString("cover_url");
            result = new Promotion(id, clubId, name, description, coverUrl);
        } catch (SQLException e) {
            result = null;
        }
        return result;
    }

    /**
     *  Construct a Promotes object with a given result set.
     * 
     *  @param rs : Result set with which to build the Promotes object.
     *  @return Promotes object, null in case of error.
     */
    private Promotes getPromote(ResultSet rs) {
        Promotes promotes;
        try {
            int productId = rs.getInt("productid");
            int promotionId = rs.getInt("promotionid");
            double discount = rs.getDouble("discount");
            Date startDate = rs.getDate("start_date");
            Date endDate = rs.getDate("end_date");
            promotes = new Promotes(productId, promotionId, discount, startDate, endDate);
        } catch (SQLException e) {
            promotes = null;
        }

        return promotes;
    }
}
