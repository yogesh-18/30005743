package controller;

import java.util.Scanner;

public class MainController {
    private ParcelController parcelController = new ParcelController();
    private CustomerController customerController = new CustomerController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Parcel");
            System.out.println("2. Track Parcel");
            System.out.println("3. Update Parcel Status");
            System.out.println("4. View Delivery History");
            System.out.println("5. Register Customer");
            System.out.println("6. View Customer Details");
            System.out.println("7. Update Customer Details");
            System.out.println("8. Delete Customer");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    parcelController.addParcel();
                    break;
                case 2:
                    parcelController.trackParcel();
                    break;
                case 3:
                    parcelController.updateParcelStatus();
                    break;
                case 4:
                    parcelController.viewDeliveryHistory();
                    break;
                case 5:
                    customerController.registerCustomer();
                    break;
                case 6:
                    customerController.viewCustomerDetails();
                    break;
                case 7:
                    customerController.updateCustomerDetails();
                    break;
                case 8:
                    customerController.deleteCustomer();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
