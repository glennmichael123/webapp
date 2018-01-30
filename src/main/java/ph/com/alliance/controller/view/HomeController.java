package ph.com.alliance.controller.view;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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
	
    @RequestMapping(method=RequestMethod.GET)
    public String loadMainMenuIndex(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	String ret = "";
    	if(session.getAttribute("username") == null || session.getAttribute("username").equals("")){
    		ret = "/index";
    		return ret;
    	}else{
    		response.sendRedirect("localhost:8081/SoaBaseCode/dashboard");
    		return "/dashboard";
    	}
    	
		
    }
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String viewDashboard(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException {
    	System.out.println("@/modulename/dashboard MODULE VIEW CONTROLLER CALLED.");
    	String ret = "";
    	 session = request.getSession();
    	if(session.getAttribute("username") == null || session.getAttribute("username").equals("")){
    		response.sendRedirect("");
    		return "/index";
    	}else{
    		ret = "dashboard";
    		return ret;
    	}
    	
    	
    	
        
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException {
    	System.out.println("@/modulename/dashboard MODULE VIEW CONTROLLER CALLED."); 
    	response.sendRedirect("");
    	session = request.getSession();
    	session.invalidate();
        
    }


}
