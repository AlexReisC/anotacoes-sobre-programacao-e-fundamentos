package Jdbc.service;

import java.util.List;

import Jdbc.dominio.Producer;
import Jdbc.repository.ProducerRepositoryRowSet;

public class ProducerServiceRowSet {
	public static List<Producer> findByNameJdbcRowSet(String name){
		return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
	}
	
	public static void updateJdbcRowSet(Producer producer){
		ProducerRepositoryRowSet.updateJdbcRowSet(producer);
	}
}
