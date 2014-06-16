package ph.com.alliance.controller.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/modulename")
public class ModuleViewController {
	
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        return "profile";
    }
    
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String viewMessages(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	System.out.println("@/modulename/messages MODULE VIEW CONTROLLER CALLED.");
        return "messages";
    }
}
