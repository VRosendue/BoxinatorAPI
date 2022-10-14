package com.example.demo.keycloak;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class keycloakLogoutHandler implements LogoutHandler {

	 private static final org.jboss.logging.Logger logger = LoggerFactory.logger(keycloakLogoutHandler.class);
	    private final RestTemplate restTemplate;

	    public keycloakLogoutHandler(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    @Override
	    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
	        logoutFromKeycloak((OidcUser) auth.getPrincipal());
	    }

	    private void logoutFromKeycloak(OidcUser user) {
	        String endSessionEndpoint = user.getIssuer() + "/protocol/openid-connect/logout";
	        UriComponentsBuilder builder = UriComponentsBuilder
	          .fromUriString(endSessionEndpoint)
	          .queryParam("id_token_hint", user.getIdToken().getTokenValue());

	        ResponseEntity<String> logoutResponse = restTemplate.getForEntity(builder.toUriString(), String.class);
	        if (logoutResponse.getStatusCode().is2xxSuccessful()) {
	            logger.info("Successfulley logged out from Keycloak");
	        } else {
	            logger.info("Not able to logout");
	        }
	    }
}
