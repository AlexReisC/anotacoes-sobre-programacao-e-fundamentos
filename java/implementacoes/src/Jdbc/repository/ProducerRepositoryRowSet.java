package Jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import Jdbc.conn.ConnectionFactory;
import Jdbc.dominio.Producer;

public class ProducerRepositoryRowSet {

	public static List<Producer> findByNameJdbcRowSet(String name){
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?";
		List<Producer> producers = new ArrayList<>();
		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
			jrs.setCommand(sql);
			jrs.setString(1, String.format("%%%s%%", name));
			jrs.execute();
			while(jrs.next()) {
				Producer producer = Producer.ProducerBuilder
						.builder()
						.id(jrs.getInt("id"))
						.name(jrs.getString("name"))
						.build();
				producers.add(producer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producers;
	}

	public static void updateJdbcRowSet(Producer producer){
		String sql = "SELECT * FROM anime_store.producer WHERE (id = ?);";
		
		try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
			jrs.setCommand(sql);
			jrs.setInt(1, producer.getId());
			jrs.execute();
			if(!jrs.next()) return;
			jrs.updateString("name", producer.getName());
			jrs.updateRow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
