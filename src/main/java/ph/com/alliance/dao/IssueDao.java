package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;


import ph.com.alliance.entity.Issue;


/**
 * 
 * 
*/
public interface IssueDao {

	public boolean createIssues(EntityManager em, Issue pIssues);
	public Issue updateIssue(EntityManager pEM, Issue pIssue);
	public List<Issue> getIssueList(EntityManager em);

	public List<Issue> getIssueListDev(EntityManager em);
	public List<Issue> getIssueListProgress(EntityManager em);
	public List<Issue> getIssueListDone(EntityManager em);
	public Issue viewIssueDetails(EntityManager em, Long id);
	
	
}
