package br.edu.univas.deliveries;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.edu.univas.deliveries.dtos.DeliveriesDTO;
import br.edu.univas.deliveries.entities.DeliveriesEntity;
import br.edu.univas.deliveries.repositories.DeliveriesRepository;
import br.edu.univas.deliveries.service.DeliveriesService;

public class DeliveriesServiceTest {
	
	private static DeliveriesService service;
	private static DeliveriesRepository repoMock;

	@BeforeAll
	public static void setup() {
		repoMock = Mockito.mock(DeliveriesRepository.class);
		service = new DeliveriesService(repoMock);
	}

	@Test
	void testGetAllDeliveries() {

		List<DeliveriesEntity> deliveries = List.of(
				new DeliveriesEntity()
				);
		Mockito.when(repoMock.findAll()).thenReturn(deliveries);

		List<DeliveriesDTO> allDeliveries = service.findAll();

		Mockito.verify(repoMock, Mockito.times(1)).findAll();

		assertNotNull(allDeliveries);
		assertEquals(1, allDeliveries.size());
	}

	@Test
	void testGetDeliveriesById() {
		
		DeliveriesEntity d1 = new DeliveriesEntity();
		d1.setId(1);
		Mockito.when(repoMock.findById(1)).thenReturn(Optional.of(d1));
		
		DeliveriesEntity deliveries = service.findById(1);
		assertNotNull(deliveries);
		assertEquals(1, deliveries.getId());
	}

	@Test
	public void testFindByCustomerConfirmation() {
		fail ("Not yet implemented");
	}

}
