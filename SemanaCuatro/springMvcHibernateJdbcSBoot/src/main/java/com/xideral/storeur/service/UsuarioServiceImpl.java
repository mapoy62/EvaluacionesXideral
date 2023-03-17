package com.xideral.storeur.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xideral.storeur.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public UsuarioServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Usuario> getUsuarios() {

		logger.info("in getUsuario(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Usuario>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Usuario>>() {
				});

		// get the list of customers from response

		List<Usuario> usuarios = responseEntity.getBody();

		logger.info("in getUsuarios(): customers" + usuarios);

		return usuarios;

	}

	@Override
	public void saveUsuario(Usuario theUsuario) {

		logger.info("in saveUsuario(): Calling REST API " + crmRestUrl);

		int usuarioId = theUsuario.getIdusuario();
		// make REST call

		if (usuarioId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theUsuario, String.class);
		} else {
			// update employee 
			restTemplate.put(crmRestUrl, theUsuario);
		}

		logger.info("in saveUsuario(): success");
		

	}

	@Override
	public Usuario getUsuario(int theId) {

		logger.info("in getUsuario(): Calling REST API " + crmRestUrl);

		// make REST call

		Usuario theUsuario = restTemplate.getForObject(crmRestUrl + "/" + theId, Usuario.class);

		logger.info("in saveUsuario(): theUsuario=" + theUsuario);

		return theUsuario;
	}

	@Override
	public void deleteUsuario(int theId) {
		
		logger.info("in deleteUsuario(): Calling REST API " + crmRestUrl);

		// make REST call

		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteUsuario(): deleted usuario theId="+ theId);

	}
}





