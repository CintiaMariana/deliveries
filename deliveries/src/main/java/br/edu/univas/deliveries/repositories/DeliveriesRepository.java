package br.edu.univas.deliveries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.deliveries.entities.DeliveriesEntity;

@Repository
public interface DeliveriesRepository extends JpaRepository<DeliveriesEntity, Integer>{
	
	public List<DeliveriesEntity> findByCustomerConfirmation(boolean customerConfirmation);

}
