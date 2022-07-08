package com.stockmarket.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockmarket.constant.Constants;
import com.stockmarket.model.Company;
import com.stockmarket.model.ResponseHandler;
import com.stockmarket.model.Stock;
import com.stockmarket.repostories.CompanyRepository;
import com.stockmarket.repostories.StockRepository;
import com.stockmarket.service.StockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@Slf4j


public class StockController {
	@Autowired
	private StockService stockService;

	@PostMapping(value = "/api/v1.0/market/stock/add/{companyCode}")
	public ResponseEntity<String> addStockPrice(@PathVariable long companyCode, @RequestBody Stock stock) {
		log.info("Registering the Stock Details for the Company",companyCode);
		stockService.addStock(companyCode, stock);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(String.format(Constants.STOCK_CREATED_SUCCESSFULLY, companyCode));
	}

	
	@Operation(summary = Constants.DELETE_COMPANY)
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = Constants.COMPANY_DELETED_SUCCESSFULLY),
	        @ApiResponse(responseCode = "400", description = Constants.REQUEST_VALIDATION_ERROR),
	        @ApiResponse(responseCode = "404", description = Constants.COMPANY_NOT_FOUND)	        
	})


	@DeleteMapping(value = "/api/v1.0/market/company/deletestock/{companyCode}")
	public ResponseEntity<String> deleteCompany(@PathVariable long companyCode) {
		log.info("Deleting the Stock Details for the Company",companyCode);
		stockService.deleteStock(companyCode);
		return ResponseEntity.status(HttpStatus.OK).body(String.format(Constants.COMPANY_DELETED_SUCCESSFULLY, companyCode));
	}


}
