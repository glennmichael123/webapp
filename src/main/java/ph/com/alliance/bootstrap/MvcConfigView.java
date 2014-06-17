package ph.com.alliance.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import ph.com.alliance.interceptors.ModuleInterceptor;
import ph.com.alliance.interceptors.UserModuleInterceptor;


/**
 * Bootstrap for REST layer. It's important to isolate this for testability.
 * 
 * @author Trey
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ph.com.alliance.controller.view"})
public class MvcConfigView extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
		registry.addResourceHandler("/pages/**").addResourceLocations("/pages/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
    public UrlBasedViewResolver getInternalResourceViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".xhtml");
        return resolver;
    }
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new ModuleInterceptor());
	    registry.addInterceptor(new UserModuleInterceptor()).addPathPatterns("/user/*");
	 }
}
