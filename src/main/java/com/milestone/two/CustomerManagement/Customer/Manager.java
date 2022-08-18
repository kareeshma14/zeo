package com.milestone.two.CustomerManagement.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Manager {
	private List<Customer> customers;

	public Manager() {
		super();
		this.customers = new ArrayList<>();
		addCustomers();
	}

	private void addCustomers() {
		customers.add(new Customer(80, "Sebastian", 36, 3000));
		customers.add(new Customer(45, "Fernando", 41, 4000));
		customers.add(new Customer(44, "Lewis", 37, 8000));
		customers.add(new Customer(77, "Bottas", 38, 3500));
		customers.add(new Customer(33, "Max", 27, 7000));
		customers.add(new Customer(89, "Lawrence", 39, 2000));
		customers.add(new Customer(66, "George", 28, 5000));
		customers.add(new Customer(3, "Daniel", 39, 6000));
		customers.add(new Customer(4, "Lando", 28, 4500));
		customers.add(new Customer(16, "Mick", 36, 4000));
		customers.add(new Customer(7, "Kimi", 43, 7000));
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Customer> getCustomersByName() {
		List<Customer> newList = new ArrayList<>(customers);
		Collections.sort(newList);
		return newList;
	}

	public void updatePurchaseAmount(int id, Scanner in) throws CustomerNotFoundException {
		boolean isCustomerFound = false;
		Customer foundedCustomer = null;
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				isCustomerFound = true;
				foundedCustomer = customer;
			}
		}
		if (!isCustomerFound) {
			throw new CustomerNotFoundException("Customer with id " + id + " is not present in the list.");
		}
		System.out.println("Enter new purchase amount: ");
		int amount = in.nextInt();
		foundedCustomer.setPurchaseAmount(amount);
		System.out.println("Updated Customer " + foundedCustomer);
	}
}