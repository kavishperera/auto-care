/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.service.common;

/**
 *
 * @author Kavish Manjitha
 */
public interface Constant {

    //common status
    public static final String PENDING_STATUS = "PENDING";
    public static final String APPROVE_STATUS = "APPROVED";
    public static final String CONFIRM_STATUS = "CONFIRMED";
    public static final String FINISHE_STATUS = "FINISHED";
    public static final String DLETED_STATUS = "DELETED";

    //payment types
    public static final String CASH_PAYMENT = "CASH_PAYMENT";
    public static final String CHEQUE_PAYMENT = "CHEQUE_PAYMENT";
    public static final String CARD_PAYMENT = "CARD_PAYMENT";

    //invoice payment
    public static final String INVOICE_CREATE = "INVOICE_CREATE";
    public static final String INVOICE_PAYMENT = "INVOICE_PAYMENT";
    public static final String CUSTOMER_PAYMENT = "CUSTOMER_PAYMENT";
    public static final String GRN_PAYMENT = "GRN_PAYMENT";
    public static final String SUPPLIER_PAYMENT = "SUPPLIER_PAYMENT";

    //t_payment information table - form names
    public static final String INVOICE_FORM = "INVOICE_FORM";
    public static final String GRN_FORM = "GRN_FORM";
    
    //m_stock list
    public static final String MAIN_STOCK = "MAIN_STOCK";
    public static final String FRONT_STOCK = "FRONT_STOCK";
    public static final String BULK_STOCK = "BULK_STOCK";
    
    //TStock transfer type
    public static final String INTERNAL_TRANSFER = "INTERNAL_TRANSFER";
    public static final String EXTERNAL_TRANSFER = "EXTERNAL_TRANSFER";
    
    //TStock Transfer Form
    public static final String BRANCH_TRANSFER_OUT = "BRANCH_TRANSFER_OUT";
    public static final String BRANCH_TRANSFER_IN = "BRANCH_TRANSFER_IN";
    public static final String INTERNAL_TRANSFER_IN = "INTERNAL_TRANSFER_IN";
    public static final String INTERNAL_TRANSFER_OUT = "INTERNAL_TRANSFER_OUT";
    
    
    

}
