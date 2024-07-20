package dao;

import model.Parcel;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelDAO {

    public void addParcel(Parcel parcel) throws SQLException {

        try (Connection conn = DBUtil.getConnection()) {
            String query = "INSERT INTO Parcel (tracking_number, sender_name, sender_address, recipient_name, recipient_address, current_status, delivery_history) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, parcel.getTrackingNumber());
            stmt.setString(2, parcel.getSenderName());
            stmt.setString(3, parcel.getSenderAddress());
            stmt.setString(4, parcel.getRecipientName());
            stmt.setString(5, parcel.getRecipientAddress());
            stmt.setString(6, parcel.getCurrentStatus());
            stmt.setString(7, parcel.getDeliveryHistory());
            stmt.executeUpdate();
        }
    }

    public Parcel getParcelByTrackingNumber(String trackingNumber) {
        Parcel parcel = null;
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM parcel WHERE tracking_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, trackingNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                parcel = new Parcel();
                parcel.setParcelId(rs.getInt("parcel_id"));
                parcel.setTrackingNumber(rs.getString("tracking_number"));
                parcel.setSenderName(rs.getString("sender_name"));
                parcel.setSenderAddress(rs.getString("sender_address"));
                parcel.setRecipientName(rs.getString("recipient_name"));
                parcel.setRecipientAddress(rs.getString("recipient_address"));
                parcel.setCurrentStatus(rs.getString("current_status"));
                parcel.setDeliveryHistory(rs.getString("delivery_history"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parcel;
    }

    public void updateParcelStatus(int parcelId, String status) {
        try (Connection conn = DBUtil.getConnection()) {
            String query = "UPDATE parcel SET current_status = ? WHERE parcel_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setInt(2, parcelId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Parcel> getDeliveryHistory(int parcelId) {
        List<Parcel> history = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM parcel WHERE parcel_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, parcelId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Parcel parcel = new Parcel();
                parcel.setParcelId(rs.getInt("parcel_id"));
                parcel.setTrackingNumber(rs.getString("tracking_number"));
                parcel.setSenderName(rs.getString("sender_name"));
                parcel.setSenderAddress(rs.getString("sender_address"));
                parcel.setRecipientName(rs.getString("recipient_name"));
                parcel.setRecipientAddress(rs.getString("recipient_address"));
                parcel.setCurrentStatus(rs.getString("current_status"));
                parcel.setDeliveryHistory(rs.getString("delivery_history"));
                history.add(parcel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}
