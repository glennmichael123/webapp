package ph.com.alliance.controller.view;
import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Example controller class that handles request for the application root.
 * 
 *
 */

@Controller
@Scope("session")
@RequestMapping("/")
public class HomeController {
	private final String ROOT_URL = "http://localhost:8081/SoaBaseCode";
	
    @RequestMapping(method=RequestMethod.GET)
    public String loadMainMenuIndex(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	return "/index";
		
    }
    
    @RequestMapping(value= "/user", method = RequestMethod.GET)
    public String loadUserLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	return "/index";

		
    }
    @RequestMapping(value= "/admin", method = RequestMethod.GET)
    public String loaAdminLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	return "/index";
		
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String viewDashboard(HttpServletRequest request, HttpServletResponse response, ModelMap map, Model model, HttpSession session) throws IOException {
    	System.out.println("@/modulename/dashboard MODULE VIEW CONTROLLER CALLED.");
    
    	
    	String ret = "";
    	session = request.getSession();
    	
 		ret = "dashboard";
 		return ret;
    	
    	
        
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException {
    	System.out.println("@/modulename/dashboard MODULE VIEW CONTROLLER CALLED."); 
    	response.sendRedirect(ROOT_URL+"/user");
    	session = request.getSession();
    	session.invalidate();
        
    }

    @RequestMapping(value = "/dashboarduser", method = RequestMethod.GET)
    public String viewUserDashboard(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	System.out.println("@/modulename/user_dashboard MODULE VIEW CONTROLLER CALLED.");
        return "dashboarduser";
    }
    
    @RequestMapping(value = "/headerdashboard", method = RequestMethod.GET)
    public String viewHeaderDashboard(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	System.out.println("@/modulename/user_dashboard MODULE VIEW CONTROLLER CALLED.");
        return "headerdashboard";
    }
    @RequestMapping(value= "/dashboard/releases", method = RequestMethod.GET)
    public String viewReleases(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	return "releases";	
    }
        
}
