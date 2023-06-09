package com.example.Insurance_Management_Platform.Controllers;

import com.example.Insurance_Management_Platform.DTOs.InsurancePolicyRequestDto;
import com.example.Insurance_Management_Platform.Models.InsurancePolicy;
import com.example.Insurance_Management_Platform.Service.InsurancePolicyService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    @PostMapping("/policies")
    public String addInsurancePolicy(@RequestBody InsurancePolicyRequestDto insurancePolicyRequestDto){
        try{
            return insurancePolicyService.addInsurancePolicy(insurancePolicyRequestDto);
        }catch (Exception e){
            String response = "policy not added";
            return response;
        }
    }

    //API to fetch policy by id.
    @GetMapping("/policies/{id}")
    public InsurancePolicy getPolicyById(@PathVariable int id){
        return insurancePolicyService.getPolicyById(id);
    }

    //Api to fetch all policies
    @GetMapping("/get_all_policies")
    public List<InsurancePolicy> getAllPolicies(){
        return insurancePolicyService.getAllPolicies();
    }

    //API to delete a policy by id
    @DeleteMapping("/policies/{id}")
    public String deletePolicy(@PathVariable int id){
        try{
            return insurancePolicyService.deletePolicy(id);
        }catch(Exception e){
            String response = "policy not deleted";
            return response;
        }
    }
}
