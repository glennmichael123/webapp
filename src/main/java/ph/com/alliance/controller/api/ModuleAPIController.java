package ph.com.alliance.controller.api;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ph.com.alliance.entity.Admin;
import ph.com.alliance.entity.Issue;
import ph.com.alliance.entity.Subtask;
import ph.com.alliance.entity.User;
import ph.com.alliance.model.IssueModel;

import ph.com.alliance.model.UserModel;
import ph.com.alliance.service.DBTransactionTestService;

/**
 * Controller class used to hadle api requests.
 * All requests that falls through /api/* servlet mapping goes through here.
 * 
 */
@Controller
public class ModuleAPIController {
	
	@Autowired
	DBTransactionTestService dbSvc;
	
	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/markFlag", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel markFlag(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	Issue issue = null;
    	Long idd = Long.parseLong(request.getParameter("flagged"));
    	int flagged = 1;
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	String sql="Update issues set flagged=? where id=?";
    	ps = con.prepareStatement(sql);
    	ps.setInt(1, flagged);
    	ps.setLong(2, idd);
    	System.out.print(ps);
    	ps.executeUpdate();
    	return issues;
    }
	
	
	@RequestMapping(value = "/unmarkFlag", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel unmarkFlag(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	
    	Long idd = Long.parseLong(request.getParameter("flagged"));
    	int flagged = 0;
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	String sql="Update issues set flagged=? where id=?";
    	ps = con.prepareStatement(sql);
    	ps.setInt(1, flagged);
    	ps.setLong(2, idd);
    	System.out.print(ps);
    	ps.executeUpdate();
    	return issues;
    }
	
	
	@RequestMapping(value = "/releaseTask", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel releaseTask(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	//Issue issue = null;
    	Long idd = Long.parseLong(request.getParameter("released"));
    	int released = 1;
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	String sql="Update issues set released=? where id=?";
    	ps = con.prepareStatement(sql);
    	ps.setInt(1, released);
    	ps.setLong(2, idd);
    	System.out.print(ps);
    	ps.executeUpdate();
    	return issues;
    }
	
	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel deleteTask(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    //	Issue issue = null;
    	Long idd = Long.parseLong(request.getParameter("id"));
    	int deleted = 1;
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	String sql="Update issues set deleted=? where id=?";
    	ps = con.prepareStatement(sql);
    	ps.setInt(1, deleted);
    	ps.setLong(2, idd);
    	//System.out.print(ps);
    	ps.executeUpdate();
    	return issues;
    }
	
	@RequestMapping(value = "/editIssue", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel editIssue(HttpServletRequest request) {
    	IssueModel issues = new IssueModel();
    	Issue issue = null;
    	String idd = request.getParameter("issudeID");
    	String flagg = request.getParameter("flag");
    	String title = request.getParameter("title");
    	String description = request.getParameter("issue_detail");
    	String priority = request.getParameter("issue_prio");
    	String type = request.getParameter("type");
    	String assigned = request.getParameter("assigned_to");
    	int deleted = 0;
    	issues.setDeleted(deleted);
    	issues.setId(Long.parseLong(idd));
    	issues.setTitle(title);
    	issues.setDescription(description);
    	issues.setPriority(priority);
    	issues.setType(type);
    	issues.setFlagged(Integer.parseInt(flagg));
    	issues.setReleased(0);
    	issues.setAssigned(assigned == null ? "" : assigned);
    	issue=dbSvc.editIssue(this.convertToEntityIssues(issues));
    	return issues;
    }
	
	

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public UserModel saveUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
    	UserModel u = new UserModel();
    	int age = (request.getParameter("age") == "" ? 0: Integer.parseInt(request.getParameter("age")));
    	u.setFname(request.getParameter("fname"));
    	u.setLname(request.getParameter("lname"));
    	u.setAge(age);
    	u.setUid(request.getParameter("uid"));
        u.setPassword(request.getParameter("pass"));
    	u.setGender(request.getParameter("gender"));
    	System.out.println("MAPPED USER --- " + this.convertToEntity(u));
        if(!dbSvc.createUser(this.convertToEntity(u))) {
            u = null;
        }
    	return u;
    }
    
    /**
     * 
     * @param uid
     * @return
     */
    @RequestMapping(value = "/searchUser/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public UserModel searchUser(@PathVariable("uid") String uid) {
    	User u = new User();
    	
    	u.setUid(uid);
    	
    	return convertToModel(dbSvc.selectUser(u));
    }
    
    @RequestMapping(value = "/saveIssues", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel saveIssues(HttpServletRequest request) {
    	IssueModel issues = new IssueModel();
    	String title = request.getParameter("title");
    	String description = request.getParameter("description");
    	String priority = request.getParameter("priority");
    	String type = request.getParameter("type");
    	String assigned = request.getParameter("assigned");
    	int deleted = 0;
    	issues.setDeleted(deleted);
    	issues.setTitle(title);
    	issues.setDescription(description);
    	issues.setPriority(priority);
    	issues.setType(type);
    	issues.setFlagged(0);
    	issues.setReleased(0);
    	issues.setOrders(0);
    	issues.setAssigned(assigned == null ? "" : assigned);
    	if(!dbSvc.createIssue(this.convertToEntityIssues(issues))) {
    		issues = null;
    	}
    	return issues;
    }
    
    /**
     * 
     * @return
     */
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
    
    
    @RequestMapping(value = "/viewIssueDetails", method = RequestMethod.POST)
    @ResponseBody
    public Issue viewIssueDetails(HttpServletRequest request) {
    	Issue issue = null;
    	
    	String id = request.getParameter("id");
    	
    	Long idd = Long.parseLong(id);
    	issue = dbSvc.viewIssueDetails(idd);
    	return issue;
    	
    }
    
    @RequestMapping(value = "/viewSubtaskDetails", method = RequestMethod.POST)
    @ResponseBody
    public List<Subtask> viewSubtaskDetails(HttpServletRequest request){
    	String id = request.getParameter("id");
    	
    	List<Subtask> subtask = null;
    	
    	Long idd = Long.parseLong(id);
    	subtask = dbSvc.viewSubtaskDetails(idd);
    
		return subtask;
    	
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/loginuser", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(HttpServletRequest request) {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession();
    	User user = dbSvc.selectUser(username, password);
    	boolean exist = user != null ? true : false;
    	if(exist){
    		session.setAttribute("username", username);
    	}
    	return exist;
    }	
    
    @RequestMapping(value = "/loginadmin", method = RequestMethod.POST)
    @ResponseBody
    public boolean loginadmin(HttpServletRequest request) {
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	HttpSession session = request.getSession();
    	Admin admin = dbSvc.selectAdmin(username, password);
    	System.out.print(admin);
    	boolean exist = admin != null ? true : false;
    	if(exist){
    		session.setAttribute("username", username);
    	}
    	return exist;
    }
    
    
    @RequestMapping(value = "/updateIssueType", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel updateIssueType(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	Long id = Long.parseLong(request.getParameter("id"));
    	String type = request.getParameter("type");
    	issues.setId(id);
    
 
    	issues.setType(type);

    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	System.out.print(id + type);
    	String sql="Update issues set type=? where id=?";
    	ps = con.prepareStatement(sql);
    	ps.setString(1, type);
    	ps.setLong(2, id);
    	System.out.print(ps);
    	ps.executeUpdate();
    	
    	return issues;
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
    		userModel = dozerBeanMapper.map(pUser, UserModel.class);
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
    		u = dozerBeanMapper.map(pUserModel, User.class);
    	}
    	
    	return u;
    }
    
    private Issue convertToEntityIssues (IssueModel pIssues) {
    	Issue issues = null;
    	if (pIssues != null) {
    		issues = dozerBeanMapper.map(pIssues, Issue.class);
    	}
    	return issues;
    }
    
    @RequestMapping(value = "/deleteSubTask", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel deleteSubTask(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	Long id = Long.parseLong(request.getParameter("id"));
    	issues.setId(id);
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	
    	String sql="delete from subtask where id = '"+id+"' ";
    	ps = con.prepareStatement(sql);
   
//    	ps.setLong(1,id);
    	System.out.print(ps);
    	ps.execute(sql);
    	
    	return issues;
    }
    
    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    @ResponseBody
    public IssueModel updateOrder(HttpServletRequest request) throws SQLException {
    	IssueModel issues = new IssueModel();
    	String driver = "com.mysql.jdbc.Driver";
    	String connectionUrl = "jdbc:mysql://localhost:3306/";
    	String database = "mytestdb3";
    	String userid = "root";
    	String password = "";
   
    	try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.sql.Connection con = null;
    	PreparedStatement ps = null;
    	con = DriverManager.getConnection(connectionUrl+database, userid, password);
    	
//    	String sql="delete from subtask where id = '"+id+"' ";
//    	ps = con.prepareStatement(sql);
//   
//    	ps.setLong(1,id);
//    	System.out.print(ps);
//    	ps.execute(sql);
    	
//    	String sql="Update issues set type=? where id=?";
//    	ps = con.prepareStatement(sql);
//    	ps.setString(1, type);
//    	ps.setLong(2, id);
//    	System.out.print(ps);
//    	ps.executeUpdate();
    	
    	String order[] = request.getParameterValues("order[]");
    	String id[] = request.getParameterValues("id[]");
    	for(int i = 0; i < order.length; i++){
    	 	String sql="Update issues set orders=? where id=?";
        	ps = con.prepareStatement(sql);
        	ps.setInt(1, i+1);
        	ps.setLong(2, Long.parseLong(id[i]));
        	
        	System.out.print(ps);
        	ps.executeUpdate();
    	}
    	
    	
    
    	
    	return issues;
    }
    
    
    
}
