package Jdbc.test;

import java.util.List;

import Jdbc.dominio.Producer;
import Jdbc.service.ProducerServiceRowSet;

public class ConnectionFactoryTest02 {
	public static void main(String[] args) {
		Producer producerToUpdate = Producer.ProducerBuilder.builder().id(1).name("MAD").build();
		ProducerServiceRowSet.updateJdbcRowSet(producerToUpdate);
		List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
		System.out.println(producers);
	}
}
