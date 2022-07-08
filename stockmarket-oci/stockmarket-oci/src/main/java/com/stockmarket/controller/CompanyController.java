package com.stockmarket.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.stockmarket.config.View;
import com.stockmarket.constant.Constants;
import com.stockmarket.exception.ResourceNotFoundException;
import com.stockmarket.model.Company;
import com.stockmarket.model.Request;
import com.stockmarket.model.ResponseHandler;
import com.stockmarket.model.Stock;
import com.stockmarket.repostories.CompanyRepository;
import com.stockmarket.repostories.StockRepository;
import com.stockmarket.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "/")
	public String getpage() {
		return "welcome";
	}


	@PostMapping(value = "/api/v1.0/market/company/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> initRegistration(@RequestBody Request reqCompanyobj,
			HttpServletResponse response) {
		log.info("Registering the Company Details");
		companyService.registerCompany(reqCompanyobj);
		return ResponseEntity.status(HttpStatus.CREATED).body(Constants.COMPANY_CREATED_SUCCESSFULLY);

	}
	
	@PutMapping(value = "/api/v1.0/market/company/update/{companyCode}")
	public ResponseEntity<String> updateCompany(@PathVariable long companyCode, @RequestBody Company company) {
		log.info("Updating the Company Details for", companyCode);
		companyService.updateCompany(companyCode, company);
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format(Constants.COMPANY_UPDATED_SUCCESSFULLY, companyCode));
	}

	@DeleteMapping(value = "/api/v1.0/market/company/delete/{companyCode}")
	public ResponseEntity<String> deleteCompany(@PathVariable long companyCode) {
		log.info("Deleting the Company Details for", companyCode);
		companyService.deleteCompany(companyCode);
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format(Constants.COMPANY_DELETED_SUCCESSFULLY, companyCode));
	}
}
