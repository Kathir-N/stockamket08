package com.stockmarket.service.impl;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmarket.constant.Constants;
import com.stockmarket.model.Company;
import com.stockmarket.model.Request;
import com.stockmarket.model.ResponseHandler;
import com.stockmarket.repostories.CompanyRepository;
import com.stockmarket.repostories.StockRepository;
import com.stockmarket.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private StockRepository stockRepository;


	@Override
	public String findAll() throws JsonProcessingException {
		List<Company> l = companyRepository.findAll();
		ObjectMapper mapper = new ObjectMapper();
		String newJsonData = mapper.writeValueAsString(l);
		log.info("The obtained details "+ newJsonData);
		return newJsonData;

	}

	@Override
	public ResponseEntity<Object> findStockprice(long companyCode) {
		log.info("Finding the stock Price for"+companyCode);
		float price = stockRepository.findstockprice(companyCode);
		log.info("The stock Price for"+companyCode+"is"+price);
		Company updatedcmpy = companyRepository.findById(companyCode).get();
		return ResponseHandler.generateFetchResponse(HttpStatus.OK, "Success", updatedcmpy, price);
	}

	@Override
	public ResponseEntity<Object> fetchCompanybasedonID(long companyCode) {
		log.info("Fetching the Company based on ID "+companyCode);
		float price = stockRepository.findstockprice(companyCode);
		Company updatedcmpy = companyRepository.findById(companyCode).get();
		return ResponseHandler.generateFetchResponse(HttpStatus.OK, "Success", updatedcmpy, price);
	}		
	
}