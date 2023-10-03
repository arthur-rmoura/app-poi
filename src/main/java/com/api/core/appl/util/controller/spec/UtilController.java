package com.api.core.appl.util.controller.spec;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

public interface UtilController {

	ResponseEntity<ArrayList<String>> verificarSaudeApp();

}
