/*
 * @author Sakshi Shrivastava (2451936)
 */
package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Customer;
import com.project.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	/*
	 * @author Sakshi Shrivastava (2451936)
	 */
	@Override
	public void createCustomer(Customer customer) {
		customerRepository.createCustomer(customer);
	}

	/*
	 * @author Sakshi Thoke (2452200)
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	/*
	 * @author Sakshi Shrivastava (2451936)
	 */
	@Override
	public List<Customer> deleteCustomer(int cno) {
		return customerRepository.deleteCustomer(cno);
	}

	/*
	 * @author Sakshi Thoke (2452200)
	 */
	@Override
	public List<Customer> updateProfile(Customer customer) {
		return customerRepository.updateProfile(customer);
	}

	/*
	 * @author Sakshi Shrivastava (2451936)
	 */
	@Override
	public Customer getCustomerById(int cid) {
		return customerRepository.getCustomerById(cid);

	}

	/*
	 * @author Sakshi Thoke (2452200)
	 */
	@Override
	public Customer getCustomerByEmail(String email, String password) {
		return customerRepository.getCustomerByEmail(email, password);

	}
}