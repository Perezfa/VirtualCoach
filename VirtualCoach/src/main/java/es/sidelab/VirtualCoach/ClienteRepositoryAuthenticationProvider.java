package es.sidelab.VirtualCoach;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepositoryAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		
		Cliente cliente=clienteRepository.findByUsuario(arg0.getName());
		
		if(cliente==null){
			throw new BadCredentialsException("User not found");
		}
		String password= (String) arg0.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, cliente.getContraseña())) {
			 throw new BadCredentialsException("Wrong password");
			 }

		
			 return new UsernamePasswordAuthenticationToken(cliente.getUsuario(), password);
			 }

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
