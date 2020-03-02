package test.login.victor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import test.login.victor.entities.Account;
import test.login.victor.entities.enums.Perfil;
import test.login.victor.repositories.AccountRepository;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AccountRepository ar;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Account a = new Account(null, "victor", "victor@gmail.com", pe.encode("victor"));
		Account a2 = new Account(null, "Marcos", "victordcporto@gmail.com", pe.encode("112"));
		a2.addPerfil(Perfil.ADMIN);

		ar.saveAll(Arrays.asList(a,a2));
		
	}

}
