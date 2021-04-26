package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DepreciationDto;
import com.lti.dto.DepreciationStatus;
import com.lti.service.DepreciationService;

@RestController
@CrossOrigin
public class DepreciationController {
	
	@Autowired
	private DepreciationService depreciationService;
	
}
