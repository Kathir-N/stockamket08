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


}