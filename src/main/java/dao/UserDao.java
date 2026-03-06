package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import model.User;

public class UserDao extends BaseDao {

    // Thêm user mới vào database
    public boolean addUser(User user) {
        String sql = "INSERT INTO USERS(firstname, lastname, email, verify, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getVerify() ? 1 : 0);
            ps.setString(5, user.getUsername());
            ps.setString(6, user.getPassword());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Kiểm tra username có tồn tại không (dùng cho đăng ký)
    public boolean SelectUsernameIsContains(String username) {
        String sql = "SELECT * FROM USERS WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            return result.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

