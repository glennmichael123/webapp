package ph.com.alliance.util;

import org.springframework.stereotype.Component;

import ph.com.alliance.domain.Person;
import ph.com.alliance.dto.PersonDto;

/**
 * Factory methods for creating DTOs.
 * 
 * @author Trey
 */
@Component
public class DtoFactory {

	/**
	 * Converts a domain entity to a dto.
	 * @param domain
	 * @return
	 */
	public PersonDto createPerson(Person domain) {
		// TODO convert to dozer
		PersonDto dto = new PersonDto();
		dto.setId(domain.getId());
		dto.setFullname(domain.getFirstName() + " " + domain.getLastName());
		return dto;
	}

}
