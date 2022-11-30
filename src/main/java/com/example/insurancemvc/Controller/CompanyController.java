package com.example.insurancemvc.Controller;

import com.example.insurancemvc.Entity.Company;
import com.example.insurancemvc.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    private CompanyService companyService;


    @GetMapping("/getall")
    public ModelAndView getAll(){
        return companyService.getAllCompanysView();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Company company){
        companyService.addCompany(company);
        return "redirect:getall";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Company get(Long id){
        return companyService.getCompany(id);
    }

    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
        companyService.softDelete(id);
        return "redirect:getall";
    }

}
