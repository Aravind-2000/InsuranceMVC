package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Company;
import com.example.insurancemvc.Repository.CompanyRepository;
import com.example.insurancemvc.Repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CompanyService {


    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ParameterRepository parameterRepository;



    public ModelAndView getAllCompanysView(){
        ModelAndView mav = new ModelAndView("/Company/company-list");
        List<Company> companyList = companyRepository.getValidFlag();
        List<String> currencyList = parameterRepository.getParameterWithRule("CR001");
        Company companyObj = new Company();
        mav.addObject("companys", companyList);
        mav.addObject("currencies", currencyList);
        mav.addObject("newCompany", companyObj);
        return mav;
    }

    public void addCompany(Company company){
        company.setValidFlag(1);
        companyRepository.save(company);
    }

    public Company getCompany(Long id){
        return companyRepository.findById(id).get();
    }


    public void softDelete(Long id){
       Company company =  companyRepository.findById(id).get();
       company.setValidFlag(-1);
       companyRepository.save(company);
    }

}
