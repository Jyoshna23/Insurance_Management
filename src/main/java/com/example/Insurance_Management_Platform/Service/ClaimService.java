package com.example.Insurance_Management_Platform.Service;

import com.example.Insurance_Management_Platform.DTOs.ClaimDto;
import com.example.Insurance_Management_Platform.Models.Claim;
import com.example.Insurance_Management_Platform.Models.InsurancePolicy;
import com.example.Insurance_Management_Platform.Repositories.ClaimRepository;
import com.example.Insurance_Management_Platform.Repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public String addClaim(ClaimDto claimDto){

        Claim claim = new Claim();
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimNumber(claimDto.getClaimNumber());
        claim.setClaimStatus(claimDto.getClaimStatus());
        claim.setDescription(claimDto.getDescription());


        int policyId = claimDto.getPolicyId();
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(policyId).get();

        claim.setPolicy(insurancePolicy);
        claimRepository.save(claim);
        return "Claim added successfully";
    }

    public Claim getClaimById(int id){
        Claim claim = claimRepository.findById(id).get();
        return claim;
    }

    public List<Claim> getAllClaims(){
        List<Claim> claimsList = claimRepository.findAll();
        return claimsList;
    }

    public String deleteClaim(int id){
        Claim claim = claimRepository.findById(id).get();
        claimRepository.delete(claim);
        return "Successfully deleted a claim";
    }
}
