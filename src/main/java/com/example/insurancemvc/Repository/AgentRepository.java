package com.example.insurancemvc.Repository;

import com.example.insurancemvc.Entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query(value = "select * from agent where valid_flag = 1" , nativeQuery = true)
    List<Agent> getAllValidAgents();

    @Query(value = "select * from agent where id = :agentid and valid_flag = 1", nativeQuery = true)
    Agent getValidAgent(Long agentid);


    @Query(value = "select * from agent where id = :key and valid_flag = 1 ", nativeQuery = true)
    List<Agent> search(String key);

    @Query(value = "select * from agent where valid_flag = -1", nativeQuery = true)
    List<Agent> getAllInvalidAgents();

    @Query(value = "select * from agent where office_id = :officeId and valid_flag = 1", nativeQuery = true)
    List<Agent> getAgentsByOffice(Long officeId);
}
