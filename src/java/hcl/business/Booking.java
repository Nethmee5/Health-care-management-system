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
public class Booking implements Serializable{

    private int bookid;
    private int serviceid;
    private int cusid;
    private int medicid;
    private String date;
    private String time;
    private String status;
    private String Address;
    private String Contact;
    private double price;

    public Booking() {
        bookid = 0;
        serviceid = 0;
        cusid = 0;
        medicid = 0;
        price = 0.00;
        date = "";
        time = "";
        status = "";
        Address = "";
        Contact = "";
    }

    public Booking(int serviceid, int cusid, int medicid, String date, String time, String Address, String Contact, double price) {
        this.serviceid = serviceid;
        this.cusid = cusid;
        this.medicid = medicid;
        this.date = date;
        this.time = time;
        this.Address = Address;
        this.Contact = Contact;
        this.price = price;
    }

    

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getServiceid() {
        return serviceid;
    }

    public void setServiceid(int serviceid) {
        this.serviceid = serviceid;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public int getMedicid() {
        return medicid;
    }

    public void setMedicid(int medicid) {
        this.medicid = medicid;
    }

    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

}
