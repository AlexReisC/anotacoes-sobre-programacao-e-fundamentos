package Jdbc.service;

import java.util.List;

import Jdbc.dominio.Producer;
import Jdbc.repository.ProducerRepository;

public class ProducerService {
	
	public static void save(Producer producer) {
		ProducerRepository.save(producer);
	}
	
	public static void delete(Integer id) {
		requireValidId(id);
		ProducerRepository.delete(id);
	}
	
	public static void update(Producer producer) {
		requireValidId(producer.getId());
		ProducerRepository.update(producer);
	}
	
	public static List<Producer> findAll() {
		return ProducerRepository.findAll();
	}
	
	public static List<Producer> findByName(String name) {
		return ProducerRepository.findByName(name);
	}
	
	public static void showProducerMetaData() {
		ProducerRepository.showProducerMetaData();
	}

	public static void showDriverMetaData() {
		ProducerRepository.showDriverMetaData();
	}

	public static void showTypeScrollWorking() {
		ProducerRepository.showTypeScrollWorking();
	}
	
	public static List<Producer> findByNameAndUpdateToUpperCase(String name){
		return ProducerRepository.findByNameAndUpdateToUpperCase(name);
	}
	
	public static List<Producer> findByNameAndInsertWhereNotFound(String name){
		return ProducerRepository.findByNameAndInsertWhereNotFound(name);
	}
	
	public static void findByNameAndDelete(String name){
		ProducerRepository.findByNameAndDelete(name);
	}
	
	public static List<Producer> findByNamePreparedStatment(String name){
		return ProducerRepository.findByNamePreparedStatment(name);
	}

	public static List<Producer> findByNameCallableStatment(String name){
		return ProducerRepository.findByNameCallableStatment(name);
	}
	
	public static void updatePreparedStatement(Producer producer) {
		requireValidId(producer.getId());
		ProducerRepository.updatePreparedStatement(producer);
	}
	
	private static void requireValidId(Integer id) {
		if(id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid value for id!");
		}
	}
}
