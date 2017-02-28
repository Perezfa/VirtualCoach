package es.sidelab.VirtualCoach;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		//Páginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		//Todas las demas son privadas
		http.authorizeRequests().anyRequest().authenticated();
		
	    http.formLogin().loginPage("/");
	    http.formLogin().usernameParameter("username");
	    http.formLogin().passwordParameter("password");
	    http.formLogin().defaultSuccessUrl("/dashboard");
	    http.formLogin().failureUrl("/usuario_no_encontrado");

		
	}
	

}
