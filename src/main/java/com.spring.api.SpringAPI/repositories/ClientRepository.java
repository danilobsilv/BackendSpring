package com.spring.api.SpringAPI.repositories;

import com.spring.api.SpringAPI.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // repositories are responsible for interacting with the database
public interface ClientRepository extends JpaRepository<Client, Long> {

}
