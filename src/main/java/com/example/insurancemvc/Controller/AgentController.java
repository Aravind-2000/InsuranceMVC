package com.example.insurancemvc.Controller;


import com.example.insurancemvc.Entity.Agent;
import com.example.insurancemvc.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;



    @GetMapping("/getall")
    public ModelAndView getAll(){
        return agentService.getAllAgents();
    }

    @GetMapping("/addpage")
    public ModelAndView addPage(){
        return agentService.addPage();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Agent agent){
        agentService.addAgent(agent);
        return "redirect:/agent/getall";
    }


}
