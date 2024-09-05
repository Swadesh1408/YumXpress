/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static yumxpress.dao.StaffDao.getNewStaffId;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.CompanyPojo;
import yumxpress.pojo.CustomerPojo;
import yumxpress.util.PasswordEncryption;

/**
 *
 * @author Swadesh Sharma
 */
public class CustomerDao {
    public static String getNewCustId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(customer_id) from customers");
        rs.next();
        String id=rs.getString(1);
        String custId="";
        if(id!=null){
            id=id.substring(4);
            custId="CUS-"+(Integer.parseInt(id)+1);
        }else{
            custId="CUS-101";
        }
        return custId;
    }
    
    public static boolean addCustomer(CustomerPojo customer)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="insert into customers values(?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        customer.setCustomerId(getNewCustId());
        ps.setString(1,customer.getCustomerId());
        ps.setString(2,customer.getCustomerName());
        ps.setString(3,customer.getCustomerEmailId());
        ps.setString(4,customer.getCustomerPass());
        ps.setString(5,customer.getCustomerMobile());
        ps.setString(6,customer.getCustomerAddress());
        return (ps.executeUpdate()==1);
    }
    
    public static CustomerPojo validate(String emailId, String password)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from customers where email_id=? and password=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, emailId);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        CustomerPojo customer=null;
        if(rs.next()){
            customer=new CustomerPojo();
            customer.setCustomerId(rs.getString(1));
            customer.setCustomerName(rs.getString(2));
            customer.setCustomerEmailId(emailId);
        }
       return customer;
         
    }
    public static CustomerPojo getCustomerDetailsByCustomerId(String customerId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from customers where customer_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, customerId);
        ResultSet rs=ps.executeQuery();
        CustomerPojo customer=null;
        if(rs.next()){
            customer=new CustomerPojo();
            String pass=rs.getString(4);
            pass=PasswordEncryption.getDecryptedPassword(pass);
            customer.setCustomerId(rs.getString(1));
            customer.setCustomerName(rs.getString(2));
            customer.setCustomerEmailId(rs.getString(3));
            customer.setCustomerPass(pass);
            customer.setCustomerMobile(rs.getString(5));
            customer.setCustomerAddress(rs.getString(6));
        }
       return customer;
    }
    
    public static boolean updateCustomerInformation(CustomerPojo customer) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="update customers set customer_name=?, password=?, mobile_no=?,address=? where customer_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(5, customer.getCustomerId());
        ps.setString(1, customer.getCustomerName());
        ps.setString(2,customer.getCustomerPass());
        ps.setString(3, customer.getCustomerMobile());
        ps.setString(4, customer.getCustomerAddress());
        return ps.executeUpdate()==1;
    }
    
}
