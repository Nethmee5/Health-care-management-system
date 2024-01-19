/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.business;
import java.io.Serializable;
/**
 *
 * @author Shame
 */
public class Admin implements Serializable{
    
    private int adminId;
    private String fname;
    private String lname;
    private String DOB;
    private String NIC;
    private String password;
    private String phone;
    private String email;
    
    //zero argument constructor
    public Admin(){
        this.adminId = 0;
        this.fname = "";
        this.lname = "";
        this.DOB = "";
        this.NIC = "";
        this.password = "";
        this.phone = "";   
        this.email = "";
    }

    public Admin(String fname, String lname, String DOB, String NIC, String password, String phone, String email) {
        
        this.fname = fname;
        this.lname = lname;
        this.DOB = DOB;
        this.NIC = NIC;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int admin_id) {
        this.adminId = admin_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    } 
}
