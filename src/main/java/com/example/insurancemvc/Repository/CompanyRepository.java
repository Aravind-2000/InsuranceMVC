package com.example.insurancemvc.Repository;

import java.util.List;

import com.example.insurancemvc.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query(value = "select * from company where valid_flag = 1", nativeQuery = true)
    List<Company> getValidFlag();

    @Query(value = "select * from company where id = :id and valid_flag = 1", nativeQuery = true)
    Company getCompany(Long id);

    @Query(value = "select * from company where company_name like %:key% and valid_flag = 1 " +
            "or company_country like %:key% and valid_flag = 1 " +
            "or company_license_number like %:key% and valid_flag = 1 " +
            "or company_currency like %:key% and valid_flag = 1 ", nativeQuery = true)
    List<Company> globalSearch(String key);
}
