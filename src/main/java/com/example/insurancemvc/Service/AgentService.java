package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Agent;
import com.example.insurancemvc.Entity.Client;
import com.example.insurancemvc.Entity.Office;
import com.example.insurancemvc.Repository.AgentRepository;
import com.example.insurancemvc.Repository.ClientRepository;
import com.example.insurancemvc.Repository.OfficeRepository;
import com.example.insurancemvc.Repository.ParameterRepository;
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

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private ParameterRepository parameterRepository;


    public ModelAndView getAllAgents(){
        ModelAndView mav = new ModelAndView("Agent/agent-list");
        List<Agent> agentList  = agentRepository.getAllValidAgents();
        mav.addObject("agents", agentList);
        Agent newAgent = new Agent();
        mav.addObject("agent", newAgent);
        List<Client> clientList = clientRepository.getallValidClients();
        mav.addObject("clients", clientList);
        List<Office> officeList = officeRepository.getAllActiveOffices();
        mav.addObject("offices", officeList);
        List<String> exclusivesList = parameterRepository.getParameterWithRule("EX001");
        mav.addObject("exclusives", exclusivesList);
        List<String> payMethodList = parameterRepository.getParameterWithRule("PM001");
        List<String> payFrequencyList = parameterRepository.getParameterWithRule("PF001");
        List<String> currencyList = parameterRepository.getParameterWithRule("CR001");
        mav.addObject("paymethods", payMethodList);
        mav.addObject("payFrequencies", payFrequencyList);
        mav.addObject("currencies", currencyList);
        return mav;
    }


    public void addAgent(Agent agent){
        agent.setValidFlag(1);
        agentRepository.save(agent);
    }

    public Agent getAgent(Long id){
        return agentRepository.getReferenceById(id);
    }

    public void softDeleteAgent(Long id){
        Agent agent = agentRepository.getReferenceById(id);
        agent.setValidFlag(-1);
        agentRepository.save(agent);
    }



}
