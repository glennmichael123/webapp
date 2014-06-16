package ph.com.alliance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ph.com.alliance.dao.PersonDao;
import ph.com.alliance.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	/*public PersonServiceImpl(PersonDao personDao) {
		super();
		this.personDao = personDao;
	}*/

	public Person getPersonById(Integer id) {
		return personDao.findById(id);
	}

	@Transactional
	public void savePerson(Person person) {
		personDao.insert(person);
	}

//	public void updatePerson(Person p) {
//		personDao.update(p);
//	}

}
