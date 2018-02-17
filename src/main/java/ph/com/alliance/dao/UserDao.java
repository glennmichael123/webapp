
package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Admin;
import ph.com.alliance.entity.User;

/**
 * 
 * 
 */
public interface UserDao {
	/**
	 * 
	 * @param puser
	 * @return
	 */
	public boolean createUser(EntityManager pEM, User pUser);
	
	/**
	 * 
	 * @param p_em
	 * @param pUser
	 * @return
	 */
	public User updateUser(EntityManager pEM, User pUser);
	
	/**
	 * 
	 * @param p_em
	 * @param pUser
	 * @return
	 */
	public int deleteUser(EntityManager pEM, User pUser);
	
	/**
	 * 
	 * @param p_em
	 * @param pUser
	 * @return
	 */
	public User selectUser(EntityManager pEM, String pUid, String password);
	
	
	public Admin selectAdmin(EntityManager pEM, String pUid, String password);

	/**
	 * 
	 * @param p_em
	 * @param pKey
	 * @return
	 */
	public List<User> selectUsers(EntityManager pEM, String pKey);
	
	/**
	 * 
	 * @param pEM
	 * @return
	 */
	public List<User> selectAllUsers(EntityManager pEM);

	public List<User> getEmployeeList(EntityManager em);

	public User getProfile(EntityManager em, String username);

	public User updateProfile(EntityManager em, User user);

	/**
	 * 
	 * @param pEM
	 * @return
	 */
//	public User selectUser(EntityManager pEM, String username);
}
