package br.com.giovanni.Checkpoint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.giovanni.Checkpoint2.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
