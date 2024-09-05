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
public class CompanyPojo {

    public CompanyPojo() {}
    private String comp_id,comp_name,owner_name,pass,emailId,sec_key;

    public CompanyPojo(String comp_id, String comp_name, String owner_name, String pass, String email, String sec_key) {
        this.comp_id = comp_id;
        this.comp_name = comp_name;
        this.owner_name = owner_name;
        this.pass = pass;
        this.emailId = email;
        this.sec_key = sec_key;
    }

    public String getComp_id() {
        return comp_id;
    }

    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String email) {
        this.emailId = email;
    }

    public String getSec_key() {
        return sec_key;
    }

    public void setSec_key(String sec_key) {
        this.sec_key = sec_key;
    }
    
}
