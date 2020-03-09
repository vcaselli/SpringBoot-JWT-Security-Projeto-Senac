package test.login.victor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.login.victor.entities.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{

}
