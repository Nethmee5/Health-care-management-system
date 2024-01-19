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
public class Service implements Serializable{
    
    private int serviceId;
    private String serviceName;
    private String brand;
    private String type;
    private String description;
    private Double price;
    private String status;

    public Service() {
        this.serviceId = 0;
        this.serviceName = "";
        this.brand = "";
        this.type = "";
        this.description = "";
        this.price = 0.00;
        this.status = "";
    }
    
    public Service(String serviceName, String brand, String type, String description, Double price) {
        this.serviceName = serviceName;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service(String serviceName, String brand, String type, String description, Double price, String status) {
        this.serviceName = serviceName;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
        this.status = status;
    }
    

}
