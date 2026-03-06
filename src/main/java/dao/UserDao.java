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


    public boolean checkAccount(String username) {
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

    // Lấy thông tin user theo userID
    public User selectUserByUserID(int userID) {
        String sql = "SELECT * FROM USERS WHERE userID = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userID);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                User user = new User();
                user.setIdUser(result.getInt("userID"));
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setVerify((result.getInt("verify") == 1));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));


                Date getBirthdate = result.getDate("birthday");
                user.setBirthday(getBirthdate == null ? null : getBirthdate.toLocalDate());

                user.setGender(result.getInt("gender"));
                user.setRole(result.getInt("role"));
                user.setStatus(result.getInt("status"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Lấy thông tin user theo username
    public User getFullName(String username) {
        String sql = "SELECT * FROM USERS WHERE username = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                User user = new User();
                user.setIdUser(result.getInt("userID"));
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setVerify((result.getInt("verify") == 1));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setRole(result.getInt("role"));
                user.setStatus(result.getInt("status"));


                Date getBirthdate = result.getDate("birthday");
                user.setBirthday(getBirthdate == null ? null : getBirthdate.toLocalDate());

                user.setGender(result.getInt("gender"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // hàm đổi mật khẩu
    public boolean updatePasswordByEmail(String email, String passwordHash) {
        String sql = "UPDATE users SET password=? WHERE email=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, passwordHash);
            ps.setString(2, email);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public boolean updatePasswordByUserID(int id, String passwordHash) {
        String sql = "UPDATE users SET password=? WHERE userID=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, passwordHash);
            ps.setInt(2, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }
}

