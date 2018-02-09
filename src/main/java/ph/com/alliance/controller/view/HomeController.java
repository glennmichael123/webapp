package ph.com.alliance.controller.view;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.com.alliance.dao.IssueDao;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.User;
import ph.com.alliance.service.DBTransactionTestService;

/**
 * Example controller class that handles request for the application root.
 * 
 *
 */

@Controller
@Scope("session")
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	DBTransactionTestService dbSvc;
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
    public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response, ModelMap map, Model model, HttpSession session) throws IOException {
    	System.out.println("@/modulename/dashboard MODULE VIEW CONTROLLER CALLED.");
    
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("dashboard");
    	System.out.print(request.getSession(false).getAttribute("username"));
    	 List<Issue> issues= dbSvc.getIssueList();
    	 List<Issue> issuesDev= dbSvc.getIssueListDev();
    	 List<Issue> issuesProgress= dbSvc.getIssueListProgress();
    	 List<Issue> issuesDone= dbSvc.getIssuesDone();
    	 List<User> employees= dbSvc.getEmployeeList();
    	
    	 mav.addObject("issues",issues);
    	 mav.addObject("issuesDev",issuesDev);
    	 mav.addObject("issuesProgress",issuesProgress);
    	 mav.addObject("issuesDone",issuesDone);
    	 mav.addObject("employees",employees);
    	 return mav;
    	
    	
        
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
    public ModelAndView viewReleases(HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session) throws IOException{
    	session = request.getSession();
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("releases");
    	 List<Issue> issuesReleased= dbSvc.getIssuesReleased();
    	 mav.addObject("issuesReleased",issuesReleased);
    	 return mav;
    }
        
}
