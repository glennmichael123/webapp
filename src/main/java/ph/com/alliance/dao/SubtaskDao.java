package ph.com.alliance.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ph.com.alliance.entity.Subtask;

public interface SubtaskDao {

	List<Subtask> viewSubtaskDetails(EntityManager em, Long id);

	Subtask editSubtask(EntityManager em, Subtask pSubtask);

}
