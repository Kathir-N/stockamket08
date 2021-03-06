package com.stockmarket.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

@RestController

public class StockController {
	@Autowired
	private StockRepository stockRepository;

	@GetMapping(value = "/api/v1.0/market/company/{companyCode}/{fromdate}/{enddate}")
	public ResponseEntity<Object> getStockBasedonDate(@PathVariable long companyCode, @PathVariable String fromdate,
			@PathVariable String enddate) throws ParseException {
		System.out.println(fromdate);
		System.out.println(enddate);

		LocalDate sdate = LocalDate.parse(fromdate);
		Date startdate = java.sql.Date.valueOf(sdate);

		LocalDate edate = LocalDate.parse(enddate);
		Date finaldate = java.sql.Date.valueOf(edate);
		List<Double> list = new ArrayList<>();

		try {
			List<Stock> stockdetials = stockRepository.findByDateandDate(companyCode, startdate, finaldate);
			if (stockdetials != null) {

				for (Stock s : stockdetials) {
					list.add(s.getStockPrice());
					System.out.println(s.getStockPrice());
				}

				double highestNumber = Collections.max(list);
				double lowestn = Collections.min(list);

				System.out.println(highestNumber);
				System.out.println(lowestn);

				double avg = list.stream().mapToDouble(d -> d).average().orElse(0.0);

				return ResponseHandler.generateResponse(HttpStatus.OK, "Success", stockdetials, highestNumber, lowestn,
						avg);
			}

			else {
				return ResponseHandler.generateErrorResponse(HttpStatus.BAD_REQUEST, "No Stock Deatils", null);

			}
		} catch (Exception e) {
			return ResponseHandler.generateErrorResponse(HttpStatus.BAD_REQUEST, "Failed", e.getCause());
		}

	}

}
