package ph.com.alliance.dao.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.IssueDao;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.User;

@Component
@Repository("issuesDao")

public class IssueDaoImpl implements IssueDao{
DataSource datasource;
JdbcTemplate template;  
	@Override
	public boolean createIssues(EntityManager pEM, Issue pIssues) {
		boolean success = true;
		try {
			pEM.persist(pIssues);
			
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

	@Override
	public List<Issue> getIssueList(EntityManager em){  
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		 Predicate predicate = cb.conjunction();
		 Predicate predicate1 = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("type"), "backlog"));
		 predicate1 = cb.and(predicate1, 
				 cb.notEqual(userRoot.get("deleted"), 1));
		 cq.where(
				 cb.and(predicate, predicate1)
         );
		 
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Issue> getIssueListDev(EntityManager em) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		Predicate predicate = cb.conjunction();
		 Predicate predicate1 = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("type"), "development"));
		 predicate1 = cb.and(predicate1, 
				 cb.notEqual(userRoot.get("deleted"), 1));
		 cq.where(
				 cb.and(predicate, predicate1)
        );
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	}  
	
	@Override
	public List<Issue> getIssueListProgress(EntityManager em) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		Predicate predicate = cb.conjunction();
		 Predicate predicate1 = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("type"), "progress"));
		 predicate1 = cb.and(predicate1, 
				 cb.notEqual(userRoot.get("deleted"), 1));
		 cq.where(
				 cb.and(predicate, predicate1)
        );
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Issue updateIssue(EntityManager pEM, Issue pIssue) {
		Issue issue = null;
		
		System.out.print(pIssue.getId());
		
		try {
			//issue = pEM.u;
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		} catch (TransactionRequiredException trxe) {
			trxe.getMessage();
		}
		
		return issue;
	}

	@Override
	public List<Issue> getIssueListDone(EntityManager em) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		Predicate predicate = cb.conjunction();
		 Predicate predicate1 = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("type"), "done"));
		 predicate1 = cb.and(predicate1, 
				 cb.notEqual(userRoot.get("deleted"), 1));
		 cq.where(
				 cb.and(predicate, predicate1)
        );
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Issue viewIssueDetails(EntityManager em, Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		
		 Predicate predicate = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("id"), id));
		 cq.where(predicate);
		try {
			return em.createQuery(cq).getSingleResult();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Issue> getIssueReleased(EntityManager em) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Issue> cq = cb.createQuery(Issue.class);
		Root<Issue> userRoot = cq.from(Issue.class);
		cq.select(userRoot);
		Predicate predicate = cb.conjunction();
		 Predicate predicate1 = cb.conjunction();
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("released"), 1));
		 predicate1 = cb.and(predicate1, 
				 cb.notEqual(userRoot.get("deleted"), 1));
		 cq.where(
				 cb.and(predicate, predicate1)
        );
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Issue editIssue(EntityManager em, Issue pIssue) {
		Issue issue = null;
		try {
			issue = em.merge(pIssue);
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		} catch (TransactionRequiredException trxe) {
			trxe.getMessage();
		}

		return issue;
	}

}
