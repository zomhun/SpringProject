package project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.Course;
import project.entities.Lab;

@Repository
public class LabDAOimpl  implements LabDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Lab> getListLab() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Lab").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean updateLab(Lab l) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(l);
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
	public boolean deleteLab(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getLabById(id));
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
	public boolean insertLab(Lab l) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(l);
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
	public Lab getLabById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Lab l = session.get(Lab.class, id);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean deleteCourse(int labId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getCourseByLabId(labId));
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
	public List<Course> getCourseByLabId(int labId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.flush();
		Query query = session.createQuery("SELECT c FROM courses c WHERE c.labId=:labId").setParameter("labId",
				labId);
		List<Course> course = query.list();
		session.getTransaction().commit();
		session.close();
		return course;
	}

}
