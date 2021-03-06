/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.service.invoice.invoice;

import com.mac.care_point.service.invoice.invoice.model.TPaymentInformation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kavish Manjitha
 */
public interface PaymentInformationRepostory extends JpaRepository<TPaymentInformation, Integer>{

    public List<TPaymentInformation> findByPayment(Integer indexNo);
    
}
