package project.DAO;


import java.util.List;

import project.entities.Course;
import project.entities.User;

public interface UserDAO {
	public List<User> getListUser();
	public boolean insertUser(User user);
	public User getUserByUserId(int userId);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
	public List<User> search(String username , String password);
	public User searchByName(String username);
	public List<User> searchUsername(String username);
	public List<User> searchAdvanceUser(String username, String email, String phone, String address);
}
