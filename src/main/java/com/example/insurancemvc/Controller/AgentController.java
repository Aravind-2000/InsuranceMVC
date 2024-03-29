package com.example.insurancemvc.Controller;


import com.example.insurancemvc.Entity.Agent;
import com.example.insurancemvc.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping("/add")
    public String add(@ModelAttribute Agent agent){
        agentService.addAgent(agent);
        return "redirect:getall";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Agent get(Long id){
        return agentService.getAgent(id);
    }

    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
        agentService.softDeleteAgent(id);
        return "redirect:getall";
    }


}
