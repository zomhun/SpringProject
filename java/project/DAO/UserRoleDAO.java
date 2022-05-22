package project.DAO;

import java.util.List;

import project.entities.User_Role;

public interface UserRoleDAO {
	public boolean insertUserRole(User_Role userRole);
	public List<User_Role> search(int userId);
	public boolean delete(int userId);
}
