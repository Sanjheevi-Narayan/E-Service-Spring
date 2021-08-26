package com.project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.repository.CustomerRepository;

public class CustomerRepositoryTest {
	/** The customer Repository. */
	static CustomerRepository customerRepository;

	CustomerRepository customer;

	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.out.println("@Before Class Called");
	}

	@Before
	public void setUp() throws java.lang.Exception {
		System.out.println("@Before Called");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		customerRepository = (CustomerRepository) context.getBean("customerRepository");
	}

	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception {
		System.out.println("@AfterClass Called");
	}

	@After
	public void tearDown() throws java.lang.Exception {
		customer = null;
		System.out.println("@After Called");
	}

	/**
	 * Test get customer.
	 */
	@Test
	public void testAllCustomers() {

		assertTrue((customerRepository.getAllCustomers()).size() >= 1);
	}
}
