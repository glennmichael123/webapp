package ph.com.alliance.springconfig;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ph.com.alliance.dao.PersonDao;

/**
 * Bootstrap for service layer.
 * 
 * @author Trey
 */
@Configuration
@ComponentScan(basePackages = { "com.trey.addrbook.service" })
public class ServiceTestConfig {

	@Bean
	public PersonDao mockPersonDao() {
		return Mockito.mock(PersonDao.class);
	}
	
}
