package project.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "labs")
public class Lab {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "labName")
	private String labName;
	@OneToMany(mappedBy = "id")
    private List<Course> listCourse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public List<Course> getListCourse() {
		return listCourse;
	}
	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	public Lab(int id, String labName, List<Course> listCourse) {
		super();
		this.id = id;
		this.labName = labName;
		this.listCourse = listCourse;
	}
	public Lab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
