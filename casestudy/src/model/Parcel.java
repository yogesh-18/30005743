package model;

public class Parcel {
    private int parcelId;
    private String recipientAddress;
    private String currentStatus;
    private String deliveryHistory;
    private String trackingNumber;
    private String senderName;
    private String senderAddress;
    private String recipientName;

    public Parcel(String trackingNumber, String senderName, String senderAddress, String recipientName, String recipientAddress, String currentStatus, String deliveryHistory) {
        this.parcelId = parcelId;
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.currentStatus = currentStatus;
        this.deliveryHistory = deliveryHistory;
    }

    public Parcel() {

    }

    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDeliveryHistory() {
        return deliveryHistory;
    }

    public void setDeliveryHistory(String deliveryHistory) {
        this.deliveryHistory = deliveryHistory;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "parcelId=" + parcelId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", deliveryHistory='" + deliveryHistory + '\'' +
                '}';
    }

}
