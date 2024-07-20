package controller;

import model.Parcel;
import service.ParcelService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ParcelController {
    private ParcelService parcelService = new ParcelService();

    public void addParcel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter tracking number: ");
        String trackingNumber = scanner.nextLine();
        System.out.print("Enter sender name: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter sender address: ");
        String senderAddress = scanner.nextLine();
        System.out.print("Enter recipient name: ");
        String recipientName = scanner.nextLine();
        System.out.print("Enter recipient address: ");
        String recipientAddress = scanner.nextLine();
        System.out.print("Enter current status: ");
        String currentStatus = scanner.nextLine();
        System.out.print("Enter delivery history: ");
        String deliveryHistory = scanner.nextLine();

        Parcel parcel = new Parcel(trackingNumber, senderName, senderAddress, recipientName, recipientAddress, currentStatus, deliveryHistory);
        try {
            parcelService.addParcel(parcel);
        } catch (SQLException e) {
            System.out.println("Error adding parcel: " + e.getMessage());
        }
    }

    public void trackParcel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter tracking number: ");
        String trackingNumber = scanner.nextLine();
        Parcel parcel = parcelService.trackParcel(trackingNumber);
        if (parcel != null) {
            System.out.println("Parcel Details:");
            System.out.println("Tracking Number: " + parcel.getTrackingNumber());
            System.out.println("Sender Name: " + parcel.getSenderName());
            System.out.println("Sender Address: " + parcel.getSenderAddress());
            System.out.println("Recipient Name: " + parcel.getRecipientName());
            System.out.println("Recipient Address: " + parcel.getRecipientAddress());
            System.out.println("Current Status: " + parcel.getCurrentStatus());
            System.out.println("Delivery History: " + parcel.getDeliveryHistory());
        } else {
            System.out.println("Parcel not found.");
        }
    }

    public void updateParcelStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parcel ID: ");
        int parcelId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();
        parcelService.updateParcelStatus(parcelId, status);
        System.out.println("Parcel status updated.");
    }

    public void viewDeliveryHistory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parcel ID: ");
        int parcelId = scanner.nextInt();
        List<Parcel> history = parcelService.getDeliveryHistory(parcelId);
        if (!history.isEmpty()) {
            System.out.println("Delivery History:");
            for (Parcel parcel : history) {
                System.out.println("Tracking Number: " + parcel.getTrackingNumber());
                System.out.println("Status: " + parcel.getCurrentStatus());
                System.out.println("History: " + parcel.getDeliveryHistory());
                System.out.println("-----------");
            }
        } else {
            System.out.println("No delivery history found.");
        }
    }
}
