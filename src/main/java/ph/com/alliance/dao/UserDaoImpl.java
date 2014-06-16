package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.UserDao;
import ph.com.alliance.entity.User;

/**
 * 
 * @author Ed Austin
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	/**
	 * TO DO:
	 * 1. Create Own Exception Class (ie. MyException class)
	 * 2. Let dao handle all hibernate/sql related exceptions and throw MyException to service layer 
	 * 		so that service layer will only handle MyException should there be errors
	 * 3. Every dao function should throw MyException
	 * 4. Should dao handle NullPointerExceptions?
	 */

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.dao.UserDao#createUser(javax.persistence.EntityManager, ph.com.alliance.entity.User)
	 */
	@Override
	public boolean createUser(EntityManager pEM, User pUser) {	
		boolean success = true;
				
		try {
			
			pEM.persist(pUser);
			
		} catch (EntityExistsException ee) {
			// instantiate MyException class here and set custom error codes common to all
			// ie. throw new MyException(<ERROR CODE HERE>, <ERROR MESSAGE HERE>)
			ee.getMessage();
			success = false;
		} catch (IllegalArgumentException iae) {
			// instantiate MyException class here and set custom error codes common to all
			// ie. throw new MyException(<ERROR CODE HERE>, <ERROR MESSAGE HERE>)
			iae.getMessage();
			success = false;
		} catch (TransactionRequiredException trxe) {
			// instantiate MyException class here and set custom error codes common to all
			// ie. throw new MyException(<ERROR CODE HERE>, <ERROR MESSAGE HERE>)
			trxe.getMessage();
			success = false;
		}
		
		return success;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.dao.UserDao#updateUser(javax.persistence.EntityManager, ph.com.alliance.entity.User)
	 */
	@Override
	public User updateUser(EntityManager pEM, User pUser) {
		User user = null;
		
		try {
			user = pEM.merge(pUser);
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		} catch (TransactionRequiredException trxe) {
			trxe.getMessage();
		}
		
		return user;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.dao.UserDao#deleteUser(javax.persistence.EntityManager, ph.com.alliance.entity.User)
	 */
	@Override
	public int deleteUser(EntityManager pEM, User pUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.dao.UserDao#selectUser(javax.persistence.EntityManager, java.lang.String)
	 */
	@Override
	public User selectUser(EntityManager pEM, String pUid) {
		User user = null;
		
		try {
			
			user = pEM.find(User.class, pUid);
			
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		}
		
		return user;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.dao.UserDao#selectUsers(javax.persistence.EntityManager, java.lang.String)
	 */
	@Override
	public List<User> selectUsers(EntityManager pEM, String pKey) {
		// TODO Auto-generated method stub
		return null;
	}

}
