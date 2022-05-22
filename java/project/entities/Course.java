package project.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "courses")
public class Course {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "courseName")
	private String courseName;
	@Column(name = "numberOfCredit")
	private int numberOfCredit;
	@Column(name = "price")
	private float price;
	@Column(name = "coefficient")
	private int coefficient;
	@ManyToOne
    @JoinColumn(name = "labId", referencedColumnName = "id")
    private Lab labId;
	@Column(name = "stillEmpty")
	private int stillEmpty;
	@OneToMany(mappedBy = "id")
    private List<User_Course> listUserCourse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNumberOfCredit() {
		return numberOfCredit;
	}
	public void setNumberOfCredit(int numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public Lab getLabId() {
		return labId;
	}
	public void setLabId(Lab labId) {
		this.labId = labId;
	}
	public int getStillEmpty() {
		return stillEmpty;
	}
	public void setStillEmpty(int stillEmpty) {
		this.stillEmpty = stillEmpty;
	}
	public List<User_Course> getListUserCourse() {
		return listUserCourse;
	}
	public void setListUserCourse(List<User_Course> listUserCourse) {
		this.listUserCourse = listUserCourse;
	}
	public Course(int id, String courseName, int numberOfCredit, float price, int coefficient, Lab labId,
			int stillEmpty, List<User_Course> listUserCourse) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.numberOfCredit = numberOfCredit;
		this.price = price;
		this.coefficient = coefficient;
		this.labId = labId;
		this.stillEmpty = stillEmpty;
		this.listUserCourse = listUserCourse;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
