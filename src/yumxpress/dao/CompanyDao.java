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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yumxpress.dbutil.DBConnection;
import yumxpress.pojo.CompanyPojo;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author Swadesh Sharma
 */
public class CompanyDao {
    public static String getNewId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(company_id) from companies");
        rs.next();
        String id=rs.getString(1);
        String compId="";
        if(id!=null){
            id=id.substring(4);
            compId="CMP-"+(Integer.parseInt(id)+1);
        }else{
            compId="CMP-101";
        }
        return compId;
    }
//    public static void main(String[] args)throws Exception {
//        String newId=getNewId();
//        System.out.println(newId);
//    }
    
    public static boolean addSeller(CompanyPojo comp) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="insert into companies values(?,?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,getNewId());
        ps.setString(2,comp.getComp_name());
        ps.setString(3,comp.getOwner_name());
        ps.setString(4,comp.getPass());
        ps.setString(5,"Active");
        ps.setString(6,comp.getEmailId());
        ps.setString(7,comp.getSec_key());
        return ps.executeUpdate()==1;
    }
    public static CompanyPojo validate(String userId, String password) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from companies where company_name=? and password=? and status='Active'";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, userId);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        CompanyPojo comp=null;
        if(rs.next()){
            comp=new CompanyPojo();
            comp.setComp_id(rs.getString(1));
            comp.setOwner_name(rs.getString(3));
            comp.setComp_name(rs.getString(2));
        }
       return comp;
    }
    
    public static Map<String, String> getEmailCredentialsByCompanyId(String companyId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select email_id, security_key from companies where company_id=? and status='Active'");
        ps.setString(1, companyId);
        Map<String,String> companyCredentials=new HashMap<>();
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            String emailId=rs.getString(1);
            String secKey=rs.getString(2);
            companyCredentials.put("emailId", emailId);
            companyCredentials.put("secKey",secKey);
        }
        return companyCredentials;
    }
    
    public static Map<String, String> getAllCompanyIdAndName() throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select company_id, company_name from companies where company_id in(select company_id from products) and status='Active'");
        ResultSet rs=ps.executeQuery();
        Map<String,String> compList=new HashMap<>();
        while(rs.next()){
            String c_id=rs.getString(1);
            String c_name=rs.getString(2);
            compList.put(c_name, c_id);
        }
        return compList;
    }
    
}


