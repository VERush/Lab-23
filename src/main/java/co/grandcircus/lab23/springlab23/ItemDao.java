package co.grandcircus.lab23.springlab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Item> findAllItems() {
		String sql = "SELECT * FROM item";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Item>(Item.class));
	}
	
	public void addItem(Item item) {
		// use question marks for user input values to avoid SQL injection attacks
		String sql = 
			"INSERT INTO item (itemName, description, quantity, price) VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, item.getItemName(), item.getDescription(), 
				item.getQuantity(), item.getPrice());
	}
	
	public void deleteItem(int id) {
		String sql = "DELETE FROM item WHERE id=?";
		
		jdbcTemplate.update(sql, id);
	}
}
