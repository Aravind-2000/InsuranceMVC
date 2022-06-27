package com.example.insurancemvc.Repository;

import com.example.insurancemvc.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select * from address where valid_flag = 1", nativeQuery = true)
    List<Address> getallValidAddress();

    @Query(value = "select * from address where id = :addressid and valid_flag = 1", nativeQuery = true)
    Address getValidAddress(Long addressid);

    @Query(value = "select * from address where to_address like %:key% and valid_flag = 1 " +
            "or city like %:key% and valid_flag = 1 " +
            "or state like %:key% and valid_flag = 1 " +
            "or country like %:key% and valid_flag = 1 or address_type like %:key% and valid_flag = 1 ", nativeQuery = true)
    List<Address> globalSearch(String key);

}
