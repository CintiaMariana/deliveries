package br.edu.univas.deliveries.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.univas.deliveries.dtos.DeliveriesDTO;
import br.edu.univas.deliveries.entities.DeliveriesEntity;
import br.edu.univas.deliveries.repositories.DeliveriesRepository;
import br.edu.univas.deliveries.suporte.DeliveriesException;
import br.edu.univas.deliveries.suporte.ObjectNotFoundException;
import br.edu.univas.deliveries.util.DeliveriesEntityConverter;

@Service
public class DeliveriesService {
	
	private final DeliveriesRepository repo;
	
	
	private DeliveriesEntityConverter converter = new DeliveriesEntityConverter();
	
	@Autowired
	public DeliveriesService(DeliveriesRepository repo) {
		this.repo = repo;
	}
	
	public List<DeliveriesDTO> findAll(){
		return repo.findAll().stream().map(DeliveriesEntityConverter::toDTO).collect(Collectors.toList());
	}
	
	public DeliveriesEntity findById(Integer id) {
		if (id == null) {
            throw new IllegalArgumentException("ID not be null");
        }
		Optional<DeliveriesEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("No delivery found with ID: " + id));
	}
	
	
	public List<DeliveriesDTO> findByConfirmation(boolean c){
		return repo.findByCustomerConfirmation(false).stream().map(DeliveriesEntityConverter::toDTO).collect(Collectors.toList());
	}
	
	public List<DeliveriesDTO> findByCustomerConfirmation(boolean customerConfirmation) {
        List<DeliveriesEntity> entities = repo.findByCustomerConfirmation(customerConfirmation);
        return entities.stream()
                .map(DeliveriesEntityConverter::toDTO)
                .collect(Collectors.toList());
    }
	
	
	public void createDeliveries(DeliveriesDTO deliveries) {
		repo.save(converter.toEntity(deliveries));
	}
	
	public void updateDeliveries(DeliveriesDTO deliveries, Integer id) {
		if (id == null || deliveries == null || !id.equals(deliveries.getId())) {
			throw new DeliveriesException("Invalid delivery id.");
		}
		DeliveriesEntity existingObj = findById(id);
		updateConfirmation(existingObj, deliveries);
		repo.save(existingObj);
	}

	private void updateConfirmation(DeliveriesEntity existingObj, DeliveriesDTO newObj) {
		existingObj.setCustomerConfirmation(newObj.isCustomerConfirmation());
	}
	
	public void deleteDeliveries(Integer id) {
		if (id == null) {
			throw new DeliveriesException("Delivery id can not be null.");
		}
		DeliveriesEntity obj = findById(id);
		try {
			repo.delete(obj);
		} catch (DataIntegrityViolationException e) {
			throw new DeliveriesException("Can not delete a Product with dependencies constraints.");
		}
	}

}
