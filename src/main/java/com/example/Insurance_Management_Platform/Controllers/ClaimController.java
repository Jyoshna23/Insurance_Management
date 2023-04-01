package com.example.Insurance_Management_Platform.Controllers;

import com.example.Insurance_Management_Platform.DTOs.ClaimDto;
import com.example.Insurance_Management_Platform.Models.Claim;
import com.example.Insurance_Management_Platform.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @PostMapping("/claims")
    public String addClaim(@RequestBody ClaimDto claimDto){
        try{
            return claimService.addClaim(claimDto);
        }catch (Exception e){
            String result = "Claim not added";
            return result;
        }
    }

    @GetMapping("/claims/{id}")
    public Claim getClaimById(@PathVariable int id){
        return claimService.getClaimById(id);
    }


    @GetMapping("/get_all_claims")
    public List<Claim> getAllClaims(){
        return claimService.getAllClaims();
    }

    @DeleteMapping("/claims/{id}")
    public String deleteClaim(@PathVariable int id){
        try{
            return claimService.deleteClaim(id);
        }catch (Exception e){
            String response = "Unfortunately, Your Claim is not deleted!";
            return response;
        }
    }
}
