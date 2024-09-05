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
public class OwnerDetails {
    private static String ownerName,companyName,companyId;

    public static String getOwnerName() {
        return ownerName;
    }

    public static void setOwnerName(String ownerName) {
        OwnerDetails.ownerName = ownerName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        OwnerDetails.companyName = companyName;
    }

    public static String getCompanyId() {
        return companyId;
    }

    public static void setCompanyId(String companyId) {
        OwnerDetails.companyId = companyId;
    }
    
    
}
