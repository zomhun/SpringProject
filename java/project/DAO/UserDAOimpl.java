package project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entities.User;
@Repository
public class UserDAOimpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> getListUser() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from User").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean insertUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			user.setEnabled(true);
			session.save(user);
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
	public User getUserByUserId(int id) {
		Session session = sessionFactory.openSession();
		try {
			User user = session.get(User.class, id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			user.setEnabled(true);
			session.update(user);
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
	public boolean deleteUser(int userId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getUserByUserId(userId));
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
	public List<User> search(String username, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM users WHERE username=:username")
	            .setParameter("username",username);
	    List<User> user = query.list();
	    session.getTransaction().commit();
	    session.close();
        return user;
	}
	@Override
	public User searchByName(String username) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    session.flush();
	    Query query = session
	            .createQuery("FROM User WHERE username=:username")
	            .setParameter("username",username);
	    User user = (User) query.getSingleResult();
	    session.getTransaction().commit();
	    session.close();
        return user;
	}
	@Override
	public List<User> searchUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			if (username == null || username.length() == 0) {
				username = "%";
			} else {
				username = "%" + username + "%";
			}

			List list = session.createQuery("from User where username like :username")
					.setParameter("username", username).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<User> searchAdvanceUser(String username, String email, String phone, String address) {
		Session session = sessionFactory.openSession();
		try {
			if (username == null || username.length() == 0) {
				username = "%";
			} else {
				username = "%" + username + "%";
			}
			if (email == null || email.length() == 0) {
				email = "%";
			} else {
				email = "%" + email + "%";
			}
			if (phone == null || phone.length() == 0) {
				phone = "%";
			} else {
				phone = "%" + phone + "%";
			}
			if (address == null || address.length() == 0) {
				address = "%";
			} else {
				address = "%" + address + "%";
			}

			List list = session.createQuery("from User where username like :username AND email LIKE :email AND phone LIKE :phone AND address LIKE :address")
					.setParameter("username", username).setParameter("email", email).setParameter("phone", phone).setParameter("address", address).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}


}
