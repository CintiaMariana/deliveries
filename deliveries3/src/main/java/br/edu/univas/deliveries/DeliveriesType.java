package br.edu.univas.deliveries;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;




@JsonPropertyOrder({"FAST", "WITHDRAW", "BASIC"})
public enum DeliveriesType {
    FAST,
    WITHDRAW,
    BASIC
}


