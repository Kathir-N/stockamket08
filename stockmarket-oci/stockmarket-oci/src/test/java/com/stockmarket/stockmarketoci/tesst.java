package com.stockmarket.stockmarketoci;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.stockmarket.controller.CompanyController;
import com.stockmarket.model.Request;
import com.stockmarket.service.CompanyService;


@RunWith(MockitoJUnitRunner.class)
public class tesst 
{
	@InjectMocks
	CompanyController companyController;
	
	@Mock
	CompanyService companyService;
	
	
	

	@Test
	public void addAccountDetailsTest()
	{
		Request req=new Request();
		req.getCompany().setCompanyCeO("CTS");
		Mockito.when(externalDetailService.addDetails(req)).thenReturn(response);	
		obj.addAccountDetails("token", req);
	}
	
	
	
	
	
	
	
	
	
//	@Test
//	public void fetchAccountDetailsTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		ExternalDetailsResponse response=new ExternalDetailsResponse();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Valid");
//		Mockito.when(externalDetailService.fetchDetails(req)).thenReturn(response);
//		obj.fetchAccountDetails("token", req);
//	}
//	
//	
//	@Test
//	public void fetchSessionExpiredTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
//		obj.fetchAccountDetails("token", req);
//	}
//	
//	@Test
//	public void updateSessionExpiredTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
//		obj.updateAccountDetails("token", req);
//	}
//	
//	@Test
//	public void updateAccountDetailsTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		ExternalDetailsResponse response=new ExternalDetailsResponse();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is valid");
//		Mockito.when(externalDetailService.updateDetails(req)).thenReturn(response);	
//		obj.updateAccountDetails("token", req);
//	}
//	
//	@Test
//	public void deleteSessionExpiredTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
//		obj.deleteAccountDetails("token", req);
//	}
//	
//	@Test
//	public void deleteAccountDetailsTest()
//	{
//		ExternalDetailsRequest req=new ExternalDetailsRequest();
//		ExternalDetailsResponse response=new ExternalDetailsResponse();
//		req.setCustomer_id(123);
//		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is valid");
//		Mockito.when(externalDetailService.deleteDetails(req)).thenReturn(response);	
//		obj.deleteAccountDetails("token", req);
//	}
}