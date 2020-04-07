package test.login.victor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import test.login.victor.entities.Account;
import test.login.victor.entities.Membros;
import test.login.victor.entities.Tarefas;
import test.login.victor.entities.enums.Perfil;
import test.login.victor.repositories.AccountRepository;
import test.login.victor.repositories.MembrosRepository;
import test.login.victor.repositories.TarefasRepository;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AccountRepository ar;
	
	@Autowired
	private MembrosRepository mp;
	
	@Autowired
	private TarefasRepository tr;
	
	@Override
	public void run(String... args) throws Exception {
		

		Account a2 = new Account(null, "Victor", "victordcporto@gmail.com", pe.encode("123"));
		a2.addPerfil(Perfil.ADMIN);
		
		Account nicole = new Account(null, "nicole", "nicole@gmail.com", pe.encode("123"));

	
		
		ar.saveAll(Arrays.asList(a2,nicole));
	
	}

}
                  