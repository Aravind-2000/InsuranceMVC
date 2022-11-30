package com.example.insurancemvc.Repository;

import com.example.insurancemvc.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {


    @Query(value = "select * from bank where valid_flag = 1", nativeQuery = true)
    List<Bank> getAllActiveAccounts();

    @Query(value = "select * from bank where id = :bankid and valid_flag = 1", nativeQuery = true)
    Bank getActiveBankAccount(Long bankid);

    @Query(value = "select * from bank where account_number like %:key% and valid_flag = 1 " +
            "or account_holder_name like %:key% and valid_flag = 1" +
            "or bank_name like %:key% and valid_flag = 1" +
            "or ifsc_code like %:key% and valid_flag = 1 or bank_branch like %:key% and valid_flag = 1 ", nativeQuery = true)
    List<Bank> globalSearch(String key);

}
