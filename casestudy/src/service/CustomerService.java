package service;

import dao.CustomerDAO;
import model.Customer;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    public void registerCustomer(Customer customer) {
        customerDAO.registerCustomer(customer);
    }

    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomerById(customerId);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
