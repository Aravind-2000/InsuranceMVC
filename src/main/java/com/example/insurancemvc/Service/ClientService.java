package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Address;
import com.example.insurancemvc.Entity.Bank;
import com.example.insurancemvc.Entity.Client;
import com.example.insurancemvc.Repository.AddressRepository;
import com.example.insurancemvc.Repository.BankRepository;
import com.example.insurancemvc.Repository.ClientRepository;
import com.example.insurancemvc.Repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BankRepository bankRepository;


    @Autowired
    private ParameterRepository parameterRepository;



    public ModelAndView getAllClientView(){
        ModelAndView mav = new ModelAndView("/Client/client-list");
        List<Client> clients = clientRepository.getallValidClients();
        List<Address> addresses = addressRepository.getallValidAddress();
        List<Bank> banks = bankRepository.getAllActiveAccounts();
        Client clientObj = new Client();
        List<String> genders = parameterRepository.getParameterWithRule("G0001");
        List<String> salutations = parameterRepository.getParameterWithRule("G0002");
        List<String> relationshipsStatus = parameterRepository.getParameterWithRule("R0001");
        List<String> occupation = parameterRepository.getParameterWithRule("W0001");
        mav.addObject("clients", clients);
        mav.addObject("addresses", addresses);
        mav.addObject("banks", banks);
        mav.addObject("newClient", clientObj);
        mav.addObject("genders", genders);
        mav.addObject("salutations", salutations);
        mav.addObject("relationships", relationshipsStatus);
        mav.addObject("occupations", occupation);
        return mav;
    }


    public Client getClient(Long id){
        return  clientRepository.findById(id).get();
    }

    public void addClient(Client client){
        client.setValidFlag(1);
        clientRepository.save(client);
    }

    public void softDelete(Long id){
        Client client = clientRepository.getClientById(id);
        client.setValidFlag(-1);
        clientRepository.save(client);
    }

}
