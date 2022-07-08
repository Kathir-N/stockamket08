package com.stockmarket.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stockmarket.model.Company;
import com.stockmarket.model.Stock;
import com.stockmarket.repostories.CompanyRepository;
import com.stockmarket.repostories.StockRepository;
import com.stockmarket.service.StockService;

import lombok.extern.slf4j.Slf4j;

@Slf4j


@Service

public class StockServiceImpl implements StockService 
{
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private CompanyRepository companyRepository;

	public void addStock(long companyCode, Stock stock) {
		stock.setDate(new Date());
		Company updatedcmpy = companyRepository.findById(companyCode).get();
		stock.setCompany(updatedcmpy);
		log.info("Saving StockInfo - {}");
		stockRepository.save(stock);
		
	}

	@Override
	public void deleteStock(long companyCode) {
		Stock deletecompany = stockRepository.findbycompId(companyCode);
		if((deletecompany.getCompany()==null)) {
			log.info("Stock Info is not available for Company ID - {}", companyCode);
		}else {
			log.info("Deleting Stock Info for CompanyID - {}", companyCode);
			stockRepository.delete(deletecompany);
			
		}

	}
}