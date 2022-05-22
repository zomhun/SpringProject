import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import project.DAO.CourseDAO;

public class Test {
	@Autowired
	private static CourseDAO CourseDAO;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bl = CourseDAO.add1StillEmpty(1);
		System.out.println(bl);
	}

}
