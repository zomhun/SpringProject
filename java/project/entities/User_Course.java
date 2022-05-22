package project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "users_courses")
public class User_Course {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private Course courseId;
	@ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public User_Course(int id, Course courseId, User userId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.userId = userId;
	}
	public User_Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
