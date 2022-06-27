package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Agent;
import com.example.insurancemvc.Entity.Client;
import com.example.insurancemvc.Repository.AgentRepository;
import com.example.insurancemvc.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ClientRepository clientRepository;


    public ModelAndView getAllAgents(){
        ModelAndView mav = new ModelAndView("Agent/agent-list");
        List<Agent> agentList  = agentRepository.getAllValidAgents();
        mav.addObject("agents", agentList);
        return mav;
    }

    public ModelAndView addPage(){
        ModelAndView mav = new ModelAndView("Agent/agent-add");
        Agent newAgent = new Agent();
        mav.addObject("agent", newAgent);
        List<Client> clientList = clientRepository.getallValidClients();
        mav.addObject("clients", clientList);
        return mav;
    }

    public void addAgent(Agent agent){
        agent.setValidFlag(1);
        agentRepository.save(agent);
    }



}
