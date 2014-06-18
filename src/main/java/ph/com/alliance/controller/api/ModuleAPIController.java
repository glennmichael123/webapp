package ph.com.alliance.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ph.com.alliance.entity.User;
import ph.com.alliance.model.UserModel;
import ph.com.alliance.service.DBTransactionTestService;

@Controller
public class ModuleAPIController {
	
	@Autowired
	DBTransactionTestService dbSvc;
	
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public UserModel saveUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	UserModel u = new UserModel();
    	int age = (request.getParameter("age") == "" ? 0: Integer.parseInt(request.getParameter("age")));
    	
    	u.setFname(request.getParameter("fname"));
    	u.setLname(request.getParameter("lname"));
    	u.setAge(age);
    	u.setUserid(request.getParameter("uid"));
    	u.setGender(request.getParameter("gender"));
    	
    	dbSvc.createUser(this.convertToEntity(u));
    	
    	return u;
    }
    
    @RequestMapping(value = "/searchUser/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public UserModel searchUser(@PathVariable("uid") String uid) {
    	User u = new User();
    	
    	u.setUid(uid);
    	
    	return convertToModel(dbSvc.selectUser(u));
    }
    
    @RequestMapping(value = "/searchAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<UserModel> searchAllUsers() {
    	List<User> userList = dbSvc.selectAllUsers();
    	List<UserModel> userModelList = new ArrayList<UserModel>();
    	
    	for(User u : userList) {
    		userModelList.add(convertToModel(u));
    	}
    	 	
    	return userModelList;
    }	
    
    /**
     * This is a sample object mapper.
     * Entity to model mapping can be handled by the class constructor itself, or
     * see convertToEntity function for another type of mapping.
     * 
     * @param pUser
     * @return UserModel
     */
    private UserModel convertToModel (User pUser) { 	
    	UserModel userModel = null;
    	
    	if (pUser != null) {
    		userModel = new UserModel(pUser);
    	} 
    	
    	return userModel;
    }
    
    /**
     * This is a sample object mapper.
     * Model to entity mapping can be explicitly done via setters, or
     * see convertToModel function for mapping using constructor
     * 
     * @param pUserModel
     * @return
     */
    private User convertToEntity (UserModel pUserModel) {
    	User u = null;
    	
    	if (pUserModel != null) {
    		u = new User();
	    	u.setAge(pUserModel.getAge());
	    	u.setFname(pUserModel.getFname());
	    	u.setGender(pUserModel.getGender());
	    	u.setLname(pUserModel.getLname());
	    	u.setUid(pUserModel.getUserid());
    	}
    	
    	return u;
    }
}
