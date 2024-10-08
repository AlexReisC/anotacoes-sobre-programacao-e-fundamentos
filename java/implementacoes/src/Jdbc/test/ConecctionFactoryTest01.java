package Jdbc.test;

import java.util.List;

import Jdbc.dominio.Producer;
import Jdbc.service.ProducerService;

public class ConecctionFactoryTest01 {
	
	public static void main(String[] args) {
		Producer producer = Producer.ProducerBuilder.builder().name("Toei Animation").build();
		Producer producerToUpdate = Producer.ProducerBuilder.builder().id(1).name("madhouse").build();
//		ProducerService.save(producer);
//		ProducerService.delete(4);
//		ProducerService.update(producerToUpdate);
//		List<Producer> producers = ProducerService.findAll();
//		List<Producer> producers = ProducerService.findByName("Mad");
//		System.out.println(producers);
//		ProducerService.showProducerMetaData();
//		ProducerService.showDriverMetaData();
//		ProducerService.showTypeScrollWorking();
//		List<Producer> pro = ProducerService.findByNameAndUpdateToUpperCase("Deen");
//		List<Producer> pro = ProducerService.findByNameAndInsertWhereNotFound("A-1 pictures");
//		System.out.println("Producers found: " + pro);
//		ProducerService.findByNameAndDelete("A-1 pictures");
//		List<Producer> producers = ProducerService.findByNamePreparedStatment("Bo,");
//		System.out.println(producers);
//		ProducerService.updatePreparedStatement(producerToUpdate);
		List<Producer> producers = ProducerService.findByNameCallableStatment("N");
		System.out.println(producers);
	}
	

}
