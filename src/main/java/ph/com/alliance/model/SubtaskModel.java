package ph.com.alliance.model;


public class SubtaskModel{
	private Long id;
	private Long issueId;
	private String description;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setIssueId(Long issueId){
		this.issueId = issueId;
	}
	
	public Long getissueId(){
		return issueId;
	}

	public void setDescription(String description){
		this.description = description;
	}
	
	

	public String getDescription(){
		return this.description;
	}
	
	

	
	@Override
    public String toString() {
        return "Issues {" + "description=" + description + ", id =" +id+ '}';

    } 
	

}
