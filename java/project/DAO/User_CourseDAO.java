package project.DAO;

import java.util.List;

import project.entities.Course;
import project.entities.User;
import project.entities.User_Course;

public interface User_CourseDAO {
	public List<User> getListCourseUser(int id);
	public List<Course> getListUserCourse(int id);
	public boolean deleteCourseUser(int id);
	public boolean deleteUserCourse(int id);
	public List<User> searchByCourseId(int id);
	public List<User> searchByUserId(int id);
	public boolean insertUser_Course(User_Course userCourse);
	public User_Course getById(int id);
}
