package ph.com.alliance.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subtask")
public class Subtask implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private int issueId;
	private String description;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setIssueId(int issueId){
		this.issueId = issueId;
	}
	
	public int getissueId(){
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
