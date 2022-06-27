package com.example.insurancemvc.Repository;


import com.example.insurancemvc.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select * from client where valid_flag = 1", nativeQuery = true)
    List<Client> getallValidClients();

    @Query(value = "select * from client where id = :clientid and valid_flag = 1 ", nativeQuery = true)
    Client getClientById(Long clientid);

    @Query(value = "select * from client where id like %:key% and valid_flag = 1 or given_name like %:key% and valid_flag = 1 or sur_name like %:key% and valid_flag = 1 or mobile_number like %:key%  and valid_flag = 1 or language like %:key% and valid_flag = 1  or marrital_status like %:key% " +
            "and valid_flag = 1", nativeQuery = true )
    List<Client> globalSearch(String key);
}
