package controller;

import model.Customer;
import service.CustomerService;
import java.util.Scanner;

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    public void registerCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Customer customer = new Customer();
        customer.setCustomerName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customerService.registerCustomer(customer);
        System.out.println("Customer registered successfully.");
    }

    public void viewCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void updateCustomerDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setCustomerName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customerService.updateCustomer(customer);
        System.out.println("Customer details updated.");
    }

    public void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        customerService.deleteCustomer(customerId);
        System.out.println("Customer deleted successfully.");
    }
}
