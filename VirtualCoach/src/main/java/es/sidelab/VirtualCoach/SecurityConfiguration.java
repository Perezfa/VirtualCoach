package es.sidelab.VirtualCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	private ClienteRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Páginas publicas

		http.authorizeRequests().antMatchers("/","/login","/assets/**", "/rating", "/usuario_no_encontrado","/registro_nuevo","/contraseña_erronea", "/mostrarestadisticasgoogle").permitAll();

		//Todas las demas son privadas
		http.authorizeRequests().anyRequest().authenticated();
		
	    http.formLogin().loginPage("/login");
	    http.formLogin().usernameParameter("username");
	    http.formLogin().passwordParameter("password");
	    http.formLogin().defaultSuccessUrl("/dashboard");
	    http.formLogin().failureUrl("/usuario_no_encontrado");

	    // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

	}
	
	
	//Si queremos poner administradores
			@Override
			 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				
				// Users
				 auth.inMemoryAuthentication().withUser("user").password("pass")
				 .roles("USER");

				 auth.inMemoryAuthentication().withUser("admin").password("adminpass")
				 .roles("USER", "ADMIN");

		 }
	
	 
	

}
