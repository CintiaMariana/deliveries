package br.edu.univas.deliveries.suporte;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class StandardError {
	
	private String message;
	private Integer status;
	private Date date;

}
