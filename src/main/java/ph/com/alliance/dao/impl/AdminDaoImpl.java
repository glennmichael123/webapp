package ph.com.alliance.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.AdminDao;
import ph.com.alliance.dao.UserDao;
import ph.com.alliance.entity.User;
import ph.com.alliance.entity.Admin;

/**
 * Sample data access object implementation using Java Persistence API.
 * 
 *
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	/**
	 * TO DO:
	 * 1. Create Own Exception Class (ie. MyException class)
	 * 2. Let dao handle all hibernate/sql related exceptions and throw MyException to service layer 
	 * 		so that service layer will only handle MyException should there be errors
	 * 3. Every dao function should throw MyException
	 * 4. Should dao handle NullPointerExceptions?
	 */


	
	@Override
	public Admin selectAdmin(EntityManager pEM, String pUid, String password) {
		
		Admin admin = null;
		try {
			Query q = pEM.createNativeQuery("SELECT * FROM admin WHERE uid = '"+pUid+"' AND password = '"+password+"'", Admin.class);
			admin = (Admin) q.getSingleResult();						
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		}
			
		return admin;
		
	}


}