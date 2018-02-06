package ph.com.alliance.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Table(name="issues")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	private String title;	
	@Lob 
	@Column(name="description", length=512)
	private String description;
	
	private String priority;
	private String type;
	private int deleted;
	private int flagged;
	private int released;
	


	public void setTitle(String title){
		this.title = title;
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
		return title;
	}

	public String getDescription(){
		return description;
	}
	
	public String getType(){
		return type;
	}

	public String getPriority(){
		return priority;
	}
	
	public int getDeleted(){
		return deleted;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	public void setFlagged(int flagged){
		this.flagged = flagged;
	}
	public int getFlagged(){
		return flagged;
	}
	
	public void setReleased(int released){
		this.released = released;
	}
	public int getReleased(){
		return released;
	}
	
	
	
	
	
	
	
	
	@Override
    public String toString() {
        return "Issues {" + "title=" + title + ", description=" + description + ", type=" + type + ", priority=" + priority + ", deleted = "+deleted+", id =" +id+ ", flagged="+flagged+ ", released= " +released+'}';

    } 
	

}
