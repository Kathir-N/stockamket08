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
	public void registerCompany(Request reqCompanyobj) {
		Company registration = reqCompanyobj.getCompany();
		log.info("Saving ComanyInfo - {}");
		companyRepository.save(registration);
	}

	@Override
	public void updateCompany(long companyCode,Company company) {
		Company updatedcmpy = companyRepository.findById(companyCode).get();
		updatedcmpy.setCompanyCeO(company.getCompanyCeO());
		updatedcmpy.setCompanyName(company.getCompanyName());
		updatedcmpy.setCompanyWebsite(company.getCompanyWebsite());
		updatedcmpy.setStockExchange(company.getStockExchange());
		updatedcmpy.setTurnOver(company.getTurnOver());
		log.info("Updating ComanyInfo - {}", updatedcmpy);
		companyRepository.save(updatedcmpy);		
	}

	@Override
	public ResponseEntity<String> deleteCompany(long companyCode) {
		Company updatedcmpy = companyRepository.findById(companyCode).get();
		if(updatedcmpy.equals(null))
		{
			log.info("Company Info is not available for ID - {}", companyCode);
		}
		else 
		{
		log.info("Deleting Company Info form Stock - {}", companyCode);
		stockRepository.deleteBycmpID(updatedcmpy.getCompanyCode());
		log.info("Deleting Company Info for Company - {}", companyCode);
		companyRepository.delete(updatedcmpy);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(String.format(Constants.COMPANY_DELETED_SUCCESSFULLY, companyCode));		

	}

}