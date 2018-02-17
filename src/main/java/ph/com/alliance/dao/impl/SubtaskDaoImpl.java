package ph.com.alliance.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ph.com.alliance.dao.SubtaskDao;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.Subtask;
@Component
@Repository("subtaskDao")
public class SubtaskDaoImpl implements SubtaskDao{

	@Override
	public List<Subtask> viewSubtaskDetails(EntityManager em, Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Subtask> cq = cb.createQuery(Subtask.class);
		Root<Subtask> userRoot = cq.from(Subtask.class);
		cq.select(userRoot);
		Predicate predicate = cb.conjunction();
		
		 predicate = cb.and(predicate, 
		 cb.equal(userRoot.get("issueId"), id));
		
		 cq.where(predicate);
		try {
			return em.createQuery(cq).getResultList();
		} catch (Exception e) {
			System.err.println("ERROR ----------------- ");
			e.printStackTrace();
			return null;
		}
	
	
}

	@Override
	public Subtask editSubtask(EntityManager em, Subtask pSubtask) {
		Subtask subtask= null;
		try {
			subtask = em.merge(pSubtask);
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
		} catch (TransactionRequiredException trxe) {
			trxe.getMessage();
		}

		return subtask;
	}
	
}
