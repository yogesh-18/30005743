package service;

import dao.ParcelDAO;
import model.Parcel;

import java.sql.SQLException;
import java.util.List;

public class ParcelService {
    private ParcelDAO parcelDAO = new ParcelDAO();

    public void addParcel(Parcel parcel) throws SQLException {
        if (parcelDAO.getParcelByTrackingNumber(parcel.getTrackingNumber()) == null) {
            parcelDAO.addParcel(parcel);
            System.out.println("Parcel added successfully.");
        } else {
            System.out.println("Parcel with tracking number " + parcel.getTrackingNumber() + " already exists.");
        }
    }

    public Parcel trackParcel(String trackingNumber) {
        return parcelDAO.getParcelByTrackingNumber(trackingNumber);
    }

    public void updateParcelStatus(int parcelId, String status) {
        parcelDAO.updateParcelStatus(parcelId, status);
    }

    public List<Parcel> getDeliveryHistory(int parcelId) {
        return parcelDAO.getDeliveryHistory(parcelId);
    }
}
