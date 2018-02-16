package ph.com.alliance.model;


public class IssueModel{
	private Long id;
	private String title;	
	private String description;
	private String priority;
	private String type;
	private int deleted;
	private int flagged;
	private int released;
	private String assigned;
	private int orders;
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setFlagged(int flagged){
		this.flagged = flagged;
	}
	
	public void setOrders(int orders){
		this.orders = orders;
	}
	
	public int getOrders(){
		return orders;
	}
	
	public int getFlagged(){
		return flagged;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}

	public void setDescription(String description){
		this.description = description;
	}
	
	public void setType(String type){
		this.type = type;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}
	
	public void setDeleted(int deleted){
		this.deleted = deleted;
	}
	
	public String getTitle(){
		return this.title;
	}

	public String getDescription(){
		return this.description;
	}
	
	public String getType(){
		return this.type;
	}

	public String getPriority(){
		return this.priority;
	}
	
	public int getDeleted(){
		return this.deleted;
	}
	
	public void setReleased(int released){
		this.released = released;
	}
	public int getReleased(){
		return released;
	}
	
	public void setAssigned(String assigned){
		this.assigned = assigned;
	}
	
	public String getAssigned(){
		return assigned;
	}
	
	@Override
    public String toString() {
        return "Issues {" + "title=" + title + ", description=" + description + ", type=" + type + ", priority=" + priority + ", deleted = "+deleted+", id =" +id+ ", flagged="+flagged+ ", released= " +released+", assigned="+assigned+", orders="+orders+'}';

    }
	

}
