/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.gl.master.service.vehicleAssignment;

import com.mac.gl.master.model.jobCard.JobCard;
import com.mac.gl.master.model.vehicleAssignment.TVehicleAssignment;
import com.mac.gl.master.repository.jobCard.JobCardRepository;
import com.mac.gl.master.repository.vehicle.VehicleRepository;
import com.mac.gl.master.repository.vehicleAssignment.VehicleAssignmentRepository;
import com.mac.gl.system.exception.DuplicateEntityException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Supervision
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VehicleAssignmentService {
    
    @Autowired
    private VehicleAssignmentRepository vehicleAssignmentRepository;
    
    @Autowired
    private JobCardRepository jobCardRepository;
    
    public List<TVehicleAssignment> findAll() {
        return vehicleAssignmentRepository.findAll();
    }
    
    public TVehicleAssignment saveDetail(TVehicleAssignment vehicleAssignment) {
        List<JobCard> findByBay = jobCardRepository.findByBay(vehicleAssignment.getBay().getIndexNo());
        if (findByBay.isEmpty()) {
            vehicleAssignment.getJobCard().setStatus("On_Going");
            vehicleAssignment.getJobCard().setBay(vehicleAssignment.getBay().getIndexNo());
            jobCardRepository.save(vehicleAssignment.getJobCard());
            List<TVehicleAssignment> updatedObjects = vehicleAssignmentRepository.findTop1ByJobCardIndexNoOrderByInTimeDesc(vehicleAssignment.getJobCard().getIndexNo());
            if (!updatedObjects.isEmpty()) {
                TVehicleAssignment updateVehicleAssignment = updatedObjects.get(0);
                updateVehicleAssignment.setOutTime(vehicleAssignment.getInTime());
                vehicleAssignmentRepository.save(updatedObjects.get(0));
            }
            vehicleAssignment.setIndexNo(0);
            return vehicleAssignmentRepository.save(vehicleAssignment);
            
            
        } else {
            throw new DuplicateEntityException("Already exsisit " + vehicleAssignment.getBay().getIndexNo());
        }
        
    }
    
    public void deleteDetail(Integer indexNo) {
        vehicleAssignmentRepository.delete(indexNo);
    }
//    public List<TVehicleAssignment> findAllByType() {
//       return vehicleAssignmentRepository.findByJobCardStatusNotIn("complete");
//    }
}