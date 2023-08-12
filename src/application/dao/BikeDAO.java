package application.dao;

import application.entity.Bike;
import application.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BikeDAO {

    public Bike getBikeById(int id) {
        Bike bike = null;
        String query = "SELECT * FROM bikes WHERE bike_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	int bikeTypeOrdinal = rs.getInt("bikeType");
            	bike = new Bike(bikeTypeOrdinal);
                bike.setRentingTime(rs.getFloat("rentingTime"));
                bike.setBatteryPercentage(rs.getFloat("batteryPercentage"));
                bike.setTimeRemain(rs.getInt("timeRemain"));
                bike.setBikeCode(rs.getString("bikeCode"));
                bike.setBrand(rs.getString("brand"));
                bike.setRentedTime(rs.getTimestamp("rentedTime").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bike;
    }
    
    public boolean bikeCodeExists(String code) {
        String query = "SELECT 1 FROM bikes WHERE bikeCode = ?"; 
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateBike(Bike bike) {
    	System.out.print(bike.getBikeCode());
        String query = "UPDATE bikes SET rentingTime = ?, batteryPercentage = ?, timeRemain = ?, bikeCode = ?, rentedTime = ? WHERE bike_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setFloat(1, bike.getRentingTime());
            pstmt.setFloat(2, bike.getBatteryPercentage());
            pstmt.setFloat(3, bike.getTimeRemain());
            pstmt.setString(4, bike.getBikeCode());
            if (bike.getRentedTime() != null) {
                pstmt.setTimestamp(5, Timestamp.valueOf(bike.getRentedTime()));
            } else {
                pstmt.setNull(5, java.sql.Types.TIMESTAMP);
            }
            pstmt.setInt(6, bike.getBikeId());
            System.out.println(bike.getBikeId());
            System.out.println(pstmt.toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(bike.getBikeCode());
    }

}
