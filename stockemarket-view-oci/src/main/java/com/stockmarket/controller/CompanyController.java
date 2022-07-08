package com.stockmarket.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
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
import com.fasterxml.jackson.databind.ObjectMapper;
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

	@JsonView(View.UserView.External.class)
	@GetMapping("/api/v1.0/market/company/getall")

	public String fetchCompany() throws JsonProcessingException {
		log.info("Fetching all the Company Details");
		return companyService.findAll();

	}

	@GetMapping("/api/v1.0/market/company/info/{companyCode}")
	public ResponseEntity<?> fetchCompanybasedonID(@PathVariable long companyCode) throws JsonProcessingException, JSONException {
		log.info("Finding the company details for "+companyCode);
		 return companyService.fetchCompanybasedonID(companyCode);
	}
	


}
