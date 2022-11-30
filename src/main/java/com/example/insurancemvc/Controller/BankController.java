package com.example.insurancemvc.Controller;


import com.example.insurancemvc.Entity.Bank;
import com.example.insurancemvc.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/bank")
@Controller
public class BankController {


    @Autowired
    private BankService bankService;


    @GetMapping("/getall")
    public ModelAndView getAll(){
        return bankService.getAllBankView();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Bank bank){
        bankService.addBank(bank);
        return "redirect:getall";
    }

    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
        bankService.softDeleteBank(id);
        return "redirect:getall";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Bank getOne(Long id){
        return bankService.getBank(id);
    }

}
