package ph.com.alliance.service;

import java.util.List;

import ph.com.alliance.entity.Admin;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.Product;
import ph.com.alliance.entity.Subtask;
import ph.com.alliance.entity.User;

/**
 * 
 * 
 */
public interface DBTransactionTestService {
	/**
	 * 
	 * @return
	 */
	public boolean createIssue(Issue pIssues);
	
	public Issue updateIssue(Issue pIssues);
	
	public boolean createUser(User pUser);
	
	/**
	 * 
	 */
	public User updateUser(User pUser);
	
	/**
	 * 
	 */
	public void deleteUser(User pUser);
	
	/**
	 * 
	 * @return
	 */
	public User selectUser(User pUser);
	
	/**
	 * 
	 * @return
	 */
	public List<User> selectUsers(String pKey);
	
	/**
	 * 
	 * @return
	 */
	public boolean createProduct(Product pProd);
	
	/**
	 * 
	 */
	public Product updateProduct(Product pProd);
	
	/**
	 * 
	 */
	public void deleteProduct(Product pProd);
	
	/**
	 * 
	 * @return
	 */
	public Product selectProduct(Product pProd);
	
	/**
	 * 
	 * @return
	 */
	public List<User> selectAllUsers();
	
	public List<Issue> getIssueList();
	public List<Issue> getIssueListDev();
	public List<Issue> getIssueListProgress();
	public List<Issue> getIssuesDone();
	
	
	public User selectUser(String username, String password);
	
	public Admin selectAdmin(String username, String password);
	

	
	/**
	 * 
	 * @return
	 */
	public List<Product> selectProducts(String pKey);
	
	/*-------------------- MULTI TABLE TRANSASCTION TESTS -----------------------*/
	public boolean createUserAndProduct(User pUser, Product pProd, boolean pRollbackFlag);
	public boolean createUserAndUpdateProduct(User pUser, Product pProd, boolean pRollbackFlag);

	public Issue viewIssueDetails(Long id);
	public List<User> getEmployeeList();

	public List<Issue> getIssuesReleased();

	public List<Subtask> viewSubtaskDetails(Long id);

	public Issue editIssue(Issue issue);

//	public User getUser();

	public Subtask editSubtask(Subtask subtask);

	public User getUser(String username);

	public User updateProfile(User user);

	public List<Issue> getTrash();

	
	
	

	
	
	
	
}
