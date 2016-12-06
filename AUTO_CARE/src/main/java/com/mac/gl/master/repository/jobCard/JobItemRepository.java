/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.gl.master.repository.jobCard;

import com.mac.gl.master.model.jobCard.JobCard;
import com.mac.gl.master.model.jobCard.TJobItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Don
 */
public interface JobItemRepository extends JpaRepository<TJobItem, Integer> {

    public List<TJobItem> findByJobCard(JobCard jobCard);
}