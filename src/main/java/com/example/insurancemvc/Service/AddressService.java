package com.example.insurancemvc.Service;


import com.example.insurancemvc.Entity.Address;
import com.example.insurancemvc.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


    public ModelAndView getAllAddress(){
        ModelAndView mav = new ModelAndView("Address/address-list");
        List<Address> addresses = addressRepository.getallValidAddress();
        mav.addObject("addresses", addresses);
        return mav;
    }


    public ModelAndView addPage(){
        ModelAndView mav = new ModelAndView("Address/address-add");
        Address addressObj = new Address();
        mav.addObject("address", addressObj);
        return mav;
    }

    public void addAddress(Address address){
        address.setValidFlag(1);
        addressRepository.save(address);
    }

    public ModelAndView getAddress(Long id){
        ModelAndView mav = new ModelAndView("Address/address-info");
        Address address = addressRepository.getValidAddress(id);
        mav.addObject("address", address);
        return mav;
    }

    public ModelAndView getAddressForUpdate(Long id){
        ModelAndView mav = new ModelAndView("Address/address-add");
        Address address = addressRepository.getValidAddress(id);
        mav.addObject("address", address);
        return mav;
    }

    public void softDeleteAddress(Long id){
        Address address = addressRepository.getValidAddress(id);
        address.setValidFlag(-1);
        addressRepository.save(address);
    }

}
