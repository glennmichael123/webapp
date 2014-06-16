package ph.com.alliance.springconfig;

import org.mockito.Mockito;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//import ph.com.alliance.service.PersonService;

@Configuration
@ComponentScan(basePackages = { "com.trey.addrbook.util" })
public class ControllerTestConfig {

	/*@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PersonService mockPersonService() {
		return Mockito.mock(PersonService.class);
	}*/
	
}
