package Jdbc.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Jdbc.conn.ConnectionFactory;
import Jdbc.dominio.Producer;

public class ProducerRepository {
	
	public static void save(Producer producer) {
		String sql = "INSERT INTO anime_store.producer(name) VALUES ('%s');".formatted(producer.getName());
		
		try (Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement()){
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Inserted producer " + producer.getId() + ", rows affected " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void delete(int id) {
		String sql = "DELETE FROM anime_store.producer WHERE (id = '%d');".formatted(id);
		
		try (Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement()){
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Delete producer " + id + ", rows affected " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void update(Producer producer) {
		String sql = "UPDATE anime_store.producer SET name = '%s' WHERE (id = '%d');"
				.formatted(producer.getName(), producer.getId());
		
		try (Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement()){
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Update producer " + producer.getId() + ", rows affected " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static List<Producer> findAll() {
		System.out.println("Finding all producers");
		return findByName("");
	}
	
	public static List<Producer> findByName(String name) {
		System.out.println("Finding producers by name");
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%s';"
		.formatted("%" + name + "%");
		
		List<Producer> producers = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()){
				Producer producer = Producer.ProducerBuilder
						.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producers;
	}
	
	public static void showProducerMetaData() {
		System.out.println("Showing producer metadata");
		String sql = "SELECT * FROM anime_store.producer;";

		try (Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			System.out.println("Column count " + columnCount);
			for (int index = 1; index <= columnCount; index++) {
				System.out.println("Table name " + rsMetaData.getTableName(index));
				System.out.println("Column name " + rsMetaData.getColumnName(index));
				System.out.println("Column size " + rsMetaData.getColumnDisplaySize(index));
				System.out.println("Column type " + rsMetaData.getColumnTypeName(index));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showDriverMetaData() {
		System.out.println("Showing driver metadata");

		try (Connection conn = ConnectionFactory.getConnection()){
			DatabaseMetaData metaData = conn.getMetaData();
			if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				System.out.println("Supports TYPE_FORWARD_ONLY");
				if(metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
					System.out.println("Add supports CONCUR_UPDATABLE");
				}
			}
			if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
				if(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
					System.out.println("Add supports CONCUR_UPDATABLE");
				}
			}
			if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Supports TYPE_SCROLL_SENSITIVE");
				if(metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
					System.out.println("Add supports CONCUR_UPDATABLE");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showTypeScrollWorking() {
		String sql = "SELECT * FROM anime_store.producer;";
		
		try (Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql)){
			System.out.println("Last row? " + rs.last());
			System.out.println(Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			System.out.println("Row number " + rs.getRow());

			System.out.println("First row? " + rs.first());
			System.out.println(Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			System.out.println("Row number " + rs.getRow());
			
			System.out.println("Row absolute? " + rs.absolute(2));
			System.out.println(Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			System.out.println("Row number " + rs.getRow());
			
			System.out.println("Row relative? " + rs.relative(-1));
			System.out.println(Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			System.out.println("Row number " + rs.getRow());
			
			System.out.println("is last? " + rs.isLast());
			System.out.println("Row number " + rs.getRow());
			
			System.out.println("is first? " + rs.isLast());
			System.out.println("Row number " + rs.getRow());
			
			System.out.println("Last row? " + rs.last());
			System.out.println("----------------------");
			while(rs.previous()) {				
				System.out.println(Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
		System.out.println("Finding producers by name");
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s'"
				.formatted("%" + name + "%");
		
		List<Producer> producers = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection(); 
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()){
				rs.updateString("name", rs.getString("name").toUpperCase());
				rs.updateRow();
				Producer producer = Producer.ProducerBuilder
						.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producers;
	}
	public static List<Producer> findByNameAndInsertWhereNotFound(String name) {
		System.out.println("Finding producers by name");
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%s'"
				.formatted("%" + name + "%");
		
		List<Producer> producers = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getConnection(); 
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql)){
			if(rs.next()) return producers;
			rs.moveToInsertRow();
			rs.updateString("name", name);
			rs.insertRow();
			producers.add(getProducer(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producers;
	}
	
	public static void findByNameAndDelete(String name) {
		System.out.println("Finding producers by name");
		String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
				.formatted(name);
		
		try (Connection conn = ConnectionFactory.getConnection(); 
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql)){
			while(rs.next()) {
				System.out.println("Deleting " + rs.getString(name));
				rs.deleteRow();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Producer getProducer(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		rs.next();
		return Producer.ProducerBuilder.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
	}
	
	public static List<Producer> findByNamePreparedStatment(String name) {
		System.out.println("Finding producers by name");
		
		List<Producer> producers = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection(); 
			PreparedStatement ps = preparedStatementFindByName(conn, name);
			ResultSet rs = ps.executeQuery()){
			while(rs.next()){
				Producer producer = Producer.ProducerBuilder
						.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return producers;
	}

	public static List<Producer> findByNameCallableStatment(String name) {
		System.out.println("Finding producers by name");
		
		List<Producer> producers = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = callableStatementFindByName(conn, name);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()){
				Producer producer = Producer.ProducerBuilder
						.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.build();
				producers.add(producer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producers;
	}
	
	private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
		String sql = "CALL `anime_store`.`sp_get_producer_by_name`('NHK');";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, String.format("%%%s%%", name));
		return ps;
	}
	
	private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
		String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
		CallableStatement cs = conn.prepareCall(sql);
		cs.setString(1, String.format("%%%s%%", name));
		return cs;
	}
	
	public static void updatePreparedStatement(Producer producer) {
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement ps = preparedStatementUpdate(conn, producer)){
			int rowsAffected = ps.executeUpdate();
			System.out.println("Update producer " + producer.getId() + ", rows affected " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
		String sql = "UPDATE anime_store.producer SET name = ? WHERE (id = ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, producer.getName());
		ps.setInt(2, producer.getId());
		return ps;
	}
	
	
}
