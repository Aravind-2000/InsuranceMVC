package com.example.insurancemvc.Repository;

import com.example.insurancemvc.Entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Long> {

    @Query(value = "select * from office where valid_flag = 1 ", nativeQuery = true)
    List<Office> getAllActiveOffices();

    @Query(value = "select * from office  where up_level_office_id = :id", nativeQuery = true)
    List<Office> getUpLevel(Long id);

    @Query(value = "select * from office  where office_level_id = :id", nativeQuery = true)
    List<Office> getByOfficeLevel(Long id);

    @Query(value = "select * from office where office_id like %:key% and valid_flag = 1 " +
            "or office_name like %:key% and valid_flag = 1 " , nativeQuery = true)
    List<Office> globalSearch(String key);

}
