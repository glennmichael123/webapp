package ph.com.alliance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.alliance.entity.User;

@Controller
public class ModuleAPIController {
	
	Map<String, User> userStore = new HashMap<String, User>();

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	
    	User u = new User();
    	u.setFname(request.getParameter("fname"));
    	u.setLname(request.getParameter("lname"));
    	
    	if (userStore.get(request.getParameter("fname")) == null) {
    		userStore.put(u.getFname(), u);
    	} else {
    		u = null;
    	}
    	
    	return u;
    }
    
    @RequestMapping(value = "/searchUser/{fname}", method = RequestMethod.GET)
    @ResponseBody
    public User searchUser(@PathVariable("fname") String fname) {
    	return userStore.get(fname);
    }
    
    @RequestMapping(value = "/searchAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> searchAllUsers() {
    	List<User> userList = new ArrayList<User>();
    	Set<String> userFirstNames = userStore.keySet();

    	for(String fname : userFirstNames){
        	userList.add(userStore.get(fname));
        }
    	
    	return userList;
    }
}
