package project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.User;
import project.entities.User_Role;

@Repository
public class UserRoleDAOimpl  implements UserRoleDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean insertUserRole(User_Role userRole) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(userRole);
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
	public List<User_Role> search(int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("SELECT u FROM users_roles u WHERE u.userId=:userId")
	            .setParameter("userId",userId);
	    List<User_Role> userRole = query.list();
	    session.getTransaction().commit();
	    session.close();
        return userRole;
	}

	@Override
	public boolean delete(int userId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.createQuery("DELETE FROM users_roles ur WHERE ur.userId=:userId").setParameter("userId",userId);
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

}
