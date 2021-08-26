/*
 * @author Sakshi Thoke (2452200)
 */
package com.project.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Customer;
import com.project.model.Orders;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * @author Sakshi Thoke (2452200) This method is used to add orders to the
	 * database.
	 */
	@Override
	public void createOrder(Orders order) {
		getSession().saveOrUpdate(order);
		System.out.println("Order added successfully in the database.");

	}

	/*
	 * @author Sakshi Shrivastava (2451936) This method is used to delete orders
	 * from the database.
	 */
	public List<Orders> deleteOrder(int oid) {
		Query query = getSession().createQuery("delete from Orders where orderId=:oid");
		query.setParameter("oid", oid);
		int noOfRows = query.executeUpdate();
		if (noOfRows > 0) {
			System.out.println("Deleted " + noOfRows + " rows");
		}

		return getAllOrders();
	}

	/*
	 * @author Sakshi Thoke (2452200) This method is used to view the list of
	 * orders.
	 */
	@Override
	public List<Orders> getAllOrders() {
		Query query = getSession().createQuery("from Orders order ");
		List<Orders> olist = query.list();
		System.out.println(olist);
		return olist;
	}
}
