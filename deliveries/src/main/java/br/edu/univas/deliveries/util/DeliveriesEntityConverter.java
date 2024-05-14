package br.edu.univas.deliveries.util;

import org.springframework.stereotype.Component;

import br.edu.univas.deliveries.dtos.DeliveriesDTO;
import br.edu.univas.deliveries.entities.DeliveriesEntity;

@Component
public class DeliveriesEntityConverter {
	
	public static DeliveriesDTO toDTO (DeliveriesEntity deliveries) {
		return new DeliveriesDTO(
					deliveries.getId(), deliveries.getDeliveryDateTime(),
					deliveries.getCPFReceiver(), deliveries.isCustomerConfirmation(),
					deliveries.getAttempt(), deliveries.getDeliveriesType());
	}
	
	public DeliveriesEntity toEntity(DeliveriesDTO deli) {
		System.out.println("toEntity: " + deli);
		return new DeliveriesEntity(deli.getId(), deli.getDeliveryDateTime(),
				deli.getCPFReceiver(), deli.isCustomerConfirmation(),
				deli.getAttempt(), deli.getDeliveriesType());
	}

}
