package com.codigorupestre.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.codigorupestre.records.BoletoViaje;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class BoletoViajeController {
	
	private Map<String, Boolean> asientosDisponibles = new HashMap<String, Boolean>();
	
	public BoletoViajeController() {
		for (int i = 0; i <=20; i++) {
			asientosDisponibles.put("XUG-2025-" + i, true);
		}
	}
	
	@MessageMapping("/comprarBoleto")
	@SendTo("/topic/actualizarAsientos")
	public Map<String, Boolean> comprarBoleto(BoletoViaje boletoViaje){
		log.info("Solicitud de compra de boleto {} ", boletoViaje);
		
		return asientosDisponibles;
	}
}
