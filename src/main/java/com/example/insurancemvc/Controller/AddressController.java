package com.example.insurancemvc.Controller;


import com.example.insurancemvc.Entity.Address;
import com.example.insurancemvc.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getall")
    public ModelAndView getAll(){
        return addressService.getAllAddress();
    }

    @GetMapping("/addPage")
    public ModelAndView addPage(){
        return addressService.addPage();
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Address address){
        addressService.addAddress(address);
        return "redirect:getall";
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Address getOne(Long id){
        return addressService.getAddressOne(id);
    }



    @GetMapping("/updatePage/{id}")
    public ModelAndView updatePage(@PathVariable Long id){
        return addressService.getAddressForUpdate(id);
    }

    @GetMapping("/softDelete")
    public String softDelete(@RequestParam Long id){
         addressService.softDeleteAddress(id);
         return "redirect:getall";
    }

}
