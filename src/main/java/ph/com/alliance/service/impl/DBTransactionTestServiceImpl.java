package ph.com.alliance.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import ph.com.alliance.dao.AdminDao;
import ph.com.alliance.dao.IssueDao;
import ph.com.alliance.dao.ProductDao;
import ph.com.alliance.dao.UserDao;
import ph.com.alliance.dao.impl.UserDaoImpl;
import ph.com.alliance.entity.Admin;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.Product;
import ph.com.alliance.entity.User;
import ph.com.alliance.service.DBTransactionTestService;


/**
 * Example service implementation that handles database transaction.
 * Database transaction starts in this layer of the application, and it also ends here. 
 *
 */
@Service("dBTransactionService")
public class DBTransactionTestServiceImpl implements DBTransactionTestService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private IssueDao issuesDao;

	@Autowired
	private JpaTransactionManager transactionManager;
	
	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#createUser(ph.com.alliance.entity.User)
	 */
	@Override
	public boolean createUser(User pUser) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		boolean result = false;
		
		em.getTransaction().begin();
		try {
			result = userDao.createUser(em, pUser);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return result;
	}
	
	public boolean createIssue(Issue pIssues){
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		boolean result = false;
		
		em.getTransaction().begin();
		try {
			result = issuesDao.createIssues(em, pIssues);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#updateUser(ph.com.alliance.entity.User)
	 */
	@Override
	public User updateUser(User pUser) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		User result = null;
		
		em.getTransaction().begin();
		
		try {
			result = userDao.updateUser(em, pUser);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#deleteUser(ph.com.alliance.entity.User)
	 */
	@Override
	public void deleteUser(User pUser) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#selectUser(ph.com.alliance.entity.User)
	 */
	@Override
	public User selectUser(User pUser) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		return userDao.selectUser(em, pUser.getUid(), pUser.getPassword());
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#selectUsers(java.lang.String)
	 */
	@Override
	public List<User> selectUsers(String pKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#selectProducts(java.lang.String)
	 */
	@Override
	public List<Product> selectProducts(String pKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createProduct(Product pProd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product updateProduct(Product pProd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product pProd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product selectProduct(Product pProd) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		return productDao.selectProduct(em, pProd.getSerialNo());
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#createUserAndProduct(ph.com.alliance.entity.User, ph.com.alliance.entity.Product, boolean)
	 */
	@Override
	public boolean createUserAndProduct(User pUser, Product pProd,
			boolean pRollbackFlag) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		boolean result = false;
		
		em.getTransaction().begin();
		try {
			userDao.createUser(em, pUser);
			productDao.createProduct(em, pProd);
			
			if (pRollbackFlag) {
				throw new Exception("FORCED TO THROW EXCEPTION TO ROLLBACK THIS TRANSACTION!");
			} else {
				em.getTransaction().commit();
			}
			
		} catch (Exception e) {
			e.getMessage();
			
			if (em.getTransaction().isActive()) {
				System.out.println("ROLLBACK FOR createUserAndProduct function.");
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#createUserAndUpdateProduct(ph.com.alliance.entity.User, ph.com.alliance.entity.Product, boolean)
	 */
	@Override
	public boolean createUserAndUpdateProduct(User pUser, Product pProd,
			boolean pRollbackFlag) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		boolean result = false;
		
		em.getTransaction().begin();
		try {
			userDao.createUser(em, pUser);
			productDao.updateProduct(em, pProd);
			
			if (pRollbackFlag) {
				throw new Exception("FORCED TO THROW EXCEPTION TO ROLLBACK THIS TRANSACTION!");
			} else {
				em.getTransaction().commit();
			}
			
		} catch (Exception e) {
			e.getMessage();
			
			if (em.getTransaction().isActive()) {
				System.out.println("ROLLBACK FOR createUserAndUpdateProduct function.");
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#selectAllUsers()
	 */
	@Override
	public List<User> selectAllUsers() {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		List<User> userList = null;
		
		try {
			userList = userDao.selectAllUsers(em);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return userList;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ph.com.alliance.service.DBTransactionTestService#selectAllUsers()
	 */
	@Override
	public User selectUser(String username, String password) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		User user = null;
		
		try {
			user = userDao.selectUser(em, username, password);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return user;
	}

	@Override
	public Admin selectAdmin(String username, String password) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		Admin admin = null;
		try {
			admin = adminDao.selectAdmin(em, username, password);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return admin;
	}

	@Override
	public List<Issue> getIssueList() {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		List<Issue> issueList = null;
		
		try {
			issueList = issuesDao.getIssueList(em);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issueList;
	}

	@Override
	public List<Issue> getIssueListDev() {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		List<Issue> issueList = null;
		try {
			issueList = issuesDao.getIssueListDev(em);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issueList;
	}
	
	@Override
	public List<Issue> getIssueListProgress() {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		List<Issue> issueList = null;
		try {
			issueList = issuesDao.getIssueListProgress(em);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issueList;
	}

	@Override
	public Issue updateIssue(Issue pIssues) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		Issue issue = null;
		
		em.getTransaction().begin();
		
		try {
			issue = issuesDao.updateIssue(em, pIssues);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.getMessage();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issue;
	}

	@Override
	public List<Issue> getIssuesDone() {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		List<Issue> issueList = null;
		try {
			issueList = issuesDao.getIssueListDone(em);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issueList;
	}

	@Override
	public Issue viewIssueDetails(Long id) {
		EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();
		Issue issue = null;
		
		try {
			issue = issuesDao.viewIssueDetails(em, id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
		return issue;
	}
}
