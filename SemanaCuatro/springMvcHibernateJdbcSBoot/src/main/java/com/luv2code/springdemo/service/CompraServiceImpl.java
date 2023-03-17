package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.entity.Compra;

@Service
public class CompraServiceImpl implements CompraService {
	
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public CompraServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Compra> getCompras() {

		logger.info("in getCompras(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Compra>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Compra>>() {
				});
		//Compra theCompra = restTemplate.getForObject(crmRestUrl + "/" + theId, Compra.class);

		// get the list of customers from response

		List<Compra> compras = responseEntity.getBody();

		logger.info("in getCompras(): customers" + compras);

		return compras;

	}

	@Override
	public void saveCompra(Compra theCompra) {

		logger.info("in saveCompra(): Calling REST API " + crmRestUrl);

		int compraId = theCompra.getIdcompra();
		// make REST call

		if (compraId == 0) {
			// add Compra
			restTemplate.postForEntity(crmRestUrl, theCompra, String.class);
		} else {
			// update Compra 
			restTemplate.put(crmRestUrl, theCompra);
		}

		logger.info("in saveCompra(): success");
		

	}

	@Override
	public Compra getCompra(int theId) {

		logger.info("in getCompra(): Calling REST API " + crmRestUrl);

		// make REST call

		Compra theCompra = restTemplate.getForObject(crmRestUrl + "/" + theId, Compra.class);

		logger.info("in saveCompra(): theCompra=" + theCompra);

		return theCompra;
	}

	@Override
	public void deleteCompra(int theId) {
		
		logger.info("in deleteCompra(): Calling REST API " + crmRestUrl);

		// make REST call

		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteCompra(): deleted Compra theId="+ theId);

	}
}





