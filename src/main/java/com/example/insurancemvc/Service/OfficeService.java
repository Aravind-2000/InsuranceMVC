package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Agent;
import com.example.insurancemvc.Entity.Company;
import com.example.insurancemvc.Entity.Office;
import com.example.insurancemvc.Entity.OfficeLevelParam;
import com.example.insurancemvc.Repository.CompanyRepository;
import com.example.insurancemvc.Repository.OfficeLevelParamRepo;
import com.example.insurancemvc.Repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class OfficeService {


    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OfficeLevelParamRepo officeLevelParamRepo;


    public ModelAndView getAllView(){
        ModelAndView mav = new ModelAndView("/Office/office-list");
        List<Company> companyList = companyRepository.getValidFlag();
        List<Office> officeList = officeRepository.getAllActiveOffices();
        List<OfficeLevelParam> officeLevelList = officeLevelParamRepo.getAllActiveLevels();
        Office officeObj = new Office();
        mav.addObject("offices", officeList);
        mav.addObject("companys", companyList);
        mav.addObject("officeLevels", officeLevelList);
        mav.addObject("newOffice", officeObj);
        return mav;
    }


    public void addOffice(Office office){
        office.setValidFlag(1);
        officeRepository.save(office);
    }

    public Office getOffice(Long id){
        return officeRepository.findById(id).get();
    }

    public List<Agent> getAgentsByOffice(Long id){
        Office office = officeRepository.getReferenceById(id);
        return office.getAgents();
    }

    public void softDelete(Long id){
        Office office = officeRepository.findById(id).get();
        office.setValidFlag(-1);
        officeRepository.save(office);    
    }
 }
