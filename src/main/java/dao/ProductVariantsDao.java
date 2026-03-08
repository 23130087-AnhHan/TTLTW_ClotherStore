package dao;

import model.ProductVariants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductVariantsDao extends BaseDao{

    // lấy các biến thể từ một id sản phẩm
    // áo số có id 1: size M status available
    // áo số có id 2: size L status not available
    public List<ProductVariants> SelectByProductIDInProductVariants(int id) {
        // TODO Auto-generated method stub
        ProductVariants productVariants = null;
        List<ProductVariants> list = new ArrayList<>();
        String sql = "Select * from products_variants WHERE productID = ?";

        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productVariants = new ProductVariants();
                productVariants.setVariantID(rs.getInt("variantID"));
                productVariants.setProductID(rs.getInt("productID"));
                productVariants.setSize(rs.getString("size"));
                productVariants.setSku(rs.getString("sku"));
                productVariants.setPriceAdjustment(rs.getBigDecimal("priceAdjustment"));
                productVariants.setStock(rs.getInt("stock"));
                productVariants.setStatus(rs.getString("status"));
                list.add(productVariants);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
