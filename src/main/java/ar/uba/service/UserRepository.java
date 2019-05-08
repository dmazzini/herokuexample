package ar.uba.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.uba.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
