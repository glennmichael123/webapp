package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Admin;
import ph.com.alliance.entity.User;

/**
 * 
 * 
 */
public interface AdminDao {
	
	
	public Admin selectAdmin(EntityManager pEM, String pUid, String password);

}
