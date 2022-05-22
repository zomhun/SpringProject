package project.DAO;

import java.util.List;

import project.entities.Course;
import project.entities.Lab;

public interface LabDAO {

	public List<Lab> getListLab();

	public boolean updateLab(Lab l);
	public boolean deleteLab(int id);
	public boolean insertLab(Lab l);
	public boolean deleteCourse(int labId);
	public Lab getLabById(int id);
	public List<Course> getCourseByLabId(int labId);

}
