package com.api.core.appl.util.controller.impl;


import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.core.appl.util.controller.spec.UtilController;



@RestController
public class UtilControllerImpl implements UtilController {

	
	
	@GetMapping("/verificacao-saude-app")
	@ResponseBody
	@Override
    public ResponseEntity<ArrayList<String>> verificarSaudeApp() {
		
		ArrayList<String> listaRespostasSaude = new ArrayList<String>();
		
		listaRespostasSaude.add("Saúde da aplicação: OK!");
		
        return new ResponseEntity<ArrayList<String>>(listaRespostasSaude, HttpStatus.OK);
    }
}
