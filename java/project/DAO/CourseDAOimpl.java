package project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.Course;

@Repository
public class CourseDAOimpl implements CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getListCourse() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Course").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateCourse(Course c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getCourseById(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean insertCourse(Course c) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Course getCourseById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Course c = session.get(Course.class, id);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean add1StillEmpty(int id) {
		Session session = sessionFactory.openSession();
		Course course = new Course();
		try {
			course = this.getCourseById(id);
			course.setStillEmpty(course.getStillEmpty() + 1);
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean take1StillEmpty(int courseId) {
		Session session = sessionFactory.openSession();
		Course course = new Course();
		try {
			course = this.getCourseById(courseId);
			course.setStillEmpty(course.getStillEmpty() - 11);
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Course> getAvailableCourse() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Course c WHERE c.stillEmpty>0").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Course> searchCourse(String courseName, float minPrice, float maxPrice) {
		Session session = sessionFactory.openSession();
		try {
			if (courseName == null || courseName.length() == 0) {
				courseName = "%";
			} else {
				courseName = "%" + courseName + "%";
			}
			if (maxPrice == 0) {
				maxPrice = 100000000;
			} else {
				maxPrice = maxPrice;
			}

			List list = session.createQuery("from Course where courseName like :courseName AND price BETWEEN :minPrice AND :maxPrice")
					.setParameter("courseName", courseName).setParameter("minPrice", minPrice).setParameter("maxPrice", maxPrice).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
