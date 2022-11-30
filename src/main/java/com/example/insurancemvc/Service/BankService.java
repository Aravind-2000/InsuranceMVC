package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Bank;
import com.example.insurancemvc.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class BankService {


    @Autowired
    private BankRepository repository;



    public ModelAndView getAllBankView(){
        ModelAndView mav = new ModelAndView("/Bank/bank-list");
        List<Bank> bankList = repository.getAllActiveAccounts();
        Bank bankObj = new Bank();
        mav.addObject("banks", bankList);
        mav.addObject("newBank", bankObj);
        return mav;
    }

    public Bank getBank(Long id){
        return repository.findById(id).get();
    }

    public void addBank(Bank bank){
        bank.setValidFlag(1);
        repository.save(bank);
    }


    public void softDeleteBank(Long id){
        Bank bank = repository.getActiveBankAccount(id);
        bank.setValidFlag(-1);
        repository.save(bank);
    }

}
