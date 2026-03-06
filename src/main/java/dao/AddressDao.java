package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Address;

public class AddressDao extends BaseDao {

    //Lấy danh sach địa chỉ của user theo userID
    public List<Address> selectAddressByUserID(int id) {
        List<Address> list = new ArrayList<Address>();
        String sql = "SELECT a.addressID, a.fulladdress, a.city_code, s.city_name, "
                   + "a.ward, a.phone, a.userID, a.isDefault, a.country "
                   + "FROM address a "
                   + "JOIN shipping s ON s.city_code = a.city_code "
                   + "WHERE userID = ? "
                   + "ORDER BY isDefault DESC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Address add = new Address();
                add.setAddressID(result.getInt("addressID"));
                add.setFullAddress(result.getString("fulladdress"));
                add.setCity_code(result.getString("city_code")); // lưu code thực sự (VD: "HCM")
                add.setCityName(result.getString("city_name"));  // lưu tên hiển thị (VD: "Hồ Chí Minh")
                add.setWard(result.getString("ward"));
                add.setPhone(result.getString("phone"));
                add.setUserID(result.getInt("userID"));
                add.setIsDefault(result.getBoolean("isDefault"));
                add.setCountry(result.getString("country"));
                list.add(add);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //Thêm địa chỉ mới cho user theo userID, trả về addressID vừa tạo
    public int addAddressByUserID(Address address) {
        String sql = "INSERT INTO address(fulladdress, city_code, ward, phone, userID, isDefault, country) "
                   + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, address.getFullAddress());
            ps.setString(2, address.getCity_code()); // FIX: lấy city_code, không lấy city_name
            ps.setString(3, address.getWard());
            ps.setString(4, address.getPhone());
            ps.setInt(5, address.getUserID());
            ps.setBoolean(6, address.getIsDefault());
            ps.setString(7, address.getCountry());
            ps.executeUpdate();

            // Lấy ID vừa tạo
            ResultSet result = ps.getGeneratedKeys();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Xóa địa chỉ theo addressID
    public boolean deleteAddressByID(int id) {
        String sql = "DELETE FROM address WHERE addressID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Reset tất cả địa chỉ của user về isDefault = false
    public boolean updateAllIsDefaultAddress(int userID) {
        String sql = "UPDATE address SET isDefault = 0 WHERE userID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userID);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Cập nhật địa chỉ hiện tại thành isDefault = true theo addressID, đồng thời reset các địa chỉ khác về false
    public boolean updateCurrentAddressByID(int id, int userID) {
        updateAllIsDefaultAddress(userID); // reset hết về 0 trước
        String sql = "UPDATE address SET isDefault = 1 WHERE addressID = ? AND userID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setInt(2, userID);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Kiểm tra xem user đã có địa chỉ nào chưa, nếu chưa có trả về 0,
    // nếu đã có trả về số lượng địa chỉ (dùng để xác định có phải là địa chỉ đầu tiên hay không)
    public int isFirstAddress(int userID) {
        String sql = "SELECT COUNT(*) FROM address WHERE userID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Lấy thông tin địa chỉ theo addressID, bao gồm cả city_name từ bảng shipping
    // Trả về một đối tượng Address đầy đủ thông tin, nếu không tìm thấy trả về null hoặc một Address rỗng
    public Address selectAddressByAddressID(int addressId) {
        Address add = new Address();
        String sql = "SELECT a.addressID, a.fulladdress, a.city_code, s.city_name, "
                   + "a.ward, a.phone, a.userID, a.isDefault, a.country "
                   + "FROM address a "
                   + "JOIN shipping s ON s.city_code = a.city_code "
                   + "WHERE addressID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, addressId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                add.setAddressID(rs.getInt("addressID"));
                add.setFullAddress(rs.getString("fulladdress"));
                add.setCity_code(rs.getString("city_code")); // lưu code thực sự
                add.setCityName(rs.getString("city_name"));  // lưu tên hiển thị
                add.setWard(rs.getString("ward"));
                add.setCountry(rs.getString("country"));
                add.setPhone(rs.getString("phone"));
                add.setUserID(rs.getInt("userID"));
                add.setIsDefault(rs.getBoolean("isDefault"));
            }
            return add;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

