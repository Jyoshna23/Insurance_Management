package com.example.Insurance_Management_Platform.Repositories;

import com.example.Insurance_Management_Platform.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {


}
