/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

/**
 *
 * @author Swadesh Sharma
 */
public class CustomerPojo {

    private String customerId;
    private String customerName;
    private String customerEmailId;
    private String customerPass;
    private String customerMobile;
    private String customerAddress;
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerPass() {
        return customerPass;
    }

    public void setCustomerPass(String customerPass) {
        this.customerPass = customerPass;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerPojo() {
    }

    public CustomerPojo(String customerId, String customerName, String customerEmailId, String customerPass, String customerMobile, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmailId = customerEmailId;
        this.customerPass = customerPass;
        this.customerMobile = customerMobile;
        this.customerAddress = customerAddress;
    }
    
    
}
