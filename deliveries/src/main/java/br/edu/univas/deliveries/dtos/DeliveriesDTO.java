package br.edu.univas.deliveries.dtos;



import java.util.Date;

import br.edu.univas.deliveries.DeliveriesType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DeliveriesDTO {
	
	private Integer id;
	private Date deliveryDateTime;
	private long CPFReceiver;
	private boolean customerConfirmation;
	private int attempt;
	private DeliveriesType deliveriesType;

}
