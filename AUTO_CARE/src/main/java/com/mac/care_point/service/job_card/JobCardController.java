/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.service.job_card;

import com.mac.care_point.service.job_card.model.JobCard;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kavish Manjitha
 */
@CrossOrigin
@RestController
@RequestMapping("/api/care-point/transaction/job-card")
public class JobCardController {

    @Autowired
    private JobCardService jobCardService;
  
    @RequestMapping(value = "/get-pending-job-cards",method = RequestMethod.GET)
    public List<JobCard> getPendingJobCard(){
        return jobCardService.getPendingJobCard();
    }
    
    @RequestMapping(value = "/save-job-card" , method = RequestMethod.POST)
    public JobCard saveJovCard(@RequestBody JobCard jobCard){
        jobCard.setBranch(1);
        return jobCardService.saveJobCard(jobCard);
    }
    
}