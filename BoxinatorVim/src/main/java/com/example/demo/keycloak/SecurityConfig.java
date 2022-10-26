package com.example.demo.keycloak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.cors().and()
			.sessionManagement().disable()
			.csrf().disable()
			.authorizeHttpRequests(authorize -> authorize
					.mvcMatchers("/v1/Users").hasAuthority("Users")
					.mvcMatchers("/v1/Shipments").hasAuthority("Users")
					.mvcMatchers("/v1/Countries").hasAuthority("Users")
					.anyRequest().authenticated()
					)
			.oauth2ResourceServer()
			.jwt()
			.jwtAuthenticationConverter(jwtRoleAuthenticationConverter());
		return http.build();
	}
	
	@Bean
	public JwtAuthenticationConverter jwtRoleAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
		grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
		return jwtAuthenticationConverter;
	}
    
}
