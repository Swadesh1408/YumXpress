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
public class StaffDetails {
    private static String staffName;
    private static String staffEmail;
    private static String staffId;

    public StaffDetails() {
    }

    public static String getStaffName() {
        return staffName;
    }

    public static void setStaffName(String staffName) {
        StaffDetails.staffName = staffName;
    }

    public static String getStaffEmail() {
        return staffEmail;
    }

    public static void setStaffEmail(String staffEmail) {
        StaffDetails.staffEmail = staffEmail;
    }

    public static String getStaffId() {
        return staffId;
    }

    public static void setStaffId(String staffId) {
        StaffDetails.staffId = staffId;
    }
    
    
    
}
