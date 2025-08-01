package com.fss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;  
import com.fss.entities.Client;
public interface ClientRepository extends JpaRepository<Client,Long> {

}
