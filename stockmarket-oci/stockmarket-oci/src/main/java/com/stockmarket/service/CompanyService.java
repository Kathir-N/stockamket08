package com.stockmarket.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockmarket.model.Company;
import com.stockmarket.model.Request;


public interface CompanyService 
{

	public void registerCompany(Request reqCompanyobj);

	public void updateCompany(long companyCode, Company company);

	public ResponseEntity<String> deleteCompany(long companyCode);
}
