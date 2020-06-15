package org.cat.proven.wolprayproject.models.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.cat.proven.wolprayproject.models.pojo.Club;
import org.cat.proven.wolprayproject.models.pojo.Product;
import org.cat.proven.wolprayproject.models.pojo.Promotes;
import org.cat.proven.wolprayproject.models.pojo.Promotion;



/**
 * Manages access to database data.
 * 
 * @author Lewis
 */
public class ProductDao {

    private Connection conn;
    private final ClubDao clubDao;

    /**
     * Empty builder.
     */
    public ProductDao() {
        clubDao = new ClubDao();
    }

    public List<Product> findAllProductsInAClub(Club club) {
        List<Product> result = clubDao.findClubById(club.getId()).getProductList();
        return result;
    }

    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(ProductQueries.SELECT_PRODUCT_WHERE_NAME);
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = getProduct(rs);
                    result.add(product);
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
    }

    public List<Product> findProductByPriceInAClub(double price, Club club) {
        List<Product> result = new ArrayList<>();

        Club clubFinded = clubDao.findClubById(club.getId());
        for (Product product : clubFinded.getProductList()) {
            if (product.getPrice() <= price) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> findProductByPromotion(Promotion promotion){
        List<Product> result = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(ProductQueries.SELECT_PROMOTES_BY_PROMOTION);
            ps.setInt(1, promotion.getId());
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                Promotes promotes = getPromote(rs);
                if(promotes != null){
                    Product product = findProductById(promotes.getProductID());
                    if(product != null){
                        result.add(product);
                    }
                }
            }
            
        } catch (SQLException e) {
            result = null;
        }
        return null;
    }

    public Product findProductById(int id) {
        Product product = null;
        try {
            conn = DBConnect.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(ProductQueries.SELECT_PRODUCT_WHERE_ID);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    product = getProduct(rs);
                }
            }
        } catch (SQLException ex) {
            product = null;
        }
        return product;
    }

    public List<Product> findProductInStockInAClub(Club club) {
        // TODO implement here
        return null;
    }

    public List<Product> findProductWherePriceIsLessThan(int price) {
        // TODO implement here
        return null;
    }

    public List<Product> findProductByCategory(String category) {
        // TODO implement here
        return null;
    }

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

    private Product getProduct(ResultSet rs) {
        Product product;
        try {
            int id = rs.getInt("productid");
            String name = rs.getString("productname");
            String dscription = rs.getString("description");
            double price = rs.getDouble("price");
            String category = rs.getString("category");
            String imageUrl = rs.getString("image_url");
            boolean isInStock;
            int status = rs.getInt("status");
            if (status == 0) {
                isInStock = false;
            } else {
                isInStock = true;
            }

            product = new Product(id, name, category, dscription, price, imageUrl, isInStock);

        } catch (SQLException e) {
            product = null;
        }

        return product;
    }

    private Promotes getPromote(ResultSet rs) {
        Promotes promotes;
        try {
            int productId = rs.getInt("productid");
            int promotionId = rs.getInt("promotionid");
            double discount = rs.getDouble("discount");
            java.sql.Date startDate = rs.getDate("start_date");
            java.sql.Date endDate = rs.getDate("end_date");
            promotes = new Promotes(productId, promotionId, discount, startDate, endDate);
        } catch (SQLException e) {
            promotes = null;
        }

        return promotes;
    }

}
