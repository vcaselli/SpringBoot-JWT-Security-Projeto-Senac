package test.login.victor.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import test.login.victor.entities.Account;
import test.login.victor.entities.Membros;
import test.login.victor.entities.enums.Perfil;
import test.login.victor.repositories.AccountRepository;
import test.login.victor.repositories.MembrosRepository;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private AccountRepository ar;
	
	@Autowired
	private MembrosRepository mp;
	
	@Override
	public void run(String... args) throws Exception {
		Membros m2 = new Membros();
		m2.setNome("Onélia");
		m2.setParentesco("Mãe");
		Membros m = new Membros();
		m.setNome("Victor");
		m.addPerfil(Perfil.CLIENTE);
		m.setParentesco("Filho");
		m.setNascimento("25/01/1995");
		m.setSexo("Masculino");
		m.setPontuacao(50.0);
		Account a = new Account(null, "victor", "victor@gmail.com", pe.encode("victor"));
		Account a2 = new Account(null, "Marcos", "victordcporto@gmail.com", pe.encode("112"));
		a2.addPerfil(Perfil.ADMIN);

		a.getMembros().add(m);
		a2.getMembros().add(m2);
		m.setAccount(a);
		m2.setAccount(a2);
		
		
		ar.saveAll(Arrays.asList(a,a2));
		mp.saveAll(Arrays.asList(m,m2));
	}

}
