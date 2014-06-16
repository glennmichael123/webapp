package ph.com.alliance.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ph.com.alliance.bootstrap.DatabaseConfig;

/**
 * Bootstrap for service layer.
 * 
 * @author Trey
 */
@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = { "com.trey.addrbook.dao" })
public class DaoTestConfig {

}
