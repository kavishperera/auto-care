/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.report.direct_print;

import com.mac.care_point.master.client.ClientRepository;
import com.mac.care_point.master.client.model.Client;
import com.mac.care_point.master.priceCategory.PriceCategoryRepository;
import com.mac.care_point.master.priceCategory.model.PriceCategory;
import com.mac.care_point.master.sms_message.MSmsDetailsRepository;
import com.mac.care_point.master.sms_message.model.MSmsDetails;
import com.mac.care_point.master.vehicle.VehicleRepository;
import com.mac.care_point.master.vehicle.model.Vehicle;
import com.mac.care_point.service.common.Constant;
import com.mac.care_point.service.job_card.JobCardRepository;
import com.mac.care_point.service.job_card.model.JobCard;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kavish manjitha
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DirectPrintService {

    @Autowired
    private JobCardRepository jobCardRepository;

    @Autowired
    private DirectPrintRepository directPrintRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PriceCategoryRepository priceCategoryRepository;

    public Integer findByJobCard(Integer jobCard) {

        JobCard getJobCardData = jobCardRepository.getOne(jobCard);
        Vehicle vehicleData = vehicleRepository.getOne(getJobCardData.getVehicle());
        Client clientData = clientRepository.getOne(getJobCardData.getClient());
        PriceCategory priceCategoryData = priceCategoryRepository.getOne(getJobCardData.getPriceCategory());

        getJobCardData.getIndexNo();
        vehicleData.getIndexNo();
        clientData.getIndexNo();
        priceCategoryData.getIndexNo();

        List<Object[]> serviceItemByJobCard = directPrintRepository.getServiceItemByJobCard(jobCard);
        List<Object[]> stockItemByJobCard = directPrintRepository.getStockItemByJobCard(jobCard);
        List<Object[]> itemTotalPriceByJobCard = directPrintRepository.getItemTotalPriceByJobCard(jobCard);
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

//        //send sms
        String contactNo = clientData.getMobile();
        String customerName = clientData.getName();
        String branch = "NUGEGODA";
        String vehicelNo = vehicleData.getVehicleNo();
        String amount = "8000.00";
        String branchContactNo = "0112816262";
        sendEstimateSms(contactNo, customerName, branch, vehicelNo, amount, branchContactNo);

//        PrinterService printerService = new PrinterService();
//        String defaultPrinter = printerService.getDefaultPrinter();
//
//        printerService.printString(defaultPrinter, "_______________________________________");
//        printerService.printString(defaultPrinter, "\n CARE POINT - NUGEGODA - Estimate \n");
//        printerService.printString(defaultPrinter, "_______________________________________");
//        printerService.printString(defaultPrinter, "\n VEHICLE NO  - " + vehicleData.getVehicleNo());
//        printerService.printString(defaultPrinter, "\n IN TIME  - " + getJobCardData.getInTime());
//        printerService.printString(defaultPrinter, "\n IN MILEAGE  - " + getJobCardData.getInMileage() + " KM");
//        printerService.printString(defaultPrinter, "\n CUSTOMER  - " + clientData.getName());
//        printerService.printString(defaultPrinter, "\n CUSTOMER CONTACT  - " + clientData.getMobile());
//        printerService.printString(defaultPrinter, "\n VEHICLE TYPE  - " + priceCategoryData.getName() + "\n");
//
//        //CARPETS ORIGINAL
//        if (getJobCardData.getCarepetOriginal() > 0) {
//            printerService.printString(defaultPrinter, " CARPETS ORIGINAL  - " + getJobCardData.getCarepetOriginal() + "\n");
//        }
//        
//        //CARPETS OTHER
//        if (getJobCardData.getCarepetOther() > 0) {
//            printerService.printString(defaultPrinter, " CARPETS OTHER  - " + getJobCardData.getCarepetOther() + "\n");
//        }
//        
//        //CARPETS 3M
//        if (getJobCardData.getCarepet3M() > 0) {
//            printerService.printString(defaultPrinter, " CARPETS 3M  - " + getJobCardData.getCarepet3M() + "\n");
//        }
//       
//        printerService.printString(defaultPrinter, "\n");
//
//        if (serviceItemByJobCard.size() > 0) {
//            printerService.printString(defaultPrinter, "--------------- SERVICE ---------------");
//            for (Object[] objects : serviceItemByJobCard) {
//                printerService.printString(defaultPrinter, "\n" + objects[0]);
//                printerService.printString(defaultPrinter, "\n" + "[" + objects[1] + "]" + "\n");
//                printerService.printString(defaultPrinter, "_______________________________________");
//            }
//            printerService.printString(defaultPrinter, "\n");
//        }
//
//        if (stockItemByJobCard.size() > 0) {
//            printerService.printString(defaultPrinter, "-------------- STOCK ITEM -------------");
//            for (Object[] objects : stockItemByJobCard) {
//                printerService.printString(defaultPrinter, "\n" + objects[0]);
//                printerService.printString(defaultPrinter, "\n" + objects[1] + " - " + objects[2] + " x " + objects[3] + " =  [" + objects[4] + "]" + "\n");
//                printerService.printString(defaultPrinter, "_______________________________________");
//            }
//            printerService.printString(defaultPrinter, "\n");
//        }
//
//        printerService.printString(defaultPrinter, "--------------------------------------- \n");
//        BigDecimal total = BigDecimal.ZERO;
//        for (Object[] objects : itemTotalPriceByJobCard) {
//            printerService.printString(defaultPrinter, objects[0] + "          -  " + objects[1] + "\n");
//            total = total.add(new BigDecimal(objects[1].toString()));
//        }
//
//        printerService.printString(defaultPrinter, "--------------------------------------- \n");
//        printerService.printString(defaultPrinter, "TOTAL AMOUNT : " + total + "\n");
//        printerService.printString(defaultPrinter, "--------------------------------------- \n");
//        printerService.printString(defaultPrinter, "Please remove all your valuble belonging such as money,jewellery, mobile phones etc..,from the vehicle before handing over for services, Carepoint (PVT) Ltd, holds no responsibility whatsoever for any losses of such items. \n \n \n");
//        printerService.printString(defaultPrinter, "");
//        printerService.printString(defaultPrinter, "\n ------------------");
//        printerService.printString(defaultPrinter, "\n Signature");
//        printerService.printString(defaultPrinter, "\n Print Time @ " + formatDate + "\n");
//        printerService.printString(defaultPrinter, "--------------------------------------- \n");
//        printerService.printString(defaultPrinter, "\n");
//        printerService.printString(defaultPrinter, "\n");
//        printerService.printString(defaultPrinter, "\n");
//        printerService.printString(defaultPrinter, "\n");
//        printerService.printString(defaultPrinter, "\n");
//
//        // cut that paper!
//        byte[] cutP = new byte[]{0x1d, 'V', 1};
//
//        printerService.printBytes(defaultPrinter, cutP);
        return 0;
    }

    private String sendEstimateSms(String contactNo, String customerName, String branch, String vehicelNo, String amount, String branchContactNo) {
        final String message
                = "Dear " + customerName + "\n"
                + "Thank you for comming CAREPOINT " + branch + ". Vehicle No " + vehicelNo + " Estimated amout is Rs." + amount + "\n"
                + "For any clarification please contact us on " + branchContactNo + "";

        final String uri = "http://smsserver.svisiontec.com/send_sms.php?api_key=6560957308&number=" + contactNo + "&message=" + message;
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(uri);
        System.out.println(uri);
        System.out.println("+++++++++++++++++++++++++++");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
