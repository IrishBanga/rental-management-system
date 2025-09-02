package com.ib.rentalManagementApplication.model;

import java.text.NumberFormat;
import java.util.Date;

public class MaintenanceRecords {
    private String serviceDescription;
    private double serviceCost;
    private Date serviceDate;

    public MaintenanceRecords(String serviceDescription, double serviceCost, Date serviceDate) {
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
        this.serviceDate = serviceDate;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    // Overridden function to display object information in custom format
    @Override
    public String toString() {
        return "Description: " + getServiceDescription()
                + ", Cost: " + (NumberFormat.getCurrencyInstance()).format(getServiceCost())
                + ", Date: " + getServiceDate();
    }
}
