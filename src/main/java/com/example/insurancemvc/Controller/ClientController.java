package com.example.insurancemvc.Controller;


import com.example.insurancemvc.Entity.Client;
import com.example.insurancemvc.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {


    @Autowired
    private ClientService clientService;


    @GetMapping("/getall")
    public ModelAndView getAll(){
        return clientService.getAllClientView();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Client client){
        clientService.addClient(client);
        return "redirect:getall";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Client get(Long id){
        return clientService.getClient(id);
    }

    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
        clientService.softDelete(id);
        return "redirect:getall";
    }


}
