

package com.stockmarket.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockmarket.model.Stock;

public interface StockService 
{

	void addStock(long companyCode, Stock stock);

	void deleteStock(long companyCode);

}