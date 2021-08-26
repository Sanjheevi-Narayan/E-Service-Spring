package com.project.restcontroller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.project.restcontroller.CustomerController;
import com.project.service.CustomerService;
import com.project.model.Customer;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

//Unit Testing on a functionality from Rest Controller

public class CustomerControllerTest {
	CustomerController customerController;
	CustomerService customerService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.out.println("Initiating Unit Testing ...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception {
		System.out.println("Terminating Unit Testing.");
	}

	@Before
	public void setUp() throws java.lang.Exception {
		System.out.println("@Before calling Test method");
		customerController = new CustomerController();
	}

	@After
	public void tearDown() throws java.lang.Exception {
		customerController = null;
		System.out.println("@After calling Test method");
	}

	 @Test
	 public void testProductId()
		{
			
			System.out.println("Testing if the returned product and the requested product are the same! ");
			Scanner sc=new Scanner(System.in);
			System.out.println("What is the ID of the product you want to Delete?");
			int cid =sc.nextInt();
			try {
			List<Customer> customerDeleted=customerService.deleteCustomer(cid);
			try{
				assertEquals("redirect:/allCustomers",customerDeleted);
				Customer cust = customerService.getCustomerById(cid);
				if( cust==null)
					System.out.println("Customer was deleted successfully!");
				}
			catch(Exception exc){
				System.out.println("Oops!The product could not be deleted!");
			}
			}
			catch(Exception e)
			{
				System.out.println("Oops!The Customer does not exist!");
			}

			finally {
				System.out.println("Customer deletion verified Successfully!");
			}
	     }
}
