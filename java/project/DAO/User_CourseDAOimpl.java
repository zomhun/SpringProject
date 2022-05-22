package project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.Course;
import project.entities.User;
import project.entities.User_Course;

@Repository
public class User_CourseDAOimpl  implements User_CourseDAO  {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> getListCourseUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM User_Course WHERE courseId.id = :courseId")
	            .setParameter("courseId",id);
	    List<User> user = query.list();
	    session.getTransaction().commit();
	    session.close();
        return user;
	}

	@Override
	public List<Course> getListUserCourse(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM User_Course WHERE userId.id = :userId")
	            .setParameter("userId",id);
	    List<Course> course = query.list();
	    session.getTransaction().commit();
	    session.close();
        return course;
	}

	@Override
	public boolean deleteCourseUser(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(searchByUserId(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteUserCourse(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getById(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<User> searchByCourseId(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM User_Course u WHERE u.courseId=:courseId")
	            .setParameter("courseId",id);
	    List<User> user = query.list();
	    session.getTransaction().commit();
	    session.close();
        return user;
	}

	@Override
	public List<User> searchByUserId(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM User_Course u WHERE u.userId=:userId")
	            .setParameter("userId",id);
	    List<User> user = query.list();
	    session.getTransaction().commit();
	    session.close();
        return user;
	}

	@Override
	public boolean insertUser_Course(User_Course userCourse) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(userCourse);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public User_Course getById(int id) {
		Session session = sessionFactory.openSession();
		try {
			User_Course uc = session.get(User_Course.class, id);
			return uc;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
