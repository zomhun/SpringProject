package project.DAO;

import java.util.List;

import project.entities.Course;

public interface CourseDAO {
	public List<Course> getListCourse();
	public boolean updateCourse(Course c);
	public boolean deleteCourse(int id);
	public boolean insertCourse(Course c);
	public Course getCourseById(int id);
	public boolean add1StillEmpty(int id);
	public boolean take1StillEmpty(int courseId);
	public List<Course> getAvailableCourse();
	public List<Course> searchCourse(String courseName, float minPrice, float maxPrice);
}
