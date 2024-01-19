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
public class Customer implements Serializable{
    
    private int cusid;
    private String fname;
    private String lname;
    private String DOB;
    private String email;
    private String NIC;
    private String gender;
    private String password;
    private String phone;
    private String AdLine1;
    private String AdLine2;
    private String city;
    private String District;
    private int postalCode;

    

    public Customer() {
       
        cusid = 0;
        fname = "";
        lname = "";
        DOB = "";
        email = "";
        NIC = "";
        gender = "";
        password = "";
        phone = "";
        AdLine1 = "";
        AdLine2 = "";
        city = "";
        District = "";
        postalCode = 0;
    }
    
    public Customer(String fname, String lname, String DOB, String email, String NIC, String gender, String password, String phone, String AdLine1, String AdLine2, String city, String district, int postalCode) {
        
        this.fname = fname;
        this.lname = lname;
        this.DOB = DOB;
        this.email = email;
        this.NIC = NIC;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.AdLine1 = AdLine1;
        this.AdLine2 = AdLine2;
        this.city = city;
        this.District = district;
        this.postalCode = postalCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAdLine1() {
        return AdLine1;
    }

    public void setAdLine1(String AdLine1) {
        this.AdLine1 = AdLine1;
    }

    public String getAdLine2() {
        return AdLine2;
    }

    public void setAdLine2(String AdLine2) {
        this.AdLine2 = AdLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
