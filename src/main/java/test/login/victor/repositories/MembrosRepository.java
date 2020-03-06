package test.login.victor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.login.victor.entities.Membros;

public interface MembrosRepository extends JpaRepository<Membros, Long> {

}
