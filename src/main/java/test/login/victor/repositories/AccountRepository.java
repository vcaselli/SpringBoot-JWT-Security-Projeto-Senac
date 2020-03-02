package test.login.victor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import test.login.victor.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Transactional(readOnly=true)
	Account findByEmail(String email);
}
