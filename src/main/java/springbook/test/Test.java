package springbook.test;

import java.sql.SQLException;

import spring.user.dao.UserDao;
import springbook.user.domain.User;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setId("TestId");
		user.setName("TestName");
		user.setPassword("TestPw");
		dao.add(user);
		
		System.out.println("등록 성공  : " + user.getId());
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}
}
