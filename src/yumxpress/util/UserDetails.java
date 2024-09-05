/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

/**
 *
 * @author Swadesh Sharma
 */
public class UserDetails {
    private static String custName, custEmailId, custId;

    public static String getCustName() {
        return custName;
    }

    public static void setCustName(String custName) {
        UserDetails.custName = custName;
    }

    public static String getCustEmailId() {
        return custEmailId;
    }

    public static void setCustEmailId(String custEmailId) {
        UserDetails.custEmailId = custEmailId;
    }

    public static String getCustId() {
        return custId;
    }

    public static void setCustId(String custId) {
        UserDetails.custId = custId;
    }
    
}
