package com.example.insurancemvc.Repository;

import com.example.insurancemvc.Entity.OfficeLevelParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeLevelParamRepo extends JpaRepository<OfficeLevelParam, Long> {


    @Query(value = "select * from office_level_param where valid_flag = 1", nativeQuery = true)
    List<OfficeLevelParam> getAllActiveLevels();

}
