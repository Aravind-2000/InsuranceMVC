package com.example.insurancemvc.Controller;

import com.example.insurancemvc.Entity.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.insurancemvc.Entity.Office;
import com.example.insurancemvc.Service.OfficeService;

import java.util.List;

@Controller
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;



    @GetMapping("/getall")
    public ModelAndView getAll(){
        return officeService.getAllView();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Office office){
        officeService.addOffice(office);
        return "redirect:getall";
    }
    

    @GetMapping("/getOne")
    @ResponseBody
    public Office getOne(Long id){
        return officeService.getOffice(id);
    }

    @GetMapping("/getAgents")
    @ResponseBody
    public List<Agent> getAgents(Long id){
        return officeService.getAgentsByOffice(id);
    }



    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
        officeService.softDelete(id);
        return "redirect:getall";
    }
}
