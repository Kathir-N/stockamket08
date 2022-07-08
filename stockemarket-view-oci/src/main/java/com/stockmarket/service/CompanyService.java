package com.stockmarket.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockmarket.model.Company;
import com.stockmarket.model.Request;


public interface CompanyService 
{
	public String findAll() throws JsonProcessingException;

	public ResponseEntity<Object> findStockprice(long companyCode);

	public ResponseEntity<Object> fetchCompanybasedonID(long companyCode);

}
