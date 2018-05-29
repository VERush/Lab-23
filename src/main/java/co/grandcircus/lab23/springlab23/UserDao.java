package co.grandcircus.lab23.springlab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@Autowired

	JdbcTemplate jdbcTemplate;

	public List<User> findAllUsers() {
		String sql = "SELECT * FROM user";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

	}
	
	public void addUser(User user) {
		// use question marks for user input values to avoid SQL injection attacks
		String sql = 
			"INSERT INTO user (firstName, lastName, email, phone, password) VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPhone(), user.getPassword());
	}
	
	public void deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		
		jdbcTemplate.update(sql, id);
	}
}
